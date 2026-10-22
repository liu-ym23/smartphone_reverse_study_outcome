package com.larus.utils.anim;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/utils/anim/Match;", "", "<init>", "(Ljava/lang/String;I)V", "X", "Y", "XY", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Match extends Enum<Match> {
    public static final Match X = null;
    public static final Match XY = null;
    public static final Match Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Match[] f375360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f375361b = null;

    public static EnumEntries<Match> getEntries() {
        return f375361b;
    }

    static {
        Match r100 = new Match("X", 0);
        X = r100;
        Match r101 = new Match("Y", 1);
        Y = r101;
        Match r102 = new Match("XY", 2);
        XY = r102;
        Match[] r103 = {r100, r101, r102};
        f375360a = r103;
        f375361b = EnumEntriesKt.enumEntries(r103);
    }

    public static Match[] values() {
        return (Match[]) f375360a.clone();
    }

    public static Match valueOf(String r100) {
        return (Match) a.a(Match.class, r100);
    }

    public Match(String r100, int r101) {
        super(r100, r101);
    }
}
