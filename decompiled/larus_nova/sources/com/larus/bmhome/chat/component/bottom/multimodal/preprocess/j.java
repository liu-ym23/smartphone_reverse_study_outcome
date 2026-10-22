package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f299948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f299949b = null;

    static {
        f299948a = new Regex("^[a-zA-Z0-9]{1,16}$");
        f299949b = MapsKt.mapOf(new Pair[]{TuplesKt.to("image/jpeg", LoadParams.ImageFormat.JPEG), TuplesKt.to("image/jpg", "jpg"), TuplesKt.to("image/png", LoadParams.ImageFormat.PNG), TuplesKt.to(MimeType.WEBP, "webp"), TuplesKt.to("image/heic", "heic"), TuplesKt.to("image/heif", "heif"), TuplesKt.to(MimeType.GIF, "gif")});
    }

    public static String a(String r100, String r101) {
        if (r100 == null) goto L11;
        String r102 = StringsKt.substringAfterLast(r100, '.', "");
        if (r102 == null) goto L11;
        String r103 = StringsKt.trim(r102).toString();
        if (r103 == null) goto L11;
        if (f299948a.matches(r103) == false) goto L11;
    L12:
        if (r103 != null) goto L20;
        if (r101 == null) goto L21;
        String r104 = StringsKt.trim(r101).toString();
        if (r104 == null) goto L22;
        String r105 = r104.toLowerCase(Locale.ROOT);
        if (r105 != null) goto L24;
        return null;
    L24:
        return f299949b.get(r105);
    L22:
        return null;
    L21:
        return null;
    L20:
        return r103;
    L11:
        r103 = null;
        goto L12
    }
}
