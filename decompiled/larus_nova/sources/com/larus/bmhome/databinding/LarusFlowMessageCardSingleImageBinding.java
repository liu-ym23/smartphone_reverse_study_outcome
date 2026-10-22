package com.larus.bmhome.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusFlowMessageCardSingleImageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f310883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f310884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageViewWithLastMotion f310885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f310886d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310883a;
    }

    public LarusFlowMessageCardSingleImageBinding(LinearLayout r100, ViewStub r101, TextView r102, ImageViewWithLastMotion r103, FrameLayout r104) {
        this.f310883a = r100;
        this.f310884b = r102;
        this.f310885c = r103;
        this.f310886d = r104;
    }
}
