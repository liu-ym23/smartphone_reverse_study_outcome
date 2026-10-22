package com.ss.android.lark.image.uploader.config;

import com.ss.android.lark.image.uploader.utils.ImageInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f426369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ImageUploadConfig f426370b = null;

    static {
        f426369a = LazyKt.lazy(ConfigManager$config$2.INSTANCE);
        f426370b = new ImageUploadConfig();
    }

    public static ImageUploadConfig a() {
        return (ImageUploadConfig) f426369a.getValue();
    }

    public static long b() {
        c r100 = a().getFileSizeConfig();
        if (r100 != null) goto L10;
        c r101 = f426370b.getFileSizeConfig();
        if (r101 != null) goto L11;
        return 52428800;
    L11:
        return r101.b();
    L10:
        return r100.b();
    }

    public static h f() {
        h r100 = a().getUploadAvatarConfig();
        if (r100 != null) goto L8;
        h r101 = f426370b.getUploadAvatarConfig();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new h();
    L8:
        return r100;
    }

    public static long c(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        c r101 = a().getFileSizeConfig();
        String r102 = null;
        if (r101 == null) goto L8;
        ImageInfo r103 = r100.f426397k;
        if (r103 == null) goto L16;
        r102 = r103.f426425e;
    L16:
        return r101.a(r102).a();
    L8:
        c r104 = f426370b.getFileSizeConfig();
        if (r104 == null) goto L14;
        ImageInfo r105 = r100.f426397k;
        if (r105 == null) goto L17;
        r102 = r105.f426425e;
    L17:
        return r104.a(r102).a();
    L14:
        return 26214400;
    }

    public static int d(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        c r101 = a().getFileSizeConfig();
        String r102 = null;
        if (r101 == null) goto L11;
        ImageInfo r103 = r100.f426397k;
        if (r103 == null) goto L7;
        String r104 = r103.f426425e;
    L8:
        f r105 = r101.a(r104).b();
        if (r105 == null) goto L11;
        return r105.a();
    L7:
        r104 = null;
    L11:
        c r106 = f426370b.getFileSizeConfig();
        if (r106 == null) goto L19;
        ImageInfo r107 = r100.f426397k;
        if (r107 == null) goto L16;
        r102 = r107.f426425e;
    L16:
        f r108 = r106.a(r102).b();
        if (r108 == null) goto L19;
        return r108.a();
    L19:
        return 12000;
    }

    public static int e(com.ss.android.lark.image.uploader.entity.b r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadImage");
        c r101 = a().getFileSizeConfig();
        String r102 = null;
        if (r101 == null) goto L11;
        ImageInfo r103 = r100.f426397k;
        if (r103 == null) goto L7;
        String r104 = r103.f426425e;
    L8:
        f r105 = r101.a(r104).b();
        if (r105 == null) goto L11;
        return r105.b();
    L7:
        r104 = null;
    L11:
        c r106 = f426370b.getFileSizeConfig();
        if (r106 == null) goto L19;
        ImageInfo r107 = r100.f426397k;
        if (r107 == null) goto L16;
        r102 = r107.f426425e;
    L16:
        f r108 = r106.a(r102).b();
        if (r108 == null) goto L19;
        return r108.b();
    L19:
        return 12000;
    }
}
