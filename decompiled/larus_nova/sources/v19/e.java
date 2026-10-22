package v19;

import android.view.MotionEvent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<View, Unit> f552460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f552461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<View, MotionEvent, Unit> f552462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<View, MotionEvent, Unit> f552463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<View, MotionEvent, Unit> f552464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f552465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f552466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f552467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f552468i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Runnable, v19.d] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r111, "event");
        int r100 = r111.getAction();
        if (r100 == 0) goto L33;
        if (r100 != 1) goto L7;
        r110.removeCallbacks(this.f552466g);
        this.f552466g = null;
        if (this.f552467h == true) goto L28;
        long r101 = System.currentTimeMillis();
        FLogger r112 = FLogger.f375446a;
        r112.i("CompoundTouchListener", "ACTION_UP called 01 lastClickTime=" + this.f552468i + " curClickTime=" + r101 + " gap=" + (r101 - this.f552468i) + " hashCode=" + hashCode());
        if ((r101 - this.f552468i) < 800) goto L31;
        this.f552468i = r101;
        r112.i("CompoundTouchListener", "ACTION_UP called 02 lastClickTime=" + this.f552468i + " hashCode=" + hashCode());
        Function1<View, Unit> r113 = this.f552460a;
        if (r113 == null) goto L31;
        r113.invoke(r110);
    L31:
        return true;
    L28:
        Function2<View, MotionEvent, Unit> r102 = this.f552463d;
        if (r102 == null) goto L31;
        r102.invoke(r110, r111);
        goto L31
    L7:
        if (r100 != 2) goto L9;
        Function2<View, MotionEvent, Unit> r103 = this.f552464e;
        if (r103 == null) goto L20;
        r103.invoke(r110, r111);
    L20:
        return true;
    L9:
        if (r100 == 3) goto L11;
        return false;
    L11:
        r110.removeCallbacks(this.f552466g);
        this.f552466g = null;
        if (this.f552467h == false) goto L16;
        Function2<View, MotionEvent, Unit> r104 = this.f552462c;
        if (r104 == null) goto L16;
        r104.invoke(r110, r111);
    L16:
        return true;
    L33:
        if ((System.currentTimeMillis() - this.f552468i) >= 800) goto L35;
        return true;
    L35:
        this.f552467h = false;
        ?? r114 = new d(this, r110);
        this.f552466g = r114;
        r110.postDelayed(r114, this.f552465f);
        return true;
    }

    public e(Function1 r100, Function1 r101, Function2 r102, Function2 r103, com.larus.bmhome.chat.component.bottom.voice.n r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r105 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r105 & 32) == 0) goto L20;
        long r106 = 500;
    L21:
        this.f552460a = r100;
        this.f552461b = r101;
        this.f552462c = r102;
        this.f552463d = r103;
        this.f552464e = r104;
        this.f552465f = r106;
        return;
    L20:
        r106 = 0;
        goto L21
    }
}
