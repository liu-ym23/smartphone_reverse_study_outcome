package com.larus.music.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.muisc.databinding.LarusCommonApplicationDialogBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sl9.b;
import sl9.c;
import sl9.d;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/music/views/CommonApplicationDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onPositiveClick", "Lkotlin/Function0;", "", "getOnPositiveClick", "()Lkotlin/jvm/functions/Function0;", "setOnPositiveClick", "(Lkotlin/jvm/functions/Function0;)V", "onNegativeClick", "getOnNegativeClick", "setOnNegativeClick", "onCancelClick", "getOnCancelClick", "setOnCancelClick", "binding", "Lcom/larus/muisc/databinding/LarusCommonApplicationDialogBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getTheme", "", "Companion", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonApplicationDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f359597h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f359598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f359599e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f359600f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusCommonApplicationDialogBinding f359601g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_BottomSheetDialog;
    }

    public CommonApplicationDialog() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Bundle r101 = requireArguments();
        String r111 = r101.getString("arg_icon_name");
        String r102 = r101.getString("arg_main_title");
        String r103 = r101.getString("arg_subtitle");
        int r104 = r101.getInt("arg_icon_res", -1);
        String r105 = r101.getString("arg_icon_url");
        String r106 = r101.getString("arg_positive_text");
        String r107 = r101.getString("arg_negative_text");
        String r108 = r101.getString("arg_positive_sub_text");
        LarusCommonApplicationDialogBinding r109 = this.f359601g;
        if (r109 == null) goto L14;
        r109.f359367i.setText(r108);
        TextView r112 = r109.f359367i;
        if (o0.d(r108) == false) goto L7;
        int r113 = 0;
    L8:
        r112.setVisibility(r113);
        r109.f359361c.setText(r111);
        r109.f359362d.setText(r102);
        r109.f359368j.setText(r103);
        if (r104 <= 0) goto L11;
        r109.f359360b.setImageResource(r104);
    L13:
        r109.f359366h.setText(r106);
        r109.f359364f.setText(r107);
        e1.d(r109.f359365g, new sl9.a(this));
        e1.d(r109.f359363e, new b(this));
        goto L14
    L11:
        if (r105 == null) goto L13;
        ImageLoaderKt.u(r109.f359360b, r105, EffectConstants.CHANNEL_TEST);
        goto L13
    L7:
        r113 = 8;
    L14:
        Dialog r114 = getDialog();
        if (r114 == null) goto L17;
        View r115 = r114.findViewById(R.id.design_bottom_sheet);
    L18:
        if (r115 == null) goto L20;
        r115.setBackgroundResource(android.R.color.transparent);
    L20:
        Dialog r116 = getDialog();
        if (r116 == null) goto L23;
        r116.setCanceledOnTouchOutside(true);
    L23:
        Dialog r117 = getDialog();
        if (r117 == null) goto L26;
        r117.setOnCancelListener(new c(this));
    L26:
        Dialog r118 = getDialog();
        if (r118 == null) goto L30;
        r118.setOnKeyListener(new d());
        return;
    L30:
        return;
    L17:
        r115 = null;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_common_application_dialog, r111, false);
        int r114 = R.id.applicaitonIcon;
        SimpleDraweeView r100 = (SimpleDraweeView) ViewBindings.findChildViewById(r113, R.id.applicaitonIcon);
        if (r100 == null) goto L26;
        r114 = R.id.applicationName;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.applicationName);
        if (r101 == null) goto L26;
        r114 = R.id.mainDescription;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r113, R.id.mainDescription);
        if (r102 == null) goto L26;
        r114 = R.id.negativeButton;
        RoundFrameLayout r103 = (RoundFrameLayout) ViewBindings.findChildViewById(r113, R.id.negativeButton);
        if (r103 == null) goto L26;
        r114 = R.id.negativeButtonText;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.negativeButtonText);
        if (r104 == null) goto L26;
        r114 = R.id.positionButton;
        RoundLinearLayout r105 = (RoundLinearLayout) ViewBindings.findChildViewById(r113, R.id.positionButton);
        if (r105 == null) goto L26;
        r114 = R.id.positionButtonText;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r113, R.id.positionButtonText);
        if (r106 == null) goto L26;
        r114 = R.id.positiveButtonSubText;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r113, R.id.positiveButtonSubText);
        if (r107 == null) goto L26;
        r114 = R.id.subDescription;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r113, R.id.subDescription);
        if (r115 == null) goto L26;
        ConstraintLayout r116 = (ConstraintLayout) r113;
        this.f359601g = new LarusCommonApplicationDialogBinding(r116, r100, r101, r102, r103, r104, r105, r106, r107, r115);
        if (r116 == null) goto L24;
        return r116;
    L24:
        return new View(getContext());
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
