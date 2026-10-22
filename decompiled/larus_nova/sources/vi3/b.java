package vi3;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f555300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShopContainerType f555301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f555302c;

    public final ShopContainerType getType() {
        return this.f555301b;
    }

    public b(ShopContainerType r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f555301b = r100;
        this.f555302c = r101;
        c r102 = c.f555303f;
        this.f555300a = c.f555303f;
    }

    public final boolean a(c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        if ((!Intrinsics.areEqual(r100, this.f555300a)) == false) goto L14;
        this.f555300a = r100;
        if (r101 == false) goto L13;
        ViewGroup.LayoutParams r102 = this.f555302c.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r102 = null;
    L9:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L12;
        r103.width = r100.f555307c;
        r103.height = r100.f555308d;
        Rect r104 = r100.f555309e;
        r103.topMargin = r104.top;
        r103.bottomMargin = r104.bottom;
        r103.rightMargin = r104.right;
        r103.leftMargin = r104.left;
    L12:
        this.f555302c.requestLayout();
    L13:
        return true;
    L14:
        return false;
    }
}
