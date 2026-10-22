package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResultSource;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.OTHERS, "REMOTE_POLICY", "LOCAL_POLICY", "FAST_PASS", "CACHE", "DOWNGRADE", "FALLBACK", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ValidateResultSource extends Enum<ValidateResultSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ValidateResultSource[] $VALUES = null;

    @SerializedName("CACHE")
    public static final ValidateResultSource CACHE = null;

    @SerializedName("DOWNGRADE")
    public static final ValidateResultSource DOWNGRADE = null;

    @SerializedName("FALLBACK")
    public static final ValidateResultSource FALLBACK = null;

    @SerializedName("FAST_PASS")
    public static final ValidateResultSource FAST_PASS = null;

    @SerializedName("LOCAL_POLICY")
    public static final ValidateResultSource LOCAL_POLICY = null;

    @SerializedName(AccountType.OTHERS)
    public static final ValidateResultSource OTHERS = null;

    @SerializedName("REMOTE_POLICY")
    public static final ValidateResultSource REMOTE_POLICY = null;

    private static final /* synthetic */ ValidateResultSource[] $values() {
        return new ValidateResultSource[]{OTHERS, REMOTE_POLICY, LOCAL_POLICY, FAST_PASS, CACHE, DOWNGRADE, FALLBACK};
    }

    public static EnumEntries<ValidateResultSource> getEntries() {
        return $ENTRIES;
    }

    static {
        OTHERS = new ValidateResultSource(AccountType.OTHERS, 0);
        REMOTE_POLICY = new ValidateResultSource("REMOTE_POLICY", 1);
        LOCAL_POLICY = new ValidateResultSource("LOCAL_POLICY", 2);
        FAST_PASS = new ValidateResultSource("FAST_PASS", 3);
        CACHE = new ValidateResultSource("CACHE", 4);
        DOWNGRADE = new ValidateResultSource("DOWNGRADE", 5);
        FALLBACK = new ValidateResultSource("FALLBACK", 6);
        ValidateResultSource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ValidateResultSource[] values() {
        return (ValidateResultSource[]) $VALUES.clone();
    }

    public static ValidateResultSource valueOf(String r100) {
        return (ValidateResultSource) r27.a.a(ValidateResultSource.class, r100);
    }

    private ValidateResultSource(String r100, int r101) {
        super(r100, r101);
    }
}
