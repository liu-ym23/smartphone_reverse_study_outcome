package com.larus.im.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/im/service/BotChangeType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ADD", "UPDATE", "DELETE", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BotChangeType extends Enum<BotChangeType> {
    public static final BotChangeType ADD = null;
    public static final a Companion = null;
    public static final BotChangeType DELETE = null;
    public static final BotChangeType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BotChangeType[] f350609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350610b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BotChangeType> getEntries() {
        return f350610b;
    }

    static {
        BotChangeType r100 = new BotChangeType("ADD", 0, 1);
        ADD = r100;
        BotChangeType r101 = new BotChangeType("UPDATE", 1, 2);
        UPDATE = r101;
        BotChangeType r102 = new BotChangeType("DELETE", 2, 3);
        DELETE = r102;
        BotChangeType[] r103 = {r100, r101, r102};
        f350609a = r103;
        f350610b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BotChangeType[] values() {
        return (BotChangeType[]) f350609a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BotChangeType valueOf(String r100) {
        return (BotChangeType) r27.a.a(BotChangeType.class, r100);
    }

    public BotChangeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
