package com.ss.android.lark.watermark.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class y<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WatermarkStateMediatorLiveData f445567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f445568b;

    public static final class a extends SimpleTarget<BitmapDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter<Bitmap> f445569a;

        public a(SingleEmitter<Bitmap> r100) {
            this.f445569a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            this.f445569a.tryOnError(new MysteriousWatermarkException());
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            BitmapDrawable r101 = (BitmapDrawable) r100;
            Intrinsics.checkNotNullParameter(r101, "resource");
            this.f445569a.onSuccess(r101.getBitmap());
        }
    }

    public y(WatermarkStateMediatorLiveData r100, String r101) {
        this.f445567a = r100;
        this.f445568b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f445567a.f445528b.invoke().asBitmap().load(this.f445568b).into(new a(r100));
    }
}
