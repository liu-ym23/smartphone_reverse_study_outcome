package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileAuthResultFrom;", "", "comeFrom", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getComeFrom", "()Ljava/lang/String;", "COME_FROM_AUTHZ", "COME_FROM_FILE_POLICY", "COME_FROM_DLP_CONTENT_DETECTING", "COME_FROM_DLP_CONTENT_SENSITIVE", "COME_FROM_TT_BLOCK", "COME_FROM_UNKNOWN", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileAuthResultFrom extends Enum<FileAuthResultFrom> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FileAuthResultFrom[] $VALUES = null;

    @SerializedName("COME_FROM_AUTHZ")
    public static final FileAuthResultFrom COME_FROM_AUTHZ = null;

    @SerializedName("COME_FROM_DLP_CONTENT_DETECTING")
    public static final FileAuthResultFrom COME_FROM_DLP_CONTENT_DETECTING = null;

    @SerializedName("COME_FROM_DLP_CONTENT_SENSITIVE")
    public static final FileAuthResultFrom COME_FROM_DLP_CONTENT_SENSITIVE = null;

    @SerializedName("COME_FROM_FILE_POLICY")
    public static final FileAuthResultFrom COME_FROM_FILE_POLICY = null;

    @SerializedName("COME_FROM_TT_BLOCK")
    public static final FileAuthResultFrom COME_FROM_TT_BLOCK = null;

    @SerializedName("COME_FROM_UNKNOWN")
    public static final FileAuthResultFrom COME_FROM_UNKNOWN = null;
    private final String comeFrom;

    private static final /* synthetic */ FileAuthResultFrom[] $values() {
        return new FileAuthResultFrom[]{COME_FROM_AUTHZ, COME_FROM_FILE_POLICY, COME_FROM_DLP_CONTENT_DETECTING, COME_FROM_DLP_CONTENT_SENSITIVE, COME_FROM_TT_BLOCK, COME_FROM_UNKNOWN};
    }

    public static EnumEntries<FileAuthResultFrom> getEntries() {
        return $ENTRIES;
    }

    static {
        COME_FROM_AUTHZ = new FileAuthResultFrom("COME_FROM_AUTHZ", 0, "Authz");
        COME_FROM_FILE_POLICY = new FileAuthResultFrom("COME_FROM_FILE_POLICY", 1, "FilePolicy");
        COME_FROM_DLP_CONTENT_DETECTING = new FileAuthResultFrom("COME_FROM_DLP_CONTENT_DETECTING", 2, "DLP_CONTENT_DETECTING");
        COME_FROM_DLP_CONTENT_SENSITIVE = new FileAuthResultFrom("COME_FROM_DLP_CONTENT_SENSITIVE", 3, "DLP_CONTENT_SENSITIVE");
        COME_FROM_TT_BLOCK = new FileAuthResultFrom("COME_FROM_TT_BLOCK", 4, "TT_BLOCK");
        COME_FROM_UNKNOWN = new FileAuthResultFrom("COME_FROM_UNKNOWN", 5, "Unknown");
        FileAuthResultFrom[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static FileAuthResultFrom[] values() {
        return (FileAuthResultFrom[]) $VALUES.clone();
    }

    public final String getComeFrom() {
        return this.comeFrom;
    }

    public static FileAuthResultFrom valueOf(String r100) {
        return (FileAuthResultFrom) r27.a.a(FileAuthResultFrom.class, r100);
    }

    private FileAuthResultFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.comeFrom = r102;
    }
}
