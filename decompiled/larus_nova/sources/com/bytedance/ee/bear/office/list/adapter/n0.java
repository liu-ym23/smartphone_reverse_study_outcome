package com.bytedance.ee.bear.office.list.adapter;

import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.thumbnail.LeftCrop;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f235813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f235814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f235815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f235816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ThumbGlideUrl f235817e;

    public n0(AppCompatImageView r100, String r101, j0 r102, AppCompatImageView r103, ThumbGlideUrl r104) {
        this.f235813a = r100;
        this.f235814b = r101;
        this.f235815c = r102;
        this.f235816d = r103;
        this.f235817e = r104;
    }

    public final void a() {
        if (Intrinsics.areEqual(this.f235813a.getTag(R.id.avatar_tag), this.f235814b) == false) goto L6;
        j0 r100 = this.f235815c;
        AppCompatImageView r101 = this.f235813a;
        AppCompatImageView r102 = this.f235816d;
        ThumbGlideUrl r103 = this.f235817e;
        String r104 = this.f235814b;
        r100.getClass();
        Glide.with(r101.getContext()).asBitmap().load(r103).skipMemoryCache(r103.needUpdate(r103.getUrl())).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new LeftCrop()).listener(new k0(r101, r104, r102)).into(r101);
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
