package com.bytedance.locallife.poi.view.mall.filter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.poi.view.mall.model.FilterLevel;
import com.bytedance.locallife.poi.view.mall.model.MallFilterStruct;
import com.bytedance.locallife.poi.view.mall.model.SelectorType;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PoiMallFilterPanelView extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f264244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f264245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f264246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f264247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PoiMallFilterAdapter f264248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PoiMallFilterAdapter f264249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f264250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f264251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SelectorType f264252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f264253j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/filter/PoiMallFilterPanelView$SelectorLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class SelectorLayoutManager extends LinearLayoutManager {
        public SelectorLayoutManager(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void setMeasuredDimension(Rect r100, int r101, int r102) {
            super.setMeasuredDimension(r100, r101, View.MeasureSpec.makeMeasureSpec(com.bytedance.locallife.dito.utils.e.b(384), Integer.MIN_VALUE));
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMallFilterPanelView f264254a;

        public a(PoiMallFilterPanelView r100) {
            this.f264254a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            PoiMallFilterPanelView r101 = this.f264254a;
            PopupWindowLancet.handleDismissBeforeOrigin(r101);
            r101.b(false);
        }
    }

    public static final class b {
    }

    public interface c {
        void a(MallFilterStruct r100, MallFilterStruct r101);
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMallFilterPanelView f264255a;

        public d(PoiMallFilterPanelView r100) {
            this.f264255a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Integer) == false) goto L5;
            Integer r102 = (Integer) r101;
        L6:
            if (r102 == null) goto L8;
            int r103 = r102.intValue();
        L9:
            ViewGroup.LayoutParams r104 = this.f264255a.f264247d.getLayoutParams();
            r104.height = r103;
            this.f264255a.f264247d.setLayoutParams(r104);
            return;
        L8:
            r103 = 0;
            goto L9
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f264256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiMallFilterPanelView f264257b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f264256a == false) goto L6;
            this.f264257b.getContentView().setVisibility(0);
            return;
        }

        public e(boolean r100, PoiMallFilterPanelView r101) {
            this.f264256a = r100;
            this.f264257b = r101;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f264256a == false) goto L5;
            ViewGroup.LayoutParams r102 = this.f264257b.f264247d.getLayoutParams();
            r102.height = -2;
            this.f264257b.f264247d.setLayoutParams(r102);
            return;
        L5:
            PoiMallFilterPanelView.a(this.f264257b);
        }
    }

    public static final class f implements PoiMallFilterAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMallFilterPanelView f264258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PoiMallFilterAdapter f264259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List<MallFilterStruct> f264260c;

        @Override // com.bytedance.locallife.poi.view.mall.filter.PoiMallFilterAdapter.a
        public final void a(View r100, MallFilterStruct r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            boolean r102 = true;
            if (this.f264258a.f264251h == 1) goto L7;
            r102 = false;
        L7:
            if (r102 == true) goto L9;
        L13:
            c r103 = this.f264258a.f264250g;
            if (r103 == null) goto L19;
            r103.a(r101, null);
            return;
        L19:
            return;
        L9:
            if (r101.getChildOptions() == null) goto L13;
            this.f264259b.notifyDataSetChanged();
            this.f264258a.e(r101.getChildOptions(), this.f264260c);
            c r104 = this.f264258a.f264250g;
            if (r104 == null) goto L17;
            r104.a(r101, null);
            return;
        }

        public f(PoiMallFilterPanelView r100, PoiMallFilterAdapter r101, List<MallFilterStruct> r102) {
            this.f264258a = r100;
            this.f264259b = r101;
            this.f264260c = r102;
        }
    }

    public static final class g implements PoiMallFilterAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiMallFilterPanelView f264261a;

        public g(PoiMallFilterPanelView r100) {
            this.f264261a = r100;
        }

        @Override // com.bytedance.locallife.poi.view.mall.filter.PoiMallFilterAdapter.a
        public final void a(View r100, MallFilterStruct r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            PoiMallFilterPanelView r102 = this.f264261a;
            c r103 = r102.f264250g;
            if (r103 == null) goto L10;
            PoiMallFilterAdapter r104 = r102.f264248e;
            if (r104 == null) goto L7;
            MallFilterStruct r105 = r104.f264237d;
        L8:
            r103.a(r105, r101);
            return;
        L7:
            r105 = null;
            goto L8
        }
    }

    static {
    }

    @Override // android.widget.PopupWindow
    public final void dismiss() {
        b(false);
    }

    public final Context getContext() {
        return this.f264244a;
    }

    public final SelectorType getType() {
        return this.f264252i;
    }

    public PoiMallFilterPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(LayoutInflater.from(r100).inflate(R.layout.saas_poi_layout_poi_mall_filter_panel_view, null));
        this.f264244a = r100;
        this.f264245b = (RecyclerView) getContentView().findViewById(R.id.poi_mall_filter_panel_first_level_list);
        this.f264246c = (RecyclerView) getContentView().findViewById(R.id.poi_mall_filter_panel_second_level_list);
        this.f264247d = (LinearLayout) getContentView().findViewById(R.id.poi_mall_selector_view);
        this.f264252i = SelectorType.NONE;
        getContentView().setOnClickListener(new a(this));
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.poi_mall_filter_panel_anim);
        setFocusable(false);
        setOutsideTouchable(false);
    }

    public static final void a(PoiMallFilterPanelView r100) {
        r100.getClass();
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        super.dismiss();
    }

    public final void b(boolean r110) {
        if (r110 == false) goto L4;
        int r100 = this.f264253j;
    L5:
        int[] r101 = new int[2];
        if (r110 == false) goto L8;
        int r102 = 0;
    L9:
        r101[0] = r102;
        if (r110 == true) goto L13;
        r100 = 0;
    L13:
        r101[1] = r100;
        ValueAnimator r103 = ValueAnimator.ofInt(r101);
        r103.setDuration(200);
        r103.addUpdateListener(new d(this));
        View r104 = getContentView();
        float[] r105 = new float[2];
        float r106 = 0.0f;
        if (r110 == false) goto L16;
        float r107 = 0.0f;
    L17:
        r105[0] = r107;
        if (r110 == false) goto L20;
        r106 = 1.0f;
    L20:
        r105[1] = r106;
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r104, "alpha", r105);
        AnimatorSet r109 = new AnimatorSet();
        r109.setDuration(200);
        r109.play(r103).with(r108);
        r109.addListener(new e(r110, this));
        r109.start();
        return;
    L16:
        r107 = 1.0f;
        goto L17
    L8:
        r102 = r100;
        goto L9
    L4:
        r100 = this.f264247d.getHeight();
        goto L5
    }

    public final void d(List<MallFilterStruct> r100) {
        PoiMallFilterAdapter r101 = this.f264248e;
        if (r101 != null) goto L5;
        PoiMallFilterAdapter r102 = new PoiMallFilterAdapter();
        r102.y2(r100, r100, FilterLevel.FIRST_LEVEL);
        f r103 = new f(this, r102, r100);
        Intrinsics.checkNotNullParameter(r103, "listener");
        r102.f264236c = r103;
        this.f264248e = r102;
        this.f264245b.setAdapter(r102);
        this.f264245b.setLayoutManager(new SelectorLayoutManager(this.f264244a));
        return;
    L5:
        r101.y2(r100, r100, FilterLevel.FIRST_LEVEL);
        r101.notifyDataSetChanged();
        this.f264245b.scrollToPosition(0);
    }

    public final void e(List<MallFilterStruct> r100, List<MallFilterStruct> r101) {
        PoiMallFilterAdapter r102 = this.f264249f;
        if (r102 != null) goto L5;
        PoiMallFilterAdapter r103 = new PoiMallFilterAdapter();
        r103.y2(r100, r101, FilterLevel.SECOND_LEVEL);
        g r104 = new g(this);
        Intrinsics.checkNotNullParameter(r104, "listener");
        r103.f264236c = r104;
        this.f264249f = r103;
        this.f264246c.setAdapter(r103);
        this.f264246c.setLayoutManager(new SelectorLayoutManager(this.f264244a));
        return;
    L5:
        if (r102 == null) goto L7;
        r102.y2(r100, r101, FilterLevel.SECOND_LEVEL);
        r102.notifyDataSetChanged();
    L7:
        this.f264246c.scrollToPosition(0);
    }

    public final void c(SelectorType r100, MallFilterStruct r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f264251h = r102;
        this.f264252i = r100;
        int r103 = 0;
        boolean r104 = true;
        if (r102 == 1) goto L6;
        r104 = false;
    L6:
        if (r104 == false) goto L19;
        ViewGroup.LayoutParams r105 = this.f264245b.getLayoutParams();
        r105.width = UIUtils.getScreenWidth(this.f264244a) / 3;
        ViewGroup.LayoutParams r106 = this.f264246c.getLayoutParams();
        r106.width = (UIUtils.getScreenWidth(this.f264244a) / 3) * 2;
        this.f264246c.setVisibility(0);
        d(r101.getChildOptions());
        List<MallFilterStruct> r107 = r101.getChildOptions();
        if (r107 == null) goto L17;
        Iterator<MallFilterStruct> r108 = r107.iterator();
    L11:
        if (r108.hasNext() == false) goto L17;
        MallFilterStruct r109 = r108.next();
        if (r109.isSelected() == false) goto L11;
        List<MallFilterStruct> r110 = r109.getChildOptions();
        if (r110 != null) goto L18;
        r110 = new ArrayList();
    L18:
        e(r110, r101.getChildOptions());
    L20:
        List<MallFilterStruct> r111 = r101.getChildOptions();
        if (r111 == null) goto L33;
        int r112 = r111.size() * 48;
        Iterator<MallFilterStruct> r113 = r111.iterator();
    L25:
        if (r113.hasNext() == false) goto L32;
        MallFilterStruct r114 = r113.next();
        if (r114.isSelected() == false) goto L25;
        List<MallFilterStruct> r115 = r114.getChildOptions();
        if (r115 == null) goto L31;
        r103 = r115.size();
    L31:
        r103 = r103 * 48;
    L32:
        r103 = com.bytedance.locallife.dito.utils.e.b(Integer.valueOf(RangesKt.coerceAtMost(Math.max(r112, r103), 384)));
    L33:
        this.f264253j = r103;
        return;
    L17:
        r110 = new ArrayList();
        goto L18
    L19:
        this.f264245b.getLayoutParams().width = -1;
        this.f264246c.getLayoutParams().width = 0;
        this.f264246c.setVisibility(4);
        d(r101.getChildOptions());
        e(new ArrayList(), null);
        goto L20
    }
}
