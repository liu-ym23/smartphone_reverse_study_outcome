package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f324784a = null;

    static {
        f324784a = new r();
    }

    public r() {
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L11;
        return null;
    L11:
        if (StringsKt.startsWith$default(r100, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == false) goto L14;
        return UriProtector.parse(r100).getPath();
    L14:
        if (StringsKt.startsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == true) goto L16;
        return null;
    L16:
        return r100;
    }
}
