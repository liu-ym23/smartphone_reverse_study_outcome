package com.facebook.keyframes;

/* JADX INFO: loaded from: classes23.dex */
public interface KeyframesDirectionallyScalingDrawable {

    public static final enum ScaleDirection extends Enum<ScaleDirection> {
        private static final /* synthetic */ ScaleDirection[] $VALUES = null;
        public static final ScaleDirection DOWN = null;
        public static final ScaleDirection UP = null;

        static {
            ScaleDirection r100 = new ScaleDirection("UP", 0);
            UP = r100;
            ScaleDirection r101 = new ScaleDirection("DOWN", 1);
            DOWN = r101;
            $VALUES = new ScaleDirection[]{r100, r101};
        }

        public static ScaleDirection[] values() {
            return (ScaleDirection[]) $VALUES.clone();
        }

        public static ScaleDirection valueOf(String r100) {
            return (ScaleDirection) Enum.valueOf(ScaleDirection.class, r100);
        }

        private ScaleDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    void setDirectionalScale(float r100, float r101, ScaleDirection r102);
}
