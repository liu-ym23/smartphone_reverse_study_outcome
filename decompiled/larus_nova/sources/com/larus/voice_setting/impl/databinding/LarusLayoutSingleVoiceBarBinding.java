package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.voice_setting.voice.mix.VoiceSingleView;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusLayoutSingleVoiceBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f376131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceSingleView f376132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f376133c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376131a;
    }

    public LarusLayoutSingleVoiceBarBinding(View r100, VoiceSingleView r101, LinearLayout r102) {
        this.f376131a = r100;
        this.f376132b = r101;
        this.f376133c = r102;
    }
}
