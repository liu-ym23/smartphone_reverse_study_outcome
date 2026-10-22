package com.larus.avatar.impl.manager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avatar/impl/manager/DigitalAvatarToastType;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "WARNING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DigitalAvatarToastType extends Enum<DigitalAvatarToastType> {
    public static final DigitalAvatarToastType FAILURE = null;
    public static final DigitalAvatarToastType SUCCESS = null;
    public static final DigitalAvatarToastType WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitalAvatarToastType[] f290790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290791b = null;

    public static EnumEntries<DigitalAvatarToastType> getEntries() {
        return f290791b;
    }

    static {
        DigitalAvatarToastType r100 = new DigitalAvatarToastType("SUCCESS", 0);
        SUCCESS = r100;
        DigitalAvatarToastType r101 = new DigitalAvatarToastType("FAILURE", 1);
        FAILURE = r101;
        DigitalAvatarToastType r102 = new DigitalAvatarToastType("WARNING", 2);
        WARNING = r102;
        DigitalAvatarToastType[] r103 = {r100, r101, r102};
        f290790a = r103;
        f290791b = EnumEntriesKt.enumEntries(r103);
    }

    public static DigitalAvatarToastType[] values() {
        return (DigitalAvatarToastType[]) f290790a.clone();
    }

    public static DigitalAvatarToastType valueOf(String r100) {
        return (DigitalAvatarToastType) r27.a.a(DigitalAvatarToastType.class, r100);
    }

    public DigitalAvatarToastType(String r100, int r101) {
        super(r100, r101);
    }
}
