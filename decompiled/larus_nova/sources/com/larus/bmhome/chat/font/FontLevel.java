package com.larus.bmhome.chat.font;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/font/FontLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXTRA_SMALL", "SMALL", "STANDARD", "LARGE", "EXTRA_LARGE", "SUPER_EXTRA_LARGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FontLevel extends Enum<FontLevel> {
    public static final FontLevel EXTRA_LARGE = null;
    public static final FontLevel EXTRA_SMALL = null;
    public static final FontLevel LARGE = null;
    public static final FontLevel SMALL = null;
    public static final FontLevel STANDARD = null;
    public static final FontLevel SUPER_EXTRA_LARGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FontLevel[] f303017a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303018b = null;
    private final int value;

    public static EnumEntries<FontLevel> getEntries() {
        return f303018b;
    }

    static {
        FontLevel r100 = new FontLevel("EXTRA_SMALL", 0, -2);
        EXTRA_SMALL = r100;
        FontLevel r101 = new FontLevel("SMALL", 1, -1);
        SMALL = r101;
        FontLevel r102 = new FontLevel("STANDARD", 2, 0);
        STANDARD = r102;
        FontLevel r103 = new FontLevel("LARGE", 3, 1);
        LARGE = r103;
        FontLevel r104 = new FontLevel("EXTRA_LARGE", 4, 2);
        EXTRA_LARGE = r104;
        FontLevel r105 = new FontLevel("SUPER_EXTRA_LARGE", 5, 3);
        SUPER_EXTRA_LARGE = r105;
        FontLevel[] r110 = {r100, r101, r102, r103, r104, r105};
        f303017a = r110;
        f303018b = EnumEntriesKt.enumEntries(r110);
    }

    public static FontLevel[] values() {
        return (FontLevel[]) f303017a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FontLevel valueOf(String r100) {
        return (FontLevel) a.a(FontLevel.class, r100);
    }

    public FontLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
