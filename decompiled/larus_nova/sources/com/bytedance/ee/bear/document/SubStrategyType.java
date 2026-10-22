package com.bytedance.ee.bear.document;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/SubStrategyType;", "", "<init>", "(Ljava/lang/String;I)V", "BaseAdd", "BaseRecord", "BaseApp", "BaseMain", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SubStrategyType extends Enum<SubStrategyType> {
    public static final SubStrategyType BaseAdd = null;
    public static final SubStrategyType BaseApp = null;
    public static final SubStrategyType BaseMain = null;
    public static final SubStrategyType BaseRecord = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubStrategyType[] f218630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218631b = null;

    public static EnumEntries<SubStrategyType> getEntries() {
        return f218631b;
    }

    static {
        SubStrategyType r100 = new SubStrategyType("BaseAdd", 0);
        BaseAdd = r100;
        SubStrategyType r101 = new SubStrategyType("BaseRecord", 1);
        BaseRecord = r101;
        SubStrategyType r102 = new SubStrategyType("BaseApp", 2);
        BaseApp = r102;
        SubStrategyType r103 = new SubStrategyType("BaseMain", 3);
        BaseMain = r103;
        SubStrategyType[] r104 = {r100, r101, r102, r103};
        f218630a = r104;
        f218631b = EnumEntriesKt.enumEntries(r104);
    }

    public static SubStrategyType[] values() {
        return (SubStrategyType[]) f218630a.clone();
    }

    public static SubStrategyType valueOf(String r100) {
        return (SubStrategyType) r27.a.a(SubStrategyType.class, r100);
    }

    public SubStrategyType(String r100, int r101) {
        super(r100, r101);
    }
}
