package com.ss.android.lark.keyboard.editor;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements zxa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f428773a;

    @Override // zxa.b
    public final CharSequence b() {
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i r100 = this.f428773a.f428764j;
        if (r100 == null) goto L6;
        CharSequence r101 = r100.b();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public g(d r100) {
        this.f428773a = r100;
    }

    @Override // zxa.b
    public final void a(CharSequence r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i r101 = this.f428773a.f428764j;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
