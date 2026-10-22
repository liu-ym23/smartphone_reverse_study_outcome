package com.ss.android.vesdk;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class VERuntimeConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f455709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f455710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f455711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f455712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f455713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Long> f455714f = null;

    public static final enum HwEncFallBackMode extends Enum<HwEncFallBackMode> {
        public static final HwEncFallBackMode AUDIO_ENC_ENCODING_FALLBACK = null;
        public static final HwEncFallBackMode AUDIO_ENC_INIT_FALLBACK = null;
        public static final HwEncFallBackMode HW_ENC_FALLBACK_NONE = null;
        public static final HwEncFallBackMode VIDEO_ENC_ENCODING_FALLBACK = null;
        public static final HwEncFallBackMode VIDEO_ENC_INIT_FALLBACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HwEncFallBackMode[] f455715a = null;
        private int mValue;

        static {
            HwEncFallBackMode r100 = new HwEncFallBackMode("HW_ENC_FALLBACK_NONE", 0, 0);
            HW_ENC_FALLBACK_NONE = r100;
            HwEncFallBackMode r101 = new HwEncFallBackMode("VIDEO_ENC_INIT_FALLBACK", 1, 1);
            VIDEO_ENC_INIT_FALLBACK = r101;
            HwEncFallBackMode r102 = new HwEncFallBackMode("AUDIO_ENC_INIT_FALLBACK", 2, 2);
            AUDIO_ENC_INIT_FALLBACK = r102;
            HwEncFallBackMode r103 = new HwEncFallBackMode("VIDEO_ENC_ENCODING_FALLBACK", 3, 3);
            VIDEO_ENC_ENCODING_FALLBACK = r103;
            HwEncFallBackMode r104 = new HwEncFallBackMode("AUDIO_ENC_ENCODING_FALLBACK", 4, 4);
            AUDIO_ENC_ENCODING_FALLBACK = r104;
            f455715a = new HwEncFallBackMode[]{r100, r101, r102, r103, r104};
        }

        public static HwEncFallBackMode[] values() {
            return (HwEncFallBackMode[]) f455715a.clone();
        }

        public int getValue() {
            return this.mValue;
        }

        public static HwEncFallBackMode valueOf(String r100) {
            return (HwEncFallBackMode) r27.a.a(HwEncFallBackMode.class, r100);
        }

        public HwEncFallBackMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    static {
        f455713e = HwEncFallBackMode.HW_ENC_FALLBACK_NONE.getValue();
        f455714f = new HashMap();
    }
}
