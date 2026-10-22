package fnb;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.ThemeColor;
import com.bytedance.lark.pb.basic.v1.UDIcon;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.URLPreviewBody;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.bytedance.lark.pb.basic.v1.URLPreviewComponents;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.DriveFileType;
import com.ss.android.lark.chat.preview.service.d;
import com.ss.android.lark.chat.preview.service.impl.UrlPreviewService;
import com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.utils.FileType;
import dagger.Lazy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w4b.f;
import wxa.e;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy<UrlPreviewService> f478060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy<d> f478061b;

    @Override // w4b.f
    public final void b() {
    }

    @Override // w4b.f
    public final xcb.a c(Map<String, e> r210) {
        Intrinsics.checkNotNullParameter(r210, "driveFiles");
        int r100 = vhb.a.f554991a;
        Intrinsics.checkNotNullParameter(r210, "driveFiles");
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, e>> r103 = r210.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L76;
        Map.Entry<String, e> r104 = r103.next();
        String r105 = r104.getKey();
        e r106 = r104.getValue();
        String r107 = "flow-drive-" + UUID.randomUUID();
        UrlPreviewHangPoint.Builder r108 = new UrlPreviewHangPoint.Builder();
        String r109 = r106.f561859e;
        if (r109 != null) goto L8;
        r109 = "";
    L8:
        UrlPreviewHangPoint.Builder r110 = r108.url(r109).preview_id(r107);
        Boolean r111 = Boolean.TRUE;
        UrlPreviewHangPoint.Builder r112 = r110.need_local_preview(r111);
        Boolean r113 = Boolean.FALSE;
        r101.put(r105, r112.is_lazy_load(r113).send_scene(UrlPreviewHangPoint.SendScene.DOUBAO_CLOUD_DRIVE_CHOOSE).build());
        int r114 = vhb.a.f554991a;
        UrlPreviewEntity.Builder r115 = new UrlPreviewEntity.Builder().source_id(UUID.randomUUID().toString()).preview_id(r107).is_sdk_preview(r113);
        URL.Builder r116 = new URL.Builder();
        String r117 = r106.f561859e;
        if (r117 != null) goto L11;
        r117 = "";
    L11:
        UrlPreviewEntity.Builder r118 = r115.url(r116.url(r117).build()).version(0);
        boolean r119 = Intrinsics.areEqual(r106.getType(), DriveFileType.IMAGE.getValue());
        Float r120 = Float.valueOf(100.0f);
        if (r119 == false) goto L14;
        LinkedHashMap r121 = new LinkedHashMap();
        r121.put(RootDescription.ROOT_ELEMENT, new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.EMPTY).can_skip_when_unknown(r111).is_font_zoomable(r111).style(new URLPreviewComponent.Style.Builder().background_color(vhb.a.a()).width(new URLPreviewComponent.Value(URLPreviewComponent.ValueType.PERCENTAGE, r120)).aspect_ratio(1).build()).child_ids(CollectionsKt.listOf("docImage")).empty(new URLPreviewComponent.EmptyProperty.Builder().build()).build());
        r121.put("docImage", new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.DOC_IMAGE).can_skip_when_unknown(r111).is_font_zoomable(r111).doc_image(new URLPreviewComponent.DocImageProperty.Builder().build()).build());
        URLPreviewBody r122 = new URLPreviewBody.Builder().components(new URLPreviewComponents.Builder().root_ids(CollectionsKt.listOf(RootDescription.ROOT_ELEMENT)).elements(r121).build()).build();
    L74:
        LinkedHashMap r123 = r102;
        r123.put(r107, r118.preview_body(r122).ext_info(new UrlPreviewEntity.ExtInfo.Builder().doc_info(new UrlPreviewEntity.DocInfo.Builder().file_token(r106.f561860f).file_name(r106.f561857c).build()).build()).build());
        r102 = r123;
        r103 = r103;
        r101 = r101;
        goto L4
    L14:
        LinkedHashMap r124 = new LinkedHashMap();
        r124.put(RootDescription.ROOT_ELEMENT, new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.EMPTY).can_skip_when_unknown(r111).is_font_zoomable(r111).style(new URLPreviewComponent.Style.Builder().background_color(vhb.a.a()).width(new URLPreviewComponent.Value(URLPreviewComponent.ValueType.PERCENTAGE, r120)).build()).child_ids(CollectionsKt.listOf("rootLayout")).empty(new URLPreviewComponent.EmptyProperty.Builder().build()).build());
        URLPreviewComponent.Builder r125 = new URLPreviewComponent.Builder();
        URLPreviewComponent.Type r126 = URLPreviewComponent.Type.LINEAR_LAYOUT;
        URLPreviewComponent.Builder r127 = r125.type(r126).can_skip_when_unknown(r111).is_font_zoomable(r111).child_ids(CollectionsKt.listOf(new String[]{"title", "bottomLayout"}));
        URLPreviewComponent.LinearLayoutProperty.Builder r128 = new URLPreviewComponent.LinearLayoutProperty.Builder().orientation(URLPreviewComponent.Orientation.COLUMN);
        Float r129 = Float.valueOf(12.0f);
        r124.put("rootLayout", r127.linear_layout(r128.spacing(r129).padding(r129).cross_axis_align(URLPreviewComponent.Align.STRETCH).build()).build());
        URLPreviewComponent.Builder r130 = new URLPreviewComponent.Builder();
        URLPreviewComponent.Type r131 = URLPreviewComponent.Type.TEXT;
        URLPreviewComponent.Builder r132 = r130.type(r131).can_skip_when_unknown(r111).is_font_zoomable(r111).style(new URLPreviewComponent.Style.Builder().font_level(new URLPreviewComponent.FontLevel.Builder().type(URLPreviewComponent.FontType.TITLE).level(1).build()).text_color_v2(new ThemeColor.Builder().token("text_title").build()).build());
        URLPreviewComponent.TextProperty.Builder r133 = new URLPreviewComponent.TextProperty.Builder();
        String r134 = FileUtils.n(r106.f561857c);
        if (r134 != null) goto L17;
        r134 = "";
    L17:
        r124.put("title", r132.text(r133.text(r134).number_of_lines(2).build()).build());
        r124.put("bottomLayout", new URLPreviewComponent.Builder().type(r126).can_skip_when_unknown(r111).is_font_zoomable(r111).child_ids(CollectionsKt.listOf(new String[]{"icon", "typeText"})).linear_layout(new URLPreviewComponent.LinearLayoutProperty.Builder().orientation(URLPreviewComponent.Orientation.ROW).spacing(Float.valueOf(6.0f)).cross_axis_align(URLPreviewComponent.Align.MIDDLE).build()).build());
        String r135 = r106.getType();
        if (r135 != null) goto L20;
        r135 = "";
    L20:
        boolean r136 = true;
        if (StringsKt.equals(r135, "ai_doc", true) == false) goto L24;
        String r137 = "file-ai_doc";
    L64:
        URLPreviewComponent.Builder r138 = new URLPreviewComponent.Builder().type(URLPreviewComponent.Type.IMAGE).can_skip_when_unknown(r111).is_font_zoomable(r111);
        URLPreviewComponent.Style.Builder r139 = new URLPreviewComponent.Style.Builder();
        URLPreviewComponent.Value.Builder r140 = new URLPreviewComponent.Value.Builder();
        URLPreviewComponent.ValueType r141 = URLPreviewComponent.ValueType.POINT;
        r124.put("icon", r138.style(r139.width(r140.type(r141).value(Float.valueOf(20.0f)).build()).height(new URLPreviewComponent.Value.Builder().type(r141).value(Float.valueOf(20.0f)).build()).build()).image(new URLPreviewComponent.ImageProperty.Builder().ud_icon(new UDIcon.Builder().key(r137).build()).build()).build());
        URLPreviewComponent.Builder r142 = new URLPreviewComponent.Builder().type(r131).can_skip_when_unknown(r111).is_font_zoomable(r111).style(new URLPreviewComponent.Style.Builder().font_level(new URLPreviewComponent.FontLevel.Builder().type(URLPreviewComponent.FontType.BODY).level(2).build()).text_color_v2(new ThemeColor.Builder().token("text_caption").build()).build());
        URLPreviewComponent.TextProperty.Builder r143 = new URLPreviewComponent.TextProperty.Builder();
        String r144 = r106.f561856b;
        if (r144 != null) goto L72;
        String r145 = r106.getType();
        if (r145 == null) goto L69;
        r144 = r145.toUpperCase(Locale.ROOT);
    L70:
        if (r144 != null) goto L72;
        String r146 = "";
    L73:
        r124.put("typeText", r142.text(r143.text(r146).number_of_lines(1).build()).build());
        r122 = new URLPreviewBody.Builder().components(new URLPreviewComponents.Builder().root_ids(CollectionsKt.listOf(RootDescription.ROOT_ELEMENT)).elements(r124).build()).build();
        goto L74
    L69:
        r144 = null;
    L72:
        r146 = r144;
        goto L73
    L24:
        if (StringsKt.equals(r135, "ai_slides", true) == false) goto L27;
        r137 = "file-ai_slides";
        goto L64
    L27:
        if (StringsKt.equals(r135, "ai_sheet", true) == false) goto L30;
        r137 = "file-ai_sheet";
        goto L64
    L30:
        if (StringsKt.equals(r135, "others", true) == false) goto L33;
        r137 = "file-others";
        goto L64
    L33:
        if (r135.length() > 0) goto L36;
        r136 = false;
    L36:
        if (r136 == false) goto L38;
        FileType r147 = FileType.getFileTypeBySuffix(".".concat(r135));
    L39:
        if (r147 != null) goto L41;
        int r148 = -1;
    L42:
        switch(r148) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            case 14: goto L50;
            case 15: goto L49;
            case 16: goto L48;
            case 17: goto L47;
            case 18: goto L46;
            case 19: goto L45;
            case 20: goto L44;
            default: goto L43;
        };
    L43:
        r137 = "file-unknown_colorful";
        goto L64
    L44:
        r137 = "file-folder_colorful";
        goto L64
    L45:
        r137 = "file-msg_colorful";
        goto L64
    L46:
        r137 = "file-eml_colorful";
        goto L64
    L47:
        r137 = "file-pages_colorful";
        goto L64
    L48:
        r137 = "file-numbers_colorful";
        goto L64
    L49:
        r137 = "file-keynote_colorful";
        goto L64
    L50:
        r137 = "file-ae_colorful";
        goto L64
    L51:
        r137 = "file-sketch_colorful";
        goto L64
    L52:
        r137 = "file-ai_colorful";
        goto L64
    L53:
        r137 = "file-android_colorful";
        goto L64
    L54:
        r137 = "file-text_colorful";
        goto L64
    L55:
        r137 = "file-audio_colorful";
        goto L64
    L56:
        r137 = "file-video_colorful";
        goto L64
    L57:
        r137 = "file-image_colorful";
        goto L64
    L58:
        r137 = "file-ps_colorful";
        goto L64
    L59:
        r137 = "file-zip_colorful";
        goto L64
    L60:
        r137 = "file-excel_colorful";
        goto L64
    L61:
        r137 = "file-word_colorful";
        goto L64
    L62:
        r137 = "file-ppt_colorful";
        goto L64
    L63:
        r137 = "file-pdf_colorful";
        goto L64
    L41:
        r148 = vhb.a.C8008a.f554992a[r147.ordinal()];
        goto L42
    L38:
        r147 = FileType.TYPE_UNKNOWN;
        goto L39
    L76:
        return new xcb.a(r101, r102);
    }

    @Inject
    public a(Lazy<UrlPreviewService> r100, Lazy<d> r101) {
        Intrinsics.checkNotNullParameter(r100, "lazeUrlPreviewService");
        Intrinsics.checkNotNullParameter(r101, "lazeUrlPreviewPush");
        this.f478060a = r100;
        this.f478061b = r101;
        new ConcurrentHashMap();
    }

    @Override // w4b.f
    public final Object a(List<PreviewHangPoint> r100, Continuation<? super Map<String, UrlCardPreviewEntity>> r101) {
        return this.f478060a.get().b(r100, r101);
    }

    @Override // w4b.f
    public final void d(String r100, long r101, long r102, KeyboardBaseModuleDependencyImpl.C118301 r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f478060a.get().getClass();
        UrlPreviewService.d(r100, r101, r102, r103);
    }
}
