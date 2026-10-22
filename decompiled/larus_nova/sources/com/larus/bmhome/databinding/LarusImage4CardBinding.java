package com.larus.bmhome.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusImage4CardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f310933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GridLayout f310934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f310935c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310933a;
    }

    public LarusImage4CardBinding(LinearLayout r100, GridLayout r101, ImageViewWithLastMotion r102, ViewStub r103, ImageViewWithLastMotion r104, ViewStub r105, ImageViewWithLastMotion r106, ViewStub r107, ImageViewWithLastMotion r108, ViewStub r110, TextView r111) {
        this.f310933a = r100;
        this.f310934b = r101;
        this.f310935c = r111;
    }
}
