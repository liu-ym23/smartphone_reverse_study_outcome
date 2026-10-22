package com.ss.android.lark.biz.im.api.extension.scroll;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/scroll/ScrollAlign;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "CENTER", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScrollAlign extends Enum<ScrollAlign> {
    public static final ScrollAlign BOTTOM = null;
    public static final ScrollAlign CENTER = null;
    public static final ScrollAlign TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollAlign[] f410220a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410221b = null;

    public static EnumEntries<ScrollAlign> getEntries() {
        return f410221b;
    }

    static {
        ScrollAlign r100 = new ScrollAlign("TOP", 0);
        TOP = r100;
        ScrollAlign r101 = new ScrollAlign("BOTTOM", 1);
        BOTTOM = r101;
        ScrollAlign r102 = new ScrollAlign("CENTER", 2);
        CENTER = r102;
        ScrollAlign[] r103 = {r100, r101, r102};
        f410220a = r103;
        f410221b = EnumEntriesKt.enumEntries(r103);
    }

    public static ScrollAlign[] values() {
        return (ScrollAlign[]) f410220a.clone();
    }

    public static ScrollAlign valueOf(String r100) {
        return (ScrollAlign) r27.a.a(ScrollAlign.class, r100);
    }

    public ScrollAlign(String r100, int r101) {
        super(r100, r101);
    }
}
