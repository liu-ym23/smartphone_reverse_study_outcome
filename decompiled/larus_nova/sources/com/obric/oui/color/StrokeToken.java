package com.obric.oui.color;

import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bH\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bT\u0010\u001aJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J&\u0010\u000b\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J2\u0010\u000e\u001a\u00020\u00052\u001e\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r0\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J \u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0007R\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0013R,\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010\u0016\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010 \u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0013R,\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010\u0016\u0012\u0004\b$\u0010\u001a\u001a\u0004\b#\u0010\u0018R\u0014\u0010%\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0013R\u0014\u0010&\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0013R,\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b'\u0010\u0016\u0012\u0004\b)\u0010\u001a\u001a\u0004\b(\u0010\u0018R\u0014\u0010*\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0013R\u0014\u0010,\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0013R\u0014\u0010-\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0013R,\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b.\u0010\u0016\u0012\u0004\b0\u0010\u001a\u001a\u0004\b/\u0010\u0018R\u0014\u00101\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0013R\u0014\u00102\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0013R,\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b3\u0010\u0016\u0012\u0004\b5\u0010\u001a\u001a\u0004\b4\u0010\u0018R\u0014\u00106\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0013R\u0014\u00107\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0013R,\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b8\u0010\u0016\u0012\u0004\b:\u0010\u001a\u001a\u0004\b9\u0010\u0018R\u0014\u0010;\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0013R\u0014\u0010<\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0013R,\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u0010\u0016\u0012\u0004\b?\u0010\u001a\u001a\u0004\b>\u0010\u0018R\u0014\u0010@\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0013R\u0014\u0010A\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0013R,\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bB\u0010\u0016\u0012\u0004\bD\u0010\u001a\u001a\u0004\bC\u0010\u0018R\u0014\u0010E\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0013R\u0014\u0010F\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0013R,\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bG\u0010\u0016\u0012\u0004\bI\u0010\u001a\u001a\u0004\bH\u0010\u0018R\u0014\u0010J\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0013R\u0014\u0010K\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0013R,\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bL\u0010\u0016\u0012\u0004\bN\u0010\u001a\u001a\u0004\bM\u0010\u0018R\u0014\u0010O\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0013R\u0014\u0010P\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0013R,\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bQ\u0010\u0016\u0012\u0004\bS\u0010\u001a\u001a\u0004\bR\u0010\u0018¨\u0006U"}, d2 = {"Lcom/obric/oui/color/StrokeToken;", "", "customTokenOwner", "", "overrideExisting", "", MiPushClient.COMMAND_REGISTER, "", "", "Lcom/obric/oui/color/i0;", "customTokens", "registerTokens", "registerProvider", "Lkotlin/Function1;", "registerProviderTokens", "name", "parse", "isLight", "OUI_Effect_Stroke_Regular_Light", "Lcom/obric/oui/color/i0;", "OUI_Effect_Stroke_Regular_Dark", "OUI_Effect_Stroke_Regular", "Lkotlin/jvm/functions/Function1;", "getOUI_Effect_Stroke_Regular", "()Lkotlin/jvm/functions/Function1;", "getOUI_Effect_Stroke_Regular$annotations", "()V", "OUI_Effect_Stroke_UltraThin_Light", "OUI_Effect_Stroke_UltraThin_Dark", "OUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin", "getOUI_Effect_Stroke_UltraThin$annotations", "OUI_Effect_Stroke_Thin_Light", "OUI_Effect_Stroke_Thin_Dark", "OUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin", "getOUI_Effect_Stroke_Thin$annotations", "OUI_Effect_Stroke_Thick_Light", "OUI_Effect_Stroke_Thick_Dark", "OUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick", "getOUI_Effect_Stroke_Thick$annotations", "OUI_Effect_Stroke_Tinted_Light", "OUI_Effect_Stroke_Tinted_Dark", "OUI_Effect_Stroke_Blue_Regular_Light", "OUI_Effect_Stroke_Blue_Regular_Dark", "OUI_Effect_Stroke_Blue_Regular", "getOUI_Effect_Stroke_Blue_Regular", "getOUI_Effect_Stroke_Blue_Regular$annotations", "OUI_Effect_Stroke_Blue_Thin_Light", "OUI_Effect_Stroke_Blue_Thin_Dark", "OUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin", "getOUI_Effect_Stroke_Blue_Thin$annotations", "OUI_Effect_Stroke_Red_Regular_Light", "OUI_Effect_Stroke_Red_Regular_Dark", "OUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular", "getOUI_Effect_Stroke_Red_Regular$annotations", "OUI_Effect_Stroke_Red_Thin_Light", "OUI_Effect_Stroke_Red_Thin_Dark", "OUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin", "getOUI_Effect_Stroke_Red_Thin$annotations", "OUI_Effect_Stroke_Green_Regular_Light", "OUI_Effect_Stroke_Green_Regular_Dark", "OUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular", "getOUI_Effect_Stroke_Green_Regular$annotations", "OUI_Effect_Stroke_Green_Thin_Light", "OUI_Effect_Stroke_Green_Thin_Dark", "OUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin", "getOUI_Effect_Stroke_Green_Thin$annotations", "OUI_Effect_Stroke_Yellow_Regular_Light", "OUI_Effect_Stroke_Yellow_Regular_Dark", "OUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular", "getOUI_Effect_Stroke_Yellow_Regular$annotations", "OUI_Effect_Stroke_Yellow_Thin_Light", "OUI_Effect_Stroke_Yellow_Thin_Dark", "OUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin", "getOUI_Effect_Stroke_Yellow_Thin$annotations", "<init>", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class StrokeToken {
    public static final StrokeToken INSTANCE = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Blue_Regular = null;
    public static final i0 OUI_Effect_Stroke_Blue_Regular_Dark = null;
    public static final i0 OUI_Effect_Stroke_Blue_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Blue_Thin = null;
    public static final i0 OUI_Effect_Stroke_Blue_Thin_Dark = null;
    public static final i0 OUI_Effect_Stroke_Blue_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Green_Regular = null;
    public static final i0 OUI_Effect_Stroke_Green_Regular_Dark = null;
    public static final i0 OUI_Effect_Stroke_Green_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Green_Thin = null;
    public static final i0 OUI_Effect_Stroke_Green_Thin_Dark = null;
    public static final i0 OUI_Effect_Stroke_Green_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Red_Regular = null;
    public static final i0 OUI_Effect_Stroke_Red_Regular_Dark = null;
    public static final i0 OUI_Effect_Stroke_Red_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Red_Thin = null;
    public static final i0 OUI_Effect_Stroke_Red_Thin_Dark = null;
    public static final i0 OUI_Effect_Stroke_Red_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Regular = null;
    public static final i0 OUI_Effect_Stroke_Regular_Dark = null;
    public static final i0 OUI_Effect_Stroke_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Thick = null;
    public static final i0 OUI_Effect_Stroke_Thick_Dark = null;
    public static final i0 OUI_Effect_Stroke_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Thin = null;
    public static final i0 OUI_Effect_Stroke_Thin_Dark = null;
    public static final i0 OUI_Effect_Stroke_Thin_Light = null;
    public static final i0 OUI_Effect_Stroke_Tinted_Dark = null;
    public static final i0 OUI_Effect_Stroke_Tinted_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_UltraThin = null;
    public static final i0 OUI_Effect_Stroke_UltraThin_Dark = null;
    public static final i0 OUI_Effect_Stroke_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Yellow_Regular = null;
    public static final i0 OUI_Effect_Stroke_Yellow_Regular_Dark = null;
    public static final i0 OUI_Effect_Stroke_Yellow_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, i0> OUI_Effect_Stroke_Yellow_Thin = null;
    public static final i0 OUI_Effect_Stroke_Yellow_Thin_Dark = null;
    public static final i0 OUI_Effect_Stroke_Yellow_Thin_Light = null;

    private StrokeToken() {
    }

    public static /* synthetic */ j0 a(kotlin.jvm.functions.Function1 r100, Boolean r101) {
        return m8581registerProviderTokens$lambda2$lambda1(r100, r101);
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Blue_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Green_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Red_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thick$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Thin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_UltraThin$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Regular$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Effect_Stroke_Yellow_Thin$annotations() {
    }

    static {
        INSTANCE = new StrokeToken();
        OUI_Effect_Stroke_Regular_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Regular_Light);
        OUI_Effect_Stroke_Regular_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Regular_Dark);
        OUI_Effect_Stroke_Regular = StrokeToken$OUI_Effect_Stroke_Regular$1.INSTANCE;
        OUI_Effect_Stroke_UltraThin_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Light);
        OUI_Effect_Stroke_UltraThin_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_UltraThin_Dark);
        OUI_Effect_Stroke_UltraThin = StrokeToken$OUI_Effect_Stroke_UltraThin$1.INSTANCE;
        OUI_Effect_Stroke_Thin_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Thin_Light);
        OUI_Effect_Stroke_Thin_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Thin_Dark);
        OUI_Effect_Stroke_Thin = StrokeToken$OUI_Effect_Stroke_Thin$1.INSTANCE;
        OUI_Effect_Stroke_Thick_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Thick_Light);
        OUI_Effect_Stroke_Thick_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Thick_Dark);
        OUI_Effect_Stroke_Thick = StrokeToken$OUI_Effect_Stroke_Thick$1.INSTANCE;
        OUI_Effect_Stroke_Tinted_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Tinted_Light);
        OUI_Effect_Stroke_Tinted_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Tinted_Dark);
        OUI_Effect_Stroke_Blue_Regular_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Light);
        OUI_Effect_Stroke_Blue_Regular_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Blue_Regular_Dark);
        OUI_Effect_Stroke_Blue_Regular = StrokeToken$OUI_Effect_Stroke_Blue_Regular$1.INSTANCE;
        OUI_Effect_Stroke_Blue_Thin_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Light);
        OUI_Effect_Stroke_Blue_Thin_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Blue_Thin_Dark);
        OUI_Effect_Stroke_Blue_Thin = StrokeToken$OUI_Effect_Stroke_Blue_Thin$1.INSTANCE;
        OUI_Effect_Stroke_Red_Regular_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Light);
        OUI_Effect_Stroke_Red_Regular_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Red_Regular_Dark);
        OUI_Effect_Stroke_Red_Regular = StrokeToken$OUI_Effect_Stroke_Red_Regular$1.INSTANCE;
        OUI_Effect_Stroke_Red_Thin_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Light);
        OUI_Effect_Stroke_Red_Thin_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Red_Thin_Dark);
        OUI_Effect_Stroke_Red_Thin = StrokeToken$OUI_Effect_Stroke_Red_Thin$1.INSTANCE;
        OUI_Effect_Stroke_Green_Regular_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Light);
        OUI_Effect_Stroke_Green_Regular_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Green_Regular_Dark);
        OUI_Effect_Stroke_Green_Regular = StrokeToken$OUI_Effect_Stroke_Green_Regular$1.INSTANCE;
        OUI_Effect_Stroke_Green_Thin_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Light);
        OUI_Effect_Stroke_Green_Thin_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Green_Thin_Dark);
        OUI_Effect_Stroke_Green_Thin = StrokeToken$OUI_Effect_Stroke_Green_Thin$1.INSTANCE;
        OUI_Effect_Stroke_Yellow_Regular_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Light);
        OUI_Effect_Stroke_Yellow_Regular_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Yellow_Regular_Dark);
        OUI_Effect_Stroke_Yellow_Regular = StrokeToken$OUI_Effect_Stroke_Yellow_Regular$1.INSTANCE;
        OUI_Effect_Stroke_Yellow_Thin_Light = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Light);
        OUI_Effect_Stroke_Yellow_Thin_Dark = k0.a(StrokeTokenCore.OUI_Effect_Stroke_Yellow_Thin_Dark);
        OUI_Effect_Stroke_Yellow_Thin = StrokeToken$OUI_Effect_Stroke_Yellow_Thin$1.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Blue_Regular() {
        return OUI_Effect_Stroke_Blue_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Blue_Thin() {
        return OUI_Effect_Stroke_Blue_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Green_Regular() {
        return OUI_Effect_Stroke_Green_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Green_Thin() {
        return OUI_Effect_Stroke_Green_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Red_Regular() {
        return OUI_Effect_Stroke_Red_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Red_Thin() {
        return OUI_Effect_Stroke_Red_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Regular() {
        return OUI_Effect_Stroke_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Thick() {
        return OUI_Effect_Stroke_Thick;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Thin() {
        return OUI_Effect_Stroke_Thin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_UltraThin() {
        return OUI_Effect_Stroke_UltraThin;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Yellow_Regular() {
        return OUI_Effect_Stroke_Yellow_Regular;
    }

    public static final kotlin.jvm.functions.Function1<Boolean, i0> getOUI_Effect_Stroke_Yellow_Thin() {
        return OUI_Effect_Stroke_Yellow_Thin;
    }

    @JvmStatic
    public static final kotlin.jvm.functions.Function1<Boolean, i0> parse(String r100) {
        final Function1<Boolean, j0> r101 = StrokeTokenCore.parseProvider(INSTANCE, r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new AnonymousClass1(r101);
    }

    @JvmStatic
    public static final i0 parse(String r100, boolean r101) {
        j0 r102 = StrokeTokenCore.parse(INSTANCE, r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        return k0.a(r102);
    }

    @JvmStatic
    public static final void register(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokenOwner");
        StrokeTokenCore.register(INSTANCE, r100, r101);
    }

    @JvmStatic
    public static final void registerProvider(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokenOwner");
        StrokeTokenCore.registerProvider(INSTANCE, r100, r101);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, i0>> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokens");
        StrokeToken r102 = INSTANCE;
        LinkedHashMap r103 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        Object r106 = r105.getKey();
        final kotlin.jvm.functions.Function1 r107 = (kotlin.jvm.functions.Function1) r105.getValue();
        r103.put(r106, new l0(r107));
        goto L4
    L6:
        StrokeTokenCore.registerProviderTokens(r102, r103, r101);
    }

    /* JADX INFO: renamed from: registerProviderTokens$lambda-2$lambda-1, reason: not valid java name */
    private static final j0 m8581registerProviderTokens$lambda2$lambda1(kotlin.jvm.functions.Function1 r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$provider");
        return ((i0) r100.invoke(r101)).a();
    }

    @JvmStatic
    public static final void registerTokens(Map<String, i0> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokens");
        StrokeToken r102 = INSTANCE;
        LinkedHashMap r103 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put(r105.getKey(), ((i0) r105.getValue()).a());
        goto L4
    L6:
        StrokeTokenCore.registerTokens(r102, r103, r101);
    }

    public static /* synthetic */ void register$default(Object r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        register(r100, r101);
    }

    public static /* synthetic */ void registerProvider$default(Object r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        registerProvider(r100, r101);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        registerProviderTokens(r100, r101);
    }

    public static /* synthetic */ void registerTokens$default(Map r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        registerTokens(r100, r101);
    }
}
