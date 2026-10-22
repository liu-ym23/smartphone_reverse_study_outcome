package com.bytedance.ee.bear.office.list.adapter;

import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.thumbnail.LeftCrop;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 implements Runnable {
    public final /* synthetic */ AppCompatImageView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ j0 c;
    public final /* synthetic */ AppCompatImageView d;
    public final /* synthetic */ ThumbGlideUrl e;

    public n0(AppCompatImageView r1, String r2, j0 r3, AppCompatImageView r4, ThumbGlideUrl r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == false) goto L6;
        j0 r0 = this.c;
        AppCompatImageView r1 = this.a;
        AppCompatImageView r2 = this.d;
        ThumbGlideUrl r3 = this.e;
        String r4 = this.b;
        r0.getClass();
        Glide.with(r1.getContext()).asBitmap().load(r3).skipMemoryCache(r3.needUpdate(r3.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCrop()).listener(new k0(r1, r4, r2)).into(r1);
        return;
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
