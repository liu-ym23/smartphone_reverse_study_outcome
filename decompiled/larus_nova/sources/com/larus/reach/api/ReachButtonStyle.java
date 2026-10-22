package com.larus.reach.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/api/ReachButtonStyle;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "PLAIN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReachButtonStyle extends Enum<ReachButtonStyle> {
    public static final ReachButtonStyle PLAIN = null;
    public static final ReachButtonStyle PRIMARY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReachButtonStyle[] f367117a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f367118b = null;

    public static EnumEntries<ReachButtonStyle> getEntries() {
        return f367118b;
    }

    static {
        ReachButtonStyle r100 = new ReachButtonStyle("PRIMARY", 0);
        PRIMARY = r100;
        ReachButtonStyle r101 = new ReachButtonStyle("PLAIN", 1);
        PLAIN = r101;
        ReachButtonStyle[] r102 = {r100, r101};
        f367117a = r102;
        f367118b = EnumEntriesKt.enumEntries(r102);
    }

    public static ReachButtonStyle[] values() {
        return (ReachButtonStyle[]) f367117a.clone();
    }

    public static ReachButtonStyle valueOf(String r100) {
        return (ReachButtonStyle) a.a(ReachButtonStyle.class, r100);
    }

    public ReachButtonStyle(String r100, int r101) {
        super(r100, r101);
    }
}
