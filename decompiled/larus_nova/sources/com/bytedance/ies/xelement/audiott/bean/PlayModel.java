package com.bytedance.ies.xelement.audiott.bean;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\f\u0010\u001d\u001a\u00020\u0012*\u00020\u001eH\u0002R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xelement/audiott/bean/PlayModel;", "", GearStrategyConsts.EV_QUALITY, "", "encryptType", "videoModelJsonObj", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getEncryptType", "()Ljava/lang/String;", "getQuality", "getVideoModelJsonObj", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "getResolution", "Lcom/ss/ttvideoengine/Resolution;", "getVideoModel", "Lcom/ss/ttvideoengine/model/VideoModel;", "hashCode", "", "makeVideoModel", "jsonObj", "toString", "isValid", "Lcom/ss/ttvideoengine/model/VideoRef;", "x-element-audio-tt_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlayModel {

    @SerializedName("type")
    private final String encryptType;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private final String quality;

    @SerializedName("video_model")
    private final JsonObject videoModelJsonObj;

    public PlayModel() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PlayModel copy$default(PlayModel r100, String r101, String r102, JsonObject r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.quality;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.encryptType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.videoModelJsonObj;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.quality;
    }

    public final String component2() {
        return this.encryptType;
    }

    public final JsonObject component3() {
        return this.videoModelJsonObj;
    }

    public final PlayModel copy(String r100, String r101, JsonObject r102) {
        return new PlayModel(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PlayModel) == true) goto L8;
        return false;
    L8:
        PlayModel r101 = (PlayModel) r100;
        if (Intrinsics.areEqual(this.quality, r101.quality) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.encryptType, r101.encryptType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoModelJsonObj, r101.videoModelJsonObj) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.quality;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.encryptType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JsonObject r107 = this.videoModelJsonObj;
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
        return "PlayModel(quality=" + this.quality + ", encryptType=" + this.encryptType + ", videoModelJsonObj=" + this.videoModelJsonObj + ')';
    }

    public final Resolution getResolution() {
        String r100 = this.quality;
        if (Intrinsics.areEqual(r100, Quality.EXCELLENT.getDesc()) == false) goto L6;
        return Resolution.SuperHigh;
    L6:
        if (Intrinsics.areEqual(r100, Quality.GOOD.getDesc()) == false) goto L9;
        return Resolution.H_High;
    L9:
        if (Intrinsics.areEqual(r100, Quality.REGULAR.getDesc()) == false) goto L12;
        return Resolution.Standard;
    L12:
        return Resolution.Standard;
    }

    public final VideoModel getVideoModel() {
        JsonObject r100 = this.videoModelJsonObj;
        if (r100 != null) goto L5;
        return null;
    L5:
        return makeVideoModel(r100);
    }

    public final String getEncryptType() {
        return this.encryptType;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final JsonObject getVideoModelJsonObj() {
        return this.videoModelJsonObj;
    }

    private final boolean isValid(VideoRef r100) {
        if (r100.mStatus != 10) goto L5;
        return true;
    L5:
        return false;
    }

    private final VideoModel makeVideoModel(JsonObject r100) {
        VideoModel r101 = new VideoModel();     // Catch: Throwable -> L8
        VideoRef r102 = new VideoRef();     // Catch: Throwable -> L8
        r102.extractFields(new JSONObject(r100.toString()));     // Catch: Throwable -> L8
        if (isValid(r102) == true) goto L6;
        return null;
    L6:
        r101.setVideoRef(r102);     // Catch: Throwable -> L8
        return r101;
    L8:
        return null;
    }

    public PlayModel(String r100, String r101, JsonObject r102) {
        this.quality = r100;
        this.encryptType = r101;
        this.videoModelJsonObj = r102;
    }

    public /* synthetic */ PlayModel(String r100, String r101, JsonObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
