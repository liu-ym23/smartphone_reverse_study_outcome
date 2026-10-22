package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k0 implements RequestListener<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f235796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f235797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f235798c;

    public k0(AppCompatImageView r100, String r101, AppCompatImageView r102) {
        this.f235796a = r100;
        this.f235797b = r101;
        this.f235798c = r102;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Bitmap> r102, boolean r103) {
        if (Intrinsics.areEqual(this.f235796a.getTag(R.id.avatar_tag), this.f235797b) == true) goto L5;
        return true;
    L5:
        this.f235796a.setVisibility(4);
        this.f235798c.setVisibility(0);
        return true;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Bitmap r100, Object r101, Target<Bitmap> r102, DataSource r103, boolean r104) {
        if (Intrinsics.areEqual(this.f235796a.getTag(R.id.avatar_tag), this.f235797b) == true) goto L5;
        return true;
    L5:
        this.f235796a.setVisibility(0);
        this.f235798c.setVisibility(8);
        return false;
    }
}
