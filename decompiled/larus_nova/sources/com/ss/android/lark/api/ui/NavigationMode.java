package com.ss.android.lark.api.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/api/ui/NavigationMode;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM_MODE", "LEFT_NARROW_MODE", "LEFT_WIDE_MODE", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigationMode extends Enum<NavigationMode> {
    public static final NavigationMode BOTTOM_MODE = null;
    public static final NavigationMode LEFT_NARROW_MODE = null;
    public static final NavigationMode LEFT_WIDE_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationMode[] f408696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f408697b = null;

    public static EnumEntries<NavigationMode> getEntries() {
        return f408697b;
    }

    static {
        NavigationMode r100 = new NavigationMode("BOTTOM_MODE", 0);
        BOTTOM_MODE = r100;
        NavigationMode r101 = new NavigationMode("LEFT_NARROW_MODE", 1);
        LEFT_NARROW_MODE = r101;
        NavigationMode r102 = new NavigationMode("LEFT_WIDE_MODE", 2);
        LEFT_WIDE_MODE = r102;
        NavigationMode[] r103 = {r100, r101, r102};
        f408696a = r103;
        f408697b = EnumEntriesKt.enumEntries(r103);
    }

    public static NavigationMode[] values() {
        return (NavigationMode[]) f408696a.clone();
    }

    public static NavigationMode valueOf(String r100) {
        return (NavigationMode) r27.a.a(NavigationMode.class, r100);
    }

    public NavigationMode(String r100, int r101) {
        super(r100, r101);
    }
}
