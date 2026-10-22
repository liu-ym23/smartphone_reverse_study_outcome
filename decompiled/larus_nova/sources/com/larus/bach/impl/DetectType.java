package com.larus.bach.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bach/impl/DetectType;", "", "<init>", "(Ljava/lang/String;I)V", "AVATAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DetectType extends Enum<DetectType> {
    public static final DetectType AVATAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DetectType[] f294817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294818b = null;

    public static EnumEntries<DetectType> getEntries() {
        return f294818b;
    }

    static {
        DetectType r100 = new DetectType();
        AVATAR = r100;
        DetectType[] r101 = {r100};
        f294817a = r101;
        f294818b = EnumEntriesKt.enumEntries(r101);
    }

    public DetectType() {
        super("AVATAR", 0);
    }

    public static DetectType[] values() {
        return (DetectType[]) f294817a.clone();
    }

    public static DetectType valueOf(String r100) {
        return (DetectType) r27.a.a(DetectType.class, r100);
    }
}
