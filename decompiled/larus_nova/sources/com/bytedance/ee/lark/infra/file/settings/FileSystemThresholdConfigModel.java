package com.bytedance.ee.lark.infra.file.settings;

import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "file_system_threshold_config")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/settings/FileSystemThresholdConfigModel;", "", "<init>", "()V", "readThreshold", "Lcom/bytedance/ee/lark/infra/file/settings/FileSystemThresholdConfigModel$ThresholdConfigModel;", "getReadThreshold", "()Lcom/bytedance/ee/lark/infra/file/settings/FileSystemThresholdConfigModel$ThresholdConfigModel;", "setReadThreshold", "(Lcom/bytedance/ee/lark/infra/file/settings/FileSystemThresholdConfigModel$ThresholdConfigModel;)V", "writeThreshold", "getWriteThreshold", "setWriteThreshold", "toString", "", "ThresholdConfigModel", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSystemThresholdConfigModel {

    @SerializedName("read_threshold")
    private ThresholdConfigModel readThreshold;

    @SerializedName("write_threshold")
    private ThresholdConfigModel writeThreshold;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/settings/FileSystemThresholdConfigModel$ThresholdConfigModel;", "Ljava/io/Serializable;", "<init>", "()V", "default", "", "getDefault", "()J", "setDefault", "(J)V", "apps", "", "", "getApps", "()Ljava/util/Map;", "setApps", "(Ljava/util/Map;)V", "toString", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ThresholdConfigModel implements Serializable {

        @SerializedName("apps")
        private Map<String, Long> apps;

        /* JADX INFO: renamed from: default, reason: not valid java name */
        @SerializedName("default")
        private long f101default;

        public String toString() {
            return "ThresholdConfigModel: { default: " + this.f101default + ", apps: " + this.apps + " }";
        }

        public ThresholdConfigModel() {
            this.f101default = BdpOkClient.CACHE_MAX_SIZE;
        }

        public final Map<String, Long> getApps() {
            return this.apps;
        }

        public final long getDefault() {
            return this.f101default;
        }

        public final void setApps(Map<String, Long> r100) {
            this.apps = r100;
        }

        public final void setDefault(long r100) {
            this.f101default = r100;
        }
    }

    public FileSystemThresholdConfigModel() {
    }

    public String toString() {
        return "file_system_threshold_config: { read_threshold: " + this.readThreshold + ", write_threshold: " + this.writeThreshold + ",  }";
    }

    public final ThresholdConfigModel getReadThreshold() {
        return this.readThreshold;
    }

    public final ThresholdConfigModel getWriteThreshold() {
        return this.writeThreshold;
    }

    public final void setReadThreshold(ThresholdConfigModel r100) {
        this.readThreshold = r100;
    }

    public final void setWriteThreshold(ThresholdConfigModel r100) {
        this.writeThreshold = r100;
    }
}
