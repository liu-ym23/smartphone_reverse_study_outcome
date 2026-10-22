package l3b;

import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f507295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507296b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f507295a == r101.f507295a) goto L12;
        return false;
    L12:
        if (this.f507296b == r101.f507296b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f507295a * 31) + this.f507296b;
    }

    public final String toString() {
        return "OpenCellLayoutConfig(startMarginDp=" + this.f507295a + ", avatarMarginDp=" + this.f507296b + ')';
    }

    public c() {
        this.f507295a = 12;
        this.f507296b = 6;
    }

    public final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        if (r101 == false) goto L5;
        int r102 = R.id.right_spacer;
    L6:
        View r103 = r100.findViewById(r102);
        if (r103 == null) goto L9;
        int r104 = this.f507295a;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        r105.width = UIUtils.dp2px(r103.getContext(), r104);
        r103.setLayoutParams(r105);
    L9:
        View r106 = r100.findViewById(R.id.bubble_layout_avatar_slot);
        if (r106 == null) goto L22;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
    L15:
        if (r108 == null) goto L23;
        if (r101 == false) goto L19;
        r108.setMarginStart(UIUtils.dp2px(r100.getContext(), this.f507296b));
    L20:
        r106.setLayoutParams(r108);
        return;
    L19:
        r108.setMarginEnd(UIUtils.dp2px(r100.getContext(), this.f507296b));
        goto L20
    L23:
        return;
    L14:
        r108 = null;
        goto L15
    L22:
        return;
    L5:
        r102 = R.id.left_spacer;
        goto L6
    }
}
