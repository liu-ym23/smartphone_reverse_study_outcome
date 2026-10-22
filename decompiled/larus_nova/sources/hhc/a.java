package hhc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f485255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f485256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f485257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f485258d;

    /* JADX INFO: renamed from: hhc.a$a, reason: collision with other inner class name */
    public class C6147a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f485259a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        public C6147a(a r100) {
            this.f485259a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            this.f485259a.getClass();
            Objects.toString(r100);
            a r101 = this.f485259a;
            int r102 = r101.f485255a + 1;
            r101.f485255a = r102;
            if (r102 == 1) goto L5;
        L11:
            this.f485259a.getClass();
            Objects.toString(r100);
            return;
        L5:
            if (r101.f485256b == true) goto L7;
        L10:
            this.f485259a.f485256b = false;
            goto L11
        L7:
            if (r101.f485258d == 2) goto L10;
            r101.f485258d = 2;
            BDNetworkTagManager.getInstance().updateLaunchType(2);
            goto L10
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            this.f485259a.getClass();
            Objects.toString(r100);
            a r101 = this.f485259a;
            int r102 = r101.f485255a - 1;
            r101.f485255a = r102;
            if (r102 != 0) goto L5;
            r101.f485256b = true;
        L5:
            Objects.toString(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            if (r101 == null) goto L5;
            int r102 = 1;
        L6:
            Objects.toString(r100);
            a r103 = this.f485259a;
            if (r103.f485257c == false) goto L13;
            r103.f485257c = false;
            if (r103.f485258d == r102) goto L14;
            r103.f485258d = r102;
            BDNetworkTagManager.getInstance().updateLaunchType(r102);
            return;
        L14:
            return;
        L13:
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    @Override // hhc.b
    public final int a() {
        return this.f485258d;
    }

    public a(Application r100) {
        this.f485255a = 0;
        this.f485256b = false;
        this.f485257c = true;
        this.f485258d = -999;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.registerActivityLifecycleCallbacks(new C6147a(this));
    }
}
