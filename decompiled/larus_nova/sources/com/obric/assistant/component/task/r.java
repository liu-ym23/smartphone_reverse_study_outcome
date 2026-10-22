package com.obric.assistant.component.task;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class r implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f388935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f388936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f388937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f388938d;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f388935a.element == true) goto L8;
        View r100 = this.f388936b;
        if (r100 == null) goto L7;
        r100.setTranslationX(0.0f);
    L7:
        return true;
    L8:
        TaskPanelView r101 = this.f388937c.f388905f;
        int r102 = 0;
        if (r101 == null) goto L11;
        int r103 = r101.getLeft();
    L12:
        View r104 = this.f388936b;
        if (r104 == null) goto L15;
        r102 = r104.getLeft();
    L15:
        View r105 = this.f388936b;
        if (r105 == null) goto L18;
        r105.setTranslationX((this.f388938d - r103) - r102);
    L18:
        return true;
    L11:
        r103 = 0;
        goto L12
    }

    public r(Ref.BooleanRef r100, View r101, n r102, int r103) {
        this.f388935a = r100;
        this.f388936b = r101;
        this.f388937c = r102;
        this.f388938d = r103;
    }
}
