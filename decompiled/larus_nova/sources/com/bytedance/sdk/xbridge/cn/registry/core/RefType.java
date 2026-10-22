package com.bytedance.sdk.xbridge.cn.registry.core;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/RefType;", "", EffectConstants.NORMAL, "WEAK", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum RefType extends Enum<RefType> {
    public static final RefType NORMAL = null;
    public static final RefType WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefType[] f270081a = null;

    public static RefType valueOf(String r100) {
        return (RefType) r27.a.a(RefType.class, r100);
    }

    public static RefType[] values() {
        return (RefType[]) f270081a.clone();
    }

    static {
        RefType r100 = new RefType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RefType r101 = new RefType("WEAK", 1);
        WEAK = r101;
        f270081a = new RefType[]{r100, r101};
    }

    public RefType(String r100, int r101) {
        super(r100, r101);
    }
}
