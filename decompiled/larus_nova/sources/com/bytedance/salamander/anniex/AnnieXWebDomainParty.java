package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXWebDomainParty;", "", "", "value", "I", "getValue", "()I", "FIRST", "SECOND", "THIRD", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXWebDomainParty extends Enum<AnnieXWebDomainParty> {
    public static final AnnieXWebDomainParty FIRST = null;
    public static final AnnieXWebDomainParty SECOND = null;
    public static final AnnieXWebDomainParty THIRD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnnieXWebDomainParty[] f267864a = null;
    private final int value;

    public static AnnieXWebDomainParty valueOf(String r100) {
        return (AnnieXWebDomainParty) r27.a.a(AnnieXWebDomainParty.class, r100);
    }

    public static AnnieXWebDomainParty[] values() {
        return (AnnieXWebDomainParty[]) f267864a.clone();
    }

    static {
        AnnieXWebDomainParty r100 = new AnnieXWebDomainParty("FIRST", 0, 1);
        FIRST = r100;
        AnnieXWebDomainParty r101 = new AnnieXWebDomainParty("SECOND", 1, 2);
        SECOND = r101;
        AnnieXWebDomainParty r102 = new AnnieXWebDomainParty("THIRD", 2, 3);
        THIRD = r102;
        f267864a = new AnnieXWebDomainParty[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public AnnieXWebDomainParty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
