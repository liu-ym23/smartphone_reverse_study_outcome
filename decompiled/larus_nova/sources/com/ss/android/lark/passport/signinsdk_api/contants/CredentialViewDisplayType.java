package com.ss.android.lark.passport.signinsdk_api.contants;

import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/contants/CredentialViewDisplayType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.ALL, "PHONE", CommonConstant.RETKEY.EMAIL, "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CredentialViewDisplayType extends Enum<CredentialViewDisplayType> {
    public static final CredentialViewDisplayType ALL = null;
    public static final CredentialViewDisplayType EMAIL = null;
    public static final CredentialViewDisplayType PHONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CredentialViewDisplayType[] f438061a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438062b = null;
    private final int value;

    public static EnumEntries<CredentialViewDisplayType> getEntries() {
        return f438062b;
    }

    static {
        CredentialViewDisplayType r100 = new CredentialViewDisplayType(AccountType.ALL, 0, 0);
        ALL = r100;
        CredentialViewDisplayType r101 = new CredentialViewDisplayType("PHONE", 1, 1);
        PHONE = r101;
        CredentialViewDisplayType r102 = new CredentialViewDisplayType(CommonConstant.RETKEY.EMAIL, 2, 2);
        EMAIL = r102;
        CredentialViewDisplayType[] r103 = {r100, r101, r102};
        f438061a = r103;
        f438062b = EnumEntriesKt.enumEntries(r103);
    }

    public static CredentialViewDisplayType[] values() {
        return (CredentialViewDisplayType[]) f438061a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CredentialViewDisplayType valueOf(String r100) {
        return (CredentialViewDisplayType) r27.a.a(CredentialViewDisplayType.class, r100);
    }

    public CredentialViewDisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
