package com.ss.android.lark.flow.ud.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowUdToastLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDShadowLayout f424293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f424294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f424295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f424296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f424297e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f424293a;
    }

    public FlowUdToastLayoutBinding(UDShadowLayout r100, TextView r101, View r102, ImageView r103, TextView r104) {
        this.f424293a = r100;
        this.f424294b = r101;
        this.f424295c = r102;
        this.f424296d = r103;
        this.f424297e = r104;
    }
}
