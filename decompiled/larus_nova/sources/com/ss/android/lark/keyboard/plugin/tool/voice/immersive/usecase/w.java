package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class w<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoiceBubbleAreaUseCase f430592a;

    public w(VoiceBubbleAreaUseCase r100) {
        this.f430592a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        AppCompatTextView r102 = this.f430592a.f430447d.l();
        Intrinsics.checkNotNull(r101);
        if (r101.booleanValue() == false) goto L5;
        int r103 = 0;
    L6:
        r102.setVisibility(r103);
        return;
    L5:
        r103 = 8;
        goto L6
    }
}
