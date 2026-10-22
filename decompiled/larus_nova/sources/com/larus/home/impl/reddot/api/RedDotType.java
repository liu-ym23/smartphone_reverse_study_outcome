package com.larus.home.impl.reddot.api;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/home/impl/reddot/api/RedDotType;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", CancelRetainContactInfoFunctions.All, "Conversation", "Notice", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RedDotType extends Enum<RedDotType> {
    public static final RedDotType All = null;
    public static final RedDotType Conversation = null;
    public static final RedDotType Notice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RedDotType[] f346027a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346028b = null;
    private final int index;

    public static EnumEntries<RedDotType> getEntries() {
        return f346028b;
    }

    static {
        RedDotType r100 = new RedDotType(CancelRetainContactInfoFunctions.All, 0, 1);
        All = r100;
        RedDotType r101 = new RedDotType("Conversation", 1, 2);
        Conversation = r101;
        RedDotType r102 = new RedDotType("Notice", 2, 3);
        Notice = r102;
        RedDotType[] r103 = {r100, r101, r102};
        f346027a = r103;
        f346028b = EnumEntriesKt.enumEntries(r103);
    }

    public static RedDotType[] values() {
        return (RedDotType[]) f346027a.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public static RedDotType valueOf(String r100) {
        return (RedDotType) a.a(RedDotType.class, r100);
    }

    public RedDotType(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
