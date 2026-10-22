package com.bytedance.applet.aibridge.permission;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.applet.utils.LocationUtils$resendQuestion$1;
import com.bytedance.applet.utils.i;
import com.bytedance.applet.utils.t;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.l1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import f3.h;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uv3.f;
import uv3.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J0\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J8\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J&\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J&\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0002J\"\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00152\b\b\u0001\u0010!\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J(\u0010\"\u001a\u00020\u00052\b\b\u0001\u0010!\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006%"}, d2 = {"Lcom/bytedance/applet/aibridge/permission/RequestPermissionMethod;", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL$RequestPermissionMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL$RequestPermissionMethodResultModel;", "handleLocationPermission", "forceBackground", "", "doRequestPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "permissionList", "", "", "permissionCallback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "onLocationPermissionResult", "isGranted", "handleCalendarPermission", "handleNotificationPermission", "runRemindAppletRuntime", "onAppletRunSuccess", "Lkotlin/Function0;", "sendResultEvent", "requestId", "permission", "callbackFailure", "errorMsg", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestPermissionMethod extends AbsRequestPermissionMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public static final class b implements Function1<AppletRuntime, Unit> {
        public final /* synthetic */ Function0<Unit> a;

        public b(Function0<Unit> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r1) {
            if (((AppletRuntime) r1) == null) goto L6;
            this.a.invoke();
        L6:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public RequestPermissionMethod() {
    }

    public static void d(Function0 r9) {
        AppletRuntimeManager.o(AppletRuntimeManager.INSTANCE, "com.flow.remind", "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, null, new b(r9), 56);
    }

    public static void c(AbsRequestPermissionMethodIDL.b r2, boolean r3) {
        e(r2.getRequestId(), r2.getPermission(), r3);
        if (r3 == false) goto L11;
        int r4 = i.a;
        Intrinsics.checkNotNullParameter(r2, "params");
        JSONObject r5 = r2.getExtra();
        if (r5 == null) goto L13;
        final String r6 = r5.optString("resendQuestionId", "");
        if (o0.d(r6) == false) goto L12;
        Intrinsics.checkNotNull(r6);
        l1.a.a(LocateScene.MSG_NEED_LOC, new LocationUtils$resendQuestion$1(r6));
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void e(String r2, @PermissionEnum String r3, boolean r4) {
        Lazy r0 = l3.d.a;
        JsonObject r1 = new JsonObject();
        r1.addProperty("requestId", r2);
        r1.addProperty("permission", r3);
        r1.addProperty("isGranted", Boolean.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        l3.d.c(new l3.a("flow.onPermissionRequestResult", r1, 4));
    }

    public final void b(final AbsRequestPermissionMethodIDL.b r13, h r14, final boolean r15) {
        AppHost.Companion r0 = AppHost.a;
        FragmentActivity r1 = r0.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L6:
        final FragmentActivity r5 = r2;
        l1 r3 = l1.a;
        if (r3.c() == true) goto L10;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r16 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r16.setRequestId(r13.getRequestId());
        r14.b(r16, "");
        e(r13.getRequestId(), r13.getPermission(), false);
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r13.getPermission() + " disable location service");
        r3.d(r5);
        return;
    L10:
        if (r15 == false) goto L12;
        int r4 = uv3.c.a;
        boolean r6 = uv3.c.a(r0.getApplication());
    L13:
        if (r6 == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r17 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r17.setRequestId(r13.getRequestId());
        r14.b(r17, "");
        c(r13, true);
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r13.getPermission() + " granted");
        return;
    L16:
        final d r7 = new d(r13, this, r15);
        t0.e(new uv3.d(r15, this, r5, r7, r13));
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r18 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r18.setRequestId(r13.getRequestId());
        r14.b(r18, "");
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r13.getPermission() + " starts");
        return;
    L12:
        int r8 = uv3.c.a;
        r6 = uv3.c.b(r0.getApplication());
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r8v9, types: [uv3.e] */
    public final void handle(e3.d r8, ParamModel r9, h r10) {
        final AbsRequestPermissionMethodIDL.b r11 = (AbsRequestPermissionMethodIDL.b) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r12 = r11.getPermission();
        switch(r12.hashCode()) {
            case -178324674: goto L21;
            case 595233003: goto L14;
            case 954101670: goto L10;
            case 1901043637: goto L6;
            default: goto L27;
        };
    L27:
        String r13 = r11.getPermission();
        String r14 = "unsupported permission: " + r11.getPermission();
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r13 + " fails, errorMsg: " + r14);
        h.a.a(r10, r14, null, null, 14);
        return;
    L6:
        if (r12.equals("location") == false) goto L27;
        b(r11, r10, false);
        return;
    L10:
        if (r12.equals(PermissionEnum.BACKGROUND_LOCATION) == false) goto L27;
        b(r11, r10, true);
        return;
    L14:
        if (r12.equals(PermissionEnum.NOTIFICATION) == false) goto L27;
        if (t.a() == false) goto L19;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r15 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r15.setRequestId(r11.getRequestId());
        r10.b(r15, "");
        e(r11.getRequestId(), r11.getPermission(), true);
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r11.getPermission() + " already granted");
        return;
    L19:
        final e r16 = new e(r11, this);
        t0.e(new uv3.h(r11, r16));
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r17 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r17.setRequestId(r11.getRequestId());
        r10.b(r17, "");
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r11.getPermission() + " starts");
        return;
    L21:
        if (r12.equals(PermissionEnum.CALENDAR) == false) goto L27;
        ?? r18 = new uv3.e();
        if (((Boolean) r18.invoke()).booleanValue() == false) goto L26;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r19 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r19.setRequestId(r11.getRequestId());
        r10.b(r19, "");
        d(new f(this, r11));
        return;
    L26:
        final c r0 = new c(r11, this, r18);
        t0.e(new g(r11, this, r0));
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.c.class, "<this>");
        AbsRequestPermissionMethodIDL.c r20 = k3.c.a(AbsRequestPermissionMethodIDL.c.class);
        r20.setRequestId(r11.getRequestId());
        r10.b(r20, "");
        FLogger.a.i("RequestPermissionMethod", "requestPermission " + r11.getPermission() + " starts");
    }
}
