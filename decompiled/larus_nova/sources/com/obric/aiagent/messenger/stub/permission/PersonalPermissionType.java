package com.obric.aiagent.messenger.stub.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/messenger/stub/permission/PersonalPermissionType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PersonalSensitiveInfo", "PersonalRegisterInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PersonalPermissionType extends Enum<PersonalPermissionType> {
    public static final PersonalPermissionType PersonalRegisterInfo = null;
    public static final PersonalPermissionType PersonalSensitiveInfo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PersonalPermissionType[] f384940a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384941b = null;
    private final String value;

    public static EnumEntries<PersonalPermissionType> getEntries() {
        return f384941b;
    }

    static {
        PersonalPermissionType r100 = new PersonalPermissionType("PersonalSensitiveInfo", 0, "PersonalSensitiveInfo");
        PersonalSensitiveInfo = r100;
        PersonalPermissionType r101 = new PersonalPermissionType("PersonalRegisterInfo", 1, "PersonalRegisterInfo");
        PersonalRegisterInfo = r101;
        PersonalPermissionType[] r102 = {r100, r101};
        f384940a = r102;
        f384941b = EnumEntriesKt.enumEntries(r102);
    }

    public static PersonalPermissionType[] values() {
        return (PersonalPermissionType[]) f384940a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PersonalPermissionType valueOf(String r100) {
        return (PersonalPermissionType) r27.a.a(PersonalPermissionType.class, r100);
    }

    public PersonalPermissionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
