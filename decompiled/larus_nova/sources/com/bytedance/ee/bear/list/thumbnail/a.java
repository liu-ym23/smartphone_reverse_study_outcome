package com.bytedance.ee.bear.list.thumbnail;

import com.ss.android.lark.widget.span.InlineCodeInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f229782a = null;

    static {
        f229782a = new a();
    }

    public a() {
    }

    public static OfficeThumbnailUrlRepository.ThumbnailUrlInfo a(JSONObject r110) {
        boolean r100 = true;
        String r101 = "";
        if (r110.optBoolean("is_cover", true) == false) goto L86;
        String r102 = r110.optString("cdn_url");
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == true) goto L18;
        r102 = null;
    L18:
        if (r102 != null) goto L30;
        r102 = r110.optString("url");
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == true) goto L23;
        r102 = null;
    L23:
        if (r102 != null) goto L30;
        r102 = r110.optString("cover_url");
        Intrinsics.checkNotNull(r102);
        if ((!StringsKt.isBlank(r102)) == true) goto L28;
        r102 = null;
    L28:
        if (r102 != null) goto L30;
    L31:
        String r103 = StringsKt.trim(StringsKt.removeSurrounding(StringsKt.trim(r101).toString(), InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER)).toString();
        if (r103 != null) goto L34;
    L36:
        boolean r104 = false;
    L37:
        if (r104 == true) goto L46;
        if (r103 != null) goto L40;
    L42:
        boolean r105 = false;
    L43:
        if (r105 == true) goto L46;
        boolean r106 = false;
    L47:
        if (r106 == true) goto L49;
        return null;
    L49:
        String[] r107 = {"cipher_type", "decrypt_type"};
        int r108 = 0;
    L50:
        if (r108 >= 2) goto L64;
        Object r109 = r110.opt(r107[r108]);
        if (r109 == null) goto L63;
        if ((r109 instanceof Number) == true) goto L56;
        if ((r109 instanceof String) == false) goto L63;
        Integer r111 = StringsKt.toIntOrNull(StringsKt.trim((String) r109).toString());
        if (r111 == null) goto L63;
        int r112 = r111.intValue();
    L62:
        int r113 = r112;
    L65:
        String r114 = b(r110, new String[]{"secret", "decrypt_key"});
        String r115 = b(r110, new String[]{"nonce", "decrypt_nonce"});
        if (r113 <= 0) goto L85;
        if (r114 != null) goto L69;
    L72:
        boolean r116 = true;
    L73:
        if (r116 == true) goto L83;
        if (r115 != null) goto L76;
    L79:
        if (r100 == true) goto L83;
        return new OfficeThumbnailUrlRepository.ThumbnailUrlInfo(r103, r114, r115, r113, true);
    L76:
        if (StringsKt.isBlank(r115) == true) goto L79;
        r100 = false;
    L83:
        return null;
    L69:
        if (StringsKt.isBlank(r114) == true) goto L72;
        r116 = false;
        goto L73
    L85:
        return new OfficeThumbnailUrlRepository.ThumbnailUrlInfo(r103, null, null, 0, false);
    L56:
        r112 = ((Number) r109).intValue();
    L63:
        r108 = r108 + 1;
        goto L50
    L64:
        r113 = 0;
        goto L65
    L40:
        if (StringsKt.startsWith$default(r103, "https://", false, 2, null) != true) goto L42;
        r105 = true;
    L46:
        r106 = true;
        goto L47
    L34:
        if (StringsKt.startsWith$default(r103, "http://", false, 2, null) != true) goto L36;
        r104 = true;
    L30:
        r101 = r102;
        goto L31
    L86:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L6
        Object r118 = Result.m9449constructorimpl(du5.b.k(r110.optString("file_token")));     // Catch: Throwable -> L6
    L8:
        Object r119 = r101;
        if (Result.m9455isFailureimpl(r118) == true) goto L12;
        r119 = r118;
    L12:
        tt5.a.k("OfficeThumbnailUrlRepos", "drop drive cdn thumbnail because is_cover=false, fileToken=" + ((String) r119));
        return null;
    L6:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static String b(JSONObject r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        String r104 = null;
        if (r103 >= r102) goto L11;
        String r105 = StringsKt.trim(r100.optString(r101[r103])).toString();
        if ((!StringsKt.isBlank(r105)) == false) goto L8;
        r104 = r105;
    L8:
        if (r104 != null) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return r104;
    L11:
        return null;
    }
}
