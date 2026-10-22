package com.ss.android.ttve.vealgorithm.params;

import java.util.ArrayList;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class VESmartCutResult extends VEAlgorithmResult {
    public ArrayList<Object> resultList;

    public static final enum VESmartCutPhotoEffect extends Enum<VESmartCutPhotoEffect> {
        public static final VESmartCutPhotoEffect VESmartCutPhotoEffectZoomIn = null;
        public static final VESmartCutPhotoEffect VESmartCutPhotoEffectZoomNone = null;
        public static final VESmartCutPhotoEffect VESmartCutPhotoEffectZoomOut = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VESmartCutPhotoEffect[] f449985a = null;
        public int value;

        static {
            VESmartCutPhotoEffect r100 = new VESmartCutPhotoEffect("VESmartCutPhotoEffectZoomNone", 0, 0);
            VESmartCutPhotoEffectZoomNone = r100;
            VESmartCutPhotoEffect r101 = new VESmartCutPhotoEffect("VESmartCutPhotoEffectZoomIn", 1, 1);
            VESmartCutPhotoEffectZoomIn = r101;
            VESmartCutPhotoEffect r102 = new VESmartCutPhotoEffect("VESmartCutPhotoEffectZoomOut", 2, 2);
            VESmartCutPhotoEffectZoomOut = r102;
            f449985a = new VESmartCutPhotoEffect[]{r100, r101, r102};
        }

        public static VESmartCutPhotoEffect[] values() {
            return (VESmartCutPhotoEffect[]) f449985a.clone();
        }

        public static VESmartCutPhotoEffect valueOf(String r100) {
            return (VESmartCutPhotoEffect) a.a(VESmartCutPhotoEffect.class, r100);
        }

        public VESmartCutPhotoEffect(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public VESmartCutResult() {
        this.type = VEAlgorithmType.VEAlgorithmTypeSmartCut;
    }
}
