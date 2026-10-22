package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq9.g;
import lq9.j;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/audio/AudioConnectionPoolConfig;", "", "isEnabled", "", "poolConfig", "Lcom/larus/platform/model/audio/ConnectionPoolConfig;", "clientConfigMap", "", "", "Lcom/larus/platform/model/audio/ClientConfig;", "<init>", "(ZLcom/larus/platform/model/audio/ConnectionPoolConfig;Ljava/util/Map;)V", "()Z", "getPoolConfig", "()Lcom/larus/platform/model/audio/ConnectionPoolConfig;", "getClientConfigMap", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioConnectionPoolConfig {

    @SerializedName("clientConfig")
    private final Map<String, g> clientConfigMap;

    @SerializedName("enabled")
    private final boolean isEnabled;

    @SerializedName("poolConfig")
    private final j poolConfig;

    public AudioConnectionPoolConfig() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioConnectionPoolConfig copy$default(AudioConnectionPoolConfig r100, boolean r101, j r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isEnabled;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.poolConfig;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.clientConfigMap;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    public final j component2() {
        return this.poolConfig;
    }

    public final Map<String, g> component3() {
        return this.clientConfigMap;
    }

    public final AudioConnectionPoolConfig copy(boolean r100, j r101, Map<String, g> r102) {
        return new AudioConnectionPoolConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioConnectionPoolConfig) == true) goto L8;
        return false;
    L8:
        AudioConnectionPoolConfig r101 = (AudioConnectionPoolConfig) r100;
        if (this.isEnabled == r101.isEnabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poolConfig, r101.poolConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clientConfigMap, r101.clientConfigMap) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        j r102 = this.poolConfig;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Map<String, g> r106 = this.clientConfigMap;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "AudioConnectionPoolConfig(isEnabled=" + this.isEnabled + ", poolConfig=" + this.poolConfig + ", clientConfigMap=" + this.clientConfigMap + ')';
    }

    public final Map<String, g> getClientConfigMap() {
        return this.clientConfigMap;
    }

    public final j getPoolConfig() {
        return this.poolConfig;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public AudioConnectionPoolConfig(boolean r100, j r101, Map<String, g> r102) {
        this.isEnabled = r100;
        this.poolConfig = r101;
        this.clientConfigMap = r102;
    }

    public /* synthetic */ AudioConnectionPoolConfig(boolean r100, j r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new j(0);
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
