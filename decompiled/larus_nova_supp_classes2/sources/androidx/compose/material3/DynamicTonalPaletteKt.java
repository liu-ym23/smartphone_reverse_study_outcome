package androidx.compose.material3;

import android.R;
import android.content.Context;
import android.os.Build;
import androidx.compose.material3.internal.colorUtil.Cam;
import androidx.compose.material3.internal.colorUtil.CamUtils;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001d\u0010\u0007\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0012"}, d2 = {"dynamicTonalPalette", "Landroidx/compose/material3/TonalPalette;", "context", "Landroid/content/Context;", "dynamicLightColorScheme", "Landroidx/compose/material3/ColorScheme;", "dynamicDarkColorScheme", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "", "setLuminance-DxMtmZc", "(JF)J", "dynamicLightColorScheme31", "tonalPalette", "dynamicLightColorScheme34", "dynamicDarkColorScheme31", "dynamicDarkColorScheme34", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DynamicTonalPaletteKt {
    public static final ColorScheme dynamicDarkColorScheme(Context r2) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        return dynamicDarkColorScheme34(r2);
    L6:
        return dynamicDarkColorScheme31(dynamicTonalPalette(r2));
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette r99) {
        long r0 = r99.m3498getPrimary800d7_KjU();
        long r2 = r99.m3492getPrimary200d7_KjU();
        long r4 = r99.m3493getPrimary300d7_KjU();
        long r6 = r99.m3499getPrimary900d7_KjU();
        long r8 = r99.m3494getPrimary400d7_KjU();
        long r10 = r99.m3511getSecondary800d7_KjU();
        long r12 = r99.m3505getSecondary200d7_KjU();
        long r14 = r99.m3506getSecondary300d7_KjU();
        long r16 = r99.m3512getSecondary900d7_KjU();
        long r18 = r99.m3524getTertiary800d7_KjU();
        long r20 = r99.m3518getTertiary200d7_KjU();
        long r22 = r99.m3519getTertiary300d7_KjU();
        long r24 = r99.m3525getTertiary900d7_KjU();
        long r26 = r99.m3477getNeutralVariant60d7_KjU();
        long r28 = r99.m3482getNeutralVariant900d7_KjU();
        long r30 = r99.m3477getNeutralVariant60d7_KjU();
        long r32 = r99.m3482getNeutralVariant900d7_KjU();
        long r34 = r99.m3473getNeutralVariant300d7_KjU();
        long r36 = r99.m3480getNeutralVariant800d7_KjU();
        long r40 = r99.m3482getNeutralVariant900d7_KjU();
        long r42 = r99.m3470getNeutralVariant200d7_KjU();
        long r52 = r99.m3478getNeutralVariant600d7_KjU();
        long r54 = r99.m3473getNeutralVariant300d7_KjU();
        long r56 = r99.m3465getNeutralVariant00d7_KjU();
        long r58 = r99.m3472getNeutralVariant240d7_KjU();
        long r70 = r99.m3477getNeutralVariant60d7_KjU();
        long r60 = r99.m3468getNeutralVariant120d7_KjU();
        long r62 = r99.m3469getNeutralVariant170d7_KjU();
        long r64 = r99.m3471getNeutralVariant220d7_KjU();
        long r66 = r99.m3466getNeutralVariant100d7_KjU();
        long r68 = r99.m3474getNeutralVariant40d7_KjU();
        return ColorSchemeKt.m2502darkColorScheme_VG5OTI$default(r0, r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r99.m3498getPrimary800d7_KjU(), r40, r42, 0, 0, 0, 0, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r99.m3499getPrimary900d7_KjU(), r99.m3498getPrimary800d7_KjU(), r99.m3490getPrimary100d7_KjU(), r99.m3493getPrimary300d7_KjU(), r99.m3512getSecondary900d7_KjU(), r99.m3511getSecondary800d7_KjU(), r99.m3503getSecondary100d7_KjU(), r99.m3506getSecondary300d7_KjU(), r99.m3525getTertiary900d7_KjU(), r99.m3524getTertiary800d7_KjU(), r99.m3516getTertiary100d7_KjU(), r99.m3519getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context r102) {
        ColorResourceHelper r1 = ColorResourceHelper.INSTANCE;
        long r3 = r1.m2439getColorWaAFU9c(r102, R.color.system_primary_dark);
        long r5 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_dark);
        long r7 = r1.m2439getColorWaAFU9c(r102, R.color.system_primary_container_dark);
        long r9 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_container_dark);
        long r11 = r1.m2439getColorWaAFU9c(r102, R.color.system_primary_light);
        long r13 = r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_dark);
        long r15 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_dark);
        long r17 = r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_container_dark);
        long r19 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_container_dark);
        long r21 = r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_dark);
        long r23 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_dark);
        long r25 = r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_container_dark);
        long r27 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_container_dark);
        long r29 = r1.m2439getColorWaAFU9c(r102, R.color.system_background_dark);
        long r31 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_background_dark);
        long r33 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_dark);
        long r35 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_surface_dark);
        long r37 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_variant_dark);
        long r39 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_surface_variant_dark);
        long r43 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_light);
        long r45 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_surface_light);
        long r55 = r1.m2439getColorWaAFU9c(r102, R.color.system_outline_dark);
        long r57 = r1.m2439getColorWaAFU9c(r102, R.color.system_outline_variant_dark);
        long r61 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_bright_dark);
        long r73 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_dim_dark);
        long r63 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_dark);
        long r65 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_high_dark);
        long r67 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_highest_dark);
        long r69 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_low_dark);
        long r71 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_lowest_dark);
        return ColorSchemeKt.m2502darkColorScheme_VG5OTI$default(r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r1.m2439getColorWaAFU9c(r102, R.color.system_primary_dark), r43, r45, 0, 0, 0, 0, r55, r57, 0, r61, r63, r65, r67, r69, r71, r73, r1.m2439getColorWaAFU9c(r102, R.color.system_primary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_primary_fixed_dim), r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_fixed_variant), r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_fixed_dim), r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_fixed_variant), r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_fixed_dim), r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed_variant), 331350016, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context r2) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        return dynamicLightColorScheme34(r2);
    L6:
        return dynamicLightColorScheme31(dynamicTonalPalette(r2));
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette r99) {
        long r0 = r99.m3494getPrimary400d7_KjU();
        long r2 = r99.m3491getPrimary1000d7_KjU();
        long r4 = r99.m3499getPrimary900d7_KjU();
        long r6 = r99.m3490getPrimary100d7_KjU();
        long r8 = r99.m3498getPrimary800d7_KjU();
        long r10 = r99.m3507getSecondary400d7_KjU();
        long r12 = r99.m3504getSecondary1000d7_KjU();
        long r14 = r99.m3512getSecondary900d7_KjU();
        long r16 = r99.m3503getSecondary100d7_KjU();
        long r18 = r99.m3520getTertiary400d7_KjU();
        long r20 = r99.m3517getTertiary1000d7_KjU();
        long r22 = r99.m3525getTertiary900d7_KjU();
        long r24 = r99.m3516getTertiary100d7_KjU();
        long r26 = r99.m3487getNeutralVariant980d7_KjU();
        long r28 = r99.m3466getNeutralVariant100d7_KjU();
        long r30 = r99.m3487getNeutralVariant980d7_KjU();
        long r32 = r99.m3466getNeutralVariant100d7_KjU();
        long r34 = r99.m3482getNeutralVariant900d7_KjU();
        long r36 = r99.m3473getNeutralVariant300d7_KjU();
        long r40 = r99.m3470getNeutralVariant200d7_KjU();
        long r42 = r99.m3485getNeutralVariant950d7_KjU();
        long r52 = r99.m3476getNeutralVariant500d7_KjU();
        long r54 = r99.m3480getNeutralVariant800d7_KjU();
        long r56 = r99.m3465getNeutralVariant00d7_KjU();
        long r58 = r99.m3487getNeutralVariant980d7_KjU();
        long r70 = r99.m3481getNeutralVariant870d7_KjU();
        long r60 = r99.m3484getNeutralVariant940d7_KjU();
        long r62 = r99.m3483getNeutralVariant920d7_KjU();
        long r64 = r99.m3482getNeutralVariant900d7_KjU();
        long r66 = r99.m3486getNeutralVariant960d7_KjU();
        long r68 = r99.m3467getNeutralVariant1000d7_KjU();
        return ColorSchemeKt.m2508lightColorScheme_VG5OTI$default(r0, r2, r4, r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r28, r30, r32, r34, r36, r99.m3494getPrimary400d7_KjU(), r40, r42, 0, 0, 0, 0, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r99.m3499getPrimary900d7_KjU(), r99.m3498getPrimary800d7_KjU(), r99.m3490getPrimary100d7_KjU(), r99.m3493getPrimary300d7_KjU(), r99.m3512getSecondary900d7_KjU(), r99.m3511getSecondary800d7_KjU(), r99.m3503getSecondary100d7_KjU(), r99.m3506getSecondary300d7_KjU(), r99.m3525getTertiary900d7_KjU(), r99.m3524getTertiary800d7_KjU(), r99.m3516getTertiary100d7_KjU(), r99.m3519getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context r102) {
        ColorResourceHelper r1 = ColorResourceHelper.INSTANCE;
        long r3 = r1.m2439getColorWaAFU9c(r102, R.color.system_primary_light);
        long r5 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_light);
        long r7 = r1.m2439getColorWaAFU9c(r102, R.color.system_primary_container_light);
        long r9 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_container_light);
        long r11 = r1.m2439getColorWaAFU9c(r102, R.color.system_primary_dark);
        long r13 = r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_light);
        long r15 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_light);
        long r17 = r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_container_light);
        long r19 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_container_light);
        long r21 = r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_light);
        long r23 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_light);
        long r25 = r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_container_light);
        long r27 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_container_light);
        long r29 = r1.m2439getColorWaAFU9c(r102, R.color.system_background_light);
        long r31 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_background_light);
        long r33 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_light);
        long r35 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_surface_light);
        long r37 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_variant_light);
        long r39 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_surface_variant_light);
        long r43 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_dark);
        long r45 = r1.m2439getColorWaAFU9c(r102, R.color.system_on_surface_dark);
        long r55 = r1.m2439getColorWaAFU9c(r102, R.color.system_outline_light);
        long r57 = r1.m2439getColorWaAFU9c(r102, R.color.system_outline_variant_light);
        long r61 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_bright_light);
        long r73 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_dim_light);
        long r63 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_light);
        long r65 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_high_light);
        long r67 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_highest_light);
        long r69 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_low_light);
        long r71 = r1.m2439getColorWaAFU9c(r102, R.color.system_surface_container_lowest_light);
        return ColorSchemeKt.m2508lightColorScheme_VG5OTI$default(r3, r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r1.m2439getColorWaAFU9c(r102, R.color.system_primary_light), r43, r45, 0, 0, 0, 0, r55, r57, 0, r61, r63, r65, r67, r69, r71, r73, r1.m2439getColorWaAFU9c(r102, R.color.system_primary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_primary_fixed_dim), r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_on_primary_fixed_variant), r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_secondary_fixed_dim), r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_on_secondary_fixed_variant), r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_tertiary_fixed_dim), r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed), r1.m2439getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed_variant), 331350016, 0, null);
    }

    public static final TonalPalette dynamicTonalPalette(Context r183) {
        ColorResourceHelper r14 = ColorResourceHelper.INSTANCE;
        return new TonalPalette(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_0), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_10), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 98.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 96.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_50), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 94.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 92.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_100), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 87.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_200), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_300), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_400), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_500), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_700), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 24.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 22.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_800), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 17.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 12.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_900), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 6.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_600), 4.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral1_1000), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_0), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_10), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 98.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 96.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_50), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 94.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 92.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_100), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 87.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_200), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_300), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_400), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_500), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_700), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 24.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 22.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_800), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 17.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 12.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_900), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 6.0f), m2647setLuminanceDxMtmZc(r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_600), 4.0f), r14.m2439getColorWaAFU9c(r183, R.color.system_neutral2_1000), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_0), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_10), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_50), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_100), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_200), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_300), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_400), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_500), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_600), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_700), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_800), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_900), r14.m2439getColorWaAFU9c(r183, R.color.system_accent1_1000), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_0), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_10), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_50), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_100), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_200), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_300), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_400), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_500), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_600), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_700), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_800), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_900), r14.m2439getColorWaAFU9c(r183, R.color.system_accent2_1000), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_0), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_10), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_50), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_100), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_200), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_300), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_400), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_500), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_600), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_700), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_800), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_900), r14.m2439getColorWaAFU9c(r183, R.color.system_accent3_1000), null);
    }

    /* JADX INFO: renamed from: setLuminance-DxMtmZc, reason: not valid java name */
    public static final long m2647setLuminanceDxMtmZc(long r8, float r10) {
        double r0 = r10;
        boolean r4 = true;
        if (r0 >= 1.0E-4d) goto L5;
        boolean r2 = true;
    L7:
        if (r0 > 99.9999d) goto L11;
        r4 = false;
    L11:
        if ((r2 | r4) == true) goto L13;
        Cam.Companion r1 = Cam.Companion;
        Cam r9 = r1.fromInt(ColorKt.toArgb-8_81llA(r8));
        return ColorKt.Color(r1.getInt(r9.getHue(), r9.getChroma(), r10));
    L13:
        return ColorKt.Color(CamUtils.INSTANCE.argbFromLstar(r0));
    L5:
        r2 = false;
        goto L7
    }
}
