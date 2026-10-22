package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/j;", "", "", "lockIndex", "J", "getLockIndex", "()J", "setLockIndex", "(J)V", "wathchedIndex", "getWathchedIndex", "setWathchedIndex", "adUnlockNum", "getAdUnlockNum", "setAdUnlockNum", "adUnlockMax", "getAdUnlockMax", "setAdUnlockMax", "chargeSeq", "getChargeSeq", "setChargeSeq", "", "isChargeSeries", "Z", "()Z", "setChargeSeries", "(Z)V", "isMultiDeviceLimit", "setMultiDeviceLimit", "", "albumInfoStr", "Ljava/lang/String;", "getAlbumInfoStr", "()Ljava/lang/String;", "setAlbumInfoStr", "(Ljava/lang/String;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class j implements Cloneable {

    @SerializedName("ad_unlock_max")
    private long adUnlockMax;

    @SerializedName("ad_unlock_num")
    private long adUnlockNum;

    @SerializedName("series_info")
    private String albumInfoStr;

    @SerializedName("charge_seq")
    private long chargeSeq;

    @SerializedName("is_charge_series")
    private boolean isChargeSeries;

    @SerializedName("multi_device_limit")
    private boolean isMultiDeviceLimit;

    @SerializedName("lock_index")
    private long lockIndex;

    @SerializedName("wathched_index")
    private long wathchedIndex;

    public j() {
        this.chargeSeq = 3;
    }

    public final Object clone() {
        return super.clone();
    }
}
