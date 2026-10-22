package com.bytedance.ee.bear.search.picker.filter.permission;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.search.e;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.factory.PickerFactory;
import com.ss.android.lark.picker.factory.PickerFactoryLoader;
import com.ss.android.lark.picker.factory.PickerViewHolder;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0019H\u0016J\u0006\u0010!\u001a\u00020\u0019J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/search/picker/filter/permission/ChatterPickerFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "pickerNotifyListener", "Lcom/bytedance/ee/bear/search/picker/filter/permission/ChatterPickerNotifyListener;", "selectedOwner", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "getSelectedOwner", "()Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "setSelectedOwner", "(Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;)V", "pickerViewHolder", "Lcom/ss/android/lark/picker/factory/PickerViewHolder;", "pickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "getPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "onDestroyView", "confirmResult", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "contentmanager-search-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterPickerFragment extends BaseAntiScreenshotsDialogFragment {
    public static e k;
    public com.bytedance.ee.bear.search.picker.filter.permission.a h;
    public SearchChatterInfo i;
    public PickerViewHolder j;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        PickerViewHolder r0 = this.j;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.j = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public final void Z90() {
        String r3 = "";
        if (ForsetiHelper.s(this) == false) goto L24;
        e r0 = k;
        dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        if (r0 == null) goto L49;
        SearchChatterInfo r1 = this.i;
        if (r1 == null) goto L16;
        String r2 = r1.getId();
        if (r2 == null) goto L16;
    L17:
        SearchChatterInfo r4 = this.i;
        if (r4 == null) goto L23;
        String r5 = r4.getTitle();
        if (r5 == null) goto L23;
        r3 = r5;
    L23:
        r0.a(r2, r3);
        return;
    L16:
        r2 = "";
        goto L17
    L49:
        return;
    L7:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L11;
        d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    L24:
        e r7 = k;
        if (r7 == null) goto L45;
        SearchChatterInfo r8 = this.i;
        if (r8 == null) goto L30;
        String r9 = r8.getId();
        if (r9 == null) goto L30;
    L31:
        SearchChatterInfo r10 = this.i;
        if (r10 == null) goto L37;
        String r11 = r10.getTitle();
        if (r11 == null) goto L37;
        r3 = r11;
    L37:
        r7.a(r9, r3);
    L30:
        r9 = "";
    L45:
        dismissAllowingStateLoss();     // Catch: Exception -> L40
        return;
    L40:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L51;
        d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -1;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public ChatterPickerFragment() {
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        k = null;     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r7, r8);
        ViewGroup r9 = (ViewGroup) r7.findViewById(2131369357);
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        PickerFactory r0 = PickerFactoryLoader.INSTANCE.load();
        this.h = new com.bytedance.ee.bear.search.picker.filter.permission.a(this);
        NavPickerConfig r2 = new NavPickerConfig(new Dependency(r1, getChildFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r2.searcher(ChatterPickerFragment$getPickerConfig$config$1$1.INSTANCE);
        r2.extra(new ChatterPickerFragment$getPickerConfig$config$1$2(this));
        r2.navigation(new ChatterPickerFragment$getPickerConfig$config$1$3(this));
        r2.addressBook(ChatterPickerFragment$getPickerConfig$config$1$4.INSTANCE);
        PickerViewHolder r10 = PickerFactory.DefaultImpls.createNavPickerHolder$default(r0, r1, r2, null, 4, null);
        this.j = r10;
        r9.addView(r10.getView(), new ViewGroup.LayoutParams(-1, -1));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131564170, r3, false);
        if (ForsetiHelper.s(this) == false) goto L5;
        r5.setFitsSystemWindows(true);
    L5:
        return r5;
    }
}
