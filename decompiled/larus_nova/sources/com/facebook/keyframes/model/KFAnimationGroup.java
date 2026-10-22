package com.facebook.keyframes.model;

import com.facebook.keyframes.model.keyframedmodels.KeyFramedAnchorPoint;
import com.facebook.keyframes.util.AnimationHelper;
import com.facebook.keyframes.util.ArgCheckUtil;
import com.facebook.keyframes.util.ListHelper;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class KFAnimationGroup {
    public static final String ANIMATIONS_JSON_FIELD = "animations";
    public static final String GROUP_ID_JSON_FIELD = "group_id";
    public static final String PARENT_GROUP_JSON_FIELD = "parent_group";
    private final KFAnimation mAnchorPoint;
    private final List<KFAnimation> mAnimations;
    private final int mGroupId;
    private final int mParentGroup;

    public static class Builder {
        public List<KFAnimation> animations;
        public int groupId;
        public int parentGroup;

        public Builder() {
        }

        public KFAnimationGroup build() {
            return new KFAnimationGroup(this.groupId, this.parentGroup, this.animations);
        }
    }

    public KeyFramedAnchorPoint getAnchorPoint() {
        KFAnimation r100 = this.mAnchorPoint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return (KeyFramedAnchorPoint) r100.getAnimation();
    }

    public List<KFAnimation> getAnimations() {
        return this.mAnimations;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public int getParentGroup() {
        return this.mParentGroup;
    }

    public KFAnimationGroup(int r100, int r101, List<KFAnimation> r102) {
        Integer r103 = Integer.valueOf(r100);
        boolean r104 = true;
        if (r100 <= 0) goto L5;
        boolean r105 = true;
    L6:
        this.mGroupId = ((Integer) ArgCheckUtil.checkArg(r103, r105, "group_id")).intValue();
        this.mParentGroup = r101;
        ListHelper.sort(r102, KFAnimation.ANIMATION_PROPERTY_COMPARATOR);
        this.mAnchorPoint = AnimationHelper.extractSpecialAnimationAnimationSet(r102, KFAnimation.PropertyType.ANCHOR_POINT);
        List r106 = ListHelper.immutableOrEmpty(r102);
        if (r102.size() > 0) goto L10;
        r104 = false;
    L10:
        this.mAnimations = (List) ArgCheckUtil.checkArg(r106, r104, "animations");
        return;
    L5:
        r105 = false;
        goto L6
    }
}
