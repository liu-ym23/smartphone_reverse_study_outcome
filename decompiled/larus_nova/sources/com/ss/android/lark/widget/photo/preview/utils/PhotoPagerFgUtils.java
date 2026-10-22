package com.ss.android.lark.widget.photo.preview.utils;

import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class PhotoPagerFgUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f447136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f447137b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f447138c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f447139d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f447140e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f447141f = null;

    static {
        f447136a = LazyKt.lazy(PhotoPagerFgUtils$isOpenImageOCR$2.INSTANCE);
        f447137b = LazyKt.lazy(PhotoPagerFgUtils$isOCRLiveText$2.INSTANCE);
        f447138c = LazyKt.lazy(PhotoPagerFgUtils$isLiveTextMenuAI$2.INSTANCE);
        f447139d = LazyKt.lazy(PhotoPagerFgUtils$isAITabEnabled$2.INSTANCE);
        f447140e = LazyKt.lazy(PhotoPagerFgUtils$isSupportScreenCaptureForQRCode$2.INSTANCE);
        f447141f = LazyKt.lazy(PhotoPagerFgUtils$isSupportHorizontalPreview$2.INSTANCE);
    }

    public static final boolean c() {
        return ((Boolean) f447137b.getValue()).booleanValue();
    }

    @JvmStatic
    public static final boolean a() {
        boolean r100 = idb.f.a().isCurrentEnable("im.message.file.deleted.from.admin");
        Log.i("PhotoPagerFgUtils", "isEnableResourceDeleted:" + r100);
        return r100;
    }

    @JvmStatic
    public static final boolean b() {
        boolean r100 = idb.f.a().isCurrentEnable("im.videoplayer.speed");
        Log.i("PhotoPagerFgUtils", "isEnableVidePlayerOpt:" + r100);
        return r100;
    }
}
