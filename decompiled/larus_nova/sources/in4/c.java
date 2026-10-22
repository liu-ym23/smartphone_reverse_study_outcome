package in4;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements com.bytedance.ee.bear.contract.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f490586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f490587b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f490588c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData<Boolean> f490589d = null;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediatorLiveData<Boolean> f490590a;

        public a(MediatorLiveData<Boolean> r100) {
            this.f490590a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            this.f490590a.postValue(Boolean.valueOf(r101));
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediatorLiveData<Boolean> f490591a;

        public b(MediatorLiveData<Boolean> r100) {
            this.f490591a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            boolean r101 = ((Boolean) r100).booleanValue();
            this.f490591a.postValue(Boolean.valueOf(r101));
        }
    }

    /* JADX INFO: renamed from: in4.c$c, reason: collision with other inner class name */
    public static final class RunnableC6292c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediatorLiveData<Boolean> f490592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f490593b;

        /* JADX INFO: renamed from: in4.c$c$a */
        public static final class a<T> implements Observer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f490594a;

            public a(c r100) {
                this.f490594a = r100;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object r100) {
                Boolean r101 = (Boolean) r100;
                MutableLiveData<Boolean> r102 = c.f490588c;
                if (this.f490594a.a() == true) goto L5;
            L7:
                boolean r103 = false;
            L8:
                r102.postValue(Boolean.valueOf(r103));
                return;
            L5:
                if (this.f490594a.f() == true) goto L7;
                r103 = true;
                goto L8
            }
        }

        public RunnableC6292c(MediatorLiveData<Boolean> r100, c r101) {
            this.f490592a = r100;
            this.f490593b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f490592a.observeForever(new a(this.f490593b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements y {
        public d() {
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(y.a r100, y.a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            boolean r102 = r101.f408860c;
            if (r102 != r100.f408860c) goto L5;
            return;
        L5:
            c.f490586a.postValue(Boolean.valueOf(r102));
        }
    }

    public static final class e {
    }

    static {
        f490586a = new MutableLiveData();
        f490587b = new MutableLiveData(Boolean.FALSE);
        f490588c = new MutableLiveData();
        f490589d = new MutableLiveData();
        AppLifecycle.a.f408803a.c(new d());
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final boolean a() {
        StringBuilder r100 = new StringBuilder("appIsVisible()... isAppFront = ");
        MutableLiveData<Boolean> r101 = f490586a;
        r100.append(r101.getValue());
        tt5.a.h("SdkVisibleServiceImpl", r100.toString());
        if (r101.getValue() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final boolean f() {
        if (f490587b.getValue() != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public c() {
        eu5.a.b(LarkContext.getApplication());
        MediatorLiveData r100 = new MediatorLiveData();
        r100.addSource(f490586a, new a(r100));
        r100.addSource(f490587b, new b(r100));
        m.a(new RunnableC6292c(r100, this));
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final long g() {
        if (f() != true) goto L5;
        return 0;
    L5:
        return 300000;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData h() {
        return eu5.a.a().f474074b;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData b() {
        return f490589d;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData c() {
        return f490586a;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData d() {
        return f490587b;
    }

    @Override // com.bytedance.ee.bear.contract.f
    public final MutableLiveData e() {
        return f490588c;
    }
}
