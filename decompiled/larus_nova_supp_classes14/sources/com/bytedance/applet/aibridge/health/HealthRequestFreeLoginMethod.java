package com.bytedance.applet.aibridge.health;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import com.huawei.hms.hihealthlite.HuaweiHiHealthLite;
import com.huawei.hms.hihealthlite.LoginFreeAuthController;
import com.larus.utils.logger.FLogger;
import f2.k;
import f3.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nv3.c;
import nv3.d;
import nv3.e;
import nv3.f;
import nv3.g;
import nv3.l;
import nv3.m;
import nv3.s;
import nv3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/health/HealthRequestFreeLoginMethod;", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL$HealthRequestFreeLoginParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL$HealthRequestFreeLoginResultModel;", "fail", "error", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "message", "", "Companion", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HealthRequestFreeLoginMethod extends AbsHealthRequestFreeLoginMethodIDL {
    public static final Set<String> b = null;

    public static final class a {
    }

    static {
        b = SetsKt.setOf(new String[]{"huawei", "honor"});
    }

    public HealthRequestFreeLoginMethod() {
    }

    public final void b(h<AbsHealthRequestFreeLoginMethodIDL.b> r4, final f3.a r5, final String r6) {
        FLogger.a.h("AISDK_JSB_HealthRequestFreeLoginMethod", new d(r5, r6));
        h.a.a(r4, r6, r5, null, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [nv3.e] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Runnable, nv3.h] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object, nv3.b] */
    /* JADX WARN: Type inference failed for: r2v5, types: [nv3.f] */
    /* JADX WARN: Type inference failed for: r2v6, types: [nv3.g] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, nv3.c] */
    public final void handle(e3.d r26, ParamModel r27, final h r28) {
        AbsHealthRequestFreeLoginMethodIDL.a r2 = (AbsHealthRequestFreeLoginMethodIDL.a) r27;
        Intrinsics.checkNotNullParameter(r26, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r28, "callback");
        if (b.contains(r2.getHealthDeviceType()) == true) goto L5;
    L139:
        b(r28, f3.a.h, "Invalid health authorization parameters");
        return;
    L5:
        if (r2.getScopes().isEmpty() == true) goto L139;
        List<String> r3 = r2.getScopes();
        boolean r6 = true;
        if ((r3 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        if (StringsKt.isBlank((String) r4.next()) == false) goto L13;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L139;
        if (StringsKt.isBlank(r2.getState()) == true) goto L139;
        if (StringsKt.isBlank(r2.getAppId()) == true) goto L139;
        Activity r7 = r26.getOwnerActivity();
        if (r7 != null) goto L27;
        r7 = k.b();
    L27:
        if (r7 != null) goto L29;
    L138:
        b(r28, f3.a.f, "Current activity is unavailable");
        return;
    L29:
        if (r7.isFinishing() == true) goto L138;
        if (r7.isDestroyed() == true) goto L138;
        final ?? r12 = new nv3.b(r28);
        ?? r8 = new c(this, r28);
        String r9 = r2.getHealthDeviceType();
        Object r16 = null;
        if (Intrinsics.areEqual(r9, "huawei") == false) goto L85;
        String r10 = r2.getScheme();
        String r11 = r2.getSecretKey();
        if (r10 != null) goto L38;
    L41:
        boolean r17 = true;
    L42:
        if (r17 == true) goto L84;
        if (r11 != null) goto L45;
    L48:
        if (r6 == true) goto L84;
        if (Build.VERSION.SDK_INT >= 23) goto L54;
        b(r28, f3.a.g, "Huawei Health requires Android 6.0 or later");
    L156:
        return;
    L54:
        int r13 = m.a;
        Intrinsics.checkNotNullParameter(r10, "value");
        if (m.a(UriProtector.parse(r10), "/healthKitHuawei") == true) goto L58;
        b(r28, f3.a.h, "Invalid Huawei health callback URI");
        goto L156
    L58:
        if ((r7 instanceof FragmentActivity) == false) goto L60;
        FragmentActivity r14 = (FragmentActivity) r7;
    L61:
        if (r14 != null) goto L63;
        b(r28, f3.a.g, "Huawei health requires a FragmentActivity");
        goto L156
    L63:
        b r0 = b.a;
        t r15 = new t(r7.getTaskId());
        List r18 = CollectionsKt.toList(r2.getScopes());
        String r1 = r2.getState();
        String r19 = r2.getAppId();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r14, "activity");
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter(r18, "scopes");
        Intrinsics.checkNotNullParameter(r1, "state");
        Intrinsics.checkNotNullParameter(r19, "appId");
        Intrinsics.checkNotNullParameter(r10, "callbackUri");
        Intrinsics.checkNotNullParameter(r11, "secretKey");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r8, "onFailure");
        final String r110 = UUID.randomUUID().toString();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L70
        LoginFreeAuthController r111 = HuaweiHiHealthLite.getLoginFreeAuthController(r14.getApplicationContext());     // Catch: Throwable -> L70
        if (r111 == null) goto L67;
        Intent r21 = r111.requestLoginFreeAuthorizationIntent((String[]) r18.toArray(new String[0]), r110, r19, r10, r11);     // Catch: Throwable -> L70
    L68:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L70
    L73:
        if (Result.isFailure-impl(r22) == true) goto L76;
        r16 = r22;
    L76:
        Intent r23 = (Intent) r16;
        if (r23 != null) goto L80;
        r8.invoke(f3.a.g, "Huawei health authorization is unavailable");
    L157:
        return;
    L80:
        Handler r24 = s.a;
        Intrinsics.checkNotNullParameter(r110, "operationId");
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter(r1, "originalState");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r8, "onFailure");
        if (s.b(new s.a(r110, r15, r1, r12, r8)) == true) goto L83;
        r8.invoke(f3.a.r, "Huawei health operation is already in progress");
        goto L157
    L83:
        HealthAuthFragment.a r25 = HealthAuthFragment.i;
        Function2 r29 = new nv3.k(r110);
        Function0 r30 = new l(r110);
        r25.getClass();
        HealthAuthFragment.a.a(r14, r23, r29, r30);
        goto L157
    L67:
        r21 = null;
    L70:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L60:
        r14 = null;
        goto L61
    L45:
        if (StringsKt.isBlank(r11) == true) goto L48;
        r6 = false;
    L84:
        b(r28, f3.a.h, "Invalid Huawei health authorization parameters");
        return;
    L38:
        if (StringsKt.isBlank(r10) == true) goto L41;
        r17 = false;
        goto L42
    L85:
        boolean r32 = false;
        if (Intrinsics.areEqual(r9, "honor") == true) goto L88;
        return;
    L88:
        if ((r7 instanceof FragmentActivity) == false) goto L90;
        final FragmentActivity r33 = (FragmentActivity) r7;
    L91:
        if (r33 != null) goto L93;
        b(r28, f3.a.g, "Honor health requires a FragmentActivity");
        return;
    L93:
        com.bytedance.applet.aibridge.health.a r34 = com.bytedance.applet.aibridge.health.a.a;
        List r35 = CollectionsKt.toList(r2.getScopes());
        final String r36 = r2.getState();
        String r37 = r2.getAppId();
        r34.getClass();
        Intrinsics.checkNotNullParameter(r33, "activity");
        Intrinsics.checkNotNullParameter(r35, "scopes");
        Intrinsics.checkNotNullParameter(r36, "state");
        Intrinsics.checkNotNullParameter(r37, "appId");
        Intrinsics.checkNotNullParameter(r12, "onSuccess");
        Intrinsics.checkNotNullParameter(r8, "onFailure");
        final String r38 = UUID.randomUUID().toString();
        final com.bytedance.applet.aibridge.health.a.C0050a r39 = new com.bytedance.applet.aibridge.health.a.C0050a(r38, new e(r12, r36), r8);
        com.bytedance.applet.aibridge.health.a.C0050a r40 = com.bytedance.applet.aibridge.health.a.c;
        if (r40 != null) goto L96;
        com.bytedance.applet.aibridge.health.a.C0050a r41 = null;
    L100:
        com.bytedance.applet.aibridge.health.a.c = r39;
        ?? r112 = new nv3.h(r39);
        com.bytedance.applet.aibridge.health.a.d = r112;
        com.bytedance.applet.aibridge.health.a.b.postDelayed(r112, 300000);
        if (r41 == null) goto L105;
        Function2<f3.a, String, Unit> r42 = r41.c;
        if (r42 == null) goto L105;
        r42.invoke(f3.a.o, "Previous Honor health authorization was replaced by a new request");
    L105:
        boolean r43 = true;
    L106:
        if (r43 == true) goto L143;
        r8.invoke(f3.a.r, "Honor health operation is already in progress");
        return;
    L143:
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L128
        SignInOptions r45 = SignInOptions.j;     // Catch: Throwable -> L128
        HashSet r46 = new HashSet();     // Catch: Throwable -> L128
        HashSet r47 = new HashSet();     // Catch: Throwable -> L128
        r46.addAll(((AbstractSignInOptions) r45).a);     // Catch: Throwable -> L128
        r47.addAll(((AbstractSignInOptions) r45).b);     // Catch: Throwable -> L128
        List r48 = r35;     // Catch: Throwable -> L128
        ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, 10));     // Catch: Throwable -> L128
        Iterator r50 = r48.iterator();     // Catch: Throwable -> L128
    L110:
        if (r50.hasNext() == false) goto L113;
        r49.add(new Scope((String) r50.next()));     // Catch: Throwable -> L128
        goto L110
    L113:
        if (r49.size() != 0) goto L117;
        r32 = true;
    L117:
        if ((!r32) == false) goto L126;
        Iterator r51 = r49.iterator();     // Catch: Throwable -> L128
    L120:
        if (r51.hasNext() == false) goto L126;
        Scope r52 = (Scope) r51.next();     // Catch: Throwable -> L128
        if (r52 == null) goto L120;
        if (r52.a == null) goto L120;
        r46.add(r52);     // Catch: Throwable -> L128
    L126:
        Object r53 = Result.constructor-impl(new iw7.b(r33, new SignInOptions(r46, r47, r37, "", "", true, true)));     // Catch: Throwable -> L128
    L131:
        if (Result.isFailure-impl(r53) == true) goto L134;
        r16 = r53;
    L134:
        final iw7.a r54 = (iw7.a) r16;
        if (r54 != null) goto L137;
        com.bytedance.applet.aibridge.health.a.b(r38, f3.a.g, "Honor health sign-in is unavailable");
        return;
    L137:
        lw7.d r55 = r54.silentSignIn();
        r55.f(new f(r38));
        r55.e(new g(r38, r54, r33));
        return;
    L128:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L131
    L96:
        if ((SystemClock.elapsedRealtime() - r40.d) >= 1000) goto L98;
        r43 = false;
        goto L106
    L98:
        r41 = com.bytedance.applet.aibridge.health.a.c(r40.a);
        goto L100
    L90:
        r33 = null;
    L17:
        r5 = false;
        goto L18
    L9:
        if (r3.isEmpty() == false) goto L11;
        goto L11
    }
}
