package com.bytedance.ee.bear.sheet.filter;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b&\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u00010\u00132\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020\u00132\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00108\u001a\u00020.H\u0016J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u001a\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010@\u001a\u00020.2\u0006\u0010A\u001a\u00020BH$J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020.H\u0002J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u00020.H\u0016J\u0010\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u00020\u001eH\u0014J#\u0010J\u001a\u00020.\"\u0004\b\u0000\u0010K2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u0002HKH\u0004¢\u0006\u0002\u0010NJ-\u0010J\u001a\u00020.\"\u0004\b\u0000\u0010K2\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u0002HK2\b\u0010O\u001a\u0004\u0018\u00010DH\u0004¢\u0006\u0002\u0010PR\u001a\u0010\u0006\u001a\u00020\u0007X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0012\u0010)\u001a\u00020\u001eX¤\u0004¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0012\u0010+\u001a\u00020$X¤\u0004¢\u0006\u0006\u001a\u0004\b,\u0010&¨\u0006R"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/BaseSubFilterFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Lcom/bytedance/ee/bear/sheet/common/SheetDragView$OnPositionChangeListener;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;", "setViewModel", "(Lcom/bytedance/ee/bear/sheet/filter/FilterViewModel;)V", "dragView", "Lcom/bytedance/ee/bear/sheet/common/SheetDragView;", "getDragView", "()Lcom/bytedance/ee/bear/sheet/common/SheetDragView;", "setDragView", "(Lcom/bytedance/ee/bear/sheet/common/SheetDragView;)V", "topView", "Landroid/view/View;", "getTopView", "()Landroid/view/View;", "setTopView", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "filterCol", "filterColPre", "filterColNext", "currentCol", "", "getCurrentCol", "()I", "setCurrentCol", "(I)V", "sheetId", "", "getSheetId", "()Ljava/lang/String;", "setSheetId", "(Ljava/lang/String;)V", "layoutResId", "getLayoutResId", "panelName", "getPanelName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroy", "updateData", "filterData", "Lcom/bytedance/ee/bear/sheet/filter/FilterData;", "updateTopViews", "filterItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterItem;", "curTitle", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "onKeyEventBackPressed", "", "exitFragment", "onChangeToMidPosition", "onChangeToMaxPosition", "notifyColRangeChanged", "index", "callback", "T", ResourceData.KEY_ID, "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "isSearch", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;)V", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSubFilterFragment extends BaseFragment implements ocb.a, SheetDragView.c {
    public static final /* synthetic */ int n = 0;
    public FilterViewModel e;
    public SheetDragView f;
    public View g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public int l;
    public String m;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ BaseSubFilterFragment a;

        public b(BaseSubFilterFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            BaseSubFilterFragment r3 = this.a;
            int r0 = BaseSubFilterFragment.n;
            r3.V90();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ BaseSubFilterFragment a;

        public c(BaseSubFilterFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            FilterData r12 = (FilterData) r11;
            BaseSubFilterFragment r0 = this.a;
            int r1 = BaseSubFilterFragment.n;
            r0.getClass();
            if (r12 == null) goto L64;
            FilterData.FilterItem r13 = r12.getData();
            if (r13 == null) goto L67;
            FilterData.ColRange r2 = r13.getColRange();
            boolean r3 = false;
            if (r2 == null) goto L9;
            int r4 = r2.getIndex();
        L10:
            r0.l = r4;
            r0.m = r13.getSheetId();
            FilterData.FilterSheetItem[] r5 = r13.getItems();
            if (r5 != null) goto L13;
            r5 = new FilterData.FilterSheetItem[0];
        L13:
            int r6 = r5.length;
            int r7 = 0;
        L14:
            if (r7 >= r6) goto L69;
            FilterData.FilterSheetItem r8 = r5[r7];
            if (Intrinsics.areEqual(r8.getId(), r0.Y90()) == true) goto L17;
            r7 = r7 + 1;
            goto L14
        L17:
            String r9 = r8.getTitle();
            TextView r10 = r0.h;
            TextView r14 = null;
            if (r10 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("title");
            r10 = null;
        L20:
            r10.setText(r9);
            TextView r15 = r0.i;
            if (r15 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("filterCol");
            r15 = null;
        L23:
            r15.setText(r13.getTitle());
            FilterData.ColRange r16 = r13.getColRange();
            if (r16 == null) goto L26;
            int r17 = r16.getIndex();
        L27:
            FilterData.ColRange r18 = r13.getColRange();
            if (r18 == null) goto L30;
            int r19 = r18.getTotal();
        L31:
            TextView r20 = r0.j;
            if (r20 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("filterColPre");
            r20 = null;
        L35:
            if (r17 == 1) goto L37;
            boolean r21 = true;
        L38:
            r20.setEnabled(r21);
            TextView r22 = r0.j;
            if (r22 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("filterColPre");
            r22 = null;
        L41:
            if (r17 == 1) goto L43;
            boolean r23 = true;
        L44:
            r22.setClickable(r23);
            TextView r24 = r0.k;
            if (r24 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("filterColNext");
            r24 = null;
        L47:
            if (r17 == r19) goto L49;
            boolean r25 = true;
        L50:
            r24.setEnabled(r25);
            TextView r26 = r0.k;
            if (r26 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("filterColNext");
            r26 = null;
        L53:
            if (r17 == r19) goto L55;
            r3 = true;
        L55:
            r26.setClickable(r3);
            TextView r110 = r0.j;
            if (r110 != null) goto L58;
            Intrinsics.throwUninitializedPropertyAccessException("filterColPre");
            r110 = null;
        L58:
            r110.setOnClickListener(new com.bytedance.ee.bear.sheet.filter.a(r0, r17));
            TextView r111 = r0.k;
            if (r111 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("filterColNext");
        L62:
            r14.setOnClickListener(new com.bytedance.ee.bear.sheet.filter.b(r0, r17));
            r0.ba0(r8);
            return;
        L61:
            r14 = r111;
            goto L62
        L49:
            r25 = false;
            goto L50
        L43:
            r23 = false;
            goto L44
        L37:
            r21 = false;
            goto L38
        L30:
            r19 = 0;
            goto L31
        L26:
            r17 = 0;
            goto L27
        L69:
            return;
        L9:
            r4 = 0;
            goto L10
        L67:
            return;
        }
    }

    public static final class d implements qm5.d.a {
        public final /* synthetic */ BaseSubFilterFragment a;

        @Override // qm5.d.a
        public final void exit() {
            BaseSubFilterFragment r0 = this.a;
            int r1 = BaseSubFilterFragment.n;
            r0.V90();
        }

        public d(BaseSubFilterFragment r1) {
            this.a = r1;
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

    public abstract void ba0(FilterData.FilterSheetItem r1);

    public final SheetDragView W90() {
        SheetDragView r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dragView");
        return null;
    }

    public final FilterViewModel Z90() {
        FilterViewModel r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final boolean S90() {
        V90();
        return true;
    }

    public final void V90() {
        rcb.c.c(getContext());
        Z90().clearFilterPageData();
        T90(2130772114);
    }

    public final void onDestroy() {
        FragmentActivity r0 = getActivity();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        pcb.a.a.b(r0).a(this);
        Z90().clearFilterPageData();
        super.onDestroy();
    }

    public BaseSubFilterFragment() {
    }

    public void aa0(int r2) {
        U90("colRange", Integer.valueOf(r2));
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        FilterViewModel r3 = com.bytedance.ee.bear.browser.plugin.q.a(this, FilterViewModel.class);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.e = r3;
        FragmentActivity r4 = getActivity();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        pcb.a.a.b(r4).c(this);
    }

    public final <T> void U90(String r8, T r9) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        Z90().callback(r8, this.m, this.l, r9, null);
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        View r6 = r4.findViewById(2131388817);
        r6.findViewById(2131363779).setOnClickListener(new b(this));
        SheetDragView r0 = (SheetDragView) r4.getRootView().findViewById(2131372039);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
        W90().setOnPositionChangeListener(this);
        W90().setSlideView(r6);
        View r1 = r4.findViewById(2131386173);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.g = r1;
        TextView r7 = (TextView) r6.findViewById(2131388772);
        this.h = r7;
        TextView r2 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("title");
        r7 = null;
    L5:
        r7.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        TextView r8 = this.h;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L9:
        r2.getPaint().setStrokeWidth(1.0f);
        this.i = (TextView) r4.findViewById(2131386169);
        this.j = (TextView) r4.findViewById(2131386171);
        this.k = (TextView) r4.findViewById(2131386170);
        Z90().getFilterData().observe(this, new c(this));
        Map<String, String> r9 = qm5.d.a;
        qm5.d.a(this, getFragmentManager(), 2131372508, new d(this));
        return;
    L8:
        r2 = r8;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(X90(), r3, false);
    }
}
