package com.larus.uaigc.helper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/helper/CreationLocalDetectState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISABLED", "SUBMITTED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum CreationLocalDetectState extends Enum<CreationLocalDetectState> {
    public static final CreationLocalDetectState DISABLED = null;
    public static final CreationLocalDetectState FAILED = null;
    public static final CreationLocalDetectState SUBMITTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationLocalDetectState[] f372960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f372961b = null;
    private final String value;

    public static EnumEntries<CreationLocalDetectState> getEntries() {
        return f372961b;
    }

    static {
        CreationLocalDetectState r100 = new CreationLocalDetectState("DISABLED", 0, "disabled");
        DISABLED = r100;
        CreationLocalDetectState r101 = new CreationLocalDetectState("SUBMITTED", 1, "submitted");
        SUBMITTED = r101;
        CreationLocalDetectState r102 = new CreationLocalDetectState("FAILED", 2, "failed");
        FAILED = r102;
        CreationLocalDetectState[] r103 = {r100, r101, r102};
        f372960a = r103;
        f372961b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreationLocalDetectState[] values() {
        return (CreationLocalDetectState[]) f372960a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationLocalDetectState valueOf(String r100) {
        return (CreationLocalDetectState) r27.a.a(CreationLocalDetectState.class, r100);
    }

    public CreationLocalDetectState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
