package com.ss.android.lark.widget.previewanimation;

import android.view.ViewGroup;
import com.ss.android.lark.widget.previewanimation.player.AnimationPlayer;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes38.dex */
public interface a<T extends AnimationPlayer> {
    T a();

    Object b(ViewGroup r100, Continuation<? super Boolean> r101);

    boolean isSuccess();
}
