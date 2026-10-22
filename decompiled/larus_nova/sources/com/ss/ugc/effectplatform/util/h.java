package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.sva.sdk.effectplatform.EffectUtils;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f458037a = null;

    public h() {
    }

    static {
        f458037a = new h();
    }

    public static String b(ProviderEffect r100) {
        ProviderEffect.StickerBean r101 = r100.getSticker_info();
        if (r101 == null) goto L7;
        String r102 = r101.getUrl();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return "";
    }

    public static boolean c(UrlModel r100) {
        if (r100 == null) goto L15;
        List<String> r101 = r100.getUrl_list();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
        goto L11
    L15:
        return true;
    }

    public static List a(List r100, String r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        r102.add(((String) r103.next()) + r101);
        goto L6
    L11:
        return r102;
    L8:
        return null;
    }

    public static void e(String r110, List r111) {
        if (r111 != null) goto L5;
        return;
    L5:
        Iterator r100 = r111.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        Effect r101 = (Effect) r100.next();
        StringBuilder r102 = new StringBuilder();
        r102.append(r110);
        String r103 = FileManager.f21782a;
        r102.append(r103);
        r102.append(StringsKt.replace$default(StringsKt.replace$default(r101.getId(), "\"", "_", false, 4, null), HTTP.URL_DEFAULT, "_", false, 4, null));
        r102.append(".zip");
        r101.setZipPath(r102.toString());
        r101.setUnzipPath(r110 + r103 + StringsKt.replace$default(StringsKt.replace$default(r101.getId(), "\"", "_", false, 4, null), HTTP.URL_DEFAULT, "_", false, 4, null));
        goto L7
    }

    public static void f(String r100, List r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Effect r103 = (Effect) r102.next();
        if (r.b(r100) == true) goto L6;
        if (r100 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r103.setRecId(r100);
        goto L6
    }

    public static void g(String r110, List r111) {
        if (r111 == null) goto L26;
        Iterator r100 = r111.iterator();
    L6:
        if (r100.hasNext() == false) goto L38;
        InfoStickerEffect r101 = (InfoStickerEffect) r100.next();
        Integer r102 = r101.getSource();
        if (r102 == null) goto L13;
        if (r102.intValue() != 1) goto L13;
        Effect r103 = r101.getLoki_effect();
        StringBuilder r104 = new StringBuilder();
        r104.append(r110);
        String r105 = FileManager.f21782a;
        r104.append(r105);
        r104.append(r101.getLoki_effect().getId());
        r104.append(".zip");
        r103.setZipPath(r104.toString());
        r101.getLoki_effect().setUnzipPath(r110 + r105 + r101.getLoki_effect().getId());
    L13:
        if (r102 == null) goto L6;
        if (r102.intValue() != 2) goto L6;
        h r106 = f458037a;
        ProviderEffect r107 = r101.getSticker();
        r106.getClass();
        String r108 = b(r107);
        int r112 = StringsKt.lastIndexOf$default(r108, HTTP.URL_DEFAULT, 0, false, 6, null);
        int r113 = StringsKt.lastIndexOf$default(r108, ".", 0, false, 6, null);
        int r109 = StringsKt.lastIndexOf$default(r108, "?", 0, false, 6, null);
        if (1 > r112) goto L24;
        if (r113 <= r112) goto L24;
        if (r113 < r109) goto L23;
        r109 = r108.length();
    L23:
        String r114 = r108.substring(r113, r109);
    L25:
        r101.getSticker().setPath(r110 + FileManager.f21782a + r101.getSticker().getId() + "_" + r108.hashCode() + r114);
    L24:
        r114 = "";
        goto L25
    L38:
        return;
    }

    public static void h(List r110, List r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        Iterator r112 = r111.iterator();
    L6:
        if (r112.hasNext() == false) goto L99;
        Effect r100 = (Effect) r112.next();
        if (r100.getFile_url().getUrl_type() == null) goto L15;
        Integer r101 = r100.getFile_url().getUrl_type();
        if (r101 == null) goto L23;
        if (r101.intValue() == 0) goto L15;
    L23:
        if (r100.getIcon_url().getUrl_type() == null) goto L30;
        Integer r102 = r100.getIcon_url().getUrl_type();
        if (r102 != null) goto L28;
    L37:
        List<String> r103 = r100.getHint_icon().getUrl_list();
        boolean r104 = true;
        if (r103 != null) goto L40;
    L43:
        boolean r105 = true;
    L44:
        if (r105 == true) goto L58;
        if (r100.getHint_icon().getUrl_type() == null) goto L52;
        Integer r106 = r100.getHint_icon().getUrl_type();
        if (r106 == null) goto L58;
        if (r106.intValue() != 0) goto L58;
    L52:
        UrlModel r107 = r100.getHint_icon();
        List<String> r108 = a(r110, r100.getHint_icon().getUri());
        if (r108 != null) goto L56;
        r108 = new ArrayList();
    L56:
        r107.setUrl_list(r108);
    L58:
        if (r100.getDesigner_avatar().getUrl_type() == null) goto L64;
        Integer r109 = r100.getDesigner_avatar().getUrl_type();
        if (r109 != null) goto L63;
    L79:
        List<UrlModel> r113 = r100.getCovers();
        if (r113 == null) goto L6;
        Iterator<T> r114 = r113.iterator();
    L83:
        if (r114.hasNext() == false) goto L6;
        UrlModel r115 = (UrlModel) r114.next();
        if (r115.getUrl_type() == null) goto L92;
        Integer r116 = r115.getUrl_type();
        if (r116 == null) goto L83;
        if (r116.intValue() != 0) goto L83;
    L92:
        if (r115.getUri() != null) goto L93;
        Logger.e$default(Logger.INSTANCE, EffectUtils.TAG, "effect " + r100.getId() + " covers uri is null", null, 4, null);
        goto L83
    L93:
        h r117 = f458037a;
        String r118 = r115.getUri();
        r117.getClass();
        List<String> r119 = a(r110, r118);
        if (r119 != null) goto L97;
        r119 = new ArrayList();
    L97:
        r115.setUrl_list(r119);
        goto L83
    L63:
        if (r109.intValue() != 0) goto L79;
    L64:
        List<String> r120 = r100.getDesigner_avatar().getUrl_list();
        if (r120 != null) goto L67;
    L70:
        if (r104 == false) goto L79;
        if (r100.getDesigner_avatar().getUri() == null) goto L78;
        UrlModel r121 = r100.getDesigner_avatar();
        h r122 = f458037a;
        String r123 = r100.getDesigner_avatar().getUri();
        r122.getClass();
        List<String> r124 = a(r110, r123);
        if (r124 != null) goto L77;
        r124 = new ArrayList();
    L77:
        r121.setUrl_list(r124);
        goto L79
    L78:
        Logger.e$default(Logger.INSTANCE, EffectUtils.TAG, "effect " + r100.getId() + " designer avatar uri is null", null, 4, null);
        goto L79
    L67:
        if (r120.isEmpty() == true) goto L70;
        r104 = false;
        goto L70
    L40:
        if (r103.isEmpty() == true) goto L43;
        r105 = false;
        goto L44
    L28:
        if (r102.intValue() != 0) goto L37;
    L30:
        if (r100.getIcon_url().getUri() == null) goto L36;
        UrlModel r125 = r100.getIcon_url();
        h r126 = f458037a;
        String r127 = r100.getIcon_url().getUri();
        r126.getClass();
        List<String> r128 = a(r110, r127);
        if (r128 != null) goto L35;
        r128 = new ArrayList();
    L35:
        r125.setUrl_list(r128);
        goto L37
    L36:
        Logger.e$default(Logger.INSTANCE, EffectUtils.TAG, "effect " + r100.getId() + " icon uri is null", null, 4, null);
    L15:
        if (r100.getFile_url().getUri() == null) goto L21;
        UrlModel r129 = r100.getFile_url();
        h r130 = f458037a;
        String r131 = r100.getFile_url().getUri();
        r130.getClass();
        List<String> r132 = a(r110, r131);
        if (r132 != null) goto L20;
        r132 = new ArrayList();
    L20:
        r129.setUrl_list(r132);
        goto L23
    L21:
        Logger.e$default(Logger.INSTANCE, EffectUtils.TAG, "effect " + r100.getId() + " file uri is null", null, 4, null);
        goto L23
    }

    public static void d(String r100, String r101, List r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        Effect r104 = (Effect) r103.next();
        StringBuilder r105 = new StringBuilder();
        r105.append(r100);
        String r106 = FileManager.f21782a;
        r105.append(r106);
        r105.append(r104.getId());
        r105.append(".zip");
        r104.setZipPath(r105.toString());
        r104.setUnzipPath(r100 + r106 + r104.getId());
        if (r101 == null) goto L10;
        String r107 = r101;
    L11:
        r104.setPanel(r107);
        goto L6
    L10:
        r107 = "";
        goto L11
    }
}
