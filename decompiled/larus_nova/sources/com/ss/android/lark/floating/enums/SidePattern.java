package com.ss.android.lark.floating.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/floating/enums/SidePattern;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LEFT", "RIGHT", "TOP", "BOTTOM", "AUTO_HORIZONTAL", "AUTO_VERTICAL", "AUTO_SIDE", "RESULT_LEFT", "RESULT_RIGHT", "RESULT_TOP", "RESULT_BOTTOM", "RESULT_HORIZONTAL", "RESULT_VERTICAL", "RESULT_SIDE", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidePattern extends Enum<SidePattern> {
    public static final SidePattern AUTO_HORIZONTAL = null;
    public static final SidePattern AUTO_SIDE = null;
    public static final SidePattern AUTO_VERTICAL = null;
    public static final SidePattern BOTTOM = null;
    public static final SidePattern DEFAULT = null;
    public static final SidePattern LEFT = null;
    public static final SidePattern RESULT_BOTTOM = null;
    public static final SidePattern RESULT_HORIZONTAL = null;
    public static final SidePattern RESULT_LEFT = null;
    public static final SidePattern RESULT_RIGHT = null;
    public static final SidePattern RESULT_SIDE = null;
    public static final SidePattern RESULT_TOP = null;
    public static final SidePattern RESULT_VERTICAL = null;
    public static final SidePattern RIGHT = null;
    public static final SidePattern TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SidePattern[] f421855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421856b = null;

    public static EnumEntries<SidePattern> getEntries() {
        return f421856b;
    }

    static {
        SidePattern r100 = new SidePattern("DEFAULT", 0);
        DEFAULT = r100;
        SidePattern r101 = new SidePattern("LEFT", 1);
        LEFT = r101;
        SidePattern r102 = new SidePattern("RIGHT", 2);
        RIGHT = r102;
        SidePattern r103 = new SidePattern("TOP", 3);
        TOP = r103;
        SidePattern r104 = new SidePattern("BOTTOM", 4);
        BOTTOM = r104;
        SidePattern r105 = new SidePattern("AUTO_HORIZONTAL", 5);
        AUTO_HORIZONTAL = r105;
        SidePattern r110 = new SidePattern("AUTO_VERTICAL", 6);
        AUTO_VERTICAL = r110;
        SidePattern r111 = new SidePattern("AUTO_SIDE", 7);
        AUTO_SIDE = r111;
        SidePattern r112 = new SidePattern("RESULT_LEFT", 8);
        RESULT_LEFT = r112;
        SidePattern r113 = new SidePattern("RESULT_RIGHT", 9);
        RESULT_RIGHT = r113;
        SidePattern r114 = new SidePattern("RESULT_TOP", 10);
        RESULT_TOP = r114;
        SidePattern r115 = new SidePattern("RESULT_BOTTOM", 11);
        RESULT_BOTTOM = r115;
        SidePattern r106 = new SidePattern("RESULT_HORIZONTAL", 12);
        RESULT_HORIZONTAL = r106;
        SidePattern r107 = new SidePattern("RESULT_VERTICAL", 13);
        RESULT_VERTICAL = r107;
        SidePattern r108 = new SidePattern("RESULT_SIDE", 14);
        RESULT_SIDE = r108;
        SidePattern[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        f421855a = r109;
        f421856b = EnumEntriesKt.enumEntries(r109);
    }

    public static SidePattern[] values() {
        return (SidePattern[]) f421855a.clone();
    }

    public static SidePattern valueOf(String r100) {
        return (SidePattern) a.a(SidePattern.class, r100);
    }

    public SidePattern(String r100, int r101) {
        super(r100, r101);
    }
}
