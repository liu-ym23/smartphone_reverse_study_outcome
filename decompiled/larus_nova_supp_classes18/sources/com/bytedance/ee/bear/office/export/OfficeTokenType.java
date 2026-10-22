package com.bytedance.ee.bear.office.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/OfficeTokenType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OFFLINE", "NONE", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeTokenType extends Enum<OfficeTokenType> {
    public static final OfficeTokenType NONE = null;
    public static final OfficeTokenType OFFLINE = null;
    public static final /* synthetic */ OfficeTokenType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<OfficeTokenType> getEntries() {
        return b;
    }

    static {
        OfficeTokenType r0 = new OfficeTokenType("OFFLINE", 0, "OFL");
        OFFLINE = r0;
        OfficeTokenType r1 = new OfficeTokenType("NONE", 1, "NONE");
        NONE = r1;
        OfficeTokenType[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static OfficeTokenType[] values() {
        return (OfficeTokenType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static OfficeTokenType valueOf(String r1) {
        return (OfficeTokenType) a.a(OfficeTokenType.class, r1);
    }

    public OfficeTokenType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
