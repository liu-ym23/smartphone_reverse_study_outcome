package d48;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.larus.account.saas.runtime.depend.ToastType;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: loaded from: classes24.dex */
    public interface a {
        void onAppLifeCycleChange(boolean r100);
    }

    boolean b();

    Activity currentActivity();

    String e();

    boolean f(ToastType r100, String r101);

    void g(a r100);

    Application getApplication();

    void h(com.larus.account.saas.mfa.assist.c r100);

    boolean isTeenMode();

    boolean startActivity(Activity r100, Intent r101);
}
