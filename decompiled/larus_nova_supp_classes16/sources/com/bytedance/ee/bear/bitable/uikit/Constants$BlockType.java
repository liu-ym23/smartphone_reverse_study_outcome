package com.bytedance.ee.bear.bitable.uikit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/Constants$BlockType;", "", "<init>", "(Ljava/lang/String;I)V", "BITABLE_FOLDER", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Constants$BlockType extends Enum<Constants$BlockType> {
    public static final Constants$BlockType BITABLE_FOLDER = null;
    public static final /* synthetic */ Constants$BlockType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Constants$BlockType> getEntries() {
        return b;
    }

    static {
        Constants$BlockType r0 = new Constants$BlockType();
        BITABLE_FOLDER = r0;
        Constants$BlockType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public Constants$BlockType() {
        super("BITABLE_FOLDER", 0);
    }

    public static Constants$BlockType[] values() {
        return (Constants$BlockType[]) a.clone();
    }

    public static Constants$BlockType valueOf(String r1) {
        return (Constants$BlockType) r27.a.a(Constants$BlockType.class, r1);
    }
}
