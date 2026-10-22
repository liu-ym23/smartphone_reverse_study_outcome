package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.IEnsure;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class IEnsureWrapper implements IEnsure {
    private static volatile IEnsureWrapper INSTANCE;
    private IEnsure iEnsure;
    private Executor mExecutor;

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
        SettingsConfigProvider r0 = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.mExecutor = r0.getConfig().c.c;
    L8:
        if (this.mExecutor != null) goto L11;
        this.mExecutor = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("EnsureWrapper"));
        return;
    }

    public static /* synthetic */ IEnsure access$000(IEnsureWrapper r0) {
        return r0.iEnsure;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureFalse(r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotEmpty(Collection r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureNotEmpty(r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureNotNull(r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r3) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new b(this, r3));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureTrue(r2);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r2) {
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L6;
        r0.reportLogException(r2);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r3) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new c(this, r3));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r2, String r3) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureFalse(r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureNotNull(Object r2, String r3) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureNotNull(r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(String r3, Map<String, String> r4) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new e(this, r3, r4));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r2, String r3) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureTrue(r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(Throwable r2, String r3) {
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L6;
        r0.reportLogException(r2, r3);
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r3, String r4) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new d(this, r3, r4));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureFalse(boolean r2, String r3, Map<String, String> r4) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureFalse(r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void ensureNotReachHere(Throwable r3, String r4, Map<String, String> r5) {
        if (this.iEnsure == null) goto L6;
        this.mExecutor.execute(new f(this, r3, r4, r5));
        return;
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public boolean ensureTrue(boolean r2, String r3, Map<String, String> r4) {
        IEnsure r0 = this.iEnsure;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.ensureTrue(r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IEnsure
    public void reportLogException(int r2, Throwable r3, String r4) {
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L6;
        r0.reportLogException(r2, r3, r4);
        return;
    }
}
