package com.bytedance.ug.sdk.tools.check.api.model;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum CheckType extends Enum<CheckType> {
    public static final CheckType DYNAMIC = null;
    public static final CheckType STATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckType[] f272361a = null;

    static {
        CheckType r100 = new CheckType("STATIC", 0);
        STATIC = r100;
        CheckType r101 = new CheckType(BannerBizName.DYNAMIC, 1);
        DYNAMIC = r101;
        f272361a = new CheckType[]{r100, r101};
    }

    public static CheckType[] values() {
        return (CheckType[]) f272361a.clone();
    }

    public static CheckType valueOf(String r100) {
        return (CheckType) a.a(CheckType.class, r100);
    }

    public CheckType(String r100, int r101) {
        super(r100, r101);
    }
}
