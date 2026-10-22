package s37;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.HashSet;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s37.a f540495a;

    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f540496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f540497b;

        /* JADX INFO: renamed from: s37.c$a$a, reason: collision with other inner class name */
        public class RunnableC7563a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f540498a;

            public final void a() {
                s37.a r100 = this.f540498a.f540497b.f540495a;
                r100.getClass();
                ((NotificationManager) r100.f540480a.getSystemService("notification")).cancel(r100.f540485f, r100.f540486g);     // Catch: Throwable -> L6
            L4:
                s37.a.b(this.f540498a.f540497b.f540495a, true, "");
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC7563a(a r100) {
                this.f540498a = r100;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            x37.b.a("IBannerNotification", "onActivityResumed");
            this.f540496a.unregisterActivityLifecycleCallbacks(this);
            PushThreadHandlerManager.inst().postRunnable(new RunnableC7563a(this));
        }

        public a(c r100, Application r101) {
            this.f540497b = r100;
            this.f540496a = r101;
        }
    }

    public c(s37.a r100) {
        this.f540495a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        x37.b.a("IBannerNotification", "onClick: on click of banner,mTargetIntent is " + this.f540495a.f540481b);
        s37.a r101 = this.f540495a;
        if (r101.f540491l == false) goto L6;
        x37.b.a("IBannerNotification", "onClick: mNeedDismiss is true so banner has been dismiss,not jump");
        return;
    L6:
        r101.c(false, -1);
        v37.a r102 = (v37.a) v37.a.b();
        if (r102.f552944d != null) goto L17;
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (r102.f552944d != null) goto L12;
        r102.f552944d = new com.bytedance.notification.supporter.impl.d();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
    L17:
        com.bytedance.notification.supporter.impl.d r103 = r102.f552944d;
        long r104 = this.f540495a.f540483d.f164103id;
        ((HashSet) r103.f266100a).add(Long.valueOf(r104));
        this.f540495a.f540481b.putExtra("from_banner_notification", true);     // Catch: Exception -> L24
        if (Build.VERSION.SDK_INT < 23) goto L21;
        int r105 = 67108864;
    L22:
        s37.a r106 = this.f540495a;     // Catch: Exception -> L24
        PendingIntent r107 = PendingIntent.getActivity(r106.f540480a, 0, r106.f540481b, r105);     // Catch: Exception -> L24
        s37.a r108 = this.f540495a;     // Catch: Exception -> L24
        r107.send(r108.f540480a, 0, r108.f540481b);     // Catch: Exception -> L24
        Application r109 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication;     // Catch: Exception -> L24
        r109.registerActivityLifecycleCallbacks(new a(this, r109));     // Catch: Exception -> L24
        return;
    L21:
        r105 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L24:
        e = move-exception;
        com.bytedance.push.utils.f.f("IBannerNotification", "error when show jump to target activity ", e);
        s37.a.b(this.f540495a, false, "exception:" + e.getLocalizedMessage());
    }
}
