package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/rc/SignUrlMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Inner", "Outer", "Both", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SignUrlMode extends Enum<SignUrlMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SignUrlMode[] $VALUES = null;
    public static final SignUrlMode Both = null;
    public static final SignUrlMode Inner = null;
    public static final SignUrlMode Outer = null;
    private final int value;

    private static final /* synthetic */ SignUrlMode[] $values() {
        return new SignUrlMode[]{Inner, Outer, Both};
    }

    public static EnumEntries<SignUrlMode> getEntries() {
        return $ENTRIES;
    }

    static {
        Inner = new SignUrlMode("Inner", 0, 1);
        Outer = new SignUrlMode("Outer", 1, 2);
        Both = new SignUrlMode("Both", 2, 3);
        SignUrlMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SignUrlMode[] values() {
        return (SignUrlMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return super.toString() + '(' + this.value + ')';
    }

    public final int getValue() {
        return this.value;
    }

    public static SignUrlMode valueOf(String r100) {
        return (SignUrlMode) r27.a.a(SignUrlMode.class, r100);
    }

    private SignUrlMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
