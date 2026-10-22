package com.obric.sva.sdk.config;

import android.content.Context;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rna.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0010H\u0016R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/sva/sdk/config/Stage1Config;", "", "<init>", "()V", "configList", "", "Lcom/obric/sva/sdk/config/Stage1Config$MiniConfig;", "getConfigList", "()Ljava/util/List;", "setConfigList", "(Ljava/util/List;)V", "size", "", "valid", "", "acquireUserConfig", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "toString", "Companion", "MiniConfig", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Stage1Config {
    public static final Companion Companion = null;
    public static final float DEFAULT_THRESHOLD = 0.65f;
    public static final String TAG = "Stage1Config";

    @SerializedName("config")
    private List<MiniConfig> configList;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/sva/sdk/config/Stage1Config$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_THRESHOLD", "", "fromJson", "Lcom/obric/sva/sdk/config/Stage1Config;", "_json", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Stage1Config fromJson(String r100) {
            Intrinsics.checkNotNullParameter(r100, "_json");
            return (Stage1Config) GsonProtectorUtils.fromJson(new Gson(), r100, Stage1Config.class);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/obric/sva/sdk/config/Stage1Config$MiniConfig;", "", "version", "", "enable", "", "threshold", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getThreshold", "()Ljava/lang/Float;", "setThreshold", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;)Lcom/obric/sva/sdk/config/Stage1Config$MiniConfig;", "equals", "other", "hashCode", "", "toString", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MiniConfig {

        @SerializedName("enable")
        private Boolean enable;

        @SerializedName("threshold")
        private Float threshold;

        @SerializedName("version")
        private String version;

        public MiniConfig() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ MiniConfig copy$default(MiniConfig r100, String r101, Boolean r102, Float r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.version;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.enable;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.threshold;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.version;
        }

        public final Boolean component2() {
            return this.enable;
        }

        public final Float component3() {
            return this.threshold;
        }

        public final MiniConfig copy(String r100, Boolean r101, Float r102) {
            return new MiniConfig(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MiniConfig) == true) goto L8;
            return false;
        L8:
            MiniConfig r101 = (MiniConfig) r100;
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.threshold, r101.threshold) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            String r100 = this.version;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.enable;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Float r107 = this.threshold;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "MiniConfig(version=" + this.version + ", enable=" + this.enable + ", threshold=" + this.threshold + ')';
        }

        public final Boolean getEnable() {
            return this.enable;
        }

        public final Float getThreshold() {
            return this.threshold;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setEnable(Boolean r100) {
            this.enable = r100;
        }

        public final void setThreshold(Float r100) {
            this.threshold = r100;
        }

        public final void setVersion(String r100) {
            this.version = r100;
        }

        public MiniConfig(String r100, Boolean r101, Float r102) {
            this.version = r100;
            this.enable = r101;
            this.threshold = r102;
        }

        public /* synthetic */ MiniConfig(String r100, Boolean r101, Float r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = Boolean.FALSE;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = Float.valueOf(0.65f);
        L11:
            this(r100, r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final int size() {
        List<MiniConfig> r100 = this.configList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public String toString() {
        return "Stage1Config(configList=" + this.configList + ')';
    }

    public final boolean valid() {
        List<MiniConfig> r100 = this.configList;
        if (r100 == null) goto L5;
        int r101 = r100.size();
    L6:
        if (r101 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = 0;
        goto L6
    }

    public Stage1Config() {
        this.configList = new ArrayList();
    }

    public final List<MiniConfig> getConfigList() {
        return this.configList;
    }

    public final String acquireUserConfig(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = b.h(r100);
        LogUtils.d(ConfigManager.TAG, "acquireUserConfig: ".concat(r101), new Object[0]);
    L18:
        e = move-exception;
        LogUtils.e(ConfigManager.TAG, "acquireUserConfig error: " + e.getMessage(), new Object[0]);
        return "";
    L4:
        if (r101.length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        return "";
    L9:
        Stage1Config r103 = Companion.fromJson(r101);     // Catch: Exception -> L18
        List<MiniConfig> r104 = this.configList;     // Catch: Exception -> L18
        if (r104 == null) goto L12;
        r104.clear();     // Catch: Exception -> L18
    L12:
        List<MiniConfig> r105 = r103.configList;     // Catch: Exception -> L18
        if (r105 == null) goto L17;
        List<MiniConfig> r106 = this.configList;     // Catch: Exception -> L18
        if (r106 == null) goto L17;
        r106.addAll(r105);     // Catch: Exception -> L18
    L17:
        return r101;
    L6:
        r102 = false;
        goto L7
    }

    public final void setConfigList(List<MiniConfig> r100) {
        this.configList = r100;
    }
}
