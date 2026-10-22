package sz7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.imageview.LKUIBadgeDrawable2;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class u<T extends ImageView> extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f544032a;

    public u(T r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        this.f544032a = r100;
    }

    public final void a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "iconViewData");
        Drawable r100 = r110.f543982a;
        if (r100 == null) goto L5;
        this.f544032a.setImageDrawable(r100);
        return;
    L5:
        String r101 = r110.f543983b;
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L22;
        int r104 = t.f544031a;
        s r105 = t.a.a(this.f544032a.getContext());
        int r106 = r110.f543987f;
        int r107 = r110.f543988g;
        r105.f544025c = r106;
        r105.f544026d = r107;
        r105.f544027e = r110.f543983b;
        r105.f544028f = r110.f543984c;
        r105.f544029g = r110.f543985d;
        r105.f544030h = r110.f543986e;
        T r108 = this.f544032a;
        Intrinsics.checkNotNullParameter(r108, PickerReporterConstants.KEY.TARGET);
        String r109 = r105.f544027e;
        if (r109 != null) goto L16;
    L19:
        if (r102 == false) goto L21;
        r108.setImageDrawable(r105.f544030h);
        return;
    L21:
        r105.f544024b.a(r105.f544023a, r109, r105.f544029g, r105.f544025c, r105.f544026d, r108);
        return;
    L16:
        if (r109.length() == 0) goto L19;
        r102 = false;
        goto L19
    L22:
        this.f544032a.setImageDrawable(r110.f543986e);
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r103 = false;
        goto L12
    }

    public final void b(x r110) {
        Intrinsics.checkNotNullParameter(r110, "miniIconViewData");
        int r100 = LKUIBadgeDrawable2.f284145i;
        T r101 = this.f544032a;
        Intrinsics.checkNotNullParameter(r101, "view");
        LKUIBadgeDrawable2.b r102 = LKUIBadgeDrawable2.a.a(r101, 0).c();
        Drawable r103 = r110.f544038a;
        if (r103 == null) goto L13;
        Context r104 = this.f544032a.getContext();
        int r105 = (int) j08.b.a(r104, 1.5f);
        GradientDrawable r106 = new GradientDrawable();
        r106.setShape(1);
        if (r110.f544039b <= 0) goto L10;
        int r107 = Math.max(r103.getIntrinsicWidth(), r103.getIntrinsicHeight());
        int r108 = r105 * 2;
        int r109 = r107 + r108;
        int r111 = r110.f544039b;
        if (r109 <= r111) goto L10;
        int r112 = r111 - r108;
        r103.setBounds(0, 0, r112, r112);
        int r113 = r110.f544039b;
        r106.setSize(r113, r113);
    L11:
        r106.setColor(ContextCompat.getColor(r104, R.color.lkui_N50));
        r102.f284160g = r103;
        r102.f284163j = 2;
        r102.f284162i = r106;
        r102.f284165l.setVisible(true, false);
        if (r102.a() == null) goto L13;
        return;
    L10:
        int r114 = r105 * 2;
        r106.setSize(r103.getIntrinsicWidth() + r114, r103.getIntrinsicWidth() + r114);
    L13:
        r102.f284165l.setVisible(false, false);
        r102.a();
    }
}
