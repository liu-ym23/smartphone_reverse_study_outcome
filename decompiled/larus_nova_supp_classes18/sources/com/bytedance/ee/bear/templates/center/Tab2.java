package com.bytedance.ee.bear.templates.center;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/templates/center/Tab2;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SYSTEM", "CUSTOM", "BUSNISS", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Tab2 extends Enum<Tab2> {
    public static final Tab2 BUSNISS = null;
    public static final Tab2 CUSTOM = null;
    public static final Tab2 SYSTEM = null;
    public static final /* synthetic */ Tab2[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Tab2> getEntries() {
        return b;
    }

    static {
        Tab2 r0 = new Tab2("SYSTEM", 0, 2131888016);
        SYSTEM = r0;
        Tab2 r1 = new Tab2("CUSTOM", 1, 2131887886);
        CUSTOM = r1;
        Tab2 r2 = new Tab2("BUSNISS", 2, 2131887904);
        BUSNISS = r2;
        Tab2[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static Tab2[] values() {
        return (Tab2[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Tab2 valueOf(String r1) {
        return (Tab2) r27.a.a(Tab2.class, r1);
    }

    public Tab2(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
