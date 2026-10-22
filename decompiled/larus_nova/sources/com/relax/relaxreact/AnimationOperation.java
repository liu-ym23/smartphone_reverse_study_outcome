package com.relax.relaxreact;

import com.alibaba.gaiax.model.GXAnimation;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxreact/AnimationOperation;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", GXAnimation.STATE_START, FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "CANCEL", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum AnimationOperation extends Enum<AnimationOperation> {
    public static final AnimationOperation CANCEL = null;
    public static final AnimationOperation PAUSE = null;
    public static final AnimationOperation PLAY = null;
    public static final AnimationOperation START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationOperation[] f405381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f405382b = null;
    private final int value;

    public static EnumEntries<AnimationOperation> getEntries() {
        return f405382b;
    }

    public static AnimationOperation valueOf(String r100) {
        return (AnimationOperation) r27.a.a(AnimationOperation.class, r100);
    }

    public static AnimationOperation[] values() {
        return (AnimationOperation[]) f405381a.clone();
    }

    static {
        AnimationOperation r100 = new AnimationOperation(GXAnimation.STATE_START, 0, 0);
        START = r100;
        AnimationOperation r101 = new AnimationOperation(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1, 1);
        PLAY = r101;
        AnimationOperation r102 = new AnimationOperation("PAUSE", 2, 2);
        PAUSE = r102;
        AnimationOperation r103 = new AnimationOperation("CANCEL", 3, 3);
        CANCEL = r103;
        AnimationOperation[] r104 = {r100, r101, r102, r103};
        f405381a = r104;
        f405382b = EnumEntriesKt.enumEntries(r104);
    }

    public final int getValue() {
        return this.value;
    }

    public AnimationOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
