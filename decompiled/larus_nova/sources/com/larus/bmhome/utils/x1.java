package com.larus.bmhome.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class x1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f315147d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f315148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Boolean> f315149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f315150c;

    public static final class a {
    }

    static {
        f315147d = SetsKt.setOf("REDMI_M2012K11AC");
    }

    public final boolean b() {
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this.f315148a);
        if (r100 == null) goto L5;
        boolean r101 = r100.isVisible(WindowInsetsCompat.Type.ime());
    L6:
        if (r101 == true) goto L12;
        Function0<Boolean> r102 = this.f315149b;
        if (r102 == null) goto L10;
        boolean r103 = r102.invoke().booleanValue();
    L11:
        if (r103 == true) goto L12;
        return false;
    L10:
        r103 = false;
    L12:
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public x1(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        this.f315148a = r100;
        this.f315150c = LazyKt.lazy(new r1());
    }

    public final void a(boolean r100) {
        boolean r101 = b();
        FLogger.f375446a.d("ImeManager", "hideIme(), isShowing:" + r101);
        if (r101 == true) goto L6;
        if (r100 == true) goto L6;
        return;
    L6:
        Context r102 = this.f315148a.getContext();
    L7:
        boolean r103 = r102 instanceof Activity;
        if (r103 == true) goto L12;
        if ((r102 instanceof ContextWrapper) == false) goto L12;
        r102 = ((ContextWrapper) r102).getBaseContext();
    L12:
        InputMethodManager r104 = null;
        if (r103 == false) goto L15;
        Activity r105 = (Activity) r102;
    L16:
        if (r105 == null) goto L18;
        Window r106 = r105.getWindow();
    L19:
        if (r106 == null) goto L39;
        Context r107 = this.f315148a.getContext();
        if ((r107 instanceof Activity) == false) goto L23;
        Activity r108 = (Activity) r107;
    L24:
        if (r108 == null) goto L33;
        View r109 = r108.getCurrentFocus();
        if (r109 == null) goto L33;
        Object r110 = r108.getSystemService("input_method");
        if ((r110 instanceof InputMethodManager) == false) goto L31;
        r104 = (InputMethodManager) r110;
    L31:
        if (r104 == null) goto L33;
        r104.hideSoftInputFromWindow(r109.getWindowToken(), 0);
    L33:
        WindowInsetsControllerCompat r111 = ViewCompat.getWindowInsetsController(this.f315148a);
        if (r111 == null) goto L40;
        r111.hide(WindowInsetsCompat.Type.ime());
        return;
    L40:
        return;
    L23:
        r108 = null;
        goto L24
    L39:
        return;
    L18:
        r106 = null;
        goto L19
    L15:
        r105 = null;
        goto L16
    }

    public static /* synthetic */ void d(x1 r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        boolean r102 = true;
    L6:
        r100.c(null, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.utils.s1] */
    public final void c(final Function0<Unit> r110, final boolean r111) {
        final ?? r100 = new s1(this, r111, r110);
        FLogger.f375446a.d("ImeManager", "innerTrickShowIme()");
        final float r101 = this.f315148a.getWidth();
        final float r102 = this.f315148a.getHeight();
        final long r103 = SystemClock.uptimeMillis();
        if (b() == true) goto L7;
        final MotionEvent r104 = MotionEvent.obtain(r103, SystemClock.uptimeMillis(), 0, r101, r102, 0);
        com.larus.utils.l0.b(new t1(this, r104));
        this.f315148a.post(new u1(r103, r101, r102, this, r100));
        return;
    }
}
