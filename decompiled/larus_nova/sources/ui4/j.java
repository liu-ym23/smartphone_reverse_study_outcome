package ui4;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class j<DATA> implements ti4.x<DATA, BaseMediaViewHolder.a>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f550168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f550169c;

    public static class a extends j<ki4.r> {
        public a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public final View d() {
        return (View) this.f550168b.getValue();
    }

    public j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f550167a = r100;
        this.f550168b = LazyKt.lazy(new g(this));
        this.f550169c = LazyKt.lazy(new h(this));
    }

    @Override // ti4.x
    public final void c(Object r100, int r101, BaseMediaViewHolder.a r102) {
        BaseMediaViewHolder.a r103 = r102;
        Intrinsics.checkNotNullParameter(r103, "state");
        boolean r104 = true;
        float r105 = 1.0f;
        if (r103.e().isSelected() == false) goto L6;
        float r106 = 1.1f;
        float r107 = 1.0f;
        boolean r108 = true;
    L11:
        if (d().getAlpha() != r105) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == true) goto L17;
        d().setAlpha(r105);
    L17:
        if (d().getScaleX() == r106) goto L20;
        r104 = false;
    L20:
        if (r104 == false) goto L22;
        return;
    L22:
        if (r103.a() == false) goto L32;
        d().animate().scaleY(r106).scaleX(r106).setDuration(300).start();
        final View r110 = (View) this.f550169c.getValue();
        if (r110 == null) goto L39;
        if (r108 == true) goto L27;
        ci4.a.a(r110, false);
    L27:
        ViewPropertyAnimator r111 = r110.animate().alpha(r107).setDuration(300);
        if (r108 == false) goto L30;
        r111.withStartAction(new i(r110));
    L30:
        r111.start();
        return;
    L39:
        return;
    L32:
        if (r103.f() == true) goto L34;
        d().setScaleX(r106);
        d().setScaleY(r106);
    L34:
        View r112 = (View) this.f550169c.getValue();
        if (r112 == null) goto L41;
        ci4.a.a(r112, r108);
        return;
    L41:
        return;
    L13:
        r109 = false;
        goto L14
    L6:
        if (r103.d() == true) goto L8;
        float r113 = 0.3f;
    L9:
        r107 = 0.0f;
        r105 = r113;
        r106 = 1.0f;
        r108 = false;
        goto L11
    L8:
        r113 = 1.0f;
        goto L9
    }
}
