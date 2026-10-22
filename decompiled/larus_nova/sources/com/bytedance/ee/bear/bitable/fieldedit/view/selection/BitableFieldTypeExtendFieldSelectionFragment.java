package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExistExtendableFields;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendOrigin;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield.ExtendFieldTypeExtendFieldSelectionView;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u000201H\u0016J\"\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u000205H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/selection/BitableFieldTypeExtendFieldSelectionFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "extendFieldsContainerFromXml", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView;", "getExtendFieldsContainerFromXml", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView;", "setExtendFieldsContainerFromXml", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView;)V", "clearFromXmlViewCache", "", "onDestroyView", "mFieldId", "", "mEditType", "mSceneType", "mFromFieldType", "mFieldEditViewModel", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "getMFieldEditViewModel", "()Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "mFieldEditViewModel$delegate", "Lkotlin/Lazy;", "onExtendFieldSelectListener", "Lkotlin/Function0;", "getOnExtendFieldSelectListener", "()Lkotlin/jvm/functions/Function0;", "setOnExtendFieldSelectListener", "(Lkotlin/jvm/functions/Function0;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initStatusBarAndTitleBar", "initDataObserver", "onBackPressed", "", "onCreateAnimation", "Landroid/view/animation/Animation;", AppletNaviType.TRANSIT, "", "enter", "nextAnim", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFieldTypeExtendFieldSelectionFragment extends BaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f211660m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f211661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExtendFieldTypeExtendFieldSelectionView f211662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f211663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f211664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f211665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f211666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f211667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f211668l;

    public BitableFieldTypeExtendFieldSelectionFragment() {
        this.f211667k = LazyKt.lazy(new BitableFieldTypeExtendFieldSelectionFragment$mFieldEditViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        T90(R.anim.facade_slide_right_out);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f211661e = null;
        this.f211662f = null;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f211661e;
        FieldExtendOrigin r103 = null;
        Object r104 = null;
        r103 = null;
        if (r102 != null) goto L9;
        View r105 = getView();
        if (r105 == null) goto L7;
        r102 = r105.findViewById(R.id.titleBar);
    L8:
        this.f211661e = (BaseTitleBar) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        ((BaseTitleBar) r102).setTitle(R.string.Bitable_PeopleField_ExtendableField_Title);
        View r106 = this.f211661e;
        if (r106 != null) goto L16;
        View r107 = getView();
        if (r107 == null) goto L14;
        r106 = r107.findViewById(R.id.titleBar);
    L15:
        this.f211661e = (BaseTitleBar) r106;
        goto L16
    L14:
        r106 = null;
    L16:
        ((BaseTitleBar) r106).setLeftClickListener(new b(this));
        View r108 = this.f211662f;
        if (r108 != null) goto L23;
        View r109 = getView();
        if (r109 == null) goto L21;
        r108 = r109.findViewById(R.id.extendFieldsContainer);
    L22:
        this.f211662f = (ExtendFieldTypeExtendFieldSelectionView) r108;
        goto L23
    L21:
        r108 = null;
    L23:
        ExtendFieldTypeExtendFieldSelectionView r110 = (ExtendFieldTypeExtendFieldSelectionView) r108;
        if (r110 == null) goto L38;
        FieldExistExtendableFields r111 = ((BitableFieldEditViewModel) this.f211667k.getValue()).getOriginFieldsInfo().getValue();
        if (r111 == null) goto L37;
        ArrayList<FieldExtendOrigin> r112 = r111.getFields();
        if (r112 == null) goto L37;
        Iterator<T> r113 = r112.iterator();
    L32:
        if (r113.hasNext() == false) goto L36;
        Object r114 = r113.next();
        if (Intrinsics.areEqual(((FieldExtendOrigin) r114).getFieldId(), this.f211663g) == false) goto L32;
        r104 = r114;
    L36:
        r103 = (FieldExtendOrigin) r104;
    L37:
        r110.setData(r103);
        r110.setOnItemListener(new a(this));
    L38:
        BitableFieldEditAnalytic r115 = ((BitableFieldEditViewModel) this.f211667k.getValue()).getBitableAnalytic();
        if (r115 == null) goto L48;
        Map r116 = MapsKt.mapOf(new Pair[]{TuplesKt.to("extend_from_field_type", this.f211666j), TuplesKt.to("edit_type", this.f211664h), TuplesKt.to("scene_type", this.f211665i)});
        HashMap r117 = new HashMap();
        if (r116 == null) goto L43;
        r117.putAll(r116);
    L43:
        r115.t(BitableFieldEditAnalytic.FieldEditSceneEvent.BITABLE_FIELD_EXTEND_MODIFY_VIEW, r117);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final Animation onCreateAnimation(int r100, boolean r101, int r102) {
        Context r103 = getContext();
        if (r101 == false) goto L5;
        int r104 = R.anim.facade_slide_right_in;
    L7:
        return AnimationUtils.loadAnimation(r103, r104);
    L5:
        r104 = R.anim.facade_slide_right_out;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Bundle r103 = getArguments();
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getString("key_from_field_id");
    L6:
        this.f211663g = r105;
        Bundle r106 = getArguments();
        if (r106 == null) goto L9;
        String r107 = r106.getString("key_from_field_type");
    L10:
        this.f211666j = r107;
        Bundle r108 = getArguments();
        if (r108 == null) goto L13;
        String r109 = r108.getString("key_edit_type");
    L14:
        this.f211664h = r109;
        Bundle r110 = getArguments();
        if (r110 == null) goto L17;
        r104 = r110.getString("key_scene_type");
    L17:
        this.f211665i = r104;
        return r100.inflate(R.layout.bitable_field_type_extend_field_selection_fragment, r101, false);
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
