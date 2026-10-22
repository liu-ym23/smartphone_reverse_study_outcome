package com.bytedance.android.shopping.store.tabkit.ssr;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static final boolean b(SSRModel r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isError");
        if (r2.getErrorCode() != null) goto L15;
        String r3 = r2.getErrorMsg();
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r4 = false;
        goto L11
    L15:
        return true;
    }

    public static final boolean c(SSRModel r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$isHydrateDataValid");
        String r0 = r3.getHydrateData();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L31;
        String r2 = r3.getHydrateUrl();
        if (r2 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L32;
        String r6 = r3.getHydrateHash();
        if (r6 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L33;
        if (r4 == false) goto L28;
    L29:
        return true;
    L28:
        if (r3.getHydrateBytes() != null) goto L29;
        return false;
    L33:
        return false;
    L21:
        if (StringsKt.isBlank(r6) == true) goto L24;
        r7 = false;
        goto L25
    L32:
        return false;
    L13:
        if (StringsKt.isBlank(r2) == true) goto L16;
        r5 = false;
        goto L17
    L31:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final Map<String, String> a(int r3, String r4, Integer r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("ssr_downgrade", CommentScene.COMMENTSCENE_NO_AWEME);
        r0.put("ssr_error_code", String.valueOf(r3));
        if (r4 != null) goto L5;
        r4 = "unknown error";
    L5:
        r0.put("ssr_error_message", r4);
        if (r5 == null) goto L9;
        String r6 = String.valueOf(r5.intValue());
        if (r6 == null) goto L9;
    L10:
        r0.put("ssr_sub_error_code", r6);
        return r0;
    L9:
        r6 = "";
        goto L10
    }
}
