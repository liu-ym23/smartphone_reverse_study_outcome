package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l0 implements RequestListener<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f235800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f235801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j0 f235802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f235803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Document f235804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ThumbGlideUrl f235805f;

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Bitmap> r102, boolean r110) {
        if (Intrinsics.areEqual(this.f235800a.getTag(R.id.avatar_tag), this.f235801b) == true) goto L5;
        return true;
    L5:
        j0 r103 = this.f235802c;
        AppCompatImageView r104 = this.f235800a;
        AppCompatImageView r105 = this.f235803d;
        Document r106 = this.f235804e;
        String r107 = this.f235801b;
        ThumbGlideUrl r108 = r103.d(r104, r106);
        if (r108 != null) goto L8;
        boolean r109 = false;
    L9:
        if (r109 == false) goto L11;
        return true;
    L11:
        this.f235800a.setVisibility(4);
        this.f235803d.setVisibility(0);
        return true;
    L8:
        r104.post(new n0(r104, r107, r103, r105, r108));
        r109 = true;
        goto L9
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Bitmap r100, Object r101, Target<Bitmap> r102, DataSource r110, boolean r111) {
        if (Intrinsics.areEqual(this.f235800a.getTag(R.id.avatar_tag), this.f235801b) == true) goto L6;
        return true;
    L6:
        if (this.f235805f.isIcon() == false) goto L11;
        j0 r103 = this.f235802c;
        AppCompatImageView r104 = this.f235800a;
        AppCompatImageView r105 = this.f235803d;
        Document r112 = this.f235804e;
        String r106 = this.f235801b;
        ThumbGlideUrl r107 = r103.d(r104, r112);
        if (r107 == null) goto L12;
        r104.post(new n0(r104, r106, r103, r105, r107));
        return true;
    L12:
        return false;
    L11:
        this.f235800a.setVisibility(0);
        this.f235803d.setVisibility(8);
        goto L12
    }

    public l0(AppCompatImageView r100, String r101, j0 r102, AppCompatImageView r103, Document r104, ThumbGlideUrl r105) {
        this.f235800a = r100;
        this.f235801b = r101;
        this.f235802c = r102;
        this.f235803d = r103;
        this.f235804e = r104;
        this.f235805f = r105;
    }
}
