package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/bean/DisplayType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Text", "RichMedia", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DisplayType extends Enum<DisplayType> {
    public static final DisplayType RichMedia = null;
    public static final DisplayType Text = null;
    public static final DisplayType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayType[] f297409a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297410b = null;
    private final int value;

    public static EnumEntries<DisplayType> getEntries() {
        return f297410b;
    }

    static {
        DisplayType r100 = new DisplayType("Unknown", 0, 0);
        Unknown = r100;
        DisplayType r101 = new DisplayType("Text", 1, 1);
        Text = r101;
        DisplayType r102 = new DisplayType("RichMedia", 2, 2);
        RichMedia = r102;
        DisplayType[] r103 = {r100, r101, r102};
        f297409a = r103;
        f297410b = EnumEntriesKt.enumEntries(r103);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) f297409a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DisplayType valueOf(String r100) {
        return (DisplayType) r27.a.a(DisplayType.class, r100);
    }

    public DisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
