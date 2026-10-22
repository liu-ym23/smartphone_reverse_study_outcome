package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class LarusDoraOnboardingMusicPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f332804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatTextView f332805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f332806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f332807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f332808e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f332804a;
    }

    public static LarusDoraOnboardingMusicPanelBinding a(View r100) {
        int r101 = R.id.dora_onboarding_music_artist_name;
        AppCompatTextView r102 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_music_artist_name);
        if (r102 == null) goto L13;
        r101 = R.id.dora_onboarding_music_avatar;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_music_avatar);
        if (r103 == null) goto L13;
        r101 = R.id.dora_onboarding_music_song_name;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_music_song_name);
        if (r104 == null) goto L13;
        r101 = R.id.dora_onboarding_music_state;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r100, R.id.dora_onboarding_music_state);
        if (r105 == null) goto L13;
        return new LarusDoraOnboardingMusicPanelBinding((ConstraintLayout) r100, r102, r103, r104, r105);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public LarusDoraOnboardingMusicPanelBinding(ConstraintLayout r100, AppCompatTextView r101, SimpleDraweeView r102, AppCompatTextView r103, ImageView r104) {
        this.f332804a = r100;
        this.f332805b = r101;
        this.f332806c = r102;
        this.f332807d = r103;
        this.f332808e = r104;
    }
}
