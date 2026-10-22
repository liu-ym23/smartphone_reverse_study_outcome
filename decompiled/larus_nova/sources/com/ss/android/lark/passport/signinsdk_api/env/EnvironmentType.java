package com.ss.android.lark.passport.signinsdk_api.env;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/env/EnvironmentType;", "", "<init>", "(Ljava/lang/String;I)V", "RELEASE", "STAGING", "PRE_RELEASE", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvironmentType extends Enum<EnvironmentType> {
    public static final EnvironmentType PRE_RELEASE = null;
    public static final EnvironmentType RELEASE = null;
    public static final EnvironmentType STAGING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnvironmentType[] f438080a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438081b = null;

    public static EnumEntries<EnvironmentType> getEntries() {
        return f438081b;
    }

    static {
        EnvironmentType r100 = new EnvironmentType("RELEASE", 0);
        RELEASE = r100;
        EnvironmentType r101 = new EnvironmentType("STAGING", 1);
        STAGING = r101;
        EnvironmentType r102 = new EnvironmentType("PRE_RELEASE", 2);
        PRE_RELEASE = r102;
        EnvironmentType[] r103 = {r100, r101, r102};
        f438080a = r103;
        f438081b = EnumEntriesKt.enumEntries(r103);
    }

    public static EnvironmentType[] values() {
        return (EnvironmentType[]) f438080a.clone();
    }

    public static EnvironmentType valueOf(String r100) {
        return (EnvironmentType) a.a(EnvironmentType.class, r100);
    }

    public EnvironmentType(String r100, int r101) {
        super(r100, r101);
    }
}
