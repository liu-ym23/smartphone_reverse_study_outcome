package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ResultType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "DENY", "ERROR", "ALLOW", "NULL", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResultType extends Enum<ResultType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ResultType[] $VALUES = null;

    @SerializedName("ALLOW")
    public static final ResultType ALLOW = null;

    @SerializedName("DENY")
    public static final ResultType DENY = null;

    @SerializedName("ERROR")
    public static final ResultType ERROR = null;

    @SerializedName("NULL")
    public static final ResultType NULL = null;

    @SerializedName("UNKNOWN")
    public static final ResultType UNKNOWN = null;

    private static final /* synthetic */ ResultType[] $values() {
        return new ResultType[]{UNKNOWN, DENY, ERROR, ALLOW, NULL};
    }

    public static EnumEntries<ResultType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new ResultType("UNKNOWN", 0);
        DENY = new ResultType("DENY", 1);
        ERROR = new ResultType("ERROR", 2);
        ALLOW = new ResultType("ALLOW", 3);
        NULL = new ResultType("NULL", 4);
        ResultType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ResultType[] values() {
        return (ResultType[]) $VALUES.clone();
    }

    public static ResultType valueOf(String r100) {
        return (ResultType) r27.a.a(ResultType.class, r100);
    }

    private ResultType(String r100, int r101) {
        super(r100, r101);
    }
}
