package com.bytedance.ee.bear.document.edit_toolbar.link;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/document/edit_toolbar/link/LinkDataType;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "EDIT", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LinkDataType extends Enum<LinkDataType> {
    public static final LinkDataType ADD = null;
    public static final LinkDataType EDIT = null;
    public static final /* synthetic */ LinkDataType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<LinkDataType> getEntries() {
        return b;
    }

    static {
        LinkDataType r0 = new LinkDataType("ADD", 0);
        ADD = r0;
        LinkDataType r1 = new LinkDataType("EDIT", 1);
        EDIT = r1;
        LinkDataType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static LinkDataType[] values() {
        return (LinkDataType[]) a.clone();
    }

    public static LinkDataType valueOf(String r1) {
        return (LinkDataType) a.a(LinkDataType.class, r1);
    }

    public LinkDataType(String r1, int r2) {
        super(r1, r2);
    }
}
