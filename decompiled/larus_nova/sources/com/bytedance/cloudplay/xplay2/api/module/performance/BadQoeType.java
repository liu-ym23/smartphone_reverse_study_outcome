package com.bytedance.cloudplay.xplay2.api.module.performance;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/module/performance/BadQoeType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "BLUR", "BLOCK", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum BadQoeType extends Enum<BadQoeType> {
    public static final BadQoeType BLOCK = null;
    public static final BadQoeType BLUR = null;
    public static final a Companion = null;
    public static final BadQoeType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BadQoeType[] f202799a = null;
    private final int value;

    public static BadQoeType valueOf(String r100) {
        return (BadQoeType) r27.a.a(BadQoeType.class, r100);
    }

    public static BadQoeType[] values() {
        return (BadQoeType[]) f202799a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.cloudplay.xplay2.api.module.performance.BadQoeType$a] */
    static {
        BadQoeType r100 = new BadQoeType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        BadQoeType r101 = new BadQoeType("BLUR", 1, 1);
        BLUR = r101;
        BadQoeType r102 = new BadQoeType("BLOCK", 2, 2);
        BLOCK = r102;
        f202799a = new BadQoeType[]{r100, r101, r102};
        Companion = new a();
    }

    public final int getValue() {
        return this.value;
    }

    public BadQoeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
