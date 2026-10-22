package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/api/bean/TtsParams;", "", "modelName", "", "styleId", "audioMetrics", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModelName", "()Ljava/lang/String;", "getStyleId", "getAudioMetrics", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsParams {

    @SerializedName("audio_metrics")
    private final String audioMetrics;

    @SerializedName("model_name")
    private final String modelName;

    @SerializedName("style_id")
    private final String styleId;

    public TtsParams() {
        this(null, null, null, 7, null);
    }

    public final String getAudioMetrics() {
        return this.audioMetrics;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getStyleId() {
        return this.styleId;
    }

    public TtsParams(String r100, String r101, String r102) {
        this.modelName = r100;
        this.styleId = r101;
        this.audioMetrics = r102;
    }

    public /* synthetic */ TtsParams(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
