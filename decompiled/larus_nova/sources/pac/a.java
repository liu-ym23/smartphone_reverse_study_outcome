package pac;

import android.app.Application;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: pac.a$a, reason: collision with other inner class name */
    public static final class RunnableC7173a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f528404a;

        public RunnableC7173a(Application r100) {
            this.f528404a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Application r100 = this.f528404a;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
            UDToast.show(r100, R.string.Lark_Setting_NameNetworkError);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a() {
        return ((oac.a) ApiUtils.getApi(oac.a.class)).isWeakNet();
    }

    @JvmStatic
    public static final void b() {
        Application r100 = LarkContext.getApplication();
        if (NetworkUtils.d(r100) == true) goto L6;
        UICallbackExecutor.execute(new RunnableC7173a(r100));
        return;
    }
}
