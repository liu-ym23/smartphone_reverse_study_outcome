package com.obric.assistant;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/DoraAuthTrustType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SYSTEM_AUTHENTICATION", "VOICE_PRINT", "ALWAYS", "NOT_ALLOWED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAuthTrustType extends Enum<DoraAuthTrustType> {
    public static final DoraAuthTrustType ALWAYS = null;
    public static final DoraAuthTrustType NOT_ALLOWED = null;
    public static final DoraAuthTrustType SYSTEM_AUTHENTICATION = null;
    public static final DoraAuthTrustType VOICE_PRINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAuthTrustType[] f385116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385117b = null;
    private final int value;

    public static EnumEntries<DoraAuthTrustType> getEntries() {
        return f385117b;
    }

    static {
        DoraAuthTrustType r100 = new DoraAuthTrustType("SYSTEM_AUTHENTICATION", 0, 0);
        SYSTEM_AUTHENTICATION = r100;
        DoraAuthTrustType r101 = new DoraAuthTrustType("VOICE_PRINT", 1, 1);
        VOICE_PRINT = r101;
        DoraAuthTrustType r102 = new DoraAuthTrustType("ALWAYS", 2, 2);
        ALWAYS = r102;
        DoraAuthTrustType r103 = new DoraAuthTrustType("NOT_ALLOWED", 3, 3);
        NOT_ALLOWED = r103;
        DoraAuthTrustType[] r104 = {r100, r101, r102, r103};
        f385116a = r104;
        f385117b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraAuthTrustType[] values() {
        return (DoraAuthTrustType[]) f385116a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DoraAuthTrustType valueOf(String r100) {
        return (DoraAuthTrustType) r27.a.a(DoraAuthTrustType.class, r100);
    }

    public DoraAuthTrustType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
