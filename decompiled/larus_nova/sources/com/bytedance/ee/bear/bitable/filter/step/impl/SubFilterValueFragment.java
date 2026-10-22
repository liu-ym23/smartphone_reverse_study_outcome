package com.bytedance.ee.bear.bitable.filter.step.impl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.filter.model.FilterCondition;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.filter.step.EFilterStep;
import com.bytedance.ee.bear.bitable.filter.step.FilterStepClickEvent;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.DateFilterValueEditViewHolder;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.GroupFilterValueEditViewHolder;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.LinkFilterValueEditViewHolder;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.UserFilterValueEditViewHolderV2;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.h;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.o;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.p;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.t;
import com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.u;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/SubFilterValueFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/IFilterValueEditViewHolder$IStepActionListener;", "<init>", "()V", "mFilterStepViewModel", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "getMFilterStepViewModel", "()Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "mFilterStepViewModel$delegate", "Lkotlin/Lazy;", "mContainer", "Landroid/view/ViewGroup;", "mFilterValueEditView", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/valueedit/IFilterValueEditViewHolder;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "rootView", "initObservers", "buildNewCondition", "editValue", "", "goToNextStep", "notifyFilterStepDone", LiveCommonConstants.REASON_ON_DEDTROY, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubFilterValueFragment extends BaseFragment implements i.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f211903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f211904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a f211905g;

    public final FilterStepViewModel U90() {
        return (FilterStepViewModel) this.f211903e.getValue();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r100 = this.f211905g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterValueEditView");
        r100 = null;
    L6:
        if (r100.b() == false) goto L10;
        com.bytedance.ee.bear.bitable.filter.step.a r101 = U90().getFilterStepPanelDelegate();
        if (r101 == null) goto L10;
        r101.b(FilterStepClickEvent.INPUT_AREA, EFilterStep.Value);
    L10:
        super.onDestroy();
    }

    public SubFilterValueFragment() {
        this.f211903e = LazyKt.lazy(new SubFilterValueFragment$mFilterStepViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i.a
    public final void NC() {
        U90().notifyFilterStepDone();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.i.a
    public final void SO() {
        U90().goToNextStep();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f211904f = (ViewGroup) r100.findViewById(R.id.container);
        FilterStepViewModel r102 = U90();
        FilterCondition r103 = r102.getNewCondition();
        if (r103 != null) goto L5;
        r103 = r102.getOldCondition();
    L5:
        FilterFieldOption[] r104 = r102.getFieldOptions();
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r105 = null;
        if (r104 == null) goto L17;
        int r106 = r104.length;
        int r107 = 0;
    L8:
        if (r107 >= r106) goto L17;
        FilterFieldOption r108 = r104[r107];
        if (r103 == null) goto L12;
        String r109 = r103.getFieldId();
    L14:
        if (TextUtils.equals(r109, r108.getId()) == true) goto L18;
        r107 = r107 + 1;
    L18:
        Context r110 = requireContext();
        k r111 = U90().getWebService();
        com.bytedance.ee.bear.bitable.a r112 = U90().getAsyncRequestDelegate();
        int r113 = h.f211994a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "stepActionListener");
        if (r108 == null) goto L21;
        EFieldType r114 = r108.getValueFieldType();
    L22:
        if (r114 != null) goto L24;
        int r115 = -1;
    L25:
        switch(r115) {
            case 1: goto L64;
            case 2: goto L64;
            case 3: goto L64;
            case 4: goto L60;
            case 5: goto L60;
            case 6: goto L60;
            case 7: goto L55;
            case 8: goto L55;
            case 9: goto L43;
            case 10: goto L38;
            case 11: goto L38;
            case 12: goto L38;
            case 13: goto L33;
            case 14: goto L28;
            case 15: goto L28;
            default: goto L26;
        };
    L26:
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r116 = new u(r110, r108);
    L65:
        r116.f211977f = r111;
        r116.f211978g = r112;
        Intrinsics.checkNotNullParameter(this, "listener");
        r116.f211979h = this;
        String r117 = r102.getRequestBaseId();
        String r118 = r102.getTableId();
        r102.getViewId();
        String r119 = r102.getTimeZone();
        r116.f211974c = r117;
        r116.f211975d = r118;
        r116.f211976e = r119;
        EFilterStep r120 = r102.getCurrentFilterStep().getValue();
        if (r120 == null) goto L68;
        EFilterStep.SubValueStep r121 = r120.getSubValueStep();
    L69:
        r116.a(r121);
        if (r108 == null) goto L76;
        FieldCompositeType r122 = r108.getFieldCompositeType();
        if (r122 == null) goto L76;
        EFieldType r123 = r122.getType();
        if (r123 == null) goto L76;
        Integer r124 = Integer.valueOf(r123.getValue());
    L77:
        if (r103 == null) goto L79;
        Integer r125 = Integer.valueOf(r103.getFieldType());
    L81:
        if (Intrinsics.areEqual(r124, r125) == false) goto L90;
        if (r103 == null) goto L84;
        String[] r126 = r103.getDisplayValue();
    L85:
        r116.e(r126);
        if (r103 == null) goto L88;
        Object r127 = r103.getValue();
    L89:
        r116.f(r127);
    L91:
        this.f211905g = r116;
        ViewGroup r128 = this.f211904f;
        if (r128 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        r128 = null;
    L94:
        com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.a r129 = this.f211905g;
        if (r129 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterValueEditView");
    L98:
        r128.addView(r105.getView());
        final FilterStepViewModel r130 = U90();
        r130.getCurrentFilterStep().observe(getViewLifecycleOwner(), new d(this, r130));
        r130.addFilterStepDoneListener(new SubFilterValueFragment$initObservers$1$2(r130, this));
        return;
    L97:
        r105 = r129;
        goto L98
    L88:
        r127 = null;
        goto L89
    L84:
        r126 = null;
        goto L85
    L90:
        r116.e(null);
        r116.f(null);
        goto L91
    L79:
        r125 = null;
    L76:
        r124 = null;
        goto L77
    L68:
        r121 = null;
        goto L69
    L64:
        r116 = new o(r110, r108);
        goto L65
    L28:
        if (r103 == null) goto L30;
        String r131 = r103.getOperator();
    L31:
        r116 = new LinkFilterValueEditViewHolder(r110, r108, r131);
        goto L65
    L30:
        r131 = null;
        goto L31
    L33:
        if (r103 == null) goto L35;
        String r132 = r103.getOperator();
    L36:
        r116 = new GroupFilterValueEditViewHolder(r110, r108, r132);
        goto L65
    L35:
        r132 = null;
        goto L36
    L38:
        if (r103 == null) goto L40;
        String r133 = r103.getOperator();
    L41:
        r116 = new UserFilterValueEditViewHolderV2(r110, r108, r133);
        goto L65
    L40:
        r133 = null;
        goto L41
    L43:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L50;
        if (r103 == null) goto L47;
        String r134 = r103.getOperator();
    L48:
        r116 = new t(r110, r108, r134);
        goto L65
    L47:
        r134 = null;
        goto L48
    L50:
        if (r103 == null) goto L52;
        String r135 = r103.getOperator();
    L53:
        r116 = new p(r110, r108, r135);
        goto L65
    L52:
        r135 = null;
        goto L53
    L55:
        if (r103 == null) goto L57;
        String r136 = r103.getOperator();
    L58:
        r116 = new p(r110, r108, r136);
        goto L65
    L57:
        r136 = null;
        goto L58
    L60:
        if (r103 == null) goto L62;
        String r137 = r103.getOperator();
    L63:
        r116 = new DateFilterValueEditViewHolder(r110, r108, r137);
        goto L65
    L62:
        r137 = null;
        goto L63
    L24:
        r115 = h.a.f211995a[r114.ordinal()];
        goto L25
    L21:
        r114 = null;
        goto L22
    L12:
        r109 = null;
    L17:
        r108 = null;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_sub_filter_value_fragment, r101, false);
    }
}
