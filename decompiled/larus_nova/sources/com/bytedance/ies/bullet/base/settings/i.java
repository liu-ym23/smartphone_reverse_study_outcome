package com.bytedance.ies.bullet.base.settings;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/base/settings/i;", "", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "", "", "Lcom/bytedance/ies/bullet/base/settings/k;", "aspectConfigs", "Ljava/util/Map;", "getAspectConfigs", "()Ljava/util/Map;", "setAspectConfigs", "(Ljava/util/Map;)V", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("debug_aspect_config")
    private Map<String, k> aspectConfigs;

    @SerializedName("enable")
    private Boolean enable;

    public i() {
        this.enable = Boolean.TRUE;
    }
}
