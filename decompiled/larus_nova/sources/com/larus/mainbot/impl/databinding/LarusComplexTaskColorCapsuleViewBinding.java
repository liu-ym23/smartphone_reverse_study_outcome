package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.chat.standarduikit.complextask.blockadapter.view.ComplexTaskColorCapsuleView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusComplexTaskColorCapsuleViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f358546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f358547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f358548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f358549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f358550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ShimmerTextView f358551g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358545a;
    }

    public LarusComplexTaskColorCapsuleViewBinding(ComplexTaskColorCapsuleView r100, View r101, LinearLayout r102, LinearLayout r103, SimpleDraweeView r104, TextView r105, ShimmerTextView r106) {
        this.f358545a = r100;
        this.f358546b = r101;
        this.f358547c = r102;
        this.f358548d = r103;
        this.f358549e = r104;
        this.f358550f = r105;
        this.f358551g = r106;
    }
}
