package vi3;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T extends View> {
    public c a;
    public final ShopContainerType b;
    public final T c;

    public final ShopContainerType getType() {
        return this.b;
    }

    public b(ShopContainerType r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "view");
        this.b = r2;
        this.c = r3;
        c r4 = c.f;
        this.a = c.f;
    }

    public final boolean a(c r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        if ((!Intrinsics.areEqual(r3, this.a)) == false) goto L14;
        this.a = r3;
        if (r4 == false) goto L13;
        ViewGroup.LayoutParams r5 = this.c.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r5 = null;
    L9:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (r6 == null) goto L12;
        r6.width = r3.c;
        r6.height = r3.d;
        Rect r7 = r3.e;
        r6.topMargin = r7.top;
        r6.bottomMargin = r7.bottom;
        r6.rightMargin = r7.right;
        r6.leftMargin = r7.left;
    L12:
        this.c.requestLayout();
    L13:
        return true;
    L14:
        return false;
    }
}
