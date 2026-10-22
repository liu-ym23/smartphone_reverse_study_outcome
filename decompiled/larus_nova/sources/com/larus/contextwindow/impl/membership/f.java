package com.larus.contextwindow.impl.membership;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f330384a = null;

    static {
        f330384a = new f();
    }

    public f() {
    }

    public static MembershipQuotaBarTier a(double r100) {
        if (r100 < 100.0d) goto L6;
        return MembershipQuotaBarTier.NEUTRAL;
    L6:
        if (r100 < 90.0d) goto L9;
        return MembershipQuotaBarTier.DANGER;
    L9:
        if (r100 < 75.0d) goto L12;
        return MembershipQuotaBarTier.WARNING;
    L12:
        if (r100 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
        return MembershipQuotaBarTier.PRIMARY;
    L15:
        return MembershipQuotaBarTier.EMPTY;
    }

    public static Double b(JsonElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonNull() == false) goto L8;
        r100 = null;
    L8:
        if (r100 != null) goto L10;
        return null;
    L10:
        if (r100.isJsonPrimitive() == true) goto L13;
        r100 = null;
    L13:
        if (r100 == null) goto L41;
        JsonPrimitive r101 = r100.getAsJsonPrimitive();
        if (r101 != null) goto L17;
        return null;
    L17:
        if (r101.isBoolean() == false) goto L37;
        return null;
    L37:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        Object r103 = Result.m9449constructorimpl(Double.valueOf(CastDoubleProtector.parseDouble(StringsKt.trim(r101.getAsString()).toString())));     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r103) == false) goto L26;
        r103 = null;
    L26:
        Double r104 = (Double) r103;
        if (r104 == null) goto L43;
        double r105 = r104.doubleValue();
        if (Double.isInfinite(r105) == false) goto L31;
    L33:
        boolean r106 = false;
    L34:
        if (r106 == true) goto L36;
        return null;
    L36:
        return r104;
    L31:
        if (Double.isNaN(r105) == true) goto L33;
        r106 = true;
        goto L34
    L43:
        return null;
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L41:
        return null;
    }

    public static Integer c(JsonElement r100) {
        Double r101 = b(r100);
        if (r101 == null) goto L16;
        double r102 = r101.doubleValue();
        if ((r102 % 1.0d) != AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        return null;
    L10:
        if (r102 >= (-2.147483648E9d)) goto L12;
        return null;
    L12:
        if (r102 <= 2.147483647E9d) goto L15;
        return null;
    L15:
        return Integer.valueOf((int) r102);
    L7:
        r103 = false;
        goto L8
    L16:
        return null;
    }

    public static z29.d d(Double r110, boolean r111, boolean r112, boolean r113, String r114, String r115) {
        boolean r100 = false;
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r110 == null) goto L15;
        double r102 = r110.doubleValue();
        if (Double.isInfinite(r102) == false) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        Double r104 = r110;
    L13:
        if (r104 == null) goto L15;
        double r105 = RangesKt.coerceIn(r104.doubleValue(), AudioStats.AUDIO_AMPLITUDE_NONE, 100.0d);
    L16:
        if (r111 == false) goto L20;
        double r106 = 0.5d;
        if (r105 >= 0.5d) goto L20;
    L22:
        if (r112 == false) goto L25;
        if (r113 == true) goto L25;
        r106 = 100.0d;
    L25:
        if (r113 == true) goto L29;
        r101 = r106;
    L29:
        if (r113 == true) goto L34;
        if (r112 == false) goto L32;
    L33:
        boolean r116 = true;
    L35:
        if (r114 != null) goto L37;
    L40:
        boolean r117 = true;
    L41:
        if (r117 == true) goto L49;
        if (r115 != null) goto L44;
    L45:
        r100 = true;
    L46:
        if (r100 == true) goto L49;
        z29.a r118 = new z29.a(r114, r115);
    L51:
        return new z29.d(r105, r101, r111, r116, r113, r118);
    L44:
        if (StringsKt.isBlank(r115) == false) goto L46;
    L49:
        r118 = null;
        goto L51
    L37:
        if (StringsKt.isBlank(r114) == true) goto L40;
        r117 = false;
        goto L41
    L32:
        if (r105 >= 100.0d) goto L33;
    L34:
        r116 = false;
    L20:
        r106 = r105;
        goto L22
    L12:
        r104 = null;
        goto L13
    L7:
        if (Double.isNaN(r102) == true) goto L9;
        r103 = true;
    L15:
        r105 = 0.0d;
        goto L16
    }
}
