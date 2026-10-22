package ih2;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f489773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Window f489774b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
    L22:
        return false;
    L4:
        if (this.f489773a != null) goto L11;
        View r100 = this.f489774b.getDecorView();     // Catch: Exception -> L22
        if (com.larus.home.impl.utils.c.f346345e == false) goto L10;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L22
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L22
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L10;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Exception -> L22
    L10:
        this.f489773a = r100.findViewById(R.id.statusBarBackground);     // Catch: Exception -> L22
    L11:
        View r102 = this.f489773a;     // Catch: Exception -> L22
        if (r102 != null) goto L15;
        return true;
    L15:
        if (r102.getBackground() != null) goto L17;
    L20:
        this.f489773a.setBackground(new ColorDrawable(0));     // Catch: Exception -> L22
    L21:
        return true;
    L17:
        if ((this.f489773a.getBackground() instanceof ColorDrawable) == false) goto L20;
        ((ColorDrawable) this.f489773a.getBackground()).setColor(0);     // Catch: Exception -> L22
        goto L21
    }

    public a(Window r100) {
        this.f489774b = r100;
        this.f489773a = null;
    }
}
