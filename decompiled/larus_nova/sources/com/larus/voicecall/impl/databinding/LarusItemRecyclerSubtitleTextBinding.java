package com.larus.voicecall.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusItemRecyclerSubtitleTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f378241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CustomMarkdownTextView f378242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f378243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f378244d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f378241a;
    }

    public LarusItemRecyclerSubtitleTextBinding(FrameLayout r100, CustomMarkdownTextView r101, ImageView r102, AppCompatTextView r103) {
        this.f378241a = r100;
        this.f378242b = r101;
        this.f378243c = r102;
        this.f378244d = r103;
    }
}
