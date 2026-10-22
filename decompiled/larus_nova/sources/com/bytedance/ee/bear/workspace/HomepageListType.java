package com.bytedance.ee.bear.workspace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/workspace/HomepageListType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RECENT", "PINNED", "WORK_SPACE", "Companion", "docs-bitable-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HomepageListType extends Enum<HomepageListType> {
    public static final a Companion = null;
    public static final HomepageListType PINNED = null;
    public static final HomepageListType RECENT = null;
    public static final HomepageListType WORK_SPACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HomepageListType[] f242617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242618b = null;
    private final int value;

    public static EnumEntries<HomepageListType> getEntries() {
        return f242618b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.workspace.HomepageListType$a] */
    static {
        HomepageListType r100 = new HomepageListType("RECENT", 0, 0);
        RECENT = r100;
        HomepageListType r101 = new HomepageListType("PINNED", 1, 1);
        PINNED = r101;
        HomepageListType r102 = new HomepageListType("WORK_SPACE", 2, 3);
        WORK_SPACE = r102;
        HomepageListType[] r103 = {r100, r101, r102};
        f242617a = r103;
        f242618b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static HomepageListType[] values() {
        return (HomepageListType[]) f242617a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static HomepageListType valueOf(String r100) {
        return (HomepageListType) r27.a.a(HomepageListType.class, r100);
    }

    public HomepageListType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
