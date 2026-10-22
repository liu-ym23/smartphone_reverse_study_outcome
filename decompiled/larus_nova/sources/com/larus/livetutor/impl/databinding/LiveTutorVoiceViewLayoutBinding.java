package com.larus.livetutor.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.livetutor.impl.typing.TypingTextView;
import com.larus.livetutor.impl.view.LiveTutorVoiceView;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorVoiceViewLayoutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f355996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f355997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f355998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TypingTextView f355999d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f355996a;
    }

    public LiveTutorVoiceViewLayoutBinding(LiveTutorVoiceView r100, TextView r101, FrameLayout r102, TypingTextView r103) {
        this.f355996a = r100;
        this.f355997b = r101;
        this.f355998c = r102;
        this.f355999d = r103;
    }
}
