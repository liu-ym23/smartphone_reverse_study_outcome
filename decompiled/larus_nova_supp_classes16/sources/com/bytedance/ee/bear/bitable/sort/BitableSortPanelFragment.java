package com.bytedance.ee.bear.bitable.sort;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
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
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002bcB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u00104\u001a\u0004\u0018\u00010\u000b2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010=\u001a\u00020\u001fH\u0002J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u000bH\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\u0006\u0010A\u001a\u00020\u001fJ\b\u0010B\u001a\u00020\u001fH\u0002J\u0006\u0010C\u001a\u00020\u001fJ\u0006\u0010D\u001a\u00020\u001fJ\r\u0010E\u001a\u0004\u0018\u000103¢\u0006\u0002\u0010FJ\u0006\u0010G\u001a\u00020\u001fJ\b\u0010H\u001a\u00020\u001fH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u000203H\u0002J\b\u0010K\u001a\u000203H\u0002J\u0012\u0010L\u001a\u00020\u001f2\b\b\u0002\u0010M\u001a\u000203H\u0002J\u0010\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001eH\u0002J\u0010\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010S\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020R2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010W\u001a\u00020\u001fH\u0002J\u0018\u0010X\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020UH\u0002J\u0018\u0010\\\u001a\u00020\u001f2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020UH\u0002J\b\u0010]\u001a\u00020\u001fH\u0002J\b\u0010^\u001a\u00020\u001fH\u0002J\b\u0010_\u001a\u00020\u001fH\u0016J\b\u0010`\u001a\u00020\u001fH\u0016J\b\u0010a\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\b\u0012\u00060\u001aR\u00020\u00000\u0019j\f\u0012\b\u0012\u00060\u001aR\u00020\u0000`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/sort/BitableSortPanelFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$OnConditionListener;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "<init>", "()V", "mSortPanel", "Landroidx/core/widget/NestedScrollView;", "mNotice", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "mSortInfoContainer", "Landroid/view/View;", "mAutoSortContainer", "mAutoSortSwitch", "Lcom/bytedance/ee/bear/bitable/common/widgets/common/AllowClickInDisableUDSwitch;", "mAutoSortWrapper", "mSortConditionsView", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView;", "mEmptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mSelectorPanel", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelFragment;", "mCurrentSortData", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData;", "mSortedConditionItems", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortPanelFragment$SortedConditionItem;", "Lkotlin/collections/ArrayList;", "mPanelActionListener", "Lkotlin/Function1;", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/EPanelAction;", "", "mToolboxViewModel", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "getMToolboxViewModel", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/BitableToolboxViewModel;", "mToolboxViewModel$delegate", "Lkotlin/Lazy;", "mPanelDelegate", "Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "getMPanelDelegate", "()Lcom/bytedance/ee/bear/bitable/toolbox/viewmodel/IPanelDelegate;", "mPanelAnalytic", "Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;", "getMPanelAnalytic", "()Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "mFilterSortViewSettingViewModel", "Lcom/bytedance/ee/bear/bitable/filtersortviewsetting/FilterSortViewSettingViewModel;", "isFragmentInForseti", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initFilterSortViewSettingControl", "initView", "root", "updateAddConditionBtnState", "handleClickAddCondition", "updateEmptyStateHeight", "attachViewTreeObserver", "detachViewTreeObserver", "isAutoSort", "()Ljava/lang/Boolean;", "applySort", "updateApplyMenuStateV2", "updateView", "renderNotice", "isNoPermission", "fetchSortDataAndRender", "firstRender", "onPanelActionDispatched", JSEventListener.ACTION, "onConditionClick", "conditionConfig", "Lcom/bytedance/ee/bear/bitable/common/widgets/conditioncard/ConditionListView$ConditionConfig;", "onConditionItemClick", "index", "", "onConditionRemove", "addNewSortCondition", "modifySortConditionField", "sortedField", "Lcom/bytedance/ee/bear/bitable/sort/BitableSortData$SortedField;", "sortedConditionIndex", "modifySortConditionDesc", "onSortConditionChanged", "executeSortCommands", "onStart", "onDraw", "onDestroy", "SortedConditionItem", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSortPanelFragment extends BaseFragment implements ConditionListView.d, ViewTreeObserver.OnDrawListener {
    public static final /* synthetic */ int u = 0;
    public NestedScrollView e;
    public UDNotice f;
    public View g;
    public View h;
    public AllowClickInDisableUDSwitch i;
    public View j;
    public ConditionListView k;
    public SpaceEmptyState l;
    public BitablePanelFragment m;
    public BitableSortData n;
    public final ArrayList<b> o;
    public final Function1<EPanelAction, Unit> p;
    public final Lazy q;
    public final CompositeDisposable r;
    public FilterSortViewSettingViewModel s;
    public boolean t;

    public static final class a {
    }

    public final class b implements ConditionListView.a, ConditionListView.c {
        public final int a;
        public final BitableSortData.SortedField b;
        public final BitableSortData.SortFieldOption c;
        public final /* synthetic */ BitableSortPanelFragment d;

        public final /* synthetic */ String getCallbackId() {
            throw null;
        }

        public final List<ConditionListView.b> e() {
            ArrayList r1 = new ArrayList();
            BitableSortData.SortFieldOption r2 = this.c;
            int r3 = 0;
            if (r2 == null) goto L10;
            Integer r4 = r2.getInvalidType();
            int r5 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
            if (r4 == null) goto L10;
            if (r4.intValue() != r5) goto L10;
            boolean r6 = true;
        L11:
            if (r6 == false) goto L13;
            r1.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(null, null, null, false, 15));
        L32:
            return r1;
        L13:
            BitableSortData.SortFieldOption r7 = this.c;
            if (r7 == null) goto L32;
            BitableSortData.OrderOption[] r8 = r7.getOrders();
            String r9 = null;
            if (r8 == null) goto L27;
            int r10 = r8.length;
        L18:
            if (r3 >= r10) goto L27;
            BitableSortData.OrderOption r11 = r8[r3];
            Boolean r12 = r11.getDesc();
            BitableSortData.SortedField r13 = this.b;
            if (r13 == null) goto L22;
            Boolean r14 = r13.getDesc();
        L24:
            if (Intrinsics.areEqual(r12, r14) == true) goto L28;
            r3 = r3 + 1;
        L28:
            r1.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r7.getName(), null, Integer.valueOf(r7.getFieldCompositeType().getIcon()), r7.isSync(), 2));
            if (r11 == null) goto L31;
            r9 = r11.getText();
        L31:
            r1.add(new com.bytedance.ee.bear.bitable.common.widgets.conditioncard.a(r9, null, null, false, 14));
            goto L32
        L22:
            r14 = null;
        L27:
            r11 = null;
        L10:
            r6 = false;
            goto L11
        }

        public final void a(ConditionView r5) {
            Intrinsics.checkNotNullParameter(r5, "conditionView");
            r5.setConditionTitle(xo5.a.c(this.d.requireContext(), 2131886780, "num", String.valueOf(this.a + 1)));
        }

        public b(BitableSortPanelFragment r6, int r7) {
            this.d = r6;
            this.a = r7;
            BitableSortData r0 = r6.n;
            BitableSortData.SortFieldOption r1 = null;
            if (r0 == null) goto L7;
            BitableSortData.SortedField[] r2 = r0.getSortInfo();
            if (r2 == null) goto L7;
            BitableSortData.SortedField r8 = r2[r7];
        L8:
            this.b = r8;
            BitableSortData r9 = r6.n;
            if (r9 == null) goto L22;
            BitableSortData.SortFieldOption[] r10 = r9.getFieldOptions();
            if (r10 == null) goto L22;
            int r11 = r10.length;
            int r3 = 0;
        L13:
            if (r3 >= r11) goto L22;
            BitableSortData.SortFieldOption r4 = r10[r3];
            String r5 = r4.getId();
            BitableSortData.SortedField r12 = this.b;
            if (r12 == null) goto L17;
            String r13 = r12.getFieldId();
        L19:
            if (TextUtils.equals(r5, r13) == true) goto L20;
            r3 = r3 + 1;
            goto L13
        L20:
            r1 = r4;
            goto L22
        L17:
            r13 = null;
        L22:
            this.c = r1;
            return;
        L7:
            r8 = null;
            goto L8
        }

        public final void d(ConditionCellView r3, int r4, ConditionListView.b r5) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r5, "conditionItem");
            BitableSortData.SortFieldOption r6 = this.c;
            if (r6 == null) goto L10;
            Integer r7 = r6.getInvalidType();
            int r1 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
            if (r7 == null) goto L10;
            if (r7.intValue() != r1) goto L10;
            boolean r8 = true;
        L11:
            if (r8 == false) goto L13;
            r3.setEnabled(false);
            r3.setCellPlaceHolderText(UIHelper.getString(2131886185));
            return;
        L13:
            r3.setEnabled(true);
            return;
        L10:
            r8 = false;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BitableSortPanelFragment a;
        public final /* synthetic */ boolean b;

        public c(BitableSortPanelFragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            BitableSortData r5 = (BitableSortData) r4;
            BitableSortPanelFragment r0 = this.a;
            r0.n = r5;
            r0.updateView();
            if (this.b == false) goto L12;
            BitableToolboxAnalytic r1 = this.a.X90();
            if (r1 == null) goto L13;
            Boolean r2 = r5.getAutoSort();
            BitableSortData.SortedField[] r6 = r5.getSortInfo();
            if (r6 == null) goto L9;
            Integer r7 = Integer.valueOf(r6.length);
        L10:
            r1.Q(r2, r7, null);
            return;
        L9:
            r7 = null;
            goto L10
        L13:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ BitableSortPanelFragment b;

        public d(boolean r1, BitableSortPanelFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            tt5.a.d("BitableSortPanelFragment", "fetchSortData failed: " + ((Throwable) r3));
            if (this.a == false) goto L18;
            Toast.showFailureText(this.b.getContext(), 2131886412);
            BaseActionPanelFragment r4 = this.b.getParentFragment();
            if ((r4 instanceof BaseActionPanelFragment) == false) goto L7;
            BaseActionPanelFragment r5 = r4;
        L8:
            if (r5 == null) goto L19;
            r5.dismissAllowingStateLoss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L20;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r5 = null;
            goto L8
        }
    }

    static {
    }

    public final void Cj(ConditionListView.b r2) {
        Intrinsics.checkNotNullParameter(r2, "conditionItem");
    }

    public final void ys(ConditionListView.a r2) {
        Intrinsics.checkNotNullParameter(r2, "conditionConfig");
    }

    public final void U90() {
        FrameLayout r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
        r0 = null;
    L7:
        r0.getViewTreeObserver().removeOnDrawListener(this);
    }

    public final void V90() {
        JSONObject r0 = new JSONObject();
        BitableSortData r1 = this.n;
        if (r1 == null) goto L5;
        Boolean r2 = r1.getAutoSort();
    L6:
        r0.put("autoSort", r2);
        BitableSortData r3 = this.n;
        if (r3 == null) goto L10;
        BitableSortData.SortedField[] r4 = r3.getSortInfo();
        if (r4 == null) goto L10;
    L11:
        r0.put("sortInfo", r4);
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r5 = Y90().getPanelDelegate();
        if (r5 == null) goto L15;
        r5.c(EPanelOperationAction.SORT_RECORD, r0);
        return;
    L15:
        return;
    L10:
        r4 = new BitableSortData.SortedField[0];
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final BitableToolboxViewModel Y90() {
        return (BitableToolboxViewModel) this.q.getValue();
    }

    public final void Z90() {
        BitableSortData r0 = this.n;
        FrameLayout r1 = null;
        boolean r2 = true;
        if (r0 == null) goto L5;
        List r3 = BitableSortData.findUnSortedFieldOptions$default(r0, null, 1, null);
    L6:
        List r4 = r3;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        boolean r6 = !r5;
        BitableSortData r7 = this.n;
        if (r7 != null) goto L16;
    L18:
        boolean r8 = false;
    L19:
        if (r8 == false) goto L21;
        Toast.showText(requireContext(), xo5.a.c(getContext(), 2131886116, "num", "20"));
        return;
    L21:
        if (r6 == false) goto L81;
        tt5.a.b("BitableSortPanelFragment", "addNewSortCondition()...");
        BitableSortData r9 = this.n;
        if (r9 == null) goto L25;
        List r10 = BitableSortData.findUnSortedFieldOptions$default(r9, null, 1, null);
    L26:
        List r11 = r10;
        if (r11 != null) goto L29;
    L32:
        boolean r12 = true;
    L33:
        if (r12 == true) goto L86;
        BitableSortData.SortedField r13 = new BitableSortData.SortedField(((BitableSortData.SortFieldOption) ListProtector.get(r10, 0)).getId(), Boolean.FALSE);
        BitableSortData r14 = this.n;
        if (r14 == null) goto L40;
        BitableSortData.SortedField[] r16 = r14.getSortInfo();
        if (r16 == null) goto L40;
        int r17 = r16.length;
    L41:
        if (r17 <= 0) goto L53;
        BitableSortData r18 = this.n;
        if (r18 == null) goto L49;
        BitableSortData.SortedField[] r19 = r18.getSortInfo();
        if (r19 == null) goto L49;
        List r20 = ArraysKt.toMutableList(r19);
        if (r20 == null) goto L49;
        r20.add(r13);
        BitableSortData.SortedField[] r21 = (BitableSortData.SortedField[]) r20.toArray(new BitableSortData.SortedField[0]);
    L50:
        BitableSortData r22 = this.n;
        if (r22 == null) goto L59;
        r22.setSortInfo(r21);
    L59:
        aa0();
        updateView();
        BaseActionPanelFragment r23 = getParentFragment();
        if ((r23 instanceof BaseActionPanelFragment) == false) goto L62;
        BaseActionPanelFragment r24 = r23;
    L63:
        if (r24 == null) goto L74;
        BottomSheetBehavior r26 = r24.ga0();
        if (r26 != null) goto L67;
    L69:
        r2 = false;
    L70:
        if (r2 == true) goto L74;
        BottomSheetBehavior r27 = r24.ga0();
        if (r27 == null) goto L74;
        r27.setState(3);
        goto L74
    L67:
        if (r26.getState() != 3) goto L69;
    L74:
        FrameLayout r28 = this.e;
        if (r28 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
    L78:
        r1.post(new com.bytedance.ee.bear.bitable.sort.b(this));
        BitableToolboxAnalytic r29 = X90();
        if (r29 == null) goto L84;
        BitableToolboxAnalytic.O(r29, "add_click", null, null, null, 14);
        return;
    L84:
        return;
    L77:
        r1 = r28;
        goto L78
    L62:
        r24 = null;
    L49:
        r21 = null;
        goto L50
    L53:
        BitableSortData.SortedField[] r30 = {r13};
        BitableSortData r31 = this.n;
        if (r31 == null) goto L56;
        r31.setSortInfo(r30);
    L56:
        BitableSortData r32 = this.n;
        if (r32 == null) goto L59;
        r32.setAutoSort(Boolean.valueOf(com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.default_auto_sort_v1")));
    L40:
        r17 = 0;
        goto L41
    L86:
        return;
    L29:
        if (r11.isEmpty() == true) goto L32;
        r12 = false;
        goto L33
    L25:
        r10 = null;
        goto L26
    L81:
        Toast.showText(requireContext(), getString(2131886486));
        return;
    L16:
        if (r7.isOverMaxSize() != true) goto L18;
        r8 = true;
        goto L19
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void aa0() {
        BitableSortData r0 = this.n;
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.getAutoSort(), Boolean.TRUE);
    L6:
        if (r1 == false) goto L9;
        V90();
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void ba0() {
        FilterSortViewSettingViewModel r0 = this.s;
        TextView r1 = null;
        if (r0 == null) goto L7;
        MutableLiveData r2 = r0.getCurrentTab();
        if (r2 == null) goto L7;
        String r3 = (String) r2.getValue();
    L9:
        if (TextUtils.isEmpty(r3) == false) goto L11;
    L13:
        BitableSortData r4 = this.n;
        boolean r5 = true;
        if (r4 == null) goto L16;
        List r6 = BitableSortData.findUnSortedFieldOptions$default(r4, null, 1, null);
    L17:
        List r7 = r6;
        if (r7 != null) goto L20;
    L23:
        boolean r8 = true;
    L24:
        boolean r9 = !r8;
        BitableSortData r10 = this.n;
        if (r10 != null) goto L27;
    L29:
        boolean r11 = false;
    L30:
        BaseActionPanelFragment r12 = getParentFragment();
        if ((r12 instanceof BaseActionPanelFragment) == false) goto L33;
        BaseActionPanelFragment r13 = r12;
    L34:
        if (r13 == null) goto L36;
        View r14 = r13.fa0();
    L37:
        if (r14 == null) goto L58;
        View r16 = r13.x;
        if (r16 != null) goto L41;
        r16 = null;
    L41:
        if (r16 == null) goto L47;
        if (r9 == false) goto L45;
        if (r11 == true) goto L45;
        boolean r17 = true;
    L46:
        r16.setEnabled(r17);
    L45:
        r17 = false;
    L47:
        TextView r18 = r13.y;
        if (r18 == null) goto L51;
        r1 = r18;
    L51:
        if (r1 == null) goto L59;
        if (r9 == false) goto L55;
        if (r11 == true) goto L55;
    L56:
        r1.setEnabled(r5);
        return;
    L55:
        r5 = false;
        goto L56
    L59:
        return;
    L58:
        return;
    L36:
        r14 = null;
        goto L37
    L33:
        r13 = null;
        goto L34
    L27:
        if (r10.isOverMaxSize() != true) goto L29;
        r11 = true;
        goto L30
    L20:
        if (r7.isEmpty() == true) goto L23;
        r8 = false;
        goto L24
    L16:
        r6 = null;
        goto L17
    L11:
        if (Intrinsics.areEqual(r3, PanelData.TAB_SORT) == true) goto L13;
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void updateView() {
        BitableSortData r0 = this.n;
        if (r0 == null) goto L7;
        BitableSortData.SortedField[] r1 = r0.getSortInfo();
        if (r1 == null) goto L7;
        int r2 = r1.length;
    L8:
        boolean r3 = true;
        if (r2 <= 0) goto L11;
        boolean r4 = true;
    L12:
        View r5 = this.g;
        Integer r6 = null;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSortInfoContainer");
        r5 = null;
    L16:
        if (r4 == false) goto L18;
        int r7 = 0;
    L19:
        r5.setVisibility(r7);
        LinearLayout r8 = this.l;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r8 = null;
    L22:
        if (r4 == false) goto L24;
        int r9 = 8;
    L25:
        r8.setVisibility(r9);
        if (r4 == false) goto L79;
        UDSwitch r10 = this.i;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r10 = null;
    L30:
        BitableSortData r11 = this.n;
        if (r11 == null) goto L35;
        Boolean r12 = r11.getAutoSort();
        if (r12 == null) goto L35;
        boolean r13 = r12.booleanValue();
    L36:
        r10.setChecked(r13);
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile.partial_load_enabled") == false) goto L58;
        BitableSortData r14 = this.n;
        if (r14 == null) goto L41;
        boolean r16 = Intrinsics.areEqual(r14.getDisposableSortEnabled(), Boolean.FALSE);
    L43:
        if (r16 == false) goto L48;
        View r17 = this.j;
        if (r17 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortWrapper");
        r17 = null;
    L47:
        r17.setVisibility(8);
    L65:
        this.o.clear();
        BitableSortData r18 = this.n;
        if (r18 == null) goto L70;
        BitableSortData.SortedField[] r19 = r18.getSortInfo();
        if (r19 == null) goto L70;
        int r20 = r19.length;
    L71:
        int r21 = 0;
    L72:
        if (r21 >= r20) goto L74;
        this.o.add(new b(this, r21));
        r21 = r21 + 1;
        goto L72
    L74:
        ConditionListView r22 = this.k;
        if (r22 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mSortConditionsView");
        r22 = null;
    L77:
        r22.r(this.o);
    L84:
        ca0();
        ba0();
        BitableSortData r23 = this.n;
        if (r23 == null) goto L109;
        BitableSortData.SortedField[] r24 = r23.getSortInfo();
        if (r24 == null) goto L109;
        int r26 = r24.length;
        int r27 = 0;
    L89:
        if (r27 >= r26) goto L109;
        BitableSortData.SortedField r28 = r24[r27];
        BitableSortData r29 = this.n;
        if (r29 == null) goto L108;
        BitableSortData.SortFieldOption[] r30 = r29.getFieldOptions();
        if (r30 == null) goto L108;
        int r31 = r30.length;
        int r110 = 0;
    L95:
        if (r110 >= r31) goto L100;
        BitableSortData.SortFieldOption r111 = r30[r110];
        if (TextUtils.equals(r111.getId(), r28.getFieldId()) == true) goto L101;
        r110 = r110 + 1;
    L101:
        if (r111 == null) goto L108;
        Integer r32 = r111.getInvalidType();
        int r33 = EFilterSortFieldInvalidType.FIELD_UNREADABLE.getValue();
        if (r32 == null) goto L108;
        if (r32.intValue() != r33) goto L108;
        boolean r34 = true;
    L110:
        BitableSortData r36 = this.n;
        if (r36 == null) goto L113;
        String r37 = r36.getNotice();
    L115:
        if (r34 == false) goto L123;
        ViewGroup r38 = this.f;
        if (r38 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r38 = null;
    L119:
        r38.setVisibility(0);
        UDNotice r39 = this.f;
        if (r39 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r39 = null;
    L122:
        r39.setText(2131886114);
    L140:
        BitableToolboxAnalytic r40 = X90();
        if (r40 == null) goto L163;
        BitableSortData r41 = this.n;
        if (r41 == null) goto L145;
        Boolean r42 = r41.getAutoSort();
    L146:
        BitableSortData r43 = this.n;
        if (r43 == null) goto L151;
        BitableSortData.SortedField[] r44 = r43.getSortInfo();
        if (r44 == null) goto L151;
        r6 = Integer.valueOf(r44.length);
    L151:
        r40.Q(r42, r6, Boolean.valueOf(r34));
        return;
    L145:
        r42 = null;
        goto L146
    L163:
        return;
    L123:
        if (r37 != null) goto L125;
    L128:
        if (r3 == true) goto L136;
        ViewGroup r46 = this.f;
        if (r46 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r46 = null;
    L132:
        r46.setVisibility(0);
        UDNotice r47 = this.f;
        if (r47 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r47 = null;
    L135:
        r47.setText(r37);
        goto L140
    L136:
        ViewGroup r48 = this.f;
        if (r48 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("mNotice");
        r48 = null;
    L139:
        r48.setVisibility(8);
        goto L140
    L125:
        if (r37.length() == 0) goto L128;
        r3 = false;
        goto L128
    L113:
        r37 = null;
        goto L115
    L100:
        r111 = null;
    L108:
        r27 = r27 + 1;
    L109:
        r34 = false;
    L70:
        r20 = 0;
        goto L71
    L48:
        View r49 = this.j;
        if (r49 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortWrapper");
        r49 = null;
    L51:
        r49.setVisibility(0);
        CompoundButton r50 = this.i;
        if (r50 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r50 = null;
    L54:
        r50.setEnabled(true);
        AllowClickInDisableUDSwitch r51 = this.i;
        if (r51 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r51 = null;
    L57:
        r51.setAllowClickInDisable(false);
        goto L65
    L41:
        r16 = false;
        goto L43
    L58:
        CompoundButton r52 = this.i;
        if (r52 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r52 = null;
    L61:
        r52.setEnabled(true);
        AllowClickInDisableUDSwitch r53 = this.i;
        if (r53 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
        r53 = null;
    L64:
        r53.setAllowClickInDisable(false);
    L35:
        r13 = false;
        goto L36
    L79:
        if (this.t == false) goto L84;
        LinearLayout r54 = this.l;
        if (r54 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r54 = null;
    L83:
        r54.post(new g(this));
        goto L84
    L24:
        r9 = 0;
        goto L25
    L18:
        r7 = 8;
        goto L19
    L11:
        r4 = false;
    L7:
        r2 = 0;
        goto L8
    }

    public BitableSortPanelFragment() {
        this.o = new ArrayList();
        this.p = new BitableSortPanelFragment$mPanelActionListener$1(this);
        this.q = LazyKt.lazy(new BitableSortPanelFragment$mToolboxViewModel$2(this));
        this.r = new CompositeDisposable();
    }

    public final BitableToolboxAnalytic X90() {
        return Y90().getToolboxAnalytic();
    }

    public final void ca0() {
        BitableFilterSortViewSettingPanel r0 = getParentFragment();
        Boolean r2 = null;
        if ((r0 instanceof BitableFilterSortViewSettingPanel) == false) goto L5;
        BitableFilterSortViewSettingPanel r1 = r0;
    L6:
        FilterSortViewSettingViewModel r3 = this.s;
        if (r3 == null) goto L11;
        MutableLiveData r4 = r3.getCurrentTab();
        if (r4 == null) goto L11;
        String r5 = (String) r4.getValue();
    L12:
        if (r1 == null) goto L18;
        BitableSortData r6 = this.n;
        if (r6 == null) goto L16;
        r2 = r6.getAutoSort();
    L16:
        r1.Aa0(r5, r2);
        return;
    L18:
        return;
    L11:
        r5 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        U90();
        BitablePanelFragment r0 = this.m;
        if (r0 != null) goto L15;
    L10:
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r1 = Y90().getPanelDelegate();
        if (r1 == null) goto L13;
        r1.handleOrientationState(false);
        r1.d(this.p);
        r1.c(EPanelOperationAction.CLOSE_SORT_PANEL, null);
    L13:
        this.r.dispose();
        return;
    L15:
        r0.dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L10;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        BaseActionPanelFragment r0 = getParentFragment();
        LinearLayout r2 = null;
        if ((r0 instanceof BaseActionPanelFragment) == false) goto L5;
        BaseActionPanelFragment r1 = r0;
    L6:
        if (r1 == null) goto L8;
        View r3 = r1.fa0();
    L9:
        int[] r4 = new int[2];
        FrameLayout r5 = this.e;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
        r5 = null;
    L12:
        r5.getLocationInWindow(r4);
        int[] r6 = new int[2];
        if (r3 == null) goto L15;
        r3.getLocationInWindow(r6);
    L15:
        int r7 = r6[1] - r4[1];
        if (r3 == null) goto L22;
        if (r7 <= 0) goto L19;
        int r8 = 0;
    L20:
        r3.setVisibility(r8);
        goto L22
    L19:
        r8 = 8;
    L22:
        if (this.t == true) goto L39;
        LinearLayout r9 = this.l;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r9 = null;
    L27:
        if (r9.getVisibility() != 0) goto L40;
        LinearLayout r10 = this.l;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r10 = null;
    L31:
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L41;
        r11.height = r7;
        LinearLayout r12 = this.l;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L37:
        r2.setLayoutParams(r11);
        return;
    L36:
        r2 = r12;
        goto L37
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void onStart() {
        super.onStart();
    }

    public final void W90(boolean r6) {
        tt5.a.b("BitableSortPanelFragment", "fetchSortDataAndRender()...");
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r0 = Y90().getPanelDelegate();
        Disposable r1 = null;
        if (r0 == null) goto L7;
        Observable r2 = com.bytedance.ee.bear.bitable.toolbox.viewmodel.a.a(r0, EQueryType.GET_SORT_DATA, BitableSortData.class, null, 10);
        if (r2 == null) goto L7;
        r1 = r2.subscribe(new c(this, r6), new d(r6, this));
    L7:
        if (r1 == null) goto L10;
        this.r.add(r1);
        return;
    }

    public final void YS(ConditionListView.a r10) {
        Intrinsics.checkNotNullParameter(r10, "conditionConfig");
        int r11 = CollectionsKt.indexOf(this.o, r10);
        tt5.a.b("BitableSortPanelFragment", "onConditionRemove()... sortedConditionIndex = " + r11);
        if (r11 < 0) goto L51;
        BitableSortData r0 = this.n;
        int r1 = 0;
        if (r0 == null) goto L9;
        BitableSortData.SortedField[] r2 = r0.getSortInfo();
        if (r2 == null) goto L9;
        int r3 = r2.length;
    L10:
        if (r11 >= r3) goto L52;
        BitableSortData r4 = this.n;
        FieldCompositeType r5 = null;
        if (r4 == null) goto L16;
        BitableSortData.SortedField[] r6 = r4.getSortInfo();
        if (r6 == null) goto L16;
        BitableSortData.SortedField r12 = r6[r11];
    L17:
        BitableSortData r7 = this.n;
        if (r7 == null) goto L24;
        BitableSortData.SortedField[] r8 = r7.getSortInfo();
        if (r8 == null) goto L24;
        List r9 = ArraysKt.toMutableList(r8);
        if (r9 == null) goto L24;
        List r13 = r9;
        TypeIntrinsics.asMutableCollection(r13).remove(r12);
        BitableSortData.SortedField[] r14 = (BitableSortData.SortedField[]) r13.toArray(new BitableSortData.SortedField[0]);
    L25:
        BitableSortData r16 = this.n;
        if (r16 == null) goto L28;
        r16.setSortInfo(r14);
    L28:
        updateView();
        aa0();
        BitableSortData r17 = this.n;
        if (r17 == null) goto L45;
        BitableSortData.SortFieldOption[] r18 = r17.getFieldOptions();
        if (r18 == null) goto L45;
        int r19 = r18.length;
    L33:
        if (r1 >= r19) goto L42;
        BitableSortData.SortFieldOption r20 = r18[r1];
        String r21 = r20.getId();
        if (r12 == null) goto L37;
        String r22 = r12.getFieldId();
    L39:
        if (TextUtils.equals(r21, r22) == true) goto L43;
        r1 = r1 + 1;
    L43:
        if (r20 == null) goto L45;
        r5 = r20.getFieldCompositeType();
        goto L45
    L37:
        r22 = null;
        goto L39
    L42:
        r20 = null;
    L45:
        FieldCompositeType r23 = r5;
        BitableToolboxAnalytic r24 = X90();
        if (r24 == null) goto L53;
        BitableToolboxAnalytic.O(r24, "delete_click", null, r23, null, 10);
        return;
    L53:
        return;
    L24:
        r14 = null;
    L16:
        r12 = null;
        goto L17
    L52:
        return;
    L9:
        r3 = 0;
        goto L10
    }

    public final void Fi(ConditionListView.a r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "conditionConfig");
        int r1 = CollectionsKt.indexOf(this.o, r18);
        if (r1 < 0) goto L103;
        BitableSortData r3 = this.n;
        if (r3 == null) goto L9;
        BitableSortData.SortedField[] r4 = r3.getSortInfo();
        if (r4 == null) goto L9;
        int r5 = r4.length;
    L10:
        if (r1 >= r5) goto L103;
        BitableSortData r6 = this.n;
        FieldCompositeType r7 = null;
        if (r6 == null) goto L17;
        BitableSortData.SortedField[] r8 = r6.getSortInfo();
        if (r8 == null) goto L17;
        BitableSortData.SortedField r9 = r8[r1];
    L18:
        if (r9 == null) goto L113;
        if (r19 != 0) goto L21;
        BitableSortData r2 = this.n;
        if (r2 == null) goto L74;
        BitableSortData.SortFieldOption[] r10 = r2.getFieldOptions();
        if (r10 == null) goto L74;
        int r11 = r10.length;
        int r12 = 0;
    L69:
        if (r12 >= r11) goto L74;
        BitableSortData.SortFieldOption r13 = r10[r12];
        if (TextUtils.equals(r13.getId(), r9.getFieldId()) == true) goto L75;
        r12 = r12 + 1;
    L75:
        Context r14 = getContext();
        FragmentManager r16 = getChildFragmentManager();
        BitablePanelModel r17 = new BitablePanelModel();
        r17.setTitle(getString(2131886799));
        BitableSortData r20 = this.n;
        if (r20 == null) goto L83;
        List<BitableSortData.SortFieldOption> r21 = r20.findUnSortedFieldOptions(r13);
        if (r21 == null) goto L83;
        List<BitableSortData.SortFieldOption> r22 = r21;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L81:
        if (r24.hasNext() == false) goto L84;
        BitableSortData.SortFieldOption r26 = (BitableSortData.SortFieldOption) r24.next();
        BitablePanelItem r110 = new BitablePanelItem();
        r110.setId(r26.getId());
        r110.setLeftText(r26.getName());
        Icon r111 = new Icon();
        r111.setImgRes(Integer.valueOf(r26.getFieldCompositeType().getIcon()));
        r111.setSync(r26.isSync());
        r110.setLeftIcon(r111);
        com.bytedance.ee.bear.bitable.panel.e.b(r110, Intrinsics.areEqual(r9.getFieldId(), r26.getId()));
        com.bytedance.ee.bear.bitable.panel.e.a(r110);
        r23.add(r110);
    L84:
        r17.setData(r23);
        PanelData r27 = (PanelData) Y90().getPanelData().getValue();
        if (r27 == null) goto L87;
        String r28 = r27.getSrcObjToken();
    L88:
        r17.setSrcObjToken(r28);
        PanelData r29 = (PanelData) Y90().getPanelData().getValue();
        if (r29 == null) goto L91;
        Integer r30 = r29.getSrcObjType();
    L92:
        r17.setSrcObjType(r30);
        Unit r31 = Unit.INSTANCE;
        f r112 = new f(this, r1, r9);
        if (this.t == false) goto L95;
        BitableSortPanelFragment r113 = this;
    L96:
        this.m = com.bytedance.ee.bear.bitable.panel.e.m(r14, r16, r17, r112, r113, 16);
        BitableToolboxAnalytic r32 = X90();
        if (r32 != null) goto L99;
        return;
    L99:
        if (r13 == null) goto L101;
        r7 = r13.getFieldCompositeType();
    L101:
        BitableToolboxAnalytic.O(r32, "field_click", null, r7, null, 10);
        return;
    L95:
        r113 = null;
        goto L96
    L91:
        r30 = null;
        goto L92
    L87:
        r28 = null;
    L83:
        r23 = null;
    L74:
        r13 = null;
        goto L75
    L21:
        if (r19 != 1) goto L117;
        BitableSortData r33 = this.n;
        if (r33 == null) goto L33;
        BitableSortData.SortFieldOption[] r34 = r33.getFieldOptions();
        if (r34 == null) goto L33;
        int r36 = r34.length;
        int r37 = 0;
    L28:
        if (r37 >= r36) goto L33;
        BitableSortData.SortFieldOption r38 = r34[r37];
        if (TextUtils.equals(r38.getId(), r9.getFieldId()) == true) goto L34;
        r37 = r37 + 1;
    L34:
        Context r114 = getContext();
        FragmentManager r115 = getChildFragmentManager();
        BitablePanelModel r116 = new BitablePanelModel();
        r116.setTitle(getString(2131886767));
        if (r38 == null) goto L45;
        BitableSortData.OrderOption[] r39 = r38.getOrders();
        if (r39 == null) goto L45;
        ArrayList r40 = new ArrayList(r39.length);
        int r41 = r39.length;
        int r117 = 0;
    L39:
        if (r117 >= r41) goto L46;
        BitableSortData.OrderOption r118 = r39[r117];
        BitablePanelItem r119 = new BitablePanelItem();
        r119.setId(com.bytedance.ee.bear.bitable.panel.e.e(r118.getDesc()));
        r119.setLeftText(r118.getText());
        if (r9.getDesc() != r118.getDesc()) goto L43;
        boolean r42 = true;
    L44:
        com.bytedance.ee.bear.bitable.panel.e.c(r119, r42);
        com.bytedance.ee.bear.bitable.panel.e.a(r119);
        r40.add(r119);
        r117 = r117 + 1;
        goto L39
    L43:
        r42 = false;
    L46:
        r116.setData(r40);
        PanelData r43 = (PanelData) Y90().getPanelData().getValue();
        if (r43 == null) goto L49;
        String r44 = r43.getSrcObjToken();
    L50:
        r116.setSrcObjToken(r44);
        PanelData r46 = (PanelData) Y90().getPanelData().getValue();
        if (r46 == null) goto L53;
        Integer r47 = r46.getSrcObjType();
    L54:
        r116.setSrcObjType(r47);
        Unit r48 = Unit.INSTANCE;
        e r120 = new e(this, r1, r9);
        if (this.t == false) goto L57;
        BitableSortPanelFragment r121 = this;
    L58:
        this.m = com.bytedance.ee.bear.bitable.panel.e.m(r114, r115, r116, r120, r121, 16);
        BitableToolboxAnalytic r122 = X90();
        if (r122 != null) goto L61;
        return;
    L61:
        if (r38 == null) goto L63;
        r7 = r38.getFieldCompositeType();
    L63:
        BitableToolboxAnalytic.O(r122, "group_rule_click", null, r7, r9.getDesc(), 2);
        return;
    L57:
        r121 = null;
        goto L58
    L53:
        r47 = null;
        goto L54
    L49:
        r44 = null;
    L45:
        r40 = null;
    L33:
        r38 = null;
        goto L34
    L117:
        return;
    L113:
        return;
    L17:
        r9 = null;
    L9:
        r5 = 0;
    L103:
        tt5.a.d("BitableSortPanelFragment", "onConditionItemClick()... invalid index");
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        com.bytedance.ee.bear.bitable.toolbox.viewmodel.b r6 = Y90().getPanelDelegate();
        if (r6 == null) goto L5;
        r6.handleOrientationState(true);
    L5:
        this.e = r4.findViewById(2131386992);
        this.l = r4.findViewById(2131371597);
        this.f = r4.findViewById(2131381014);
        this.g = r4.findViewById(2131386987);
        ConditionListView r7 = r4.findViewById(2131386982);
        this.k = r7;
        UDSwitch r1 = null;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSortConditionsView");
        r7 = null;
    L8:
        r7.setOnConditionListener(this);
        this.h = r4.findViewById(2131363618);
        this.i = r4.findViewById(2131363619);
        this.j = r4.findViewById(2131363618);
        UDSwitch r8 = this.i;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mAutoSortSwitch");
    L12:
        r1.setOnCheckedChangeListener(new com.bytedance.ee.bear.bitable.sort.d(this));
        W90(true);
        Fragment r9 = getParentFragment();
        if (r9 == null) goto L15;
        this.s = q.a(r9, FilterSortViewSettingViewModel.class);
    L15:
        FilterSortViewSettingViewModel r10 = this.s;
        if (r10 == null) goto L21;
        MutableLiveData r11 = r10.getCurrentTab();
        if (r11 == null) goto L22;
        r11.observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.sort.c(this));
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r1 = r8;
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.t = r5;
        return r2.inflate(2131559150, r3, false);
    L5:
        if (ForsetiHelper.r(this) == false) goto L7;
        r5 = true;
        goto L8
    }
}
