package hp4;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class s implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f486427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f486428b;

    public s(t r100, Context r101) {
        this.f486427a = r100;
        this.f486428b = r101;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "insets");
        int r102 = r101.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r104 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile_fix_oppo_editor_navigation") == false) goto L29;
        if (r102 > 0) goto L29;
        this.f486427a.getClass();
        boolean r105 = true;
        if (StringsKt.equals(Build.MANUFACTURER, "OPPO", true) == false) goto L29;
        this.f486427a.getClass();
        if (Build.VERSION.SDK_INT != 29) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L29;
        t r107 = this.f486427a;
        r107.getClass();
        Window r108 = r107.f486429a;     // Catch: Exception -> L31
        if (r108 == null) goto L23;
        View r109 = r108.getDecorView();     // Catch: Exception -> L31
        if (com.larus.home.impl.utils.c.f346345e == false) goto L20;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L31
        Thread r110 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L31
        if (r110 == com.larus.home.impl.utils.c.f346341a) goto L20;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");     // Catch: Exception -> L31
    L20:
        if (r109 == null) goto L23;
        View r111 = r109.findViewById(R.id.navigationBarBackground);     // Catch: Exception -> L31
    L24:
        if (r111 == null) goto L26;
    L27:
        if (r105 == false) goto L29;
        r102 = com.bytedance.ee.util.ui.k.d(this.f486428b);
    L23:
        r111 = null;
    L26:
        r105 = false;
        goto L27
    L10:
        r106 = false;
    L29:
        r100.setPadding(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getPaddingRight(), r102);
        return r101;
    }
}
