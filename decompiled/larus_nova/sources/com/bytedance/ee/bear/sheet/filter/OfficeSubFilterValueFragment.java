package com.bytedance.ee.bear.sheet.filter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\u001fH\u0002J \u00107\u001a\u0002002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#H\u0016J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0014J\u0016\u0010?\u001a\u0002002\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0018\u0010@\u001a\u0002002\u0006\u00104\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001fH\u0002J\u0010\u0010B\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010C\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010D\u001a\u0002002\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010E\u001a\u000200H\u0002J\u0018\u0010F\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\u001fH\u0002J\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016J\b\u0010L\u001a\u000200H\u0016J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u000200H\u0002J#\u0010P\u001a\u000200\"\u0004\b\u0000\u0010Q2\u0006\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u0002HQH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u000200H\u0002J\b\u0010V\u001a\u00020\u001fH\u0016J\b\u0010W\u001a\u000200H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020#X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u0016X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/OfficeSubFilterValueFragment;", "Lcom/bytedance/ee/bear/sheet/filter/OfficeBaseSubFilterFragment;", "Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter$OnSelectedChangeListener;", "<init>", "()V", "searchBox", "Landroid/view/View;", "searchIcon", "selectAllLayout", "selectAllCheckBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "selectAllHintText", "searchEditText", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "searchClearIcon", "valueCount", "Landroid/widget/TextView;", "valueCountLeft", "valueCountRight", "recyclerView", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "keyWord", "", "textWatcher", "Landroid/text/TextWatcher;", "filterValueAdapter", "Lcom/bytedance/ee/bear/sheet/filter/FilterValueAdapter;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "isConductSearch", "", "isSelectAllBeforeSearch", "isEnterSearchLayout", "current", "", "lastCurrentCol", "sheetAnalytic", "Lcom/bytedance/ee/bear/sheet_core/common/SheetAnalytic;", "layoutResId", "getLayoutResId", "()I", "panelName", "getPanelName", "()Ljava/lang/String;", "debounceUtil", "Lcom/bytedance/ee/util/rx/DebounceFlowableWrapper;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "changeSearchLayout", "isSearch", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "updateResultListData", "updateViewEnableStatus", "enable", "updateCurView", "updateCurList", "loadMoreData", "notifyAllDataUpdated", "searchKeyWord", "isScrollToTop", "selectAllOrNot", "checked", "onChangeToMidPosition", "onChangeToMaxPosition", "onSelectItem", "filterSelectedItems", "filterAllItems", "filterNothing", FilterData.FilterSheetItem.Id.FILTER_VALUE, ExifInterface.GPS_DIRECTION_TRUE, "id", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "updateSelectAllCheckBox", "onBackPressed", "onDestroyView", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSubFilterValueFragment extends OfficeBaseSubFilterFragment implements FilterValueAdapter.a {
    public static final /* synthetic */ int M = 0;
    public d A;
    public FilterValueAdapter B;
    public final List<FilterData.FilterOptionItem> C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public on5.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f237765J;
    public final String K;
    public uu5.d<String> L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f237766o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f237767p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f237768q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public UDCheckBox f237769r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f237770s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SpaceEditText f237771t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f237772u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f237773v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f237774w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f237775x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BaseRecyclerView f237776y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f237777z;

    public static final class a {
    }

    public static final class b extends CommonActionPanelLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237778a;

        @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
        public final void b() {
            OfficeSubFilterValueFragment r100 = this.f237778a;
            int r101 = OfficeSubFilterValueFragment.M;
            r100.ca0(false);
            rcb.c.c(this.f237778a.getContext());
            SpaceEditText r102 = this.f237778a.f237771t;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r102 = null;
        L5:
            r102.setText("");
        }

        public b(OfficeSubFilterValueFragment r100) {
            this.f237778a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237779a;

        public c(OfficeSubFilterValueFragment r100) {
            this.f237779a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FilterValueAdapter r100 = this.f237779a.B;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.notifyDataSetChanged();     // Catch: Throwable -> L6
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237780a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "s");
        }

        public d(OfficeSubFilterValueFragment r100) {
            this.f237780a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            Intrinsics.checkNotNullParameter(r100, "s");
            OfficeSubFilterValueFragment r101 = this.f237780a;
            int r102 = r101.H;
            int r103 = r101.f237726l;
            if (r102 != r103) goto L11;
            r101.fa0(r100.toString(), true);
            boolean r104 = TextUtils.isEmpty(r100.toString());
            OfficeSubFilterValueFragment r105 = this.f237780a;
            r105.D = !r104;
            View r106 = r105.f237772u;
            if (r106 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("searchClearIcon");
            r106 = null;
        L7:
            if (r104 == false) goto L9;
            int r107 = 8;
        L10:
            r106.setVisibility(r107);
            return;
        L9:
            r107 = 0;
            goto L10
        L11:
            r101.H = r103;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237781a;

        public e(OfficeSubFilterValueFragment r100) {
            this.f237781a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            OfficeSubFilterValueFragment r101 = this.f237781a;
            int r102 = OfficeSubFilterValueFragment.M;
            r101.ca0(true);
            this.f237781a.W90().n();
            SpaceEditText r103 = this.f237781a.f237771t;
            on5.a r104 = null;
            if (r103 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r103 = null;
        L5:
            r103.requestFocus();
            rcb.c.g(this.f237781a.getContext());
            on5.a r105 = this.f237781a.I;
            if (r105 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("sheetAnalytic");
        L9:
            r104.b("filter_search");
            return;
        L8:
            r104 = r105;
            goto L9
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237782a;

        public f(OfficeSubFilterValueFragment r100) {
            this.f237782a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            UDCheckBox r101 = this.f237782a.f237769r;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
            r101 = null;
        L5:
            r101.performClick();
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237783a;

        public g(OfficeSubFilterValueFragment r100) {
            this.f237783a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            UDCheckBox r100 = this.f237783a.f237769r;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
            r100 = null;
        L5:
            boolean r101 = r100.isChecked();
            OfficeSubFilterValueFragment r102 = this.f237783a;
            Iterator r103 = ((ArrayList) r102.C).iterator();
        L7:
            if (r103.hasNext() == false) goto L11;
            FilterData.FilterOptionItem r104 = (FilterData.FilterOptionItem) r103.next();
            if (r104.isVisible() == false) goto L7;
            r104.setSelect(r101);
            goto L7
        L11:
            FilterValueAdapter r105 = r102.B;
            if (r105 == null) goto L14;
            r105.notifyDataSetChanged();
        L14:
            boolean r106 = r102.D;
            if (r106 == false) goto L18;
            r102.da0();
        L21:
            OfficeSubFilterValueFragment r107 = this.f237783a;
            if (r107.D == true) goto L30;
            r107.E = r101;
            return;
        L30:
            return;
        L18:
            if (r101 == false) goto L20;
            Boolean r110 = Boolean.valueOf(r106);
            Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, "id");
            r102.Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, r102.f237727m, r102.f237726l, new int[]{-1}, r110);
            goto L21
        L20:
            Boolean r111 = Boolean.valueOf(r106);
            Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, "id");
            r102.Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, r102.f237727m, r102.f237726l, new int[0], r111);
            goto L21
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237784a;

        public h(OfficeSubFilterValueFragment r100) {
            this.f237784a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SpaceEditText r101 = this.f237784a.f237771t;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r101 = null;
        L5:
            r101.setText("");
        }
    }

    public static final class i implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237785a;

        public i(OfficeSubFilterValueFragment r100) {
            this.f237785a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 6) goto L14;
            SpaceEditText r103 = this.f237785a.f237771t;
            on5.a r104 = null;
            if (r103 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            r103 = null;
        L7:
            r103.setText("");
            SheetDragView r105 = this.f237785a.W90();
            r105.f237475x.a();
            r105.C = false;
            on5.a r106 = this.f237785a.I;
            if (r106 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("sheetAnalytic");
        L11:
            r104.b("filter_search_confirm");
            return true;
        L10:
            r104 = r106;
            goto L11
        L14:
            return true;
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237786a;

        public j(OfficeSubFilterValueFragment r100) {
            this.f237786a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            FilterPageData r101 = (FilterPageData) r100;
            if (r101 == null) goto L25;
            OfficeSubFilterValueFragment r102 = this.f237786a;
            r102.G = r101.getCurrent();
            FilterData.FilterOptionItem[] r103 = r101.getList();
            if (r103 == null) goto L7;
            int r104 = r103.length;
        L9:
            if (Intrinsics.areEqual(r101.getSheetId(), r102.f237727m) == true) goto L11;
            return;
        L11:
            if (r101.getCurrentCol() == r102.f237726l) goto L13;
            return;
        L13:
            if (((((ArrayList) r102.C).size() + r104) - 1) != r102.G) goto L28;
            List<FilterData.FilterOptionItem> r105 = r102.C;
            FilterData.FilterOptionItem[] r106 = r101.getList();
            if (r106 == null) goto L17;
            List r107 = ArraysKt.toMutableList(r106);
        L18:
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
            ((ArrayList) r105).addAll((ArrayList) r107);
            if (r101.getHasNext() == false) goto L23;
            int r108 = r102.G;
            FilterViewModel.c r109 = r102.Z90().getFilterValueDelegate();
            if (r109 == null) goto L29;
            r109.a(r108, r102.f237727m, r102.f237726l);
            return;
        L29:
            return;
        L23:
            r102.ea0();
            return;
        L17:
            r107 = null;
            goto L18
        L28:
            return;
        L7:
            r104 = 0;
            goto L9
        }
    }

    public static final class k implements uu5.d.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeSubFilterValueFragment f237787a;

        public k(OfficeSubFilterValueFragment r100) {
            this.f237787a = r100;
        }

        @Override // uu5.d.a
        public final void onSubscribe(String r100) {
            OfficeSubFilterValueFragment r101 = this.f237787a;
            int r102 = OfficeSubFilterValueFragment.M;
            r101.da0();
            this.f237787a.ha0();
        }
    }

    static {
    }

    public final void ea0() {
        String r100 = this.f237777z;     // Catch: Exception -> L25
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        BaseRecyclerView r102 = null;
        if (r101 == true) goto L16;
        SpaceEditText r103 = this.f237771t;     // Catch: Exception -> L25
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");     // Catch: Exception -> L25
        r103 = null;
    L15:
        fa0(String.valueOf(r103.getText()), false);     // Catch: Exception -> L25
    L19:
        BaseRecyclerView r104 = this.f237776y;     // Catch: Exception -> L25
        if (r104 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Exception -> L25
    L23:
        r102.post(new c(this));     // Catch: Exception -> L25
        return;
    L22:
        r102 = r104;
        goto L23
    L16:
        FilterValueAdapter r105 = this.B;     // Catch: Exception -> L25
        if (r105 == null) goto L19;
        List<FilterData.FilterOptionItem> r106 = this.C;     // Catch: Exception -> L25
        Intrinsics.checkNotNullParameter(r106, "newList");     // Catch: Exception -> L25
        r105.f237713a = r106;     // Catch: Exception -> L25
        goto L19
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
    L25:
        e = move-exception;
        tt5.a.e("SubFilterValueFragment", "notifyAllDataUpdated(): ", e, false);
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void Q5() {
        View r100 = this.f237766o;
        View r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r100 = null;
    L6:
        if (r100.getVisibility() != 8) goto L16;
        View r102 = this.f237766o;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r102 = null;
    L10:
        r102.setVisibility(0);
        View r103 = this.f237767p;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
    L14:
        r101.setVisibility(8);
        return;
    L13:
        r101 = r103;
        goto L14
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void W6() {
        View r100 = this.f237766o;
        View r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r100 = null;
    L6:
        if (r100.getVisibility() != 0) goto L16;
        ca0(false);
        View r102 = this.f237766o;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r102 = null;
    L10:
        r102.setVisibility(8);
        View r103 = this.f237767p;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
    L14:
        r101.setVisibility(0);
        rcb.c.c(getContext());
        return;
    L13:
        r101 = r103;
        goto L14
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterValueAdapter.a
    public final void c20() {
        uu5.d<String> r100 = this.L;
        if (r100 == null) goto L6;
        r100.b("");
        return;
    }

    public final void da0() {
        ArrayList r100 = new ArrayList();
        if (this.D == true) goto L5;
    L12:
        int r101 = ((ArrayList) this.C).size();
        int r102 = 0;
        boolean r103 = true;
    L13:
        if (r102 >= r101) goto L19;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r102)).isSelect() == false) goto L17;
        r100.add(Integer.valueOf(r102));
    L18:
        r102 = r102 + 1;
        goto L13
    L17:
        r103 = false;
        goto L18
    L19:
        if (r103 == false) goto L22;
        Boolean r110 = Boolean.valueOf(this.D);
        Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, "id");
        Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, this.f237727m, this.f237726l, new int[]{-1}, r110);
        return;
    L22:
        Object[] r104 = r100.toArray(new Integer[0]);
        Boolean r105 = Boolean.valueOf(this.D);
        Intrinsics.checkNotNullParameter(FilterData.FilterSheetItem.Id.FILTER_VALUE, "id");
        Z90().callback(FilterData.FilterSheetItem.Id.FILTER_VALUE, this.f237727m, this.f237726l, r104, r105);
        return;
    L5:
        if (this.E == false) goto L12;
        int r106 = ((ArrayList) this.C).size();
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L22;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r107)).isSelect() == false) goto L11;
        r100.add(Integer.valueOf(r107));
    L11:
        r107 = r107 + 1;
        goto L7
    }

    public final void ha0() {
        int r100 = this.C.size();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100) goto L11;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r101)).isVisible() == false) goto L10;
        r102 = r102 + 1;
        if (((FilterData.FilterOptionItem) ListProtector.get(this.C, r101)).isSelect() == true) goto L10;
        boolean r103 = false;
    L12:
        if (r102 == 0) goto L15;
        if (r103 == false) goto L15;
        boolean r104 = true;
    L16:
        UDCheckBox r105 = this.f237769r;
        UDCheckBox r106 = null;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r105 = null;
    L20:
        if (r105.isChecked() == false) goto L26;
        if (r104 == true) goto L26;
        UDCheckBox r107 = this.f237769r;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r107 = null;
    L25:
        r107.setChecked(false);
    L37:
        if (this.D == true) goto L48;
        UDCheckBox r108 = this.f237769r;
        if (r108 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
    L42:
        this.E = r106.isChecked();
        return;
    L41:
        r106 = r108;
        goto L42
    L48:
        return;
    L26:
        UDCheckBox r109 = this.f237769r;
        if (r109 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r109 = null;
    L30:
        if (r109.isChecked() == true) goto L37;
        if (r104 == false) goto L37;
        UDCheckBox r110 = this.f237769r;
        if (r110 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r110 = null;
    L35:
        r110.setChecked(true);
    L15:
        r104 = false;
    L10:
        r101 = r101 + 1;
        goto L4
    L11:
        r103 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        boolean r100 = this.F;
        if (r100 != true) goto L5;
        ca0(false);
        return true;
    L5:
        if (r100 == true) goto L9;
        return super.onBackPressed();
    L9:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        if (this.F == false) goto L5;
        ca0(false);
        rcb.c.c(getContext());
    L5:
        uu5.d<String> r100 = this.L;
        if (r100 == null) goto L9;
        r100.a();
    L9:
        if (this.F == false) goto L11;
        ca0(false);
    L11:
        super.onDestroyView();
    }

    public OfficeSubFilterValueFragment() {
        this.C = new ArrayList();
        this.G = -1;
        this.H = -1;
        this.f237765J = R.layout.sheet_filter_value_fragment;
        this.K = FilterData.FilterSheetItem.Id.FILTER_VALUE;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final int X90() {
        return this.f237765J;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final String Y90() {
        return this.K;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final void ba0(FilterData.FilterSheetItem r100) {
        Intrinsics.checkNotNullParameter(r100, "filterSheetItem");
        View r101 = this.f237768q;
        BaseRecyclerView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllLayout");
        r101 = null;
    L5:
        r101.setVisibility(0);
        ha0();
        if (this.D == true) goto L11;
        TextView r103 = this.f237773v;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("valueCount");
        r103 = null;
    L10:
        r103.setText(String.valueOf(r100.getTotal()));
    L11:
        int r104 = ((ArrayList) this.C).size();
        ((ArrayList) this.C).clear();
        FilterData.FilterOptionItem[] r105 = r100.getList();
        boolean r106 = true;
        if (r105 != null) goto L14;
    L20:
        if (r106 == true) goto L26;
        List<FilterData.FilterOptionItem> r107 = this.C;
        FilterData.FilterOptionItem[] r108 = r100.getList();
        if (r108 == null) goto L24;
        List r109 = ArraysKt.toMutableList(r108);
    L25:
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
        ((ArrayList) r107).addAll((ArrayList) r109);
        goto L26
    L24:
        r109 = null;
    L26:
        this.G = r100.getCurrent();
        if (r100.getHasNext() == false) goto L32;
        View r110 = getView();
        if (r110 == null) goto L32;
        r110.post(new a0(this));
    L32:
        if (r104 != ((ArrayList) this.C).size()) goto L38;
        boolean r111 = r100.isSelectAll();
        UDCheckBox r112 = this.f237769r;
        if (r112 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r112 = null;
    L37:
        if (r111 != r112.isChecked()) goto L38;
    L40:
        if (this.H == this.f237726l) goto L50;
        this.f237777z = null;
        this.D = false;
        SpaceEditText r113 = this.f237771t;
        if (r113 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r113 = null;
    L44:
        r113.setText("");
        ga0(this.C);
        BaseRecyclerView r114 = this.f237776y;
        if (r114 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L48:
        r102.smoothScrollToPosition(0);
        return;
    L47:
        r102 = r114;
        goto L48
    L50:
        if (r100.getHasNext() == true) goto L54;
        ea0();
        return;
    L54:
        return;
    L38:
        ha0();
        goto L40
    L14:
        if (r105.length != 0) goto L16;
        boolean r115 = true;
    L17:
        if (r115 == true) goto L20;
        r106 = false;
        goto L20
    L16:
        r115 = false;
        goto L17
    }

    public final void ca0(boolean r100) {
        this.F = r100;
        View r101 = this.f237721g;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("topView");
        r101 = null;
    L6:
        int r102 = 8;
        if (r100 == false) goto L9;
        int r103 = 8;
    L10:
        r101.setVisibility(r103);
        View r104 = W90().getDragHandler();
        if (r100 == true) goto L14;
        r102 = 0;
    L14:
        r104.setVisibility(r102);
        W90().setTitleBarVisible(r100);
        if (r100 == false) goto L17;
        W90().setTitle(getString(R.string.Doc_Facade_Search));
        W90().setDividerVisible(false);
        W90().setOnActionListener(new b(this));
        return;
    L17:
        W90().setDividerVisible(true);
        W90().setOnActionListener(null);
        return;
    L9:
        r103 = 0;
        goto L10
    }

    public final void ga0(List<FilterData.FilterOptionItem> r100) {
        FilterValueAdapter r101 = this.B;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "newList");
        r101.f237713a = r100;
    L5:
        FilterValueAdapter r102 = this.B;
        if (r102 == null) goto L9;
        r102.notifyDataSetChanged();
    L9:
        if (((ArrayList) r100).size() <= 0) goto L11;
        boolean r103 = true;
    L12:
        View r104 = this.f237768q;
        TextView r105 = null;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllLayout");
        r104 = null;
    L15:
        ia0(r104, r103);
        UDCheckBox r106 = this.f237769r;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r106 = null;
    L18:
        ia0(r106, r103);
        View r107 = this.f237770s;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllHintText");
        r107 = null;
    L21:
        ia0(r107, r103);
        View r108 = this.f237767p;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
        r108 = null;
    L24:
        ia0(r108, r103);
        TextView r109 = this.f237774w;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("valueCountLeft");
        r109 = null;
    L27:
        ia0(r109, r103);
        TextView r110 = this.f237773v;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("valueCount");
        r110 = null;
    L30:
        ia0(r110, r103);
        TextView r111 = this.f237775x;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("valueCountRight");
    L34:
        ia0(r105, r103);
        return;
    L33:
        r105 = r111;
        goto L34
    L11:
        r103 = false;
        goto L12
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.A = new d(this);
        this.I = new on5.a();
        DocViewModel r101 = (DocViewModel) com.bytedance.ee.bear.browser.plugin.q.a(this, DocViewModel.class);
        on5.a r102 = this.I;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sheetAnalytic");
        r102 = null;
    L5:
        r102.f524353a = r101.getBearUrl();
    }

    public final void fa0(String r100, boolean r101) {
        this.f237777z = r100;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) this.C).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L11;
        FilterData.FilterOptionItem r105 = (FilterData.FilterOptionItem) r103.next();
        String r106 = r105.getValue();
        if (r106 == null) goto L4;
        if (StringsKt.contains(r106, r100, true) == true) goto L9;
        r105.setVisible(false);
        goto L4
    L9:
        r105.setVisible(true);
        r104 = r104 + r105.getCount();
        r102.add(r105);
        goto L4
    L11:
        ga0(r102);
        TextView r107 = null;
        if (r101 == false) goto L17;
        BaseRecyclerView r108 = this.f237776y;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r108 = null;
    L16:
        r108.smoothScrollToPosition(0);
    L17:
        TextView r109 = this.f237773v;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("valueCount");
    L21:
        r107.setText(String.valueOf(r104));
        ha0();
        return;
    L20:
        r107 = r109;
        goto L21
    }

    public final void ia0(View r100, boolean r101) {
        r100.setEnabled(r101);
        r100.setClickable(r101);
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        BaseRecyclerView r102 = (BaseRecyclerView) r100.findViewById(R.id.value_list_recycler_view);
        this.f237776y = r102;
        View r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r102 = null;
    L5:
        final FragmentActivity r104 = getActivity();
        r102.setLayoutManager(new AnonymousClass1(r104));
        FilterValueAdapter r105 = new FilterValueAdapter(this.C);
        r105.f237714b = this;
        BaseRecyclerView r106 = this.f237776y;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r106 = null;
    L8:
        r106.setAdapter(r105);
        this.B = r105;
        this.f237773v = (TextView) r100.findViewById(R.id.filter_value_total_count);
        this.f237774w = (TextView) r100.findViewById(R.id.filter_value_total_count_left);
        this.f237775x = (TextView) r100.findViewById(R.id.filter_value_total_count_right);
        this.f237766o = r100.findViewById(R.id.sheet_filter_search_layout);
        View r107 = r100.findViewById(R.id.search);
        this.f237767p = r107;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
        r107 = null;
    L11:
        r107.setOnClickListener(new e(this));
        this.f237768q = r100.findViewById(R.id.select_all_layout);
        this.f237769r = (UDCheckBox) r100.findViewById(R.id.select_all_check_box);
        this.f237770s = r100.findViewById(R.id.select_all_hint);
        View r108 = this.f237768q;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllLayout");
        r108 = null;
    L14:
        r108.setOnClickListener(new f(this));
        UDCheckBox r109 = this.f237769r;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        r109 = null;
    L17:
        r109.setOnClickListener(new g(this));
        View r110 = r100.findViewById(R.id.search_clear_icon);
        this.f237772u = r110;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("searchClearIcon");
        r110 = null;
    L20:
        r110.setOnClickListener(new h(this));
        SpaceEditText r111 = (SpaceEditText) r100.findViewById(R.id.search_et);
        this.f237771t = r111;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r111 = null;
    L23:
        r111.addTextChangedListener(this.A);
        SpaceEditText r112 = this.f237771t;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        r112 = null;
    L26:
        r112.setOnEditorActionListener(new i(this));
        Z90().getFilterPageData().observe(this, new j(this));
        com.bytedance.ee.bear.facade.common.widget.d r113 = W90().f237475x;
        if (r113.b() < ((int) r113.f226588c[2])) goto L29;
        boolean r114 = true;
    L30:
        if (r114 == false) goto L39;
        View r115 = this.f237766o;
        if (r115 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("searchBox");
        r115 = null;
    L34:
        r115.setVisibility(0);
        View r116 = this.f237767p;
        if (r116 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
    L38:
        r103.setVisibility(8);
        goto L39
    L37:
        r103 = r116;
    L39:
        this.L = new uu5.d(200, new k(this));
        return;
    L29:
        r114 = false;
        goto L30
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
        if (r101 <= 0) goto L6;
        ca0(true);
        return;
    }
}
