package com.bytedance.applet.aibridge.health;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import android.util.Base64;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import e3.d;
import f2.k;
import f3.h;
import java.util.List;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import nv3.s;
import nv3.t;
import nv3.v;
import nv3.w;
import nv3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/health/SyncHuaweiDataMethod;", "Lcom/bytedance/applet/aibridge/health/AbsSyncHuaweiDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/health/AbsSyncHuaweiDataMethodIDL$SyncHuaweiDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/health/AbsSyncHuaweiDataMethodIDL$SyncHuaweiDataResultModel;", "fail", "error", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "message", "", "Companion", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncHuaweiDataMethod extends AbsSyncHuaweiDataMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public SyncHuaweiDataMethod() {
    }

    public final void b(h<AbsSyncHuaweiDataMethodIDL.b> r4, final f3.a r5, final String r6) {
        FLogger.a.h("AISDK_JSB_SyncHuaweiDataMethod", new x(r5, r6));
        h.a.a(r4, r6, r5, null, 10);
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, nv3.v] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, nv3.w] */
    public final void handle(d r28, ParamModel r29, final h r30) {
        AbsSyncHuaweiDataMethodIDL.a r2 = (AbsSyncHuaweiDataMethodIDL.a) r29;
        Intrinsics.checkNotNullParameter(r28, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r30, "callback");
        if (StringsKt.isBlank(r2.getAppId()) == false) goto L5;
    L77:
        b(r30, f3.a.h, "Invalid Huawei health sync parameters");
        return;
    L5:
        if (StringsKt.isBlank(r2.getSecretKey()) == true) goto L77;
        if (StringsKt.isBlank(r2.getScheme()) == true) goto L77;
        Activity r3 = r28.getOwnerActivity();
        if (r3 != null) goto L12;
        r3 = k.b();
    L12:
        if (r3 != null) goto L14;
    L76:
        b(r30, f3.a.f, "Current activity is unavailable");
        return;
    L14:
        if (r3.isFinishing() == true) goto L76;
        if (r3.isDestroyed() == true) goto L76;
        b r4 = b.a;
        t r5 = new t(r3.getTaskId());
        String r6 = r2.getAppId();
        String r7 = r2.getSecretKey();
        String r8 = r2.getScheme();
        ?? r9 = new v(r30);
        ?? r10 = new w(this, r30);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "appId");
        Intrinsics.checkNotNullParameter(r7, "secretKey");
        Intrinsics.checkNotNullParameter(r8, "callbackUri");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Intrinsics.checkNotNullParameter(r10, "onFailure");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        Object r1 = Result.constructor-impl(r3.getPackageManager().getPackageInfo("com.huawei.health", 128).versionName);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r1) == false) goto L26;
        r1 = null;
    L26:
        String r15 = (String) r1;
        int r14 = 0;
        if (r15 != null) goto L29;
    L32:
        boolean r16 = true;
    L33:
        if (r16 == true) goto L51;
        List r11 = StringsKt.split$default(r15, new char[]{'.'}, false, 0, 6, null);
        List r12 = StringsKt.split$default("13.1.3.300", new char[]{'.'}, false, 0, 6, null);
        int r13 = Math.max(r11.size(), r12.size());
        int r17 = 0;
    L36:
        if (r17 >= r13) goto L53;
        String r18 = (String) CollectionsKt.getOrNull(r11, r17);
        if (r18 == null) goto L42;
        Integer r19 = StringsKt.toIntOrNull(r18);
        if (r19 == null) goto L42;
        r14 = r19.intValue();
    L42:
        String r110 = (String) CollectionsKt.getOrNull(r12, r17);
        if (r110 == null) goto L47;
        Integer r111 = StringsKt.toIntOrNull(r110);
        if (r111 == null) goto L47;
        int r20 = r111.intValue();
    L48:
        if (r14 != r20) goto L49;
        r17 = r17 + 1;
        r12 = r12;
        r14 = 0;
        goto L36
    L49:
        if (r14 <= r20) goto L51;
    L47:
        r20 = 0;
    L53:
        boolean r112 = true;
    L54:
        if (r112 == true) goto L79;
        r10.invoke(f3.a.g, "Huawei Health 13.1.3.300 or later is required");
    L87:
        return;
    L79:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L59
        byte[] r22 = Base64.decode(r7, 0);     // Catch: Throwable -> L59
        Mac r113 = Mac.getInstance("HmacSHA256");     // Catch: Throwable -> L59
        r113.init(new SecretKeySpec(r22, "HmacSHA256"));     // Catch: Throwable -> L59
        Object r23 = Result.constructor-impl(Base64.encodeToString(r113.doFinal((r6 + '_' + r7).getBytes(Charsets.UTF_8)), 2));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r23) == false) goto L64;
        Object r114 = null;
    L65:
        String r115 = (String) r114;
        if (r115 != null) goto L68;
        r10.invoke(f3.a.f, "Failed to create Huawei health signature");
        goto L87
    L68:
        String r24 = UUID.randomUUID().toString();
        Intent r25 = new Intent("android.intent.action.VIEW", UriProtector.parse("huaweischeme://healthapp/router/sync").buildUpon().appendQueryParameter("appId", r6).appendQueryParameter("redirectUrl", r8).appendQueryParameter("signature", r115).build());
        Handler r26 = s.a;
        Intrinsics.checkNotNullParameter(r24, "operationId");
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Intrinsics.checkNotNullParameter(r10, "onFailure");
        if (s.b(new s.c(r24, r5, r9, r10)) == true) goto L83;
        r10.invoke(f3.a.r, "Huawei health operation is already in progress");
        goto L87
    L83:
        r3.startActivity(r25);     // Catch: RuntimeException -> L73 ActivityNotFoundException -> L74
    L74:
        Handler r27 = s.a;
        s.a(r24, f3.a.g, "Huawei Health is unavailable");
    L73:
        Handler r31 = s.a;
        s.a(r24, f3.a.f, "Failed to open Huawei Health");
        goto L87
    L64:
        r114 = r23;
    L59:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L51:
        r112 = false;
        goto L54
    L29:
        if (StringsKt.isBlank(r15) == true) goto L32;
        r16 = false;
    L21:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
