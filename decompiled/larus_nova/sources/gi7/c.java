package gi7;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import ci7.p;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mi7.h;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f481459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<Activity> f481460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f481461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f481462d;

    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f481463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f481464b;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        public a(c r100) {
            this.f481464b = r100;
            this.f481463a = 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            if (r100 == null) goto L5;
            this.f481464b.f481460b.remove(r100);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            View r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.getClass().getCanonicalName();
        L7:
            if (TextUtils.isEmpty(r102) == true) goto L23;
            ZlinkDependAbility r103 = p.f23879a;
            if (r103 != null) goto L11;
            List<String> r104 = null;
        L13:
            if (mi7.a.a(r104) == true) goto L23;
            if (r100 == null) goto L23;
            Iterator<String> r105 = r104.iterator();
        L17:
            if (r105.hasNext() == false) goto L23;
            String r106 = r105.next();
            if (r102.equalsIgnoreCase(r106) == false) goto L17;
            mi7.e.a("AppFrontBackHelper", "the forbidden activity is " + r106 + " result the counter invalid where onActivityStarted");
            return;
        L11:
            r104 = r103.getForbiddenActivityList();
        L23:
            if (TextUtils.isEmpty(r102) == false) goto L25;
            mi7.e.a("AppFrontBackHelper", "the activity is null which results the counter valid where onActivityStarted");
        L26:
            int r107 = this.f481463a + 1;
            this.f481463a = r107;
            if (r107 != 1) goto L60;
        L53:
            th = move-exception;
            th.printStackTrace();
            return;
        L29:
            if (Build.VERSION.SDK_INT >= 29) goto L31;
            c.a(this.f481464b, r100);     // Catch: Throwable -> L53
            return;
        L31:
            if (r100 == null) goto L33;
            Window r108 = r100.getWindow();     // Catch: Throwable -> L53
        L34:
            if (r108 == null) goto L40;
            r101 = r108.getDecorView();     // Catch: Throwable -> L53
            if (com.larus.home.impl.utils.c.f346345e == false) goto L40;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L53
            Thread r109 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L53
            if (r109 == com.larus.home.impl.utils.c.f346341a) goto L40;
            com.larus.home.impl.utils.c.a(r109, "getDecorView");     // Catch: Throwable -> L53
        L40:
            if (r101 == null) goto L42;
            r101.post(new gi7.a(this, r100));     // Catch: Throwable -> L53
            return;
        L42:
            Handler r110 = h.c();     // Catch: Throwable -> L53
            if (r110 != null) goto L46;
            return;
        L46:
            if (p.a() == null) goto L50;
            long r111 = p.a().delayMillis();     // Catch: Throwable -> L53
            if (r111 <= 0) goto L50;
        L51:
            r110.postDelayed(new gi7.b(this, r100), r111);     // Catch: Throwable -> L53
            return;
        L50:
            r111 = 500;
            goto L51
        L33:
            r108 = null;
            goto L34
        L60:
            return;
        L25:
            mi7.e.a("AppFrontBackHelper", "the activity is " + r102 + " which results the counter valid where onActivityStarted");
            goto L26
        L5:
            r102 = null;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            List<String> r101 = null;
            if (r100 == null) goto L5;
            String r102 = r100.getClass().getCanonicalName();
        L7:
            if (TextUtils.isEmpty(r102) == true) goto L23;
            ZlinkDependAbility r103 = p.f23879a;
            if (r103 == null) goto L13;
            r101 = r103.getForbiddenActivityList();
        L13:
            if (mi7.a.a(r101) == true) goto L23;
            if (r100 == null) goto L23;
            Iterator<String> r104 = r101.iterator();
        L17:
            if (r104.hasNext() == false) goto L23;
            String r105 = r104.next();
            if (r102.equalsIgnoreCase(r105) == false) goto L17;
            mi7.e.a("AppFrontBackHelper", "the forbidden activity is " + r105 + " result the counter invalid where onActivityStopped");
            return;
        L23:
            if (TextUtils.isEmpty(r102) == false) goto L25;
            mi7.e.a("AppFrontBackHelper", "the activity is null which results the counter valid where onActivityStopped");
        L26:
            int r106 = this.f481463a - 1;
            this.f481463a = r106;
            if (r106 != 0) goto L44;
            c r107 = this.f481464b;
            Iterator<d> r108 = r107.f481461c.iterator();
        L30:
            if (r108.hasNext() == false) goto L34;
            d r109 = r108.next();
            if (r109 == null) goto L30;
            r109.onBack();
            goto L30
        L34:
            r107.f481459a = false;
            return;
        L44:
            return;
        L25:
            mi7.e.a("AppFrontBackHelper", "the activity is " + r102 + " which results the counter valid where onActivityStopped");
            goto L26
        L5:
            r102 = null;
            goto L7
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            this.f481464b.f481460b.remove(r100);
            this.f481464b.f481460b.add(r100);
            mi7.e.a("AppFrontBackHelper", "onActivityCreated " + r100);
            if (mi7.b.a(r100) == false) goto L12;
            long r102 = System.currentTimeMillis() / 1000;
            mi7.g.a(r100).getClass();
            if (mi7.g.f514094a == null) goto L12;
            if (TextUtils.isEmpty("first_launch_timestamp") == true) goto L12;
            SharedPreferences.Editor r103 = mi7.g.f514094a.edit();
            r103.putLong("first_launch_timestamp", r102);
            r103.apply();
        L12:
            if (mi7.b.b(r100.getClass().getCanonicalName()) == false) goto L15;
            ji7.f.b.f499223a.b(r100, r100.getIntent());
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f481465a = null;

        static {
            f481465a = new c();
        }
    }

    public final Activity b() {
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (this.f481460b.isEmpty() == true) goto L14;
        return this.f481460b.getLast();
    L14:
        return null;
    }

    public c() {
        this.f481461c = new CopyOnWriteArrayList();
        this.f481462d = new a(this);
        this.f481460b = new LinkedList();
    }

    public static void a(c r100, Activity r101) {
        Iterator<d> r102 = r100.f481461c.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        d r103 = r102.next();
        if (r103 == null) goto L4;
        r103.onFront(r101);
        goto L4
    L8:
        r100.f481459a = true;
    }
}
