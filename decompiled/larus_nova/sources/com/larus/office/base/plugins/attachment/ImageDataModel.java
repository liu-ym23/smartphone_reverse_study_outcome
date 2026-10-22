package com.larus.office.base.plugins.attachment;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/office/base/plugins/attachment/ImageDataModel;", "Lcom/larus/office/base/plugins/attachment/ImageData;", "<init>", "()V", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageDataModel extends ImageData {

    @SerializedName("source")
    private String source;

    @Override // com.larus.office.base.plugins.attachment.ImageData
    public String toString() {
        return "ImageDataModel{toolStatus=" + this.toolStatus + ", image=" + this.image + ", imageList=" + this.imageList + ", source=" + this.source + '}';
    }

    public ImageDataModel() {
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }
}
