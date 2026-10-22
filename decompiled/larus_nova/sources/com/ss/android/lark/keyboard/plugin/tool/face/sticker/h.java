package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements FaceNewAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FacePageNewFragment2 f429722a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.c
    public final void a() {
        WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> r100 = this.f429722a.f429673d;
        if (r100 == null) goto L5;
        com.ss.android.lark.keyboard.plugin.tool.face.b r101 = r100.get();
    L6:
        if (r101 == null) goto L9;
        r101.a();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public h(FacePageNewFragment2 r100) {
        this.f429722a = r100;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.c
    public final void b(com.ss.android.lark.keyboard.plugin.tool.face.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> r101 = this.f429722a.f429673d;
        if (r101 == null) goto L7;
        com.ss.android.lark.keyboard.plugin.tool.face.b r102 = r101.get();
    L8:
        if (r102 == null) goto L11;
        r102.b();
        return;
    L11:
        return;
    L7:
        r102 = null;
        goto L8
    }
}
