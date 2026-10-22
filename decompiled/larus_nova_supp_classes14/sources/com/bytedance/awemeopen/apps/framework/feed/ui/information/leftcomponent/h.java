package com.bytedance.awemeopen.apps.framework.feed.ui.information.leftcomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.AutoWrapRtlViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import r14.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<i, l> {
    public final String e;
    public AutoWrapRtlViewPager f;
    public LinearLayout g;
    public List<w> h;
    public int i;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        l r0 = (l) this.c;
        Observer<List<w>> r1 = new f(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        Lazy r2 = AoBizCardSettingsConfig.b;
        if (((String) r2.getValue()).length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L14;
        Drawable r4 = b().getBackground();
        if ((r4 instanceof GradientDrawable) == false) goto L10;
        GradientDrawable r5 = (GradientDrawable) r4;
    L11:
        if (r5 == null) goto L15;
        r5.setColor(ColorProtector.parseColor((String) r2.getValue()));
        return;
    L15:
        return;
    L10:
        r5 = null;
        goto L11
    L14:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void d() {
        List<w> r0 = this.h;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        List<w> r2 = this.h;
        Intrinsics.checkNotNull(r2);
        int r3 = r2.size();
        int r4 = this.i;
        if (r4 >= 0) goto L12;
        return;
    L12:
        if (r4 < r3) goto L14;
        return;
    L14:
        List<w> r5 = this.h;
        Intrinsics.checkNotNull(r5);
        w r6 = (w) ListProtector.get(r5, this.i);
        r6.j(this.i);
        i r7 = (i) this.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "hostExpand");
        r7.b.b(r6);
        return;
    L5:
        if (r0.isEmpty() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void e() {
        LinearLayout r0 = this.g;
        int r2 = 0;
        if (r0 == null) goto L13;
        List<w> r3 = this.h;
        if (r3 == null) goto L8;
        int r4 = r3.size();
    L9:
        if (r4 <= 1) goto L11;
        int r5 = 0;
    L12:
        r0.setVisibility(r5);
        goto L13
    L11:
        r5 = 8;
        goto L12
    L8:
        r4 = 0;
    L13:
        LinearLayout r1 = this.g;
        if (r1 == null) goto L16;
        r1.removeAllViews();
    L16:
        List<w> r6 = this.h;
        if (r6 == null) goto L19;
        int r7 = r6.size();
    L20:
        if (r7 > 1) goto L22;
        return;
    L22:
        if (r2 >= r7) goto L34;
        ImageView r8 = new ImageView(getContext());
        if (r2 != this.i) goto L26;
        int r9 = 2131231530;
    L27:
        r8.setBackgroundResource(r9);
        int r10 = com.bytedance.awemeopen.infra.util.e.a(getContext(), 4.0f);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(r10, r10);
        if (r2 == 0) goto L30;
        r11.leftMargin = com.bytedance.awemeopen.infra.util.e.a(getContext(), 6.0f);
    L30:
        LinearLayout r12 = this.g;
        if (r12 == null) goto L33;
        r12.addView(r8, r11);
    L33:
        r2 = r2 + 1;
        goto L22
    L26:
        r9 = 2131231531;
        goto L27
    L34:
        return;
    L19:
        r7 = 0;
        goto L20
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(getContext()).inflate(2131558614, r4, false);
    }

    public h(Context r2, i r3, l r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        Intrinsics.checkNotNullParameter(r5, "contentScene");
        super(r2, r3, r4);
        this.e = r5;
    }
}
