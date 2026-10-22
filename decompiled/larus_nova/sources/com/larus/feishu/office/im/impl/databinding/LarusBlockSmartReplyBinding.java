package com.larus.feishu.office.im.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes29.dex */
public final class LarusBlockSmartReplyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f343201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f343202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f343203c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f343201a;
    }

    public LarusBlockSmartReplyBinding(LinearLayout r100, LinearLayout r101, SimpleDraweeView r102, TextView r103) {
        this.f343201a = r100;
        this.f343202b = r102;
        this.f343203c = r103;
    }
}
