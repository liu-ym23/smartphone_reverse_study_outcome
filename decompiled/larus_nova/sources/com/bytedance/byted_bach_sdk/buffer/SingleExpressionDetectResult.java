package com.bytedance.byted_bach_sdk.buffer;

import java.util.Vector;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public class SingleExpressionDetectResult {
    public int ID;
    public float age;
    public float attractive;
    public float boy_prob;
    public Vector<Float> exp_probs;
    public FaceExpression exp_type;
    public FaceGender gender;
    public float happy_score;
    public float quality;
    public float real_face_prob;

    public static final enum FaceExpression extends Enum<FaceExpression> {
        private static final /* synthetic */ FaceExpression[] $VALUES = null;
        public static final FaceExpression ANGRY = null;
        public static final FaceExpression DISGUST = null;
        public static final FaceExpression FEAR = null;
        public static final FaceExpression HAPPY = null;
        public static final FaceExpression NEUTRAL = null;
        public static final FaceExpression NUM_EXPRESSION = null;
        public static final FaceExpression SAD = null;
        public static final FaceExpression SURPRISE = null;
        public static final FaceExpression UNKNOWN = null;

        static {
            FaceExpression r100 = new FaceExpression("ANGRY", 0);
            ANGRY = r100;
            FaceExpression r101 = new FaceExpression("DISGUST", 1);
            DISGUST = r101;
            FaceExpression r102 = new FaceExpression("FEAR", 2);
            FEAR = r102;
            FaceExpression r103 = new FaceExpression("HAPPY", 3);
            HAPPY = r103;
            FaceExpression r104 = new FaceExpression("SAD", 4);
            SAD = r104;
            FaceExpression r105 = new FaceExpression("SURPRISE", 5);
            SURPRISE = r105;
            FaceExpression r110 = new FaceExpression("NEUTRAL", 6);
            NEUTRAL = r110;
            FaceExpression r111 = new FaceExpression("NUM_EXPRESSION", 7);
            NUM_EXPRESSION = r111;
            FaceExpression r112 = new FaceExpression("UNKNOWN", 8);
            UNKNOWN = r112;
            $VALUES = new FaceExpression[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static FaceExpression[] values() {
            return (FaceExpression[]) $VALUES.clone();
        }

        public static FaceExpression valueOf(String r100) {
            return (FaceExpression) a.a(FaceExpression.class, r100);
        }

        private FaceExpression(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum FaceGender extends Enum<FaceGender> {
        private static final /* synthetic */ FaceGender[] $VALUES = null;
        public static final FaceGender FEMALE = null;
        public static final FaceGender MALE = null;
        public static final FaceGender UNKNOWN = null;

        static {
            FaceGender r100 = new FaceGender("MALE", 0);
            MALE = r100;
            FaceGender r101 = new FaceGender("FEMALE", 1);
            FEMALE = r101;
            FaceGender r102 = new FaceGender("UNKNOWN", 2);
            UNKNOWN = r102;
            $VALUES = new FaceGender[]{r100, r101, r102};
        }

        public static FaceGender[] values() {
            return (FaceGender[]) $VALUES.clone();
        }

        public static FaceGender valueOf(String r100) {
            return (FaceGender) a.a(FaceGender.class, r100);
        }

        private FaceGender(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SingleExpressionDetectResult() {
        this.ID = -1;
        this.gender = FaceGender.UNKNOWN;
        this.exp_type = FaceExpression.UNKNOWN;
        this.real_face_prob = 0.0f;
        this.quality = 0.0f;
    }
}
