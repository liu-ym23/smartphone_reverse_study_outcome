package com.larus.home.api.block;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.home.api.databinding.LarusBottomConfirmDialogBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/home/api/block/BottomConfirmDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/home/api/databinding/LarusBottomConfirmDialogBinding;", "content", "", "confirmText", "confirmCallback", "Lkotlin/Function0;", "", "setUp", "callback", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BottomConfirmDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f344077h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusBottomConfirmDialogBinding f344078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f344079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f344080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f344081g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_BottomSheetDialog;
    }

    public BottomConfirmDialog() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Dialog r102 = getDialog();
        if (r102 == null) goto L5;
        View r103 = r102.findViewById(R.id.design_bottom_sheet);
    L6:
        if (r103 == null) goto L8;
        r103.setBackgroundResource(android.R.color.transparent);
    L8:
        LarusBottomConfirmDialogBinding r104 = this.f344078d;
        if (r104 == null) goto L12;
        r104.f344087c.setText(this.f344079e);
        r104.f344088d.setText(this.f344080f);
        r104.f344088d.setOnClickListener(new b(this));
        r104.f344086b.setOnClickListener(new c(this));
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void S90(String r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "confirmText");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f344079e = r100;
        this.f344080f = r101;
        this.f344081g = r102;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_bottom_confirm_dialog, r101, false);
        int r104 = R.id.bottom_cancel_tv;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.bottom_cancel_tv);
        if (r105 == null) goto L11;
        r104 = R.id.bottom_confirm_tip_tv;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.bottom_confirm_tip_tv);
        if (r106 == null) goto L11;
        r104 = R.id.bottom_confirm_tv;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.bottom_confirm_tv);
        if (r107 == null) goto L11;
        LinearLayout r108 = (LinearLayout) r103;
        this.f344078d = new LarusBottomConfirmDialogBinding(r108, r105, r106, r107);
        return r108;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
