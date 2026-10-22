package q32;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.highlight.indicator.DuxBaseIndicator;
import com.bytedance.android.livesdk.interactivity.api.highlight.indicator.LiveDuxCarouselIndicator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LiveDuxCarouselIndicator f531494c;

    @Override // q32.c
    public final int a() {
        return this.f531494c.f133225a.size();
    }

    public b(LiveDuxCarouselIndicator r100) {
        this.f531494c = r100;
    }

    @Override // q32.c
    public final void d(int r100) {
        a.a((View) ListProtector.get(this.f531494c.f133225a, r100), (int) this.f531494c.getDotsSize());
        this.f531494c.c(r100);
    }

    @Override // q32.c
    public final void c(int r100, int r110, float r111) {
        ArrayList<View> r101 = this.f531494c.f133225a;
        Intrinsics.checkNotNullParameter(r101, "$this$isInBounds");
        int r102 = r101.size();
        boolean r103 = false;
        if (r100 < 0) goto L7;
        if (r102 <= r100) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
        return;
    L10:
        View r105 = (View) ListProtector.get(this.f531494c.f133225a, r100);
        float r106 = 1;
        a.a(r105, (int) (this.f531494c.getDotsSize() + ((this.f531494c.getDotsSize() * (this.f531494c.getDotsWidthFactor() - r106)) * (r106 - r111))));
        ArrayList<View> r107 = this.f531494c.f133225a;
        Intrinsics.checkNotNullParameter(r107, "$this$isInBounds");
        int r108 = r107.size();
        if (r110 < 0) goto L15;
        if (r108 <= r110) goto L15;
        r103 = true;
    L15:
        if (r103 == false) goto L40;
        View r112 = (View) ListProtector.get(this.f531494c.f133225a, r110);
        a.a(r112, (int) (this.f531494c.getDotsSize() + ((this.f531494c.getDotsSize() * (this.f531494c.getDotsWidthFactor() - r106)) * r111)));
        Drawable r109 = r105.getBackground();
        if (r109 == null) goto L39;
        GradientDrawable r113 = (GradientDrawable) r109;
        Drawable r114 = r112.getBackground();
        if (r114 == null) goto L37;
        GradientDrawable r115 = (GradientDrawable) r114;
        if (this.f531494c.getSelectedDotColor() == this.f531494c.getDotsColor()) goto L40;
        LiveDuxCarouselIndicator r116 = this.f531494c;
        Object r117 = r116.f133242m.evaluate(r111, Integer.valueOf(r116.getSelectedDotColor()), Integer.valueOf(this.f531494c.getDotsColor()));
        if (r117 == null) goto L35;
        int r118 = ((Integer) r117).intValue();
        LiveDuxCarouselIndicator r119 = this.f531494c;
        Object r120 = r119.f133242m.evaluate(r111, Integer.valueOf(r119.getDotsColor()), Integer.valueOf(this.f531494c.getSelectedDotColor()));
        if (r120 == null) goto L33;
        r115.setColor(((Integer) r120).intValue());
        DuxBaseIndicator.a r121 = this.f531494c.getPager();
        if (r121 != null) goto L29;
    L31:
        r113.setColor(r118);
        goto L40
    L29:
        if (r100 != r121.getCurrentItem()) goto L31;
        r113.setColor(this.f531494c.getSelectedDotColor());
        goto L40
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L40:
        this.f531494c.invalidate();
        return;
    L7:
        r104 = false;
        goto L8
    }
}
