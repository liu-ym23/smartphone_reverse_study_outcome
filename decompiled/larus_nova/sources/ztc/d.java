package ztc;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorService f573650e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f573651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f573652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap f573653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f573654d;

    public interface a {
    }

    static {
        f573650e = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("urry/BlurTask"));
    }

    public d(View r100, b r101, com.alibaba.gaiax.render.view.basic.d r102) {
        this.f573652b = r101;
        this.f573654d = r102;
        this.f573651a = new WeakReference(r100.getContext());
        r100.setDrawingCacheEnabled(true);
        r100.destroyDrawingCache();
        r100.setDrawingCacheQuality(524288);
        Bitmap r103 = r100.getDrawingCache();
        this.f573653c = r103.copy(Bitmap.Config.ARGB_8888, true);
        r103.recycle();
    }
}
