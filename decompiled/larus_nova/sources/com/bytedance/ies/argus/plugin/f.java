package com.bytedance.ies.argus.plugin;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/argus/plugin/f;", "Lcom/bytedance/ies/argus/plugin/a;", "", "firstLoadMaxRiskLevel", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "redirectMaxRiskLevel", "e", "", "checkScene", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "firstUseSync", "Z", "d", "()Z", "redirectUseSync", "f", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class f extends a {

    @SerializedName("check_scene")
    private final String checkScene;

    @SerializedName("first_load_max_risk_level")
    private final Integer firstLoadMaxRiskLevel;

    @SerializedName("first_use_sync")
    private final boolean firstUseSync;

    @SerializedName("redirect_max_risk_level")
    private final Integer redirectMaxRiskLevel;

    @SerializedName("redirect_use_sync")
    private final boolean redirectUseSync;

    public f() {
        this(0);
    }

    public final String b() {
        return this.checkScene;
    }

    public final Integer c() {
        return this.firstLoadMaxRiskLevel;
    }

    public final boolean d() {
        return this.firstUseSync;
    }

    public final Integer e() {
        return this.redirectMaxRiskLevel;
    }

    public final boolean f() {
        return this.redirectUseSync;
    }

    public f(int r100) {
        this.firstLoadMaxRiskLevel = 2;
        this.redirectMaxRiskLevel = 8;
        this.checkScene = null;
        this.firstUseSync = false;
        this.redirectUseSync = false;
    }
}
