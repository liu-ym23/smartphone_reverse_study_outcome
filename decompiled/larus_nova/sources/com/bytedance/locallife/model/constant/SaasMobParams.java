package com.bytedance.locallife.model.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/constant/SaasMobParams;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "IS_SAAS", "SAAS_HOS_NAME", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum SaasMobParams extends Enum<SaasMobParams> {
    public static final SaasMobParams IS_SAAS = null;
    public static final SaasMobParams SAAS_HOS_NAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SaasMobParams[] f260851a = null;
    private final String key;

    public static SaasMobParams valueOf(String r100) {
        return (SaasMobParams) a.a(SaasMobParams.class, r100);
    }

    public static SaasMobParams[] values() {
        return (SaasMobParams[]) f260851a.clone();
    }

    static {
        SaasMobParams r100 = new SaasMobParams("IS_SAAS", 0, "is_saas");
        IS_SAAS = r100;
        SaasMobParams r101 = new SaasMobParams("SAAS_HOS_NAME", 1, "saas_host_name");
        SAAS_HOS_NAME = r101;
        f260851a = new SaasMobParams[]{r100, r101};
    }

    public final String getKey() {
        return this.key;
    }

    public SaasMobParams(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
