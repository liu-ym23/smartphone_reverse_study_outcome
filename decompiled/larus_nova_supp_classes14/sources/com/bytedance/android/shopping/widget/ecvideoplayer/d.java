package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends m {
    public final /* synthetic */ TTVideoEngine d;
    public final /* synthetic */ ECVideoPlayer e;
    public final /* synthetic */ int f;

    public static final class a implements SeekCompletionListener {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onCompletion(boolean r1) {
            this.a.e.n.lock();
            this.a.e.o.signalAll();
            this.a.e.n.unlock();
        }
    }

    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
    public final void a() {
        i r0 = this.e.g;
        r0.getClass();
        if (r0.c(new int[]{3, 4}) == false) goto L5;
        this.d.seekTo(this.f, new a(this));
        this.e.n.lock();
        this.e.o.await();
        this.e.n.unlock();
        this.e.g(this);
        return;
    L5:
        this.e.f(this);
    }

    public d(TTVideoEngine r1, ECVideoPlayer r2, int r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
    }
}
