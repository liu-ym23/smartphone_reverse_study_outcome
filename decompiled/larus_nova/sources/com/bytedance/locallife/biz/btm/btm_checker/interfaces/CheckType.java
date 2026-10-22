package com.bytedance.locallife.biz.btm.btm_checker.interfaces;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/biz/btm/btm_checker/interfaces/CheckType;", "", "COVER", "VALID", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum CheckType extends Enum<CheckType> {
    public static final CheckType COVER = null;
    public static final CheckType VALID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckType[] f256562a = null;

    public static CheckType valueOf(String r100) {
        return (CheckType) a.a(CheckType.class, r100);
    }

    public static CheckType[] values() {
        return (CheckType[]) f256562a.clone();
    }

    static {
        CheckType r100 = new CheckType("COVER", 0);
        COVER = r100;
        CheckType r101 = new CheckType("VALID", 1);
        VALID = r101;
        f256562a = new CheckType[]{r100, r101};
    }

    public CheckType(String r100, int r101) {
        super(r100, r101);
    }
}
