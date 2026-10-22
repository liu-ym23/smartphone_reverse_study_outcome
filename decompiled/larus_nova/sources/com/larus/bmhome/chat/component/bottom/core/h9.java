package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes25.dex */
public final class h9 implements g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f298553a;

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    @Override // com.larus.bmhome.chat.component.bottom.core.g9
    public final View root() {
        return this.f298553a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void a(float r100) {
        ?? r101 = this.f298553a;
        if (r101 == 0) goto L6;
        r101.setAlpha(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void b(boolean r100) {
        ?? r101 = this.f298553a;
        if (r101 == 0) goto L6;
        r101.setEnabled(r100);
        return;
    }

    public final void c(int r100) {
        Object r101 = this.f298553a;
        if ((r101 instanceof ImageView) == false) goto L6;
        ((ImageView) r101).setImageResource(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void d(int r100) {
        ?? r101 = this.f298553a;
        if (r101 == 0) goto L6;
        r101.setVisibility(r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, java.lang.Object] */
    public final void e(boolean r100) {
        ?? r101 = this.f298553a;
        if (r101 == 0) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public h9(g9.b r100, int r101) {
        View r102 = r100.f298534a;
        if (r102 == null) goto L5;
        View r103 = r102.findViewById(r101);
    L6:
        this.f298553a = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }
}
