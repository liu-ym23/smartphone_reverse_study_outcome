package com.obric.assistant.obric_action.handler.auth.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/result/AuthenticationActionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PASS", "NOT_AVAILABLE", "FAILED", "TIMEOUT", "CANCELLED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthenticationActionStatus extends Enum<AuthenticationActionStatus> {

    @SerializedName("cancelled")
    public static final AuthenticationActionStatus CANCELLED = null;
    public static final a Companion = null;

    @SerializedName("failed")
    public static final AuthenticationActionStatus FAILED = null;

    @SerializedName("not_available")
    public static final AuthenticationActionStatus NOT_AVAILABLE = null;

    @SerializedName("pass")
    public static final AuthenticationActionStatus PASS = null;

    @SerializedName("timeout")
    public static final AuthenticationActionStatus TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthenticationActionStatus[] f390468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390469b = null;
    private final String value;

    public static EnumEntries<AuthenticationActionStatus> getEntries() {
        return f390469b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.obric_action.handler.auth.result.AuthenticationActionStatus$a] */
    static {
        AuthenticationActionStatus r100 = new AuthenticationActionStatus("PASS", 0, "pass");
        PASS = r100;
        AuthenticationActionStatus r101 = new AuthenticationActionStatus("NOT_AVAILABLE", 1, "not_available");
        NOT_AVAILABLE = r101;
        AuthenticationActionStatus r102 = new AuthenticationActionStatus("FAILED", 2, "failed");
        FAILED = r102;
        AuthenticationActionStatus r103 = new AuthenticationActionStatus("TIMEOUT", 3, "timeout");
        TIMEOUT = r103;
        AuthenticationActionStatus r104 = new AuthenticationActionStatus("CANCELLED", 4, "cancelled");
        CANCELLED = r104;
        AuthenticationActionStatus[] r105 = {r100, r101, r102, r103, r104};
        f390468a = r105;
        f390469b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static AuthenticationActionStatus[] values() {
        return (AuthenticationActionStatus[]) f390468a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AuthenticationActionStatus valueOf(String r100) {
        return (AuthenticationActionStatus) r27.a.a(AuthenticationActionStatus.class, r100);
    }

    public AuthenticationActionStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
