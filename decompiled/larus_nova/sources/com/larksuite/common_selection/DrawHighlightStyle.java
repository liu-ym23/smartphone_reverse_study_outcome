package com.larksuite.common_selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/DrawHighlightStyle;", "", "<init>", "(Ljava/lang/String;I)V", "FOREGROUND", "BACKGROUND", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrawHighlightStyle extends Enum<DrawHighlightStyle> {
    public static final DrawHighlightStyle BACKGROUND = null;
    public static final DrawHighlightStyle FOREGROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DrawHighlightStyle[] f282825a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282826b = null;

    public static EnumEntries<DrawHighlightStyle> getEntries() {
        return f282826b;
    }

    static {
        DrawHighlightStyle r100 = new DrawHighlightStyle("FOREGROUND", 0);
        FOREGROUND = r100;
        DrawHighlightStyle r101 = new DrawHighlightStyle("BACKGROUND", 1);
        BACKGROUND = r101;
        DrawHighlightStyle[] r102 = {r100, r101};
        f282825a = r102;
        f282826b = EnumEntriesKt.enumEntries(r102);
    }

    public static DrawHighlightStyle[] values() {
        return (DrawHighlightStyle[]) f282825a.clone();
    }

    public static DrawHighlightStyle valueOf(String r100) {
        return (DrawHighlightStyle) r27.a.a(DrawHighlightStyle.class, r100);
    }

    public DrawHighlightStyle(String r100, int r101) {
        super(r100, r101);
    }
}
