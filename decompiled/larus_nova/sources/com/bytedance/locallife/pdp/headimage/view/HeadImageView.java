package com.bytedance.locallife.pdp.headimage.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import hx6.c;
import hx6.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/pdp/headimage/view/HeadImageView;", "Landroid/widget/FrameLayout;", "Lhx6/d;", "pageSelectListener", "", "setOnPageSelectListener", "Lhx6/c;", "pageScrollListener", "setOnPageScrollListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class HeadImageView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f261472f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager2 f261473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HeadImageItemAdapter f261474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Integer> f261475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, Integer> f261476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f261477e;

    public HeadImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeadImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnPageScrollListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "pageScrollListener");
    }

    public final void setOnPageSelectListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "pageSelectListener");
        this.f261477e = r100;
    }

    public static final void a(HeadImageView r100, int r101) {
        ViewParent r102 = r100.f261473a.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r103 = (ViewGroup) r102;
        if (r103.getHeight() == r101) goto L10;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L8;
        r104.height = r101;
    L8:
        r103.requestLayout();
        return;
    }

    public final void b(int r100, RecyclerView r101) {
        RecyclerView.ViewHolder r102 = r101.findViewHolderForAdapterPosition(r100);
        if (r102 == null) goto L9;
        View r103 = r102.itemView;
        if (r103 == null) goto L10;
        r103.measure(View.MeasureSpec.makeMeasureSpec(r103.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r104 = r103.getMeasuredHeight();
        Integer r105 = Integer.valueOf(r100);
        Integer r106 = Integer.valueOf(r104);
        this.f261476d.put(r105, r106);
        return;
    L10:
        return;
    }

    public HeadImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f261475c = new LinkedHashMap();
        this.f261476d = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.life_pdp_head_image_view, this, true);
        ViewPager2 r103 = (ViewPager2) findViewById(R.id.viewpager);
        this.f261473a = r103;
        r103.setOrientation(0);
        View r104 = r103.getChildAt(0);
        if ((r104 instanceof RecyclerView) == false) goto L5;
        RecyclerView r105 = (RecyclerView) r104;
    L6:
        if (r105 == null) goto L9;
        r105.setNestedScrollingEnabled(false);
    L9:
        r103.registerOnPageChangeCallback(new AnonymousClass1(this));
        HeadImageItemAdapter r106 = new HeadImageItemAdapter(null);
        this.f261474b = r106;
        r103.setAdapter(r106);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ HeadImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
