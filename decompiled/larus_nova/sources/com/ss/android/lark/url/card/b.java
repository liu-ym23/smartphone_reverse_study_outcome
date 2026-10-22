package com.ss.android.lark.url.card;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Image;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.parser.internal.z;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f444611a = null;

    static {
        f444611a = new b();
    }

    public b() {
    }

    public static RichTextElement.ImageProperty b(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r100) throws Exception {
        RichTextElement.ImageProperty r101 = new RichTextElement.ImageProperty();
        if (r100 != null) goto L5;
        List<String> r102 = new ArrayList();
    L6:
        r101.setUrls(r102);
        String r103 = "";
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setToken(r104);
        if (r100 == null) goto L17;
        Image r105 = r100.intact;
        if (r105 == null) goto L17;
        if (r105.exif_orientation.intValue() <= 0) goto L17;
        r101.setIntactKey(r105.key);
    L17:
        if (r100 != null) goto L19;
        String r106 = "";
    L20:
        r101.setOriginKey(r106);
        boolean r107 = false;
        if (r100 != null) goto L23;
        int r108 = 0;
    L24:
        r101.setOriginWidth(r108);
        if (r100 != null) goto L27;
        int r109 = 0;
    L28:
        r101.setOriginHeight(r109);
        if (r100 != null) goto L31;
        int r110 = 0;
    L32:
        r101.setCustomWidth(r110);
        if (r100 == null) goto L36;
        r107 = r100.need_copy.booleanValue();
    L36:
        r101.setNeedCopy(r107);
        ResourceCleanScene r111 = null;
        if (r100 != null) goto L39;
        com.ss.android.lark.widget.richtext.Image r112 = null;
    L40:
        r101.setMiddleImage(r112);
        if (r100 != null) goto L43;
        com.ss.android.lark.widget.richtext.Image r113 = null;
    L44:
        r101.setThumbImage(r113);
        if (r100 == null) goto L49;
        Image r114 = r100.origin;
        if (r114 == null) goto L49;
        r101.setFsUnit(r114.fs_unit);
        r101.setCrypto(r114.crypto);
    L79:
        if (r100 == null) goto L90;
        Image r115 = r100.middle_webp;
        if (r115 != null) goto L84;
    L89:
        r103 = r100.middle_key;
        goto L90
    L84:
        if (TextUtils.isEmpty(r115.key) == true) goto L89;
        Image r116 = r100.middle_webp;
        if (r116 == null) goto L88;
        r103 = r116.key;
        goto L90
    L88:
        r103 = null;
    L90:
        r101.setMiddleKey(r103);
        r101.setThumbKey(z.u(r100));
        if (r100 == null) goto L93;
        String r117 = r100.alt;
    L94:
        r101.setAlt(r117);
        if (r100 == null) goto L97;
        String r118 = r100.alt_i18n_key;
    L98:
        r101.setAltI18nKey(r118);
        if (r100 == null) goto L103;
        Boolean r119 = r100.img_can_preview;
        if (r119 == null) goto L103;
        r119.booleanValue();
        r101.setImgCanPreview(r100.img_can_preview.booleanValue());
    L103:
        if (r100 == null) goto L107;
        Boolean r120 = r100.is_origin_source;
        if (r120 == null) goto L107;
        r120.booleanValue();
        r101.setOriginSource(r100.is_origin_source.booleanValue());
    L107:
        if (r100 == null) goto L111;
        Long r121 = r100.origin_size;
        if (r121 == null) goto L111;
        r121.longValue();
        r101.setOriginSize(r100.origin_size.longValue());
    L111:
        if (r100 == null) goto L115;
        Integer r122 = r100.show_mode;
        if (r122 == null) goto L115;
        r122.intValue();
        r101.setShowMode(r100.show_mode.intValue());
    L115:
        if (r100 == null) goto L117;
        ByteString r123 = r100.inline_preview;
    L118:
        if (r123 != null) goto L120;
    L122:
        if (r100 == null) goto L126;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r124 = r100.clean_resource_scene;
        if (r124 == null) goto L126;
        ResourceCleanScene.Companion.getClass();
        r111 = ResourceCleanScene.a.a(r124);
    L126:
        r101.setResourceCleanScene(r111);
        return r101;
    L120:
        if (r100.inline_preview.size() <= 0) goto L122;
        r101.setInlinePreview(r100.inline_preview);
        goto L122
    L117:
        r123 = null;
        goto L118
    L97:
        r118 = null;
        goto L98
    L93:
        r117 = null;
    L49:
        if (r100 == null) goto L51;
        Image r125 = r100.middle_webp;
    L52:
        if (r125 == null) goto L62;
        Image r126 = r100.middle_webp;
        if (r126 == null) goto L56;
        String r127 = r126.fs_unit;
    L57:
        r101.setFsUnit(r127);
        Image r128 = r100.middle_webp;
        if (r128 == null) goto L60;
        ByteString r129 = r128.crypto;
    L61:
        r101.setCrypto(r129);
        goto L79
    L60:
        r129 = null;
        goto L61
    L56:
        r127 = null;
        goto L57
    L62:
        if (r100 == null) goto L64;
        Image r130 = r100.thumbnail_webp;
    L65:
        if (r130 == null) goto L75;
        Image r131 = r100.thumbnail_webp;
        if (r131 == null) goto L69;
        String r132 = r131.fs_unit;
    L70:
        r101.setFsUnit(r132);
        Image r133 = r100.thumbnail_webp;
        if (r133 == null) goto L73;
        ByteString r134 = r133.crypto;
    L74:
        r101.setCrypto(r134);
        goto L79
    L73:
        r134 = null;
        goto L74
    L69:
        r132 = null;
        goto L70
    L75:
        if (r100 == null) goto L77;
        String r135 = r100.fs_unit;
    L78:
        r101.setFsUnit(r135);
        goto L79
    L77:
        r135 = null;
        goto L78
    L64:
        r130 = null;
        goto L65
    L51:
        r125 = null;
        goto L52
    L43:
        r113 = a(r100.thumbnail_webp, r100.clean_resource_scene);
        goto L44
    L39:
        r112 = a(r100.middle_webp, r100.clean_resource_scene);
        goto L40
    L31:
        r110 = r100.custom_width.intValue();
        goto L32
    L27:
        r109 = r100.origin_height.intValue();
        goto L28
    L23:
        r108 = r100.origin_width.intValue();
        goto L24
    L19:
        r106 = r100.origin_key;
        goto L20
    L9:
        r104 = r100.token;
        goto L10
    L5:
        r102 = r100.urls;
        goto L6
    }

    public static com.ss.android.lark.widget.richtext.Image a(Image r100, com.bytedance.lark.pb.basic.v1.ResourceCleanScene r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.widget.richtext.Image r102 = new com.ss.android.lark.widget.richtext.Image();
        r102.setKey(r100.key);
        r102.setWidth(r100.width.intValue());
        r102.setHeight(r100.height.intValue());
        r102.setUrls(r100.urls);
        r102.setCrypto(r100.crypto);
        r102.setFsUnit(r100.fs_unit);
        ResourceCleanScene.Companion.getClass();
        r102.setResourceCleanScene(ResourceCleanScene.a.a(r101));
        if (r101 == null) goto L8;
        boolean r103 = true;
    L9:
        r102.setResourceIsCleaned(r103);
        return r102;
    L8:
        r103 = false;
        goto L9
    }
}
