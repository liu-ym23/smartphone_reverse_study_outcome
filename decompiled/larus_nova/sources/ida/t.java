package ida;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class t {

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f489432a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        public a(boolean r100) {
            this.f489432a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            r100.removeOnAttachStateChangeListener(this);
            t.a(r100, this.f489432a);
        }
    }

    public static final void a(View r100, boolean r101) {
        if (r100.getParent() != null) goto L6;
        r100.addOnAttachStateChangeListener(new a(r101));
        return;
    L6:
        int r102 = 0;
        r100.setVisibility(0);
        Object r103 = r100.getParent();
        ViewGroup r104 = null;
        if ((r103 instanceof View) == false) goto L9;
        View r105 = (View) r103;
    L10:
        if (r105 != null) goto L13;
        return;
    L13:
        if (r101 == false) goto L15;
        int r106 = 0;
    L16:
        r105.setVisibility(r106);
        ViewParent r107 = r105.getParent();
        if ((r107 instanceof ViewGroup) == false) goto L19;
        r104 = (ViewGroup) r107;
    L19:
        if (r104 != null) goto L21;
        return;
    L21:
        int r108 = r104.indexOfChild(r105);
        if (r108 <= 0) goto L31;
        View r109 = r104.getChildAt(r108 - 1);
        if (r109 != null) goto L26;
        return;
    L26:
        if (r101 == true) goto L29;
        r102 = 8;
    L29:
        r109.setVisibility(r102);
        return;
    L31:
        return;
    L15:
        r106 = 8;
        goto L16
    L9:
        r105 = null;
        goto L10
    }
}
