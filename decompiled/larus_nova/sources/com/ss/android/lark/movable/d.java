package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.ss.android.lark.log.Log;
import kotlin.UInt;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f432659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f432660b;

    public static final class a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f432660b == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        Lark_markdown_renderKt.m8397ffiReleaseMovableDocumentForClientWZ4Q5Ns(this.f432659a);     // Catch: Throwable -> L11
        this.f432660b = true;     // Catch: Throwable -> L11
        Log.d("MovableDocumentReleaseHandle", "release movable document, docId: " + UInt.m9590toStringimpl(this.f432659a));     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public d(int r100) {
        this.f432659a = r100;
    }
}
