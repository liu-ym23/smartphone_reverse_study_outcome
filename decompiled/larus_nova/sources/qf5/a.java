package qf5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.middleground.drive.rustsdk.DriveStateMonitorImpl;
import com.bytedance.ee.bear.middleground.drive.rustsdk.init.DriveRustSdkWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7322a f532733c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f532734d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f532735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qf5.b f532736b;

    /* JADX INFO: renamed from: qf5.a$a, reason: collision with other inner class name */
    public static final class C7322a {
        public C7322a() {
        }

        public final a a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            a r101 = a.f532734d;
            if (r101 != null) goto L13;
            monitor-enter(this);
            r101 = a.f532734d;     // Catch: Throwable -> L10
            if (r101 != null) goto L8;
            r101 = new a();     // Catch: Throwable -> L10
            a.f532734d = r101;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r101;
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f532737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccountService$Account f532738b;

        public b(String r100, AccountService$Account r101) {
            this.f532737a = r100;
            this.f532738b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            String r101 = (String) r100;
            Intrinsics.checkNotNullParameter(r101, "deviceId");
            if (TextUtils.isEmpty(r101) == true) goto L6;
            String r102 = this.f532737a;
            AccountService$Account r103 = this.f532738b;
            final DriveRustSdkWrapper.a r104 = new DriveRustSdkWrapper.a(r102, r103.token, r103.uid, r103.tenantId, r101);
            return Flowable.create(new com.bytedance.ee.bear.middleground.drive.rustsdk.init.c(r104), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b());
        L6:
            return Flowable.error(new Throwable("init drive device id is empty"));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountService$Account f532739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f532740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f532741c;

        public c(AccountService$Account r100, a r101, Runnable r102) {
            this.f532739a = r100;
            this.f532740b = r101;
            this.f532741c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            tt5.a.h("Middleground_Drive_DriveSDK", "async init drive end initResult = " + r101 + ", uid=" + this.f532739a.uid);
            if (r101.booleanValue() == false) goto L5;
            this.f532740b.f532735a.set(2);
            DriveStateMonitorImpl.a().b();
        L6:
            Runnable r102 = this.f532741c;
            if (r102 == null) goto L10;
            r102.run();
            return;
        L10:
            return;
        L5:
            this.f532740b.f532735a.set(0);
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f532742a;

        public d(a r100) {
            this.f532742a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            a r101 = this.f532742a;
            tt5.a.k("Middleground_Drive_DriveSDK", "async init drive throwable = " + ((Throwable) r100));
            r101.f532735a.set(0);
        }
    }

    static {
        f532733c = new C7322a();
    }

    public a() {
        this.f532735a = new AtomicInteger(0);
    }

    public final void a(Runnable r100, String r101, AccountService$Account r102) {
        tt5.a.h("Middleground_Drive_DriveSDK", "async init drive start, uid=" + r102.uid);
        this.f532735a.set(1);
        Flowable<R> r103 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).n().toFlowable().flatMap(new b(r101, r102));
        if (r103 == 0) goto L8;
        Flowable r104 = r103.observeOn(fo5.d.d());
        if (r104 == null) goto L9;
        r104.subscribe(new c(r102, this, r100), new d(this));
        return;
    L9:
        return;
    }
}
