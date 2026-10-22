package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.indicator.DrawableIndicator;

/* JADX INFO: loaded from: classes26.dex */
public final class LarusDialogBotEditBgImageChooseBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f317744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f317745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LarusLayoutBotEditErrorLayBinding f317746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DrawableIndicator f317747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewPager2 f317748e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f317744a;
    }

    public LarusDialogBotEditBgImageChooseBinding(LinearLayout r100, TextView r101, LarusLayoutBotEditErrorLayBinding r102, DrawableIndicator r103, ViewPager2 r104) {
        this.f317744a = r100;
        this.f317745b = r101;
        this.f317746c = r102;
        this.f317747d = r103;
        this.f317748e = r104;
    }
}
