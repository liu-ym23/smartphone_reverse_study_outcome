package oj9;

import android.util.Base64;
import com.larus.livetutor.api.idl.DoubaoActionbarPageQueryParams;
import com.larus.livetutor.api.idl.DoubaoSuggestQueryParams;
import com.larus.livetutor.api.idl.Image;
import com.larus.livetutor.api.idl.LiveTutorV2Params;
import com.larus.livetutor.api.idl.TutorEntranceType;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final String b(LiveTutorV2Params r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getTutorEntranceType();
        TutorEntranceType r102 = TutorEntranceType.DoubaoActionbarPage;
        int r103 = r102.getValue();
        if (r101 != null) goto L6;
    L7:
        int r104 = TutorEntranceType.History.getValue();
        if (r101 != null) goto L11;
    L13:
        int r105 = TutorEntranceType.DoubaoSuggest.getValue();
        if (r101 != null) goto L17;
    L50:
        String r106 = null;
    L51:
        Integer r107 = r100.getTutorEntranceType();
        int r108 = r102.getValue();
        if (r107 != null) goto L55;
    L56:
        int r109 = TutorEntranceType.History.getValue();
        if (r107 != null) goto L60;
    L62:
        int r110 = TutorEntranceType.DoubaoSuggest.getValue();
        if (r107 != null) goto L66;
    L99:
        String r111 = null;
    L100:
        if (r106 != null) goto L102;
    L105:
        boolean r112 = true;
    L106:
        if (r112 == true) goto L112;
        if (y0.e(r106) == false) goto L136;
        return r106;
    L136:
        return MSkiaImageRegionDecoder.FILE_PREFIX + r106;
    L112:
        if (o0.d(r111) == false) goto L137;
        StringBuilder r113 = new StringBuilder(fyb.a.KEY_DATA);
        byte[] r114 = Base64.decode(r111, 0);     // Catch: Exception -> L132
        if (r114.length < 3) goto L122;
        if (r114[0] != (-1)) goto L122;
        if (r114[1] != (-40)) goto L122;
        String r115 = "image/jpeg";
    L130:
        r113.append(r115);
        r113.append(";base64,");
        r113.append(r111);
        return r113.toString();
    L122:
        if (r114.length < 6) goto L129;
        if (r114[0] != 82) goto L129;
        if (r114[1] != 73) goto L129;
        r115 = MimeType.WEBP;
    L129:
        r115 = "image/png";
        goto L130
    L137:
        return null;
    L102:
        if (r106.length() == 0) goto L105;
        r112 = false;
        goto L106
    L66:
        if (r107.intValue() != r110) goto L99;
        DoubaoSuggestQueryParams r116 = r100.getDoubaoSuggestQueryParams();
        if (r116 == null) goto L74;
        List<Image> r117 = r116.getImages();
        if (r117 == null) goto L74;
        Image r118 = (Image) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L74;
        r111 = r118.getImageBase64();
    L75:
        if (r111 != null) goto L77;
    L80:
        boolean r119 = true;
    L81:
        if (r119 == true) goto L99;
    L77:
        if (r111.length() == 0) goto L80;
        r119 = false;
    L74:
        r111 = null;
        goto L75
    L60:
        if (r107.intValue() != r109) goto L62;
    L83:
        DoubaoActionbarPageQueryParams r120 = r100.getDoubaoActionbarPageQueryParams();
        if (r120 == null) goto L90;
        List<Image> r121 = r120.getImages();
        if (r121 == null) goto L90;
        Image r122 = (Image) CollectionsKt.firstOrNull(r121);
        if (r122 == null) goto L90;
        r111 = r122.getImageBase64();
    L91:
        if (r111 != null) goto L93;
    L96:
        boolean r123 = true;
    L97:
        if (r123 == true) goto L99;
    L93:
        if (r111.length() == 0) goto L96;
        r123 = false;
    L90:
        r111 = null;
        goto L91
    L55:
        if (r107.intValue() == r108) goto L83;
    L17:
        if (r101.intValue() != r105) goto L50;
        DoubaoSuggestQueryParams r124 = r100.getDoubaoSuggestQueryParams();
        if (r124 == null) goto L25;
        List<Image> r125 = r124.getImages();
        if (r125 == null) goto L25;
        Image r126 = (Image) CollectionsKt.firstOrNull(r125);
        if (r126 == null) goto L25;
        r106 = r126.getImageUrl();
    L26:
        if (r106 != null) goto L28;
    L31:
        boolean r127 = true;
    L32:
        if (r127 == true) goto L50;
    L28:
        if (r106.length() == 0) goto L31;
        r127 = false;
    L25:
        r106 = null;
        goto L26
    L11:
        if (r101.intValue() != r104) goto L13;
    L34:
        DoubaoActionbarPageQueryParams r128 = r100.getDoubaoActionbarPageQueryParams();
        if (r128 == null) goto L41;
        List<Image> r129 = r128.getImages();
        if (r129 == null) goto L41;
        Image r130 = (Image) CollectionsKt.firstOrNull(r129);
        if (r130 == null) goto L41;
        r106 = r130.getImageUrl();
    L42:
        if (r106 != null) goto L44;
    L47:
        boolean r131 = true;
    L48:
        if (r131 == true) goto L50;
    L44:
        if (r106.length() == 0) goto L47;
        r131 = false;
    L41:
        r106 = null;
        goto L42
    L6:
        if (r101.intValue() == r103) goto L34;
        goto L7
    }

    public static final String c(LiveTutorV2Params r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r101 = r100.getTutorEntranceType();
        int r102 = TutorEntranceType.DoubaoActionbarPage.getValue();
        boolean r103 = false;
        if (r101 != null) goto L6;
    L7:
        int r104 = TutorEntranceType.History.getValue();
        if (r101 != null) goto L11;
    L13:
        int r105 = TutorEntranceType.DoubaoSuggest.getValue();
        if (r101 != null) goto L17;
        return null;
    L17:
        if (r101.intValue() != r105) goto L39;
        DoubaoSuggestQueryParams r106 = r100.getDoubaoSuggestQueryParams();
        if (r106 == null) goto L21;
        String r107 = r106.getUserTextQuery();
    L22:
        if (r107 != null) goto L24;
    L25:
        r103 = true;
    L26:
        if (r103 == false) goto L38;
        return null;
    L38:
        return r107;
    L24:
        if (r107.length() != 0) goto L26;
    L21:
        r107 = null;
        goto L22
    L39:
        return null;
    L11:
        if (r101.intValue() != r104) goto L13;
    L28:
        DoubaoActionbarPageQueryParams r108 = r100.getDoubaoActionbarPageQueryParams();
        if (r108 == null) goto L31;
        r107 = r108.getUserTextQuery();
    L32:
        if (r107 != null) goto L34;
    L35:
        r103 = true;
    L36:
        if (r103 == false) goto L38;
        return null;
    L34:
        if (r107.length() != 0) goto L36;
    L31:
        r107 = null;
        goto L32
    L6:
        if (r101.intValue() == r102) goto L28;
        goto L7
    }

    public static final Image a(String r110, String r111) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L18;
        if (r111 != null) goto L12;
    L13:
        r100 = true;
    L14:
        if (r100 == false) goto L18;
        return null;
    L12:
        if (r111.length() != 0) goto L14;
    L18:
        if (r110 != null) goto L20;
        String r102 = "";
    L21:
        if (r111 != null) goto L23;
        String r103 = "";
    L25:
        return new Image(r103, r102, null, null, null, null, null, null, null, null, null, null, 4092, null);
    L23:
        r103 = r111;
        goto L25
    L20:
        r102 = r110;
        goto L21
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
