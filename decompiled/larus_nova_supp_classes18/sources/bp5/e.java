package bp5;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widget.statusbar.StatusBarView;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements a {
    public e() {
    }

    @Override // bp5.a
    public final void a(Window r6, int r7) {
        d.a(r6, 67108864);
        View r0 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L7:
        ViewGroup r2 = (ViewGroup) r0;
        View r3 = r2.findViewWithTag("ghStatusBarView");
        if (r3 != null) goto L10;
        r3 = new StatusBarView(r6.getContext());
        r3.setTag("ghStatusBarView");
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -2);
        r4.gravity = 48;
        r3.setLayoutParams(r4);
        r2.addView(r3);
    L10:
        r3.setBackgroundColor(r7);
        View r8 = ((ViewGroup) r6.findViewById(R.id.content)).getChildAt(0);
        if (r8 == null) goto L14;
        r8.setFitsSystemWindows(true);
        return;
    }
}
