package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq9.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/audio/AudioHostConfig;", "", "realtimeCallAppKey", "", "samiBusinessId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getRealtimeCallAppKey", "()Ljava/lang/String;", "getSamiBusinessId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/platform/model/audio/AudioHostConfig;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioHostConfig {

    @SerializedName("realtime_call_app_key")
    private final String realtimeCallAppKey;

    @SerializedName("sami_business_id")
    private final Integer samiBusinessId;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioHostConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AudioHostConfig copy$default(AudioHostConfig r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.realtimeCallAppKey;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.samiBusinessId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.realtimeCallAppKey;
    }

    public final Integer component2() {
        return this.samiBusinessId;
    }

    public final AudioHostConfig copy(String r100, Integer r101) {
        return new AudioHostConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AudioHostConfig) == true) goto L8;
        return false;
    L8:
        AudioHostConfig r101 = (AudioHostConfig) r100;
        if (Intrinsics.areEqual(this.realtimeCallAppKey, r101.realtimeCallAppKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.samiBusinessId, r101.samiBusinessId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.realtimeCallAppKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.samiBusinessId;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AudioHostConfig(realtimeCallAppKey=" + this.realtimeCallAppKey + ", samiBusinessId=" + this.samiBusinessId + ')';
    }

    public final String getRealtimeCallAppKey() {
        return this.realtimeCallAppKey;
    }

    public final Integer getSamiBusinessId() {
        return this.samiBusinessId;
    }

    public AudioHostConfig(String r100, Integer r101) {
        this.realtimeCallAppKey = r100;
        this.samiBusinessId = r101;
    }

    public /* synthetic */ AudioHostConfig(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = d.a();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
