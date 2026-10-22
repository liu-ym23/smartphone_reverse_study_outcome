package w3;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.ai.applet.page.g;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Unit> f558091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<View> f558092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f558093c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        WeakReference<View> r100 = this.f558092b;
        if (r100 == null) goto L10;
        View r101 = r100.get();
        if (r101 == null) goto L10;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102.isAlive() == false) goto L9;
        r102.removeOnGlobalLayoutListener(this);
    L9:
        r101.removeOnAttachStateChangeListener(this);
    L10:
        WeakReference<View> r103 = this.f558092b;
        if (r103 == null) goto L13;
        r103.clear();
    L13:
        this.f558092b = null;
        this.f558093c = null;
    }

    public final void b() {
        WeakReference<View> r100 = this.f558092b;
        if (r100 == null) goto L37;
        View r101 = r100.get();
        if (r101 == null) goto L39;
        View r102 = r101.getRootView();
        if (r102 != null) goto L10;
        r102 = r101;
    L10:
        int r103 = r102.getHeight();
        if (r103 > 0) goto L13;
        Integer r104 = null;
    L24:
        if (r104 == null) goto L38;
        int r105 = r104.intValue();
        Integer r106 = this.f558093c;
        if (r106 != null) goto L32;
        this.f558093c = Integer.valueOf(r105);
        if (r105 <= 0) goto L36;
        this.f558091a.invoke(Integer.valueOf(r105));
        return;
    L36:
        return;
    L32:
        if (r106.intValue() != r105) goto L34;
        return;
    L34:
        this.f558093c = Integer.valueOf(r105);
        this.f558091a.invoke(Integer.valueOf(r105));
        return;
    L38:
        return;
    L13:
        WindowInsetsCompat r107 = ViewCompat.getRootWindowInsets(r101);
        if (r107 == null) goto L20;
        int r108 = RangesKt.coerceAtLeast(r107.getInsets(WindowInsetsCompat.Type.ime()).bottom - r107.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom, 0);
        if (r108 <= 0) goto L18;
    L19:
        r104 = Integer.valueOf(r108);
        goto L24
    L18:
        if (r107.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L19;
    L20:
        Rect r109 = new Rect();
        r102.getWindowVisibleDisplayFrame(r109);
        int r110 = RangesKt.coerceAtLeast(r103 - r109.bottom, 0);
        if (r110 <= (r103 * 0.15f)) goto L23;
        r104 = Integer.valueOf(r110);
        goto L24
    L23:
        r104 = 0;
        goto L24
    L39:
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        b();
    }

    public b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "onHeightChanged");
        this.f558091a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        WeakReference<View> r101 = this.f558092b;
        if (r101 == null) goto L5;
        View r102 = r101.get();
    L6:
        if (r102 == r100) goto L8;
        return;
    L8:
        ViewTreeObserver r103 = r100.getViewTreeObserver();
        if (r103.isAlive() == false) goto L11;
        r103.addOnGlobalLayoutListener(this);
    L11:
        b();
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101.isAlive() == false) goto L6;
        r101.removeOnGlobalLayoutListener(this);
        return;
    }
}
