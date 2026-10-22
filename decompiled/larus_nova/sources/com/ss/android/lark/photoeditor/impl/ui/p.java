package com.ss.android.lark.photoeditor.impl.ui;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f438606a;

    public /* synthetic */ p(r r100) {
        this.f438606a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.b r100 = this.f438606a.f438616g;
        if (r100 == null) goto L6;
        ((PhotoEditorFragment.a) r100).f438570a.finish();
        return;
    }
}
