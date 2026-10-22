package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f372442a = 0;

    static {
    }

    public static Image a(Map r210) {
        Intrinsics.checkNotNullParameter(r210, "attributes");
        String r100 = (String) r210.get("video_cover_key");
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = (String) r210.get("video_cover_local_path");
        if (r102 == null) goto L10;
        r101 = r102;
    L10:
        if (StringsKt.isBlank(r100) == false) goto L15;
        if (StringsKt.isBlank(r101) == false) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r100)) == false) goto L17;
        String r103 = r100;
    L19:
        if ((!StringsKt.isBlank(r101)) == false) goto L21;
        String r110 = r101;
    L22:
        String r104 = (String) r210.get("video_cover_width");
        if (r104 == null) goto L27;
        Integer r105 = StringsKt.toIntOrNull(r104);
        if (r105 == null) goto L27;
        int r211 = r105.intValue();
    L28:
        String r106 = (String) r210.get("video_cover_height");
        if (r106 == null) goto L33;
        Integer r107 = StringsKt.toIntOrNull(r106);
        if (r107 == null) goto L33;
        int r212 = r107.intValue();
    L35:
        return new Image(r103, null, null, new ImageObj(null, r211, r212, null, null, 25, null), null, r110, null, null, null, null, null, null, null, null, 16342, null);
    L33:
        r212 = 0;
    L27:
        r211 = 0;
        goto L28
    L21:
        r110 = null;
        goto L22
    L17:
        r103 = null;
        goto L19
    }
}
