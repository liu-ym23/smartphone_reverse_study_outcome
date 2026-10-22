package com.ss.android.ttve.model;

import com.ss.android.lark.location.dto.LocationConstants$NameType;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class VEAlgorithmResult {
    private static final String[] tags = null;
    private C1CategoryItem[] categoryItems;
    private int[] cluster_ids;
    private ArrayList<ArrayList<Integer>> clusters;
    private int errorCode;
    private int faceCount;
    private float[] faceFeatures;
    private float face_score;
    private byte[] featureByte;
    private float quality_score;
    private float score;
    private float sharpness_score;
    private float similarityScore;

    public static class C1CategoryItem {
        private float prob;
        private boolean satisfied;
        private String tag;

        public C1CategoryItem() {
        }

        public float getProb() {
            return this.prob;
        }

        public String getTag() {
            return this.tag;
        }

        public boolean isSatisfied() {
            return this.satisfied;
        }

        public void setProb(float r100) {
            this.prob = r100;
        }

        public void setSatisfied(boolean r100) {
            this.satisfied = r100;
        }

        public void setTag(String r100) {
            this.tag = r100;
        }

        public C1CategoryItem(float r100, boolean r101, int r102) {
            setProb(r100);
            setSatisfied(r101);
            this.tag = VEAlgorithmResult.access$000()[r102];
        }
    }

    static {
        tags = new String[]{"baby", "beach", LocationConstants$NameType.BUILDING, CommonCmd.AIDL_PLATFORM_TYPE_CAR, "cartoon", "cat", "dog", "flower", "food", "group", "hill", "indoor", "lake", "nightscape", "selfie", "sky", "statue", "street", "sunset", "text", "tree", "others"};
    }

    public VEAlgorithmResult() {
        this.errorCode = 0;
    }

    public static /* synthetic */ String[] access$000() {
        return tags;
    }

    public C1CategoryItem[] getCategoryItems() {
        return this.categoryItems;
    }

    public int[] getClusterIDs() {
        return this.cluster_ids;
    }

    public ArrayList<ArrayList<Integer>> getClusters() {
        return this.clusters;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getFaceCount() {
        return this.faceCount;
    }

    public float[] getFaceFeatures() {
        return this.faceFeatures;
    }

    public float getFaceScore() {
        return this.face_score;
    }

    public byte[] getFeatureByte() {
        return this.featureByte;
    }

    public float getQualityScore() {
        return this.quality_score;
    }

    public float getScore() {
        return this.score;
    }

    public float getSharpnessScore() {
        return this.sharpness_score;
    }

    public float getSimilarityScore() {
        return this.similarityScore;
    }

    public void setCategoryItems(C1CategoryItem[] r100) {
        this.categoryItems = r100;
    }

    public void setClusterIDs(int[] r100) {
        this.cluster_ids = r100;
    }

    public void setClusters(ArrayList<ArrayList<Integer>> r100) {
        this.clusters = r100;
    }

    public void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public void setFaceCount(int r100) {
        this.faceCount = r100;
    }

    public void setFaceFeatures(float[] r100) {
        this.faceFeatures = r100;
    }

    public void setFaceScore(float r100) {
        this.face_score = r100;
    }

    public void setFeatureByte(byte[] r100) {
        this.featureByte = r100;
    }

    public void setQualityScore(float r100) {
        this.quality_score = r100;
    }

    public void setScore(float r100) {
        this.score = r100;
    }

    public void setSharpnessScore(float r100) {
        this.sharpness_score = r100;
    }

    public void setSimilarityScore(float r100) {
        this.similarityScore = r100;
    }
}
