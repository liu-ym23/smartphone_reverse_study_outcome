package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MESSAGE_PIN", "URL_PIN", "ANNOUNCEMENT_PIN", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UniversalPinExtraType extends Enum<UniversalPinExtraType> {
    public static final UniversalPinExtraType ANNOUNCEMENT_PIN = null;
    public static final UniversalPinExtraType MESSAGE_PIN = null;
    public static final UniversalPinExtraType UNKNOWN = null;
    public static final UniversalPinExtraType URL_PIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UniversalPinExtraType[] f415315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415316b = null;
    private final int value;

    public static EnumEntries<UniversalPinExtraType> getEntries() {
        return f415316b;
    }

    static {
        UniversalPinExtraType r100 = new UniversalPinExtraType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        UniversalPinExtraType r101 = new UniversalPinExtraType("MESSAGE_PIN", 1, 1);
        MESSAGE_PIN = r101;
        UniversalPinExtraType r102 = new UniversalPinExtraType("URL_PIN", 2, 2);
        URL_PIN = r102;
        UniversalPinExtraType r103 = new UniversalPinExtraType("ANNOUNCEMENT_PIN", 3, 3);
        ANNOUNCEMENT_PIN = r103;
        UniversalPinExtraType[] r104 = {r100, r101, r102, r103};
        f415315a = r104;
        f415316b = EnumEntriesKt.enumEntries(r104);
    }

    public static UniversalPinExtraType[] values() {
        return (UniversalPinExtraType[]) f415315a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UniversalPinExtraType valueOf(String r100) {
        return (UniversalPinExtraType) r27.a.a(UniversalPinExtraType.class, r100);
    }

    public UniversalPinExtraType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
