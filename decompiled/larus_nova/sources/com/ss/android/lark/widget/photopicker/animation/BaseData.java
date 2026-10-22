package com.ss.android.lark.widget.photopicker.animation;

/* JADX INFO: loaded from: classes38.dex */
public abstract class BaseData {

    public static final enum AnimationType extends Enum<AnimationType> {
        public static final AnimationType ALPHA_ANIMATION = null;
        public static final AnimationType TRANSLATE_ANIMATION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnimationType[] f447458a = null;
        int value;

        static {
            AnimationType r100 = new AnimationType("TRANSLATE_ANIMATION", 0, 0);
            TRANSLATE_ANIMATION = r100;
            AnimationType r101 = new AnimationType("ALPHA_ANIMATION", 1, 1);
            ALPHA_ANIMATION = r101;
            f447458a = new AnimationType[]{r100, r101};
        }

        public static AnimationType[] values() {
            return (AnimationType[]) f447458a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static AnimationType forValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return TRANSLATE_ANIMATION;
        L8:
            return ALPHA_ANIMATION;
        L10:
            return TRANSLATE_ANIMATION;
        }

        public static AnimationType valueOf(String r100) {
            return (AnimationType) r27.a.a(AnimationType.class, r100);
        }

        public AnimationType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public BaseData() {
    }
}
