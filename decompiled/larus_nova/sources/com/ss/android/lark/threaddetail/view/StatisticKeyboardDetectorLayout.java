package com.ss.android.lark.threaddetail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: classes38.dex */
public class StatisticKeyboardDetectorLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f441318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f441319b;

    public StatisticKeyboardDetectorLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.f441319b == true) goto L6;
        ChatCoreModule.a().getPerfEnterChatMonitor().k();
        this.f441319b = true;
        return;
    }

    public StatisticKeyboardDetectorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f441318a == true) goto L5;
        ChatCoreModule.a().getPerfEnterChatMonitor().r();
        this.f441318a = true;
    L5:
        super.onMeasure(r100, r101);
    }

    public StatisticKeyboardDetectorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
