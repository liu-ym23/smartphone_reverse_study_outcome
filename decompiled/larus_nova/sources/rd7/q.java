package rd7;

import android.app.Activity;
import android.content.ContentResolver;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.deleteCalendarEvent")
public final class q extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f537329d;

    public q() {
        this.f537329d = "[XDeleteCalendarEventMethod]";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b.InterfaceC7466b r113 = (b.InterfaceC7466b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L5;
        id7.c.a("try to obtain context, but got a null.");
        CompletionBlock.DefaultImpls.onFailure$default(r112, CalendarErrorCode.Failed.getValue(), "try to obtain context, but got a null.", null, 4, null);
        return;
    L5:
        ContentResolver r101 = r100.getContentResolver();
        if (r101 != null) goto L9;
        id7.c.a("try to obtain contentResolver, but got a null");
        CompletionBlock.DefaultImpls.onFailure$default(r112, CalendarErrorCode.Failed.getValue(), "try to obtain contentResolver, but got a null", null, 4, null);
        return;
    L9:
        if (r113.getIdentifier().length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "identifier can not be empty.", null, 4, null);
    L14:
        XBaseRuntime r103 = XBaseRuntime.f270095a;
        r103.getClass();
        if (XBaseRuntime.f270117w == null) goto L19;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.m(this.f537329d, "getCalendarDependInstance()?.deleteEvent...", null, null, 12);
        r103.getClass();
        IHostCalendarDepend r105 = XBaseRuntime.f270117w;
        if (r105 == null) goto L30;
        r105.deleteEvent(r110, r113.getIdentifier(), new o(r112));
        return;
    L30:
        return;
    L19:
        String[] r106 = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        IHostPermissionDepend r107 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r107 != null) goto L22;
        return;
    L22:
        if (r107.isPermissionAllGranted(r100, (String[]) Arrays.copyOf(r106, 2)) == false) goto L24;
        Task.callInBackground(new m(r113, r101)).continueWith(new n(r112, r113), Task.UI_THREAD_EXECUTOR);
        return;
    L24:
        Activity r108 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r100);
        if (r108 == null) goto L34;
        r107.requestPermission(r108, r110, this.f537294a, (String[]) Arrays.copyOf(r106, 2), new p(this, r113, r112, r101));
        return;
    L34:
        return;
    L11:
        r102 = false;
        goto L12
    }
}
