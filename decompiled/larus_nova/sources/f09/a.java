package f09;

import android.app.Activity;
import android.os.Bundle;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: f09.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes4.dex */
    public interface InterfaceC5845a {
        void onCreate(Activity r100, Bundle r101);

        void onPaused(Activity r100);

        void onPreDestroyed(Activity r100);

        void onResumed(Activity r100);

        void onStart(Activity r100);

        void onStopped(Activity r100);
    }

    public interface b {
        void onAllActivityDestroyed();

        void onAppBackground();

        void onAppForeground();
    }

    Activity a(Activity r100, Function1<? super Activity, Boolean> r101);

    void b(Activity r100);

    void c(b r100);

    Integer d();

    void e(InterfaceC5845a r100);

    void f(InterfaceC5845a r100);

    void finishAllActivities();

    List<Activity> g();

    Activity getCurrentActivity();

    Activity getTopActivity();

    boolean h(Class<? extends Activity> r100);

    boolean isAppBackground();

    boolean isAppPaused();

    void j(b r100);

    void k();

    List<Activity> m();
}
