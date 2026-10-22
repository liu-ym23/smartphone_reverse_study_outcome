package com.bytedance.android.shopping.store.home.presenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/AnimationStatus;", "", "DEFAULT", "RUNNING", "FINISHED", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationStatus extends Enum<AnimationStatus> {
    public static final AnimationStatus DEFAULT = null;
    public static final AnimationStatus FINISHED = null;
    public static final AnimationStatus RUNNING = null;
    public static final /* synthetic */ AnimationStatus[] a = null;

    static {
        AnimationStatus r1 = new AnimationStatus("DEFAULT", 0);
        DEFAULT = r1;
        AnimationStatus r2 = new AnimationStatus("RUNNING", 1);
        RUNNING = r2;
        AnimationStatus r3 = new AnimationStatus("FINISHED", 2);
        FINISHED = r3;
        a = new AnimationStatus[]{r1, r2, r3};
    }

    public static AnimationStatus valueOf(String r1) {
        return (AnimationStatus) r27.a.a(AnimationStatus.class, r1);
    }

    public static AnimationStatus[] values() {
        return (AnimationStatus[]) a.clone();
    }

    public AnimationStatus(String r1, int r2) {
        super(r1, r2);
    }
}
