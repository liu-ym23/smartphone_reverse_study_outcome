package com.ss.android.lark.image;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.Request;
import com.larus.nova.R;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.impl.GlideImageLoader;
import com.ss.android.lark.image.impl.RequestCreatorContainer;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes36.dex */
public class ImageLoader {
    private static final String TAG = "ImageLoader";
    private static a sDependency;
    private static final rkb.c sImagerLoaderProxy = null;

    public interface a {
        GlideExecutor getCustomSourceExecutor(Object r100);

        boolean hasImageCache(String r100);

        void reportError(String r100, String r101);
    }

    public ImageLoader() {
    }

    static {
        sImagerLoaderProxy = new GlideImageLoader();
        sDependency = (a) ApiUtils.getApi(a.class);
    }

    public static a getDependency() {
        return sDependency;
    }

    public static void clear(View r100) {
        sImagerLoaderProxy.clear(r100);
    }

    public static void clearMemoryCache(Context r100) {
        sImagerLoaderProxy.clearMemoryCache(r100);
    }

    public static Request getRequest(View r100) {
        Object r101 = r100.getTag(R.id.glide_custom_view_target_tag);
        if (r101 != null) goto L5;
    L8:
        return null;
    L5:
        if ((r101 instanceof Request) == true) goto L10;
        Log.w(TAG, "getRequest:" + r101.getClass());
        goto L8
    L10:
        return (Request) r101;
    }

    public static IRequestCreator with(Fragment r100) {
        return new RequestCreatorContainer(sImagerLoaderProxy, r100);
    }

    public static IRequestCreator with(Context r100) {
        return new RequestCreatorContainer(sImagerLoaderProxy, r100);
    }

    public static IRequestCreator with(androidx.fragment.app.Fragment r100) {
        return new RequestCreatorContainer(sImagerLoaderProxy, r100);
    }

    public static void setRequest(View r100, Request r101) {
        r100.setTag(R.id.glide_custom_view_target_tag, r101);
    }

    public static <T extends Key, Y> void registerLoadModelHook(Context r100, Class<T> r101, Class<Y> r102, rkb.e<T, Y> r103) {
        sImagerLoaderProxy.registerLoadModelHook(r100, r101, r102, r103);
    }
}
