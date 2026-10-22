package rd7;

import android.app.Activity;
import android.content.ContentResolver;
import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.readCalendarEvent")
public final class u extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f537337d;

    public u() {
        this.f537337d = "[XReadCalendarEventMethod]";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        c.b r113 = (c.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L5;
        id7.c.a("try to obtain context, but got a null.");
        CompletionBlock.DefaultImpls.onFailure$default(r112, CalendarErrorCode.Failed.getValue(), "try to obtain context, but got a null.", null, 4, null);
        return;
    L5:
        int r101 = 0;
        if (r113.getIdentifier().length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "identifier can not be empty.", null, 4, null);
    L11:
        ContentResolver r103 = r100.getContentResolver();
        if (r103 != null) goto L14;
        id7.c.a("try to obtain contentResolver, but got a null");
        CompletionBlock.DefaultImpls.onFailure$default(r112, CalendarErrorCode.Failed.getValue(), "try to obtain contentResolver, but got a null", null, 4, null);
        return;
    L14:
        XBaseRuntime r104 = XBaseRuntime.f270095a;
        r104.getClass();
        if (XBaseRuntime.f270117w == null) goto L27;
        r104.getClass();
        IHostCalendarDepend r105 = XBaseRuntime.f270117w;
        if (r105 == null) goto L19;
        com.bytedance.sdk.xbridge.cn.runtime.depend.b r114 = r105.readEvent(r110, r113.getIdentifier());
    L20:
        HybridLogger r115 = HybridLogger.f246343a;
        HybridLogger.m(this.f537337d, "getCalendarDependInstance()?.readEvent...", null, null, 12);
        if (r114 == null) goto L26;
        XBaseModel r116 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC7467c.class));
        c.InterfaceC7467c r106 = (c.InterfaceC7467c) r116;
        Integer r107 = r114.f270126e;
        if (r107 == null) goto L25;
        r101 = r107.intValue();
    L25:
        r106.setAlarmOffset(Integer.valueOf(r101 * 60000));
        r106.setStartDate(Long.valueOf(r114.f270124c));
        r106.setEndDate(Long.valueOf(r114.f270125d));
        r106.setTitle(r114.f270122a);
        r106.setNotes(r114.f270123b);
        r106.setLocation(r114.f270129h);
        r106.setUrl(r114.f270128g);
        r112.onSuccess((XBaseResultModel) r116, "read success");
        return;
    L26:
        CompletionBlock.DefaultImpls.onFailure$default(r112, CalendarErrorCode.NotFound.getValue(), "read calendar but got a null.", null, 4, null);
        return;
    L19:
        r114 = null;
        goto L20
    L27:
        IHostPermissionDepend r108 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r108 != null) goto L30;
        return;
    L30:
        if (r108.isPermissionAllGranted(r100, new String[]{"android.permission.READ_CALENDAR"}) == false) goto L32;
        Task.callInBackground(new s(r113, r103)).continueWith(new t(r112), Task.UI_THREAD_EXECUTOR);
        return;
    L32:
        Activity r109 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r100);
        if (r109 == null) goto L42;
        r108.requestPermission(r109, r110, this.f537297a, new String[]{"android.permission.READ_CALENDAR"}, new r(this, r113, r112, r103));
        return;
    L42:
        return;
    L8:
        r102 = false;
        goto L9
    }
}
