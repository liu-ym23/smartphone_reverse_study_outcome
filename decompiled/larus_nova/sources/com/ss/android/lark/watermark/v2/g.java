package com.ss.android.lark.watermark.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileWatermarkStateMediatorLiveData f445545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f445546b;

    public static final class a extends SimpleTarget<BitmapDrawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleEmitter<Bitmap> f445547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f445548b;

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            Log.e("FileWatermarkStateMediatorLiveData", "load image failed, url: " + this.f445548b);
            this.f445547a.tryOnError(new FileMysteriousWatermarkException());
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            BitmapDrawable r101 = (BitmapDrawable) r100;
            Intrinsics.checkNotNullParameter(r101, "resource");
            if (this.f445547a.isDisposed() == true) goto L6;
            this.f445547a.onSuccess(r101.getBitmap());
            return;
        }

        public a(SingleEmitter<Bitmap> r100, String r101) {
            this.f445547a = r100;
            this.f445548b = r101;
        }
    }

    public g(FileWatermarkStateMediatorLiveData r100, String r101) {
        this.f445545a = r100;
        this.f445546b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        this.f445545a.f445523b.invoke().asBitmap().load(this.f445546b).into(new a(r100, this.f445546b));
    }
}
