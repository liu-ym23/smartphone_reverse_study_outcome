package com.larus.push.impl.reminder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/push/impl/reminder/BubbleStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SIMPLE_LEFT", "SIMPLE_RIGHT", "SIMPLE_LEFT_WITH_SUB_AVATAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BubbleStyle extends Enum<BubbleStyle> {
    public static final BubbleStyle SIMPLE_LEFT = null;
    public static final BubbleStyle SIMPLE_LEFT_WITH_SUB_AVATAR = null;
    public static final BubbleStyle SIMPLE_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BubbleStyle[] f367099a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367100b = null;
    private final int value;

    public static EnumEntries<BubbleStyle> getEntries() {
        return f367100b;
    }

    static {
        BubbleStyle r100 = new BubbleStyle("SIMPLE_LEFT", 0, 1);
        SIMPLE_LEFT = r100;
        BubbleStyle r101 = new BubbleStyle("SIMPLE_RIGHT", 1, 2);
        SIMPLE_RIGHT = r101;
        BubbleStyle r102 = new BubbleStyle("SIMPLE_LEFT_WITH_SUB_AVATAR", 2, 3);
        SIMPLE_LEFT_WITH_SUB_AVATAR = r102;
        BubbleStyle[] r103 = {r100, r101, r102};
        f367099a = r103;
        f367100b = EnumEntriesKt.enumEntries(r103);
    }

    public static BubbleStyle[] values() {
        return (BubbleStyle[]) f367099a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BubbleStyle valueOf(String r100) {
        return (BubbleStyle) r27.a.a(BubbleStyle.class, r100);
    }

    public BubbleStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
