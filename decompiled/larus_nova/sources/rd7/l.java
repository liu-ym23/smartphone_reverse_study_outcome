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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.createCalendarEvent")
public final class l extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f537318e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f537319d;

    public l() {
        this.f537319d = "[XCreateCalendarEventMethod]";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r310, XBaseParamModel r311, CompletionBlock r312) {
        a.b r100 = (a.b) r311;
        Intrinsics.checkNotNullParameter(r310, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r312, "callback");
        Activity r110 = r310.getOwnerActivity();
        if (r110 != null) goto L5;
        id7.c.a("try to obtain context, but got a null.");
        CompletionBlock.DefaultImpls.onFailure$default(r312, CalendarErrorCode.Failed.getValue(), "try to obtain context, but got a null.", null, 4, null);
        return;
    L5:
        ContentResolver r111 = r110.getContentResolver();
        if (r111 != null) goto L9;
        id7.c.a("try to obtain contentResolver, but got a null");
        CompletionBlock.DefaultImpls.onFailure$default(r312, CalendarErrorCode.Failed.getValue(), "try to obtain contentResolver, but got a null", null, 4, null);
        return;
    L9:
        if (r100.getIdentifier().length() != 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L15;
        CompletionBlock.DefaultImpls.onFailure$default(r312, -3, "identifier can not be empty.", null, 4, null);
    L15:
        if (Intrinsics.areEqual(r100.getRepeatCount(), -1) == false) goto L17;
    L24:
        boolean r210 = false;
    L25:
        XBaseRuntime r102 = XBaseRuntime.f270095a;
        r102.getClass();
        if (XBaseRuntime.f270117w == null) goto L53;
        String r103 = r100.getTitle();
        if (r103 != null) goto L30;
        String r112 = "";
    L31:
        String r104 = r100.getNotes();
        if (r104 != null) goto L34;
        String r113 = "";
    L35:
        long r114 = r100.getStartDate().longValue();
        long r115 = r100.getEndDate().longValue();
        Number r105 = r100.getAlarmOffset();
        if (r105 != null) goto L38;
        r105 = 0;
    L38:
        Integer r211 = Integer.valueOf(r105.intValue() / 60000);
        String r212 = r100.getIdentifier();
        String r106 = r100.getUrl();
        if (r106 != null) goto L41;
        String r213 = "";
    L42:
        String r107 = r100.getLocation();
        if (r107 != null) goto L45;
        String r214 = "";
    L46:
        Boolean r108 = r100.getAllDay();
        if (r108 == null) goto L49;
        boolean r215 = r108.booleanValue();
    L50:
        com.bytedance.sdk.xbridge.cn.runtime.depend.b r109 = new com.bytedance.sdk.xbridge.cn.runtime.depend.b(r112, r113, r114, r115, r211, r212, r213, r214, r215, r210, CollectionsKt.emptyList(), r100.getRepeatFrequency(), Integer.valueOf(r100.getRepeatInterval().intValue()), Integer.valueOf(r100.getRepeatCount().intValue()));
        i r116 = new i(r312);
        HybridLogger r117 = HybridLogger.f246343a;
        HybridLogger.m(this.f537319d, "getCalendarDependInstance()?.insertOrUpdate...", null, null, 12);
        r102.getClass();
        IHostCalendarDepend r118 = XBaseRuntime.f270117w;
        if (r118 == null) goto L64;
        r118.insertOrUpdate(r310, r109, r116);
        return;
    L64:
        return;
    L49:
        r215 = false;
        goto L50
    L45:
        r214 = r107;
        goto L46
    L41:
        r213 = r106;
        goto L42
    L34:
        r113 = r104;
        goto L35
    L30:
        r112 = r103;
        goto L31
    L53:
        String[] r119 = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        IHostPermissionDepend r120 = com.bytedance.sdk.xbridge.cn.utils.g.f(r310);
        if (r120 != null) goto L56;
        return;
    L56:
        if (r120.isPermissionAllGranted(r110, (String[]) Arrays.copyOf(r119, 2)) == false) goto L58;
        Task.callInBackground(new f(this, r100, r111)).continueWith(new g(r312, r100, this, r111), Task.UI_THREAD_EXECUTOR);
        return;
    L58:
        Activity r121 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r110);
        if (r121 == null) goto L68;
        r120.requestPermission(r121, r310, this.f537291a, (String[]) Arrays.copyOf(r119, 2), new h(this, r100, r312, r111));
        return;
    L68:
        return;
    L17:
        if (Intrinsics.areEqual(r100.getRepeatInterval(), -1) == true) goto L24;
        if (r100.getRepeatFrequency().length() <= 0) goto L21;
        boolean r122 = true;
    L22:
        if (r122 == false) goto L24;
        r210 = true;
        goto L25
    L21:
        r122 = false;
        goto L22
    L11:
        r101 = false;
        goto L12
    }
}
