package com.ss.android.lark.keyboard.keyboard2;

import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/TransitionWrapper;", "Landroidx/transition/TransitionSet;", PlayerResolution.SDKKEY.ORIGIN, "Landroidx/transition/Transition;", "<init>", "(Landroidx/transition/Transition;)V", "cancelAnim", "", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransitionWrapper extends TransitionSet {
    public TransitionWrapper(Transition r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        addTransition(r100);
    }
}
