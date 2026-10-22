package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/CustomMenuJumpType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "UPLOAD_FILE", "PARSE_LINK", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CustomMenuJumpType extends Enum<CustomMenuJumpType> {
    public static final CustomMenuJumpType PARSE_LINK = null;
    public static final CustomMenuJumpType UNKNOWN = null;
    public static final CustomMenuJumpType UPLOAD_FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CustomMenuJumpType[] f312055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312056b = null;
    private final int value;

    public static EnumEntries<CustomMenuJumpType> getEntries() {
        return f312056b;
    }

    static {
        CustomMenuJumpType r100 = new CustomMenuJumpType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        CustomMenuJumpType r101 = new CustomMenuJumpType("UPLOAD_FILE", 1, 1);
        UPLOAD_FILE = r101;
        CustomMenuJumpType r102 = new CustomMenuJumpType("PARSE_LINK", 2, 2);
        PARSE_LINK = r102;
        CustomMenuJumpType[] r103 = {r100, r101, r102};
        f312055a = r103;
        f312056b = EnumEntriesKt.enumEntries(r103);
    }

    public static CustomMenuJumpType[] values() {
        return (CustomMenuJumpType[]) f312055a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CustomMenuJumpType valueOf(String r100) {
        return (CustomMenuJumpType) a.a(CustomMenuJumpType.class, r100);
    }

    public CustomMenuJumpType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
