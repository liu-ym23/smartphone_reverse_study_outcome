package com.larus.bmhome.chat.resp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/resp/ContentDistType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Normal", "Aweme", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentDistType extends Enum<ContentDistType> {
    public static final ContentDistType Aweme = null;
    public static final ContentDistType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentDistType[] f308551a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308552b = null;
    private final int value;

    public static EnumEntries<ContentDistType> getEntries() {
        return f308552b;
    }

    static {
        ContentDistType r100 = new ContentDistType("Normal", 0, 0);
        Normal = r100;
        ContentDistType r101 = new ContentDistType("Aweme", 1, 1);
        Aweme = r101;
        ContentDistType[] r102 = {r100, r101};
        f308551a = r102;
        f308552b = EnumEntriesKt.enumEntries(r102);
    }

    public static ContentDistType[] values() {
        return (ContentDistType[]) f308551a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContentDistType valueOf(String r100) {
        return (ContentDistType) a.a(ContentDistType.class, r100);
    }

    public ContentDistType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
