package com.ss.android.lark.passport.signinsdk_api.account;

import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutSceneKey;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/account/EraseType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LOGOUT_ALL", "DEEP_CLEAN", "ADMIN_KICKOUT_WIPE", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EraseType extends Enum<EraseType> {
    public static final EraseType ADMIN_KICKOUT_WIPE = null;
    public static final EraseType DEEP_CLEAN = null;
    public static final EraseType LOGOUT_ALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EraseType[] f438050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438051b = null;
    private final String value;

    public static EnumEntries<EraseType> getEntries() {
        return f438051b;
    }

    static {
        EraseType r100 = new EraseType("LOGOUT_ALL", 0, "logout_all");
        LOGOUT_ALL = r100;
        EraseType r101 = new EraseType("DEEP_CLEAN", 1, "deep_clean");
        DEEP_CLEAN = r101;
        EraseType r102 = new EraseType("ADMIN_KICKOUT_WIPE", 2, LogoutSceneKey.ADMIN_KICKOUT_WIPE);
        ADMIN_KICKOUT_WIPE = r102;
        EraseType[] r103 = {r100, r101, r102};
        f438050a = r103;
        f438051b = EnumEntriesKt.enumEntries(r103);
    }

    public static EraseType[] values() {
        return (EraseType[]) f438050a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EraseType valueOf(String r100) {
        return (EraseType) a.a(EraseType.class, r100);
    }

    public EraseType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
