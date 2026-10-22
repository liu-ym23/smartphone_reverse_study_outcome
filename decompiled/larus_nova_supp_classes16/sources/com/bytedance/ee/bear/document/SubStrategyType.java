package com.bytedance.ee.bear.document;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/SubStrategyType;", "", "<init>", "(Ljava/lang/String;I)V", "BaseAdd", "BaseRecord", "BaseApp", "BaseMain", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubStrategyType extends Enum<SubStrategyType> {
    public static final SubStrategyType BaseAdd = null;
    public static final SubStrategyType BaseApp = null;
    public static final SubStrategyType BaseMain = null;
    public static final SubStrategyType BaseRecord = null;
    public static final /* synthetic */ SubStrategyType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SubStrategyType> getEntries() {
        return b;
    }

    static {
        SubStrategyType r0 = new SubStrategyType("BaseAdd", 0);
        BaseAdd = r0;
        SubStrategyType r1 = new SubStrategyType("BaseRecord", 1);
        BaseRecord = r1;
        SubStrategyType r3 = new SubStrategyType("BaseApp", 2);
        BaseApp = r3;
        SubStrategyType r5 = new SubStrategyType("BaseMain", 3);
        BaseMain = r5;
        SubStrategyType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static SubStrategyType[] values() {
        return (SubStrategyType[]) a.clone();
    }

    public static SubStrategyType valueOf(String r1) {
        return (SubStrategyType) r27.a.a(SubStrategyType.class, r1);
    }

    public SubStrategyType(String r1, int r2) {
        super(r1, r2);
    }
}
