package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.MarkdownImageSet;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class z {
    public static RichTextElement.AnchorProperty a(com.bytedance.lark.pb.basic.v1.RichTextElement.AnchorProperty r100) throws Exception {
        RichTextElement.AnchorProperty r101 = new RichTextElement.AnchorProperty();
        if (r100 == null) goto L16;
        r101.setHref(r100.href);
        if (TextUtils.isEmpty(r100.text_content) == false) goto L7;
        String r102 = r100.content;
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = r100.href;
    L11:
        r101.setContent(r102);
        r101.setAndroidHref(r100.android_href);
        r101.setI18nKey(r100.i18n_key);
        r101.setCustom(r100.is_custom.booleanValue());
        r101.setScene(RichTextElement.AnchorProperty.Scene.valueOf(r100.scene.getValue()));
        Boolean r103 = r100.close_card_preview;
        if (r103 == null) goto L14;
        r101.setCloseCardPreview(r103.booleanValue());
    L15:
        r101.setSpecialURL(RichTextElement.AnchorProperty.SpecialURL.valueOf(r100.special_url.getValue()));
    L17:
        return r101;
    L14:
        r101.setCloseCardPreview(false);
        goto L15
    L7:
        r102 = r100.text_content;
        goto L9
    L16:
        r101.setHref("");
        r101.setContent("");
        r101.setAndroidHref("");
        r101.setI18nKey("");
        r101.setCustom(false);
        goto L17
    }

    public static RichTextElement.AtProperty b(com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty r100) throws Exception {
        RichTextElement.AtProperty r101 = new RichTextElement.AtProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setUserId(r103);
        if (r100 == null) goto L10;
        r102 = r100.content;
    L10:
        r101.setContent(r102);
        boolean r104 = false;
        if (r100 != null) goto L13;
        boolean r105 = false;
    L14:
        r101.setOutChatUser(r105);
        if (r100 != null) goto L17;
        boolean r106 = false;
    L18:
        r101.setAnonymous(r106);
        if (r100 != null) goto L21;
    L23:
        r101.setHighLight(r104);
        return r101;
    L21:
        if (r100.is_highlight.booleanValue() == false) goto L23;
        r104 = true;
        goto L23
    L17:
        r106 = r100.is_anonymous.booleanValue();
        goto L18
    L13:
        r105 = r100.is_outer.booleanValue();
        goto L14
    L5:
        r103 = r100.user_id;
        goto L6
    }

    public static RichTextElement.ButtonProperty c(com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonProperty r100) throws Exception {
        RichTextElement.ButtonProperty r101 = new RichTextElement.ButtonProperty();
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        r101.setActionId(r102);
        boolean r103 = false;
        if (r100 != null) goto L9;
        boolean r104 = false;
    L10:
        r101.setActive(r104);
        if (r100 != null) goto L13;
        boolean r105 = true;
    L14:
        r101.setDisable(r105);
        if (r100 == null) goto L18;
        r103 = r100.is_loading.booleanValue();
    L18:
        r101.setShowLoadingIcon(r103);
        if (r100 != null) goto L21;
        String r106 = "default";
    L22:
        r101.setMode(r106);
        if (r100 == null) goto L44;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r107 = r100.confirm;
        if (r107 != null) goto L27;
    L35:
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonLoadingProperty r108 = r100.loading;
        if (r108 == null) goto L44;
        if (TextUtils.isEmpty(r108.begin) == true) goto L44;
        if (TextUtils.isEmpty(r100.loading.success) == true) goto L44;
        if (TextUtils.isEmpty(r100.loading.fail) == true) goto L44;
        RichTextElement.ButtonProperty.ButtonLoadingProperty r109 = new RichTextElement.ButtonProperty.ButtonLoadingProperty();
        r109.setBegin(r100.loading.begin);
        r109.setBeginI18NKey(r100.loading.begin_i18n_key);
        r109.setSuccess(r100.loading.success);
        r109.setSuccessI18NKey(r100.loading.success_i18n_key);
        r109.setFail(r100.loading.fail);
        r109.setFailI18NKey(r100.loading.fail_i18n_key);
        r101.setLoading(r109);
        goto L44
    L27:
        if (TextUtils.isEmpty(r107.title) == true) goto L35;
        if (TextUtils.isEmpty(r100.confirm.text) == true) goto L35;
        if (TextUtils.isEmpty(r100.confirm.confirm) == true) goto L35;
        if (TextUtils.isEmpty(r100.confirm.dismiss) == true) goto L35;
        RichTextElement.ConfirmProperty r110 = new RichTextElement.ConfirmProperty();
        r110.setTitle(r100.confirm.title);
        r110.setTitleI18NKey(r100.confirm.title_i18n_key);
        r110.setText(r100.confirm.text);
        r110.setTextI18NKey(r100.confirm.text_i18n_key);
        r110.setConfirm(r100.confirm.confirm);
        r110.setConfirmI18NKey(r100.confirm.confirm_i18n_key);
        r110.setDismiss(r100.confirm.dismiss);
        r110.setDismissI18NKey(r100.confirm.dismiss_i18n_key);
        r101.setConfirm(r110);
    L44:
        return r101;
    L21:
        r106 = r100.mode;
        goto L22
    L13:
        r105 = r100.disable.booleanValue();
        goto L14
    L9:
        r104 = r100.active.booleanValue();
        goto L10
    L5:
        r102 = r100.action_id;
        goto L6
    }

    public static RichTextElement.CodeBlockProperty d(com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty r100) {
        RichTextElement.CodeBlockProperty r101 = new RichTextElement.CodeBlockProperty();
        if (r100 != null) goto L5;
        RichTextElement.CodeBlockProperty.Language r102 = RichTextElement.CodeBlockProperty.Language.JS;
    L6:
        r101.setLanguage(r102);
        if (r100 != null) goto L9;
        String r103 = "";
    L10:
        r101.setContent(r103);
        if (r100 != null) goto L13;
    L26:
        return r101;
    L13:
        if (CollectionUtils.isNotEmpty(r100.style_refs) == false) goto L20;
        ArrayList r104 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.StyleRef> r105 = r100.style_refs.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.StyleRef r106 = r105.next();
        RichTextElement.CodeBlockProperty.StyleRef r107 = new RichTextElement.CodeBlockProperty.StyleRef();
        r107.length = r106.length.intValue();
        r107.location = r106.location.intValue();
        r107.styleIds = new ArrayList(r106.style_ids);
        r104.add(r107);
        goto L16
    L18:
        r101.setStyleRefList(r104);
    L20:
        if (CollectionUtils.isNotEmpty(r100.styles) == false) goto L26;
        ArrayList r108 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.Style> r109 = r100.styles.iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.Style r110 = r109.next();
        RichTextElement.CodeBlockProperty.Style r111 = new RichTextElement.CodeBlockProperty.Style();
        r111.type = RichTextElement.CodeBlockProperty.StyleType.forType(r110.type.getValue());
        r111.name = r110.name;
        r111.value = r110.value;
        r108.add(r111);
        goto L23
    L25:
        r101.setStyleList(r108);
        goto L26
    L9:
        r103 = r100.content;
        goto L10
    L5:
        r102 = RichTextElement.CodeBlockProperty.Language.forType(r100.language.getValue());
        goto L6
    }

    public static RichTextElement.CodeBlockV2Property e(com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property r110) {
        RichTextElement.CodeBlockV2Property r100 = new RichTextElement.CodeBlockV2Property();
        if (r110 != null) goto L5;
        RichTextElement.CodeBlockV2Property.Language r101 = RichTextElement.CodeBlockV2Property.Language.PLAIN_TEXT;
    L6:
        r100.setLanguage(r101);
        ArrayList r102 = null;
        if (r110 == null) goto L34;
        List<com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent> r103 = r110.contents;
        if (CollectionUtils.isEmpty(r103) == true) goto L34;
        ArrayList r104 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent> r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L33;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent r106 = r105.next();
        if (r106 == null) goto L14;
        LineContent r107 = new LineContent();
        if (r106.contents == null) goto L20;
        ArrayList r108 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Content> r109 = r106.contents.iterator();
    L23:
        if (r109.hasNext() == false) goto L32;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Content r111 = r109.next();
        if (r111 == null) goto L23;
        if (CollectionUtils.isNotEmpty(r111.style) == false) goto L30;
        HashMap r112 = new HashMap(r111.style);
    L31:
        LineContent.Content r113 = new LineContent.Content();
        r113.setOriginText(r111.content);
        r113.setContentType(LineContent.ContentType.fromValue(r111.type.getValue()));
        r113.setStyle(r112);
        r108.add(r113);
        goto L23
    L30:
        r112 = null;
        goto L31
    L32:
        r107.setContents(r108);
        r104.add(r107);
        goto L14
    L20:
        r104.add(r107);
        goto L14
    L33:
        r102 = r104;
    L34:
        r100.setLineContents(r102);
        int r114 = 0;
        if (r110 != null) goto L37;
    L39:
        boolean r115 = false;
    L40:
        r100.setWordWrap(r115);
        if (r110 == null) goto L44;
        r114 = r110.version.intValue();
    L44:
        r100.setVersion(r114);
        return r100;
    L37:
        if (r110.word_wrap.booleanValue() == false) goto L39;
        r115 = true;
        goto L40
    L5:
        r101 = RichTextElement.CodeBlockV2Property.Language.fromValue(r110.language.getValue());
        goto L6
    }

    public static RichTextElement.DatePickerProperty f(com.bytedance.lark.pb.basic.v1.RichTextElement.DatePickerProperty r100) throws Exception {
        RichTextElement.DatePickerProperty r101 = new RichTextElement.DatePickerProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setActionId(r103);
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setPlaceHolder(r104);
        if (r100 != null) goto L13;
        String r105 = "";
    L14:
        r101.setInitialDate(r105);
        if (r100 == null) goto L18;
        r102 = r100.place_holder_i18n_key;
    L18:
        r101.setPlaceHolderI18nKey(r102);
        boolean r106 = false;
        if (r100 != null) goto L21;
        boolean r107 = false;
    L22:
        r101.setDisable(r107);
        if (r100 == null) goto L26;
        r106 = r100.is_loading.booleanValue();
    L26:
        r101.setLoading(r106);
        if (r100 == null) goto L39;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r108 = r100.confirm;
        if (r108 == null) goto L39;
        if (TextUtils.isEmpty(r108.title) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.text) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.confirm) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.dismiss) == true) goto L39;
        RichTextElement.ConfirmProperty r109 = new RichTextElement.ConfirmProperty();
        r109.setTitle(r100.confirm.title);
        r109.setTitleI18NKey(r100.confirm.title_i18n_key);
        r109.setText(r100.confirm.text);
        r109.setTextI18NKey(r100.confirm.text_i18n_key);
        r109.setConfirm(r100.confirm.confirm);
        r109.setConfirmI18NKey(r100.confirm.confirm_i18n_key);
        r109.setDismiss(r100.confirm.dismiss);
        r109.setDismissI18NKey(r100.confirm.dismiss_i18n_key);
        r101.setConfirm(r109);
    L39:
        return r101;
    L21:
        r107 = r100.disable.booleanValue();
        goto L22
    L13:
        r105 = r100.initial_date;
        goto L14
    L9:
        r104 = r100.place_holder;
        goto L10
    L5:
        r103 = r100.action_id;
        goto L6
    }

    public static RichTextElement.DateTimePickerProperty g(com.bytedance.lark.pb.basic.v1.RichTextElement.DatetimePickerProperty r100) throws Exception {
        RichTextElement.DateTimePickerProperty r101 = new RichTextElement.DateTimePickerProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setActionId(r103);
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setPlaceHolder(r104);
        if (r100 != null) goto L13;
        String r105 = "";
    L14:
        r101.setInitialDateTime(r105);
        if (r100 == null) goto L18;
        r102 = r100.place_holder_i18n_key;
    L18:
        r101.setPlaceHolderI18nKey(r102);
        boolean r106 = false;
        if (r100 != null) goto L21;
        boolean r107 = false;
    L22:
        r101.setDisable(r107);
        if (r100 == null) goto L26;
        r106 = r100.is_loading.booleanValue();
    L26:
        r101.setLoading(r106);
        if (r100 == null) goto L39;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r108 = r100.confirm;
        if (r108 == null) goto L39;
        if (TextUtils.isEmpty(r108.title) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.text) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.confirm) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.dismiss) == true) goto L39;
        RichTextElement.ConfirmProperty r109 = new RichTextElement.ConfirmProperty();
        r109.setTitle(r100.confirm.title);
        r109.setTitleI18NKey(r100.confirm.title_i18n_key);
        r109.setText(r100.confirm.text);
        r109.setTextI18NKey(r100.confirm.text_i18n_key);
        r109.setConfirm(r100.confirm.confirm);
        r109.setConfirmI18NKey(r100.confirm.confirm_i18n_key);
        r109.setDismiss(r100.confirm.dismiss);
        r109.setDismissI18NKey(r100.confirm.dismiss_i18n_key);
        r101.setConfirm(r109);
    L39:
        return r101;
    L21:
        r107 = r100.disable.booleanValue();
        goto L22
    L13:
        r105 = r100.initial_datetime;
        goto L14
    L9:
        r104 = r100.place_holder;
        goto L10
    L5:
        r103 = r100.action_id;
        goto L6
    }

    public static Image h(com.bytedance.lark.pb.basic.v1.Image r100) {
        Image r101 = new Image();
        if (r100 != null) goto L5;
        return r101;
    L5:
        r101.setKey(r100.key);
        if (r100.exif_orientation.intValue() < 5) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        Integer r103 = r100.height;
    L12:
        r101.setWidth(r103.intValue());
        if (r102 == false) goto L15;
        Integer r104 = r100.width;
    L16:
        r101.setHeight(r104.intValue());
        r101.setUrls(new ArrayList(r100.urls));
        r101.setType(Image.Type.forNumber(r100.type.getValue()));
        r101.setCrypto(r100.crypto);
        r101.setFsUnit(r100.fs_unit);
        return r101;
    L15:
        r104 = r100.height;
        goto L16
    L11:
        r103 = r100.width;
        goto L12
    L8:
        r102 = false;
        goto L9
    }

    public static RichTextElement.ImageProperty j(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r100) throws Exception {
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
        com.bytedance.lark.pb.basic.v1.Image r105 = r100.intact;
        if (r105 == null) goto L17;
        if (r105.exif_orientation.intValue() <= 0) goto L17;
        r101.setIntactKey(r100.intact.key);
    L17:
        if (r100 == null) goto L20;
        r103 = r100.origin_key;
    L20:
        r101.setOriginKey(r103);
        boolean r106 = false;
        if (r100 != null) goto L23;
        int r107 = 0;
    L24:
        r101.setOriginWidth(r107);
        if (r100 != null) goto L27;
        int r108 = 0;
    L28:
        r101.setOriginHeight(r108);
        if (r100 != null) goto L31;
        int r109 = 0;
    L32:
        r101.setCustomWidth(r109);
        if (r100 != null) goto L35;
    L37:
        r101.setNeedCopy(r106);
        com.ss.android.lark.widget.richtext.Image r110 = null;
        if (r100 != null) goto L40;
        ResourceCleanScene r111 = null;
    L41:
        r101.setResourceCleanScene(r111);
        if (r100 != null) goto L44;
        com.ss.android.lark.widget.richtext.Image r112 = null;
    L45:
        r101.setMiddleImage(r112);
        if (r100 == null) goto L49;
        r110 = i(r100.thumbnail_webp, r100.clean_resource_scene);
    L49:
        r101.setThumbImage(r110);
        com.bytedance.lark.pb.basic.v1.Image r113 = r100.origin;
        if (r113 == null) goto L53;
        r101.setFsUnit(r113.fs_unit);
        r101.setCrypto(r100.origin.crypto);
    L59:
        com.bytedance.lark.pb.basic.v1.Image r114 = r100.middle_webp;
        if (r114 != null) goto L62;
    L64:
        String r115 = r100.middle_key;
    L65:
        r101.setMiddleKey(r115);
        r101.setThumbKey(u(r100));
        r101.setAlt(r100.alt);
        r101.setAltI18nKey(r100.alt_i18n_key);
        r101.setImgCanPreview(r100.img_can_preview.booleanValue());
        r101.setOriginSource(r100.is_origin_source.booleanValue());
        r101.setOriginSize(r100.origin_size.longValue());
        r101.setShowMode(r100.show_mode.intValue());
        r101.setWidth(r100.width.intValue());
        r101.setHeight(r100.height.intValue());
        ByteString r116 = r100.inline_preview;
        if (r116 != null) goto L68;
    L70:
        return r101;
    L68:
        if (r116.size() <= 0) goto L70;
        r101.setInlinePreview(r100.inline_preview);
        goto L70
    L62:
        if (TextUtils.isEmpty(r114.key) == true) goto L64;
        r115 = r100.middle_webp.key;
        goto L65
    L53:
        if (r101.getMiddleImage() == null) goto L56;
        r101.setFsUnit(r101.getMiddleImage().getFsUnit());
        r101.setCrypto(r101.getMiddleImage().getCrypto());
        goto L59
    L56:
        if (r101.getThumbImage() == null) goto L58;
        r101.setFsUnit(r101.getThumbImage().getFsUnit());
        r101.setCrypto(r101.getThumbImage().getCrypto());
        goto L59
    L58:
        r101.setFsUnit(r100.fs_unit);
        goto L59
    L44:
        r112 = i(r100.middle_webp, r100.clean_resource_scene);
        goto L45
    L40:
        ResourceCleanScene.a r117 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r118 = r100.clean_resource_scene;
        r117.getClass();
        r111 = ResourceCleanScene.a.a(r118);
        goto L41
    L35:
        if (r100.need_copy.booleanValue() == false) goto L37;
        r106 = true;
        goto L37
    L31:
        r109 = r100.custom_width.intValue();
        goto L32
    L27:
        r108 = r100.origin_height.intValue();
        goto L28
    L23:
        r107 = r100.origin_width.intValue();
        goto L24
    L9:
        r104 = r100.token;
        goto L10
    L5:
        r102 = r100.urls;
        goto L6
    }

    public static RichTextElement.MarkdownProperty k(com.bytedance.lark.pb.basic.v1.RichTextElement.MarkdownProperty r100) {
        RichTextElement.MarkdownProperty r101 = new RichTextElement.MarkdownProperty();
        String r102 = "";
        if (r100 != null) goto L6;
        r101.setContent("");
        return r101;
    L6:
        String r103 = r100.content;
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        r101.setContent(r102);
        Map<String, ImageSetV2> r104 = r100.images;
        HashMap r105 = null;
        if (CollectionUtils.isEmpty(r104) == false) goto L13;
        HashMap r106 = null;
    L20:
        r101.setImages(r106);
        r101.setAtUserIds(r100.at_user_ids);
        r101.setAtAll(Boolean.TRUE.equals(r100.is_at_all));
        Map<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty> r107 = r100.at_users;
        if (CollectionUtils.isEmpty(r107) == true) goto L31;
        r105 = new HashMap(r107.size());
        Iterator<Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty>> r108 = r107.entrySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L31;
        Map.Entry<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty> r109 = r108.next();
        r105.put(r109.getKey(), b(r109.getValue()));     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e("ModelParserRichTextProperty", "parse markdown at user failed: " + e.getMessage(), e);
    L31:
        r101.setAtUsers(r105);
        return r101;
    L13:
        r106 = new HashMap(r104.size());
        Iterator<Map.Entry<String, ImageSetV2>> r110 = r104.entrySet().iterator();
    L15:
        if (r110.hasNext() == false) goto L20;
        Map.Entry<String, ImageSetV2> r111 = r110.next();
        MarkdownImageSet r112 = MarkdownImageSet.fromImageSetV2(r111.getValue());
        if (r112 == null) goto L15;
        r106.put(r111.getKey(), r112);
        goto L15
    }

    public static RichTextElement.MediaProperty l(com.bytedance.lark.pb.basic.v1.RichTextElement.MediaProperty r100) throws Exception {
        RichTextElement.MediaProperty r101 = new RichTextElement.MediaProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setKey(r103);
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setName(r104);
        if (r100 != null) goto L13;
        long r105 = 0;
    L14:
        r101.setSize(r105);
        if (r100 != null) goto L17;
        String r106 = "";
    L18:
        r101.setMime(r106);
        if (r100 != null) goto L21;
        String r107 = "";
    L22:
        r101.setCryptoToken(r107);
        if (r100 != null) goto L25;
        RichTextElement.MediaProperty.Source r108 = RichTextElement.MediaProperty.Source.UNKNOWN;
    L26:
        r101.setSource(r108);
        ResourceCleanScene r109 = null;
        if (r100 == null) goto L32;
        ImageSet r110 = r100.image;
        if (r110 == null) goto L32;
        com.ss.android.lark.widget.richtext.Image r111 = i(r110.origin, r100.clean_resource_scene);
    L33:
        r101.setOriginImage(r111);
        boolean r112 = true;
        int r113 = 0;
        if (r100 == null) goto L49;
        ImageSet r114 = r100.image;
        if (r114 == null) goto L49;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r115 = r100.clean_resource_scene;
        com.bytedance.lark.pb.basic.v1.Image r116 = r114.thumbnail_webp;
        if (r116 != null) goto L41;
    L43:
        Image r117 = h(r114.thumbnail);
    L44:
        com.ss.android.lark.widget.richtext.Image r118 = new com.ss.android.lark.widget.richtext.Image();
        r118.setKey(r117.getKey());
        r118.setWidth(r117.getWidth());
        r118.setHeight(r117.getHeight());
        r118.setUrls(r117.getUrls());
        r118.setCrypto(r117.getCrypto());
        r118.setFsUnit(r117.getFsUnit());
        if (r115 == null) goto L47;
        boolean r119 = true;
    L48:
        r118.setResourceIsCleaned(r119);
        ResourceCleanScene.Companion.getClass();
        r118.setResourceCleanScene(ResourceCleanScene.a.a(r115));
    L50:
        r101.setThumbImage(r118);
        if (r101.getOriginImage() == null) goto L54;
        r101.setFsUnit(r101.getOriginImage().getFsUnit());
        r101.setCrypto(r101.getOriginImage().getCrypto());
    L60:
        if (r100 != null) goto L62;
        int r120 = 0;
    L63:
        r101.setDuration(r120);
        if (r100 != null) goto L66;
        String r121 = "";
    L67:
        r101.setUrl(r121);
        if (r100 != null) goto L70;
        String r122 = "";
    L71:
        r101.setCompressPath(r122);
        if (r100 != null) goto L74;
        String r123 = "";
    L75:
        r101.setOriginPath(r123);
        if (r100 == null) goto L81;
        ImageSet r124 = r100.image;
        if (r124 == null) goto L81;
        String r125 = r124.key;
    L82:
        r101.setImageSetKey(r125);
        if (r100 == null) goto L88;
        String r126 = r100.image_path;
        if (r126 == null) goto L88;
        r102 = r126;
    L88:
        r101.setCoverPath(r102);
        if (r100 != null) goto L91;
    L95:
        r112 = false;
    L96:
        r101.setNeedCopy(r112);
        if (r100 == null) goto L100;
        ResourceCleanScene.a r127 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r128 = r100.clean_resource_scene;
        r127.getClass();
        r109 = ResourceCleanScene.a.a(r128);
    L100:
        r101.setResourceCleanScene(r109);
        if (r100 != null) goto L103;
        int r129 = 0;
    L104:
        r101.setWidth(r129);
        if (r100 == null) goto L108;
        r113 = r100.height.intValue();
    L108:
        r101.setHeight(r113);
        return r101;
    L103:
        r129 = r100.width.intValue();
        goto L104
    L91:
        if (r100.need_copy_img.booleanValue() == false) goto L95;
        if (r100.need_copy_media.booleanValue() == false) goto L95;
    L81:
        r125 = "";
        goto L82
    L74:
        r123 = r100.origin_path;
        goto L75
    L70:
        r122 = r100.compress_path;
        goto L71
    L66:
        r121 = r100.url;
        goto L67
    L62:
        r120 = r100.duration.intValue();
        goto L63
    L54:
        if (r101.getThumbImage() == null) goto L56;
        r101.setFsUnit(r101.getThumbImage().getFsUnit());
        r101.setCrypto(r101.getThumbImage().getCrypto());
        goto L60
    L56:
        if (r100 != null) goto L58;
        String r130 = "";
    L59:
        r101.setFsUnit(r130);
        Log.i("ModelParserRichTextProperty", "there is no origin or thumbnail, fsUnit " + r101.getFsUnit());
        goto L60
    L58:
        r130 = r100.fs_unit;
        goto L59
    L47:
        r119 = false;
        goto L48
    L41:
        if (TextUtils.isEmpty(r116.key) == true) goto L43;
        r117 = h(r114.thumbnail_webp);
    L49:
        r118 = null;
    L32:
        r111 = null;
        goto L33
    L25:
        r108 = RichTextElement.MediaProperty.Source.forNumber(r100.source.getValue());
        goto L26
    L21:
        r107 = r100.crypto_token;
        goto L22
    L17:
        r106 = r100.mime;
        goto L18
    L13:
        r105 = r100.size.longValue();
        goto L14
    L9:
        r104 = r100.name;
        goto L10
    L5:
        r103 = r100.key;
        goto L6
    }

    public static RichTextElement.MentionProperty m(com.bytedance.lark.pb.basic.v1.RichTextElement.MentionProperty r100) {
        RichTextElement.MentionProperty r101 = new RichTextElement.MentionProperty();
        if (r100 == null) goto L5;
        String r102 = r100.content;
    L6:
        r101.setContent(r102);
        RichTextElement.MentionItem r103 = new RichTextElement.MentionItem();
        if (r100 == null) goto L11;
        com.bytedance.lark.pb.basic.v1.RichTextElement.MentionItem r104 = r100.item;
        if (r104 == null) goto L11;
        r103.setId(r104.f253541id);
        r103.setType(RichTextElement.MentionItem.MentionType.valueOf(r100.item.type.getValue()));
    L11:
        r101.setMentionItem(r103);
        return r101;
    L5:
        r102 = "";
        goto L6
    }

    public static RichTextElement.MyAIToolProperty n(com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty r100) {
        RichTextElement.MyAIToolProperty r101 = new RichTextElement.MyAIToolProperty();
        if (r100 != null) goto L5;
        RichTextElement.MyAIToolProperty.Status r102 = RichTextElement.MyAIToolProperty.Status.FAILED;
    L6:
        r101.setStatus(r102);
        com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Icon r103 = null;
        if (r100 != null) goto L9;
        String r104 = null;
    L10:
        r101.setTool_id(r104);
        if (r100 != null) goto L13;
        String r105 = null;
    L14:
        r101.setTool_runtime_id(r105);
        if (r100 != null) goto L17;
        Map<String, String> r106 = null;
    L18:
        r101.setI18n_name(r106);
        if (r100 != null) goto L21;
        String r107 = null;
    L22:
        r101.setText(r107);
        if (r100 == null) goto L26;
        r103 = r100.icon;
    L26:
        r101.setIcon(r103);
        return r101;
    L21:
        r107 = r100.text;
        goto L22
    L17:
        r106 = r100.i18n_name;
        goto L18
    L13:
        r105 = r100.tool_runtime_id;
        goto L14
    L9:
        r104 = r100.tool_id;
        goto L10
    L5:
        r102 = RichTextElement.MyAIToolProperty.Status.fromValue(r100.status.getValue());
        goto L6
    }

    public static RichTextElement.OverflowMenuProperty o(com.bytedance.lark.pb.basic.v1.RichTextElement.OverflowMenuProperty r100) throws Exception {
        RichTextElement.OverflowMenuProperty r101 = new RichTextElement.OverflowMenuProperty();
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        r101.setActionId(r102);
        boolean r103 = false;
        if (r100 != null) goto L9;
        boolean r104 = false;
    L10:
        r101.setDisable(r104);
        if (r100 == null) goto L14;
        r103 = r100.is_loading.booleanValue();
    L14:
        r101.setLoading(r103);
        if (r100 == null) goto L36;
        List<com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption> r105 = r100.options;
        if (r105 != null) goto L19;
    L25:
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r106 = r100.confirm;
        if (r106 == null) goto L36;
        if (TextUtils.isEmpty(r106.title) == true) goto L36;
        if (TextUtils.isEmpty(r100.confirm.text) == true) goto L36;
        if (TextUtils.isEmpty(r100.confirm.confirm) == true) goto L36;
        if (TextUtils.isEmpty(r100.confirm.dismiss) == true) goto L36;
        RichTextElement.ConfirmProperty r107 = new RichTextElement.ConfirmProperty();
        r107.setTitle(r100.confirm.title);
        r107.setTitleI18NKey(r100.confirm.title_i18n_key);
        r107.setText(r100.confirm.text);
        r107.setTextI18NKey(r100.confirm.text_i18n_key);
        r107.setConfirm(r100.confirm.confirm);
        r107.setConfirmI18NKey(r100.confirm.confirm_i18n_key);
        r107.setDismiss(r100.confirm.dismiss);
        r107.setDismissI18NKey(r100.confirm.dismiss_i18n_key);
        r101.setConfirm(r107);
        goto L36
    L19:
        if (r105.size() <= 0) goto L25;
        ArrayList r108 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption> r109 = r100.options.iterator();
    L22:
        if (r109.hasNext() == false) goto L24;
        com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption r110 = r109.next();
        RichTextElement.MenuOption r111 = new RichTextElement.MenuOption();
        r111.setText(r110.text);
        r111.setI18Key(r110.text_i18n_key);
        r111.setValue(r110.value);
        r111.setOptionActionId(r110.option_action_id);
        r108.add(r111);
        goto L22
    L24:
        r101.setOptions(r108);
    L36:
        return r101;
    L9:
        r104 = r100.disable.booleanValue();
        goto L10
    L5:
        r102 = r100.action_id;
        goto L6
    }

    public static RichTextElement.ProgressSelectOptionProperty p(com.bytedance.lark.pb.basic.v1.RichTextElement.ProgressSelectOptionProperty r100) throws Exception {
        RichTextElement.ProgressSelectOptionProperty r101 = new RichTextElement.ProgressSelectOptionProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setActionId(r103);
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setActionParamName(r104);
        if (r100 != null) goto L13;
        String r105 = "";
    L14:
        r101.setActionParamValue(r105);
        int r106 = 0;
        if (r100 != null) goto L17;
        boolean r107 = false;
    L18:
        r101.setDisable(r107);
        if (r100 != null) goto L21;
        boolean r108 = false;
    L22:
        r101.setSelected(r108);
        if (r100 != null) goto L25;
        String r109 = "";
    L26:
        r101.setOptionCase(r109);
        if (r100 == null) goto L30;
        r102 = r100.content;
    L30:
        r101.setContent(r102);
        if (r100 != null) goto L33;
        int r110 = 0;
    L34:
        r101.setNumberOfSelected(r110);
        if (r100 == null) goto L38;
        r106 = r100.number_of_total.intValue();
    L38:
        r101.setNumberOfTotal(r106);
        return r101;
    L33:
        r110 = r100.number_of_selected.intValue();
        goto L34
    L25:
        r109 = r100.option_case;
        goto L26
    L21:
        r108 = r100.selected.booleanValue();
        goto L22
    L17:
        r107 = r100.disable.booleanValue();
        goto L18
    L13:
        r105 = r100.action_param_value;
        goto L14
    L9:
        r104 = r100.action_param_name;
        goto L10
    L5:
        r103 = r100.action_id;
        goto L6
    }

    public static RichTextElement.SelectMenuProperty q(com.bytedance.lark.pb.basic.v1.RichTextElement.SelectMenuProperty r100) throws Exception {
        RichTextElement.SelectMenuProperty r101 = new RichTextElement.SelectMenuProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setActionId(r103);
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setPlaceHolder(r104);
        if (r100 != null) goto L13;
        RichTextElement.SelectMenuProperty.Type r105 = RichTextElement.SelectMenuProperty.Type.UNKNOWN;
    L14:
        r101.setType(r105);
        if (r100 != null) goto L17;
        String r106 = "";
    L18:
        r101.setPlaceHolderI18nKey(r106);
        if (r100 == null) goto L22;
        r102 = r100.initial_option;
    L22:
        r101.setInitialOption(r102);
        boolean r107 = false;
        if (r100 != null) goto L25;
        boolean r108 = false;
    L26:
        r101.setDisable(r108);
        if (r100 == null) goto L30;
        r107 = r100.is_loading.booleanValue();
    L30:
        r101.setLoading(r107);
        if (r100 == null) goto L52;
        List<com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption> r109 = r100.options;
        if (r109 != null) goto L35;
    L41:
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r110 = r100.confirm;
        if (r110 == null) goto L52;
        if (TextUtils.isEmpty(r110.title) == true) goto L52;
        if (TextUtils.isEmpty(r100.confirm.text) == true) goto L52;
        if (TextUtils.isEmpty(r100.confirm.confirm) == true) goto L52;
        if (TextUtils.isEmpty(r100.confirm.dismiss) == true) goto L52;
        RichTextElement.ConfirmProperty r111 = new RichTextElement.ConfirmProperty();
        r111.setTitle(r100.confirm.title);
        r111.setTitleI18NKey(r100.confirm.title_i18n_key);
        r111.setText(r100.confirm.text);
        r111.setTextI18NKey(r100.confirm.text_i18n_key);
        r111.setConfirm(r100.confirm.confirm);
        r111.setConfirmI18NKey(r100.confirm.confirm_i18n_key);
        r111.setDismiss(r100.confirm.dismiss);
        r111.setDismissI18NKey(r100.confirm.dismiss_i18n_key);
        r101.setConfirm(r111);
        goto L52
    L35:
        if (r109.size() <= 0) goto L41;
        ArrayList r112 = new ArrayList();
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption> r113 = r100.options.iterator();
    L38:
        if (r113.hasNext() == false) goto L40;
        com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption r114 = r113.next();
        RichTextElement.MenuOption r115 = new RichTextElement.MenuOption();
        r115.setText(r114.text);
        r115.setI18Key(r114.text_i18n_key);
        r115.setValue(r114.value);
        r112.add(r115);
        goto L38
    L40:
        r101.setOptions(r112);
    L52:
        return r101;
    L25:
        r108 = r100.disable.booleanValue();
        goto L26
    L17:
        r106 = r100.place_holder_i18n_key;
        goto L18
    L13:
        r105 = RichTextElement.SelectMenuProperty.Type.forType(r100.type.getValue());
        goto L14
    L9:
        r104 = r100.place_holder;
        goto L10
    L5:
        r103 = r100.action_id;
        goto L6
    }

    public static RichTextElement.TableCellProperty r(com.bytedance.lark.pb.basic.v1.RichTextElement.TableCellProperty r100) {
        RichTextElement.TableCellProperty r101 = new RichTextElement.TableCellProperty();
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        int r103 = 1;
    L9:
        r101.setColumnSpan(r103);
        if (r100 != null) goto L12;
    L15:
        int r104 = 1;
    L16:
        r101.setRowSpan(r104);
        if (r100 != null) goto L19;
        HorizontalAlign r105 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
    L20:
        r101.setHorizontalAlign(r105);
        if (r100 != null) goto L23;
        VerticalAlign r106 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L24:
        r101.setVerticalAlign(r106);
        if (r100 != null) goto L27;
    L29:
        r102 = false;
    L30:
        r101.setMerged(r102);
        return r101;
    L27:
        if (r100.is_merged.booleanValue() == false) goto L29;
    L23:
        r106 = VerticalAlign.fromValue(r100.vertical_align.getValue());
        goto L24
    L19:
        r105 = HorizontalAlign.fromValue(r100.horizontal_align.getValue());
        goto L20
    L12:
        if (r100.rowspan.intValue() <= 0) goto L15;
        r104 = r100.rowspan.intValue();
        goto L16
    L5:
        if (r100.colspan.intValue() <= 0) goto L8;
        r103 = r100.colspan.intValue();
        goto L9
    }

    public static RichTextElement.TableProperty s(com.bytedance.lark.pb.basic.v1.RichTextElement.TableProperty r100) {
        RichTextElement.TableProperty r101 = new RichTextElement.TableProperty();
        LinkedList<Column> r102 = new LinkedList();
        if (r100 != null) goto L5;
    L14:
        r101.setColumns(r102);
        return r101;
    L5:
        if (CollectionUtils.isEmpty(r100.columns) == true) goto L14;
        Iterator<com.bytedance.lark.pb.basic.v1.RichTextElement.TableProperty.Column> r103 = r100.columns.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        com.bytedance.lark.pb.basic.v1.RichTextElement.TableProperty.Column r104 = r103.next();
        if (r104.width.intValue() > 0) goto L12;
        int r105 = 100;
    L13:
        r102.add(new Column(Integer.valueOf(r105), HorizontalAlign.fromValue(r104.horizontal_align.getValue()), VerticalAlign.fromValue(r104.vertical_align.getValue()), r104.is_header.booleanValue()));
        goto L8
    L12:
        r105 = r104.width.intValue();
        goto L13
    }

    public static RichTextElement.TableRowProperty t(com.bytedance.lark.pb.basic.v1.RichTextElement.TableRowProperty r100) {
        RichTextElement.TableRowProperty r101 = new RichTextElement.TableRowProperty();
        if (r100 != null) goto L5;
        HorizontalAlign r102 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
    L6:
        r101.setHorizontalAlign(r102);
        if (r100 != null) goto L9;
        VerticalAlign r103 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L10:
        r101.setVerticalAlign(r103);
        if (r100 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        r101.setHeader(r104);
        return r101;
    L13:
        if (r100.is_header.booleanValue() == false) goto L15;
        r104 = true;
        goto L16
    L9:
        r103 = VerticalAlign.fromValue(r100.vertical_align.getValue());
        goto L10
    L5:
        r102 = HorizontalAlign.fromValue(r100.horizontal_align.getValue());
        goto L6
    }

    public static String u(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        com.bytedance.lark.pb.basic.v1.Image r101 = r100.thumbnail_webp;
        if (r101 == null) goto L12;
        if (TextUtils.isEmpty(r101.key) == true) goto L12;
        return r100.thumbnail_webp.key;
    L12:
        return r100.thumb_key;
    }

    public static RichTextElement.TimePickerProperty v(com.bytedance.lark.pb.basic.v1.RichTextElement.TimePickerProperty r100) throws Exception {
        RichTextElement.TimePickerProperty r101 = new RichTextElement.TimePickerProperty();
        String r102 = "";
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r101.setActionId(r103);
        if (r100 != null) goto L9;
        String r104 = "";
    L10:
        r101.setPlaceHolder(r104);
        if (r100 != null) goto L13;
        String r105 = "";
    L14:
        r101.setInitialTime(r105);
        if (r100 == null) goto L18;
        r102 = r100.place_holder_i18n_key;
    L18:
        r101.setPlaceHolderI18nKey(r102);
        boolean r106 = false;
        if (r100 != null) goto L21;
        boolean r107 = false;
    L22:
        r101.setDisable(r107);
        if (r100 == null) goto L26;
        r106 = r100.is_loading.booleanValue();
    L26:
        r101.setLoading(r106);
        if (r100 == null) goto L39;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r108 = r100.confirm;
        if (r108 == null) goto L39;
        if (TextUtils.isEmpty(r108.title) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.text) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.confirm) == true) goto L39;
        if (TextUtils.isEmpty(r100.confirm.dismiss) == true) goto L39;
        RichTextElement.ConfirmProperty r109 = new RichTextElement.ConfirmProperty();
        r109.setTitle(r100.confirm.title);
        r109.setTitleI18NKey(r100.confirm.title_i18n_key);
        r109.setText(r100.confirm.text);
        r109.setTextI18NKey(r100.confirm.text_i18n_key);
        r109.setConfirm(r100.confirm.confirm);
        r109.setConfirmI18NKey(r100.confirm.confirm_i18n_key);
        r109.setDismiss(r100.confirm.dismiss);
        r109.setDismissI18NKey(r100.confirm.dismiss_i18n_key);
        r101.setConfirm(r109);
    L39:
        return r101;
    L21:
        r107 = r100.disable.booleanValue();
        goto L22
    L13:
        r105 = r100.initial_time;
        goto L14
    L9:
        r104 = r100.place_holder;
        goto L10
    L5:
        r103 = r100.action_id;
        goto L6
    }

    public static com.ss.android.lark.widget.richtext.Image i(com.bytedance.lark.pb.basic.v1.Image r100, com.bytedance.lark.pb.basic.v1.ResourceCleanScene r101) {
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
        if (r101 == null) goto L8;
        boolean r103 = true;
    L9:
        r102.setResourceIsCleaned(r103);
        ResourceCleanScene.Companion.getClass();
        r102.setResourceCleanScene(ResourceCleanScene.a.a(r101));
        return r102;
    L8:
        r103 = false;
        goto L9
    }
}
