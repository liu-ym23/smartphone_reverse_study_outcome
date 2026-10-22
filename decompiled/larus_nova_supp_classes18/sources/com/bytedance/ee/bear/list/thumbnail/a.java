package com.bytedance.ee.bear.list.thumbnail;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static OfficeThumbnailUrlRepository.ThumbnailUrlInfo a(JSONObject r10) {
        boolean r1 = true;
        String r2 = "";
        if (r10.optBoolean("is_cover", true) == false) goto L86;
        String r0 = r10.optString("cdn_url");
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L18;
        r0 = null;
    L18:
        if (r0 != null) goto L30;
        r0 = r10.optString(ResourceData.KEY_URL);
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L23;
        r0 = null;
    L23:
        if (r0 != null) goto L30;
        r0 = r10.optString("cover_url");
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == true) goto L28;
        r0 = null;
    L28:
        if (r0 != null) goto L30;
    L31:
        String r5 = StringsKt.trim(StringsKt.removeSurrounding(StringsKt.trim(r2).toString(), "`")).toString();
        if (r5 != null) goto L34;
    L36:
        boolean r4 = false;
    L37:
        if (r4 == true) goto L46;
        if (r5 != null) goto L40;
    L42:
        boolean r6 = false;
    L43:
        if (r6 == true) goto L46;
        boolean r7 = false;
    L47:
        if (r7 == true) goto L49;
        return null;
    L49:
        String[] r8 = {"cipher_type", "decrypt_type"};
        int r9 = 0;
    L50:
        if (r9 >= 2) goto L64;
        Object r11 = r10.opt(r8[r9]);
        if (r11 == null) goto L63;
        if ((r11 instanceof Number) == true) goto L56;
        if ((r11 instanceof String) == false) goto L63;
        Integer r12 = StringsKt.toIntOrNull(StringsKt.trim((String) r11).toString());
        if (r12 == null) goto L63;
        int r3 = r12.intValue();
    L62:
        int r13 = r3;
    L65:
        String r14 = b(r10, new String[]{"secret", "decrypt_key"});
        String r15 = b(r10, new String[]{"nonce", "decrypt_nonce"});
        if (r13 <= 0) goto L85;
        if (r14 != null) goto L69;
    L72:
        boolean r16 = true;
    L73:
        if (r16 == true) goto L83;
        if (r15 != null) goto L76;
    L79:
        if (r1 == true) goto L83;
        return new OfficeThumbnailUrlRepository.ThumbnailUrlInfo(r5, r14, r15, r13, true);
    L76:
        if (StringsKt.isBlank(r15) == true) goto L79;
        r1 = false;
    L83:
        return null;
    L69:
        if (StringsKt.isBlank(r14) == true) goto L72;
        r16 = false;
        goto L73
    L85:
        return new OfficeThumbnailUrlRepository.ThumbnailUrlInfo(r5, null, null, 0, false);
    L56:
        r3 = ((Number) r11).intValue();
    L63:
        r9 = r9 + 1;
        goto L50
    L64:
        r13 = 0;
        goto L65
    L40:
        if (StringsKt.startsWith$default(r5, "https://", false, 2, null) != true) goto L42;
        r6 = true;
    L46:
        r7 = true;
        goto L47
    L34:
        if (StringsKt.startsWith$default(r5, "http://", false, 2, null) != true) goto L36;
        r4 = true;
    L30:
        r2 = r0;
        goto L31
    L86:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L6
        Object r18 = Result.constructor-impl(du5.b.k(r10.optString("file_token")));     // Catch: Throwable -> L6
    L8:
        Object r19 = r2;
        if (Result.isFailure-impl(r18) == true) goto L12;
        r19 = r18;
    L12:
        tt5.a.k("OfficeThumbnailUrlRepos", "drop drive cdn thumbnail because is_cover=false, fileToken=" + ((String) r19));
        return null;
    L6:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static String b(JSONObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        String r2 = null;
        if (r1 >= r0) goto L11;
        String r3 = StringsKt.trim(r5.optString(r6[r1])).toString();
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        r2 = r3;
    L8:
        if (r2 != null) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    L11:
        return null;
    }
}
