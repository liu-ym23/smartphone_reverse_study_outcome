package com.obric.assistant;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/ObricActivityServiceImpl;", "Lcom/obric/assistant/IObricActivityService;", "<init>", "()V", "isActivityReCreated", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "", "initLock", "", "initialized", "init", "", "isReCreatedActivity", "activity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActivityServiceImpl implements IObricActivityService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHashMap<Activity, Boolean> f385134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f385135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f385136c;

    public static final class a {
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricActivityServiceImpl f385137a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        public b(ObricActivityServiceImpl r100) {
            this.f385137a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            FLogger.f375446a.i("ObricActivityServiceImpl", "onActivityDestroyed: " + r100);
            this.f385137a.f385134a.remove(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if (r101 == null) goto L5;
            boolean r102 = true;
        L6:
            FLogger.f375446a.i("ObricActivityServiceImpl", "onActivityCreated: " + r100 + ", isReCreated = " + r102);
            this.f385137a.f385134a.put(r100, Boolean.valueOf(r102));
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    static {
    }

    @Override // com.obric.assistant.IObricActivityService
    public final void init() {
        if (this.f385136c == false) goto L5;
        return;
    L5:
        Object r100 = this.f385135b;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.f385136c == false) goto L11;
        monitor-exit(r100);
        return;
    L11:
        AppHost.f326268a.getApplication().registerActivityLifecycleCallbacks(new b(this));     // Catch: Throwable -> L14
        this.f385136c = true;     // Catch: Throwable -> L14
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
    }

    public ObricActivityServiceImpl() {
        this.f385134a = new WeakHashMap();
        this.f385135b = new Object();
    }

    @Override // com.obric.assistant.IObricActivityService
    public final boolean a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return Intrinsics.areEqual(this.f385134a.get(r100), Boolean.TRUE);
    }
}
