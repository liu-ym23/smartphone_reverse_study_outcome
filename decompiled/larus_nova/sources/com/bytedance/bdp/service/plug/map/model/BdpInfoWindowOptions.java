package com.bytedance.bdp.service.plug.map.model;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions;", "", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "anchorX", "", "getAnchorX", "()D", "anchorY", "getAnchorY", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "borderColor", "getBorderColor", "borderRadius", "getBorderRadius", "borderWidth", "getBorderWidth", "color", "getColor", "content", "getContent", "display", "Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$Display;", "getDisplay", "()Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$Display;", "fontSize", "getFontSize", GXTemplateKey.FLEXBOX_PADDING, "getPadding", "textAlign", "Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$TextAlign;", "getTextAlign", "()Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$TextAlign;", "title", "Companion", "Display", "TextAlign", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public final class BdpInfoWindowOptions {
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
    private final Display display;
    private final double fontSize;
    private final double padding;
    private final TextAlign textAlign;
    public String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$Companion;", "", "()V", "defaultColor", "", "defaultFontSize", "", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$Display;", "", "(Ljava/lang/String;I)V", "BYCLICK", "ALWAYS", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum Display extends Enum<Display> {
        private static final /* synthetic */ Display[] $VALUES = null;
        public static final Display ALWAYS = null;
        public static final Display BYCLICK = null;

        static {
            Display r100 = new Display("BYCLICK", 0);
            BYCLICK = r100;
            Display r101 = new Display("ALWAYS", 1);
            ALWAYS = r101;
            $VALUES = new Display[]{r100, r101};
        }

        public static Display valueOf(String r100) {
            return (Display) a.a(Display.class, r100);
        }

        public static Display[] values() {
            return (Display[]) $VALUES.clone();
        }

        private Display(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$TextAlign;", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "", "(Ljava/lang/String;II)V", "getGravity", "()I", "LEFT", "CENTER", "RIGHT", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
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

    public final Display getDisplay() {
        return this.display;
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

    public BdpInfoWindowOptions(JSONObject r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.optString("content");
    L6:
        this.content = r102;
        String r103 = "#222222";
        if (r100 == null) goto L12;
        String r104 = r100.optString("color", "#222222");
        if (r104 == null) goto L12;
        r103 = r104;
    L12:
        this.color = r103;
        double r105 = 12.0d;
        if (r100 == null) goto L15;
        double r106 = r100.optDouble("fontSize", 12.0d);
    L16:
        this.fontSize = r106;
        double r107 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L19;
        r105 = RangesKt.coerceAtLeast(r100.optDouble("borderRadius", 12.0d), AudioStats.AUDIO_AMPLITUDE_NONE);
    L19:
        this.borderRadius = r105;
        if (r100 == null) goto L22;
        double r108 = RangesKt.coerceAtLeast(r100.optDouble(GXTemplateKey.FLEXBOX_PADDING, AudioStats.AUDIO_AMPLITUDE_NONE), AudioStats.AUDIO_AMPLITUDE_NONE);
    L23:
        this.padding = r108;
        if (r100 == null) goto L26;
        double r109 = RangesKt.coerceAtLeast(r100.optDouble("borderWidth", AudioStats.AUDIO_AMPLITUDE_NONE), AudioStats.AUDIO_AMPLITUDE_NONE);
    L27:
        this.borderWidth = r109;
        if (r100 == null) goto L30;
        String r110 = r100.optString("borderColor");
    L31:
        this.borderColor = r110;
        if (r100 == null) goto L34;
        r101 = r100.optString("bgColor");
    L34:
        this.bgColor = r101;
        if (r100 == null) goto L37;
        double r111 = r100.optDouble("anchorX", AudioStats.AUDIO_AMPLITUDE_NONE);
    L38:
        this.anchorX = r111;
        if (r100 == null) goto L41;
        r107 = r100.optDouble("anchorY", AudioStats.AUDIO_AMPLITUDE_NONE);
    L41:
        this.anchorY = r107;
        if (r100 != null) goto L63;
    L47:
        String r112 = Display.BYCLICK.name();     // Catch: Exception -> L50
    L48:
        Display r113 = Display.valueOf(r112);     // Catch: Exception -> L50
    L51:
        this.display = r113;
        if (r100 != null) goto L65;
    L57:
        String r114 = "";
    L58:
        TextAlign r115 = TextAlign.valueOf(r114);     // Catch: Exception -> L60
    L61:
        this.textAlign = r115;
        return;
    L60:
        r115 = TextAlign.CENTER;
        goto L61
    L65:
        String r116 = r100.optString("textAlign");     // Catch: Exception -> L60
        if (r116 == null) goto L57;
        r114 = r116.toUpperCase(Locale.ROOT);     // Catch: Exception -> L60
        if (r114 != null) goto L58;
    L50:
        r113 = Display.BYCLICK;
        goto L51
    L63:
        String r117 = r100.optString("display");     // Catch: Exception -> L50
        if (r117 == null) goto L47;
        r112 = r117.toUpperCase(Locale.ROOT);     // Catch: Exception -> L50
        if (r112 != null) goto L48;
    L37:
        r111 = 0.0d;
        goto L38
    L30:
        r110 = null;
        goto L31
    L26:
        r109 = 0.0d;
        goto L27
    L22:
        r108 = 6.0d;
        goto L23
    L15:
        r106 = 12.0d;
        goto L16
    L5:
        r102 = null;
        goto L6
    }
}
