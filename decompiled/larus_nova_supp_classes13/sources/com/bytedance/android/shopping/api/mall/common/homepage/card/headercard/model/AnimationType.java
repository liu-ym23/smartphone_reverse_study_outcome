package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/AnimationType;", "", "", "value", "I", "getValue", "()I", "NONE", "PRODUCT_CAROUSEL", "TAG_FLIP", "TAG_FLIP_AND_PRODUCT_CAROUSEL", "TAG_PRODUCT_CAROUSEL", "TASK_CAROUSEL", "LOTTIE_WITH_INFO", "TAG_SUB_PRODUCT_CAROUSEL", "LOTTIE_CAROUSEL", "WEBP_CAROUSEL", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationType extends Enum<AnimationType> {
    public static final AnimationType LOTTIE_CAROUSEL = null;
    public static final AnimationType LOTTIE_WITH_INFO = null;
    public static final AnimationType NONE = null;
    public static final AnimationType PRODUCT_CAROUSEL = null;
    public static final AnimationType TAG_FLIP = null;
    public static final AnimationType TAG_FLIP_AND_PRODUCT_CAROUSEL = null;
    public static final AnimationType TAG_PRODUCT_CAROUSEL = null;
    public static final AnimationType TAG_SUB_PRODUCT_CAROUSEL = null;
    public static final AnimationType TASK_CAROUSEL = null;
    public static final AnimationType WEBP_CAROUSEL = null;
    public static final /* synthetic */ AnimationType[] a = null;
    private final int value;

    public static AnimationType valueOf(String r1) {
        return (AnimationType) a.a(AnimationType.class, r1);
    }

    public static AnimationType[] values() {
        return (AnimationType[]) a.clone();
    }

    static {
        AnimationType r1 = new AnimationType("NONE", 0, 0);
        NONE = r1;
        AnimationType r2 = new AnimationType("PRODUCT_CAROUSEL", 1, 1);
        PRODUCT_CAROUSEL = r2;
        AnimationType r3 = new AnimationType("TAG_FLIP", 2, 2);
        TAG_FLIP = r3;
        AnimationType r4 = new AnimationType("TAG_FLIP_AND_PRODUCT_CAROUSEL", 3, 3);
        TAG_FLIP_AND_PRODUCT_CAROUSEL = r4;
        AnimationType r5 = new AnimationType("TAG_PRODUCT_CAROUSEL", 4, 4);
        TAG_PRODUCT_CAROUSEL = r5;
        AnimationType r6 = new AnimationType("TASK_CAROUSEL", 5, 5);
        TASK_CAROUSEL = r6;
        AnimationType r7 = new AnimationType("LOTTIE_WITH_INFO", 6, 6);
        LOTTIE_WITH_INFO = r7;
        AnimationType r8 = new AnimationType("TAG_SUB_PRODUCT_CAROUSEL", 7, 7);
        TAG_SUB_PRODUCT_CAROUSEL = r8;
        AnimationType r9 = new AnimationType("LOTTIE_CAROUSEL", 8, 8);
        LOTTIE_CAROUSEL = r9;
        AnimationType r10 = new AnimationType("WEBP_CAROUSEL", 9, 9);
        WEBP_CAROUSEL = r10;
        a = new AnimationType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
