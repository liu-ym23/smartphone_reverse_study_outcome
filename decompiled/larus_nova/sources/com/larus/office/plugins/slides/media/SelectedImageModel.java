package com.larus.office.plugins.slides.media;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/office/plugins/slides/media/SelectedImageModel;", "", "width", "", "height", "url", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getWidth", "()Ljava/lang/Float;", "setWidth", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getHeight", "setHeight", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedImageModel {

    @SerializedName("height")
    private Float height;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private Float width;

    public SelectedImageModel() {
        this(null, null, null, 7, null);
    }

    public final Float getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setHeight(Float r100) {
        this.height = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }

    public SelectedImageModel(Float r100, Float r101, String r102) {
        this.width = r100;
        this.height = r101;
        this.url = r102;
    }

    public /* synthetic */ SelectedImageModel(Float r100, Float r101, String r102, int r103, DefaultConstructorMarker r104) {
        int r105 = r103 & 1;
        Float r106 = Float.valueOf(0.0f);
        if (r105 == 0) goto L6;
        r100 = r106;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = r106;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
