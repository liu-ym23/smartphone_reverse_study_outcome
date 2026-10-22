package com.bytedance.lighten.loader;

import android.app.ActivityManager;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.ss.android.ugc.aweme.thread.ThreadPoolOptions;
import com.ss.android.ugc.aweme.thread.ThreadPoolType;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountingMemoryCache<CacheKey, CloseableImage> f254712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f254713b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f254714a = null;

        static {
            f254714a = new c();
        }
    }

    public c() {
        Context r100 = df6.g.getContext();
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        if ((r100.getApplicationInfo().flags & 1048576) == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        int r103 = r101.getLargeMemoryClass();
    L9:
        int r104 = (int) ((((long) r103) * 1048576) / 10);
        WindowManager r105 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r106 = new DisplayMetrics();
        r105.getDefaultDisplay().getMetrics(r106);
        int r107 = ((r106.widthPixels * r106.heightPixels) * 4) * 4;
        if (r104 <= r107) goto L13;
        r104 = r107;
    L15:
        this.f254713b = r104;
        this.f254712a = new CountingMemoryCache(new com.bytedance.lighten.loader.a(), new BitmapMemoryCacheTrimStrategy(), new b(this, (ActivityManager) df6.g.getContext().getSystemService("activity")));
        ThreadPoolOptions.Builder r108 = new ThreadPoolOptions.Builder(ThreadPoolType.SERIAL);
        r108.f454332b = "bitmap-cache";
        new g(ThreadPoolHelper.a(new ThreadPoolOptions(r108)));
        return;
    L13:
        if (r104 >= 6291456) goto L15;
        r104 = BmLocated.ALIGN_LEFT_BOTTOM;
        goto L15
    L8:
        r103 = r101.getMemoryClass();
        goto L9
    L5:
        r102 = false;
        goto L6
    }
}
