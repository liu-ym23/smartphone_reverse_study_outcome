package com.bytedance.ee.bear.bitable.statistic.business.recordcell;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/business/recordcell/OptionPanelScene;", "", "<init>", "(Ljava/lang/String;I)V", "LINK_OPTION", "CAS_SELECT_OPTION", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OptionPanelScene extends Enum<OptionPanelScene> {
    public static final OptionPanelScene CAS_SELECT_OPTION = null;
    public static final OptionPanelScene LINK_OPTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OptionPanelScene[] f215605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215606b = null;

    public static EnumEntries<OptionPanelScene> getEntries() {
        return f215606b;
    }

    static {
        OptionPanelScene r100 = new OptionPanelScene("LINK_OPTION", 0);
        LINK_OPTION = r100;
        OptionPanelScene r101 = new OptionPanelScene("CAS_SELECT_OPTION", 1);
        CAS_SELECT_OPTION = r101;
        OptionPanelScene[] r102 = {r100, r101};
        f215605a = r102;
        f215606b = EnumEntriesKt.enumEntries(r102);
    }

    public static OptionPanelScene[] values() {
        return (OptionPanelScene[]) f215605a.clone();
    }

    public static OptionPanelScene valueOf(String r100) {
        return (OptionPanelScene) a.a(OptionPanelScene.class, r100);
    }

    public OptionPanelScene(String r100, int r101) {
        super(r100, r101);
    }
}
