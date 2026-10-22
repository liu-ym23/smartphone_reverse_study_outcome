package com.bytedance.locallife.dito.common.plugin;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/dito/common/plugin/v;", "", "", "cubeConfig", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "preCreateCount", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "e", "(Ljava/lang/Integer;)V", "", "appendConfigQuery", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "preloadList", "Ljava/util/List;", "d", "()Ljava/util/List;", "dito-common-saas_release"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("append_config_query")
    private final Boolean appendConfigQuery;

    @SerializedName("cube_config")
    private final String cubeConfig;

    @SerializedName("pre_create_count")
    private Integer preCreateCount;

    @SerializedName("pre_load_list")
    private final List<String> preloadList;

    public v() {
        this(null);
    }

    public final Boolean a() {
        return this.appendConfigQuery;
    }

    public final String b() {
        return this.cubeConfig;
    }

    public final Integer c() {
        return this.preCreateCount;
    }

    public final List<String> d() {
        return this.preloadList;
    }

    public v(Object r100) {
        Boolean r101 = Boolean.TRUE;
        ArrayList r102 = new ArrayList();
        this.cubeConfig = null;
        this.preCreateCount = 0;
        this.appendConfigQuery = r101;
        this.preloadList = r102;
    }

    public final void e(Integer r100) {
        this.preCreateCount = r100;
    }
}
