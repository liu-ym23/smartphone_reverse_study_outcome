package com.obric.assistant.component;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class z4 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f389016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f389017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a5 f389018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OrionChatSpeakerComponent f389019d;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.f389016a.getWidth() <= 0) goto L9;
        this.f389017b.invoke();
        ViewTreeObserver r100 = this.f389016a.getViewTreeObserver();
        if (r100 == null) goto L7;
        r100.removeOnGlobalLayoutListener(this);
    L7:
        this.f389016a.removeOnAttachStateChangeListener(this.f389018c);
        this.f389019d.f388297w = false;
        return;
    }

    public z4(AudioVisualizerOpt r100, y4 r101, a5 r102, OrionChatSpeakerComponent r103) {
        this.f389016a = r100;
        this.f389017b = r101;
        this.f389018c = r102;
        this.f389019d = r103;
    }
}
