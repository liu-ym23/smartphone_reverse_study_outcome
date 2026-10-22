package com.larus.utils.anim;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/utils/anim/Alignment;", "", "<init>", "(Ljava/lang/String;I)V", "Leading", "Trailing", "Center", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Alignment extends Enum<Alignment> {
    public static final Alignment Center = null;
    public static final Alignment Leading = null;
    public static final Alignment Trailing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Alignment[] f375358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f375359b = null;

    public static EnumEntries<Alignment> getEntries() {
        return f375359b;
    }

    static {
        Alignment r100 = new Alignment("Leading", 0);
        Leading = r100;
        Alignment r101 = new Alignment("Trailing", 1);
        Trailing = r101;
        Alignment r102 = new Alignment("Center", 2);
        Center = r102;
        Alignment[] r103 = {r100, r101, r102};
        f375358a = r103;
        f375359b = EnumEntriesKt.enumEntries(r103);
    }

    public static Alignment[] values() {
        return (Alignment[]) f375358a.clone();
    }

    public static Alignment valueOf(String r100) {
        return (Alignment) a.a(Alignment.class, r100);
    }

    public Alignment(String r100, int r101) {
        super(r100, r101);
    }
}
