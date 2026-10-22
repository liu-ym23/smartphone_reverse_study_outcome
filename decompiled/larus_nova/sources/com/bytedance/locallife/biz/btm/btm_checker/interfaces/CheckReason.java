package com.bytedance.locallife.biz.btm.btm_checker.interfaces;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/biz/btm/btm_checker/interfaces/CheckReason;", "", "SUCCESS", "COVER_BTM_NULL", "COVER_BTM_PRE_CD_NULL", "BTM_INVALID", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum CheckReason extends Enum<CheckReason> {
    public static final CheckReason BTM_INVALID = null;
    public static final CheckReason COVER_BTM_NULL = null;
    public static final CheckReason COVER_BTM_PRE_CD_NULL = null;
    public static final CheckReason SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckReason[] f256561a = null;

    public static CheckReason valueOf(String r100) {
        return (CheckReason) a.a(CheckReason.class, r100);
    }

    public static CheckReason[] values() {
        return (CheckReason[]) f256561a.clone();
    }

    static {
        CheckReason r100 = new CheckReason("SUCCESS", 0);
        SUCCESS = r100;
        CheckReason r101 = new CheckReason("COVER_BTM_NULL", 1);
        COVER_BTM_NULL = r101;
        CheckReason r102 = new CheckReason("COVER_BTM_PRE_CD_NULL", 2);
        COVER_BTM_PRE_CD_NULL = r102;
        CheckReason r103 = new CheckReason("BTM_INVALID", 3);
        BTM_INVALID = r103;
        f256561a = new CheckReason[]{r100, r101, r102, r103};
    }

    public CheckReason(String r100, int r101) {
        super(r100, r101);
    }
}
