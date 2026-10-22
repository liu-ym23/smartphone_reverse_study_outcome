package com.ss.android.download.api.common;

import android.app.Application;
import android.content.Context;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/download/api/common/DefaultAppStatusChecker;", "", "()V", "foregroundActivityCount", "", "mIsAppBackground", "", "sInit", "init", "application", "Landroid/app/Application;", "isAppBackground", "download-api_release"}, k = 1, mv = {1, 1, 16})
public final class DefaultAppStatusChecker {
    public static final DefaultAppStatusChecker INSTANCE = null;
    private static int foregroundActivityCount;
    private static volatile boolean mIsAppBackground;
    private static volatile boolean sInit;

    private DefaultAppStatusChecker() {
    }

    static {
        INSTANCE = new DefaultAppStatusChecker();
        mIsAppBackground = true;
    }

    public final boolean isAppBackground() {
        if ((GlobalInfo.getContext() instanceof Application) == false) goto L10;
        Context r100 = GlobalInfo.getContext();
        if (r100 == null) goto L8;
        init((Application) r100);
        goto L10
    L8:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
    L10:
        return mIsAppBackground;
    }

    public static final /* synthetic */ int access$getForegroundActivityCount$p(DefaultAppStatusChecker r100) {
        return foregroundActivityCount;
    }

    public static final /* synthetic */ boolean access$getMIsAppBackground$p(DefaultAppStatusChecker r100) {
        return mIsAppBackground;
    }

    public final synchronized boolean init(Application r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (sInit == true) goto L7;
        if (r100 == null) goto L7;
        r100.registerActivityLifecycleCallbacks(new AnonymousClass1());     // Catch: Throwable -> L10
        sInit = true;     // Catch: Throwable -> L10
    L7:
        boolean r101 = sInit;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    }

    public static final /* synthetic */ void access$setForegroundActivityCount$p(DefaultAppStatusChecker r100, int r101) {
        foregroundActivityCount = r101;
    }

    public static final /* synthetic */ void access$setMIsAppBackground$p(DefaultAppStatusChecker r100, boolean r101) {
        mIsAppBackground = r101;
    }
}
