package com.bytedance.ee.bear.bitable.card.view.page;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/page/AutoSubscribeConfirmDialog;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "cardViewModel", "Lcom/bytedance/ee/bear/bitable/itemview/record/menu/SubscribeDep;", "baseId", "", "<init>", "(Lcom/bytedance/ee/bear/bitable/itemview/record/menu/SubscribeDep;Ljava/lang/String;)V", "getBaseId", "()Ljava/lang/String;", "confirmButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "cancelButton", "dispose", "Lio/reactivex/disposables/Disposable;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "", "onCreateDialog", "Landroid/app/Dialog;", "initView", "rootView", "changeAutoSubscribe", "closeAutoSubscribe", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoSubscribeConfirmDialog extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.itemview.record.menu.g f208459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f208460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UDButton f208461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UDButton f208462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f208463o;

    public static final class a {
    }

    static {
    }

    public final void ea0() {
        super.onStart();
        Dialog r100 = getDialog();
        BottomSheetDialog r101 = null;
        if ((r100 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r102 = (BottomSheetDialog) r100;
    L6:
        if (r102 == null) goto L10;
        BottomSheetBehavior r103 = r102.getBehavior();
        if (r103 == null) goto L10;
        r103.setDraggable(false);
    L10:
        Dialog r104 = getDialog();
        if ((r104 instanceof BottomSheetDialog) == false) goto L13;
        r101 = (BottomSheetDialog) r104;
    L13:
        if (r101 == null) goto L18;
        BottomSheetBehavior r105 = r101.getBehavior();
        if (r105 == null) goto L19;
        r105.setState(3);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        ea0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setCanceledOnTouchOutside(false);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setLayout(-1, -2);
    L5:
        return r101;
    }

    public AutoSubscribeConfirmDialog(com.bytedance.ee.bear.bitable.itemview.record.menu.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cardViewModel");
        Intrinsics.checkNotNullParameter(r101, "baseId");
        this.f208459k = r100;
        this.f208460l = r101;
    }

    public static final void da0(AutoSubscribeConfirmDialog r100, boolean r101) {
        r100.getClass();
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        NetService.f r103 = new NetService.f(String.format("/space/api/bitable/record/%s/subscribe_base_edit_status", Arrays.copyOf(new Object[]{r100.f208460l}, 1)));
        r103.f216906c = 1;
        JSONObject r104 = new JSONObject();
        if (r101 == false) goto L5;
        int r105 = 2;
    L6:
        r104.put("status", r105);
        r103.f216913j = r104.toString();
        r100.f208463o = ((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class)).Vc(new ax4.f()).a(r103).subscribe(new com.bytedance.ee.bear.bitable.card.view.page.a(r101, r100), b.f208571a);
        return;
    L5:
        r105 = 3;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_auto_subscribe_confirm_dialog, r101, false);
        Intrinsics.checkNotNull(r103);
        this.f208461m = (UDButton) r103.findViewById(R.id.button_confirm);
        this.f208462n = (UDButton) r103.findViewById(R.id.button_cancel);
        UDButton r104 = this.f208461m;
        UDButton r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        r104 = null;
    L5:
        r104.setOnClickListener(new c(this));
        UDButton r106 = this.f208462n;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
    L9:
        r105.setOnClickListener(new d(this));
        return r103;
    L8:
        r105 = r106;
        goto L9
    }
}
