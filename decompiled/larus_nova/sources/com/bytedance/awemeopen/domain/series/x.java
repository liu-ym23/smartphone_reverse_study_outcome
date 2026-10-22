package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u00061"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/x;", "", "", "vid", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "playAuthToken", "getPlayAuthToken", "setPlayAuthToken", "businessToken", "getBusinessToken", "setBusinessToken", "authToken", "getAuthToken", "setAuthToken", "forbiddenReason", "getForbiddenReason", "setForbiddenReason", "", "duration", "D", "getDuration", "()D", "setDuration", "(D)V", "realDuration", "getRealDuration", "setRealDuration", "", "multiDeviceOneDayLimit", "I", "getMultiDeviceOneDayLimit", "()I", "setMultiDeviceOneDayLimit", "(I)V", "videoModleJson", "getVideoModleJson", "setVideoModleJson", "keyToken", "getKeyToken", "setKeyToken", "name", "getName", "setName", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class x implements Cloneable {

    @SerializedName("AuthToken")
    private String authToken;

    @SerializedName("BusinessToken")
    private String businessToken;

    @SerializedName("Duration")
    private double duration;

    @SerializedName("ForbiddenReason")
    private String forbiddenReason;

    @SerializedName("KeyToken")
    private String keyToken;

    @SerializedName("MultiDeviceOneDayLimit")
    private int multiDeviceOneDayLimit;

    @SerializedName("Name")
    private String name;

    @SerializedName("PlayAuthToken")
    private String playAuthToken;

    @SerializedName("RealDuration")
    private double realDuration;

    @SerializedName("Vid")
    private String vid;

    @SerializedName("VideoModelJson")
    private String videoModleJson;

    public x() {
        this.vid = "";
        this.playAuthToken = "";
        this.businessToken = "";
        this.authToken = "";
        this.forbiddenReason = "";
        this.videoModleJson = "";
        this.keyToken = "";
        this.name = "";
    }

    public final Object clone() {
        return super.clone();
    }
}
