package com.ss.android.lark.widget.photo.preview.utils;

import a0b.h;
import android.content.Context;
import com.ss.android.lark.media.MediaMutex;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f447155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakReference<Context> f447156b;

    @Override // a0b.h.a
    public final void onSuccess() {
        this.f447155a.run();
    }

    @Override // a0b.h.a
    public final void a(MediaMutex.LockError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Context r101 = this.f447156b.get();
        if (r101 == null) goto L6;
        h.f(r101, r100);
        return;
    }

    public e(com.ss.android.lark.widget.photo.preview.video.cover.c r100, WeakReference r101) {
        this.f447155a = r100;
        this.f447156b = r101;
    }
}
