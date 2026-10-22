package com.ss.android.ttve.vealgorithm.params;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class VESmartCutParam extends VEAlgorithmParam {
    public a audioBeatParam;
    public int frameCountPerStep;
    public ArrayList<String> paths;
    public int stepDurationMs;
    public int threadNum;
    public int threadNumOfSW;

    public static final enum VESmartCutBeatMode extends Enum<VESmartCutBeatMode> {
        public static final VESmartCutBeatMode VESmartCutModeSelective = null;
        public static final VESmartCutBeatMode VESmartCutModeSequential = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VESmartCutBeatMode[] f449983a = null;
        public int value;

        static {
            VESmartCutBeatMode r100 = new VESmartCutBeatMode("VESmartCutModeSequential", 0, 1);
            VESmartCutModeSequential = r100;
            VESmartCutBeatMode r101 = new VESmartCutBeatMode("VESmartCutModeSelective", 1, 2);
            VESmartCutModeSelective = r101;
            f449983a = new VESmartCutBeatMode[]{r100, r101};
        }

        public static VESmartCutBeatMode[] values() {
            return (VESmartCutBeatMode[]) f449983a.clone();
        }

        public static VESmartCutBeatMode valueOf(String r100) {
            return (VESmartCutBeatMode) r27.a.a(VESmartCutBeatMode.class, r100);
        }

        public VESmartCutBeatMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VESmartCutBeatType extends Enum<VESmartCutBeatType> {
        public static final VESmartCutBeatType VESmartCutBeatTypeDownBeats = null;
        public static final VESmartCutBeatType VESmartCutBeatTypeManMade = null;
        public static final VESmartCutBeatType VESmartCutBeatTypeVeBeats = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VESmartCutBeatType[] f449984a = null;
        public int value;

        static {
            VESmartCutBeatType r100 = new VESmartCutBeatType("VESmartCutBeatTypeDownBeats", 0, 1);
            VESmartCutBeatTypeDownBeats = r100;
            VESmartCutBeatType r101 = new VESmartCutBeatType("VESmartCutBeatTypeVeBeats", 1, 2);
            VESmartCutBeatTypeVeBeats = r101;
            VESmartCutBeatType r102 = new VESmartCutBeatType("VESmartCutBeatTypeManMade", 2, 3);
            VESmartCutBeatTypeManMade = r102;
            f449984a = new VESmartCutBeatType[]{r100, r101, r102};
        }

        public static VESmartCutBeatType[] values() {
            return (VESmartCutBeatType[]) f449984a.clone();
        }

        public static VESmartCutBeatType valueOf(String r100) {
            return (VESmartCutBeatType) r27.a.a(VESmartCutBeatType.class, r100);
        }

        public VESmartCutBeatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a {
        public a() {
            int r100 = VESmartCutBeatMode.VESmartCutModeSelective.value;
            int r101 = VESmartCutBeatType.VESmartCutBeatTypeDownBeats.value;
        }
    }

    public VESmartCutParam() {
        this.type = VEAlgorithmType.VEAlgorithmTypeSmartCut;
        this.threadNum = 1;
        this.threadNumOfSW = 0;
        this.stepDurationMs = 1000;
        this.frameCountPerStep = 2;
        this.audioBeatParam = new a();
    }
}
