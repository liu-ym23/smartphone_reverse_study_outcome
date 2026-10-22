package hja;

import androidx.camera.video.AudioStats;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import ija.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements gja.a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f485491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Token$Easing f485492c;

    public a() {
        this(300, 0, Token$Easing.OUI_ANIMATION_EASING_STANDARD);
    }

    @Override // gja.a
    public final String dump() {
        return "FloatTweenSpec(durationMillis: " + this.f485490a + ", delay: " + this.f485491b + ", easing: " + this.f485492c + ')';
    }

    public final int hashCode() {
        return (((this.f485490a * 31) + this.f485492c.hashCode()) * 31) + this.f485491b;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (r101.f485490a == this.f485490a) goto L7;
        return false;
    L7:
        if (r101.f485491b == this.f485491b) goto L9;
        return false;
    L9:
        if (r101.f485492c != this.f485492c) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    @Override // gja.a
    public final boolean a(long r100, long r101) {
        if (r100 < (r101 + (((long) this.f485491b) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    public a(int r100, int r101, Token$Easing r102) {
        Intrinsics.checkNotNullParameter(r102, "easing");
        this.f485490a = r100;
        this.f485491b = r101;
        this.f485492c = r102;
    }

    @Override // gja.a
    public final long b(Float r100, Float r101, float r102) {
        r100.floatValue();
        r101.floatValue();
        return ((long) this.f485490a) * 1000000;
    }

    public final Float e(long r210, float r310, float r311) {
        long r100 = RangesKt.coerceIn(r210 - (((long) this.f485491b) * 1000000), 0, ((long) this.f485490a) * 1000000);
        int r101 = this.f485490a;
        if (r101 != 0) goto L5;
        float r102 = 1.0f;
    L6:
        Token$Easing r103 = this.f485492c;
        if (r103 != Token$Easing.OUI_ANIMATION_EASING_LINEAR) goto L9;
        Intrinsics.checkNotNullParameter(r103, "$this$toLinearEasing");
    L171:
        int r104 = b.f490154a;
        return Float.valueOf(((1 - r102) * r310) + (r102 * r311));
    L9:
        Intrinsics.checkNotNullParameter(r103, "$this$toCubicBezierEasing");
        if (r103.getValues().length != 4) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L174;
        float r106 = r103.getValues()[0];
        float r107 = r103.getValues()[1];
        float r108 = r103.getValues()[2];
        float r109 = r103.getValues()[3];
        ija.a r110 = new ija.a(r106, r107, r108, r109);
        if (r102 >= 0.0f) goto L18;
        r102 = 0.0f;
    L18:
        if (r102 <= 1.0f) goto L21;
        r102 = 1.0f;
    L21:
        if (r102 <= 0.0f) goto L171;
        if (r102 >= 1.0f) goto L171;
        float r111 = 0.0f - r102;
        float r112 = r106 - r102;
        float r113 = r108 - r102;
        int r114 = b.f490154a;
        double r115 = r111;
        double r116 = ((r115 - (((double) r112) * 2.0d)) + ((double) r113)) * 3.0d;
        double r117 = ((double) (r112 - r111)) * 3.0d;
        double r118 = (((double) (-r111)) + (((double) (r112 - r113)) * 3.0d)) + ((double) (1.0f - r102));
        if (Math.abs(r118 - AudioStats.AUDIO_AMPLITUDE_NONE) >= 1.0E-7d) goto L27;
        boolean r119 = true;
    L29:
        if (r119 == true) goto L31;
        double r211 = r116 / r118;
        double r120 = r117 / r118;
        double r212 = ((r120 * 3.0d) - (r211 * r211)) / 9.0d;
        double r121 = (((((2.0d * r211) * r211) * r211) - ((9.0d * r211) * r120)) + ((r115 / r118) * 27.0d)) / 54.0d;
        double r122 = (r212 * r212) * r212;
        double r123 = (r121 * r121) + r122;
        double r124 = r211 / 3.0d;
        if (r123 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L121;
        double r125 = Math.sqrt(-r122);
        double r126 = (-r121) / r125;
        if (r126 >= (-1.0d)) goto L81;
        r126 = -1.0d;
    L81:
        if (r126 <= 1.0d) goto L83;
        r126 = 1.0d;
    L83:
        double r127 = Math.acos(r126);
        double r128 = b.a((float) r125) * 2.0f;
        float r129 = (float) ((Math.cos(r127 / 3.0d) * r128) - r124);
        if (r129 >= 0.0f) goto L89;
        if (r129 < (-8.34465E-7f)) goto L93;
        r129 = 0.0f;
    L95:
        if (Float.isNaN(r129) == true) goto L97;
    L96:
        float r130 = r129;
    L160:
        if (Float.isNaN(r130) == true) goto L170;
        float r131 = (r107 - r109) + 0.33333334f;
        float r132 = (((((r131 * r130) + (r109 - (2.0f * r107))) * r130) + r107) * 3.0f) * r130;
        float r133 = r110.f490148a;
        float r134 = r110.f490149b;
        if (r132 >= r133) goto L165;
        r132 = r133;
    L165:
        if (r132 > r134) goto L168;
        r134 = r132;
    L168:
        r102 = r134;
        goto L171
    L170:
        throw new IllegalArgumentException("The cubic curve with parameters (" + r106 + ", " + r107 + ", " + r108 + ", " + r109 + ") has no solution at " + r102);
    L97:
        r129 = (float) ((Math.cos((6.283185307179586d + r127) / 3.0d) * r128) - r124);
        if (r129 >= 0.0f) goto L103;
        if (r129 < (-8.34465E-7f)) goto L107;
        r129 = 0.0f;
    L109:
        if (Float.isNaN(r129) == false) goto L96;
        float r135 = (float) ((r128 * Math.cos((r127 + 12.566370614359172d) / 3.0d)) - r124);
        if (r135 >= 0.0f) goto L117;
        if (r135 >= (-8.34465E-7f)) goto L150;
    L156:
        float r136 = Float.NaN;
    L158:
        r130 = r136;
    L150:
        r136 = 0.0f;
        goto L158
    L117:
        if (r135 > 1.0f) goto L119;
    L157:
        r136 = r135;
        goto L158
    L119:
        if (r135 > 1.0000008f) goto L156;
    L155:
        r136 = 1.0f;
    L107:
        r129 = Float.NaN;
        goto L109
    L103:
        if (r129 <= 1.0f) goto L109;
        if (r129 > 1.0000008f) goto L107;
        r129 = 1.0f;
    L93:
        r129 = Float.NaN;
        goto L95
    L89:
        if (r129 <= 1.0f) goto L95;
        if (r129 > 1.0000008f) goto L93;
        r129 = 1.0f;
        goto L95
    L121:
        if (r123 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L146;
        float r137 = -b.a((float) r121);
        float r138 = (float) r124;
        r136 = (r137 * 2.0f) - r138;
        if (r136 >= 0.0f) goto L128;
        if (r136 < (-8.34465E-7f)) goto L132;
        r136 = 0.0f;
    L134:
        if (Float.isNaN(r136) == false) goto L158;
        r135 = (-r137) - r138;
        if (r135 >= 0.0f) goto L142;
        if (r135 < (-8.34465E-7f)) goto L156;
    L142:
        if (r135 <= 1.0f) goto L157;
        if (r135 > 1.0000008f) goto L156;
    L132:
        r136 = Float.NaN;
        goto L134
    L128:
        if (r136 <= 1.0f) goto L134;
        if (r136 > 1.0000008f) goto L132;
        r136 = 1.0f;
        goto L134
    L146:
        double r139 = Math.sqrt(r123);
        r135 = (float) (((double) (b.a((float) ((-r121) + r139)) - b.a((float) (r121 + r139)))) - r124);
        if (r135 >= 0.0f) goto L152;
        if (r135 < (-8.34465E-7f)) goto L156;
    L152:
        if (r135 <= 1.0f) goto L157;
        if (r135 > 1.0000008f) goto L156;
    L31:
        if (Math.abs(r116 - AudioStats.AUDIO_AMPLITUDE_NONE) >= 1.0E-7d) goto L33;
        boolean r140 = true;
    L34:
        if (r140 == true) goto L36;
        double r141 = Math.sqrt((r117 * r117) - ((4.0d * r116) * r115));
        double r142 = r116 * 2.0d;
        float r143 = (float) ((r141 - r117) / r142);
        if (r143 >= 0.0f) goto L57;
        if (r143 < (-8.34465E-7f)) goto L61;
        r143 = 0.0f;
    L63:
        if (Float.isNaN(r143) == true) goto L65;
        r130 = r143;
        goto L160
    L65:
        r135 = (float) (((-r117) - r141) / r142);
        if (r135 >= 0.0f) goto L71;
        if (r135 < (-8.34465E-7f)) goto L156;
    L71:
        if (r135 <= 1.0f) goto L157;
        if (r135 > 1.0000008f) goto L156;
    L61:
        r143 = Float.NaN;
        goto L63
    L57:
        if (r143 <= 1.0f) goto L63;
        if (r143 > 1.0000008f) goto L61;
        r143 = 1.0f;
        goto L63
    L36:
        if (Math.abs(r117 - AudioStats.AUDIO_AMPLITUDE_NONE) >= 1.0E-7d) goto L38;
        boolean r213 = true;
    L39:
        if (r213 == false) goto L41;
        r130 = Float.NaN;
        goto L160
    L41:
        r135 = (float) ((-r115) / r117);
        if (r135 >= 0.0f) goto L47;
        if (r135 < (-8.34465E-7f)) goto L156;
    L47:
        if (r135 <= 1.0f) goto L157;
        if (r135 > 1.0000008f) goto L156;
    L38:
        r213 = false;
        goto L39
    L33:
        r140 = false;
        goto L34
    L27:
        r119 = false;
        goto L29
    L174:
        throw new IllegalArgumentException("Easing values must contain exactly 4 floats for cubic bezier.".toString());
    L12:
        r105 = false;
        goto L13
    L5:
        r102 = r100 / (((long) r101) * 1000000);
        goto L6
    }

    @Override // gja.a
    public final /* bridge */ /* synthetic */ Float c(long r100, Float r101, Float r102, float r103) {
        return e(r100, r101.floatValue(), r102.floatValue());
    }

    @Override // gja.a
    public final float d(long r110, Float r111, Float r112, float r113) {
        float r114 = r111.floatValue();
        float r115 = r112.floatValue();
        long r116 = RangesKt.coerceIn(r110 - (((long) this.f485491b) * 1000000), 0, ((long) this.f485490a) * 1000000);
        if (r116 >= 0) goto L5;
        return 0.0f;
    L5:
        if (r116 == 0) goto L10;
        float r117 = e(r116 - 1000000, r114, r115).floatValue();
        return (e(r116, r114, r115).floatValue() - r117) * 1000.0f;
    L10:
        return r113;
    }
}
