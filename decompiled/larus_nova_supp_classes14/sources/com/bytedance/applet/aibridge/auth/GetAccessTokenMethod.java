package com.bytedance.applet.aibridge.auth;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.g5;
import com.larus.platform.service.i0;
import d3.a0;
import f3.h;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/GetAccessTokenMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL$GetAccessTokenParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/auth/AbsGetAccessTokenMethodIDL$GetAccessTokenResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAccessTokenMethod extends AbsGetAccessTokenMethodIDL {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AbsGetAccessTokenMethodIDL.LoginPlatform.values().length];
            r0[AbsGetAccessTokenMethodIDL.LoginPlatform.DOUYIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public GetAccessTokenMethod() {
    }

    public final void handle(e3.d r6, ParamModel r7, h r8) {
        AbsGetAccessTokenMethodIDL.a r9 = (AbsGetAccessTokenMethodIDL.a) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        a0 r10 = r6.getContainerContext();
        if (r10 == null) goto L45;
        String r11 = r10.getAppletId();
        if (r11 == null) goto L45;
        boolean r3 = false;
        if (r11.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L13;
        r11 = null;
    L13:
        if (r11 == null) goto L45;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r12 = AppletAppManagerService.a(r11);
        if (r12 == null) goto L25;
        Applet r13 = r12.j();
        if (r13 == null) goto L25;
        if (((AIPackage) r13).G != 1) goto L22;
        boolean r14 = true;
    L23:
        if (r14 != true) goto L25;
        boolean r15 = true;
    L26:
        if (r15 == true) goto L29;
        h.a.a(r8, "permission denied", null, null, 14);
        return;
    L29:
        if (a.a[r9.getLoginPlatform().ordinal()] != 1) goto L44;
        ISdkDouyinAuth r16 = i0.a();
        if (r16 == null) goto L35;
        g5 r17 = r16.b();
        if (r17 == null) goto L35;
        String r18 = r17.a;
    L36:
        if (r18 != null) goto L38;
    L39:
        r3 = true;
    L40:
        if (r3 == false) goto L42;
        h.a.a(r8, "accessToken is empty", null, null, 14);
        return;
    L42:
        Intrinsics.checkNotNullParameter(AbsGetAccessTokenMethodIDL.b.class, "<this>");
        AbsGetAccessTokenMethodIDL.b r19 = k3.c.a(AbsGetAccessTokenMethodIDL.b.class);
        r19.setAccessToken(r18);
        r8.b(r19, "");
        return;
    L38:
        if (r18.length() != 0) goto L40;
    L35:
        r18 = null;
        goto L36
    L44:
        throw new NoWhenBranchMatchedException();
    L22:
        r14 = false;
    L25:
        r15 = false;
        goto L26
    L9:
        r2 = false;
    L45:
        h.a.a(r8, "appId is null", null, null, 14);
    }
}
