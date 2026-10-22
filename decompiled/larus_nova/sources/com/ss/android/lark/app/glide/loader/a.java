package com.ss.android.lark.app.glide.loader;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bytedance.android.live.uikit.toast.CustomToast;
import java.io.InputStream;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ModelLoader<GlideUrl, InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Option<Integer> f408733b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ModelCache<GlideUrl, GlideUrl> f408734a;

    /* JADX INFO: renamed from: com.ss.android.lark.app.glide.loader.a$a, reason: collision with other inner class name */
    public static class C4744a implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ModelCache<GlideUrl, GlideUrl> f408735a;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final void teardown() {
        }

        public C4744a() {
            this.f408735a = new ModelCache(500);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public final ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory r100) {
            return new a(this.f408735a);
        }
    }

    static {
        f408733b = Option.memory("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(CustomToast.LENGTH_SHORT));
    }

    public a(ModelCache<GlideUrl, GlideUrl> r100) {
        this.f408734a = r100;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final /* bridge */ /* synthetic */ boolean handles(GlideUrl r100) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public final ModelLoader.LoadData<InputStream> buildLoadData(GlideUrl r100, int r101, int r102, Options r103) {
        GlideUrl r104 = r100;
        ModelCache<GlideUrl, GlideUrl> r105 = this.f408734a;
        if (r105 == null) goto L9;
        GlideUrl r106 = r105.get(r104, 0, 0);
        if (r106 != null) goto L7;
        this.f408734a.put(r104, 0, 0, r104);
        goto L9
    L7:
        r104 = r106;
    L9:
        return new ModelLoader.LoadData(r104, new b(r104, ((Integer) r103.get(f408733b)).intValue()));
    }
}
