package f4c;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import kotlin.jvm.internal.Intrinsics;
import w3c.j;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements b08.b<UserStatusLinearLayout, j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f475605a = null;

    static {
        f475605a = new i();
    }

    public i() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        UserStatusLinearLayout r101 = (UserStatusLinearLayout) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r110, j r111) {
        UserStatusLinearLayout r100 = (UserStatusLinearLayout) r110;
        j r112 = r111;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r112, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r112.f558247c != null) goto L5;
        r100.setVisibility(8);
        return;
    L5:
        r100.setVisibility(0);
        Integer r101 = r112.f558245a;
        if (r101 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r100.setTextColor(r101.intValue());
    L8:
        int r102 = r112.f558251g;
        String r103 = r112.f558247c;
        if (r103 == null) goto L11;
        int r104 = r103.length();
    L12:
        int r105 = Math.min(r102, r104);
        if (r105 < 0) goto L24;
        Drawable r106 = r112.f558246b;
        int r107 = r100.getPaddingStart() + r100.getPaddingEnd();
        View[] r108 = {r100.f461150a, r100.f461151b};
        int r109 = 0;
        int r113 = 0;
    L15:
        if (r109 >= 2) goto L20;
        View r114 = r108[r109];
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        r113 = r113 + (r116.getMarginStart() + r116.getMarginEnd());
    L19:
        r107 = r107 + (r114.getPaddingStart() + r114.getPaddingEnd());
        r109 = r109 + 1;
        goto L15
    L20:
        if (r106 == null) goto L22;
        int r117 = r106.getIntrinsicWidth();
    L23:
        r100.setMinimumWidth((int) (((r113 + r107) + r117) + (r105 * r100.f461151b.getTextSize())));
        goto L24
    L22:
        r117 = 0;
    L24:
        String r118 = r112.f558247c;
        if (r118 == null) goto L38;
        String r119 = r112.f558248d;
        String r120 = r112.f558249e;
        if (r119 == null) goto L31;
        if (r120 == null) goto L31;
        r100.setNeedToRecognize(true);
        r100.b(r118, r119, r112.f558246b, false, r120, r112.f558250f);
        return;
    L31:
        r100.setNeedToRecognize(false);
        r100.f461150a.setImageDrawable(r112.f558246b);
        r100.f461151b.G(r118, null);
        r100.f461152c = r118;
        return;
    L38:
        return;
    L11:
        r104 = -1;
        goto L12
    }
}
