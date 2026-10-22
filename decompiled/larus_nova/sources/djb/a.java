package djb;

import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements xwa.b, bxa.a.InterfaceC0374a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAppStateSyncService f468977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<xwa.b.a> f468978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bxa.a f468979c;

    /* JADX INFO: renamed from: djb.a$a, reason: collision with other inner class name */
    public static final class C5679a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f468980a;

        public C5679a(a r100) {
            this.f468980a = r100;
        }

        @Override // com.ss.android.lark.appcontext.applifecycle.y
        public final void f(y.a r100, y.a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldState");
            Intrinsics.checkNotNullParameter(r101, "newState");
            a r102 = this.f468980a;
            bxa.a r103 = r102.f468979c;
            if (r103 == null) goto L5;
            r103.I1(r102);
        L5:
            bxa.a r104 = (bxa.a) OfficeSDKManager.getHostGlobalService(bxa.a.class);
            r102.f468979c = r104;
            if (r104 == null) goto L9;
            r104.h0(r102);
        L9:
            if (r102.f468979c == null) goto L11;
            boolean r105 = true;
        L12:
            if (r105 == false) goto L15;
            com.ss.android.lark.appcontext.applifecycle2.api.a.d(this);
            Log.i("OfficeBatteryMonitor", "registerDozeModeCallback success");
            return;
        L15:
            return;
        L11:
            r105 = false;
            goto L12
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // xwa.b
    public final boolean a() {
        bxa.a r100 = this.f468979c;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.l1() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Inject
    public a(IAppStateSyncService r100) {
        Intrinsics.checkNotNullParameter(r100, "appStateSyncService");
        this.f468977a = r100;
        this.f468978b = new CopyOnWriteArraySet();
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(new C5679a(this));
    }

    @Override // bxa.a.InterfaceC0374a
    public final void onStateChanged(boolean r100) {
        Log.i("OfficeBatteryMonitor", "onStateChanged, isDozeMode=" + r100);
        this.f468977a.c(r100);
        Iterator<xwa.b.a> r101 = this.f468978b.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        xwa.b.a r102 = r101.next();
        if (r100 == true) goto L7;
        r102.a();
        goto L4
    L7:
        r102.b();
        goto L4
    }
}
