package com.facebook.keyframes.model;

import android.graphics.Matrix;
import android.util.SparseArray;
import com.facebook.keyframes.util.AnimationGroupSort;
import com.facebook.keyframes.util.ArgCheckUtil;
import com.facebook.keyframes.util.ListHelper;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KFImage {
    public static final String ANIMATION_GROUPS_JSON_FIELD = "animation_groups";
    public static final String CANVAS_SIZE_JSON_FIELD = "canvas_size";
    public static final String FEATURES_JSON_FIELD = "features";
    public static final String FRAME_COUNT_JSON_FIELD = "animation_frame_count";
    public static final String FRAME_RATE_JSON_FIELD = "frame_rate";
    public static final String KEY_JSON_FIELD = "key";
    private final List<KFAnimationGroup> mAnimationGroups;
    private final float[] mCanvasSize;
    private final List<KFFeature> mFeatures;
    private final int mFrameCount;
    private final int mFrameRate;
    private final int mKey;

    /* JADX INFO: renamed from: com.facebook.keyframes.model.KFImage$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        public List<KFAnimationGroup> animationGroups;
        public float[] canvasSize;
        public List<KFFeature> features;
        public int frameCount;
        public int frameRate;
        public int key;

        public Builder() {
        }

        public KFImage build() {
            return new KFImage(this.frameRate, this.frameCount, this.features, this.animationGroups, this.canvasSize, this.key, null);
        }
    }

    public List<KFAnimationGroup> getAnimationGroups() {
        return this.mAnimationGroups;
    }

    public float[] getCanvasSize() {
        return this.mCanvasSize;
    }

    public List<KFFeature> getFeatures() {
        return this.mFeatures;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public int getKey() {
        return this.mKey;
    }

    public void setAnimationMatrices(SparseArray<Matrix> r100, float r110) {
        int r101 = this.mAnimationGroups.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L14;
        KFAnimationGroup r103 = this.mAnimationGroups.get(r102);
        Matrix r104 = r100.get(r103.getGroupId());
        r104.reset();
        if (r103.getAnchorPoint() == null) goto L7;
        r103.getAnchorPoint().apply(r104);
    L7:
        int r105 = r103.getAnimations().size();
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L11;
        r103.getAnimations().get(r106).getAnimation().apply(r110, r104);
        r106 = r106 + 1;
        goto L8
    L11:
        if (r103.getParentGroup() <= 0) goto L13;
        r104.postConcat(r100.get(r103.getParentGroup()));
    L13:
        r102 = r102 + 1;
        goto L3
    }

    private KFImage(int r100, int r101, List<KFFeature> r102, List<KFAnimationGroup> r103, float[] r104, int r110) {
        Integer r105 = Integer.valueOf(r100);
        boolean r106 = true;
        if (r100 <= 0) goto L5;
        boolean r107 = true;
    L6:
        this.mFrameRate = ((Integer) ArgCheckUtil.checkArg(r105, r107, FRAME_RATE_JSON_FIELD)).intValue();
        Integer r108 = Integer.valueOf(r101);
        if (r101 <= 0) goto L9;
        boolean r109 = true;
    L10:
        this.mFrameCount = ((Integer) ArgCheckUtil.checkArg(r108, r109, FRAME_COUNT_JSON_FIELD)).intValue();
        List r111 = ListHelper.immutableOrEmpty(r102);
        if (r102.size() <= 0) goto L13;
        boolean r112 = true;
    L14:
        this.mFeatures = (List) ArgCheckUtil.checkArg(r111, r112, FEATURES_JSON_FIELD);
        List<KFAnimationGroup> r113 = AnimationGroupSort.sort(r103);
        this.mAnimationGroups = (List) ArgCheckUtil.checkArg(ListHelper.immutableOrEmpty(r113), ArgCheckUtil.checkAnimationGroupIdUniqueness(r113), ANIMATION_GROUPS_JSON_FIELD);
        if (r104.length == 2) goto L17;
    L21:
        r106 = false;
    L22:
        this.mCanvasSize = (float[]) ArgCheckUtil.checkArg(r104, r106, CANVAS_SIZE_JSON_FIELD);
        this.mKey = r110;
        return;
    L17:
        if (r104[0] <= 0.0f) goto L21;
        if (r104[1] <= 0.0f) goto L21;
    L13:
        r112 = false;
        goto L14
    L9:
        r109 = false;
        goto L10
    L5:
        r107 = false;
        goto L6
    }

    public /* synthetic */ KFImage(int r100, int r101, List r102, List r103, float[] r104, int r105, AnonymousClass1 r106) {
        this(r100, r101, r102, r103, r104, r105);
    }
}
