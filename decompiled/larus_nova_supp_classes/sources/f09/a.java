package f09;

import android.app.Activity;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface a {

    public interface b {
        void onAllActivityDestroyed();

        void onAppBackground();

        void onAppForeground();
    }

    Activity a(Activity r1, Function1<? super Activity, Boolean> r2);

    void b(Activity r1);

    void c(b r1);

    Integer d();

    void e(a r1);

    void f(a r1);

    void finishAllActivities();

    List<Activity> g();

    Activity getCurrentActivity();

    Activity getTopActivity();

    boolean h(Class<? extends Activity> r1);

    boolean isAppBackground();

    boolean isAppPaused();

    void j(b r1);

    void k();

    List<Activity> m();
}
