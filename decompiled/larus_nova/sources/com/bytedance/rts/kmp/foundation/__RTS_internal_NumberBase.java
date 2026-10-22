package com.bytedance.rts.kmp.foundation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/rts/kmp/foundation/__RTS_internal_NumberBase;", "", "value", "", "<init>", "(Ljava/lang/String;IJ)V", "getValue", "()J", "DECIMAL", "HEX", "OCTAL", "BINARY", "rts2native_kmp_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum __RTS_internal_NumberBase extends Enum<__RTS_internal_NumberBase> {
    public static final __RTS_internal_NumberBase BINARY = null;
    public static final __RTS_internal_NumberBase DECIMAL = null;
    public static final __RTS_internal_NumberBase HEX = null;
    public static final __RTS_internal_NumberBase OCTAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ __RTS_internal_NumberBase[] f267603a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f267604b = null;
    private final long value;

    public static EnumEntries<__RTS_internal_NumberBase> getEntries() {
        return f267604b;
    }

    static {
        __RTS_internal_NumberBase r100 = new __RTS_internal_NumberBase("DECIMAL", 0, 10);
        DECIMAL = r100;
        __RTS_internal_NumberBase r101 = new __RTS_internal_NumberBase("HEX", 1, 16);
        HEX = r101;
        __RTS_internal_NumberBase r102 = new __RTS_internal_NumberBase("OCTAL", 2, 8);
        OCTAL = r102;
        __RTS_internal_NumberBase r103 = new __RTS_internal_NumberBase("BINARY", 3, 2);
        BINARY = r103;
        __RTS_internal_NumberBase[] r104 = {r100, r101, r102, r103};
        f267603a = r104;
        f267604b = EnumEntriesKt.enumEntries(r104);
    }

    public static __RTS_internal_NumberBase[] values() {
        return (__RTS_internal_NumberBase[]) f267603a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public static __RTS_internal_NumberBase valueOf(String r100) {
        return (__RTS_internal_NumberBase) r27.a.a(__RTS_internal_NumberBase.class, r100);
    }

    public __RTS_internal_NumberBase(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
