package com.bytedance.ee.bear.sheet.filter;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b&\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u00010\u00132\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00108\u001a\u00020.H\u0016J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u001a\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020BH$J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020.H\u0002J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u00020.H\u0016J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u001eH\u0014J#\u0010J\u001a\u00020.\"\u0004\b\u0000\u0010K2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u0002HKH\u0004¢\u0006\u0002\u0010NJ-\u0010J\u001a\u00020.\"\u0004\b\u0000\u0010K2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u0002HK2\b\u0010O\u001a\u0004\u0018\u00010DH\u0004¢\u0006\u0002\u0010PR\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020\u001eX¤\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0012\u0010+\u001a\u00020$X¤\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/BaseSubFilterFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Lcom/bytedance/ee/bear/sheet/common/SheetDragView$OnPositionChangeListener;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;", "setViewModel", "(Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;)V", "dragView", "Lcom/bytedance/ee/bear/sheet/common/SheetDragView;", "getDragView", "()Lcom/bytedance/ee/bear/sheet/common/SheetDragView;", "setDragView", "(Lcom/bytedance/ee/bear/sheet/common/SheetDragView;)V", "topView", "Landroid/view/View;", "getTopView", "()Landroid/view/View;", "setTopView", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "filterCol", "filterColPre", "filterColNext", "currentCol", "", "getCurrentCol", "()I", "setCurrentCol", "(I)V", "sheetId", "", "getSheetId", "()Ljava/lang/String;", "setSheetId", "(Ljava/lang/String;)V", "layoutResId", "getLayoutResId", "panelName", "getPanelName", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", LiveCommonConstants.REASON_ON_DEDTROY, "updateData", "filterData", "Lcom/bytedance/ee/bear/sheet/filter/FilterData;", "updateTopViews", "filterItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterItem;", "curTitle", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "onKeyEventBackPressed", "", "exitFragment", "onChangeToMidPosition", "onChangeToMaxPosition", "notifyColRangeChanged", "index", "callback", ExifInterface.GPS_DIRECTION_TRUE, "id", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "isSearch", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)V", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubFilterFragment extends BaseFragment implements ocb.a, SheetDragView.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f237658n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FilterViewModel f237659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SheetDragView f237660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f237661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f237662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f237663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f237664j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f237665k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f237666l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f237667m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSubFilterFragment f237668a;

        public b(BaseSubFilterFragment r100) {
            this.f237668a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BaseSubFilterFragment r101 = this.f237668a;
            int r102 = BaseSubFilterFragment.f237658n;
            r101.V90();
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSubFilterFragment f237669a;

        public c(BaseSubFilterFragment r100) {
            this.f237669a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            FilterData r111 = (FilterData) r110;
            BaseSubFilterFragment r100 = this.f237669a;
            int r101 = BaseSubFilterFragment.f237658n;
            r100.getClass();
            if (r111 == null) goto L64;
            FilterData.FilterItem r112 = r111.getData();
            if (r112 == null) goto L67;
            FilterData.ColRange r102 = r112.getColRange();
            boolean r103 = false;
            if (r102 == null) goto L9;
            int r104 = r102.getIndex();
        L10:
            r100.f237666l = r104;
            r100.f237667m = r112.getSheetId();
            FilterData.FilterSheetItem[] r105 = r112.getItems();
            if (r105 != null) goto L13;
            r105 = new FilterData.FilterSheetItem[0];
        L13:
            int r106 = r105.length;
            int r107 = 0;
        L14:
            if (r107 >= r106) goto L69;
            FilterData.FilterSheetItem r108 = r105[r107];
            if (Intrinsics.areEqual(r108.getId(), r100.Y90()) == true) goto L17;
            r107 = r107 + 1;
            goto L14
        L17:
            String r109 = r108.getTitle();
            TextView r113 = r100.f237662h;
            TextView r114 = null;
            if (r113 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("title");
            r113 = null;
        L20:
            r113.setText(r109);
            TextView r115 = r100.f237663i;
            if (r115 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("filterCol");
            r115 = null;
        L23:
            r115.setText(r112.getTitle());
            FilterData.ColRange r116 = r112.getColRange();
            if (r116 == null) goto L26;
            int r117 = r116.getIndex();
        L27:
            FilterData.ColRange r118 = r112.getColRange();
            if (r118 == null) goto L30;
            int r119 = r118.getTotal();
        L31:
            TextView r120 = r100.f237664j;
            if (r120 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("filterColPre");
            r120 = null;
        L35:
            if (r117 == 1) goto L37;
            boolean r121 = true;
        L38:
            r120.setEnabled(r121);
            TextView r122 = r100.f237664j;
            if (r122 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("filterColPre");
            r122 = null;
        L41:
            if (r117 == 1) goto L43;
            boolean r123 = true;
        L44:
            r122.setClickable(r123);
            TextView r124 = r100.f237665k;
            if (r124 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("filterColNext");
            r124 = null;
        L47:
            if (r117 == r119) goto L49;
            boolean r125 = true;
        L50:
            r124.setEnabled(r125);
            TextView r126 = r100.f237665k;
            if (r126 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("filterColNext");
            r126 = null;
        L53:
            if (r117 == r119) goto L55;
            r103 = true;
        L55:
            r126.setClickable(r103);
            TextView r127 = r100.f237664j;
            if (r127 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("filterColPre");
            r127 = null;
        L58:
            r127.setOnClickListener(new com.bytedance.ee.bear.sheet.filter.a(r100, r117));
            TextView r128 = r100.f237665k;
            if (r128 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("filterColNext");
        L62:
            r114.setOnClickListener(new com.bytedance.ee.bear.sheet.filter.b(r100, r117));
            r100.ba0(r108);
            return;
        L61:
            r114 = r128;
            goto L62
        L49:
            r125 = false;
            goto L50
        L43:
            r123 = false;
            goto L44
        L37:
            r121 = false;
            goto L38
        L30:
            r119 = 0;
            goto L31
        L26:
            r117 = 0;
            goto L27
        L69:
            return;
        L9:
            r104 = 0;
            goto L10
        L67:
            return;
        }
    }

    public static final class d implements qm5.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseSubFilterFragment f237670a;

        @Override // qm5.d.a
        public final void exit() {
            BaseSubFilterFragment r100 = this.f237670a;
            int r101 = BaseSubFilterFragment.f237658n;
            r100.V90();
        }

        public d(BaseSubFilterFragment r100) {
            this.f237670a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public void Q5() {
    }

    @Override // com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public void W6() {
    }

    public abstract int X90();

    public abstract String Y90();

    public abstract void ba0(FilterData.FilterSheetItem r100);

    public final SheetDragView W90() {
        SheetDragView r100 = this.f237660f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
        return null;
    }

    public final FilterViewModel Z90() {
        FilterViewModel r100 = this.f237659e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final boolean S90() {
        V90();
        return true;
    }

    public final void V90() {
        rcb.c.c(getContext());
        Z90().clearFilterPageData();
        T90(R.anim.child_fragment_exit);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        FragmentActivity r100 = getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        pcb.a.AbstractC7181a.b(r100).a(this);
        Z90().clearFilterPageData();
        super.onDestroy();
    }

    public BaseSubFilterFragment() {
    }

    public void aa0(int r100) {
        U90("colRange", Integer.valueOf(r100));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        FilterViewModel r101 = (FilterViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, FilterViewModel.class);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f237659e = r101;
        FragmentActivity r102 = getActivity();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        pcb.a.AbstractC7181a.b(r102).c(this);
    }

    public final <T> void U90(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r100, "id");
        Z90().callback(r100, this.f237667m, this.f237666l, r101, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = r100.findViewById(R.id.title_bar_layout);
        r102.findViewById(R.id.back_icon).setOnClickListener(new b(this));
        SheetDragView r103 = (SheetDragView) r100.getRootView().findViewById(R.id.fab_dragview);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f237660f = r103;
        W90().setOnPositionChangeListener(this);
        W90().setSlideView(r102);
        View r104 = r100.findViewById(R.id.sheet_filter_subfragment_top_layout);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f237661g = r104;
        TextView r105 = (TextView) r102.findViewById(R.id.title);
        this.f237662h = r105;
        TextView r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r105 = null;
    L5:
        r105.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        TextView r107 = this.f237662h;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L9:
        r106.getPaint().setStrokeWidth(1.0f);
        this.f237663i = (TextView) r100.findViewById(R.id.sheet_filter_col);
        this.f237664j = (TextView) r100.findViewById(R.id.sheet_filter_col_pre);
        this.f237665k = (TextView) r100.findViewById(R.id.sheet_filter_col_next);
        Z90().getFilterData().observe(this, new c(this));
        Map<String, String> r108 = qm5.d.f533877a;
        qm5.d.a(this, getFragmentManager(), Integer.valueOf(R.id.filter_panel_container), new d(this));
        return;
    L8:
        r106 = r107;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(X90(), r101, false);
    }
}
