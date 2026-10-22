package com.larus.voicecall.impl.degrade.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010 \u001a\u00020\tH\u0016J\u0013\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J[\u0010'\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010¨\u0006."}, d2 = {"Lcom/larus/voicecall/impl/degrade/bean/RealtimeCallDegradeConfig;", "Ljava/io/Serializable;", "downgradeConfigs", "", "Lcom/larus/voicecall/impl/degrade/bean/DowngradeConfig;", "requestExpireTime", "", "configCacheExpireTime", "configMd5", "", "backupMd5", "backupConfig", "Lcom/larus/voicecall/impl/degrade/bean/BackupDegradeConfig;", "<init>", "(Ljava/util/List;JJLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDowngradeConfigs", "()Ljava/util/List;", "setDowngradeConfigs", "(Ljava/util/List;)V", "getRequestExpireTime", "()J", "setRequestExpireTime", "(J)V", "getConfigCacheExpireTime", "setConfigCacheExpireTime", "getConfigMd5", "()Ljava/lang/String;", "setConfigMd5", "(Ljava/lang/String;)V", "getBackupMd5", "setBackupMd5", "getBackupConfig", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallDegradeConfig implements Serializable {

    @SerializedName("backup")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<BackupDegradeConfig> backupConfig;

    @SerializedName("backup_md5")
    private String backupMd5;

    @SerializedName("config_cache_expire_time")
    private long configCacheExpireTime;

    @SerializedName("downgrade_configs_md5")
    private String configMd5;

    @SerializedName("downgrade_configs")
    private List<DowngradeConfig> downgradeConfigs;

    @SerializedName("request_expire_time")
    private long requestExpireTime;

    public RealtimeCallDegradeConfig() {
        this(null, 0, 0, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RealtimeCallDegradeConfig copy$default(RealtimeCallDegradeConfig r100, List r110, long r111, long r112, String r113, String r114, List r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        List r101 = r100.downgradeConfigs;
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r102 = r100.requestExpireTime;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.configCacheExpireTime;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.configMd5;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r100.backupMd5;
    L23:
        if ((r116 & 32) == 0) goto L25;
        List r106 = r100.backupConfig;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final List<DowngradeConfig> component1() {
        return this.downgradeConfigs;
    }

    public final long component2() {
        return this.requestExpireTime;
    }

    public final long component3() {
        return this.configCacheExpireTime;
    }

    public final String component4() {
        return this.configMd5;
    }

    public final String component5() {
        return this.backupMd5;
    }

    public final List<BackupDegradeConfig> component6() {
        return this.backupConfig;
    }

    public final RealtimeCallDegradeConfig copy(List<DowngradeConfig> r110, long r111, long r112, String r113, String r114, List<BackupDegradeConfig> r115) {
        return new RealtimeCallDegradeConfig(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealtimeCallDegradeConfig) == true) goto L8;
        return false;
    L8:
        RealtimeCallDegradeConfig r101 = (RealtimeCallDegradeConfig) r100;
        if (Intrinsics.areEqual(this.downgradeConfigs, r101.downgradeConfigs) == true) goto L12;
        return false;
    L12:
        if (this.requestExpireTime == r101.requestExpireTime) goto L15;
        return false;
    L15:
        if (this.configCacheExpireTime == r101.configCacheExpireTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.configMd5, r101.configMd5) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backupMd5, r101.backupMd5) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.backupConfig, r101.backupConfig) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        List<DowngradeConfig> r100 = this.downgradeConfigs;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.requestExpireTime;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.configCacheExpireTime;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.configMd5;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.backupMd5;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        List<BackupDegradeConfig> r113 = this.backupConfig;
        if (r113 == null) goto L19;
        r101 = r113.hashCode();
    L19:
        return r112 + r101;
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "hashCode = " + hashCode() + " requestExpireTime = " + this.requestExpireTime + " configCacheExpireTime = " + this.configCacheExpireTime;
    }

    public final List<BackupDegradeConfig> getBackupConfig() {
        return this.backupConfig;
    }

    public final String getBackupMd5() {
        return this.backupMd5;
    }

    public final long getConfigCacheExpireTime() {
        return this.configCacheExpireTime;
    }

    public final String getConfigMd5() {
        return this.configMd5;
    }

    public final List<DowngradeConfig> getDowngradeConfigs() {
        return this.downgradeConfigs;
    }

    public final long getRequestExpireTime() {
        return this.requestExpireTime;
    }

    public final void setBackupMd5(String r100) {
        this.backupMd5 = r100;
    }

    public final void setConfigCacheExpireTime(long r100) {
        this.configCacheExpireTime = r100;
    }

    public final void setConfigMd5(String r100) {
        this.configMd5 = r100;
    }

    public final void setDowngradeConfigs(List<DowngradeConfig> r100) {
        this.downgradeConfigs = r100;
    }

    public final void setRequestExpireTime(long r100) {
        this.requestExpireTime = r100;
    }

    public RealtimeCallDegradeConfig(List<DowngradeConfig> r100, long r101, long r102, String r103, String r104, List<BackupDegradeConfig> r105) {
        this.downgradeConfigs = r100;
        this.requestExpireTime = r101;
        this.configCacheExpireTime = r102;
        this.configMd5 = r103;
        this.backupMd5 = r104;
        this.backupConfig = r105;
    }

    public /* synthetic */ RealtimeCallDegradeConfig(List r110, long r111, long r112, String r113, String r114, List r115, int r116, DefaultConstructorMarker r117) {
        List r100 = null;
        if ((r116 & 1) == 0) goto L5;
        List r101 = null;
    L6:
        long r102 = -1;
        if ((r116 & 2) == 0) goto L9;
        long r103 = -1;
    L11:
        if ((r116 & 4) != 0) goto L15;
        r102 = r112;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r116 & 32) != 0) goto L26;
        r100 = r115;
    L26:
        this(r101, r103, r102, r104, r105, r100);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
