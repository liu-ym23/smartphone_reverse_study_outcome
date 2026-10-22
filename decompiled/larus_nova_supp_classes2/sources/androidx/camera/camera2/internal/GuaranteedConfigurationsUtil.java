package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class GuaranteedConfigurationsUtil {
    public static List<SurfaceCombination> get10BitSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        SurfaceConfig.ConfigType r5 = SurfaceConfig.ConfigType.YUV;
        r4.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r4);
        SurfaceCombination r6 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r7 = SurfaceConfig.ConfigSize.PREVIEW;
        r6.addSurfaceConfig(SurfaceConfig.create(r2, r7));
        SurfaceConfig.ConfigType r8 = SurfaceConfig.ConfigType.JPEG;
        r6.addSurfaceConfig(SurfaceConfig.create(r8, r3));
        r0.add(r6);
        SurfaceCombination r9 = new SurfaceCombination();
        r9.addSurfaceConfig(SurfaceConfig.create(r2, r7));
        r9.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r9);
        SurfaceCombination r10 = new SurfaceCombination();
        r10.addSurfaceConfig(SurfaceConfig.create(r5, r7));
        r10.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r10);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r7));
        SurfaceConfig.ConfigSize r12 = SurfaceConfig.ConfigSize.RECORD;
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r12));
        r0.add(r11);
        SurfaceCombination r13 = new SurfaceCombination();
        r13.addSurfaceConfig(SurfaceConfig.create(r2, r7));
        r13.addSurfaceConfig(SurfaceConfig.create(r2, r12));
        r13.addSurfaceConfig(SurfaceConfig.create(r5, r12));
        r0.add(r13);
        SurfaceCombination r14 = new SurfaceCombination();
        r14.addSurfaceConfig(SurfaceConfig.create(r2, r7));
        r14.addSurfaceConfig(SurfaceConfig.create(r2, r12));
        r14.addSurfaceConfig(SurfaceConfig.create(r8, r12));
        r0.add(r14);
        return r0;
    }

    public static List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.PREVIEW;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigSize r4 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r4));
        r0.add(r1);
        SurfaceCombination r5 = new SurfaceCombination();
        r5.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigType r6 = SurfaceConfig.ConfigType.YUV;
        r5.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r5);
        SurfaceCombination r7 = new SurfaceCombination();
        r7.addSurfaceConfig(SurfaceConfig.create(r6, r3));
        r7.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r7);
        return r0;
    }

    public static List<SurfaceCombination> getConcurrentSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.s1440p;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        SurfaceConfig.ConfigType r5 = SurfaceConfig.ConfigType.PRIV;
        r4.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r4);
        SurfaceCombination r6 = new SurfaceCombination();
        SurfaceConfig.ConfigType r7 = SurfaceConfig.ConfigType.JPEG;
        r6.addSurfaceConfig(SurfaceConfig.create(r7, r3));
        r0.add(r6);
        SurfaceCombination r8 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r9 = SurfaceConfig.ConfigSize.s720p;
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r8.addSurfaceConfig(SurfaceConfig.create(r7, r3));
        r0.add(r8);
        SurfaceCombination r10 = new SurfaceCombination();
        r10.addSurfaceConfig(SurfaceConfig.create(r5, r9));
        r10.addSurfaceConfig(SurfaceConfig.create(r7, r3));
        r0.add(r10);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r11);
        SurfaceCombination r12 = new SurfaceCombination();
        r12.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r12.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r12);
        SurfaceCombination r13 = new SurfaceCombination();
        r13.addSurfaceConfig(SurfaceConfig.create(r5, r9));
        r13.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r13);
        SurfaceCombination r14 = new SurfaceCombination();
        r14.addSurfaceConfig(SurfaceConfig.create(r5, r9));
        r14.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r14);
        return r0;
    }

    public static List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.PREVIEW;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigSize r4 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r4));
        r0.add(r1);
        SurfaceCombination r5 = new SurfaceCombination();
        r5.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigType r6 = SurfaceConfig.ConfigType.YUV;
        r5.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r5);
        SurfaceCombination r7 = new SurfaceCombination();
        r7.addSurfaceConfig(SurfaceConfig.create(r6, r3));
        r7.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r7);
        SurfaceCombination r8 = new SurfaceCombination();
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, r4));
        r0.add(r8);
        SurfaceCombination r9 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r10 = SurfaceConfig.ConfigSize.VGA;
        r9.addSurfaceConfig(SurfaceConfig.create(r6, r10));
        r9.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r9.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r9);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r6, r10));
        r11.addSurfaceConfig(SurfaceConfig.create(r6, r3));
        r11.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r11);
        return r0;
    }

    public static List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        SurfaceConfig.ConfigType r5 = SurfaceConfig.ConfigType.JPEG;
        r4.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r4);
        SurfaceCombination r6 = new SurfaceCombination();
        SurfaceConfig.ConfigType r7 = SurfaceConfig.ConfigType.YUV;
        r6.addSurfaceConfig(SurfaceConfig.create(r7, r3));
        r0.add(r6);
        SurfaceCombination r8 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r9 = SurfaceConfig.ConfigSize.PREVIEW;
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r8.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r8);
        SurfaceCombination r10 = new SurfaceCombination();
        r10.addSurfaceConfig(SurfaceConfig.create(r7, r9));
        r10.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r10);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r0.add(r11);
        SurfaceCombination r12 = new SurfaceCombination();
        r12.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r12.addSurfaceConfig(SurfaceConfig.create(r7, r9));
        r0.add(r12);
        SurfaceCombination r13 = new SurfaceCombination();
        r13.addSurfaceConfig(SurfaceConfig.create(r2, r9));
        r13.addSurfaceConfig(SurfaceConfig.create(r7, r9));
        r13.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r13);
        return r0;
    }

    public static List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.PREVIEW;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigSize r4 = SurfaceConfig.ConfigSize.VGA;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r4));
        SurfaceConfig.ConfigType r5 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize r6 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r5, r6));
        SurfaceConfig.ConfigType r7 = SurfaceConfig.ConfigType.RAW;
        r1.addSurfaceConfig(SurfaceConfig.create(r7, r6));
        r0.add(r1);
        SurfaceCombination r8 = new SurfaceCombination();
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r4));
        r8.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.JPEG, r6));
        r8.addSurfaceConfig(SurfaceConfig.create(r7, r6));
        r0.add(r8);
        return r0;
    }

    public static List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.PREVIEW;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigSize r4 = SurfaceConfig.ConfigSize.RECORD;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r4));
        r0.add(r1);
        SurfaceCombination r5 = new SurfaceCombination();
        r5.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigType r6 = SurfaceConfig.ConfigType.YUV;
        r5.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r5);
        SurfaceCombination r7 = new SurfaceCombination();
        r7.addSurfaceConfig(SurfaceConfig.create(r6, r3));
        r7.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r0.add(r7);
        SurfaceCombination r8 = new SurfaceCombination();
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r8.addSurfaceConfig(SurfaceConfig.create(r2, r4));
        SurfaceConfig.ConfigType r9 = SurfaceConfig.ConfigType.JPEG;
        r8.addSurfaceConfig(SurfaceConfig.create(r9, r4));
        r0.add(r8);
        SurfaceCombination r10 = new SurfaceCombination();
        r10.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r10.addSurfaceConfig(SurfaceConfig.create(r6, r4));
        r10.addSurfaceConfig(SurfaceConfig.create(r9, r4));
        r0.add(r10);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r6, r3));
        r11.addSurfaceConfig(SurfaceConfig.create(r6, r3));
        r11.addSurfaceConfig(SurfaceConfig.create(r9, SurfaceConfig.ConfigSize.MAXIMUM));
        r0.add(r11);
        return r0;
    }

    public static List<SurfaceCombination> getPreviewStabilizationSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.s1440p;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        SurfaceConfig.ConfigType r5 = SurfaceConfig.ConfigType.YUV;
        r4.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r4);
        SurfaceCombination r6 = new SurfaceCombination();
        r6.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigType r7 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize r8 = SurfaceConfig.ConfigSize.MAXIMUM;
        r6.addSurfaceConfig(SurfaceConfig.create(r7, r8));
        r0.add(r6);
        SurfaceCombination r9 = new SurfaceCombination();
        r9.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r9.addSurfaceConfig(SurfaceConfig.create(r7, r8));
        r0.add(r9);
        SurfaceCombination r10 = new SurfaceCombination();
        r10.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r10.addSurfaceConfig(SurfaceConfig.create(r5, r8));
        r0.add(r10);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r11.addSurfaceConfig(SurfaceConfig.create(r5, r8));
        r0.add(r11);
        SurfaceCombination r12 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r13 = SurfaceConfig.ConfigSize.PREVIEW;
        r12.addSurfaceConfig(SurfaceConfig.create(r2, r13));
        r12.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r12);
        SurfaceCombination r14 = new SurfaceCombination();
        r14.addSurfaceConfig(SurfaceConfig.create(r5, r13));
        r14.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r14);
        SurfaceCombination r15 = new SurfaceCombination();
        r15.addSurfaceConfig(SurfaceConfig.create(r2, r13));
        r15.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r15);
        SurfaceCombination r16 = new SurfaceCombination();
        r16.addSurfaceConfig(SurfaceConfig.create(r5, r13));
        r16.addSurfaceConfig(SurfaceConfig.create(r5, r3));
        r0.add(r16);
        return r0;
    }

    public static List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        SurfaceConfig.ConfigType r5 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r6 = SurfaceConfig.ConfigSize.PREVIEW;
        r4.addSurfaceConfig(SurfaceConfig.create(r5, r6));
        r4.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r4);
        SurfaceCombination r7 = new SurfaceCombination();
        SurfaceConfig.ConfigType r8 = SurfaceConfig.ConfigType.YUV;
        r7.addSurfaceConfig(SurfaceConfig.create(r8, r6));
        r7.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r7);
        SurfaceCombination r9 = new SurfaceCombination();
        r9.addSurfaceConfig(SurfaceConfig.create(r5, r6));
        r9.addSurfaceConfig(SurfaceConfig.create(r5, r6));
        r9.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r9);
        SurfaceCombination r10 = new SurfaceCombination();
        r10.addSurfaceConfig(SurfaceConfig.create(r5, r6));
        r10.addSurfaceConfig(SurfaceConfig.create(r8, r6));
        r10.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r10);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r8, r6));
        r11.addSurfaceConfig(SurfaceConfig.create(r8, r6));
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r11);
        SurfaceCombination r12 = new SurfaceCombination();
        r12.addSurfaceConfig(SurfaceConfig.create(r5, r6));
        SurfaceConfig.ConfigType r13 = SurfaceConfig.ConfigType.JPEG;
        r12.addSurfaceConfig(SurfaceConfig.create(r13, r3));
        r12.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r12);
        SurfaceCombination r14 = new SurfaceCombination();
        r14.addSurfaceConfig(SurfaceConfig.create(r8, r6));
        r14.addSurfaceConfig(SurfaceConfig.create(r13, r3));
        r14.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r14);
        return r0;
    }

    public static List<SurfaceCombination> getStreamUseCaseSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.s1440p;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3, 4));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        SurfaceConfig.ConfigType r6 = SurfaceConfig.ConfigType.YUV;
        r4.addSurfaceConfig(SurfaceConfig.create(r6, r3, 4));
        r0.add(r4);
        SurfaceCombination r5 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r7 = SurfaceConfig.ConfigSize.RECORD;
        r5.addSurfaceConfig(SurfaceConfig.create(r2, r7, 3));
        r0.add(r5);
        SurfaceCombination r8 = new SurfaceCombination();
        r8.addSurfaceConfig(SurfaceConfig.create(r6, r7, 3));
        r0.add(r8);
        SurfaceCombination r9 = new SurfaceCombination();
        SurfaceConfig.ConfigType r10 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize r11 = SurfaceConfig.ConfigSize.MAXIMUM;
        r9.addSurfaceConfig(SurfaceConfig.create(r10, r11, 2));
        r0.add(r9);
        SurfaceCombination r12 = new SurfaceCombination();
        r12.addSurfaceConfig(SurfaceConfig.create(r6, r11, 2));
        r0.add(r12);
        SurfaceCombination r13 = new SurfaceCombination();
        SurfaceConfig.ConfigSize r14 = SurfaceConfig.ConfigSize.PREVIEW;
        r13.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r13.addSurfaceConfig(SurfaceConfig.create(r10, r11, 2));
        r0.add(r13);
        SurfaceCombination r15 = new SurfaceCombination();
        r15.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r15.addSurfaceConfig(SurfaceConfig.create(r6, r11, 2));
        r0.add(r15);
        SurfaceCombination r16 = new SurfaceCombination();
        r16.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r16.addSurfaceConfig(SurfaceConfig.create(r2, r7, 3));
        r0.add(r16);
        SurfaceCombination r17 = new SurfaceCombination();
        r17.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r17.addSurfaceConfig(SurfaceConfig.create(r6, r7, 3));
        r0.add(r17);
        SurfaceCombination r18 = new SurfaceCombination();
        r18.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r18.addSurfaceConfig(SurfaceConfig.create(r6, r14, 1));
        r0.add(r18);
        SurfaceCombination r19 = new SurfaceCombination();
        r19.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r19.addSurfaceConfig(SurfaceConfig.create(r2, r7, 3));
        r19.addSurfaceConfig(SurfaceConfig.create(r10, r7, 2));
        r0.add(r19);
        SurfaceCombination r20 = new SurfaceCombination();
        r20.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r20.addSurfaceConfig(SurfaceConfig.create(r6, r7, 3));
        r20.addSurfaceConfig(SurfaceConfig.create(r10, r7, 2));
        r0.add(r20);
        SurfaceCombination r21 = new SurfaceCombination();
        r21.addSurfaceConfig(SurfaceConfig.create(r2, r14, 1));
        r21.addSurfaceConfig(SurfaceConfig.create(r6, r14, 1));
        r21.addSurfaceConfig(SurfaceConfig.create(r10, r11, 2));
        r0.add(r21);
        return r0;
    }

    public static List<SurfaceCombination> getUltraHdrSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.JPEG_R;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r1);
        SurfaceCombination r4 = new SurfaceCombination();
        r4.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        r4.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r0.add(r4);
        return r0;
    }

    public static List<SurfaceCombination> getUltraHighResolutionSupportedCombinationList() {
        ArrayList r0 = new ArrayList();
        SurfaceCombination r1 = new SurfaceCombination();
        SurfaceConfig.ConfigType r2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize r3 = SurfaceConfig.ConfigSize.ULTRA_MAXIMUM;
        r1.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        SurfaceConfig.ConfigType r4 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize r5 = SurfaceConfig.ConfigSize.PREVIEW;
        r1.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        SurfaceConfig.ConfigSize r6 = SurfaceConfig.ConfigSize.RECORD;
        r1.addSurfaceConfig(SurfaceConfig.create(r4, r6));
        r0.add(r1);
        SurfaceCombination r7 = new SurfaceCombination();
        SurfaceConfig.ConfigType r8 = SurfaceConfig.ConfigType.JPEG;
        r7.addSurfaceConfig(SurfaceConfig.create(r8, r3));
        r7.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r7.addSurfaceConfig(SurfaceConfig.create(r4, r6));
        r0.add(r7);
        SurfaceCombination r9 = new SurfaceCombination();
        SurfaceConfig.ConfigType r10 = SurfaceConfig.ConfigType.RAW;
        r9.addSurfaceConfig(SurfaceConfig.create(r10, r3));
        r9.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r9.addSurfaceConfig(SurfaceConfig.create(r4, r6));
        r0.add(r9);
        SurfaceCombination r11 = new SurfaceCombination();
        r11.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r11.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        SurfaceConfig.ConfigSize r12 = SurfaceConfig.ConfigSize.MAXIMUM;
        r11.addSurfaceConfig(SurfaceConfig.create(r8, r12));
        r0.add(r11);
        SurfaceCombination r13 = new SurfaceCombination();
        r13.addSurfaceConfig(SurfaceConfig.create(r8, r3));
        r13.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r13.addSurfaceConfig(SurfaceConfig.create(r8, r12));
        r0.add(r13);
        SurfaceCombination r14 = new SurfaceCombination();
        r14.addSurfaceConfig(SurfaceConfig.create(r10, r3));
        r14.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r14.addSurfaceConfig(SurfaceConfig.create(r8, r12));
        r0.add(r14);
        SurfaceCombination r15 = new SurfaceCombination();
        r15.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r15.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r15.addSurfaceConfig(SurfaceConfig.create(r2, r12));
        r0.add(r15);
        SurfaceCombination r16 = new SurfaceCombination();
        r16.addSurfaceConfig(SurfaceConfig.create(r8, r3));
        r16.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r16.addSurfaceConfig(SurfaceConfig.create(r2, r12));
        r0.add(r16);
        SurfaceCombination r17 = new SurfaceCombination();
        r17.addSurfaceConfig(SurfaceConfig.create(r10, r3));
        r17.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r17.addSurfaceConfig(SurfaceConfig.create(r2, r12));
        r0.add(r17);
        SurfaceCombination r18 = new SurfaceCombination();
        r18.addSurfaceConfig(SurfaceConfig.create(r2, r3));
        r18.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r18.addSurfaceConfig(SurfaceConfig.create(r10, r12));
        r0.add(r18);
        SurfaceCombination r19 = new SurfaceCombination();
        r19.addSurfaceConfig(SurfaceConfig.create(r8, r3));
        r19.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r19.addSurfaceConfig(SurfaceConfig.create(r10, r12));
        r0.add(r19);
        SurfaceCombination r20 = new SurfaceCombination();
        r20.addSurfaceConfig(SurfaceConfig.create(r10, r3));
        r20.addSurfaceConfig(SurfaceConfig.create(r4, r5));
        r20.addSurfaceConfig(SurfaceConfig.create(r10, r12));
        r0.add(r20);
        return r0;
    }

    private GuaranteedConfigurationsUtil() {
    }

    public static List<SurfaceCombination> generateSupportedCombinationList(int r4, boolean r5, boolean r6) {
        ArrayList r0 = new ArrayList();
        r0.addAll(getLegacySupportedCombinationList());
        if (r4 == 0) goto L6;
        if (r4 == 1) goto L6;
        if (r4 == 3) goto L6;
    L7:
        if (r4 == 1) goto L9;
        if (r4 == 3) goto L9;
    L10:
        if (r5 == false) goto L12;
        r0.addAll(getRAWSupportedCombinationList());
    L12:
        if (r6 == false) goto L15;
        if (r4 != 0) goto L15;
        r0.addAll(getBurstSupportedCombinationList());
    L15:
        if (r4 != 3) goto L17;
        r0.addAll(getLevel3SupportedCombinationList());
    L17:
        return r0;
    L9:
        r0.addAll(getFullSupportedCombinationList());
    L6:
        r0.addAll(getLimitedSupportedCombinationList());
        goto L7
    }
}
