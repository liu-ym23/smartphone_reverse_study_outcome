package com.bytedance.bdp.service.plug.map.model;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpFacadeOptions;", "", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "anchorX", "", "getAnchorX", "()D", "anchorY", "getAnchorY", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "borderColor", "getBorderColor", "borderRadius", "getBorderRadius", "borderWidth", "getBorderWidth", "color", "getColor", "content", "getContent", "fontSize", "getFontSize", GXTemplateKey.FLEXBOX_PADDING, "getPadding", "textAlign", "Lcom/bytedance/bdp/service/plug/map/model/BdpFacadeOptions$TextAlign;", "getTextAlign", "()Lcom/bytedance/bdp/service/plug/map/model/BdpFacadeOptions$TextAlign;", "Companion", "TextAlign", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public final class BdpFacadeOptions {
    public static final Companion Companion = null;
    public static final String defaultColor = "#222222";
    public static final double defaultFontSize = 12.0d;
    private final double anchorX;
    private final double anchorY;
    private final String bgColor;
    private final String borderColor;
    private final double borderRadius;
    private final double borderWidth;
    private final String color;
    private final String content;
    private final double fontSize;
    private final double padding;
    private final TextAlign textAlign;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpFacadeOptions$Companion;", "", "()V", "defaultColor", "", "defaultFontSize", "", "optOptions", "Lcom/bytedance/bdp/service/plug/map/model/BdpFacadeOptions;", "params", "Lorg/json/JSONObject;", "parse", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final BdpFacadeOptions optOptions(JSONObject r100) {
            DefaultConstructorMarker r101 = null;
            if (r100 != null) goto L6;
            return null;
        L6:
            return new BdpFacadeOptions(r100, r101);
        }

        @JvmStatic
        public final BdpFacadeOptions parse(JSONObject r100) {
            return new BdpFacadeOptions(r100, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpFacadeOptions$TextAlign;", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "(Ljava/lang/String;II)V", "getGravity", "()I", "LEFT", "CENTER", "RIGHT", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum TextAlign extends Enum<TextAlign> {
        private static final /* synthetic */ TextAlign[] $VALUES = null;
        public static final TextAlign CENTER = null;
        public static final TextAlign LEFT = null;
        public static final TextAlign RIGHT = null;
        private final int gravity;

        static {
            TextAlign r100 = new TextAlign("LEFT", 0, 3);
            LEFT = r100;
            TextAlign r101 = new TextAlign("CENTER", 1, 17);
            CENTER = r101;
            TextAlign r102 = new TextAlign("RIGHT", 2, 5);
            RIGHT = r102;
            $VALUES = new TextAlign[]{r100, r101, r102};
        }

        public static TextAlign valueOf(String r100) {
            return (TextAlign) a.a(TextAlign.class, r100);
        }

        public static TextAlign[] values() {
            return (TextAlign[]) $VALUES.clone();
        }

        public final int getGravity() {
            return this.gravity;
        }

        private TextAlign(String r100, int r101, int r102) {
            super(r100, r101);
            this.gravity = r102;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final BdpFacadeOptions optOptions(JSONObject r100) {
        return Companion.optOptions(r100);
    }

    @JvmStatic
    public static final BdpFacadeOptions parse(JSONObject r100) {
        return Companion.parse(r100);
    }

    public final double getAnchorX() {
        return this.anchorX;
    }

    public final double getAnchorY() {
        return this.anchorY;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final double getBorderRadius() {
        return this.borderRadius;
    }

    public final double getBorderWidth() {
        return this.borderWidth;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getContent() {
        return this.content;
    }

    public final double getFontSize() {
        return this.fontSize;
    }

    public final double getPadding() {
        return this.padding;
    }

    public final TextAlign getTextAlign() {
        return this.textAlign;
    }

    private BdpFacadeOptions(JSONObject r100) {
        if (r100 == null) goto L5;
        String r101 = r100.optString("content");
    L6:
        this.content = r101;
        String r102 = "#222222";
        if (r100 == null) goto L12;
        String r103 = r100.optString("color", "#222222");
        if (r103 == null) goto L12;
        r102 = r103;
    L12:
        this.color = r102;
        double r104 = 12.0d;
        if (r100 == null) goto L15;
        double r105 = r100.optDouble("fontSize", 12.0d);
    L16:
        this.fontSize = r105;
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L19;
        r104 = RangesKt.coerceAtLeast(r100.optDouble("borderRadius", 12.0d), AudioStats.AUDIO_AMPLITUDE_NONE);
    L19:
        this.borderRadius = r104;
        if (r100 == null) goto L22;
        double r107 = RangesKt.coerceAtLeast(r100.optDouble(GXTemplateKey.FLEXBOX_PADDING, AudioStats.AUDIO_AMPLITUDE_NONE), AudioStats.AUDIO_AMPLITUDE_NONE);
    L23:
        this.padding = r107;
        if (r100 == null) goto L26;
        double r108 = RangesKt.coerceAtLeast(r100.optDouble("borderWidth", AudioStats.AUDIO_AMPLITUDE_NONE), AudioStats.AUDIO_AMPLITUDE_NONE);
    L27:
        this.borderWidth = r108;
        String r109 = CustomHeaderConfig.COLOR_DARK;
        if (r100 == null) goto L33;
        String r110 = r100.optString("borderColor", CustomHeaderConfig.COLOR_DARK);
        if (r110 == null) goto L33;
        r109 = r110;
    L33:
        this.borderColor = r109;
        String r111 = CustomHeaderConfig.COLOR_LIGHT;
        if (r100 == null) goto L39;
        String r112 = r100.optString("bgColor", CustomHeaderConfig.COLOR_LIGHT);
        if (r112 == null) goto L39;
        r111 = r112;
    L39:
        this.bgColor = r111;
        if (r100 == null) goto L42;
        double r113 = r100.optDouble("anchorX", AudioStats.AUDIO_AMPLITUDE_NONE);
    L43:
        this.anchorX = r113;
        if (r100 == null) goto L46;
        r106 = r100.optDouble("anchorY", AudioStats.AUDIO_AMPLITUDE_NONE);
    L46:
        this.anchorY = r106;
        if (r100 != null) goto L58;
    L52:
        String r114 = "";
    L53:
        TextAlign r115 = TextAlign.valueOf(r114);     // Catch: Exception -> L55
    L56:
        this.textAlign = r115;
        return;
    L55:
        r115 = TextAlign.CENTER;
        goto L56
    L58:
        String r116 = r100.optString("textAlign");     // Catch: Exception -> L55
        if (r116 == null) goto L52;
        r114 = r116.toUpperCase(Locale.ROOT);     // Catch: Exception -> L55
        if (r114 != null) goto L53;
    L42:
        r113 = 0.0d;
        goto L43
    L26:
        r108 = 0.0d;
        goto L27
    L22:
        r107 = 6.0d;
        goto L23
    L15:
        r105 = 12.0d;
        goto L16
    L5:
        r101 = null;
        goto L6
    }

    public /* synthetic */ BdpFacadeOptions(JSONObject r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
