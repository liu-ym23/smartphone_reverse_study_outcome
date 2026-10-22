package com.ss.android.lark.image.impl.preload;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/image/impl/preload/ImagePreloadSettings;", "", "<init>", "()V", "TAG", "", "config", "Lcom/ss/android/lark/image/impl/preload/ImagePreloadConfig;", "getConfig", "()Lcom/ss/android/lark/image/impl/preload/ImagePreloadConfig;", "config$delegate", "Lkotlin/Lazy;", "getStrategy", "Lcom/ss/android/lark/image/impl/preload/PreloadStrategy;", "scene", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImagePreloadSettings {
    public static final int $stable = 0;
    public static final ImagePreloadSettings INSTANCE = null;
    private static final Lazy config$delegate = null;

    private ImagePreloadSettings() {
    }

    static {
        INSTANCE = new ImagePreloadSettings();
        config$delegate = LazyKt.lazy(ImagePreloadSettings$config$2.INSTANCE);
        $stable = 8;
    }

    public final ImagePreloadConfig getConfig() {
        return (ImagePreloadConfig) config$delegate.getValue();
    }

    public final PreloadStrategy getStrategy(String r110) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        PreloadStrategy[] r100 = getConfig().getStrategy();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        PreloadStrategy r103 = r100[r102];
        if (Intrinsics.areEqual(r103.getScene(), r110) == true) goto L9;
        r102 = r102 + 1;
    L9:
        if (r103 == null) goto L11;
        return r103;
    L11:
        return new PreloadStrategy(null, 0, 0, 7, null);
    L8:
        r103 = null;
        goto L9
    }
}
