package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import lt7.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ImageView e;
    public final /* synthetic */ d f;

    public b(Context r1, String r2, int r3, int r4, CoverImageAdapter r5, ImageView r6, d r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }

    public final void a() {
        Glide.with(this.a).asBitmap().load(this.b).diskCacheStrategy(DiskCacheStrategy.ALL).error(2131233832).override(this.c, this.d).into(new CoverImageAdapter.b(this.e, this.f));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
