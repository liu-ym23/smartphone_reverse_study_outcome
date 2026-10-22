package com.larus.dora.impl.resource;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceTheme;", "", "directoryName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDirectoryName", "()Ljava/lang/String;", "LIGHT", "NIGHT", "lookupOrder", "", "getLookupOrder$impl_mainlandRelease", "()Ljava/util/List;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceTheme extends Enum<DoraResourceTheme> {
    public static final DoraResourceTheme LIGHT = null;
    public static final DoraResourceTheme NIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceTheme[] f337832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337833b = null;
    private final String directoryName;

    public static EnumEntries<DoraResourceTheme> getEntries() {
        return f337833b;
    }

    static {
        DoraResourceTheme r100 = new DoraResourceTheme("LIGHT", 0, "light");
        LIGHT = r100;
        DoraResourceTheme r101 = new DoraResourceTheme("NIGHT", 1, "night");
        NIGHT = r101;
        DoraResourceTheme[] r102 = {r100, r101};
        f337832a = r102;
        f337833b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraResourceTheme[] values() {
        return (DoraResourceTheme[]) f337832a.clone();
    }

    public final List<DoraResourceTheme> getLookupOrder$impl_mainlandRelease() {
        DoraResourceTheme r100 = NIGHT;
        if (this != r100) goto L6;
        return CollectionsKt.listOf(new DoraResourceTheme[]{r100, LIGHT});
    L6:
        return CollectionsKt.listOf(LIGHT);
    }

    public final String getDirectoryName() {
        return this.directoryName;
    }

    public static DoraResourceTheme valueOf(String r100) {
        return (DoraResourceTheme) r27.a.a(DoraResourceTheme.class, r100);
    }

    public DoraResourceTheme(String r100, int r101, String r102) {
        super(r100, r101);
        this.directoryName = r102;
    }
}
