package com.larus.uaigc.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusCreationSelectItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f373099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f373100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f373101d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373098a;
    }

    public LarusCreationSelectItemViewBinding(View r100, SimpleDraweeView r101, SimpleDraweeView r102, TextView r103) {
        this.f373098a = r100;
        this.f373099b = r101;
        this.f373100c = r102;
        this.f373101d = r103;
    }
}
