package com.ss.android.lark.emoji_office.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes35.dex */
public final class OfficeReactionDetailPopupBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f420642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f420643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TabLayout f420644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewPager2 f420645d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f420642a;
    }

    public OfficeReactionDetailPopupBinding(LinearLayout r100, AppCompatImageView r101, TabLayout r102, ViewPager2 r103) {
        this.f420642a = r100;
        this.f420643b = r101;
        this.f420644c = r102;
        this.f420645d = r103;
    }
}
