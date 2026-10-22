package ih2;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public View a;
    public final /* synthetic */ Window b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
    L22:
        return false;
    L4:
        if (this.a != null) goto L11;
        View r1 = this.b.getDecorView();     // Catch: Exception -> L22
        if (com.larus.home.impl.utils.c.e == false) goto L10;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L22
        Thread r2 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L22
        if (r2 == com.larus.home.impl.utils.c.a) goto L10;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");     // Catch: Exception -> L22
    L10:
        this.a = r1.findViewById(R.id.statusBarBackground);     // Catch: Exception -> L22
    L11:
        View r3 = this.a;     // Catch: Exception -> L22
        if (r3 != null) goto L15;
        return true;
    L15:
        if (r3.getBackground() != null) goto L17;
    L20:
        this.a.setBackground(new ColorDrawable(0));     // Catch: Exception -> L22
    L21:
        return true;
    L17:
        if ((this.a.getBackground() instanceof ColorDrawable) == false) goto L20;
        ((ColorDrawable) this.a.getBackground()).setColor(0);     // Catch: Exception -> L22
        goto L21
    }

    public a(Window r1) {
        this.b = r1;
        this.a = null;
    }
}
