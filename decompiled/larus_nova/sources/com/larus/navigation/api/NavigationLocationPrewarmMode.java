package com.larus.navigation.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/navigation/api/NavigationLocationPrewarmMode;", "", "<init>", "(Ljava/lang/String;I)V", "WALKING", "CYCLING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigationLocationPrewarmMode extends Enum<NavigationLocationPrewarmMode> {
    public static final NavigationLocationPrewarmMode CYCLING = null;
    public static final NavigationLocationPrewarmMode WALKING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationLocationPrewarmMode[] f359617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359618b = null;

    public static EnumEntries<NavigationLocationPrewarmMode> getEntries() {
        return f359618b;
    }

    static {
        NavigationLocationPrewarmMode r100 = new NavigationLocationPrewarmMode("WALKING", 0);
        WALKING = r100;
        NavigationLocationPrewarmMode r101 = new NavigationLocationPrewarmMode("CYCLING", 1);
        CYCLING = r101;
        NavigationLocationPrewarmMode[] r102 = {r100, r101};
        f359617a = r102;
        f359618b = EnumEntriesKt.enumEntries(r102);
    }

    public static NavigationLocationPrewarmMode[] values() {
        return (NavigationLocationPrewarmMode[]) f359617a.clone();
    }

    public static NavigationLocationPrewarmMode valueOf(String r100) {
        return (NavigationLocationPrewarmMode) r27.a.a(NavigationLocationPrewarmMode.class, r100);
    }

    public NavigationLocationPrewarmMode(String r100, int r101) {
        super(r100, r101);
    }
}
