package uqa;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.message.util.ToolUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqa.c;
import mqa.g;
import mqa.h;
import mqa.i;
import nqa.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f551344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C7918a f551345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f551346c;

    /* JADX INFO: renamed from: uqa.a$a, reason: collision with other inner class name */
    public class C7918a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f551347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f551348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f551349c;

        /* JADX INFO: renamed from: uqa.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes34.dex */
        public class RunnableC7919a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f551350a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C7918a f551351b;

            @Override // java.lang.Runnable
            public final void run() {
                nqa.a.a(this.f551351b.f551347a).c(this.f551350a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }

            public RunnableC7919a(C7918a r100, b r101) {
                this.f551351b = r100;
                this.f551350a = r101;
            }
        }

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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
        }

        public C7918a(a r100, Application r101) {
            this.f551349c = r100;
            this.f551347a = r101;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            boolean r102 = true;
            Field r103 = Activity.class.getDeclaredField("mReferrer");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
            r103.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
            String r104 = (String) r103.get(r100);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        L11:
            if (Build.VERSION.SDK_INT < 22) goto L18;
            if (a.a(r104, r100) == true) goto L18;
            Uri r105 = r100.getReferrer();
            if (r105 == null) goto L18;
            r104 = r105.getHost();
        L18:
            if (a.a(r104, r100) == true) goto L21;
            r104 = r100.getCallingPackage();
        L21:
            if (a.a(r104, r100) == true) goto L27;
            r104 = r100.getPackageManager().getNameForUid(Binder.getCallingUid());     // Catch: Exception -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L27:
            if (Logger.debug() == false) goto L29;
            Logger.d("ActivityAliveTracker", "startActivity = " + r100.getComponentName().getClassName() + ", referrer = " + r104);
        L29:
            boolean r106 = false;
            if (this.f551348b != null) goto L32;
            boolean r107 = false;
        L36:
            List<String> r108 = vqa.a.f556785a;
            String r109 = r100.getComponentName().getClassName();
            Iterator r110 = ((ArrayList) vqa.a.f556785a).iterator();
        L38:
            if (r110.hasNext() == false) goto L44;
            String r111 = (String) r110.next();
            if (StringUtils.equal(r109, r111) == true) goto L43;
            if (r109.contains(r111) == false) goto L38;
        L43:
            boolean r112 = true;
        L45:
            if (r112 == false) goto L79;
            return;
        L79:
        L54:
            e = move-exception;
            e.printStackTrace();
        L56:
            if (r107 == false) goto L59;
            this.f551347a.unregisterActivityLifecycleCallbacks(this);
            return;
        L59:
            if (r106 == false) goto L75;
            i r113 = new i();
            r113.f514936a = ToolUtils.currentTimeMillis();
            r113.f514941f = r100.getIntent();
            r113.f514942g = r104;
            r113.f514937b = ToolUtils.getCurProcessName(r100);
            r113.f514943h = vqa.a.a(r100);
            r113.f514940e = 4;
            Application r114 = this.f551347a;
            if (g.f514930c != null) goto L73;
            monitor-enter(g.class);
        L69:
            th = move-exception;
            throw th;
        L65:
            if (g.f514930c != null) goto L67;
            g.f514930c = new g(r114);     // Catch: Throwable -> L69
        L67:
            monitor-exit(g.class);     // Catch: Throwable -> L69
        L73:
            if (g.f514930c.a().f514933a == false) goto L75;
            b r115 = new b();
            r115.f520152b = r113.a().toString();
            r115.f520153c = -1;
            ThreadPlus.submitRunnable(new RunnableC7919a(this, r115));
        L75:
            this.f551347a.unregisterActivityLifecycleCallbacks(this);
            return;
        L48:
            if (this.f551349c.f551346c.exists() == true) goto L52;
            if (this.f551349c.f551346c.createNewFile() == false) goto L52;
        L53:
            r106 = r102;
        L52:
            r102 = false;
            goto L53
        L44:
            r112 = false;
            goto L45
        L32:
            if (a.a(r104, r100) == false) goto L34;
            c r116 = ((mqa.a) this.f551348b).f514903a;
            i r117 = r116.f514913g;
            r117.f514942g = r104;
            ThreadPlus.submitRunnable(new mqa.b(r116, r117.a().toString()));
        L34:
            this.f551348b = null;
            r107 = true;
        L5:
            e = move-exception;
            e.printStackTrace();
        L9:
            r104 = null;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }
    }

    public a(Application r100, boolean r101) {
        this.f551344a = r100;
        this.f551346c = new PolarisFileWrapper(r100.getFilesDir(), "process_activity.lock");
    }

    public static boolean a(String r100, Activity r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r100, r101.getPackageName()) == true) goto L7;
        return true;
    }
}
