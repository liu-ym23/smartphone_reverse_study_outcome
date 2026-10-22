package z06;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f569630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f569631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f569632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f569633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f569634e;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r100 = this.f569630a.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r101 = ThreadMethodProxy.currentThread();
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");
    L7:
        WindowInsetsCompat r102 = ViewCompat.getRootWindowInsets(r100);
        if (r102 != null) goto L10;
        return;
    L10:
        boolean r103 = false;
        if (r102.isVisible(WindowInsetsCompat.Type.ime()) == false) goto L26;
        Ref.BooleanRef r104 = this.f569631b;
        View r105 = this.f569632c;
        if (r105 != null) goto L15;
    L16:
        r103 = true;
    L17:
        r104.element = r103;
        if (this.f569633d.element == false) goto L20;
    L24:
        this.f569633d.element = true;
        return;
    L20:
        if (this.f569631b.element == false) goto L24;
        Function1<Boolean, Unit> r106 = this.f569634e;
        if (r106 == null) goto L24;
        r106.invoke(Boolean.TRUE);
        goto L24
    L15:
        if (r105.hasFocus() == false) goto L17;
    L26:
        if (this.f569633d.element == true) goto L28;
    L32:
        this.f569633d.element = false;
        return;
    L28:
        if (this.f569631b.element == false) goto L32;
        Function1<Boolean, Unit> r107 = this.f569634e;
        if (r107 == null) goto L32;
        r107.invoke(Boolean.FALSE);
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Window r100, Ref.BooleanRef r101, View r102, Ref.BooleanRef r103, Function1<? super Boolean, Unit> r104) {
        this.f569630a = r100;
        this.f569631b = r101;
        this.f569632c = r102;
        this.f569633d = r103;
        this.f569634e = r104;
    }
}
