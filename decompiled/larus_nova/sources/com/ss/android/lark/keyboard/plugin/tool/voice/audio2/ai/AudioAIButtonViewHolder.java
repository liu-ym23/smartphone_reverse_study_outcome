package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "btn", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIGradientButton;", "getBtn", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/ai/AudioAIGradientButton;", "btn$delegate", "Lkotlin/Lazy;", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioAIButtonViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f429925a;

    public AudioAIButtonViewHolder(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f429925a = LazyKt.lazy(new AudioAIButtonViewHolder$btn$2(r100));
    }
}
