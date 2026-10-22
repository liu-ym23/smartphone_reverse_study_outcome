package com.larus.notify.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusPageNotificationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f360272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CreateBotButton f360273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f360274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f360275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NovaTitleBarEx f360276e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f360272a;
    }

    public LarusPageNotificationBinding(ConstraintLayout r100, CreateBotButton r101, RecyclerView r102, FrameLayout r103, NovaTitleBarEx r104) {
        this.f360272a = r100;
        this.f360273b = r101;
        this.f360274c = r102;
        this.f360275d = r103;
        this.f360276e = r104;
    }
}
