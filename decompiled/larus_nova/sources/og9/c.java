package og9;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarEventCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PermissionState;
import com.bytedance.timon.calendar.EventRecord;
import com.bytedance.timon.calendar.ResultCode;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements IHostCalendarDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f523220a;

    public static final class a {
    }

    public static final class b implements com.bytedance.timon.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostCalendarEventCallback f523221a;

        public b(IHostCalendarEventCallback r100) {
            this.f523221a = r100;
        }

        @Override // com.bytedance.timon.calendar.a
        public final void a(boolean r100, ResultCode r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "msg");
            this.f523221a.onResult(r100, r101.getValue(), r102);
        }
    }

    /* JADX INFO: renamed from: og9.c$c, reason: collision with other inner class name */
    public static final class C7053c implements com.bytedance.timon.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IHostCalendarEventCallback f523222a;

        public C7053c(IHostCalendarEventCallback r100) {
            this.f523222a = r100;
        }

        @Override // com.bytedance.timon.calendar.a
        public final void a(boolean r100, ResultCode r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "msg");
            this.f523222a.onResult(r100, r101.getValue(), r102);
        }
    }

    public static final class d implements OnPermissionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.timon.calendar.b f523223a;

        public d(com.bytedance.timon.calendar.b r100) {
            this.f523223a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.OnPermissionCallback
        public final void onResult(boolean r100, Map<String, ? extends PermissionState> r101) {
            Intrinsics.checkNotNullParameter(r101, "result");
            if (r100 == false) goto L5;
            this.f523223a.a(new String[]{"android.permission.WRITE_CALENDAR"});
            return;
        L5:
            this.f523223a.onPermissionDenied();
        }
    }

    static {
    }

    public c() {
        Function1<? super com.bytedance.timon.calendar.b, Unit> r100 = com.bytedance.timon.calendar.c.f270568a;
        com.bytedance.timon.calendar.c.b(AppHost.f326268a.getApplication());
        FLogger.f375446a.i("BDXHostCalendarDependImpl", "TimonCalendarManager init...");
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend
    public final com.bytedance.sdk.xbridge.cn.runtime.depend.b readEvent(IBDXBridgeContext r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r211, com.heytap.mcssdk.constant.b.f276361k);
        Activity r100 = r210.getOwnerActivity();
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f523220a == true) goto L8;
        a(r100, r210, "x.deleteCalendarEvent");
    L8:
        EventRecord r101 = com.bytedance.timon.calendar.c.d(r211);
        FLogger.f375446a.i("BDXHostCalendarDependImpl", "TimonCalendarManager readEvent， eventRecord：" + r101);
        if (r101 != null) goto L11;
        return null;
    L11:
        return new com.bytedance.sdk.xbridge.cn.runtime.depend.b(r101.n(), r101.d(), r101.m(), r101.e(), r101.a(), r101.f(), r101.c(), r101.h(), r101.b(), r101.o(), r101.l(), r101.j(), r101.k(), r101.i());
    }

    public final void a(final Context r100, final IBDXBridgeContext r101, final String r102) {
        if (this.f523220a == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("BDXHostCalendarDependImpl", "TimonCalendarManager registerInvoker...");
        Function1<? super com.bytedance.timon.calendar.b, Unit> r103 = com.bytedance.timon.calendar.c.f270568a;
        Function1<? super com.bytedance.timon.calendar.b, Unit> r104 = new og9.b(r101, r100, r102);
        Intrinsics.checkNotNullParameter(r104, "invoker");
        com.bytedance.timon.calendar.c.f270568a = r104;
        this.f523220a = true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend
    public final void deleteEvent(IBDXBridgeContext r100, String r101, IHostCalendarEventCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r103 = r100.getOwnerActivity();
        if (r103 != null) goto L7;
        r102.onResult(false, 0, "context is null.");
        return;
    L7:
        if (this.f523220a == true) goto L9;
        a(r103, r100, "x.deleteCalendarEvent");
    L9:
        FLogger.f375446a.i("BDXHostCalendarDependImpl", "TimonCalendarManager deleteEvent...");
        com.bytedance.timon.calendar.c.a(r103, r101, new b(r102));
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarDepend
    public final void insertOrUpdate(IBDXBridgeContext r100, com.bytedance.sdk.xbridge.cn.runtime.depend.b r101, IHostCalendarEventCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r103 = r100.getOwnerActivity();
        if (r103 != null) goto L7;
        r102.onResult(false, 0, "context is null.");
        return;
    L7:
        if (this.f523220a == true) goto L9;
        a(r103, r100, "x.createCalendarEvent");
    L9:
        FLogger.f375446a.i("BDXHostCalendarDependImpl", "TimonCalendarManager readEvent， insertOrUpdate");
        Function1<? super com.bytedance.timon.calendar.b, Unit> r104 = com.bytedance.timon.calendar.c.f270568a;
        EventRecord r105 = new EventRecord();
        r105.C(r101.f270124c);
        r105.t(r101.f270125d);
        r105.D(r101.f270122a);
        r105.s(r101.f270123b);
        r105.p(r101.f270126e);
        r105.u(r101.f270127f);
        r105.w(r101.f270129h);
        r105.r(r101.f270128g);
        r105.x(r101.f270131j);
        r105.B(r101.f270132k);
        r105.z(r101.f270133l);
        r105.A(r101.f270134m);
        r105.y(r101.f270135n);
        r105.q(r101.f270130i);
        com.bytedance.timon.calendar.c.c(r103, r105, new C7053c(r102));
    }
}
