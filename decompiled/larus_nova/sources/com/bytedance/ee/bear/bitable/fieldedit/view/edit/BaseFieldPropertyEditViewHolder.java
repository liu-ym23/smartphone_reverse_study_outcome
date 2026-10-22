package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfigs;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldConfigMetaModel;
import com.bytedance.ee.bear.bitable.fieldedit.viewmodel.BitableFieldEditViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.nova.R;
import io.reactivex.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0015H\u0016J\b\u0010B\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020@H\u0014J\b\u0010D\u001a\u00020@H\u0014J\b\u0010E\u001a\u00020\u000fH\u0016J0\u0010F\u001a\u00020@2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010\u001b2\b\u0010J\u001a\u0004\u0018\u00010!2\b\u0010K\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010L\u001a\u00020@2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0012\u0010O\u001a\u00020@2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020@H\u0016J\u0012\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010TH\u0016J\n\u0010U\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010V\u001a\u00020WH\u0016J\n\u0010X\u001a\u0004\u0018\u00010!H\u0016J\b\u0010Y\u001a\u00020WH\u0016J\n\u0010Z\u001a\u0004\u0018\u00010'H\u0016J\b\u0010[\u001a\u00020WH\u0016J\b\u0010\\\u001a\u00020WH\u0016J\u0010\u0010]\u001a\u00020@2\u0006\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020@H\u0016J)\u0010a\u001a\u00020@2\u0006\u0010b\u001a\u00020W2\u0012\u0010c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0d\"\u00020\u000fH\u0004¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020@2\u0006\u0010g\u001a\u00020WH\u0014J\"\u0010l\u001a\u00020@2\b\u0010m\u001a\u0004\u0018\u0001032\u0006\u0010n\u001a\u00020:2\u0006\u0010o\u001a\u00020:H\u0016J\b\u0010p\u001a\u00020@H\u0004J\b\u0010q\u001a\u00020@H\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R#\u00102\u001a\n 4*\u0004\u0018\u000103038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u00020:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010h\u001a\u00020i8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010k¨\u0006r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/BaseFieldPropertyEditViewHolder;", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder;", "Lcom/ss/android/lark/edit/keyboard/KeyboardHeightObserver;", "Landroidx/lifecycle/LifecycleOwner;", "mContext", "Landroid/content/Context;", "mFieldCompositeType", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;)V", "getMContext", "()Landroid/content/Context;", "getMFieldCompositeType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/FieldCompositeType;", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mActionDelegate", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder$ActionDelegate;", "getMActionDelegate", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder$ActionDelegate;", "setMActionDelegate", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/IFieldPropertyEditViewHolder$ActionDelegate;)V", "mOriginalFieldProperty", "Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "getMOriginalFieldProperty", "()Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;", "setMOriginalFieldProperty", "(Lcom/bytedance/ee/bear/bitable/common/model/field/FieldProperty;)V", "mOriginalAllowedEditModes", "Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "getMOriginalAllowedEditModes", "()Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "setMOriginalAllowedEditModes", "(Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;)V", "mOriginalFieldExtendOrigin", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "getMOriginalFieldExtendOrigin", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "setMOriginalFieldExtendOrigin", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;)V", "mFieldEditViewModel", "Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "getMFieldEditViewModel", "()Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;", "setMFieldEditViewModel", "(Lcom/bytedance/ee/bear/bitable/fieldedit/viewmodel/BitableFieldEditViewModel;)V", "mKeyboardHeightProvider", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "kotlin.jvm.PlatformType", "getMKeyboardHeightProvider", "()Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "mKeyboardHeightProvider$delegate", "Lkotlin/Lazy;", "mKeyboardHeight", "", "getMKeyboardHeight", "()I", "setMKeyboardHeight", "(I)V", "bindActionDelegate", "", "actionListener", WidgetCostModule.TYPE_ON_CREATE, "initView", "initClickEvent", "getView", "injectFieldInfo", "fieldConfigItem", "Lcom/bytedance/ee/bear/bitable/fieldedit/model/FieldConfigMetaModel$FieldConfigItem;", "fieldProperty", "allowedEditModes", "fieldExtendInfo", "notifyFieldPropertyOptionChanged", "newFieldPropertyOption", "", "notifyFieldExtendConfigsChanged", "fieldExtendConfigs", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendConfigs;", "verifyFailWhenSaveData", "getCurrentEditPropertyAsync", "Lio/reactivex/Observable;", "getCurrentEditProperty", "isPropertyChanged", "", "getCurrentAllowedEditModes", "isAllowedEditModesChanged", "getCurrentFieldExtendOrigin", "isFieldExtendOriginChanged", "getCheckBoxState", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetach", "setVisible", "visible", "views", "", "(Z[Landroid/view/View;)V", "onCheckBoxClicked", "isChecked", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onKeyboardHeightChanged", "khp", "keyboardHeight", "orientation", "bringFocusTextViewVisibleIfNeed", "handlerExtendsField", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseFieldPropertyEditViewHolder implements q0, ocb.a, LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f211149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FieldCompositeType f211150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f211151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q0.a f211152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FieldProperty f211153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AllowedEditModes f211154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FieldExtendInfo f211155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BitableFieldEditViewModel f211156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f211157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f211158j;

    public static final class a extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseFieldPropertyEditViewHolder f211159c;

        public a(BaseFieldPropertyEditViewHolder r100) {
            this.f211159c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f211159c.r().j(BitableFieldEditAnalytic.FieldSubSettingAction.OPEN_SELECT, null);
            this.f211159c.r().n(null);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseFieldPropertyEditViewHolder f211160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f211161b;

        public b(BaseFieldPropertyEditViewHolder r100, View r101) {
            this.f211160a = r100;
            this.f211161b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f211160a.v(((UDSwitch) this.f211161b.findViewById(R.id.checkBox)).isChecked());
        }
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public void a(FieldExtendConfigs r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public AllowedEditModes f() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public void h() {
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public FieldExtendInfo j() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public void l(Object r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    public FieldProperty p() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final boolean c() {
        return ((UDSwitch) this.f211151c.findViewById(R.id.checkBox)).isChecked();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public Observable e() {
        return Observable.just(Boolean.TRUE);
    }

    public final void o() {
        View r100 = this.f211151c.findFocus();
        if (r100 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof TextView) == true) goto L9;
        return;
    L9:
        if (this.f211158j <= 0) goto L19;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = (com.bytedance.ee.util.ui.n.z(this.f211149a) - r101[1]) - ((TextView) r100).getHeight();
        if (r102 >= this.f211158j) goto L21;
        Context r103 = this.f211149a;
        if ((r103 instanceof Activity) == false) goto L15;
        Activity r104 = (Activity) r103;
    L16:
        int r105 = com.bytedance.ee.util.ui.k.c(r104);
        int r106 = ((this.f211158j + r105) - r102) + com.bytedance.ee.util.ui.n.d(20);
        q0.a r107 = r();
        if (r107 == null) goto L22;
        r107.i(r106, false);
        return;
    L22:
        return;
    L15:
        r104 = null;
        goto L16
    L21:
        return;
    L19:
        r100.clearFocus();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public void onDetach() {
        ((pcb.a) this.f211157i.getValue()).a(this);
        q0.a r100 = r();
        if (r100 == null) goto L6;
        r100.d(true);
        return;
    }

    public final q0.a r() {
        q0.a r100 = this.f211152d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mActionDelegate");
        return null;
    }

    public void s() {
        View r100 = this.f211151c;
        ((LinearLayout) r100.findViewById(R.id.fieldPropertySelector)).setOnClickListener(new a(this));
        ((UDSwitch) r100.findViewById(R.id.checkBox)).setOnClickListener(new b(this, r100));
    }

    public void t() {
        View r100 = this.f211151c;
        w(false, new View[]{r100.findViewById(R.id.fieldPropertyTvLayout), r100.findViewById(R.id.fieldPropertySelector), r100.findViewById(R.id.fieldPropertyChecker)});
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public boolean b() {
        FieldProperty r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return !Intrinsics.areEqual(r100, this.f211153e);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final boolean g() {
        return !Intrinsics.areEqual(f(), this.f211154f);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return r().getLifecycle();
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public Observable<FieldProperty> i() {
        FieldProperty r100 = p();
        if (r100 != null) goto L5;
        return null;
    L5:
        return Observable.just(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.fieldedit.view.edit.q0
    public final boolean k() {
        return !Intrinsics.areEqual(j(), this.f211155g);
    }

    public final void onCreate() {
        q0.a r100 = r();
        if (r100 == null) goto L7;
        PluginHost r101 = r100.getPluginHost();
        if (r101 == null) goto L7;
        this.f211156h = (BitableFieldEditViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r101, BitableFieldEditViewModel.class, null);
    L7:
        t();
        s();
    }

    public void m(q0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionListener");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f211152d = r100;
    }

    public void v(boolean r100) {
        r().j(BitableFieldEditAnalytic.FieldSubSettingAction.CHECK_CHANGED, Boolean.valueOf(r100));
    }

    public BaseFieldPropertyEditViewHolder(Context r100, FieldCompositeType r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFieldCompositeType");
        this.f211149a = r100;
        this.f211150b = r101;
        this.f211151c = LayoutInflater.from(r100).inflate(R.layout.bitable_field_edit_property_view, null);
        Lazy r102 = LazyKt.lazy(new BaseFieldPropertyEditViewHolder$mKeyboardHeightProvider$2(this));
        this.f211157i = r102;
        ((pcb.a) r102.getValue()).c(this);
    }

    public static void w(boolean r100, View... r101) {
        Intrinsics.checkNotNullParameter(r101, "views");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        View r104 = r101[r103];
        if (r100 == false) goto L7;
        int r105 = 0;
    L8:
        r104.setVisibility(r105);
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = 8;
        goto L8
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        this.f211158j = r101;
        o();
    }

    public void u(FieldConfigMetaModel.FieldConfigItem r100, FieldProperty r101, AllowedEditModes r102, FieldExtendInfo r103) {
        this.f211153e = r101;
        this.f211154f = r102;
        this.f211155g = r103;
    }
}
