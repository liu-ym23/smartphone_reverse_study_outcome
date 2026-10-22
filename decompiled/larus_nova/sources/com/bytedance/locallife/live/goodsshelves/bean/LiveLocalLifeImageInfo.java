package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeImageInfo;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "webUri", "", "getWebUri", "()Ljava/lang/String;", "setWebUri", "(Ljava/lang/String;)V", NativeDownloadModel.JsonKey.WEB_URL, "getWebUrl", "setWebUrl", "width", "getWidth", "setWidth", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveLocalLifeImageInfo implements Serializable {

    @SerializedName("height")
    private int height;

    @SerializedName("web_uri")
    private String webUri;

    @SerializedName("web_url")
    private String webUrl;

    @SerializedName("width")
    private int width;

    public LiveLocalLifeImageInfo() {
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getWebUri() {
        return this.webUri;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setWebUri(String r100) {
        this.webUri = r100;
    }

    public final void setWebUrl(String r100) {
        this.webUrl = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
