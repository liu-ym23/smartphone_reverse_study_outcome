package d58;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f467068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f467069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Integer> f467070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f467071d;

    public static final class a {
    }

    static {
    }

    public final Function0<Integer> getBottomBlockHeightProvider() {
        return this.f467070c;
    }

    public final boolean getDisableGesture() {
        return this.f467068a;
    }

    public final Function0<Unit> getOnBlockedGesture() {
        return this.f467069b;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        setClickable(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = true;
        if (this.f467068a == true) goto L5;
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L18;
        if (r102 != 1) goto L14;
    L16:
        boolean r103 = this.f467071d;
        this.f467071d = false;
        return r103;
    L14:
        if (r102 == 3) goto L16;
    L37:
        return this.f467071d;
    L18:
        Function0<Integer> r104 = this.f467070c;
        if (r104 == null) goto L29;
        Integer r105 = Integer.valueOf(r104.invoke().intValue());
        if (r105.intValue() <= 0) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == true) goto L27;
        r105 = null;
    L27:
        if (r105 == null) goto L29;
        int r107 = r105.intValue();
    L30:
        if (r107 > 0) goto L32;
    L34:
        r101 = false;
    L35:
        this.f467071d = r101;
        goto L37
    L32:
        if (r100.getY() < (getHeight() - r107)) goto L34;
    L23:
        r106 = false;
    L29:
        r107 = 0;
        goto L30
    L5:
        if (r100.getActionMasked() != 0) goto L9;
        Function0<Unit> r108 = this.f467069b;
        if (r108 == null) goto L9;
        r108.invoke();
    L9:
        return true;
    }

    public final void setBottomBlockHeightProvider(Function0<Integer> r100) {
        this.f467070c = r100;
    }

    public final void setDisableGesture(boolean r100) {
        this.f467068a = r100;
    }

    public final void setOnBlockedGesture(Function0<Unit> r100) {
        this.f467069b = r100;
    }
}
