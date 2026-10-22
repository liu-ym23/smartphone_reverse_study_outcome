package com.bytedance.applet.aibridge.locallife.impl;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.widget.WidgetManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.applet.aibridge.locallife.api.AbsOpenLocalLifeMethodIDL;
import com.bytedance.applet.impl.u0;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.bridge.b;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.TouristManager;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.SdkOauthTokenTriggerScene;
import com.larus.platform.api.w2;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i0;
import com.larus.platform.service.j1;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import hx7.f;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applet/aibridge/locallife/impl/OpenLocalLifeMethod;", "Lcom/bytedance/applet/aibridge/locallife/api/AbsOpenLocalLifeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/locallife/api/AbsOpenLocalLifeMethodIDL$OpenLocalLifeMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/locallife/api/AbsOpenLocalLifeMethodIDL$OpenLocalLifeMethodResultModel;", "defaultOpenLocalLife", "context", "Landroid/content/Context;", "openSchemaCompat", "", "schema", "", "rewriteLifeSchemaIfNeeded", "shouldApplySectionFrequencyControl", "source", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLocalLifeMethod extends AbsOpenLocalLifeMethodIDL {
    public static final Set<String> b = null;

    public static final class a {
    }

    static {
        b = new LinkedHashSet();
    }

    public OpenLocalLifeMethod() {
    }

    public static String d(String r6) {
        Object r3 = null;
        if (StringsKt.startsWith$default(r6, "aweme://", false, 2, null) == true) goto L5;
        return r6;
    L5:
        w2 r1 = (w2) j1.a.getValue();
        if (r1 != null) goto L8;
        return r6;
    L8:
        r1.a();
        String r0 = "sslocal://" + StringsKt.removePrefix(r6, "aweme://");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(UriProtector.parse(r0));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == true) goto L17;
        r3 = r4;
    L17:
        Uri r5 = (Uri) r3;
        if (r5 != null) goto L36;
        return r6;
    L36:
        Object r7 = Result.constructor-impl(Boolean.valueOf(r1.b(r5)));     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L27;
        FLogger.a.w("OpenLocalLifeMethod", "matchSchema threw, fallback to origin. schema=" + r6 + ", e=" + r8);
    L27:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L31;
        r7 = r9;
    L31:
        if (((Boolean) r7).booleanValue() == true) goto L33;
        return r6;
    L33:
        return r0;
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static boolean c(FragmentActivity r4, String r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Map r2 = b.a;     // Catch: Throwable -> L9
        f r3 = (f) b.a(f.class);     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        boolean r6 = r3.openSchema(r5, MapsKt.emptyMap(), r4);     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(Boolean.valueOf(r6));     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L15;
        FLogger.a.w("OpenLocalLifeMethod", "openSchema threw, skip container fallback. schema=" + r5 + ", e=" + r8);
        return false;
    L15:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = r0;
    L18:
        boolean r9 = ((Boolean) r7).booleanValue();
        if (r9 == true) goto L24;
        int r10 = u0.a;
        Uri r11 = UriProtector.parse(r5);
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        return BulletSdk.h(r4, r11, null, 12);
    L24:
        return r9;
    L6:
        r6 = false;
    L9:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static void b(FragmentActivity r3, AbsOpenLocalLifeMethodIDL.a r4, h r5) {
        String r6 = r4.getDefaultSchema();
        if (r6 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        h.a.a(r5, "defaultSchema is null or empty. defaultSchema: " + r6, null, null, 14);
        return;
    L13:
        String r7 = d(r6);
        if (c(r3, r7) == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsOpenLocalLifeMethodIDL.b.class, "<this>");
        r5.b(c.a(AbsOpenLocalLifeMethodIDL.b.class), "");
        return;
    L16:
        h.a.a(r5, "Failed to open schema: " + r7, null, null, 14);
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [ov3.a] */
    public final void handle(d r17, ParamModel r18, final h r19) {
        final AbsOpenLocalLifeMethodIDL.a r10 = (AbsOpenLocalLifeMethodIDL.a) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        TouristManager r1 = TouristManager.a;
        if (r1.f() == false) goto L5;
        ITouristApi.a.a(r1, TriggerLoginScene.TRIGGER_LOGIN_LOCAL_LIFE, false, 2);
        Intrinsics.checkNotNullParameter(AbsOpenLocalLifeMethodIDL.b.class, "<this>");
        r19.b(c.a(AbsOpenLocalLifeMethodIDL.b.class), "");
        return;
    L5:
        FragmentActivity r2 = r17.getOwnerActivity();
        if ((r2 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r12 = r2;
    L9:
        if (r12 != null) goto L11;
        h.a.a(r19, "Failed to get fragment activity", null, null, 14);
        return;
    L11:
        WidgetContainer r0 = (WidgetContainer) r17.d(WidgetContainer.class);
        if (r0 == null) goto L14;
        View r3 = r0.realView();
    L15:
        AppletRuntimeManager.INSTANCE.getClass();
        if (r3 != null) goto L18;
        com.bytedance.ai.widget.contianer.h r4 = null;
    L19:
        if (r4 == null) goto L23;
        m r5 = r4.k();
        if (r5 == null) goto L23;
        String r13 = r5.f;
    L24:
        String r6 = r10.getCurrentPage();
        if (r6 != null) goto L27;
        r6 = "local_life_card";
    L27:
        final String r7 = r6;
        String r8 = r10.getSource();
        if (r8 != null) goto L30;
        final String r9 = "click_local_life_detail";
    L31:
        String r11 = r10.getSource();
        if (r11 != null) goto L34;
    L39:
        boolean r14 = true;
    L40:
        final FragmentActivity r15 = r12;
        final boolean r16 = r14;
        final String r20 = r13;
        ?? r110 = new ov3.a(r10, r15, r7, r9, this, r19, r16, r20);
        ISdkDouyinAuth r21 = i0.a();
        if (r21 == null) goto L46;
        r21.a(false, SdkOauthTokenTriggerScene.Request, new ov3.c(r110, this, r12, r10, r19, r14, r13));
        return;
    L46:
        return;
    L34:
        if (Intrinsics.areEqual(r11, "click_local_life_detail") == true) goto L39;
        if (Intrinsics.areEqual(r11, "click_life_product_card") == true) goto L39;
        r14 = false;
        goto L40
    L30:
        r9 = r8;
    L23:
        r13 = null;
        goto L24
    L18:
        r4 = WidgetManager.h.a(r3);
        goto L19
    L14:
        r3 = null;
        goto L15
    L8:
        r12 = null;
        goto L9
    }
}
