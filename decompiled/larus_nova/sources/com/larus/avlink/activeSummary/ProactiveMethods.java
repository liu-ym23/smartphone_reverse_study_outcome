package com.larus.avlink.activeSummary;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveMethods;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Frontier", "Push", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactiveMethods extends Enum<ProactiveMethods> {
    public static final ProactiveMethods Frontier = null;
    public static final ProactiveMethods Push = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProactiveMethods[] f291417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291418b = null;
    private final int value;

    public static EnumEntries<ProactiveMethods> getEntries() {
        return f291418b;
    }

    static {
        ProactiveMethods r100 = new ProactiveMethods("Frontier", 0, 2);
        Frontier = r100;
        ProactiveMethods r101 = new ProactiveMethods("Push", 1, 3);
        Push = r101;
        ProactiveMethods[] r102 = {r100, r101};
        f291417a = r102;
        f291418b = EnumEntriesKt.enumEntries(r102);
    }

    public static ProactiveMethods[] values() {
        return (ProactiveMethods[]) f291417a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ProactiveMethods valueOf(String r100) {
        return (ProactiveMethods) r27.a.a(ProactiveMethods.class, r100);
    }

    public ProactiveMethods(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
