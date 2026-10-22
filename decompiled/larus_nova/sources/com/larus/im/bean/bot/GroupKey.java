package com.larus.im.bean.bot;

import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.Serializable;
import uc9.y;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/bean/bot/GroupKey;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Top", "First", "Second", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum GroupKey extends Enum<GroupKey> {
    public static final a Companion = null;
    public static final GroupKey First = null;
    public static final GroupKey Second = null;
    public static final GroupKey Top = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>> f346473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ GroupKey[] f346474b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346475c = null;
    private final String value;

    public static EnumEntries<GroupKey> getEntries() {
        return f346475c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.im.bean.bot.GroupKey$a] */
    static {
        GroupKey r100 = new GroupKey("Top", 0, "group_top");
        Top = r100;
        GroupKey r101 = new GroupKey("First", 1, "group_first");
        First = r101;
        GroupKey r102 = new GroupKey("Second", 2, "group_second");
        Second = r102;
        GroupKey[] r103 = {r100, r101, r102};
        f346474b = r103;
        f346475c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        f346473a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new y());
    }

    public static GroupKey[] values() {
        return (GroupKey[]) f346474b.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return f346473a;
    }

    public final String getValue() {
        return this.value;
    }

    public static GroupKey valueOf(String r100) {
        return (GroupKey) r27.a.a(GroupKey.class, r100);
    }

    public GroupKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
