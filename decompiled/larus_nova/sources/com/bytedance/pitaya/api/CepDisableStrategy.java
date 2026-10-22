package com.bytedance.pitaya.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/CepDisableStrategy;", "", "", "code", "I", "getCode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PREVENT_INPUT", "STOP", "CLEAN", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final enum CepDisableStrategy extends Enum<CepDisableStrategy> {
    public static final CepDisableStrategy CLEAN = null;
    public static final a Companion = null;
    public static final CepDisableStrategy PREVENT_INPUT = null;
    public static final CepDisableStrategy STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CepDisableStrategy[] f266524a = null;
    private final int code;

    public static CepDisableStrategy valueOf(String r100) {
        return (CepDisableStrategy) r27.a.a(CepDisableStrategy.class, r100);
    }

    public static CepDisableStrategy[] values() {
        return (CepDisableStrategy[]) f266524a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.pitaya.api.CepDisableStrategy$a] */
    static {
        CepDisableStrategy r100 = new CepDisableStrategy("PREVENT_INPUT", 0, 0);
        PREVENT_INPUT = r100;
        CepDisableStrategy r101 = new CepDisableStrategy("STOP", 1, 1);
        STOP = r101;
        CepDisableStrategy r102 = new CepDisableStrategy("CLEAN", 2, 2);
        CLEAN = r102;
        f266524a = new CepDisableStrategy[]{r100, r101, r102};
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public CepDisableStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
