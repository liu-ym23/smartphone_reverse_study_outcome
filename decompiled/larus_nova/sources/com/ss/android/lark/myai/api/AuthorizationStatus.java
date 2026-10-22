package com.ss.android.lark.myai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/myai/api/AuthorizationStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "REJECT", "ACCEPT", "Companion", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthorizationStatus extends Enum<AuthorizationStatus> {
    public static final AuthorizationStatus ACCEPT = null;
    public static final a Companion = null;
    public static final AuthorizationStatus REJECT = null;
    public static final AuthorizationStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthorizationStatus[] f432839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432840b = null;
    private final int value;

    public static EnumEntries<AuthorizationStatus> getEntries() {
        return f432840b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.myai.api.AuthorizationStatus$a] */
    static {
        AuthorizationStatus r100 = new AuthorizationStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        AuthorizationStatus r101 = new AuthorizationStatus("REJECT", 1, 1);
        REJECT = r101;
        AuthorizationStatus r102 = new AuthorizationStatus("ACCEPT", 2, 2);
        ACCEPT = r102;
        AuthorizationStatus[] r103 = {r100, r101, r102};
        f432839a = r103;
        f432840b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static AuthorizationStatus[] values() {
        return (AuthorizationStatus[]) f432839a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AuthorizationStatus valueOf(String r100) {
        return (AuthorizationStatus) r27.a.a(AuthorizationStatus.class, r100);
    }

    public AuthorizationStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
