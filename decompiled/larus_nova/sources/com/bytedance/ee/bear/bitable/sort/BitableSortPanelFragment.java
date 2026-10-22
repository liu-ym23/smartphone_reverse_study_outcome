package com.bytedance.ee.bear.bitable.sort;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.common.model.condition.EFilterSortFieldInvalidType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.query.EQueryType;
import com.bytedance.ee.bear.bitable.common.widgets.common.AllowClickInDisableUDSwitch;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionCellView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionView;
import com.bytedance.ee.bear.bitable.filtersortviewsetting.BitableFilterSortViewSettingPanel;
import com.bytedance.ee.bear.bitable.filtersortviewsetting.FilterSortViewSettingViewModel;
import com.bytedance.ee.bear.bitable.panel.BitablePanelFragment;
import com.bytedance.ee.bear.bitable.panel.BitablePanelItem;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.EPanelAction;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.EPanelOperationAction;
import com.bytedance.ee.bear.bitable.toolbox.model.panel.PanelData;
import com.bytedance.ee.bear.bitable.toolbox.viewmodel.BitableToolboxViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002bcB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u00104\u001a\u0004\u0018\u00010\u000b2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010=\u001a\u00020\u001fH\u0002J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u000bH\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\u0006\u0010A\u001a\u00020\u001fJ\b\u0010B\u001a\u00020\u001fH\u0002J\u0006\u0010C\u001a\u00020\u001fJ\u0006\u0010D\u001a\u00020\u001fJ\r\u0010E\u001a\u0004\u0018\u000103¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020\u001fJ\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u000203H\u0002J\b\u0010K\u001a\u000203H\u0002J\u0012\u0010L\u001a\u00020\u001f2\b\b\u0002\u0010M\u001a\u000203H\u0002J\u0010\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001eH\u0002J\u0010\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010S\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020R2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010W\u001a\u00020\u001fH\u0002J\u0018\u0010X\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020UH\u0002J\u0018\u0010\\\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020UH\u0002J\b\u0010]\u001a\u00020\u001fH\u0002J\b\u0010^\u001a\u00020\u001fH\u0002J\b\u0010_\u001a\u00020\u001fH\u0016J\b\u0010`\u001a\u00020\u001fH\u0016J\b\u0010a\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\b\u0012\u00060\u001aR\u00020\u00000\u0019j\f\u0012\b\u0012\u00060\u001aR\u00020\u0000`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortPanelFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$OnConditionListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "<init>", "()V", "mSortPanel", "Landroidx/core/widget/NestedScrollView;", "mNotice", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "mSortInfoContainer", "Landroid/view/View;", "mAutoSortContainer", "mAutoSortSwitch", "Lcom/bytedance/ee/bear/bitable/common/widgets/common/AllowClickInDisableUDSwitch;", "mAutoSortWrapper", "mSortConditionsView", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;", "mEmptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mSelectorPanel", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelFragment;", "mCurrentSortData", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData;", "mSortedConditionItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortPanelFragment$SortedConditionItem;", "Lkotlin/collections/ArrayList;", "mPanelActionListener", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/EPanelAction;", "", "mToolboxViewModel", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "getMToolboxViewModel", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "mToolboxViewModel$delegate", "Lkotlin/Lazy;", "mPanelDelegate", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "getMPanelDelegate", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "mPanelAnalytic", "Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;", "getMPanelAnalytic", "()Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mFilterSortViewSettingViewModel", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel;", "isFragmentInForseti", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initFilterSortViewSettingControl", "initView", RootDescription.ROOT_ELEMENT, "updateAddConditionBtnState", "handleClickAddCondition", "updateEmptyStateHeight", "attachViewTreeObserver", "detachViewTreeObserver", "isAutoSort", "()Ljava/lang/Boolean;", "applySort", "updateApplyMenuStateV2", "updateView", "renderNotice", "isNoPermission", "fetchSortDataAndRender", "firstRender", "onPanelActionDispatched", "action", "onConditionClick", "conditionConfig", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionConfig;", "onConditionItemClick", "index", "", "onConditionRemove", "addNewSortCondition", "modifySortConditionField", "sortedField", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;", "sortedConditionIndex", "modifySortConditionDesc", "onSortConditionChanged", "executeSortCommands", WidgetCostModule.TYPE_ON_START, "onDraw", LiveCommonConstants.REASON_ON_DEDTROY, "SortedConditionItem", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSortPanelFragment extends BaseFragment implements ConditionListView.d, ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f215552u = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NestedScrollView f215553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDNotice f215554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f215555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f215556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AllowClickInDisableUDSwitch f215557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f215558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ConditionListView f215559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SpaceEmptyState f215560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BitablePanelFragment f215561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BitableSortData f215562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<b> f215563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<EPanelAction, Unit> f215564p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f215565q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompositeDisposable f215566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FilterSortViewSettingViewModel f215567s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f215568t;

    public static final class a {
    }

    public final class b implements ConditionListView.a, ConditionListView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f215569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BitableSortData.SortedField f215570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final BitableSortData.SortFieldOption f215571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BitableSortPanelFragment f215572d;

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
        public final /* synthetic */ String getCallbackId() {
            throw null;
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.a
        public final List<ConditionListView.b> e() {
            ArrayList r100 = new ArrayList();
            BitableSortData.SortFieldOption r101 = this.f215571c;
            int r102 = 0;
            if (r101 == null) goto L10;
            Integer r103 = r101.getInvalidType();
            int r104 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
            if (r103 == null) goto L10;
            if (r103.intValue() != r104) goto L10;
            boolean r105 = true;
        L11:
            if (r105 == false) goto L13;
            r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, null, null, false, 15));
        L32:
            return r100;
        L13:
            BitableSortData.SortFieldOption r106 = this.f215571c;
            if (r106 == null) goto L32;
            BitableSortData.OrderOption[] r107 = r106.getOrders();
            String r108 = null;
            if (r107 == null) goto L27;
            int r109 = r107.length;
        L18:
            if (r102 >= r109) goto L27;
            BitableSortData.OrderOption r110 = r107[r102];
            Boolean r111 = r110.getDesc();
            BitableSortData.SortedField r112 = this.f215570b;
            if (r112 == null) goto L22;
            Boolean r113 = r112.getDesc();
        L24:
            if (Intrinsics.areEqual(r111, r113) == true) goto L28;
            r102 = r102 + 1;
        L28:
            r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r106.getName(), null, Integer.valueOf(r106.getFieldCompositeType().getIcon()), r106.isSync(), 2));
            if (r110 == null) goto L31;
            r108 = r110.getText();
        L31:
            r100.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r108, null, null, false, 14));
            goto L32
        L22:
            r113 = null;
        L27:
            r110 = null;
        L10:
            r105 = false;
            goto L11
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
        public final void a(ConditionView r100) {
            Intrinsics.checkNotNullParameter(r100, "conditionView");
            r100.setConditionTitle(xo5.a.c(this.f215572d.requireContext(), R.string.Bitable_Relation_DefaultConditionName_Mobile, "num", String.valueOf(this.f215569a + 1)));
        }

        public b(BitableSortPanelFragment r100, int r101) {
            this.f215572d = r100;
            this.f215569a = r101;
            BitableSortData r102 = r100.f215562n;
            BitableSortData.SortFieldOption r103 = null;
            if (r102 == null) goto L7;
            BitableSortData.SortedField[] r104 = r102.getSortInfo();
            if (r104 == null) goto L7;
            BitableSortData.SortedField r105 = r104[r101];
        L8:
            this.f215570b = r105;
            BitableSortData r106 = r100.f215562n;
            if (r106 == null) goto L22;
            BitableSortData.SortFieldOption[] r107 = r106.getFieldOptions();
            if (r107 == null) goto L22;
            int r108 = r107.length;
            int r109 = 0;
        L13:
            if (r109 >= r108) goto L22;
            BitableSortData.SortFieldOption r110 = r107[r109];
            String r111 = r110.getId();
            BitableSortData.SortedField r112 = this.f215570b;
            if (r112 == null) goto L17;
            String r113 = r112.getFieldId();
        L19:
            if (TextUtils.equals(r111, r113) == true) goto L20;
            r109 = r109 + 1;
            goto L13
        L20:
            r103 = r110;
            goto L22
        L17:
            r113 = null;
        L22:
            this.f215571c = r103;
            return;
        L7:
            r105 = null;
            goto L8
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.c
        public final void d(ConditionCellView r100, int r101, ConditionListView.b r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r102, "conditionItem");
            BitableSortData.SortFieldOption r103 = this.f215571c;
            if (r103 == null) goto L10;
            Integer r104 = r103.getInvalidType();
            int r105 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
            if (r104 == null) goto L10;
            if (r104.intValue() != r105) goto L10;
            boolean r106 = true;
        L11:
            if (r106 == false) goto L13;
            r100.setEnabled(false);
            r100.setCellPlaceHolderText(UIHelper.getString(R.string.Bitable_AdvancedPermission_NotAccessibleField));
            return;
        L13:
            r100.setEnabled(true);
            return;
        L10:
            r106 = false;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableSortPanelFragment f215573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f215574b;

        public c(BitableSortPanelFragment r100, boolean r101) {
            this.f215573a = r100;
            this.f215574b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BitableSortData r101 = (BitableSortData) r100;
            BitableSortPanelFragment r102 = this.f215573a;
            r102.f215562n = r101;
            r102.updateView();
            if (this.f215574b == false) goto L12;
            BitableToolboxAnalytic r103 = this.f215573a.X90();
            if (r103 == null) goto L13;
            Boolean r104 = r101.getAutoSort();
            BitableSortData.SortedField[] r105 = r101.getSortInfo();
            if (r105 == null) goto L9;
            Integer r106 = Integer.valueOf(r105.length);
        L10:
            r103.Q(r104, r106, null);
            return;
        L9:
            r106 = null;
            goto L10
        L13:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f215575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableSortPanelFragment f215576b;

        public d(boolean r100, BitableSortPanelFragment r101) {
            this.f215575a = r100;
            this.f215576b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("BitableSortPanelFragment", "fetchSortData failed: " + ((Throwable) r100));
            if (this.f215575a == false) goto L18;
            Toast.showFailureText(this.f215576b.getContext(), R.string.Bitable_Error_SyetemErrorCommonTips_Mobile);
            Fragment r101 = this.f215576b.getParentFragment();
            if ((r101 instanceof BaseActionPanelFragment) == false) goto L7;
            BaseActionPanelFragment r102 = (BaseActionPanelFragment) r101;
        L8:
            if (r102 == null) goto L19;
            r102.dismissAllowingStateLoss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L20;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void Cj(ConditionListView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionItem");
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void ys(ConditionListView.a r100) {
        Intrinsics.checkNotNullParameter(r100, "conditionConfig");
    }

    public final void U90() {
        NestedScrollView r100 = this.f215553e;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
        r100 = null;
    L7:
        r100.getViewTreeObserver().removeOnDrawListener(this);
    }

    public final void V90() {
        JSONObject r100 = new JSONObject();
        BitableSortData r101 = this.f215562n;
        if (r101 == null) goto L5;
        Boolean r102 = r101.getAutoSort();
    L6:
        r100.put2("autoSort", r102);
        BitableSortData r103 = this.f215562n;
        if (r103 == null) goto L10;
        BitableSortData.SortedField[] r104 = r103.getSortInfo();
        if (r104 == null) goto L10;
    L11:
        r100.put2("sortInfo", r104);
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r105 = Y90().getPanelDelegate();
        if (r105 == null) goto L15;
        r105.c(EPanelOperationAction.SORT_RECORD, r100);
        return;
    L15:
        return;
    L10:
        r104 = new BitableSortData.SortedField[0];
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public final BitableToolboxViewModel Y90() {
        return (BitableToolboxViewModel) this.f215565q.getValue();
    }

    public final void Z90() {
        BitableSortData r100 = this.f215562n;
        NestedScrollView r101 = null;
        boolean r102 = true;
        if (r100 == null) goto L5;
        List r103 = BitableSortData.findUnSortedFieldOptions$default(r100, null, 1, null);
    L6:
        List r104 = r103;
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        boolean r106 = !r105;
        BitableSortData r107 = this.f215562n;
        if (r107 != null) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L21;
        Toast.showText(requireContext(), xo5.a.c(getContext(), R.string.Bitable_AdvancedPerm_MaxLmtOfSortConditionsReached_Toast, "num", "20"));
        return;
    L21:
        if (r106 == false) goto L81;
        tt5.a.b("BitableSortPanelFragment", "addNewSortCondition()...");
        BitableSortData r109 = this.f215562n;
        if (r109 == null) goto L25;
        List r110 = BitableSortData.findUnSortedFieldOptions$default(r109, null, 1, null);
    L26:
        List r111 = r110;
        if (r111 != null) goto L29;
    L32:
        boolean r112 = true;
    L33:
        if (r112 == true) goto L86;
        BitableSortData.SortedField r113 = new BitableSortData.SortedField(((BitableSortData.SortFieldOption) ListProtector.get(r110, 0)).getId(), Boolean.FALSE);
        BitableSortData r114 = this.f215562n;
        if (r114 == null) goto L40;
        BitableSortData.SortedField[] r115 = r114.getSortInfo();
        if (r115 == null) goto L40;
        int r116 = r115.length;
    L41:
        if (r116 <= 0) goto L53;
        BitableSortData r117 = this.f215562n;
        if (r117 == null) goto L49;
        BitableSortData.SortedField[] r118 = r117.getSortInfo();
        if (r118 == null) goto L49;
        List r119 = ArraysKt.toMutableList(r118);
        if (r119 == null) goto L49;
        r119.add(r113);
        BitableSortData.SortedField[] r120 = (BitableSortData.SortedField[]) r119.toArray(new BitableSortData.SortedField[0]);
    L50:
        BitableSortData r121 = this.f215562n;
        if (r121 == null) goto L59;
        r121.setSortInfo(r120);
    L59:
        aa0();
        updateView();
        Fragment r122 = getParentFragment();
        if ((r122 instanceof BaseActionPanelFragment) == false) goto L62;
        BaseActionPanelFragment r123 = (BaseActionPanelFragment) r122;
    L63:
        if (r123 == null) goto L74;
        BottomSheetBehavior<FrameLayout> r124 = r123.ga0();
        if (r124 != null) goto L67;
    L69:
        r102 = false;
    L70:
        if (r102 == true) goto L74;
        BottomSheetBehavior<FrameLayout> r125 = r123.ga0();
        if (r125 == null) goto L74;
        r125.setState(3);
        goto L74
    L67:
        if (r124.getState() != 3) goto L69;
    L74:
        NestedScrollView r126 = this.f215553e;
        if (r126 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
    L78:
        r101.post(new com.bytedance.ee.bear.bitable.sort.b(this));
        BitableToolboxAnalytic r127 = X90();
        if (r127 == null) goto L84;
        BitableToolboxAnalytic.O(r127, "add_click", null, null, null, 14);
        return;
    L84:
        return;
    L77:
        r101 = r126;
        goto L78
    L62:
        r123 = null;
    L49:
        r120 = null;
        goto L50
    L53:
        BitableSortData.SortedField[] r128 = {r113};
        BitableSortData r129 = this.f215562n;
        if (r129 == null) goto L56;
        r129.setSortInfo(r128);
    L56:
        BitableSortData r130 = this.f215562n;
        if (r130 == null) goto L59;
        r130.setAutoSort(Boolean.valueOf(com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.bitable.default_auto_sort_v1")));
    L40:
        r116 = 0;
        goto L41
    L86:
        return;
    L29:
        if (r111.isEmpty() == true) goto L32;
        r112 = false;
        goto L33
    L25:
        r110 = null;
        goto L26
    L81:
        Toast.showText(requireContext(), getString(R.string.Bitable_Field_SortConditionMaxError_Toast_Mobile));
        return;
    L16:
        if (r107.isOverMaxSize() != true) goto L18;
        r108 = true;
        goto L19
    L9:
        if (r104.isEmpty() == true) goto L12;
        r105 = false;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void aa0() {
        BitableSortData r100 = this.f215562n;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.getAutoSort(), Boolean.TRUE);
    L6:
        if (r101 == false) goto L9;
        V90();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void ba0() {
        FilterSortViewSettingViewModel r100 = this.f215567s;
        TextView r101 = null;
        if (r100 == null) goto L7;
        MutableLiveData<String> r102 = r100.getCurrentTab();
        if (r102 == null) goto L7;
        String r103 = r102.getValue();
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L11;
    L13:
        BitableSortData r104 = this.f215562n;
        boolean r105 = true;
        if (r104 == null) goto L16;
        List r106 = BitableSortData.findUnSortedFieldOptions$default(r104, null, 1, null);
    L17:
        List r107 = r106;
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        boolean r109 = !r108;
        BitableSortData r110 = this.f215562n;
        if (r110 != null) goto L27;
    L29:
        boolean r111 = false;
    L30:
        Fragment r112 = getParentFragment();
        if ((r112 instanceof BaseActionPanelFragment) == false) goto L33;
        BaseActionPanelFragment r113 = (BaseActionPanelFragment) r112;
    L34:
        if (r113 == null) goto L36;
        View r114 = r113.fa0();
    L37:
        if (r114 == null) goto L58;
        AppCompatImageView r115 = r113.f209823x;
        if (r115 != null) goto L41;
        r115 = null;
    L41:
        if (r115 == null) goto L47;
        if (r109 == false) goto L45;
        if (r111 == true) goto L45;
        boolean r116 = true;
    L46:
        r115.setEnabled(r116);
    L45:
        r116 = false;
    L47:
        TextView r117 = r113.f209824y;
        if (r117 == null) goto L51;
        r101 = r117;
    L51:
        if (r101 == null) goto L59;
        if (r109 == false) goto L55;
        if (r111 == true) goto L55;
    L56:
        r101.setEnabled(r105);
        return;
    L55:
        r105 = false;
        goto L56
    L59:
        return;
    L58:
        return;
    L36:
        r114 = null;
        goto L37
    L33:
        r113 = null;
        goto L34
    L27:
        if (r110.isOverMaxSize() != true) goto L29;
        r111 = true;
        goto L30
    L20:
        if (r107.isEmpty() == true) goto L23;
        r108 = false;
        goto L24
    L16:
        r106 = null;
        goto L17
    L11:
        if (Intrinsics.areEqual(r103, "sort") == true) goto L13;
        return;
    L7:
        r103 = null;
        goto L9
    }

    public final void updateView() {
        BitableSortData r100 = this.f215562n;
        if (r100 == null) goto L7;
        BitableSortData.SortedField[] r101 = r100.getSortInfo();
        if (r101 == null) goto L7;
        int r102 = r101.length;
    L8:
        boolean r103 = true;
        if (r102 <= 0) goto L11;
        boolean r104 = true;
    L12:
        View r105 = this.f215555g;
        Integer r106 = null;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSortInfoContainer");
        r105 = null;
    L16:
        if (r104 == false) goto L18;
        int r107 = 0;
    L19:
        r105.setVisibility(r107);
        SpaceEmptyState r108 = this.f215560l;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r108 = null;
    L22:
        if (r104 == false) goto L24;
        int r109 = 8;
    L25:
        r108.setVisibility(r109);
        if (r104 == false) goto L79;
        AllowClickInDisableUDSwitch r110 = this.f215557i;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r110 = null;
    L30:
        BitableSortData r111 = this.f215562n;
        if (r111 == null) goto L35;
        Boolean r112 = r111.getAutoSort();
        if (r112 == null) goto L35;
        boolean r113 = r112.booleanValue();
    L36:
        r110.setChecked(r113);
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile.partial_load_enabled") == false) goto L58;
        BitableSortData r114 = this.f215562n;
        if (r114 == null) goto L41;
        boolean r115 = Intrinsics.areEqual(r114.getDisposableSortEnabled(), Boolean.FALSE);
    L43:
        if (r115 == false) goto L48;
        View r116 = this.f215558j;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortWrapper");
        r116 = null;
    L47:
        r116.setVisibility(8);
    L65:
        this.f215563o.clear();
        BitableSortData r117 = this.f215562n;
        if (r117 == null) goto L70;
        BitableSortData.SortedField[] r118 = r117.getSortInfo();
        if (r118 == null) goto L70;
        int r119 = r118.length;
    L71:
        int r120 = 0;
    L72:
        if (r120 >= r119) goto L74;
        this.f215563o.add(new b(this, r120));
        r120 = r120 + 1;
        goto L72
    L74:
        ConditionListView r121 = this.f215559k;
        if (r121 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mSortConditionsView");
        r121 = null;
    L77:
        r121.r(this.f215563o);
    L84:
        ca0();
        ba0();
        BitableSortData r122 = this.f215562n;
        if (r122 == null) goto L109;
        BitableSortData.SortedField[] r123 = r122.getSortInfo();
        if (r123 == null) goto L109;
        int r124 = r123.length;
        int r125 = 0;
    L89:
        if (r125 >= r124) goto L109;
        BitableSortData.SortedField r126 = r123[r125];
        BitableSortData r127 = this.f215562n;
        if (r127 == null) goto L108;
        BitableSortData.SortFieldOption[] r128 = r127.getFieldOptions();
        if (r128 == null) goto L108;
        int r129 = r128.length;
        int r130 = 0;
    L95:
        if (r130 >= r129) goto L100;
        BitableSortData.SortFieldOption r131 = r128[r130];
        if (TextUtils.equals(r131.getId(), r126.getFieldId()) == true) goto L101;
        r130 = r130 + 1;
    L101:
        if (r131 == null) goto L108;
        Integer r132 = r131.getInvalidType();
        int r133 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
        if (r132 == null) goto L108;
        if (r132.intValue() != r133) goto L108;
        boolean r134 = true;
    L110:
        BitableSortData r135 = this.f215562n;
        if (r135 == null) goto L113;
        String r136 = r135.getNotice();
    L115:
        if (r134 == false) goto L123;
        UDNotice r137 = this.f215554f;
        if (r137 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r137 = null;
    L119:
        r137.setVisibility(0);
        UDNotice r138 = this.f215554f;
        if (r138 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r138 = null;
    L122:
        r138.setText(R.string.Bitable_AdvancedPerm_FailToSortInView_Tooltip);
    L140:
        BitableToolboxAnalytic r139 = X90();
        if (r139 == null) goto L163;
        BitableSortData r140 = this.f215562n;
        if (r140 == null) goto L145;
        Boolean r141 = r140.getAutoSort();
    L146:
        BitableSortData r142 = this.f215562n;
        if (r142 == null) goto L151;
        BitableSortData.SortedField[] r143 = r142.getSortInfo();
        if (r143 == null) goto L151;
        r106 = Integer.valueOf(r143.length);
    L151:
        r139.Q(r141, r106, Boolean.valueOf(r134));
        return;
    L145:
        r141 = null;
        goto L146
    L163:
        return;
    L123:
        if (r136 != null) goto L125;
    L128:
        if (r103 == true) goto L136;
        UDNotice r144 = this.f215554f;
        if (r144 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r144 = null;
    L132:
        r144.setVisibility(0);
        UDNotice r145 = this.f215554f;
        if (r145 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r145 = null;
    L135:
        r145.setText(r136);
        goto L140
    L136:
        UDNotice r146 = this.f215554f;
        if (r146 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r146 = null;
    L139:
        r146.setVisibility(8);
        goto L140
    L125:
        if (r136.length() == 0) goto L128;
        r103 = false;
        goto L128
    L113:
        r136 = null;
        goto L115
    L100:
        r131 = null;
    L108:
        r125 = r125 + 1;
    L109:
        r134 = false;
    L70:
        r119 = 0;
        goto L71
    L48:
        View r147 = this.f215558j;
        if (r147 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortWrapper");
        r147 = null;
    L51:
        r147.setVisibility(0);
        AllowClickInDisableUDSwitch r148 = this.f215557i;
        if (r148 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r148 = null;
    L54:
        r148.setEnabled(true);
        AllowClickInDisableUDSwitch r149 = this.f215557i;
        if (r149 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r149 = null;
    L57:
        r149.setAllowClickInDisable(false);
        goto L65
    L41:
        r115 = false;
        goto L43
    L58:
        AllowClickInDisableUDSwitch r150 = this.f215557i;
        if (r150 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r150 = null;
    L61:
        r150.setEnabled(true);
        AllowClickInDisableUDSwitch r151 = this.f215557i;
        if (r151 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r151 = null;
    L64:
        r151.setAllowClickInDisable(false);
    L35:
        r113 = false;
        goto L36
    L79:
        if (this.f215568t == false) goto L84;
        SpaceEmptyState r152 = this.f215560l;
        if (r152 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r152 = null;
    L83:
        r152.post(new g(this));
        goto L84
    L24:
        r109 = 0;
        goto L25
    L18:
        r107 = 8;
        goto L19
    L11:
        r104 = false;
    L7:
        r102 = 0;
        goto L8
    }

    public BitableSortPanelFragment() {
        this.f215563o = new ArrayList();
        this.f215564p = new BitableSortPanelFragment$mPanelActionListener$1(this);
        this.f215565q = LazyKt.lazy(new BitableSortPanelFragment$mToolboxViewModel$2(this));
        this.f215566r = new CompositeDisposable();
    }

    public final BitableToolboxAnalytic X90() {
        return Y90().getToolboxAnalytic();
    }

    public final void ca0() {
        Fragment r100 = getParentFragment();
        Boolean r101 = null;
        if ((r100 instanceof BitableFilterSortViewSettingPanel) == false) goto L5;
        BitableFilterSortViewSettingPanel r102 = (BitableFilterSortViewSettingPanel) r100;
    L6:
        FilterSortViewSettingViewModel r103 = this.f215567s;
        if (r103 == null) goto L11;
        MutableLiveData<String> r104 = r103.getCurrentTab();
        if (r104 == null) goto L11;
        String r105 = r104.getValue();
    L12:
        if (r102 == null) goto L18;
        BitableSortData r106 = this.f215562n;
        if (r106 == null) goto L16;
        r101 = r106.getAutoSort();
    L16:
        r102.Aa0(r105, r101);
        return;
    L18:
        return;
    L11:
        r105 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        U90();
        BitablePanelFragment r100 = this.f215561m;
        if (r100 != null) goto L15;
    L10:
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r101 = Y90().getPanelDelegate();
        if (r101 == null) goto L13;
        r101.handleOrientationState(false);
        r101.d(this.f215564p);
        r101.c(EPanelOperationAction.CLOSE_SORT_PANEL, null);
    L13:
        this.f215566r.dispose();
        return;
    L15:
        r100.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        Fragment r100 = getParentFragment();
        SpaceEmptyState r101 = null;
        if ((r100 instanceof BaseActionPanelFragment) == false) goto L5;
        BaseActionPanelFragment r102 = (BaseActionPanelFragment) r100;
    L6:
        if (r102 == null) goto L8;
        View r103 = r102.fa0();
    L9:
        int[] r104 = new int[2];
        NestedScrollView r105 = this.f215553e;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
        r105 = null;
    L12:
        r105.getLocationInWindow(r104);
        int[] r106 = new int[2];
        if (r103 == null) goto L15;
        r103.getLocationInWindow(r106);
    L15:
        int r107 = r106[1] - r104[1];
        if (r103 == null) goto L22;
        if (r107 <= 0) goto L19;
        int r108 = 0;
    L20:
        r103.setVisibility(r108);
        goto L22
    L19:
        r108 = 8;
    L22:
        if (this.f215568t == true) goto L39;
        SpaceEmptyState r109 = this.f215560l;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r109 = null;
    L27:
        if (r109.getVisibility() != 0) goto L40;
        SpaceEmptyState r110 = this.f215560l;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r110 = null;
    L31:
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L41;
        r111.height = r107;
        SpaceEmptyState r112 = this.f215560l;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L37:
        r101.setLayoutParams(r111);
        return;
    L36:
        r101 = r112;
        goto L37
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    public final void W90(boolean r100) {
        tt5.a.b("BitableSortPanelFragment", "fetchSortDataAndRender()...");
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r101 = Y90().getPanelDelegate();
        Disposable r102 = null;
        if (r101 == null) goto L7;
        Observable r103 = com.bytedance.ee.bear.bitable.toolbox.viewmodel.a.a(r101, EQueryType.GET_SORT_DATA, BitableSortData.class, null, 10);
        if (r103 == null) goto L7;
        r102 = r103.subscribe(new c(this, r100), new d(r100, this));
    L7:
        if (r102 == null) goto L10;
        this.f215566r.add(r102);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void YS(ConditionListView.a r110) {
        Intrinsics.checkNotNullParameter(r110, "conditionConfig");
        int r111 = CollectionsKt.indexOf(this.f215563o, r110);
        tt5.a.b("BitableSortPanelFragment", "onConditionRemove()... sortedConditionIndex = " + r111);
        if (r111 < 0) goto L51;
        BitableSortData r100 = this.f215562n;
        int r101 = 0;
        if (r100 == null) goto L9;
        BitableSortData.SortedField[] r102 = r100.getSortInfo();
        if (r102 == null) goto L9;
        int r103 = r102.length;
    L10:
        if (r111 >= r103) goto L52;
        BitableSortData r104 = this.f215562n;
        FieldCompositeType r105 = null;
        if (r104 == null) goto L16;
        BitableSortData.SortedField[] r106 = r104.getSortInfo();
        if (r106 == null) goto L16;
        BitableSortData.SortedField r112 = r106[r111];
    L17:
        BitableSortData r107 = this.f215562n;
        if (r107 == null) goto L24;
        BitableSortData.SortedField[] r108 = r107.getSortInfo();
        if (r108 == null) goto L24;
        List r109 = ArraysKt.toMutableList(r108);
        if (r109 == null) goto L24;
        List r113 = r109;
        TypeIntrinsics.asMutableCollection(r113).remove(r112);
        BitableSortData.SortedField[] r114 = (BitableSortData.SortedField[]) r113.toArray(new BitableSortData.SortedField[0]);
    L25:
        BitableSortData r115 = this.f215562n;
        if (r115 == null) goto L28;
        r115.setSortInfo(r114);
    L28:
        updateView();
        aa0();
        BitableSortData r116 = this.f215562n;
        if (r116 == null) goto L45;
        BitableSortData.SortFieldOption[] r117 = r116.getFieldOptions();
        if (r117 == null) goto L45;
        int r118 = r117.length;
    L33:
        if (r101 >= r118) goto L42;
        BitableSortData.SortFieldOption r119 = r117[r101];
        String r120 = r119.getId();
        if (r112 == null) goto L37;
        String r121 = r112.getFieldId();
    L39:
        if (TextUtils.equals(r120, r121) == true) goto L43;
        r101 = r101 + 1;
    L43:
        if (r119 == null) goto L45;
        r105 = r119.getFieldCompositeType();
        goto L45
    L37:
        r121 = null;
        goto L39
    L42:
        r119 = null;
    L45:
        FieldCompositeType r122 = r105;
        BitableToolboxAnalytic r123 = X90();
        if (r123 == null) goto L53;
        BitableToolboxAnalytic.O(r123, "delete_click", null, r122, null, 10);
        return;
    L53:
        return;
    L24:
        r114 = null;
    L16:
        r112 = null;
        goto L17
    L52:
        return;
    L9:
        r103 = 0;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.d
    public final void Fi(ConditionListView.a r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "conditionConfig");
        int r100 = CollectionsKt.indexOf(this.f215563o, r110);
        if (r100 < 0) goto L103;
        BitableSortData r101 = this.f215562n;
        if (r101 == null) goto L9;
        BitableSortData.SortedField[] r102 = r101.getSortInfo();
        if (r102 == null) goto L9;
        int r103 = r102.length;
    L10:
        if (r100 >= r103) goto L103;
        BitableSortData r104 = this.f215562n;
        FieldCompositeType r105 = null;
        if (r104 == null) goto L17;
        BitableSortData.SortedField[] r106 = r104.getSortInfo();
        if (r106 == null) goto L17;
        BitableSortData.SortedField r107 = r106[r100];
    L18:
        if (r107 == null) goto L113;
        if (r111 != 0) goto L21;
        BitableSortData r108 = this.f215562n;
        if (r108 == null) goto L74;
        BitableSortData.SortFieldOption[] r109 = r108.getFieldOptions();
        if (r109 == null) goto L74;
        int r112 = r109.length;
        int r113 = 0;
    L69:
        if (r113 >= r112) goto L74;
        BitableSortData.SortFieldOption r114 = r109[r113];
        if (TextUtils.equals(r114.getId(), r107.getFieldId()) == true) goto L75;
        r113 = r113 + 1;
    L75:
        Context r115 = getContext();
        FragmentManager r116 = getChildFragmentManager();
        BitablePanelModel r117 = new BitablePanelModel();
        r117.setTitle(getString(R.string.Bitable_Relation_SelectField_Mobile));
        BitableSortData r118 = this.f215562n;
        if (r118 == null) goto L83;
        List<BitableSortData.SortFieldOption> r119 = r118.findUnSortedFieldOptions(r114);
        if (r119 == null) goto L83;
        List<BitableSortData.SortFieldOption> r120 = r119;
        ArrayList<BitablePanelItem> r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator<T> r122 = r120.iterator();
    L81:
        if (r122.hasNext() == false) goto L84;
        BitableSortData.SortFieldOption r123 = (BitableSortData.SortFieldOption) r122.next();
        BitablePanelItem r124 = new BitablePanelItem();
        r124.setId(r123.getId());
        r124.setLeftText(r123.getName());
        Icon r125 = new Icon();
        r125.setImgRes(Integer.valueOf(r123.getFieldCompositeType().getIcon()));
        r125.setSync(r123.isSync());
        r124.setLeftIcon(r125);
        com.bytedance.ee.bear.bitable.panel.e.b(r124, Intrinsics.areEqual(r107.getFieldId(), r123.getId()));
        com.bytedance.ee.bear.bitable.panel.e.a(r124);
        r121.add(r124);
    L84:
        r117.setData(r121);
        PanelData r126 = Y90().getPanelData().getValue();
        if (r126 == null) goto L87;
        String r127 = r126.getSrcObjToken();
    L88:
        r117.setSrcObjToken(r127);
        PanelData r128 = Y90().getPanelData().getValue();
        if (r128 == null) goto L91;
        Integer r129 = r128.getSrcObjType();
    L92:
        r117.setSrcObjType(r129);
        Unit r130 = Unit.INSTANCE;
        f r131 = new f(this, r100, r107);
        if (this.f215568t == false) goto L95;
        BitableSortPanelFragment r132 = this;
    L96:
        this.f215561m = com.bytedance.ee.bear.bitable.panel.e.m(r115, r116, r117, r131, r132, 16);
        BitableToolboxAnalytic r133 = X90();
        if (r133 != null) goto L99;
        return;
    L99:
        if (r114 == null) goto L101;
        r105 = r114.getFieldCompositeType();
    L101:
        BitableToolboxAnalytic.O(r133, "field_click", null, r105, null, 10);
        return;
    L95:
        r132 = null;
        goto L96
    L91:
        r129 = null;
        goto L92
    L87:
        r127 = null;
    L83:
        r121 = null;
    L74:
        r114 = null;
        goto L75
    L21:
        if (r111 != 1) goto L117;
        BitableSortData r134 = this.f215562n;
        if (r134 == null) goto L33;
        BitableSortData.SortFieldOption[] r135 = r134.getFieldOptions();
        if (r135 == null) goto L33;
        int r136 = r135.length;
        int r137 = 0;
    L28:
        if (r137 >= r136) goto L33;
        BitableSortData.SortFieldOption r138 = r135[r137];
        if (TextUtils.equals(r138.getId(), r107.getFieldId()) == true) goto L34;
        r137 = r137 + 1;
    L34:
        Context r139 = getContext();
        FragmentManager r140 = getChildFragmentManager();
        BitablePanelModel r141 = new BitablePanelModel();
        r141.setTitle(getString(R.string.Bitable_Record_SetSortMethod));
        if (r138 == null) goto L45;
        BitableSortData.OrderOption[] r142 = r138.getOrders();
        if (r142 == null) goto L45;
        ArrayList<BitablePanelItem> r143 = new ArrayList(r142.length);
        int r144 = r142.length;
        int r145 = 0;
    L39:
        if (r145 >= r144) goto L46;
        BitableSortData.OrderOption r146 = r142[r145];
        BitablePanelItem r147 = new BitablePanelItem();
        r147.setId(com.bytedance.ee.bear.bitable.panel.e.e(r146.getDesc()));
        r147.setLeftText(r146.getText());
        if (r107.getDesc() != r146.getDesc()) goto L43;
        boolean r148 = true;
    L44:
        com.bytedance.ee.bear.bitable.panel.e.c(r147, r148);
        com.bytedance.ee.bear.bitable.panel.e.a(r147);
        r143.add(r147);
        r145 = r145 + 1;
        goto L39
    L43:
        r148 = false;
    L46:
        r141.setData(r143);
        PanelData r149 = Y90().getPanelData().getValue();
        if (r149 == null) goto L49;
        String r150 = r149.getSrcObjToken();
    L50:
        r141.setSrcObjToken(r150);
        PanelData r151 = Y90().getPanelData().getValue();
        if (r151 == null) goto L53;
        Integer r152 = r151.getSrcObjType();
    L54:
        r141.setSrcObjType(r152);
        Unit r153 = Unit.INSTANCE;
        e r154 = new e(this, r100, r107);
        if (this.f215568t == false) goto L57;
        BitableSortPanelFragment r155 = this;
    L58:
        this.f215561m = com.bytedance.ee.bear.bitable.panel.e.m(r139, r140, r141, r154, r155, 16);
        BitableToolboxAnalytic r156 = X90();
        if (r156 != null) goto L61;
        return;
    L61:
        if (r138 == null) goto L63;
        r105 = r138.getFieldCompositeType();
    L63:
        BitableToolboxAnalytic.O(r156, "group_rule_click", null, r105, r107.getDesc(), 2);
        return;
    L57:
        r155 = null;
        goto L58
    L53:
        r152 = null;
        goto L54
    L49:
        r150 = null;
    L45:
        r143 = null;
    L33:
        r138 = null;
        goto L34
    L117:
        return;
    L113:
        return;
    L17:
        r107 = null;
    L9:
        r103 = 0;
    L103:
        tt5.a.d("BitableSortPanelFragment", "onConditionItemClick()... invalid index");
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r102 = Y90().getPanelDelegate();
        if (r102 == null) goto L5;
        r102.handleOrientationState(true);
    L5:
        this.f215553e = (NestedScrollView) r100.findViewById(R.id.sort_panel);
        this.f215560l = (SpaceEmptyState) r100.findViewById(R.id.empty_state);
        this.f215554f = (UDNotice) r100.findViewById(R.id.notice);
        this.f215555g = r100.findViewById(R.id.sort_info_container);
        ConditionListView r103 = (ConditionListView) r100.findViewById(R.id.sort_conditions_view);
        this.f215559k = r103;
        AllowClickInDisableUDSwitch r104 = null;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSortConditionsView");
        r103 = null;
    L8:
        r103.setOnConditionListener(this);
        this.f215556h = r100.findViewById(R.id.autosort_container);
        this.f215557i = (AllowClickInDisableUDSwitch) r100.findViewById(R.id.autosort_switch);
        this.f215558j = r100.findViewById(R.id.autosort_container);
        AllowClickInDisableUDSwitch r105 = this.f215557i;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
    L12:
        r104.setOnCheckedChangeListener(new com.bytedance.ee.bear.bitable.sort.d(this));
        W90(true);
        Fragment r106 = getParentFragment();
        if (r106 == null) goto L15;
        this.f215567s = (FilterSortViewSettingViewModel) q.a(r106, FilterSortViewSettingViewModel.class);
    L15:
        FilterSortViewSettingViewModel r107 = this.f215567s;
        if (r107 == null) goto L21;
        MutableLiveData<String> r108 = r107.getCurrentTab();
        if (r108 == null) goto L22;
        r108.observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.sort.c(this));
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r104 = r105;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f215568t = r103;
        return r100.inflate(R.layout.bitable_sort_panel_fragment, r101, false);
    L5:
        if (ForsetiHelper.r(this) == false) goto L7;
        r103 = true;
        goto L8
    }
}
