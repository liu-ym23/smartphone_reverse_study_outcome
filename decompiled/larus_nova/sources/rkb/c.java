package rkb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.Key;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.impl.RequestCreator;
import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
public interface c {
    void clear(View r100);

    void clearMemoryCache(Context r100);

    File downloadOnly(int r100, int r101, RequestCreator r102);

    <R> void downloadOnly(Target<R> r100, RequestCreator r101);

    Bitmap getBitmap(int r100, int r101, RequestCreator r102);

    String getCacheFile(int r100, int r101, RequestCreator r102);

    void into(ImageView r100, RequestCreator r101);

    <R> void into(Target<R> r100, RequestCreator r101);

    void pauseRequests(RequestCreator r100);

    <T extends Key, Y> void registerLoadModelHook(Context r100, Class<T> r101, Class<Y> r102, e<T, Y> r103);

    void resumeRequests(RequestCreator r100);
}
