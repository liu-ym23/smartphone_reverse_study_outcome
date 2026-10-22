package qf5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.middleground.drive.rustsdk.DriveStateMonitorImpl;
import com.bytedance.ee.bear.middleground.drive.rustsdk.init.DriveRustSdkWrapper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final C0295a c = null;
    public static volatile a d;
    public final AtomicInteger a;
    public qf5.b b;

    /* JADX INFO: renamed from: qf5.a$a, reason: collision with other inner class name */
    public static final class C0295a {
        public C0295a() {
        }

        public final a a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            a r3 = a.d;
            if (r3 != null) goto L13;
            monitor-enter(this);
            r3 = a.d;     // Catch: Throwable -> L10
            if (r3 != null) goto L8;
            r3 = new a();     // Catch: Throwable -> L10
            a.d = r3;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r3;
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ AccountService.Account b;

        public b(String r1, AccountService.Account r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r7) {
            String r5 = (String) r7;
            Intrinsics.checkNotNullParameter(r5, "deviceId");
            if (TextUtils.isEmpty(r5) == true) goto L6;
            String r1 = this.a;
            AccountService.Account r8 = this.b;
            final DriveRustSdkWrapper.a r9 = new DriveRustSdkWrapper.a(r1, r8.token, r8.uid, r8.tenantId, r5);
            return Flowable.create(new com.bytedance.ee.bear.middleground.drive.rustsdk.init.c(r9), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b());
        L6:
            return Flowable.error(new Throwable("init drive device id is empty"));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AccountService.Account a;
        public final /* synthetic */ a b;
        public final /* synthetic */ Runnable c;

        public c(AccountService.Account r1, a r2, Runnable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            tt5.a.h("Middleground_Drive_DriveSDK", "async init drive end initResult = " + r4 + ", uid=" + this.a.uid);
            if (r4.booleanValue() == false) goto L5;
            this.b.a.set(2);
            DriveStateMonitorImpl.a().b();
        L6:
            Runnable r5 = this.c;
            if (r5 == null) goto L10;
            r5.run();
            return;
        L10:
            return;
        L5:
            this.b.a.set(0);
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            a r0 = this.a;
            tt5.a.k("Middleground_Drive_DriveSDK", "async init drive throwable = " + ((Throwable) r4));
            r0.a.set(0);
        }
    }

    static {
        c = new C0295a();
    }

    public a() {
        this.a = new AtomicInteger(0);
    }

    public final void a(Runnable r4, String r5, AccountService.Account r6) {
        tt5.a.h("Middleground_Drive_DriveSDK", "async init drive start, uid=" + r6.uid);
        this.a.set(1);
        Flowable r7 = ((b0) org.koin.java.a.c(b0.class, null, null, 6)).n().toFlowable().flatMap(new b(r5, r6));
        if (r7 == null) goto L8;
        Flowable r8 = r7.observeOn(fo5.d.d());
        if (r8 == null) goto L9;
        r8.subscribe(new c(r6, this, r4), new d(this));
        return;
    L9:
        return;
    }
}
