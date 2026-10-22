package com.bytedance.ee.bear.document.offline.sync;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/PreloadType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "CLIENTVAR", "SSR", "ALL", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreloadType extends Enum<PreloadType> {
    public static final PreloadType ALL = null;
    public static final PreloadType CLIENTVAR = null;
    public static final PreloadType NONE = null;
    public static final PreloadType SSR = null;
    public static final /* synthetic */ PreloadType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PreloadType> getEntries() {
        return b;
    }

    static {
        PreloadType r0 = new PreloadType("NONE", 0);
        NONE = r0;
        PreloadType r1 = new PreloadType("CLIENTVAR", 1);
        CLIENTVAR = r1;
        PreloadType r3 = new PreloadType("SSR", 2);
        SSR = r3;
        PreloadType r5 = new PreloadType("ALL", 3);
        ALL = r5;
        PreloadType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) a.clone();
    }

    public static PreloadType valueOf(String r1) {
        return (PreloadType) r27.a.a(PreloadType.class, r1);
    }

    public PreloadType(String r1, int r2) {
        super(r1, r2);
    }
}
