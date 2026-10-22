package com.bytedance.ee.bear.bitable.filter.step.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016JO\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010%H\u0004¢\u0006\u0002\u0010&JQ\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010%H\u0004¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0011H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/step/impl/BaseSubFilterSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mFilterStepViewModel", "Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "getMFilterStepViewModel", "()Lcom/bytedance/ee/bear/bitable/filter/step/impl/FilterStepViewModel;", "mFilterStepViewModel$delegate", "Lkotlin/Lazy;", "mContainer", "Landroid/view/ViewGroup;", "getMContainer", "()Landroid/view/ViewGroup;", "setMContainer", "(Landroid/view/ViewGroup;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "createSelectorItem", "Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView;", "title", "", "leftIconResId", "", "leftIconIsSync", "", "showNextStepArrow", "selected", "clickListener", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Integer;ZZZLkotlin/jvm/functions/Function0;)Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView;", "rightIconResId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZLkotlin/jvm/functions/Function0;)Lcom/bytedance/ee/bear/bitable/common/widgets/item/BitableSelectorItemView;", "notifyItemSelected", "itemView", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseSubFilterSelectionFragment extends BaseFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f211894g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f211895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f211896f;

    public static final class a implements BitableSelectorItemView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f211897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseSubFilterSelectionFragment f211898b;

        @Override // com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView.b
        public final void a(BitableSelectorItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
        }

        @Override // com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView.b
        public final boolean b(BitableSelectorItemView r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Function0<Unit> r101 = this.f211897a;
            if (r101 == null) goto L5;
            r101.invoke();
        L5:
            BaseSubFilterSelectionFragment r102 = this.f211898b;
            int r103 = BaseSubFilterSelectionFragment.f211894g;
            ViewGroup r104 = r102.f211896f;
            if (r104 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            r104 = null;
        L9:
            int r105 = r104.getChildCount();
            int r106 = 0;
        L10:
            if (r106 >= r105) goto L22;
            ViewGroup r107 = r102.f211896f;
            if (r107 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            r107 = null;
        L15:
            View r108 = r107.getChildAt(r106);
            if ((r108 instanceof BitableSelectorItemView) == false) goto L18;
            BitableSelectorItemView r109 = (BitableSelectorItemView) r108;
        L19:
            if (r109 == null) goto L21;
            r109.setSelected(Intrinsics.areEqual(r109, r100));
        L21:
            r106 = r106 + 1;
            goto L10
        L18:
            r109 = null;
            goto L19
        L22:
            return true;
        }

        public a(Function0<Unit> r100, BaseSubFilterSelectionFragment r101) {
            this.f211897a = r100;
            this.f211898b = r101;
        }
    }

    public final FilterStepViewModel V90() {
        return (FilterStepViewModel) this.f211895e.getValue();
    }

    public BaseSubFilterSelectionFragment() {
        this.f211895e = LazyKt.lazy(new BaseSubFilterSelectionFragment$mFilterStepViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.container);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f211896f = r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_sub_filter_selection_fragment, r101, false);
    }

    public final BitableSelectorItemView U90(String r100, Integer r101, Integer r102, boolean r103, boolean r110, Function0<Unit> r111) {
        ViewGroup r104 = null;
        BitableSelectorItemView r105 = new BitableSelectorItemView(getContext(), null, 6, 0);
        BitableSelectorItemView.f(r105, r100);
        if (r101 == null) goto L5;
        BitableSelectorItemView.c(r105, r101.intValue(), r103, 2);
    L5:
        if (r102 == null) goto L7;
        r105.d(r102.intValue(), null);
    L7:
        r105.setSelected(r110);
        r105.setOnItemClickListener(new a(r111, this));
        ViewGroup r106 = this.f211896f;
        if (r106 == null) goto L10;
        r104 = r106;
    L11:
        r104.addView(r105);
        return r105;
    L10:
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        goto L11
    }
}
