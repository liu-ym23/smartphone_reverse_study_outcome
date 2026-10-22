package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.bytedance.android.shopping.anchorv3.utils.n;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class IPromotionUIConfig {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a {
        public static k a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "jsonStr");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
            LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L22
            JSONObject r8 = com.bytedance.android.shopping.anchorv3.a.d(r7);     // Catch: Throwable -> L22
            if (r8 == null) goto L19;
            Iterator<String> r3 = r8.keys();     // Catch: Throwable -> L22
        L7:
            if (r3.hasNext() == false) goto L20;
            String r4 = r3.next();     // Catch: Throwable -> L22
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L11
            int r6 = n.a;     // Catch: Throwable -> L11
            Object r9 = Result.constructor-impl((d) n.a.a.fromJson(r8.optString(r4), d.class));     // Catch: Throwable -> L11
        L14:
            if (Result.isFailure-impl(r9) == false) goto L16;
            r9 = null;
        L16:
            d r10 = (d) r9;     // Catch: Throwable -> L22
            if (r10 == null) goto L7;
            PromotionCardModuleName.Companion.getClass();     // Catch: Throwable -> L22
            r2.put(PromotionCardModuleName.a.a(r4), r10);     // Catch: Throwable -> L22
        L11:
            th = move-exception;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
            r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
        L20:
            Object r12 = Result.constructor-impl(r2);     // Catch: Throwable -> L22
        L24:
            Throwable r13 = Result.exceptionOrNull-impl(r12);
            if (r13 == null) goto L28;
            ye.a.b(r13);
        L28:
            if (Result.isFailure-impl(r12) == false) goto L30;
            r12 = null;
        L30:
            Map r14 = (Map) r12;
            if (r14 != null) goto L33;
            return null;
        L33:
            return new k(r14);
        L19:
            Lazy r15 = IPromotionUIConfig.a;     // Catch: Throwable -> L22
            ye.a.a("UI config of promotion card cannot be parsed.");     // Catch: Throwable -> L22
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L24
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001a\u0010\u001f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "", "", "bgColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "radius", "[F", "i", "()[F", "", "fontSize", "F", "e", "()F", "", "fontUseSp", "Z", "f", "()Z", "", "fontWeight", "I", "g", "()I", "fontColor", "d", "lineSpacingExtra", "h", "drawableScale", "c", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("bg_color")
        private final String bgColor;

        @SerializedName("drawable_scale")
        private final float drawableScale;

        @SerializedName("font_color")
        private final String fontColor;

        @SerializedName("font_size")
        private final float fontSize;

        @SerializedName("font_sp")
        private final boolean fontUseSp;

        @SerializedName("font_weight")
        private final int fontWeight;

        @SerializedName("line_spacing_extra")
        private final float lineSpacingExtra;

        @SerializedName("radius")
        private final float[] radius;

        public b() {
            this(null, null, 0.0f, true, 0, null, 0.0f, 1.0f);
        }

        public final String toString() {
            return "Design(bgColor=" + this.bgColor + ", radius=" + Arrays.toString(this.radius) + ", fontSize=" + this.fontSize + ", fontUseSp=" + this.fontUseSp + ", fontWeight=" + this.fontWeight + ", fontColor=" + this.fontColor + ", lineSpacingExtra=" + this.lineSpacingExtra + ", drawableScale=" + this.drawableScale + ")";
        }

        public final int hashCode() {
            String r0 = this.bgColor;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            float[] r4 = this.radius;
            if (r4 == null) goto L9;
            int r5 = Arrays.hashCode(r4);
        L10:
            int r6 = (((r3 + r5) * 31) + Float.floatToIntBits(this.fontSize)) * 31;
            if (this.fontUseSp == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (((r6 + r7) * 31) + this.fontWeight) * 31;
            String r9 = this.fontColor;
            if (r9 == null) goto L18;
            r1 = r9.hashCode();
        L18:
            return ((((r8 + r1) * 31) + Float.floatToIntBits(this.lineSpacingExtra)) * 31) + Float.floatToIntBits(this.drawableScale);
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String b() {
            return this.bgColor;
        }

        public final float c() {
            return this.drawableScale;
        }

        public final String d() {
            return this.fontColor;
        }

        public final float e() {
            return this.fontSize;
        }

        public final boolean f() {
            return this.fontUseSp;
        }

        public final int g() {
            return this.fontWeight;
        }

        public final float h() {
            return this.lineSpacingExtra;
        }

        public final float[] i() {
            return this.radius;
        }

        public static b a(b r9) {
            return new b(null, r9.radius, r9.fontSize, r9.fontUseSp, r9.fontWeight, r9.fontColor, r9.lineSpacingExtra, r9.drawableScale);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if ((!Intrinsics.areEqual(b.class, r2)) == false) goto L12;
            return false;
        L12:
            if (r5 == null) goto L45;
            b r6 = (b) r5;
            if ((true ^ Intrinsics.areEqual(this.bgColor, r6.bgColor)) == false) goto L16;
            return false;
        L16:
            float[] r0 = this.radius;
            if (r0 == null) goto L25;
            float[] r1 = r6.radius;
            if (r1 != null) goto L22;
            return false;
        L22:
            if (Arrays.equals(r0, r1) == true) goto L28;
            return false;
        L28:
            if (this.fontSize == r6.fontSize) goto L31;
            return false;
        L31:
            if (this.fontUseSp == r6.fontUseSp) goto L34;
            return false;
        L34:
            if (this.fontWeight == r6.fontWeight) goto L37;
            return false;
        L37:
            if (this.lineSpacingExtra == r6.lineSpacingExtra) goto L40;
            return false;
        L40:
            if (this.drawableScale == r6.drawableScale) goto L43;
            return false;
        L43:
            return Intrinsics.areEqual(this.fontColor, r6.fontColor);
        L25:
            if (r6.radius == null) goto L28;
            return false;
        L45:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig.Design");
        L8:
            r2 = null;
            goto L10
        }

        public b(String r1, float[] r2, float r3, boolean r4, int r5, String r6, float r7, float r8) {
            this.bgColor = r1;
            this.radius = r2;
            this.fontSize = r3;
            this.fontUseSp = r4;
            this.fontWeight = r5;
            this.fontColor = r6;
            this.lineSpacingExtra = r7;
            this.drawableScale = r8;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001c\u0010$\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u001c\u0010(\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001fR\u001c\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001fR\u001c\u0010,\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001f¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "", "", "width", "I", "r", "()I", "height", "c", "paddingTop", "Ljava/lang/Integer;", "m", "()Ljava/lang/Integer;", "paddingRight", "l", "paddingBottom", "j", "paddingLeft", "k", "marginTop", "i", "marginRight", "h", "marginBottom", "f", "marginLeft", "g", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "leftToLeft", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/PromotionCardModuleName;", "leftToRight", "e", "rightToLeft", "n", "rightToRight", "o", "topToTop", "q", "topToBottom", "p", "bottomToTop", "b", "bottomToBottom", "a", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("bottom_to_bottom")
        private final PromotionCardModuleName bottomToBottom;

        @SerializedName("bottom_to_top")
        private final PromotionCardModuleName bottomToTop;

        @SerializedName("height")
        private final int height;

        @SerializedName("left_to_left")
        private final PromotionCardModuleName leftToLeft;

        @SerializedName("left_to_right")
        private final PromotionCardModuleName leftToRight;

        @SerializedName("bottom_margin")
        private final Integer marginBottom;

        @SerializedName("left_margin")
        private final Integer marginLeft;

        @SerializedName("right_margin")
        private final Integer marginRight;

        @SerializedName("top_margin")
        private final Integer marginTop;

        @SerializedName("bottom_padding")
        private final Integer paddingBottom;

        @SerializedName("left_padding")
        private final Integer paddingLeft;

        @SerializedName("right_padding")
        private final Integer paddingRight;

        @SerializedName("top_padding")
        private final Integer paddingTop;

        @SerializedName("right_to_left")
        private final PromotionCardModuleName rightToLeft;

        @SerializedName("right_to_right")
        private final PromotionCardModuleName rightToRight;

        @SerializedName("top_to_bottom")
        private final PromotionCardModuleName topToBottom;

        @SerializedName("top_to_top")
        private final PromotionCardModuleName topToTop;

        @SerializedName("width")
        private final int width;

        public c() {
            this(0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        }

        public final String toString() {
            return "Layout(width=" + this.width + ", height=" + this.height + ", paddingTop=" + this.paddingTop + ", paddingRight=" + this.paddingRight + ", paddingBottom=" + this.paddingBottom + ", paddingLeft=" + this.paddingLeft + ", marginTop=" + this.marginTop + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", marginLeft=" + this.marginLeft + ", leftToLeft=" + this.leftToLeft + ", leftToRight=" + this.leftToRight + ", rightToLeft=" + this.rightToLeft + ", rightToRight=" + this.rightToRight + ", topToTop=" + this.topToTop + ", topToBottom=" + this.topToBottom + ", bottomToTop=" + this.bottomToTop + ", bottomToBottom=" + this.bottomToBottom + ")";
        }

        public final int hashCode() {
            int r0 = ((this.width * 31) + this.height) * 31;
            Integer r1 = this.paddingTop;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.intValue();
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.paddingRight;
            if (r5 == null) goto L9;
            int r6 = r5.intValue();
        L10:
            int r7 = (r4 + r6) * 31;
            Integer r8 = this.paddingBottom;
            if (r8 == null) goto L13;
            int r9 = r8.intValue();
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.paddingLeft;
            if (r11 == null) goto L17;
            int r12 = r11.intValue();
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.marginTop;
            if (r14 == null) goto L21;
            int r15 = r14.intValue();
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.marginRight;
            if (r17 == null) goto L25;
            int r18 = r17.intValue();
        L26:
            int r19 = (r16 + r18) * 31;
            Integer r20 = this.marginBottom;
            if (r20 == null) goto L29;
            int r21 = r20.intValue();
        L30:
            int r22 = (r19 + r21) * 31;
            Integer r23 = this.marginLeft;
            if (r23 == null) goto L33;
            int r24 = r23.intValue();
        L34:
            int r25 = (r22 + r24) * 31;
            PromotionCardModuleName r26 = this.leftToLeft;
            if (r26 == null) goto L37;
            int r27 = r26.hashCode();
        L38:
            int r28 = (r25 + r27) * 31;
            PromotionCardModuleName r29 = this.leftToRight;
            if (r29 == null) goto L41;
            int r30 = r29.hashCode();
        L42:
            int r31 = (r28 + r30) * 31;
            PromotionCardModuleName r32 = this.rightToLeft;
            if (r32 == null) goto L45;
            int r33 = r32.hashCode();
        L46:
            int r34 = (r31 + r33) * 31;
            PromotionCardModuleName r35 = this.rightToRight;
            if (r35 == null) goto L49;
            int r36 = r35.hashCode();
        L50:
            int r37 = (r34 + r36) * 31;
            PromotionCardModuleName r38 = this.topToTop;
            if (r38 == null) goto L53;
            int r39 = r38.hashCode();
        L54:
            int r40 = (r37 + r39) * 31;
            PromotionCardModuleName r41 = this.topToBottom;
            if (r41 == null) goto L57;
            int r42 = r41.hashCode();
        L58:
            int r43 = (r40 + r42) * 31;
            PromotionCardModuleName r44 = this.bottomToTop;
            if (r44 == null) goto L61;
            int r45 = r44.hashCode();
        L62:
            int r46 = (r43 + r45) * 31;
            PromotionCardModuleName r47 = this.bottomToBottom;
            if (r47 == null) goto L66;
            r2 = r47.hashCode();
        L66:
            return r46 + r2;
        L61:
            r45 = 0;
            goto L62
        L57:
            r42 = 0;
            goto L58
        L53:
            r39 = 0;
            goto L54
        L49:
            r36 = 0;
            goto L50
        L45:
            r33 = 0;
            goto L46
        L41:
            r30 = 0;
            goto L42
        L37:
            r27 = 0;
            goto L38
        L33:
            r24 = 0;
            goto L34
        L29:
            r21 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final PromotionCardModuleName a() {
            return this.bottomToBottom;
        }

        public final PromotionCardModuleName b() {
            return this.bottomToTop;
        }

        public final int c() {
            return this.height;
        }

        public final PromotionCardModuleName d() {
            return this.leftToLeft;
        }

        public final PromotionCardModuleName e() {
            return this.leftToRight;
        }

        public final Integer f() {
            return this.marginBottom;
        }

        public final Integer g() {
            return this.marginLeft;
        }

        public final Integer h() {
            return this.marginRight;
        }

        public final Integer i() {
            return this.marginTop;
        }

        public final Integer j() {
            return this.paddingBottom;
        }

        public final Integer k() {
            return this.paddingLeft;
        }

        public final Integer l() {
            return this.paddingRight;
        }

        public final Integer m() {
            return this.paddingTop;
        }

        public final PromotionCardModuleName n() {
            return this.rightToLeft;
        }

        public final PromotionCardModuleName o() {
            return this.rightToRight;
        }

        public final PromotionCardModuleName p() {
            return this.topToBottom;
        }

        public final PromotionCardModuleName q() {
            return this.topToTop;
        }

        public final int r() {
            return this.width;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if ((!Intrinsics.areEqual(c.class, r2)) == false) goto L12;
            return false;
        L12:
            if (r5 == null) goto L70;
            c r6 = (c) r5;
            if (this.width == r6.width) goto L17;
            return false;
        L17:
            if (this.height == r6.height) goto L20;
            return false;
        L20:
            if ((!Intrinsics.areEqual(this.paddingTop, r6.paddingTop)) == false) goto L23;
            return false;
        L23:
            if ((!Intrinsics.areEqual(this.paddingRight, r6.paddingRight)) == false) goto L26;
            return false;
        L26:
            if ((!Intrinsics.areEqual(this.paddingBottom, r6.paddingBottom)) == false) goto L29;
            return false;
        L29:
            if ((!Intrinsics.areEqual(this.paddingLeft, r6.paddingLeft)) == false) goto L32;
            return false;
        L32:
            if ((!Intrinsics.areEqual(this.marginTop, r6.marginTop)) == false) goto L35;
            return false;
        L35:
            if ((!Intrinsics.areEqual(this.marginRight, r6.marginRight)) == false) goto L38;
            return false;
        L38:
            if ((!Intrinsics.areEqual(this.marginBottom, r6.marginBottom)) == false) goto L41;
            return false;
        L41:
            if ((!Intrinsics.areEqual(this.marginLeft, r6.marginLeft)) == false) goto L44;
            return false;
        L44:
            if (this.leftToLeft == r6.leftToLeft) goto L47;
            return false;
        L47:
            if (this.leftToRight == r6.leftToRight) goto L50;
            return false;
        L50:
            if (this.rightToLeft == r6.rightToLeft) goto L53;
            return false;
        L53:
            if (this.rightToRight == r6.rightToRight) goto L56;
            return false;
        L56:
            if (this.topToTop == r6.topToTop) goto L59;
            return false;
        L59:
            if (this.topToBottom == r6.topToBottom) goto L62;
            return false;
        L62:
            if (this.bottomToTop == r6.bottomToTop) goto L65;
            return false;
        L65:
            if (this.bottomToBottom == r6.bottomToBottom) goto L71;
            return false;
        L71:
            return true;
        L70:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig.Layout");
        L8:
            r2 = null;
            goto L10
        }

        public final boolean s(Map<PromotionCardModuleName, Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "moduleIdMap");
            PromotionCardModuleName r0 = this.leftToLeft;
            if (r0 != null) goto L5;
        L6:
            PromotionCardModuleName r1 = this.leftToRight;
            if (r1 != null) goto L9;
        L10:
            PromotionCardModuleName r3 = this.rightToLeft;
            if (r3 != null) goto L13;
        L14:
            PromotionCardModuleName r4 = this.rightToRight;
            if (r4 != null) goto L17;
        L18:
            PromotionCardModuleName r5 = this.topToTop;
            if (r5 != null) goto L21;
        L22:
            PromotionCardModuleName r6 = this.topToBottom;
            if (r6 != null) goto L25;
        L26:
            PromotionCardModuleName r7 = this.bottomToTop;
            if (r7 != null) goto L29;
        L30:
            PromotionCardModuleName r8 = this.bottomToBottom;
            if (r8 != null) goto L33;
        L35:
            return false;
        L33:
            if (r2.get(r8) == null) goto L35;
        L34:
            return true;
        L29:
            if (r2.get(r7) != null) goto L34;
        L25:
            if (r2.get(r6) != null) goto L34;
        L21:
            if (r2.get(r5) != null) goto L34;
        L17:
            if (r2.get(r4) != null) goto L34;
        L13:
            if (r2.get(r3) != null) goto L34;
        L9:
            if (r2.get(r1) != null) goto L34;
        L5:
            if (r2.get(r0) != null) goto L34;
            goto L6
        }

        public c(int r3, int r4, Integer r5, Integer r6, Integer r7, Integer r8, Integer r9, Integer r10, Integer r11, Integer r12, PromotionCardModuleName r13, PromotionCardModuleName r14, PromotionCardModuleName r15, PromotionCardModuleName r16, PromotionCardModuleName r17, PromotionCardModuleName r18, PromotionCardModuleName r19, PromotionCardModuleName r20) {
            this.width = r3;
            this.height = r4;
            this.paddingTop = r5;
            this.paddingRight = r6;
            this.paddingBottom = r7;
            this.paddingLeft = r8;
            this.marginTop = r9;
            this.marginRight = r10;
            this.marginBottom = r11;
            this.marginLeft = r12;
            this.leftToLeft = r13;
            this.leftToRight = r14;
            this.rightToLeft = r15;
            this.rightToRight = r16;
            this.topToTop = r17;
            this.topToBottom = r18;
            this.bottomToTop = r19;
            this.bottomToBottom = r20;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$d;", "", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "design", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$b;", "", "visibility", "I", "c", "()I", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "layout", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$c;", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("design")
        private final b design;

        @SerializedName("layout")
        private final c layout;

        @SerializedName("visibility")
        private final int visibility;

        public static final class a {
        }

        static {
        }

        public d() {
            this(null, -1, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L12;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.design, r4.design) == true) goto L8;
            return false;
        L8:
            if (this.visibility == r4.visibility) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.layout, r4.layout) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            b r0 = this.design;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.visibility) * 31;
            c r4 = this.layout;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Style(design=" + this.design + ", visibility=" + this.visibility + ", layout=" + this.layout + ")";
        }

        public final Boolean d() {
            int r0 = this.visibility;
            if (r0 == 0) goto L9;
            if (r0 == 1) goto L11;
            return null;
        L11:
            return Boolean.FALSE;
        L9:
            return Boolean.TRUE;
        }

        public final b a() {
            return this.design;
        }

        public final c b() {
            return this.layout;
        }

        public final int c() {
            return this.visibility;
        }

        public d(b r1, int r2, c r3) {
            this.design = r1;
            this.visibility = r2;
            this.layout = r3;
        }
    }

    static {
        a = LazyKt.lazy(IPromotionUIConfig$Companion$PROMOTION_CARD$2.INSTANCE);
        b = LazyKt.lazy(IPromotionUIConfig$Companion$PROMOTION_CARD_V2$2.INSTANCE);
    }
}
