package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.audio.call.dora.IntentSource;
import com.ss.android.vesdk.VECameraSettings$Parameters$NoiseReduce;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/voicecall/api/bean/VisionIntentionItem;", "", "<init>", "()V", "source", "", "getSource$annotations", "getSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "needPicture", "", "getNeedPicture", "()Z", "highQuality", "getHighQuality", "photoType", "getPhotoType", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisionIntentionItem {

    @SerializedName(VECameraSettings$Parameters$NoiseReduce.HIGH_QUALITY)
    private final boolean highQuality;

    @SerializedName("need_picture")
    private final boolean needPicture;

    @SerializedName("photo_type")
    private final Integer photoType;

    @SerializedName("source")
    private final Integer source;

    public VisionIntentionItem() {
    }

    @IntentSource
    public static /* synthetic */ void getSource$annotations() {
    }

    public final boolean getHighQuality() {
        return this.highQuality;
    }

    public final boolean getNeedPicture() {
        return this.needPicture;
    }

    public final Integer getPhotoType() {
        return this.photoType;
    }

    public final Integer getSource() {
        return this.source;
    }
}
