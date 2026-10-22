package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/panel/MoreGroup;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "NORMAL", "DANGER", "features-more-panel-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoreGroup extends Enum<MoreGroup> {
    public static final MoreGroup DANGER = null;
    public static final MoreGroup NORMAL = null;
    public static final MoreGroup TOP = null;
    public static final /* synthetic */ MoreGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MoreGroup> getEntries() {
        return b;
    }

    static {
        MoreGroup r0 = new MoreGroup("TOP", 0);
        TOP = r0;
        MoreGroup r1 = new MoreGroup("NORMAL", 1);
        NORMAL = r1;
        MoreGroup r3 = new MoreGroup("DANGER", 2);
        DANGER = r3;
        MoreGroup[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MoreGroup[] values() {
        return (MoreGroup[]) a.clone();
    }

    public static MoreGroup valueOf(String r1) {
        return (MoreGroup) r27.a.a(MoreGroup.class, r1);
    }

    public MoreGroup(String r1, int r2) {
        super(r1, r2);
    }
}
