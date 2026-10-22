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
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import r14.w;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<i, l> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f196183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AutoWrapRtlViewPager f196184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f196185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<w> f196186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f196187i;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        l r100 = (l) this.f195898c;
        Observer<List<w>> r101 = new f(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "observer");
        r100.f196198a.a(r101);
        Lazy r102 = AoBizCardSettingsConfig.f196133b;
        if (((String) r102.getValue()).length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L14;
        Drawable r104 = b().getBackground();
        if ((r104 instanceof GradientDrawable) == false) goto L10;
        GradientDrawable r105 = (GradientDrawable) r104;
    L11:
        if (r105 == null) goto L15;
        r105.setColor(ColorProtector.parseColor((String) r102.getValue()));
        return;
    L15:
        return;
    L10:
        r105 = null;
        goto L11
    L14:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void d() {
        List<w> r100 = this.f196186h;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        List<w> r102 = this.f196186h;
        Intrinsics.checkNotNull(r102);
        int r103 = r102.size();
        int r104 = this.f196187i;
        if (r104 >= 0) goto L12;
        return;
    L12:
        if (r104 < r103) goto L14;
        return;
    L14:
        List<w> r105 = this.f196186h;
        Intrinsics.checkNotNull(r105);
        w r106 = (w) ListProtector.get(r105, this.f196187i);
        r106.j(this.f196187i);
        i r107 = (i) this.f195897b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "hostExpand");
        r107.f196189b.b(r106);
        return;
    L5:
        if (r100.isEmpty() != true) goto L7;
        r101 = true;
        goto L7
    }

    public final void e() {
        LinearLayout r100 = this.f196185g;
        int r101 = 0;
        if (r100 == null) goto L13;
        List<w> r102 = this.f196186h;
        if (r102 == null) goto L8;
        int r103 = r102.size();
    L9:
        if (r103 <= 1) goto L11;
        int r104 = 0;
    L12:
        r100.setVisibility(r104);
        goto L13
    L11:
        r104 = 8;
        goto L12
    L8:
        r103 = 0;
    L13:
        LinearLayout r105 = this.f196185g;
        if (r105 == null) goto L16;
        r105.removeAllViews();
    L16:
        List<w> r106 = this.f196186h;
        if (r106 == null) goto L19;
        int r107 = r106.size();
    L20:
        if (r107 > 1) goto L22;
        return;
    L22:
        if (r101 >= r107) goto L34;
        ImageView r108 = new ImageView(getContext());
        if (r101 != this.f196187i) goto L26;
        int r109 = R.drawable.aos_left_component_dot_select;
    L27:
        r108.setBackgroundResource(r109);
        int r110 = com.bytedance.awemeopen.infra.util.e.a(getContext(), 4.0f);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(r110, r110);
        if (r101 == 0) goto L30;
        r111.leftMargin = com.bytedance.awemeopen.infra.util.e.a(getContext(), 6.0f);
    L30:
        LinearLayout r112 = this.f196185g;
        if (r112 == null) goto L33;
        r112.addView(r108, r111);
    L33:
        r101 = r101 + 1;
        goto L22
    L26:
        r109 = R.drawable.aos_left_component_dot_unselect;
        goto L27
    L34:
        return;
    L19:
        r107 = 0;
        goto L20
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(getContext()).inflate(R.layout.aos_common_feed_left_component, r100, false);
    }

    public h(Context r100, i r101, l r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r103, "contentScene");
        super(r100, r101, r102);
        this.f196183e = r103;
    }
}
