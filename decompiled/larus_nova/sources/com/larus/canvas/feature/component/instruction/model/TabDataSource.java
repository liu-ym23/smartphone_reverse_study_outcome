package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/TabDataSource;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_LOCAL", "FROM_REMOTE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabDataSource extends Enum<TabDataSource> {
    public static final TabDataSource FROM_LOCAL = null;
    public static final TabDataSource FROM_REMOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabDataSource[] f323162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323163b = null;

    public static EnumEntries<TabDataSource> getEntries() {
        return f323163b;
    }

    static {
        TabDataSource r100 = new TabDataSource("FROM_LOCAL", 0);
        FROM_LOCAL = r100;
        TabDataSource r101 = new TabDataSource("FROM_REMOTE", 1);
        FROM_REMOTE = r101;
        TabDataSource[] r102 = {r100, r101};
        f323162a = r102;
        f323163b = EnumEntriesKt.enumEntries(r102);
    }

    public static TabDataSource[] values() {
        return (TabDataSource[]) f323162a.clone();
    }

    public static TabDataSource valueOf(String r100) {
        return (TabDataSource) r27.a.a(TabDataSource.class, r100);
    }

    public TabDataSource(String r100, int r101) {
        super(r100, r101);
    }
}
