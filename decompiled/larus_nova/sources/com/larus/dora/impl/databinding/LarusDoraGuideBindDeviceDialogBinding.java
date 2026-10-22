package com.larus.dora.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraGuideBindDeviceDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f332666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f332667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f332668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraTextView f332669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DoraTextView f332670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraTextView f332671f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332666a;
    }

    public static LarusDoraGuideBindDeviceDialogBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_dora_guide_bind_device_dialog, r101, false);
        int r103 = R.id.dora_guide_dialog_avatar;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.dora_guide_dialog_avatar);
        if (r104 == null) goto L15;
        r103 = R.id.dora_guide_dialog_close_btn;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.dora_guide_dialog_close_btn);
        if (r105 == null) goto L15;
        r103 = R.id.dora_guide_dialog_confirm_btn;
        DoraTextView r106 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_guide_dialog_confirm_btn);
        if (r106 == null) goto L15;
        r103 = R.id.dora_guide_dialog_subtitle;
        DoraTextView r107 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_guide_dialog_subtitle);
        if (r107 == null) goto L15;
        r103 = R.id.dora_guide_dialog_title;
        DoraTextView r108 = (DoraTextView) ViewBindings.findChildViewById(r102, R.id.dora_guide_dialog_title);
        if (r108 == null) goto L15;
        return new LarusDoraGuideBindDeviceDialogBinding((FrameLayout) r102, r104, r105, r106, r107, r108);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public LarusDoraGuideBindDeviceDialogBinding(FrameLayout r100, SimpleDraweeView r101, ImageView r102, DoraTextView r103, DoraTextView r104, DoraTextView r105) {
        this.f332666a = r100;
        this.f332667b = r101;
        this.f332668c = r102;
        this.f332669d = r103;
        this.f332670e = r104;
        this.f332671f = r105;
    }
}
