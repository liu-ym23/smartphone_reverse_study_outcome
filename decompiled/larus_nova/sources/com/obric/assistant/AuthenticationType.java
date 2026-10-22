package com.obric.assistant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/AuthenticationType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "INVALID", "VoicePrint", "Biometric", "UnLocked", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthenticationType extends Enum<AuthenticationType> {
    public static final AuthenticationType Biometric = null;
    public static final AuthenticationType INVALID = null;
    public static final AuthenticationType UnLocked = null;
    public static final AuthenticationType VoicePrint = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthenticationType[] f385109a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385110b = null;
    private final int type;

    public static EnumEntries<AuthenticationType> getEntries() {
        return f385110b;
    }

    static {
        AuthenticationType r100 = new AuthenticationType("INVALID", 0, 0);
        INVALID = r100;
        AuthenticationType r101 = new AuthenticationType("VoicePrint", 1, 1);
        VoicePrint = r101;
        AuthenticationType r102 = new AuthenticationType("Biometric", 2, 2);
        Biometric = r102;
        AuthenticationType r103 = new AuthenticationType("UnLocked", 3, 3);
        UnLocked = r103;
        AuthenticationType[] r104 = {r100, r101, r102, r103};
        f385109a = r104;
        f385110b = EnumEntriesKt.enumEntries(r104);
    }

    public static AuthenticationType[] values() {
        return (AuthenticationType[]) f385109a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AuthenticationType valueOf(String r100) {
        return (AuthenticationType) r27.a.a(AuthenticationType.class, r100);
    }

    public AuthenticationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
