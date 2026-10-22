package com.ss.android.lark.flow.chat.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatAudioPlayBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f422103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckBox f422104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f422105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowAudioWaveView f422106d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f422103a;
    }

    public FlowChatAudioPlayBarBinding(View r100, CheckBox r101, TextView r102, FlowAudioWaveView r103) {
        this.f422103a = r100;
        this.f422104b = r101;
        this.f422105c = r102;
        this.f422106d = r103;
    }
}
