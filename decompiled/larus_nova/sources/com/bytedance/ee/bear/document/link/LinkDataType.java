package com.bytedance.ee.bear.document.link;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/link/LinkDataType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "EDIT", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LinkDataType extends Enum<LinkDataType> {
    public static final LinkDataType ADD = null;
    public static final LinkDataType EDIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkDataType[] f220159a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f220160b = null;

    public static EnumEntries<LinkDataType> getEntries() {
        return f220160b;
    }

    static {
        LinkDataType r100 = new LinkDataType("ADD", 0);
        ADD = r100;
        LinkDataType r101 = new LinkDataType("EDIT", 1);
        EDIT = r101;
        LinkDataType[] r102 = {r100, r101};
        f220159a = r102;
        f220160b = EnumEntriesKt.enumEntries(r102);
    }

    public static LinkDataType[] values() {
        return (LinkDataType[]) f220159a.clone();
    }

    public static LinkDataType valueOf(String r100) {
        return (LinkDataType) a.a(LinkDataType.class, r100);
    }

    public LinkDataType(String r100, int r101) {
        super(r100, r101);
    }
}
