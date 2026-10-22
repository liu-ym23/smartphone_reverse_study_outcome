package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle;

import com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.f;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a<T extends f> {
    public final Queue<T> a;

    public a() {
        int r0 = q95.f.a;
        this.a = new ArrayDeque(20);
    }

    public final void a(T r3) {
        if (((ArrayDeque) this.a).size() >= 20) goto L6;
        ((ArrayDeque) this.a).offer(r3);
        return;
    }
}
