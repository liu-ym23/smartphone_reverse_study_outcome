package com.ss.android.lark.widget.light.layout;

import android.graphics.Picture;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Picture f446151a;

    public a() {
        this.f446151a = new Picture();
    }

    @Override // com.ss.android.lark.widget.light.layout.b
    public final void a(f r100) {
        r100.draw(this.f446151a.beginRecording(e.b(r100), e.a(r100)));     // Catch: Exception -> L4
        this.f446151a.endRecording();     // Catch: Exception -> L4
        return;
    }
}
