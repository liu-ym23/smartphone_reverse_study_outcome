package com.bytedance.ee.bear.bitable.statistic.business.recordcell;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/business/recordcell/OptionPanelScene;", "", "<init>", "(Ljava/lang/String;I)V", "LINK_OPTION", "CAS_SELECT_OPTION", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OptionPanelScene extends Enum<OptionPanelScene> {
    public static final OptionPanelScene CAS_SELECT_OPTION = null;
    public static final OptionPanelScene LINK_OPTION = null;
    public static final /* synthetic */ OptionPanelScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OptionPanelScene> getEntries() {
        return b;
    }

    static {
        OptionPanelScene r0 = new OptionPanelScene("LINK_OPTION", 0);
        LINK_OPTION = r0;
        OptionPanelScene r1 = new OptionPanelScene("CAS_SELECT_OPTION", 1);
        CAS_SELECT_OPTION = r1;
        OptionPanelScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OptionPanelScene[] values() {
        return (OptionPanelScene[]) a.clone();
    }

    public static OptionPanelScene valueOf(String r1) {
        return (OptionPanelScene) a.a(OptionPanelScene.class, r1);
    }

    public OptionPanelScene(String r1, int r2) {
        super(r1, r2);
    }
}
