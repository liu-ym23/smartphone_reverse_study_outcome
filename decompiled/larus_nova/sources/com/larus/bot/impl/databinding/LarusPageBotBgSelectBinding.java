package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.IndefinitePagerIndicator;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.widget.BgSelectViewPagerContainer;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusPageBotBgSelectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f317894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f317895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IndefinitePagerIndicator f317896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f317897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NovaTitleBarEx f317898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BgSelectViewPagerContainer f317899f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317894a;
    }

    public LarusPageBotBgSelectBinding(ConstraintLayout r100, TextView r101, IndefinitePagerIndicator r102, TextView r103, NovaTitleBarEx r104, BgSelectViewPagerContainer r105) {
        this.f317894a = r100;
        this.f317895b = r101;
        this.f317896c = r102;
        this.f317897d = r103;
        this.f317898e = r104;
        this.f317899f = r105;
    }
}
