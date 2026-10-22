package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.universe_design.image.UDAvatar;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableUserUikitItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f211063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDAvatar f211064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f211065c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211063a;
    }

    public BitableUserUikitItemBinding(View r100, UDAvatar r101, TextView r102) {
        this.f211063a = r100;
        this.f211064b = r101;
        this.f211065c = r102;
    }
}
