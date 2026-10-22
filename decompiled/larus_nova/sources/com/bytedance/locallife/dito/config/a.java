package com.bytedance.locallife.dito.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/dito/config/a;", "", "", "enable", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "", "sceneList", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "delayMode", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("delay_mode")
    private final Integer delayMode;

    @SerializedName("enable_v2")
    private final Integer enable;

    @SerializedName("scene_list")
    private final String[] sceneList;

    public a() {
        this(0);
    }

    public final Integer a() {
        return this.delayMode;
    }

    public final Integer b() {
        return this.enable;
    }

    public final String[] c() {
        return this.sceneList;
    }

    public a(int r100) {
        this.enable = null;
        this.sceneList = null;
        this.delayMode = null;
    }
}
