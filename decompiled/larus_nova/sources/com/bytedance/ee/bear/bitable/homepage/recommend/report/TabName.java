package com.bytedance.ee.bear.bitable.homepage.recommend.report;

import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/report/TabName;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RECOMMEND", "RECOMMEND_H5", "PERSONAL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabName extends Enum<TabName> {
    public static final TabName PERSONAL = null;
    public static final TabName RECOMMEND = null;
    public static final TabName RECOMMEND_H5 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabName[] f213054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213055b = null;
    private final String value;

    public static EnumEntries<TabName> getEntries() {
        return f213055b;
    }

    static {
        TabName r100 = new TabName("RECOMMEND", 0, "recommend");
        RECOMMEND = r100;
        TabName r101 = new TabName("RECOMMEND_H5", 1, "recommend_h5");
        RECOMMEND_H5 = r101;
        TabName r102 = new TabName("PERSONAL", 2, WikiSpaceType.PERSONAL);
        PERSONAL = r102;
        TabName[] r103 = {r100, r101, r102};
        f213054a = r103;
        f213055b = EnumEntriesKt.enumEntries(r103);
    }

    public static TabName[] values() {
        return (TabName[]) f213054a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static TabName valueOf(String r100) {
        return (TabName) a.a(TabName.class, r100);
    }

    public TabName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
