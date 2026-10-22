package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class IEnsureWrapper implements IEnsure {
    private static volatile IEnsureWrapper INSTANCE;
    private IEnsure iEnsure;
    private Executor mExecutor;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IEnsureWrapper f265975a;

        @Override // java.lang.Runnable
        public final void run() {
            IEnsureWrapper.access$000(this.f265975a).ensureNotReachHere();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(IEnsureWrapper r100) {
            this.f265975a = r100;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f265976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IEnsureWrapper f265977b;

        @Override // java.lang.Runnable
        public final void run() {
            IEnsureWrapper.access$000(this.f265977b).ensureNotReachHere(this.f265976a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(IEnsureWrapper r100, String r101) {
            this.f265977b = r100;
            this.f265976a = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f265978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IEnsureWrapper f265979b;

        @Override // java.lang.Runnable
        public final void run() {
            IEnsureWrapper.access$000(this.f265979b).ensureNotReachHere(this.f265978a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(IEnsureWrapper r100, Throwable r101) {
            this.f265979b = r100;
            this.f265978a = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f265980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f265981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IEnsureWrapper f265982c;

        @Override // java.lang.Runnable
        public final void run() {
            IEnsureWrapper.access$000(this.f265982c).ensureNotReachHere(this.f265980a, this.f265981b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(IEnsureWrapper r100, Throwable r101, String r102) {
            this.f265982c = r100;
            this.f265980a = r101;
            this.f265981b = r102;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f265983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f265984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IEnsureWrapper f265985c;

        @Override // java.lang.Runnable
        public final void run() {
            IEnsureWrapper.access$000(this.f265985c).ensureNotReachHere(this.f265983a, this.f265984b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(IEnsureWrapper r100, String r101, Map r102) {
            this.f265985c = r100;
            this.f265983a = r101;
            this.f265984b = r102;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f265986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f265987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f265988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IEnsureWrapper f265989d;

        @Override // java.lang.Runnable
        public final void run() {
            IEnsureWrapper.access$000(this.f265989d).ensureNotReachHere(this.f265986a, this.f265987b, this.f265988c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(IEnsureWrapper r100, Throwable r101, String r102, Map r103) {
            this.f265989d = r100;
            this.f265986a = r101;
            this.f265987b = r102;
            this.f265988c = r103;
        }
    }

    public static IEnsureWrapper getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(IEnsureWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new IEnsureWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(IEnsureWrapper.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere() {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new a(this));
        return;
    }

    private IEnsureWrapper() {
        this.iEnsure = (IEnsure) ServiceManager.getService(IEnsure.class);
        SettingsConfigProvider r100 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r100 == null) goto L8;
        if (r100.getConfig() == null) goto L8;
        this.mExecutor = r100.getConfig().f479840c.f479854c;
    L8:
        if (this.mExecutor != null) goto L11;
        this.mExecutor = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("EnsureWrapper"));
        return;
    }

    public static /* synthetic */ IEnsure access$000(IEnsureWrapper r100) {
        return r100.iEnsure;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r100) {
        IEnsure r101 = this.iEnsure;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.ensureFalse(r100);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotEmpty(Collection r100) {
        IEnsure r101 = this.iEnsure;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.ensureNotEmpty(r100);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r100) {
        IEnsure r101 = this.iEnsure;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.ensureNotNull(r100);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r100) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new b(this, r100));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r100) {
        IEnsure r101 = this.iEnsure;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.ensureTrue(r100);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r100) {
        IEnsure r101 = this.iEnsure;
        if (r101 == null) goto L6;
        r101.reportLogException(r100);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r100) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new c(this, r100));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r100, String r101) {
        IEnsure r102 = this.iEnsure;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.ensureFalse(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r100, String r101) {
        IEnsure r102 = this.iEnsure;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.ensureNotNull(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r100, Map<String, String> r101) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new e(this, r100, r101));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r100, String r101) {
        IEnsure r102 = this.iEnsure;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.ensureTrue(r100, r101);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r100, String r101) {
        IEnsure r102 = this.iEnsure;
        if (r102 == null) goto L6;
        r102.reportLogException(r100, r101);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r100, String r101) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new d(this, r100, r101));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r100, String r101, Map<String, String> r102) {
        IEnsure r103 = this.iEnsure;
        if (r103 != null) goto L5;
        return false;
    L5:
        return r103.ensureFalse(r100, r101, r102);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new f(this, r100, r101, r102));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r100, String r101, Map<String, String> r102) {
        IEnsure r103 = this.iEnsure;
        if (r103 != null) goto L5;
        return false;
    L5:
        return r103.ensureTrue(r100, r101, r102);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(int r100, Throwable r101, String r102) {
        IEnsure r103 = this.iEnsure;
        if (r103 == null) goto L6;
        r103.reportLogException(r100, r101, r102);
        return;
    }
}
