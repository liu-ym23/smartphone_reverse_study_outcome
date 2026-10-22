package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextSelectorSubTitle;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraPageChatSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ItemTextSelector f332882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemTextSelectorSubTitle f332883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemTextSelectorSubTitle f332884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ItemGroup f332885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f332886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NovaTitleBarEx f332887g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332881a;
    }

    public LarusDoraPageChatSettingsBinding(ConstraintLayout r100, ItemTextSelector r101, ItemTextSelectorSubTitle r102, ItemTextSelectorSubTitle r103, ItemGroup r104, View r105, NovaTitleBarEx r106) {
        this.f332881a = r100;
        this.f332882b = r101;
        this.f332883c = r102;
        this.f332884d = r103;
        this.f332885e = r104;
        this.f332886f = r105;
        this.f332887g = r106;
    }
}
