package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.profile.impl.view.MineTabTitleBar;
import com.larus.profile.impl.view.ProfileInfoView;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusFragmentMineTabBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f366451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CreateBotButton f366452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f366453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProfileInfoView f366454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MineTabTitleBar f366455e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f366451a;
    }

    public LarusFragmentMineTabBinding(ConstraintLayout r100, CreateBotButton r101, FrameLayout r102, ProfileInfoView r103, MineTabTitleBar r104) {
        this.f366451a = r100;
        this.f366452b = r101;
        this.f366453c = r102;
        this.f366454d = r103;
        this.f366455e = r104;
    }
}
