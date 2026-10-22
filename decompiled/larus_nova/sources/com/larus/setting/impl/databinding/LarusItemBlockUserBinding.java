package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.RoundAvatarImageView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemBlockUserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f368152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundAvatarImageView f368153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f368154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f368155d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f368152a;
    }

    public LarusItemBlockUserBinding(LinearLayout r100, RoundAvatarImageView r101, Button r102, TextView r103) {
        this.f368152a = r100;
        this.f368153b = r101;
        this.f368154c = r102;
        this.f368155d = r103;
    }
}
