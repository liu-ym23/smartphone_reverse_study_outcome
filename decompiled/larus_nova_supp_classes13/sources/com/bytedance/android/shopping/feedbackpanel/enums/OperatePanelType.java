package com.bytedance.android.shopping.feedbackpanel.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/enums/OperatePanelType;", "", "SHOW", "CLOSE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperatePanelType extends Enum<OperatePanelType> {
    public static final OperatePanelType CLOSE = null;
    public static final OperatePanelType SHOW = null;
    public static final /* synthetic */ OperatePanelType[] a = null;

    static {
        OperatePanelType r1 = new OperatePanelType("SHOW", 0);
        SHOW = r1;
        OperatePanelType r2 = new OperatePanelType("CLOSE", 1);
        CLOSE = r2;
        a = new OperatePanelType[]{r1, r2};
    }

    public static OperatePanelType valueOf(String r1) {
        return (OperatePanelType) a.a(OperatePanelType.class, r1);
    }

    public static OperatePanelType[] values() {
        return (OperatePanelType[]) a.clone();
    }

    public OperatePanelType(String r1, int r2) {
        super(r1, r2);
    }
}
