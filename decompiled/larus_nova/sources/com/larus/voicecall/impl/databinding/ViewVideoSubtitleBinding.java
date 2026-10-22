package com.larus.voicecall.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.voicecall.impl.component.videosubtitle.VideoSubtitleContainer;

/* JADX INFO: loaded from: classes32.dex */
public final class ViewVideoSubtitleBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f378320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoSubtitleContainer f378321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f378322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f378323d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378320a;
    }

    public ViewVideoSubtitleBinding(View r100, VideoSubtitleContainer r101, AppCompatTextView r102, AppCompatTextView r103) {
        this.f378320a = r100;
        this.f378321b = r101;
        this.f378322c = r102;
        this.f378323d = r103;
    }
}
