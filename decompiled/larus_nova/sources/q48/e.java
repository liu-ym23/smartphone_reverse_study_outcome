package q48;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.PluginState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends t57.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f531678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f531679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f531680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f531681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashMap<String, byte[]> f531682e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Application f531683f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f531684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f531685h;

    /* JADX INFO: loaded from: classes3.dex */
    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f531686a;

        public a(e r100) {
            this.f531686a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivityDestroyed");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivityPaused");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivityResumed");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivityStarted");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivityStopped");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivityCreated");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostSaveInstanceState(Activity r100, Bundle r101) {
            if (e.f(this.f531686a, r100) == false) goto L6;
            Logger.a("BinderTranTooLargeExp", "[" + r100 + "] onSaveState disabled");
            return;
        L6:
            this.f531686a.getClass();
            Parcel r102 = Parcel.obtain();
            r102.writeBundle(r101);     // Catch: Throwable -> L9
            byte[] r103 = r102.marshall();     // Catch: Throwable -> L9
            r102.recycle();
        L12:
            if (r103 != null) goto L19;
            if (this.f531686a.f531678a == false) goto L16;
            Logger.a("BinderTranTooLargeExp", "[" + r100 + "] onSaveState force clear");
            r101.clear();
        L16:
            Logger.d("[" + r100 + "] onSaveState bundleBytes is null");
            return;
        L19:
            if (r103.length <= this.f531686a.f531681d) goto L25;
            String r104 = UUID.randomUUID().toString();
            this.f531686a.f531682e.put(r104, r103);     // Catch: Throwable -> L23
            r101.clear();     // Catch: Throwable -> L23
            r101.putString("BinderTranTooLargeExpActivityRecordKey", r104);     // Catch: Throwable -> L23
            JSONObject r105 = new JSONObject();     // Catch: Throwable -> L23
            r105.put("activity", r100.getComponentName().getClassName());     // Catch: Throwable -> L23
            r105.put("step", 1);     // Catch: Throwable -> L23
            ApmAgent.monitorEvent("binder_tran_too_large_exp", r105, null, null);     // Catch: Throwable -> L23
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onSaveState success uuid = [" + r104 + "]");     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            th.printStackTrace();
            return;
        L25:
            Logger.d("[" + r100 + "] onSaveState length not reach");
            return;
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L27
            r102.recycle();
            r103 = null;
        L27:
            th = move-exception;
            r102.recycle();
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreCreated(Activity r110, Bundle r111) {
            if (r111 != null) goto L7;
            Logger.d("[" + r110 + "] onActivityPreCreated savedState is null");
            return;
        L7:
            if (e.f(this.f531686a, r110) == false) goto L10;
            Logger.a("BinderTranTooLargeExp", "[" + r110 + "] onActivityPreCreated disabled");
            return;
        L10:
            Object r100 = r111.get("BinderTranTooLargeExpActivityRecordKey");
            if (r100 != null) goto L15;
            Logger.d("[" + r110 + "] onActivityPreCreated uuid is null");
            return;
        L15:
            if ((r100 instanceof String) == true) goto L59;
            Logger.d("[" + r110 + "] onActivityPreCreated uuid is not String[" + r100 + "]");
            return;
        L59:
            r111.clear();     // Catch: Throwable -> L39
            byte[] r101 = this.f531686a.f531682e.remove(r100);     // Catch: Throwable -> L39
            if (r101 != null) goto L25;
            Logger.a("BinderTranTooLargeExp", "[" + r110 + "] onActivityPreCreated uuid = [" + r100 + "], decoded == null");     // Catch: Throwable -> L39
            if (this.f531686a.f531679b == true) goto L22;
            return;
        L22:
            if (r111.isEmpty() == false) goto L61;
            e.g(this.f531686a, r110);
            return;
        L61:
            return;
        L25:
            e r102 = this.f531686a;     // Catch: Throwable -> L39
            ClassLoader r103 = r110.getClassLoader();     // Catch: Throwable -> L39
            r102.getClass();     // Catch: Throwable -> L39
            Parcel r104 = Parcel.obtain();     // Catch: Throwable -> L39
            r104.unmarshall(r101, 0, r101.length);     // Catch: Throwable -> L36
            r104.setDataPosition(0);     // Catch: Throwable -> L36
            Bundle r105 = r104.readBundle(r103);     // Catch: Throwable -> L36
            r104.recycle();     // Catch: Throwable -> L39
            if (r105 == null) goto L30;
            r111.putAll(r105);     // Catch: Throwable -> L39
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L39
            r106.put("activity", r110.getComponentName().getClassName());     // Catch: Throwable -> L39
            r106.put("step", 2);     // Catch: Throwable -> L39
            ApmAgent.monitorEvent("binder_tran_too_large_exp", r106, null, null);     // Catch: Throwable -> L39
            Logger.b("BinderTranTooLargeExp", "[" + r110 + "] onActivityPreCreated restore success uuid = [" + r100 + "]");     // Catch: Throwable -> L39
        L32:
            if (this.f531686a.f531679b == true) goto L34;
            return;
        L34:
            if (r111.isEmpty() == false) goto L63;
        L45:
            e.g(this.f531686a, r110);
            return;
        L63:
            return;
        L30:
            Logger.d("[" + r110 + "] onActivityPreCreated restore bundle is null uuid = [" + r100 + "]");     // Catch: Throwable -> L39
            goto L32
        L36:
            th = move-exception;
            r104.recycle();     // Catch: Throwable -> L39
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L46
            if (this.f531686a.f531679b == true) goto L44;
            return;
        L44:
            if (r111.isEmpty() == true) goto L45;
            return;
        L46:
            th = move-exception;
            if (this.f531686a.f531679b == true) goto L50;
        L52:
            throw th;
        L50:
            if (r111.isEmpty() == false) goto L52;
            e.g(this.f531686a, r110);
            goto L52
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            Logger.b("BinderTranTooLargeExp", "[" + r100 + "] onActivitySaveInstanceState, outState = [" + r101 + "]");
        }
    }

    @Override // t57.a
    public final String b() {
        return "BinderTranTooLargeExp";
    }

    @Override // t57.a
    public final void d() {
        PluginState r100 = PluginState.INITIALIZED;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 29) goto L7;
        Logger.d("start, ignore sdk=" + r101);
        return;
    L7:
        if (this.f531684g == false) goto L10;
        Logger.d("start, already started");
        return;
    L10:
        this.f531684g = true;
        this.f531683f.registerActivityLifecycleCallbacks(this.f531685h);
        Logger.b("BinderTranTooLargeExp", "start");
    }

    @Override // t57.a
    public final void c(Application r100) {
        PluginState r101 = PluginState.INITIALIZED;
        this.f531683f = r100;
        Logger.b("BinderTranTooLargeExp", "init, bundleSizeThresholdBytes=" + this.f531681d);
    }

    public e(List r100, int r101) {
        this.f531682e = new LinkedHashMap();
        this.f531685h = new a(this);
        this.f531678a = true;
        this.f531679b = true;
        this.f531680c = r100;
        if (r101 > 0) goto L6;
        r101 = 460800;
    L6:
        this.f531681d = r101;
    }

    public static boolean f(e r100, Activity r101) {
        r100.getClass();
        String r102 = r101.getClass().getName();
        Iterator<String> r103 = r100.f531680c.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        if (TextUtils.equals(r103.next(), r102) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public static void g(e r100, Activity r101) {
        r100.getClass();
        Application r102 = r101.getApplication();
        if (r102 != null) goto L5;
        Logger.a("BinderTranTooLargeExp", "[" + r101 + "] restart, application == null");
        return;
    L5:
        Intent r103 = r102.getPackageManager().getLaunchIntentForPackage(r102.getPackageName());
        if (r103 != null) goto L8;
        Logger.a("BinderTranTooLargeExp", "[" + r101 + "] restart, intent == null");
        return;
    L8:
        r101.startActivity(Intent.makeRestartActivityTask(r103.getComponent()));
        Logger.a("BinderTranTooLargeExp", "[" + r101 + "] restart success then exit");
        Runtime.getRuntime().exit(0);
    }
}
