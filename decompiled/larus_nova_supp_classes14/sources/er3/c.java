package er3;

import android.graphics.Color;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ler3/c;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "width", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "height", "getHeight", "backgroundColor", "getBackgroundColor", "Ler3/a;", "cornerRadius", "Ler3/a;", "getCornerRadius", "()Ler3/a;", "", "Ler3/f;", "actions", "Ljava/util/List;", "a", "()Ljava/util/List;", "Ler3/c$a;", "extra", "Ler3/c$a;", "getExtra", "()Ler3/c$a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("actions")
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

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011R\u001c\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006¨\u0006)"}, d2 = {"Ler3/c$a;", "", "", "verticalPadding", "Ljava/lang/Integer;", "k", "()Ljava/lang/Integer;", "setVerticalPadding", "(Ljava/lang/Integer;)V", "marginToTarget", "g", "marginToEdge", "f", "", "clickOutDismiss", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "arrowHeight", "a", "Lcom/bytedance/android/ec/model/ECUrlModel;", "imageUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "e", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Ler3/a;", "imageCornerRadius", "Ler3/a;", "d", "()Ler3/a;", "", "text", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "bold", "b", "textColor", "i", "textSizeDp", "j", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("arrow_height")
        private final Integer arrowHeight;

        @SerializedName("bold")
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
        Integer r0 = this.width;
        if (r0 == null) goto L5;
        int r3 = r0.intValue();
    L6:
        Integer r1 = this.height;
        if (r1 == null) goto L9;
        int r4 = r1.intValue();
    L10:
        String r2 = this.backgroundColor;
        if (r2 != null) goto L105;
    L15:
        int r5 = 0;
    L16:
        fr3.a.C0125a.C0126a r6 = fr3.a.C0125a.f;
        er3.a r7 = this.cornerRadius;
        r6.getClass();
        fr3.a.C0125a r11 = fr3.a.C0125a.C0126a.a(r7);
        String r8 = this.type;
        String r9 = null;
        switch(r8.hashCode()) {
            case 102102: goto L99;
            case 3556653: goto L69;
            case 98629247: goto L35;
            case 100313435: goto L20;
            default: goto L102;
        };
    L102:
        return null;
    L20:
        if (r8.equals("image") == false) goto L102;
        a r10 = this.extra;
        if (r10 == null) goto L24;
        ECUrlModel r12 = r10.e();
    L25:
        a r13 = this.extra;
        if (r13 == null) goto L28;
        er3.a r14 = r13.d();
    L29:
        fr3.a.C0125a r15 = fr3.a.C0125a.C0126a.a(r14);
        if (r12 != null) goto L33;
        return null;
    L33:
        return new fr3.a.e(r3, r4, r5, r11, r12, r15);
    L28:
        r14 = null;
        goto L29
    L24:
        r12 = null;
        goto L25
    L35:
        if (r8.equals("group") == false) goto L102;
        a r16 = this.extra;
        if (r16 == null) goto L41;
        Integer r17 = r16.k();
        if (r17 == null) goto L41;
        int r18 = r17.intValue();
    L42:
        a r19 = this.extra;
        if (r19 == null) goto L47;
        Integer r20 = r19.g();
        if (r20 == null) goto L47;
        int r21 = r20.intValue();
    L48:
        a r22 = this.extra;
        if (r22 == null) goto L53;
        Integer r23 = r22.f();
        if (r23 == null) goto L53;
        int r24 = r23.intValue();
    L54:
        a r25 = this.extra;
        if (r25 == null) goto L59;
        Boolean r26 = r25.c();
        if (r26 == null) goto L59;
        boolean r27 = r26.booleanValue();
    L60:
        a r28 = this.extra;
        if (r28 == null) goto L65;
        Integer r29 = r28.a();
        if (r29 == null) goto L65;
        int r30 = r29.intValue();
    L67:
        return new fr3.a.c(r3, r4, r18, r21, r24, r30, r27, r5, r11);
    L65:
        r30 = 10;
    L59:
        r27 = false;
    L53:
        r24 = 0;
    L47:
        r21 = 0;
    L41:
        r18 = 0;
        goto L42
    L69:
        if (r8.equals("text") == false) goto L102;
        a r31 = this.extra;
        if (r31 == null) goto L73;
        String r32 = r31.h();
    L74:
        a r33 = this.extra;
        if (r33 == null) goto L79;
        Boolean r34 = r33.b();
        if (r34 == null) goto L79;
        boolean r110 = r34.booleanValue();
    L80:
        if (r32 == null) goto L110;
        a r35 = this.extra;
        if (r35 == null) goto L85;
        r9 = r35.i();
    L85:
        if (r9 != null) goto L107;
    L89:
        int r36 = -16777216;
    L90:
        a r37 = this.extra;
        if (r37 == null) goto L95;
        Integer r38 = r37.j();
        if (r38 == null) goto L95;
        int r39 = r38.intValue();
    L97:
        return new fr3.a.g(r3, r4, r5, r11, r39, r36, r32, r110);
    L95:
        r39 = 13;
        goto L97
    L107:
        r36 = Color.parseColor(r9);     // Catch: IllegalArgumentException -> L103
        goto L90
    L110:
        return null;
    L79:
        r110 = false;
        goto L80
    L73:
        r32 = null;
        goto L74
    L99:
        if (r8.equals("gap") == false) goto L102;
        return new fr3.a.b(r3);
    L105:
        r5 = Color.parseColor(r2);     // Catch: IllegalArgumentException -> L104
    L9:
        r4 = -2;
        goto L10
    L5:
        r3 = -2;
        goto L6
    }

    public final List<f> a() {
        return this.actions;
    }

    public final String getType() {
        return this.type;
    }
}
