package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/assistant/utils/ObricAppStatus;", "", "errorCode", "", "errorMessage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "Success", "Unknown", "NoInstalledError", "AppDisabledError", "PrivacyNotApprovalError", "PrivacyNotObtainError", "UserNoLogin", "NotRoleAssistant", "assistant-status-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAppStatus extends Enum<ObricAppStatus> {
    public static final ObricAppStatus AppDisabledError = null;
    public static final ObricAppStatus NoInstalledError = null;
    public static final ObricAppStatus NotRoleAssistant = null;
    public static final ObricAppStatus PrivacyNotApprovalError = null;
    public static final ObricAppStatus PrivacyNotObtainError = null;
    public static final ObricAppStatus Success = null;
    public static final ObricAppStatus Unknown = null;
    public static final ObricAppStatus UserNoLogin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAppStatus[] f384606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384607b = null;
    private final int errorCode;
    private final String errorMessage;

    public static EnumEntries<ObricAppStatus> getEntries() {
        return f384607b;
    }

    static {
        ObricAppStatus r100 = new ObricAppStatus("Success", 0, 0, "success");
        Success = r100;
        ObricAppStatus r101 = new ObricAppStatus("Unknown", 1, -1, "unknown");
        Unknown = r101;
        ObricAppStatus r102 = new ObricAppStatus("NoInstalledError", 2, 1, "noInstalled");
        NoInstalledError = r102;
        ObricAppStatus r103 = new ObricAppStatus("AppDisabledError", 3, 2, "appDisabled");
        AppDisabledError = r103;
        ObricAppStatus r104 = new ObricAppStatus("PrivacyNotApprovalError", 4, 3, "PrivacyNotApproval");
        PrivacyNotApprovalError = r104;
        ObricAppStatus r105 = new ObricAppStatus("PrivacyNotObtainError", 5, 4, "PrivacyNotObtainOrTimeout");
        PrivacyNotObtainError = r105;
        ObricAppStatus r110 = new ObricAppStatus("UserNoLogin", 6, 5, "noLogin");
        UserNoLogin = r110;
        ObricAppStatus r111 = new ObricAppStatus("NotRoleAssistant", 7, 6, "NotRoleAssistant");
        NotRoleAssistant = r111;
        ObricAppStatus[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f384606a = r112;
        f384607b = EnumEntriesKt.enumEntries(r112);
    }

    public static ObricAppStatus[] values() {
        return (ObricAppStatus[]) f384606a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public static ObricAppStatus valueOf(String r100) {
        return (ObricAppStatus) r27.a.a(ObricAppStatus.class, r100);
    }

    public ObricAppStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMessage = r103;
    }
}
