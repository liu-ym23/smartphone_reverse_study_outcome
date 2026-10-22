package com.larus.uaigc.createpage.component.stylelist;

import com.bytedance.keva.Keva;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zd9.h;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f372477a = null;

    static {
        f372477a = Keva.getRepo("ImageStyleListCache", 0);
    }

    public static void a(ImageStyleRecommendApi.ImageStyleRecommendResponse r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, UserInfo.LANGUAGECODE);
        if (r100 == null) goto L17;
        List<ImageStyleRecommendApi.ImageStyle> r102 = r100.getStyleList();
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L17;
        FLogger.f375446a.i("ImageStyleListCache", "saveImageStyleList");
        Keva r104 = f372477a;
        String r105 = "image_style_list_resp_" + r101;
        h.f571481a.getClass();
        String r106 = h.c(r100);
        if (r106 != null) goto L16;
        r106 = "";
    L16:
        r104.storeString(r105, r106);
        return;
    L7:
        if (r102.isEmpty() == true) goto L10;
        r103 = false;
    L17:
        f372477a.erase("image_style_list_resp_" + r101);
    }
}
