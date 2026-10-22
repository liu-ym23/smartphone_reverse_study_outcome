package rjb;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ViewUtils;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f538226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WeakReference<FrameLayout> f538227k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f538228a;

        public b(i r100) {
            this.f538228a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f538228a.isShowing() == false) goto L6;
            this.f538228a.close();
            return;
        }
    }

    static {
    }

    @Override // rjb.c, rjb.g
    public final void close() {
        WeakReference<FrameLayout> r100 = this.f538227k;
        if (r100 == null) goto L8;
        FrameLayout r101 = r100.get();
        if (r101 == null) goto L9;
        r101.removeView(this.f538226j);
        return;
    L9:
        return;
    }

    @Override // rjb.c, rjb.g
    public final boolean isShowing() {
        FrameLayout r100 = this.f538226j;
        if (r100 == null) goto L14;
        WeakReference<FrameLayout> r101 = this.f538227k;
        if (r101 == null) goto L17;
        FrameLayout r102 = r101.get();
        if (r102 == null) goto L18;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L20;
        if (Intrinsics.areEqual(r102.getChildAt(r104), r100) == true) goto L19;
        r104 = r104 + 1;
        goto L9
    L19:
        return true;
    L20:
        return false;
    L18:
        return false;
    L17:
        return false;
    L14:
        return false;
    }

    @Override // rjb.c, rjb.g
    public final boolean show() {
        View r100 = this.f538197a.f538185b;
        if (r100 != null) goto L7;
        Log.i("ViewGuidePopup", "params.anchorView is null");
        return false;
    L7:
        if (r100.getWindowToken() != null) goto L10;
        Log.i("ViewGuidePopup", "anchorView.windowToken is null, anchorView.isAttachedToWindow=" + r100.isAttachedToWindow());
        return false;
    L10:
        rjb.b r101 = this.f538197a.f538184a;
        if (r101 != null) goto L14;
        Log.i("ViewGuidePopup", "params.component is null");
        return false;
    L14:
        int r102 = h.f538224b;
        Intrinsics.checkNotNullParameter(r101, "component");
        h r103 = new h(r101);
        Context r104 = r100.getContext();
        if ((r104 instanceof Activity) == false) goto L18;
        Activity r105 = (Activity) r104;
    L24:
        Intrinsics.checkNotNull(r104);
        e(r104);
        this.f538203g = d(r104, r103);
        Rect r106 = c.b(r100);
        LinearLayout r107 = this.f538203g;
        Intrinsics.checkNotNull(r107);
        Point r108 = c(r103.a(r107, this.f538204h, r106), r103);
        int r109 = this.f538204h.getWidth();     // Catch: Exception -> L38
        int r110 = this.f538204h.getHeight();     // Catch: Exception -> L38
        if (r109 <= 0) goto L36;
        if (r110 <= 0) goto L36;
        FrameLayout r111 = (FrameLayout) r105.findViewById(R.id.content);     // Catch: Exception -> L38
        this.f538227k = new WeakReference(r111);     // Catch: Exception -> L38
        FrameLayout r112 = new FrameLayout(r104);     // Catch: Exception -> L38
        LinearLayout r113 = this.f538203g;     // Catch: Exception -> L38
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-2, -2);     // Catch: Exception -> L38
        r114.topMargin = r108.y;     // Catch: Exception -> L38
        r114.leftMargin = r108.x;     // Catch: Exception -> L38
        Unit r115 = Unit.INSTANCE;     // Catch: Exception -> L38
        r112.addView(r113, r114);     // Catch: Exception -> L38
        Boolean r116 = this.f538197a.f538186c;     // Catch: Exception -> L38
        if (r116 == null) goto L32;
        boolean r117 = r116.booleanValue();     // Catch: Exception -> L38
    L33:
        if (r117 == false) goto L35;
        r112.setOnClickListener(new b(this));     // Catch: Exception -> L38
    L35:
        this.f538226j = r112;     // Catch: Exception -> L38
        r111.addView(r112, new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L38
    L40:
        return false;
    L32:
        r117 = false;
    L36:
        Log.w("ViewGuidePopup", "show error, width=" + r109 + ", height=" + r110);     // Catch: Exception -> L38
        return false;
    L38:
        e = move-exception;
        Log.e("ViewGuidePopup", "show error", e);
        goto L40
    L18:
        if (this.f538197a.getActivity() == null) goto L20;
        r105 = this.f538197a.getActivity();
        goto L24
    L20:
        r105 = ViewUtils.getActivityByContext(r104);
        if (r105 != null) goto L24;
        Log.i("ViewGuidePopup", "not found activity");
        return false;
    }

    public i(rjb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
    }
}
