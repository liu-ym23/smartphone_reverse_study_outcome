package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 implements RequestListener<Bitmap> {
    public final /* synthetic */ AppCompatImageView a;
    public final /* synthetic */ String b;
    public final /* synthetic */ j0 c;
    public final /* synthetic */ AppCompatImageView d;
    public final /* synthetic */ Document e;
    public final /* synthetic */ ThumbGlideUrl f;

    public final boolean onLoadFailed(GlideException r7, Object r8, Target<Bitmap> r9, boolean r10) {
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L5;
        return true;
    L5:
        j0 r3 = this.c;
        AppCompatImageView r11 = this.a;
        AppCompatImageView r4 = this.d;
        Document r12 = this.e;
        String r2 = this.b;
        ThumbGlideUrl r5 = r3.d(r11, r12);
        if (r5 != null) goto L8;
        boolean r13 = false;
    L9:
        if (r13 == false) goto L11;
        return true;
    L11:
        this.a.setVisibility(4);
        this.d.setVisibility(0);
        return true;
    L8:
        r11.post(new n0(r11, r2, r3, r4, r5));
        r13 = true;
        goto L9
    }

    public final boolean onResourceReady(Object r7, Object r8, Target r9, DataSource r10, boolean r11) {
        Bitmap r12 = (Bitmap) r7;
        if (Intrinsics.areEqual(this.a.getTag(2131363734), this.b) == true) goto L6;
        return true;
    L6:
        if (this.f.isIcon() == false) goto L11;
        j0 r3 = this.c;
        AppCompatImageView r13 = this.a;
        AppCompatImageView r4 = this.d;
        Document r14 = this.e;
        String r2 = this.b;
        ThumbGlideUrl r5 = r3.d(r13, r14);
        if (r5 == null) goto L12;
        r13.post(new n0(r13, r2, r3, r4, r5));
        return true;
    L12:
        return false;
    L11:
        this.a.setVisibility(0);
        this.d.setVisibility(8);
        goto L12
    }

    public l0(AppCompatImageView r1, String r2, j0 r3, AppCompatImageView r4, Document r5, ThumbGlideUrl r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
