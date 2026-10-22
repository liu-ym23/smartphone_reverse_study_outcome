package com.ss.android.lark.widget.photopickernew.utils;

import com.ss.android.lark.widget.thumb.AlbumSettingUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AlbumUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f447969a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f447970b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f447971c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f447972d = null;

    public interface a {
    }

    static {
        f447969a = LazyKt.lazy(AlbumUtils$horizontalItemSize$2.INSTANCE);
        f447970b = LazyKt.lazy(AlbumUtils$girdItemSize$2.INSTANCE);
        f447971c = LazyKt.lazy(AlbumUtils$serialSourceExecutor$2.INSTANCE);
        f447972d = LazyKt.lazy(AlbumUtils$remoteConfigSourceExecutor$2.INSTANCE);
    }

    public static boolean a(com.ss.android.lark.widget.thumb.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (r100.f448953d == false) goto L5;
        return false;
    L5:
        if (r100.f448955f == false) goto L7;
        return false;
    L7:
        if (r100.f448951b != null) goto L9;
        return false;
    L9:
        if (r100.f448952c <= ((((Number) AlbumSettingUtils.f448947d.getValue()).intValue() * 1024) * 1024)) goto L16;
        return true;
    L16:
        return false;
    }
}
