package er3;

import android.graphics.Color;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ler3/c;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "width", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "height", "getHeight", "backgroundColor", "getBackgroundColor", "Ler3/a;", "cornerRadius", "Ler3/a;", "getCornerRadius", "()Ler3/a;", "", "Ler3/f;", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Ler3/c$a;", "extra", "Ler3/c$a;", "getExtra", "()Ler3/c$a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<f> actions;

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("corner_radius")
    private final er3.a cornerRadius;

    @SerializedName("extra")
    private final a extra;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("config_type")
    private final String type;

    @SerializedName("width")
    private final Integer width;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011R\u001c\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006¨\u0006)"}, d2 = {"Ler3/c$a;", "", "", "verticalPadding", "Ljava/lang/Integer;", ce.f26396k, "()Ljava/lang/Integer;", "setVerticalPadding", "(Ljava/lang/Integer;)V", "marginToTarget", ce.f26391f, "marginToEdge", "f", "", "clickOutDismiss", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "arrowHeight", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/model/ECUrlModel;", "imageUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "e", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Ler3/a;", "imageCornerRadius", "Ler3/a;", "d", "()Ler3/a;", "", "text", "Ljava/lang/String;", "h", "()Ljava/lang/String;", CommodityText.BOLD, "b", "textColor", RXScreenCaptureService.KEY_INDEX, "textSizeDp", ce.f26395j, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("arrow_height")
        private final Integer arrowHeight;

        @SerializedName(CommodityText.BOLD)
        private final Boolean bold;

        @SerializedName("click_out_dismiss")
        private final Boolean clickOutDismiss;

        @SerializedName("image_corner_radius")
        private final er3.a imageCornerRadius;

        @SerializedName("image")
        private final ECUrlModel imageUrl;

        @SerializedName("margin_to_edge")
        private final Integer marginToEdge;

        @SerializedName("margin_to_target")
        private final Integer marginToTarget;

        @SerializedName("text")
        private final String text;

        @SerializedName("text_color")
        private final String textColor;

        @SerializedName("text_size")
        private final Integer textSizeDp;

        @SerializedName("vertical_padding")
        private Integer verticalPadding;

        public final Integer a() {
            return this.arrowHeight;
        }

        public final Boolean b() {
            return this.bold;
        }

        public final Boolean c() {
            return this.clickOutDismiss;
        }

        public final er3.a d() {
            return this.imageCornerRadius;
        }

        public final ECUrlModel e() {
            return this.imageUrl;
        }

        public final Integer f() {
            return this.marginToEdge;
        }

        public final Integer g() {
            return this.marginToTarget;
        }

        public final String h() {
            return this.text;
        }

        public final String i() {
            return this.textColor;
        }

        public final Integer j() {
            return this.textSizeDp;
        }

        public final Integer k() {
            return this.verticalPadding;
        }
    }

    public final fr3.a<?> b() {
        Integer r100 = this.width;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        Integer r102 = this.height;
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L10:
        String r104 = this.backgroundColor;
        if (r104 != null) goto L105;
    L15:
        int r105 = 0;
    L16:
        fr3.a.C5943a.C5944a r106 = fr3.a.C5943a.f478587f;
        er3.a r107 = this.cornerRadius;
        r106.getClass();
        fr3.a.C5943a r110 = fr3.a.C5943a.C5944a.a(r107);
        String r108 = this.type;
        String r109 = null;
        switch(r108.hashCode()) {
            case 102102: goto L99;
            case 3556653: goto L69;
            case 98629247: goto L35;
            case 100313435: goto L20;
            default: goto L102;
        };
    L102:
        return null;
    L20:
        if (r108.equals("image") == false) goto L102;
        a r111 = this.extra;
        if (r111 == null) goto L24;
        ECUrlModel r112 = r111.e();
    L25:
        a r113 = this.extra;
        if (r113 == null) goto L28;
        er3.a r114 = r113.d();
    L29:
        fr3.a.C5943a r115 = fr3.a.C5943a.C5944a.a(r114);
        if (r112 != null) goto L33;
        return null;
    L33:
        return new fr3.a.e(r101, r103, r105, r110, r112, r115);
    L28:
        r114 = null;
        goto L29
    L24:
        r112 = null;
        goto L25
    L35:
        if (r108.equals("group") == false) goto L102;
        a r116 = this.extra;
        if (r116 == null) goto L41;
        Integer r117 = r116.k();
        if (r117 == null) goto L41;
        int r118 = r117.intValue();
    L42:
        a r119 = this.extra;
        if (r119 == null) goto L47;
        Integer r120 = r119.g();
        if (r120 == null) goto L47;
        int r121 = r120.intValue();
    L48:
        a r122 = this.extra;
        if (r122 == null) goto L53;
        Integer r123 = r122.f();
        if (r123 == null) goto L53;
        int r124 = r123.intValue();
    L54:
        a r125 = this.extra;
        if (r125 == null) goto L59;
        Boolean r126 = r125.c();
        if (r126 == null) goto L59;
        boolean r127 = r126.booleanValue();
    L60:
        a r128 = this.extra;
        if (r128 == null) goto L65;
        Integer r129 = r128.a();
        if (r129 == null) goto L65;
        int r130 = r129.intValue();
    L67:
        return new fr3.a.c(r101, r103, r118, r121, r124, r130, r127, r105, r110);
    L65:
        r130 = 10;
    L59:
        r127 = false;
    L53:
        r124 = 0;
    L47:
        r121 = 0;
    L41:
        r118 = 0;
        goto L42
    L69:
        if (r108.equals("text") == false) goto L102;
        a r131 = this.extra;
        if (r131 == null) goto L73;
        String r132 = r131.h();
    L74:
        a r133 = this.extra;
        if (r133 == null) goto L79;
        Boolean r134 = r133.b();
        if (r134 == null) goto L79;
        boolean r135 = r134.booleanValue();
    L80:
        if (r132 == null) goto L110;
        a r136 = this.extra;
        if (r136 == null) goto L85;
        r109 = r136.i();
    L85:
        if (r109 != null) goto L107;
    L89:
        int r137 = -16777216;
    L90:
        a r138 = this.extra;
        if (r138 == null) goto L95;
        Integer r139 = r138.j();
        if (r139 == null) goto L95;
        int r140 = r139.intValue();
    L97:
        return new fr3.a.g(r101, r103, r105, r110, r140, r137, r132, r135);
    L95:
        r140 = 13;
        goto L97
    L107:
        r137 = Color.parseColor(r109);     // Catch: IllegalArgumentException -> L103
        goto L90
    L110:
        return null;
    L79:
        r135 = false;
        goto L80
    L73:
        r132 = null;
        goto L74
    L99:
        if (r108.equals("gap") == false) goto L102;
        return new fr3.a.b(r101);
    L105:
        r105 = Color.parseColor(r104);     // Catch: IllegalArgumentException -> L104
    L9:
        r103 = -2;
        goto L10
    L5:
        r101 = -2;
        goto L6
    }

    public final List<f> a() {
        return this.actions;
    }

    public final String getType() {
        return this.type;
    }
}
