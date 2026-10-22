package com.larus.bot.impl.common.util;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Bitmap> f317674a;

    public a(kotlinx.coroutines.j r100) {
        this.f317674a = r100;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        if (this.f317674a.isActive() == false) goto L6;
        this.f317674a.resumeWith(Result.m9449constructorimpl(null));
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        if (this.f317674a.isActive() == false) goto L6;
        this.f317674a.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }
}
