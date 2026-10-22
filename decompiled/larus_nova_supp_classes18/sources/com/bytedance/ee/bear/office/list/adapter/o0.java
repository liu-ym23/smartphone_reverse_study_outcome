package com.bytedance.ee.bear.office.list.adapter;

import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bytedance.ee.bear.list.listitem.ListIconTransformation;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o0 implements Runnable {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ j0 c;
    public final /* synthetic */ ThumbGlideUrl d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Function0<Unit> f;

    public o0(ImageView r1, String r2, j0 r3, ThumbGlideUrl r4, int r5, Function0<Unit> r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void a() {
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == false) goto L6;
        j0 r0 = this.c;
        ImageView r1 = this.a;
        ThumbGlideUrl r2 = this.d;
        int r3 = this.e;
        String r4 = this.b;
        Function0<Unit> r5 = this.f;
        r0.getClass();
        Glide.with(r1.getContext()).asBitmap().load(r2).skipMemoryCache(r2.needUpdate(r2.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(r3).transform(new Transformation[]{new ListIconTransformation(), new CenterCrop(), new RoundedCorners(com.bytedance.ee.util.ui.n.d(8))}).error(r3).listener(new m0(r1, r4, r5)).into(r1);
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
