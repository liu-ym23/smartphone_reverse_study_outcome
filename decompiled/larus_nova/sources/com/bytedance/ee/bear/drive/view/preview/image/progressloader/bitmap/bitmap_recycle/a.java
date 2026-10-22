package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.f;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a<T extends f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<T> f224934a;

    public a() {
        int r100 = q95.f.f532111a;
        this.f224934a = new ArrayDeque(20);
    }

    public final void a(T r100) {
        if (((ArrayDeque) this.f224934a).size() >= 20) goto L6;
        ((ArrayDeque) this.f224934a).offer(r100);
        return;
    }
}
