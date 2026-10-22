package com.ss.android.ugc.aweme.feed.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0010\u0010 \u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00048G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/VideoUrlModel;", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "()V", "_codecType", "", "_ratio", "", "_sourceId", "value", "codecType", "getCodecType2", "()I", "setCodecType2", "(I)V", "duration", "", "mVr", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "getRatio2", "()Ljava/lang/String;", "setRatio2", "(Ljava/lang/String;)V", "sourceId", "getSourceId2", "setSourceId2", "getCodecType", "getRatio", "getSourceId", "setCodecType", "", "setRatio", "setSourceId", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class VideoUrlModel extends UrlModel {
    private int _codecType;
    private String _ratio;
    private String _sourceId;

    @SerializedName("duration")
    public double duration;
    private boolean mVr;

    public final int getCodecType2() {
        return getCodecType();
    }

    public final String getRatio2() {
        return getRatio();
    }

    public final String getSourceId2() {
        return getSourceId();
    }

    public VideoUrlModel() {
    }

    public final int getCodecType() {
        return this._codecType;
    }

    public final String getRatio() {
        return this._ratio;
    }

    public final String getSourceId() {
        return this._sourceId;
    }

    public final void setCodecType(int r100) {
        this._codecType = r100;
    }

    public final void setCodecType2(int r100) {
        setCodecType(r100);
    }

    public final void setRatio(String r100) {
        this._ratio = r100;
    }

    public final void setRatio2(String r100) {
        setRatio(r100);
    }

    public final void setSourceId(String r100) {
        this._sourceId = r100;
    }

    public final void setSourceId2(String r100) {
        setSourceId(r100);
    }
}
