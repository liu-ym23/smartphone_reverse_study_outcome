package com.larus.dora.impl.noti_v3.special_contacts.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.utils.x1;
import com.larus.dora.impl.databinding.LarusDoraDialogNotiV3AddSpecialContactBinding;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import x59.b;
import x59.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/noti_v3/special_contacts/dialog/NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDialogNotiV3AddSpecialContactBinding;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "contactId", "", "getTheme", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupInitialValues", "()Lkotlin/Unit;", "onDestroyView", "setupBottomSheetBehavior", "setupInputValidation", "validateInputs", "setupClicks", "handleConfirm", "appName", "chatName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f336495g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDoraDialogNotiV3AddSpecialContactBinding f336496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x1 f336497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f336498f;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_AddSpecialContactBottomSheetDialog;
    }

    public final Unit S90() {
        LarusDoraDialogNotiV3AddSpecialContactBinding r100 = this.f336496d;
        String r101 = null;
        if (r100 == null) goto L35;
        Editable r102 = r100.f332476d.getText();
        if (r102 == null) goto L9;
        String r103 = r102.toString();
        if (r103 == null) goto L9;
        String r104 = StringsKt.trim(r103).toString();
    L10:
        String r105 = "";
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        Editable r106 = r100.f332477e.getText();
        if (r106 == null) goto L18;
        String r107 = r106.toString();
        if (r107 == null) goto L18;
        r101 = StringsKt.trim(r107).toString();
    L18:
        if (r101 == null) goto L21;
        r105 = r101;
    L21:
        AppCompatButton r108 = r100.f332475c;
        int r109 = r104.length();
        boolean r110 = true;
        if (r109 <= 0) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == true) goto L27;
    L32:
        r110 = false;
    L33:
        r108.setEnabled(r110);
        return Unit.INSTANCE;
    L27:
        if (r105.length() <= 0) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L32;
    L29:
        r112 = false;
        goto L30
    L24:
        r111 = false;
    L9:
        r104 = null;
        goto L10
    L35:
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        x1 r100 = this.f336497e;
        if (r100 == null) goto L5;
        r100.a(true);
    L5:
        this.f336496d = null;
    }

    public NotificationBroadcastV3AddSpecialContactBottomSheetDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        String r102 = r101.getString("key_contact_id");
    L6:
        this.f336498f = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L7;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L7;
        r103.setSoftInputMode(16);
    L7:
        LarusDoraDialogNotiV3AddSpecialContactBinding r104 = this.f336496d;
        if (r104 == null) goto L12;
        AppCompatEditText r105 = r104.f332476d;
        if (r105 == null) goto L12;
        this.f336497e = new x1(r105);
    L12:
        LarusDoraDialogNotiV3AddSpecialContactBinding r106 = this.f336496d;
        if (r106 == null) goto L28;
        Bundle r107 = getArguments();
        if (r107 == null) goto L19;
        String r108 = r107.getString("key_app_name");
        if (r108 == null) goto L19;
        r106.f332476d.setText(r108);
    L19:
        Bundle r109 = getArguments();
        if (r109 == null) goto L25;
        String r110 = r109.getString("key_chat_name");
        if (r110 == null) goto L25;
        r106.f332477e.setText(r110);
    L25:
        if (this.f336498f == null) goto L27;
        r106.f332478f.setText(getString(R.string.larus_dora_broadcast_v3_special_chat_edit_panel_title_cn));
    L27:
        Unit r111 = Unit.INSTANCE;
    L28:
        Dialog r112 = getDialog();
        View r113 = null;
        if ((r112 instanceof BottomSheetDialog) == false) goto L31;
        BottomSheetDialog r114 = (BottomSheetDialog) r112;
    L32:
        if (r114 == null) goto L34;
        r113 = r114.findViewById(R.id.design_bottom_sheet);
    L34:
        if (r113 == null) goto L36;
        BottomSheetBehavior r115 = BottomSheetBehavior.from(r113);
        r115.setState(3);
        r115.setSkipCollapsed(true);
    L36:
        LarusDoraDialogNotiV3AddSpecialContactBinding r116 = this.f336496d;
        if (r116 == null) goto L39;
        c r117 = new c(this);
        r116.f332476d.addTextChangedListener(r117);
        r116.f332477e.addTextChangedListener(r117);
        S90();
    L39:
        final LarusDoraDialogNotiV3AddSpecialContactBinding r118 = this.f336496d;
        if (r118 == null) goto L43;
        e1.d(r118.f332474b, new x59.a(this));
        e1.d(r118.f332475c, new b(r118, this));
        Unit r119 = Unit.INSTANCE;
        return;
    L43:
        return;
    L31:
        r114 = null;
        goto L32
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dora_dialog_noti_v3_add_special_contact, r101, false);
        int r103 = R.id.btn_cancel;
        AppCompatButton r104 = (AppCompatButton) ViewBindings.findChildViewById(r102, R.id.btn_cancel);
        if (r104 == null) goto L19;
        r103 = R.id.btn_confirm;
        AppCompatButton r105 = (AppCompatButton) ViewBindings.findChildViewById(r102, R.id.btn_confirm);
        if (r105 == null) goto L19;
        r103 = R.id.et_app_name;
        AppCompatEditText r106 = (AppCompatEditText) ViewBindings.findChildViewById(r102, R.id.et_app_name);
        if (r106 == null) goto L19;
        r103 = R.id.et_contact_name;
        AppCompatEditText r107 = (AppCompatEditText) ViewBindings.findChildViewById(r102, R.id.et_contact_name);
        if (r107 == null) goto L19;
        r103 = R.id.tv_app_label;
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.tv_app_label)) == null) goto L19;
        r103 = R.id.tv_contact_label;
        if (((DoraTextView) ViewBindings.findChildViewById(r102, R.id.tv_contact_label)) == null) goto L19;
        r103 = R.id.tv_title;
        DoraTextView r108 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.tv_title);
        if (r108 == null) goto L19;
        NestedScrollView r109 = (NestedScrollView) r102;
        this.f336496d = new LarusDoraDialogNotiV3AddSpecialContactBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
