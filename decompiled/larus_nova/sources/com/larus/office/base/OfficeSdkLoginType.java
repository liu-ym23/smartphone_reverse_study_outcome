package com.larus.office.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/office/base/OfficeSdkLoginType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FAST_LOGIN", "FULL_LOGIN", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSdkLoginType extends Enum<OfficeSdkLoginType> {
    public static final OfficeSdkLoginType FAST_LOGIN = null;
    public static final OfficeSdkLoginType FULL_LOGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSdkLoginType[] f360474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360475b = null;
    private final String value;

    public static EnumEntries<OfficeSdkLoginType> getEntries() {
        return f360475b;
    }

    static {
        OfficeSdkLoginType r100 = new OfficeSdkLoginType("FAST_LOGIN", 0, "fast_login");
        FAST_LOGIN = r100;
        OfficeSdkLoginType r101 = new OfficeSdkLoginType("FULL_LOGIN", 1, "full_login");
        FULL_LOGIN = r101;
        OfficeSdkLoginType[] r102 = {r100, r101};
        f360474a = r102;
        f360475b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeSdkLoginType[] values() {
        return (OfficeSdkLoginType[]) f360474a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static OfficeSdkLoginType valueOf(String r100) {
        return (OfficeSdkLoginType) r27.a.a(OfficeSdkLoginType.class, r100);
    }

    public OfficeSdkLoginType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
