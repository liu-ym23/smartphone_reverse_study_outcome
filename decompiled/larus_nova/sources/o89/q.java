package o89;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.impl.applet.PageState;
import com.larus.nova.R;
import com.larus.settings.value.b1;
import com.larus.settings.value.e10;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f522409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PageState f522410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<? extends Activity> f522411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f522412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f522413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f522414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f522415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f522416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f522417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<String> f522418j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f522419k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<Activity, String> f522420l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f522421m = null;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            AtomicBoolean r101 = q.f522409a;
            if (q.f(r100) == false) goto L5;
            return;
        L5:
            String r102 = q.f522420l.remove(r100);
            if (r102 != null) goto L9;
            FLogger.f375446a.i("ECAppletStackManager", "onDestroy page not found, page_id=" + q.f522415g + ", size=" + ((ArrayList) q.f522418j).size());
            return;
        L9:
            Set<String> r103 = q.f522419k;
            if (r103.remove(r102) == false) goto L14;
            FLogger.f375446a.i("ECAppletStackManager", "onDestroy is pending recreate page, page_id=" + q.f522415g + ", size=" + ((ArrayList) q.f522418j).size());
            return;
        L14:
            if (q.f522414f == false) goto L17;
            return;
        L17:
            if (r100.isFinishing() == true) goto L19;
        L23:
            FLogger r104 = FLogger.f375446a;
            StringBuilder r105 = new StringBuilder("onDestroy, page_id=");
            r105.append(q.f522415g);
            r105.append(", size=");
            ArrayList r106 = (ArrayList) q.f522418j;
            r105.append(r106.size());
            r104.i("ECAppletStackManager", r105.toString());
            if (r106.isEmpty() == false) goto L27;
            c.a(r100);
            q.i();
            return;
        L27:
            return;
        L19:
            if (r100.isChangingConfigurations() == true) goto L23;
            r103.remove(r102);
            List<String> r107 = q.f522418j;
            ((ArrayList) r107).remove(r102);
            if (Intrinsics.areEqual(q.f522416h, r102) == false) goto L23;
            q.f522416h = (String) CollectionsKt.lastOrNull(r107);
            goto L23
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            AtomicBoolean r101 = q.f522409a;
            if (q.f(r100) == false) goto L6;
            return;
        L6:
            if (q.a(r100) == false) goto L23;
            int r102 = c.f522394a;
            if (r100 == null) goto L23;
            if (q.f(r100) == true) goto L23;
            if (b.c() == false) goto L23;
            int r103 = x89.a.f562932a;
            if (Build.VERSION.SDK_INT < 30) goto L19;
            r100.setTranslucent(false);     // Catch: Throwable -> L21
        L30:
            goto L23
        L19:
            Method r104 = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L21
            r104.setAccessible(true);     // Catch: Throwable -> L21
            r104.invoke(r100, new Object[0]);     // Catch: Throwable -> L21
        L23:
            if (q.a(r100) == true) goto L25;
            return;
        L25:
            if (r100.isFinishing() == false) goto L34;
            c.a(r100);
            if (q.f522414f == true) goto L35;
            r.f522422a.getClass();
            JSONObject r105 = new JSONObject();
            r105.putOpt("exit_method", "other");
            Unit r106 = Unit.INSTANCE;
            r.a("exit_doubao_apps", r105);
            return;
        L35:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            AtomicBoolean r101 = q.f522409a;
            if (q.f(r100) == false) goto L5;
            return;
        L5:
            String r102 = (String) ((LinkedHashMap) q.f522420l).get(r100);
            if (r102 == null) goto L9;
            q.f522416h = r102;
            q.f522419k.remove(r102);
            q.b(r102);
        L9:
            if (q.f522410b == PageState.CREATED) goto L11;
            return;
        L11:
            if (q.f522411c != null) goto L13;
        L15:
            boolean r103 = false;
        L16:
            if (r103 == false) goto L20;
            FLogger.f375446a.i("ECAppletStackManager", "origin resumed, reset applet stack, stack=" + q.f522418j);
            q.i();
            return;
        L20:
            return;
        L13:
            if (Intrinsics.areEqual(r100.getClass(), q.f522411c) == false) goto L15;
            r103 = true;
            goto L16
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r110, Bundle r111) {
            Intrinsics.checkNotNullParameter(r110, "activity");
            AtomicBoolean r100 = q.f522409a;
            if (q.f(r110) == false) goto L6;
            return;
        L6:
            if (r111 == null) goto L12;
            String r112 = r111.getString("ec_applet_page_id");
            if (r112 == null) goto L12;
            if (((ArrayList) q.f522418j).contains(r112) == false) goto L12;
        L14:
            if (r112 == null) goto L16;
        L26:
            if (r112 != null) goto L28;
            StringBuilder r113 = new StringBuilder("ec_applet_page_");
            int r101 = q.f522415g + 1;
            q.f522415g = r101;
            r113.append(r101);
            r113.append('_');
            r113.append(System.currentTimeMillis());
            r112 = r113.toString();
            ((ArrayList) q.f522418j).add(r112);
        L28:
            FLogger.f375446a.i("ECAppletStackManager", "onCreate, page_id=" + q.f522415g + ", size=" + ((ArrayList) q.f522418j).size());
            q.f522416h = r112;
            q.f522420l.put(r110, r112);
            q.f522419k.remove(r112);
            q.b(r112);
            if (q.f522417i != null) goto L76;
            q.f522417i = r112;
            q.f522410b = PageState.CREATED;
            int r114 = c.f522394a;
            if (r110 != null) goto L34;
        L39:
            if (r110 != null) goto L42;
        L68:
            AtomicBoolean r115 = q.f522409a;
            q.h(IVKService.ResponseConstants.CREATED);
            return;
        L42:
            if (q.f(r110) == true) goto L68;
            if (b.c() == false) goto L68;
            int r116 = x89.a.f562932a;
            Intrinsics.checkNotNullParameter(r110, "activity");
            if (Build.VERSION.SDK_INT < 30) goto L71;
            r110.setTranslucent(true);
        L67:
            r110.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            goto L68
        L71:
            Method r117 = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);     // Catch: Throwable -> L70
            if (r117 == null) goto L52;
            r117.setAccessible(true);     // Catch: Throwable -> L70
        L52:
            if (r117 == null) goto L54;
            Object r118 = r117.invoke(r110, new Object[0]);     // Catch: Throwable -> L70
        L55:
            Class<?>[] r102 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L70
            int r103 = r102.length;     // Catch: Throwable -> L70
            Class<?> r104 = null;
            int r105 = 0;
        L57:
            if (r105 >= r103) goto L62;
            Class<?> r106 = r102[r105];     // Catch: Throwable -> L70
            if (StringsKt.contains$default(r106.getSimpleName(), "TranslucentConversionListener", false, 2, null) == false) goto L61;
            r104 = r106;
        L61:
            r105 = r105 + 1;     // Catch: Throwable -> L70
            goto L57
        L62:
            Method r107 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r104, ActivityOptions.class});     // Catch: Throwable -> L70
            if (r107 == null) goto L65;
            r107.setAccessible(true);     // Catch: Throwable -> L70
        L65:
            if (r107 == null) goto L67;
            r107.invoke(r110, new Object[]{null, r118});     // Catch: Throwable -> L70
            goto L67
        L54:
            r118 = null;
            goto L55
        L34:
            if (q.f(r110) == true) goto L39;
            if (b.c() == false) goto L39;
            r110.overridePendingTransition(R.anim.slide_in_bottom, 0);
            goto L39
        L76:
            return;
        L16:
            if (q.f522410b != PageState.CREATED) goto L26;
            if (q.f522411c != null) goto L20;
        L22:
            boolean r108 = false;
        L23:
            if (r108 == false) goto L26;
            FLogger.f375446a.i("ECAppletStackManager", "origin created, reset applet stack, stack=" + q.f522418j);
            q.i();
            return;
        L20:
            if (Intrinsics.areEqual(r110.getClass(), q.f522411c) == false) goto L22;
            r108 = true;
        L12:
            r112 = null;
            goto L14
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "outState");
            AtomicBoolean r102 = q.f522409a;
            if (q.f(r100) == false) goto L5;
            return;
        L5:
            String r103 = (String) ((LinkedHashMap) q.f522420l).get(r100);
            if (r103 == null) goto L9;
            r101.putString("ec_applet_page_id", r103);
            q.f522419k.add(r103);
            return;
        }
    }

    public q() {
    }

    static {
        f522409a = new AtomicBoolean(false);
        f522410b = PageState.UNKNOWN;
        f522412d = System.currentTimeMillis();
        f522418j = new ArrayList();
        f522419k = new LinkedHashSet();
        f522420l = new LinkedHashMap();
        f522421m = new a();
    }

    public static boolean d() {
        if (f(AppHost.f326268a.a().getCurrentActivity()) == false) goto L7;
        return true;
    L7:
        return f522409a.get();
    }

    public static boolean g() {
        if (f(AppHost.f326268a.a().getCurrentActivity()) == false) goto L6;
        return false;
    L6:
        if (f522410b != PageState.GOING) goto L8;
    L11:
        return true;
    L8:
        if (f522410b == PageState.CREATED) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(f522416h, f522417i) == true) goto L11;
        return false;
    }

    public static void i() {
        FLogger.f375446a.i("ECAppletStackManager", BasicTestActionHandler.TEST_ACTION_RESET);
        f522410b = PageState.UNKNOWN;
        f522411c = null;
        f522413e = null;
        f522414f = false;
        f522415g = 0;
        f522416h = null;
        f522417i = null;
        ((ArrayList) f522418j).clear();
        f522419k.clear();
        ((LinkedHashMap) f522420l).clear();
        AppHost.f326268a.getApplication().unregisterActivityLifecycleCallbacks(f522421m);
        p.f522406a = null;
        p.f522407b = false;
        f522409a.set(false);
    }

    public static final boolean a(Activity r100) {
        String r101 = (String) ((LinkedHashMap) f522420l).get(r100);
        if (r101 != null) goto L6;
    L10:
        return false;
    L6:
        if (f522410b != PageState.CREATED) goto L10;
        if (Intrinsics.areEqual(r101, f522417i) == false) goto L10;
        return true;
    }

    public static final void b(String r100) {
        List<String> r101 = f522418j;
        ArrayList r102 = (ArrayList) r101;
        int r103 = r102.indexOf(r100);
        if (r103 >= 0) goto L5;
        return;
    L5:
        if (r103 == CollectionsKt.getLastIndex(r101)) goto L10;
        int r104 = r103 + 1;
        List r105 = CollectionsKt.toList(r102.subList(r104, r102.size()));
        r102.subList(r104, r102.size()).clear();
        f522419k.removeAll(CollectionsKt.toSet(r105));
        FLogger.f375446a.i("ECAppletStackManager", "trim stack to pageId=" + r100 + ", removed=" + r105 + ", size=" + r102.size());
        return;
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        AppHost.Companion r101 = AppHost.f326268a;
        Activity r102 = r101.a().getCurrentActivity();
        if (r102 != null) goto L5;
        return;
    L5:
        Class<? extends Activity> r103 = f522411c;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("close applet, scene=");
        r105.append(r100);
        r105.append(", current=");
        r105.append(r102.getClass().getName());
        r105.append(", origin=");
        if (r103 == null) goto L8;
        String r106 = r103.getName();
    L9:
        r105.append(r106);
        r104.i("ECAppletStackManager", r105.toString());
        boolean r107 = true;
        if (f(r102) == false) goto L13;
        r102.moveTaskToBack(true);
        return;
    L13:
        Lazy r108 = p89.d.f528228a;
        Set r109 = CollectionsKt.toSet(f522418j);
        Intrinsics.checkNotNullParameter("ec_applet_page_id", "pageIdKey");
        Intrinsics.checkNotNullParameter(r109, "closingPageIds");
        p89.c r110 = p89.d.f528229b;
        if (r110 == null) goto L20;
        r101.getApplication().unregisterActivityLifecycleCallbacks(r110);
        if (p89.d.f528229b != r110) goto L20;
        p89.d.f528229b = null;
    L20:
        if (r109.isEmpty() == true) goto L23;
        final p89.c r111 = new p89.c(r109);
        p89.d.f528229b = r111;
        r101.getApplication().registerActivityLifecycleCallbacks(r111);
        ((Handler) p89.d.f528228a.getValue()).postDelayed(new p89.b(r111), 2000);
    L23:
        f522414f = true;
        Set r112 = ((LinkedHashMap) f522420l).keySet();
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L24:
        boolean r115 = false;
        if (r114.hasNext() == false) goto L31;
        Object r116 = r114.next();
        if (((Activity) r116).getTaskId() != r102.getTaskId()) goto L29;
        r115 = true;
    L29:
        if (r115 == false) goto L24;
        r113.add(r116);
        goto L24
    L31:
        i();
        if (r103 != null) goto L34;
        r102.finish();
    L48:
        c.a(r102);
        return;
    L34:
        if (Build.VERSION.SDK_INT >= 34) goto L36;
    L40:
        r107 = false;
    L41:
        if (r107 == false) goto L46;
        Iterator r117 = r113.iterator();
    L44:
        if (r117.hasNext() == false) goto L48;
        ((Activity) r117.next()).finish();
        goto L44
    L46:
        Intent r118 = new Intent(r102, r103);
        r118.addFlags(603979776);
        r102.startActivity(r118);
        goto L48
    L36:
        if (b.c() == false) goto L40;
        e10 r119 = e10.f368561a;
        int r120 = l0.f375430a;
        if (((Boolean) l0.a(Boolean.TRUE, new b1())).booleanValue() == false) goto L40;
    L8:
        r106 = null;
        goto L9
    }

    public static boolean e(ComponentName r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getClassName();
    L6:
        return Intrinsics.areEqual(r101, AppletFullScreenActivity.class.getName());
    L4:
        r101 = null;
        goto L6
    }

    public static boolean f(Activity r110) {
        if (r110 != null) goto L6;
        return false;
    L6:
        if ((r110 instanceof AppletFullScreenActivity) == false) goto L8;
        return true;
    L8:
        List<Activity> r100 = AppHost.f326268a.a().g();
        if ((r100 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r101 = r100.iterator();
    L15:
        if (r101.hasNext() == false) goto L24;
        Activity r102 = (Activity) r101.next();
        if ((r102 instanceof AppletFullScreenActivity) == true) goto L19;
    L21:
        boolean r103 = false;
    L22:
        if (r103 == false) goto L15;
        boolean r104 = true;
    L25:
        if (r104 == false) goto L27;
        return true;
    L27:
        Object r105 = r110.getSystemService("activity");
        if ((r105 instanceof ActivityManager) == false) goto L30;
        ActivityManager r106 = (ActivityManager) r105;
    L31:
        if (r106 == null) goto L88;
        List<ActivityManager.AppTask> r107 = r106.getAppTasks();     // Catch: SecurityException -> L70
        if ((r107 instanceof Collection) == true) goto L36;
    L38:
        Iterator<T> r108 = r107.iterator();     // Catch: SecurityException -> L70
    L39:
        if (r108.hasNext() == false) goto L89;
        ActivityManager.RecentTaskInfo r109 = ((ActivityManager.AppTask) r108.next()).getTaskInfo();     // Catch: SecurityException -> L70
        if (r109 != null) goto L44;
        boolean r111 = false;
    L68:
        if (r111 == false) goto L39;
        return true;
    L44:
        int r112 = Build.VERSION.SDK_INT;     // Catch: SecurityException -> L70
        if (r112 < 29) goto L47;
        int r113 = r109.taskId;     // Catch: SecurityException -> L70
    L48:
        Intent r114 = r109.baseIntent;     // Catch: SecurityException -> L70
        if (r114 == null) goto L51;
        ComponentName r115 = r114.getComponent();     // Catch: SecurityException -> L70
    L52:
        ComponentName r116 = r109.origActivity;     // Catch: SecurityException -> L70
        if (r112 < 29) goto L55;
        ComponentName r117 = r109.baseActivity;     // Catch: SecurityException -> L70
    L57:
        if (r113 == r110.getTaskId()) goto L59;
    L65:
        r111 = false;
    L66:
        if (r111 == false) goto L68;
        FLogger.f375446a.i("ECAppletStackManager", "isInAppletAppTask: matched AppTask, activity=" + r110.getClass().getSimpleName() + ", taskId=" + r113 + ", baseIntent=" + r115 + ", origActivity=" + r116 + ", baseActivity=" + r117);     // Catch: SecurityException -> L70
        goto L68
    L59:
        if (e(r115) == false) goto L61;
    L64:
        r111 = true;
        goto L66
    L61:
        if (e(r116) == true) goto L64;
        if (e(r117) == false) goto L65;
    L55:
        r117 = null;
        goto L57
    L51:
        r115 = null;
        goto L52
    L47:
        r113 = r109.persistentId;     // Catch: SecurityException -> L70
        goto L48
    L89:
        return false;
    L36:
        if (r107.isEmpty() == false) goto L38;
        return false;
    L70:
        e = move-exception;
        FLogger.f375446a.w("ECAppletStackManager", "isInAppletAppTask: getAppTasks denied, taskId=" + r110.getTaskId() + ", error=" + e.getMessage());
        return false;
    L88:
        return false;
    L30:
        r106 = null;
        goto L31
    L19:
        if (((AppletFullScreenActivity) r102).getTaskId() != r110.getTaskId()) goto L21;
        r103 = true;
    L24:
        r104 = false;
        goto L25
    L11:
        if (r100.isEmpty() == false) goto L13;
        goto L13
    }

    public static void h(String r100) {
        r r101 = r.f522422a;
        String r102 = f522413e;
        Class<? extends Activity> r103 = f522411c;
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getName();
    L6:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "type");
        JSONObject r106 = new JSONObject();
        if (r102 == null) goto L9;
        r104 = StringsKt.substringBefore$default(r102, "?", null, 2, null);
    L9:
        r106.putOpt("url", r104);
        r106.putOpt("scene", r105);
        r106.putOpt("action_type", r100);
        IApplog.f287053a.reportEvent("ies_ec_flow_applet_open", r106);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
