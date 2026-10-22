package com.larus.uaigc.helper;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/helper/CreationReviewState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PASS", "INSTANT_SKIP", "DEGRADE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum CreationReviewState extends Enum<CreationReviewState> {
    public static final CreationReviewState DEGRADE = null;
    public static final CreationReviewState INSTANT_SKIP = null;
    public static final CreationReviewState PASS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReviewState[] f372990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f372991b = null;
    private final String value;

    public static EnumEntries<CreationReviewState> getEntries() {
        return f372991b;
    }

    static {
        CreationReviewState r100 = new CreationReviewState("PASS", 0, "pass");
        PASS = r100;
        CreationReviewState r101 = new CreationReviewState("INSTANT_SKIP", 1, "instant_skip");
        INSTANT_SKIP = r101;
        CreationReviewState r102 = new CreationReviewState("DEGRADE", 2, "degrade");
        DEGRADE = r102;
        CreationReviewState[] r103 = {r100, r101, r102};
        f372990a = r103;
        f372991b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreationReviewState[] values() {
        return (CreationReviewState[]) f372990a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationReviewState valueOf(String r100) {
        return (CreationReviewState) r27.a.a(CreationReviewState.class, r100);
    }

    public CreationReviewState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
