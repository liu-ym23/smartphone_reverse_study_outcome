package com.larus.bmhome.chat.component.bottom.core.inputtext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/InputReferenceType;", "", "<init>", "(Ljava/lang/String;I)V", "CONTACT", "GROUP", "ATTACHMENT", "SKILL", "DRIVE", "CONVERSATION", "FILE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputReferenceType extends Enum<InputReferenceType> {
    public static final InputReferenceType ATTACHMENT = null;
    public static final InputReferenceType CONTACT = null;
    public static final InputReferenceType CONVERSATION = null;
    public static final InputReferenceType DRIVE = null;
    public static final InputReferenceType FILE = null;
    public static final InputReferenceType GROUP = null;
    public static final InputReferenceType SKILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputReferenceType[] f298625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298626b = null;

    public static EnumEntries<InputReferenceType> getEntries() {
        return f298626b;
    }

    static {
        InputReferenceType r100 = new InputReferenceType("CONTACT", 0);
        CONTACT = r100;
        InputReferenceType r101 = new InputReferenceType("GROUP", 1);
        GROUP = r101;
        InputReferenceType r102 = new InputReferenceType("ATTACHMENT", 2);
        ATTACHMENT = r102;
        InputReferenceType r103 = new InputReferenceType("SKILL", 3);
        SKILL = r103;
        InputReferenceType r104 = new InputReferenceType("DRIVE", 4);
        DRIVE = r104;
        InputReferenceType r105 = new InputReferenceType("CONVERSATION", 5);
        CONVERSATION = r105;
        InputReferenceType r110 = new InputReferenceType("FILE", 6);
        FILE = r110;
        InputReferenceType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f298625a = r111;
        f298626b = EnumEntriesKt.enumEntries(r111);
    }

    public static InputReferenceType[] values() {
        return (InputReferenceType[]) f298625a.clone();
    }

    public static InputReferenceType valueOf(String r100) {
        return (InputReferenceType) r27.a.a(InputReferenceType.class, r100);
    }

    public InputReferenceType(String r100, int r101) {
        super(r100, r101);
    }
}
