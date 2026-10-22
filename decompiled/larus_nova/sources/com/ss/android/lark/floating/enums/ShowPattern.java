package com.ss.android.lark.floating.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/floating/enums/ShowPattern;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT_ACTIVITY", "FOREGROUND", "BACKGROUND", "ALL_TIME", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShowPattern extends Enum<ShowPattern> {
    public static final ShowPattern ALL_TIME = null;
    public static final ShowPattern BACKGROUND = null;
    public static final ShowPattern CURRENT_ACTIVITY = null;
    public static final ShowPattern FOREGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowPattern[] f421851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421852b = null;

    public static EnumEntries<ShowPattern> getEntries() {
        return f421852b;
    }

    static {
        ShowPattern r100 = new ShowPattern("CURRENT_ACTIVITY", 0);
        CURRENT_ACTIVITY = r100;
        ShowPattern r101 = new ShowPattern("FOREGROUND", 1);
        FOREGROUND = r101;
        ShowPattern r102 = new ShowPattern("BACKGROUND", 2);
        BACKGROUND = r102;
        ShowPattern r103 = new ShowPattern("ALL_TIME", 3);
        ALL_TIME = r103;
        ShowPattern[] r104 = {r100, r101, r102, r103};
        f421851a = r104;
        f421852b = EnumEntriesKt.enumEntries(r104);
    }

    public static ShowPattern[] values() {
        return (ShowPattern[]) f421851a.clone();
    }

    public static ShowPattern valueOf(String r100) {
        return (ShowPattern) a.a(ShowPattern.class, r100);
    }

    public ShowPattern(String r100, int r101) {
        super(r100, r101);
    }
}
