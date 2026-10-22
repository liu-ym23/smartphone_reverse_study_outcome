package htb;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.OfficeSdkLarkDependencyInjector;
import com.ss.android.lark.officesdk.chameleon.assembly.doubao.webview.OfficeWebViewLarkDependencyInjector;
import com.ss.android.lark.officewebview.util.b;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f487192a = null;

    static {
        f487192a = new AtomicBoolean(false);
    }

    public static void a() {
        if (f487192a.compareAndSet(false, true) == false) goto L13;
        OfficeSdkLarkDependencyInjector.a();
        OfficeWebViewLarkDependencyInjector.a();
        Application r100 = LarkContext.getApplication();
        WeakReference<Activity> r101 = b.f437537a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r102 = r100.getApplicationContext();
        if ((r102 instanceof Application) == false) goto L7;
        Application r103 = (Application) r102;
    L8:
        if (r103 == null) goto L10;
        r103.unregisterActivityLifecycleCallbacks(b.f437538b);
    L10:
        if (r103 == null) goto L14;
        r103.registerActivityLifecycleCallbacks(b.f437538b);
        return;
    L14:
        return;
    L7:
        r103 = null;
        goto L8
    }
}
