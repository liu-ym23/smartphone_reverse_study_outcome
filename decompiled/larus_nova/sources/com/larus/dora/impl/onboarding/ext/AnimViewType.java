package com.larus.dora.impl.onboarding.ext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/onboarding/ext/AnimViewType;", "", "<init>", "(Ljava/lang/String;I)V", "AVATAR", "BUBBLE", "BUBBLE_BACKGROUND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AnimViewType extends Enum<AnimViewType> {
    public static final AnimViewType AVATAR = null;
    public static final AnimViewType BUBBLE = null;
    public static final AnimViewType BUBBLE_BACKGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimViewType[] f336628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336629b = null;

    public static EnumEntries<AnimViewType> getEntries() {
        return f336629b;
    }

    static {
        AnimViewType r100 = new AnimViewType("AVATAR", 0);
        AVATAR = r100;
        AnimViewType r101 = new AnimViewType("BUBBLE", 1);
        BUBBLE = r101;
        AnimViewType r102 = new AnimViewType("BUBBLE_BACKGROUND", 2);
        BUBBLE_BACKGROUND = r102;
        AnimViewType[] r103 = {r100, r101, r102};
        f336628a = r103;
        f336629b = EnumEntriesKt.enumEntries(r103);
    }

    public static AnimViewType[] values() {
        return (AnimViewType[]) f336628a.clone();
    }

    public static AnimViewType valueOf(String r100) {
        return (AnimViewType) a.a(AnimViewType.class, r100);
    }

    public AnimViewType(String r100, int r101) {
        super(r100, r101);
    }
}
