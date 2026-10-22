package com.bytedance.ies.bullet.service.base.utils;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$DataSource;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "UNKNOWN", "WEB", "RN", "LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum KitType extends Enum<KitType> {
    public static final KitType LYNX = null;
    public static final KitType RN = null;
    public static final KitType UNKNOWN = null;
    public static final KitType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KitType[] f247919a = null;
    private final String tag;

    public static KitType valueOf(String r100) {
        return (KitType) a.a(KitType.class, r100);
    }

    public static KitType[] values() {
        return (KitType[]) f247919a.clone();
    }

    static {
        KitType r100 = new KitType("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        KitType r101 = new KitType("WEB", 1, "web");
        WEB = r101;
        KitType r102 = new KitType("RN", 2, DocFeed$Value$DataSource.RN);
        RN = r102;
        KitType r103 = new KitType("LYNX", 3, "lynx");
        LYNX = r103;
        f247919a = new KitType[]{r100, r101, r102, r103};
    }

    public final String getTag() {
        return this.tag;
    }

    public KitType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
