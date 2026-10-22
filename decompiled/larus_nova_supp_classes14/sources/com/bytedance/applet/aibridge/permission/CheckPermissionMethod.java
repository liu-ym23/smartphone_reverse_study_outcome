package com.bytedance.applet.aibridge.permission;

import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.utils.t;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J(\u0010\u0011\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/applet/aibridge/permission/CheckPermissionMethod;", "Lcom/bytedance/applet/aibridge/permission/AbsCheckPermissionMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/permission/AbsCheckPermissionMethodIDL$CheckPermissionMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/permission/AbsCheckPermissionMethodIDL$CheckPermissionMethodResultModel;", "handleLocationPermission", "handleBackgroundLocationPermission", "handleCalendarPermission", "handleNotificationPermission", "callbackFailure", "permission", "", "errorMsg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPermissionMethod extends AbsCheckPermissionMethodIDL {

    public static final class a {
    }

    static {
    }

    public CheckPermissionMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, h r9) {
        AbsCheckPermissionMethodIDL.a r10 = (AbsCheckPermissionMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        String r11 = r10.getPermission();
        switch(r11.hashCode()) {
            case -178324674: goto L18;
            case 595233003: goto L14;
            case 954101670: goto L10;
            case 1901043637: goto L6;
            default: goto L33;
        };
    L33:
        String r12 = r10.getPermission();
        String r13 = "unsupported permission: " + r10.getPermission();
        FLogger.a.i("CheckPermissionMethod", "checkPermission " + r12 + " fails, errorMsg: " + r13);
        h.a.a(r9, r13, null, null, 14);
        return;
    L6:
        if (r11.equals("location") == false) goto L33;
        int r14 = uv3.c.a;
        boolean r15 = uv3.c.b(AppHost.a.getApplication());
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        AbsCheckPermissionMethodIDL.b r0 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        r0.setGranted(r15);
        r9.b(r0, "");
        FLogger.a.i("CheckPermissionMethod", "checkPermission " + r10.getPermission() + " succeeds, result: " + r15);
        return;
    L10:
        if (r11.equals(PermissionEnum.BACKGROUND_LOCATION) == false) goto L33;
        int r16 = uv3.c.a;
        boolean r17 = uv3.c.a(AppHost.a.getApplication());
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        AbsCheckPermissionMethodIDL.b r1 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        r1.setGranted(r17);
        r9.b(r1, "");
        FLogger.a.i("CheckPermissionMethod", "checkPermission " + r10.getPermission() + " succeeds, result: " + r17);
        return;
    L14:
        if (r11.equals(PermissionEnum.NOTIFICATION) == false) goto L33;
        boolean r18 = t.a();
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        AbsCheckPermissionMethodIDL.b r2 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        r2.setGranted(r18);
        r9.b(r2, "");
        FLogger.a.i("CheckPermissionMethod", "checkPermission " + r10.getPermission() + " succeeds, result: " + r18);
        return;
    L18:
        if (r11.equals(PermissionEnum.CALENDAR) == false) goto L33;
        AppHost.Companion r19 = AppHost.a;
        boolean r3 = false;
        if (ContextCompat.checkSelfPermission(r19.getApplication(), "android.permission.READ_CALENDAR") != 0) goto L23;
        boolean r20 = true;
    L25:
        if (ContextCompat.checkSelfPermission(r19.getApplication(), "android.permission.WRITE_CALENDAR") != 0) goto L27;
        boolean r21 = true;
    L28:
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        AbsCheckPermissionMethodIDL.b r4 = k3.c.a(AbsCheckPermissionMethodIDL.b.class);
        AbsCheckPermissionMethodIDL.b r5 = r4;
        if (r21 == false) goto L32;
        if (r20 == false) goto L32;
        r3 = true;
    L32:
        r5.setGranted(r3);
        r9.b(r4, "");
        return;
    L27:
        r21 = false;
        goto L28
    L23:
        r20 = false;
        goto L25
    }
}
