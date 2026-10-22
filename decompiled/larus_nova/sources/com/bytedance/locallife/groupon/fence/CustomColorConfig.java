package com.bytedance.locallife.groupon.fence;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/locallife/groupon/fence/CustomColorConfig;", "", "startColor", "", "midColor", "endColor", "startPointX", "", "startPointY", "endPointX", "endPointY", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFF)V", "getEndColor", "()Ljava/lang/String;", "setEndColor", "(Ljava/lang/String;)V", "getEndPointX", "()F", "setEndPointX", "(F)V", "getEndPointY", "setEndPointY", "getMidColor", "setMidColor", "getStartColor", "setStartColor", "getStartPointX", "setStartPointX", "getStartPointY", "setStartPointY", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CustomColorConfig {

    @SerializedName("end")
    private String endColor;

    @SerializedName("end_pointx")
    private float endPointX;

    @SerializedName("end_pointy")
    private float endPointY;

    @SerializedName("mid")
    private String midColor;

    @SerializedName("start")
    private String startColor;

    @SerializedName("start_pointx")
    private float startPointX;

    @SerializedName("start_pointy")
    private float startPointY;

    public CustomColorConfig() {
        this(null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 127, null);
    }

    public final String getEndColor() {
        return this.endColor;
    }

    public final float getEndPointX() {
        return this.endPointX;
    }

    public final float getEndPointY() {
        return this.endPointY;
    }

    public final String getMidColor() {
        return this.midColor;
    }

    public final String getStartColor() {
        return this.startColor;
    }

    public final float getStartPointX() {
        return this.startPointX;
    }

    public final float getStartPointY() {
        return this.startPointY;
    }

    public final void setEndColor(String r100) {
        this.endColor = r100;
    }

    public final void setEndPointX(float r100) {
        this.endPointX = r100;
    }

    public final void setEndPointY(float r100) {
        this.endPointY = r100;
    }

    public final void setMidColor(String r100) {
        this.midColor = r100;
    }

    public final void setStartColor(String r100) {
        this.startColor = r100;
    }

    public final void setStartPointX(float r100) {
        this.startPointX = r100;
    }

    public final void setStartPointY(float r100) {
        this.startPointY = r100;
    }

    public CustomColorConfig(String r100, String r101, String r102, float r103, float r104, float r105, float r106) {
        this.startColor = r100;
        this.midColor = r101;
        this.endColor = r102;
        this.startPointX = r103;
        this.startPointY = r104;
        this.endPointX = r105;
        this.endPointY = r106;
    }

    public /* synthetic */ CustomColorConfig(String r100, String r101, String r102, float r103, float r110, float r111, float r112, int r113, DefaultConstructorMarker r114) {
        String r104 = null;
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r113 & 4) != 0) goto L15;
        r104 = r102;
    L15:
        if ((r113 & 8) == 0) goto L17;
        float r106 = 0.0f;
    L19:
        if ((r113 & 16) == 0) goto L21;
        float r107 = 0.0f;
    L23:
        if ((r113 & 32) == 0) goto L25;
        float r108 = 1.0f;
    L27:
        if ((r113 & 64) == 0) goto L29;
        float r116 = 1.0f;
    L30:
        this(r115, r105, r104, r106, r107, r108, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L25:
        r108 = r111;
        goto L27
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
