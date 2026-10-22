package com.ss.android.ugc.quota;

import android.app.Application;
import android.util.Pair;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import jm9.d;

/* JADX INFO: loaded from: classes5.dex */
public class BDNetworkTagManager {
    private static final Pair<String, String> DEFAULT_TAG = null;
    public static final String KEY_BD_NETWORK_REQUEST_TAG = "x-tt-request-tag";
    private static final String TAG = "BDNetworkTagManager";
    private static volatile BDNetworkTagManager sInstance;
    private ghc.b<Application> contextLazy;
    private ghc.b<ghc.a> dependLazy;
    private AtomicBoolean enable;
    private boolean firstInstallLaunch;
    private ghc.b<hhc.b> launchMonitorLazy;
    private int launchType;

    public class a extends ghc.b<Application> {
        @Override // ghc.b
        public final Application b() {
            IBDNetworkTagConfig r100 = (IBDNetworkTagConfig) ServiceManager.get().getService(IBDNetworkTagConfig.class);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getApplication();
        }

        public a() {
        }
    }

    public class b extends ghc.b<ghc.a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BDNetworkTagManager f454375d;

        @Override // ghc.b
        public final ghc.a b() {
            IBDNetworkTagConfig r100 = (IBDNetworkTagConfig) ServiceManager.get().getService(IBDNetworkTagConfig.class);
            if (r100 == null) goto L5;
            ghc.a r101 = r100.a();
        L6:
            if (r101 == null) goto L8;
            AtomicBoolean r102 = BDNetworkTagManager.access$000(this.f454375d);
            r101.enable();
            r102.set(true);
            BDNetworkTagManager.access$102(this.f454375d, r101.b());
        L8:
            return r101;
        L5:
            r101 = null;
            goto L6
        }

        public b(BDNetworkTagManager r100) {
            this.f454375d = r100;
        }
    }

    public class c extends ghc.b<hhc.b> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BDNetworkTagManager f454376d;

        public final hhc.b c() {
            if (BDNetworkTagManager.access$200(this.f454376d).a() == null) goto L7;
            ((ghc.a) BDNetworkTagManager.access$200(this.f454376d).a()).c();
            return d.f499704a;
        L7:
            return new hhc.a((Application) BDNetworkTagManager.access$300(this.f454376d).a());
        }

        @Override // ghc.b
        public final /* bridge */ /* synthetic */ hhc.b b() {
            return c();
        }

        public c(BDNetworkTagManager r100) {
            this.f454376d = r100;
        }
    }

    static {
        DEFAULT_TAG = new Pair(KEY_BD_NETWORK_REQUEST_TAG, "");
    }

    private boolean enabled() {
        if (this.dependLazy.a() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.enable.get() == false) goto L7;
        return true;
    }

    public static BDNetworkTagManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BDNetworkTagManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BDNetworkTagManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDNetworkTagManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private BDNetworkTagManager() {
        this.contextLazy = new a();
        this.dependLazy = new b(this);
        this.launchMonitorLazy = new c(this);
        this.enable = new AtomicBoolean(false);
        this.launchType = -999;
    }

    public int currentLaunchType() {
        if (enabled() == true) goto L7;
        return -999;
    L7:
        return this.launchType;
    }

    public boolean isFirstInstallLaunch() {
        if (enabled() == true) goto L7;
        return false;
    L7:
        return this.firstInstallLaunch;
    }

    public static /* synthetic */ AtomicBoolean access$000(BDNetworkTagManager r100) {
        return r100.enable;
    }

    public static /* synthetic */ ghc.b access$200(BDNetworkTagManager r100) {
        return r100.dependLazy;
    }

    public static /* synthetic */ ghc.b access$300(BDNetworkTagManager r100) {
        return r100.contextLazy;
    }

    public Pair<String, String> buildBDNetworkTag(IBDNetworkTagContextProvider r100) {
        if (enabled() == false) goto L5;
        if (r100 == null) goto L8;
        int r101 = this.launchMonitorLazy.a().a();
        if (this.launchType == r101) goto L13;
        updateLaunchType(r101);
    L13:
        return new Pair(KEY_BD_NETWORK_REQUEST_TAG, "t=" + r100.triggerType() + ";n=" + (r100.markAsNewUser() ? 1 : 0));
    L8:
        return DEFAULT_TAG;
    L5:
        return DEFAULT_TAG;
    }

    public void enable(boolean r100) {
        this.enable.set(r100);
    }

    public void updateLaunchType(int r100) {
        if (enabled() == true) goto L5;
        return;
    L5:
        this.launchType = r100;
        if (this.dependLazy.a() == null) goto L9;
        this.dependLazy.a().a();
        return;
    }

    public static /* synthetic */ boolean access$102(BDNetworkTagManager r100, boolean r101) {
        r100.firstInstallLaunch = r101;
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, jm9.d] */
    public void init(Application r100, ghc.a r101) {
        if (this.dependLazy.f481326a == false) goto L5;
        return;
    L5:
        if (r100 == 0) goto L10;
        if (r101 == 0) goto L10;
        ghc.b<Application> r102 = this.contextLazy;
        r102.f481328c = r100;
        r102.f481326a = true;
        AtomicBoolean r103 = this.enable;
        r101.enable();
        r103.set(true);
        r101.c();
        ?? r104 = d.f499704a;
        ghc.b<hhc.b> r105 = this.launchMonitorLazy;
        r105.f481328c = r104;
        r105.f481326a = true;
        this.firstInstallLaunch = r101.b();
        ghc.b<ghc.a> r106 = this.dependLazy;
        r106.f481328c = r101;
        r106.f481326a = true;
        return;
    L10:
        throw new IllegalArgumentException("Context or depend is NULL");
    }
}
