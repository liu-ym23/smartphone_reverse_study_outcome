package com.ss.android.lark.chat.utils;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class w {
    static {
    }

    @JvmStatic
    public static final void a(ImageSet r100, ValidateIMFileResult r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        IMFileResult r102 = null;
        if (r101 == null) goto L43;
        ValidateIMFileResult.a r103 = ValidateIMFileResult.Companion;
        boolean r104 = false;
        if ((r100 instanceof MediaImageSet) == false) goto L21;
        MediaExtra r105 = ((MediaImageSet) r100).getMediaExtra();
        if (r105 == null) goto L21;
        String r106 = r105.getKey();
        if (r106 == null) goto L21;
        if (r106.length() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L21;
    L42:
        r103.getClass();
        ValidateIMFileResult r108 = ValidateIMFileResult.a.a(r101, r106);
    L44:
        if (r108 == null) goto L46;
        r102 = r108.getResultType();
    L46:
        r100.setReceiveAuthorizationStateValue(MessagePermissionUtil.h(r102).getValue());
        r100.setValidateIMFileResult(r108);
        return;
    L15:
        r107 = false;
    L21:
        r106 = r100.getKey();
        if (r106 != null) goto L24;
    L32:
        Image r109 = r100.getOrigin();
        if (r109 == null) goto L41;
        r106 = r109.getKey();
        if (r106 == null) goto L41;
        if (r106.length() <= 0) goto L39;
        r104 = true;
    L39:
        if (r104 == true) goto L42;
    L41:
        r106 = null;
        goto L42
    L24:
        if (r106.length() <= 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == true) goto L30;
        r106 = null;
    L30:
        if (r106 == null) goto L32;
    L26:
        r110 = false;
        goto L27
    L43:
        r108 = null;
        goto L44
    }
}
