package com.ss.android.vesdk.algorithm;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachSceneRecognitionParam extends VEBachAlgorithmParam {
    private String applicationName;
    private String configJson;
    private String modelPath;
    private RECONGNITION_TYPE sceneType;

    public static final enum RECONGNITION_TYPE extends Enum<RECONGNITION_TYPE> {
        private static final /* synthetic */ RECONGNITION_TYPE[] $VALUES = null;
        public static final RECONGNITION_TYPE BABY = null;
        public static final RECONGNITION_TYPE BEACH = null;
        public static final RECONGNITION_TYPE BUILDING = null;
        public static final RECONGNITION_TYPE CAR = null;
        public static final RECONGNITION_TYPE CARTOON = null;
        public static final RECONGNITION_TYPE CAT = null;
        public static final RECONGNITION_TYPE DOG = null;
        public static final RECONGNITION_TYPE FLOWER = null;
        public static final RECONGNITION_TYPE FOOD = null;
        public static final RECONGNITION_TYPE GROUP = null;
        public static final RECONGNITION_TYPE HILL = null;
        public static final RECONGNITION_TYPE INDOOR = null;
        public static final RECONGNITION_TYPE LAKE = null;
        public static final RECONGNITION_TYPE NIGHTSCAPE = null;
        public static final RECONGNITION_TYPE SELFIE = null;
        public static final RECONGNITION_TYPE SKY = null;
        public static final RECONGNITION_TYPE STATUE = null;
        public static final RECONGNITION_TYPE STREET = null;
        public static final RECONGNITION_TYPE SUNSET = null;
        public static final RECONGNITION_TYPE TEXT = null;
        public static final RECONGNITION_TYPE TREE = null;

        private static /* synthetic */ RECONGNITION_TYPE[] $values() {
            return new RECONGNITION_TYPE[]{BABY, BEACH, BUILDING, CAR, CARTOON, CAT, DOG, FLOWER, FOOD, GROUP, HILL, INDOOR, LAKE, NIGHTSCAPE, SELFIE, SKY, STATUE, STREET, SUNSET, TEXT, TREE};
        }

        static {
            BABY = new RECONGNITION_TYPE("BABY", 0);
            BEACH = new RECONGNITION_TYPE("BEACH", 1);
            BUILDING = new RECONGNITION_TYPE("BUILDING", 2);
            CAR = new RECONGNITION_TYPE("CAR", 3);
            CARTOON = new RECONGNITION_TYPE("CARTOON", 4);
            CAT = new RECONGNITION_TYPE("CAT", 5);
            DOG = new RECONGNITION_TYPE("DOG", 6);
            FLOWER = new RECONGNITION_TYPE("FLOWER", 7);
            FOOD = new RECONGNITION_TYPE("FOOD", 8);
            GROUP = new RECONGNITION_TYPE("GROUP", 9);
            HILL = new RECONGNITION_TYPE("HILL", 10);
            INDOOR = new RECONGNITION_TYPE("INDOOR", 11);
            LAKE = new RECONGNITION_TYPE("LAKE", 12);
            NIGHTSCAPE = new RECONGNITION_TYPE("NIGHTSCAPE", 13);
            SELFIE = new RECONGNITION_TYPE("SELFIE", 14);
            SKY = new RECONGNITION_TYPE("SKY", 15);
            STATUE = new RECONGNITION_TYPE("STATUE", 16);
            STREET = new RECONGNITION_TYPE("STREET", 17);
            SUNSET = new RECONGNITION_TYPE("SUNSET", 18);
            TEXT = new RECONGNITION_TYPE(CardAdapter.TEXT, 19);
            TREE = new RECONGNITION_TYPE("TREE", 20);
            $VALUES = $values();
        }

        public static RECONGNITION_TYPE[] values() {
            return (RECONGNITION_TYPE[]) $VALUES.clone();
        }

        public static RECONGNITION_TYPE valueOf(String r100) {
            return (RECONGNITION_TYPE) a.a(RECONGNITION_TYPE.class, r100);
        }

        private RECONGNITION_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public VEBachSceneRecognitionParam() {
        super(15, "SceneRecognition", false);
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public String getConfigJson() {
        return this.configJson;
    }

    public String getModelPath() {
        return this.modelPath;
    }

    public RECONGNITION_TYPE getSceneType() {
        return this.sceneType;
    }

    public void setApplicationName(String r100) {
        this.applicationName = r100;
    }

    public void setConfigJson(String r100) {
        this.configJson = r100;
    }

    public void setModelPath(String r100) {
        this.modelPath = r100;
    }

    public void setSceneType(RECONGNITION_TYPE r100) {
        this.sceneType = r100;
    }
}
