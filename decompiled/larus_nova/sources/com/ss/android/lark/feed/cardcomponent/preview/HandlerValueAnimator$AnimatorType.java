package com.ss.android.lark.feed.cardcomponent.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/HandlerValueAnimator$AnimatorType;", "", "<init>", "(Ljava/lang/String;I)V", "FLOAT", "INT", "COLOR", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum HandlerValueAnimator$AnimatorType extends Enum<HandlerValueAnimator$AnimatorType> {
    public static final HandlerValueAnimator$AnimatorType COLOR = null;
    public static final HandlerValueAnimator$AnimatorType FLOAT = null;
    public static final HandlerValueAnimator$AnimatorType INT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HandlerValueAnimator$AnimatorType[] f420901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420902b = null;

    public static EnumEntries<HandlerValueAnimator$AnimatorType> getEntries() {
        return f420902b;
    }

    static {
        HandlerValueAnimator$AnimatorType r100 = new HandlerValueAnimator$AnimatorType("FLOAT", 0);
        FLOAT = r100;
        HandlerValueAnimator$AnimatorType r101 = new HandlerValueAnimator$AnimatorType("INT", 1);
        INT = r101;
        HandlerValueAnimator$AnimatorType r102 = new HandlerValueAnimator$AnimatorType("COLOR", 2);
        COLOR = r102;
        HandlerValueAnimator$AnimatorType[] r103 = {r100, r101, r102};
        f420901a = r103;
        f420902b = EnumEntriesKt.enumEntries(r103);
    }

    public static HandlerValueAnimator$AnimatorType[] values() {
        return (HandlerValueAnimator$AnimatorType[]) f420901a.clone();
    }

    public static HandlerValueAnimator$AnimatorType valueOf(String r100) {
        return (HandlerValueAnimator$AnimatorType) r27.a.a(HandlerValueAnimator$AnimatorType.class, r100);
    }

    public HandlerValueAnimator$AnimatorType(String r100, int r101) {
        super(r100, r101);
    }
}
