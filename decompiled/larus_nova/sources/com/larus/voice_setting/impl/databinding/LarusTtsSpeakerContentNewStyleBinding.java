package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.voice_setting.voice.mix.SingleVoiceBar;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.larus.voice_setting.voice.mix.VoiceMixBar;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusTtsSpeakerContentNewStyleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoordinatorLayout f376192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppBarLayout f376193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CollapsingToolbarLayout f376194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Toolbar f376195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VoiceMixBar f376196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TabLayout f376197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewPager2 f376198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SingleVoiceBar f376199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ItemTextToggle f376200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f376201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final VoiceEditArea f376202k;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376192a;
    }

    public LarusTtsSpeakerContentNewStyleBinding(CoordinatorLayout r100, AppBarLayout r101, CollapsingToolbarLayout r102, Toolbar r103, VoiceMixBar r104, TabLayout r105, ViewPager2 r106, SingleVoiceBar r107, ItemTextToggle r108, FrameLayout r110, VoiceEditArea r111) {
        this.f376192a = r100;
        this.f376193b = r101;
        this.f376194c = r102;
        this.f376195d = r103;
        this.f376196e = r104;
        this.f376197f = r105;
        this.f376198g = r106;
        this.f376199h = r107;
        this.f376200i = r108;
        this.f376201j = r110;
        this.f376202k = r111;
    }
}
