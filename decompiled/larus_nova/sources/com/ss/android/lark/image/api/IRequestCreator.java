package com.ss.android.lark.image.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.ss.android.lark.image.transform.CropTransformation;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import rkb.g;
import xkb.a;
import xkb.b;

/* JADX INFO: loaded from: classes36.dex */
public interface IRequestCreator {
    IRequestCreator asBitmap();

    IRequestCreator asDrawable();

    IRequestCreator asFile();

    IRequestCreator asGif();

    IRequestCreator centerCrop();

    IRequestCreator decodeFormat(DecodeFormat r100);

    IRequestCreator diskCacheStrategy(DiskCacheStrategy r100);

    IRequestCreator dontAnimate(boolean r100);

    File downloadOnly(int r100, int r101) throws InterruptedException, ExecutionException;

    <R> void downloadOnly(Target<R> r100);

    IRequestCreator error(int r100);

    IRequestCreator error(Drawable r100);

    IRequestCreator fitCenter();

    Bitmap getBitmap(int r100, int r101) throws InterruptedException, ExecutionException;

    String getCacheFile(int r100, int r101);

    IRequestCreator gifFileSize(int r100);

    IRequestCreator gifMaxHeight(int r100);

    IRequestCreator gifMaxWidth(int r100);

    void into(ImageView r100);

    <R> void into(Target<R> r100);

    IRequestCreator isAsync(boolean r100);

    IRequestCreator listener(g r100);

    IRequestCreator load(Object r100);

    IRequestCreator onlyRetrieveFromCache(boolean r100);

    IRequestCreator override(int r100, int r101);

    void pauseRequests();

    IRequestCreator placeholder(int r100);

    IRequestCreator placeholder(Drawable r100);

    void resumeRequests();

    IRequestCreator setErrorScaleType(ImageView.ScaleType r100);

    IRequestCreator signature(Key r100);

    IRequestCreator skipMemoryCache(boolean r100);

    IRequestCreator sourceExecutor(GlideExecutor r100);

    IRequestCreator thumbnail(float r100);

    IRequestCreator thumbnail(IRequestCreator r100);

    IRequestCreator transform(Transformation<Bitmap> r100);

    IRequestCreator transform(CropTransformation r100);

    IRequestCreator transform(a r100);

    IRequestCreator transform(b r100);

    IRequestCreator transforms(List<Transformation<Bitmap>> r100);
}
