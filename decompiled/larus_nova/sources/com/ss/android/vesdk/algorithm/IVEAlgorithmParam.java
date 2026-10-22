package com.ss.android.vesdk.algorithm;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public interface IVEAlgorithmParam {

    public static final enum Usage extends Enum<Usage> {
        private static final /* synthetic */ Usage[] $VALUES = null;
        public static final Usage DEFAULT = null;
        public static final Usage LENS = null;

        private static /* synthetic */ Usage[] $values() {
            return new Usage[]{DEFAULT, LENS};
        }

        static {
            DEFAULT = new Usage("DEFAULT", 0);
            LENS = new Usage("LENS", 1);
            $VALUES = $values();
        }

        public static Usage[] values() {
            return (Usage[]) $VALUES.clone();
        }

        public static Usage valueOf(String r100) {
            return (Usage) a.a(Usage.class, r100);
        }

        private Usage(String r100, int r101) {
            super(r100, r101);
        }
    }

    Usage getUsage();
}
