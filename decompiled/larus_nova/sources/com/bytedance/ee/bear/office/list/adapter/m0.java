package com.bytedance.ee.bear.office.list.adapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m0 implements RequestListener<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f235807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f235808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f235809c;

    public m0(ImageView r100, String r101, Function0<Unit> r102) {
        this.f235807a = r100;
        this.f235808b = r101;
        this.f235809c = r102;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onLoadFailed(GlideException r100, Object r101, Target<Bitmap> r102, boolean r103) {
        if (Intrinsics.areEqual(this.f235807a.getTag(R.id.avatar_tag), this.f235808b) == true) goto L6;
        return true;
    L6:
        this.f235809c.invoke();
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final boolean onResourceReady(Bitmap r100, Object r101, Target<Bitmap> r102, DataSource r103, boolean r104) {
        return !Intrinsics.areEqual(this.f235807a.getTag(R.id.avatar_tag), this.f235808b);
    }
}
