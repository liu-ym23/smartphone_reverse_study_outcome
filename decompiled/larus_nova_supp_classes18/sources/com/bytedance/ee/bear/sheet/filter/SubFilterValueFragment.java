package com.bytedance.ee.bear.sheet.filter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\u001fH\u0002J \u00107\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#H\u0016J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0014J\u0016\u0010?\u001a\u0002002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0018\u0010@\u001a\u0002002\u0006\u00104\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001fH\u0002J\u0010\u0010B\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010C\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010D\u001a\u0002002\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010E\u001a\u000200H\u0002J\u0018\u0010F\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\u001fH\u0002J\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016J\b\u0010L\u001a\u000200H\u0016J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u000200H\u0002J#\u0010P\u001a\u000200\"\u0004\b\u0000\u0010Q2\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u0002HQH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u000200H\u0002J\b\u0010V\u001a\u00020\u001fH\u0016J\b\u0010W\u001a\u000200H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020#X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u0016X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/SubFilterValueFragment;", "Lcom/bytedance/ee/bear/sheet/filter/BaseSubFilterFragment;", "Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$OnSelectedChangeListener;", "<init>", "()V", "searchBox", "Landroid/view/View;", "searchIcon", "selectAllLayout", "selectAllCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "selectAllHintText", "searchEditText", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "searchClearIcon", "valueCount", "Landroid/widget/TextView;", "valueCountLeft", "valueCountRight", "recyclerView", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "keyWord", "", "textWatcher", "Landroid/text/TextWatcher;", "filterValueAdapter", "Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "isConductSearch", "", "isSelectAllBeforeSearch", "isEnterSearchLayout", "current", "", "lastCurrentCol", "sheetAnalytic", "Lcom/bytedance/ee/bear/sheet/common/SheetAnalytic;", "layoutResId", "getLayoutResId", "()I", "panelName", "getPanelName", "()Ljava/lang/String;", "debounceUtil", "Lcom/bytedance/ee/util/rx/DebounceFlowableWrapper;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "changeSearchLayout", "isSearch", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "updateResultListData", "updateViewEnableStatus", "enable", "updateCurView", "updateCurList", "loadMoreData", "notifyAllDataUpdated", "searchKeyWord", "isScrollToTop", "selectAllOrNot", "checked", "onChangeToMidPosition", "onChangeToMaxPosition", "onSelectItem", "filterSelectedItems", "filterAllItems", "filterNothing", FilterData.FilterSheetItem.Id.FILTER_VALUE, "T", ResourceData.KEY_ID, "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "updateSelectAllCheckBox", "onBackPressed", "onDestroyView", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubFilterValueFragment extends BaseSubFilterFragment implements FilterValueAdapter.a {
    public static final /* synthetic */ int M = 0;
    public d A;
    public FilterValueAdapter B;
    public final List<FilterData.FilterOptionItem> C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public qm5.a I;
    public final int J;
    public final String K;
    public uu5.d<String> L;
    public View o;
    public View p;
    public View q;
    public UDCheckBox r;
    public View s;
    public SpaceEditText t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public BaseRecyclerView y;
    public String z;

    public static final class a {
    }

    public static final class b extends CommonActionPanelLayout.b {
        public final /* synthetic */ SubFilterValueFragment a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void b() {
            SubFilterValueFragment r0 = this.a;
            int r1 = SubFilterValueFragment.M;
            r0.ca0(false);
            rcb.c.c(this.a.getContext());
            UDEditText r2 = this.a.t;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r2 = null;
        L5:
            r2.setText("");
        }

        public b(SubFilterValueFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ SubFilterValueFragment a;

        public c(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FilterValueAdapter r0 = this.a.B;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.notifyDataSetChanged();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ SubFilterValueFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        public d(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            Intrinsics.checkNotNullParameter(r4, "s");
            SubFilterValueFragment r0 = this.a;
            int r1 = r0.H;
            int r2 = r0.l;
            if (r1 != r2) goto L11;
            r0.fa0(r4.toString(), true);
            boolean r5 = TextUtils.isEmpty(r4.toString());
            SubFilterValueFragment r3 = this.a;
            r3.D = !r5;
            View r6 = r3.u;
            if (r6 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("searchClearIcon");
            r6 = null;
        L7:
            if (r5 == false) goto L9;
            int r7 = 8;
        L10:
            r6.setVisibility(r7);
            return;
        L9:
            r7 = 0;
            goto L10
        L11:
            r0.H = r2;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ SubFilterValueFragment a;

        public e(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            SubFilterValueFragment r3 = this.a;
            int r0 = SubFilterValueFragment.M;
            r3.ca0(true);
            this.a.W90().n();
            UDEditText r4 = this.a.t;
            qm5.a r1 = null;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r4 = null;
        L5:
            r4.requestFocus();
            rcb.c.g(this.a.getContext());
            qm5.a r5 = this.a.I;
            if (r5 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("sheetAnalytic");
        L9:
            r1.b("filter_search");
            return;
        L8:
            r1 = r5;
            goto L9
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ SubFilterValueFragment a;

        public f(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            UDCheckBox r2 = this.a.r;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
            r2 = null;
        L5:
            r2.performClick();
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ SubFilterValueFragment a;

        public g(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            UDCheckBox r1 = this.a.r;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
            r1 = null;
        L5:
            boolean r2 = r1.isChecked();
            SubFilterValueFragment r3 = this.a;
            Iterator r4 = ((ArrayList) r3.C).iterator();
        L7:
            if (r4.hasNext() == false) goto L11;
            FilterData.FilterOptionItem r5 = (FilterData.FilterOptionItem) r4.next();
            if (r5.isVisible() == false) goto L7;
            r5.setSelect(r2);
            goto L7
        L11:
            FilterValueAdapter r6 = r3.B;
            if (r6 == null) goto L14;
            r6.notifyDataSetChanged();
        L14:
            boolean r7 = r3.D;
            if (r7 == false) goto L18;
            r3.da0();
        L21:
            SubFilterValueFragment r8 = this.a;
            if (r8.D == true) goto L30;
            r8.E = r2;
            return;
        L30:
            return;
        L18:
            if (r2 == false) goto L20;
            Boolean r12 = Boolean.valueOf(r7);
            Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, ResourceData.KEY_ID);
            r3.Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, r3.m, r3.l, new int[]{-1}, r12);
            goto L21
        L20:
            Boolean r18 = Boolean.valueOf(r7);
            Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, ResourceData.KEY_ID);
            r3.Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, r3.m, r3.l, new int[0], r18);
            goto L21
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ SubFilterValueFragment a;

        public h(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            UDEditText r3 = this.a.t;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r3 = null;
        L5:
            r3.setText("");
        }
    }

    public static final class i implements TextView.OnEditorActionListener {
        public final /* synthetic */ SubFilterValueFragment a;

        public i(SubFilterValueFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 != 6) goto L14;
            UDEditText r4 = this.a.t;
            qm5.a r5 = null;
            if (r4 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r4 = null;
        L7:
            r4.setText("");
            SheetDragView r6 = this.a.W90();
            r6.x.a();
            r6.C = false;
            qm5.a r7 = this.a.I;
            if (r7 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("sheetAnalytic");
        L11:
            r5.b("filter_search_confirm");
            return true;
        L10:
            r5 = r7;
            goto L11
        L14:
            return true;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ SubFilterValueFragment a;

        public j(SubFilterValueFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            FilterPageData r6 = (FilterPageData) r5;
            if (r6 == null) goto L25;
            SubFilterValueFragment r0 = this.a;
            r0.G = r6.getCurrent();
            FilterData.FilterOptionItem[] r1 = r6.getList();
            if (r1 == null) goto L7;
            int r2 = r1.length;
        L9:
            if (Intrinsics.areEqual(r6.getSheetId(), r0.m) == true) goto L11;
            return;
        L11:
            if (r6.getCurrentCol() == r0.l) goto L13;
            return;
        L13:
            if (((((ArrayList) r0.C).size() + r2) - 1) != r0.G) goto L28;
            List<FilterData.FilterOptionItem> r3 = r0.C;
            FilterData.FilterOptionItem[] r4 = r6.getList();
            if (r4 == null) goto L17;
            List r7 = ArraysKt.toMutableList(r4);
        L18:
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
            ((ArrayList) r3).addAll((ArrayList) r7);
            if (r6.getHasNext() == false) goto L23;
            int r8 = r0.G;
            FilterViewModel.c r9 = r0.Z90().getFilterValueDelegate();
            if (r9 == null) goto L29;
            r9.a(r8, r0.m, r0.l);
            return;
        L29:
            return;
        L23:
            r0.ea0();
            return;
        L17:
            r7 = null;
            goto L18
        L28:
            return;
        L7:
            r2 = 0;
            goto L9
        }
    }

    public static final class k implements uu5.d.a<String> {
        public final /* synthetic */ SubFilterValueFragment a;

        public k(SubFilterValueFragment r1) {
            this.a = r1;
        }

        public final void onSubscribe(Object r2) {
            String r3 = (String) r2;
            SubFilterValueFragment r4 = this.a;
            int r0 = SubFilterValueFragment.M;
            r4.da0();
            this.a.ha0();
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.ViewGroup] */
    public final void ea0() {
        String r1 = this.z;     // Catch: Exception -> L25
        if (r1 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        ?? r3 = 0;
        if (r2 == true) goto L16;
        AppCompatEditText r4 = this.t;     // Catch: Exception -> L25
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");     // Catch: Exception -> L25
        r4 = null;
    L15:
        fa0(String.valueOf(r4.getText()), false);     // Catch: Exception -> L25
    L19:
        BaseRecyclerView r5 = this.y;     // Catch: Exception -> L25
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Exception -> L25
    L23:
        r3.post(new c(this));     // Catch: Exception -> L25
        return;
    L22:
        r3 = r5;
        goto L23
    L16:
        FilterValueAdapter r6 = this.B;     // Catch: Exception -> L25
        if (r6 == null) goto L19;
        List<FilterData.FilterOptionItem> r7 = this.C;     // Catch: Exception -> L25
        Intrinsics.checkNotNullParameter(r7, "newList");     // Catch: Exception -> L25
        r6.a = r7;     // Catch: Exception -> L25
        goto L19
    L6:
        if (r1.length() == 0) goto L9;
        r2 = false;
    L25:
        e = move-exception;
        tt5.a.e("SubFilterValueFragment", "notifyAllDataUpdated(): ", e, false);
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void Q5() {
        View r0 = this.o;
        View r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r0 = null;
    L6:
        if (r0.getVisibility() != 8) goto L16;
        View r1 = this.o;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r1 = null;
    L10:
        r1.setVisibility(0);
        View r3 = this.p;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
    L14:
        r2.setVisibility(8);
        return;
    L13:
        r2 = r3;
        goto L14
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void W6() {
        View r0 = this.o;
        View r2 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r0 = null;
    L6:
        if (r0.getVisibility() != 0) goto L16;
        ca0(false);
        View r3 = this.o;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r3 = null;
    L10:
        r3.setVisibility(8);
        View r1 = this.p;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
    L14:
        r2.setVisibility(0);
        rcb.c.c(getContext());
        return;
    L13:
        r2 = r1;
        goto L14
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterValueAdapter.a
    public final void c20() {
        uu5.d<String> r0 = this.L;
        if (r0 == null) goto L6;
        r0.b("");
        return;
    }

    public final void da0() {
        ArrayList r0 = new ArrayList();
        if (this.D == true) goto L5;
    L12:
        int r1 = ((ArrayList) this.C).size();
        int r5 = 0;
        boolean r6 = true;
    L13:
        if (r5 >= r1) goto L19;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r5)).isSelect() == false) goto L17;
        r0.add(Integer.valueOf(r5));
    L18:
        r5 = r5 + 1;
        goto L13
    L17:
        r6 = false;
        goto L18
    L19:
        if (r6 == false) goto L22;
        Boolean r12 = Boolean.valueOf(this.D);
        Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, ResourceData.KEY_ID);
        Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, this.m, this.l, new int[]{-1}, r12);
        return;
    L22:
        Object[] r7 = r0.toArray(new Integer[0]);
        Boolean r8 = Boolean.valueOf(this.D);
        Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, ResourceData.KEY_ID);
        Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, this.m, this.l, r7, r8);
        return;
    L5:
        if (this.E == false) goto L12;
        int r2 = ((ArrayList) this.C).size();
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L22;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r4)).isSelect() == false) goto L11;
        r0.add(Integer.valueOf(r4));
    L11:
        r4 = r4 + 1;
        goto L7
    }

    public final void ha0() {
        int r0 = this.C.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L11;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r2)).isVisible() == false) goto L10;
        r3 = r3 + 1;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r2)).isSelect() == true) goto L10;
        boolean r1 = false;
    L12:
        if (r3 == 0) goto L15;
        if (r1 == false) goto L15;
        boolean r4 = true;
    L16:
        UDCheckBox r5 = this.r;
        UDCheckBox r6 = null;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r5 = null;
    L20:
        if (r5.isChecked() == false) goto L26;
        if (r4 == true) goto L26;
        UDCheckBox r7 = this.r;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r7 = null;
    L25:
        r7.setChecked(false);
    L37:
        if (this.D == true) goto L48;
        UDCheckBox r8 = this.r;
        if (r8 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
    L42:
        this.E = r6.isChecked();
        return;
    L41:
        r6 = r8;
        goto L42
    L48:
        return;
    L26:
        UDCheckBox r9 = this.r;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r9 = null;
    L30:
        if (r9.isChecked() == true) goto L37;
        if (r4 == false) goto L37;
        UDCheckBox r10 = this.r;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r10 = null;
    L35:
        r10.setChecked(true);
    L15:
        r4 = false;
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        r1 = true;
        goto L12
    }

    public final boolean onBackPressed() {
        boolean r0 = this.F;
        if (r0 != true) goto L5;
        ca0(false);
        return true;
    L5:
        if (r0 == true) goto L9;
        return super.onBackPressed();
    L9:
        throw new NoWhenBranchMatchedException();
    }

    public final void onDestroyView() {
        if (this.F == false) goto L5;
        ca0(false);
        rcb.c.c(getContext());
    L5:
        uu5.d<String> r0 = this.L;
        if (r0 == null) goto L9;
        r0.a();
    L9:
        if (this.F == false) goto L11;
        ca0(false);
    L11:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public SubFilterValueFragment() {
        this.C = new ArrayList();
        this.G = -1;
        this.H = -1;
        this.J = 2131564561;
        this.K = FilterData.FilterSheetItem.Id.FILTER_VALUE;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final int X90() {
        return this.J;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final String Y90() {
        return this.K;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void ba0(FilterData.FilterSheetItem r7) {
        Intrinsics.checkNotNullParameter(r7, "filterSheetItem");
        View r0 = this.q;
        RecyclerView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllLayout");
        r0 = null;
    L5:
        r0.setVisibility(0);
        ha0();
        if (this.D == true) goto L11;
        TextView r2 = this.v;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("valueCount");
        r2 = null;
    L10:
        r2.setText(String.valueOf(r7.getTotal()));
    L11:
        int r3 = ((ArrayList) this.C).size();
        ((ArrayList) this.C).clear();
        FilterData.FilterOptionItem[] r4 = r7.getList();
        boolean r5 = true;
        if (r4 != null) goto L14;
    L20:
        if (r5 == true) goto L26;
        List<FilterData.FilterOptionItem> r6 = this.C;
        FilterData.FilterOptionItem[] r8 = r7.getList();
        if (r8 == null) goto L24;
        List r9 = ArraysKt.toMutableList(r8);
    L25:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
        ((ArrayList) r6).addAll((ArrayList) r9);
        goto L26
    L24:
        r9 = null;
    L26:
        this.G = r7.getCurrent();
        if (r7.getHasNext() == false) goto L32;
        View r10 = getView();
        if (r10 == null) goto L32;
        r10.post(new f0(this));
    L32:
        if (r3 != ((ArrayList) this.C).size()) goto L38;
        boolean r11 = r7.isSelectAll();
        UDCheckBox r12 = this.r;
        if (r12 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r12 = null;
    L37:
        if (r11 != r12.isChecked()) goto L38;
    L40:
        if (this.H == this.l) goto L50;
        this.z = null;
        this.D = false;
        UDEditText r13 = this.t;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r13 = null;
    L44:
        r13.setText("");
        ga0(this.C);
        RecyclerView r14 = this.y;
        if (r14 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L48:
        r1.smoothScrollToPosition(0);
        return;
    L47:
        r1 = r14;
        goto L48
    L50:
        if (r7.getHasNext() == true) goto L54;
        ea0();
        return;
    L54:
        return;
    L38:
        ha0();
        goto L40
    L14:
        if (r4.length != 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 == true) goto L20;
        r5 = false;
        goto L20
    L16:
        r15 = false;
        goto L17
    }

    public final void ca0(boolean r6) {
        this.F = r6;
        View r0 = this.g;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("topView");
        r0 = null;
    L6:
        int r2 = 8;
        if (r6 == false) goto L9;
        int r4 = 8;
    L10:
        r0.setVisibility(r4);
        View r1 = W90().getDragHandler();
        if (r6 == true) goto L14;
        r2 = 0;
    L14:
        r1.setVisibility(r2);
        W90().setTitleBarVisible(r6);
        if (r6 == false) goto L17;
        W90().setTitle(getString(2131887821));
        W90().setDividerVisible(false);
        W90().setOnActionListener(new b(this));
        return;
    L17:
        W90().setDividerVisible(true);
        W90().setOnActionListener(null);
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public final void ga0(List<FilterData.FilterOptionItem> r3) {
        FilterValueAdapter r0 = this.B;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "newList");
        r0.a = r3;
    L5:
        FilterValueAdapter r1 = this.B;
        if (r1 == null) goto L9;
        r1.notifyDataSetChanged();
    L9:
        if (((ArrayList) r3).size() <= 0) goto L11;
        boolean r4 = true;
    L12:
        View r2 = this.q;
        TextView r5 = null;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllLayout");
        r2 = null;
    L15:
        ia0(r2, r4);
        View r6 = this.r;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r6 = null;
    L18:
        ia0(r6, r4);
        View r7 = this.s;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllHintText");
        r7 = null;
    L21:
        ia0(r7, r4);
        View r8 = this.p;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
        r8 = null;
    L24:
        ia0(r8, r4);
        TextView r9 = this.w;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("valueCountLeft");
        r9 = null;
    L27:
        ia0(r9, r4);
        TextView r10 = this.v;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("valueCount");
        r10 = null;
    L30:
        ia0(r10, r4);
        TextView r11 = this.x;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("valueCountRight");
    L34:
        ia0(r5, r4);
        return;
    L33:
        r5 = r11;
        goto L34
    L11:
        r4 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.A = new d(this);
        this.I = new qm5.a();
        DocViewModel r3 = com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class);
        qm5.a r0 = this.I;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sheetAnalytic");
        r0 = null;
    L5:
        r0.a = r3.getBearUrl();
    }

    public final void fa0(String r8, boolean r9) {
        this.z = r8;
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.C).iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L11;
        FilterData.FilterOptionItem r4 = (FilterData.FilterOptionItem) r1.next();
        String r5 = r4.getValue();
        if (r5 == null) goto L4;
        if (StringsKt.contains(r5, r8, true) == true) goto L9;
        r4.setVisible(false);
        goto L4
    L9:
        r4.setVisible(true);
        r3 = r3 + r4.getCount();
        r0.add(r4);
        goto L4
    L11:
        ga0(r0);
        TextView r10 = null;
        if (r9 == false) goto L17;
        RecyclerView r11 = this.y;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L16:
        r11.smoothScrollToPosition(0);
    L17:
        TextView r12 = this.v;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("valueCount");
    L21:
        r10.setText(String.valueOf(r3));
        ha0();
        return;
    L20:
        r10 = r12;
        goto L21
    }

    public final void ia0(View r1, boolean r2) {
        r1.setEnabled(r2);
        r1.setClickable(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.widget.EditText] */
    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        RecyclerView r7 = (BaseRecyclerView) r5.findViewById(2131392193);
        this.y = r7;
        View r1 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L5:
        final FragmentActivity r2 = getActivity();
        r7.setLayoutManager(new AnonymousClass1(r2));
        FilterValueAdapter r8 = new FilterValueAdapter(this.C);
        r8.b = this;
        RecyclerView r3 = this.y;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r3 = null;
    L8:
        r3.setAdapter(r8);
        this.B = r8;
        this.v = (TextView) r5.findViewById(2131372527);
        this.w = (TextView) r5.findViewById(2131372528);
        this.x = (TextView) r5.findViewById(2131372529);
        this.o = r5.findViewById(2131386172);
        View r9 = r5.findViewById(2131385286);
        this.p = r9;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
        r9 = null;
    L11:
        r9.setOnClickListener(new e(this));
        this.q = r5.findViewById(2131385780);
        this.r = r5.findViewById(2131385778);
        this.s = r5.findViewById(2131385779);
        View r10 = this.q;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllLayout");
        r10 = null;
    L14:
        r10.setOnClickListener(new f(this));
        View r11 = this.r;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r11 = null;
    L17:
        r11.setOnClickListener(new g(this));
        View r12 = r5.findViewById(2131385349);
        this.u = r12;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchClearIcon");
        r12 = null;
    L20:
        r12.setOnClickListener(new h(this));
        SpaceEditText r13 = (SpaceEditText) r5.findViewById(2131385429);
        this.t = r13;
        ?? r14 = r13;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r14 = 0;
    L23:
        r14.addTextChangedListener(this.A);
        UDEditText r15 = this.t;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r15 = null;
    L26:
        r15.setOnEditorActionListener(new i(this));
        Z90().getFilterPageData().observe(this, new j(this));
        com.bytedance.ee.bear.facade.common.widget.d r16 = W90().x;
        if (r16.b() < ((int) r16.c[2])) goto L29;
        boolean r17 = true;
    L30:
        if (r17 == false) goto L39;
        View r18 = this.o;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r18 = null;
    L34:
        r18.setVisibility(0);
        View r19 = this.p;
        if (r19 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
    L38:
        r1.setVisibility(8);
        goto L39
    L37:
        r1 = r19;
    L39:
        this.L = new uu5.d(200, new k(this));
        return;
    L29:
        r17 = false;
        goto L30
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "khp");
        if (r2 <= 0) goto L6;
        ca0(true);
        return;
    }
}
