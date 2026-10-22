package com.bytedance.locallife.dito.common.request;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/dito/common/request/DowngradeReason;", "", "NOT_OPEN", "SELF_DOWNGRADE", "RESPONSE_NOT_SUPPORT", "DEFAULT", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final enum DowngradeReason extends Enum<DowngradeReason> {
    public static final DowngradeReason DEFAULT = null;
    public static final DowngradeReason NOT_OPEN = null;
    public static final DowngradeReason RESPONSE_NOT_SUPPORT = null;
    public static final DowngradeReason SELF_DOWNGRADE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DowngradeReason[] f257657a = null;

    public static DowngradeReason valueOf(String r100) {
        return (DowngradeReason) r27.a.a(DowngradeReason.class, r100);
    }

    public static DowngradeReason[] values() {
        return (DowngradeReason[]) f257657a.clone();
    }

    static {
        DowngradeReason r100 = new DowngradeReason("NOT_OPEN", 0);
        NOT_OPEN = r100;
        DowngradeReason r101 = new DowngradeReason("SELF_DOWNGRADE", 1);
        SELF_DOWNGRADE = r101;
        DowngradeReason r102 = new DowngradeReason("RESPONSE_NOT_SUPPORT", 2);
        RESPONSE_NOT_SUPPORT = r102;
        DowngradeReason r103 = new DowngradeReason("DEFAULT", 3);
        DEFAULT = r103;
        f257657a = new DowngradeReason[]{r100, r101, r102, r103};
    }

    public DowngradeReason(String r100, int r101) {
        super(r100, r101);
    }
}
