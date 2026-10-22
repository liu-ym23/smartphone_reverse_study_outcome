package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/bean/message/UpLinkState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PROCESSING", "SUCCESS", "FAIL", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpLinkState extends Enum<UpLinkState> {
    public static final a Companion = null;
    public static final UpLinkState DEFAULT = null;
    public static final UpLinkState FAIL = null;
    public static final UpLinkState PROCESSING = null;
    public static final UpLinkState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpLinkState[] f346732a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346733b = null;
    private final int value;

    public static EnumEntries<UpLinkState> getEntries() {
        return f346733b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.im.bean.message.UpLinkState$a] */
    static {
        UpLinkState r100 = new UpLinkState("DEFAULT", 0, 0);
        DEFAULT = r100;
        UpLinkState r101 = new UpLinkState("PROCESSING", 1, 1);
        PROCESSING = r101;
        UpLinkState r102 = new UpLinkState("SUCCESS", 2, 2);
        SUCCESS = r102;
        UpLinkState r103 = new UpLinkState("FAIL", 3, 3);
        FAIL = r103;
        UpLinkState[] r104 = {r100, r101, r102, r103};
        f346732a = r104;
        f346733b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static UpLinkState[] values() {
        return (UpLinkState[]) f346732a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UpLinkState valueOf(String r100) {
        return (UpLinkState) r27.a.a(UpLinkState.class, r100);
    }

    public UpLinkState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
