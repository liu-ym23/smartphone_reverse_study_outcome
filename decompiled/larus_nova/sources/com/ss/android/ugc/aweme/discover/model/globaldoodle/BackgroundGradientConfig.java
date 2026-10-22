package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/BackgroundGradientConfig;", "Ljava/io/Serializable;", "()V", "centerColor", "", "getCenterColor", "()Ljava/lang/String;", "setCenterColor", "(Ljava/lang/String;)V", "centerColorPosition", "", "getCenterColorPosition", "()D", "setCenterColorPosition", "(D)V", "centerColorPxPosition", "", "getCenterColorPxPosition", "()I", "setCenterColorPxPosition", "(I)V", "endColor", "getEndColor", "setEndColor", "gradientLayoutType", "getGradientLayoutType", "setGradientLayoutType", "startColor", "getStartColor", "setStartColor", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class BackgroundGradientConfig implements Serializable {

    @SerializedName("center_color")
    private String centerColor;

    @SerializedName("center_color_position")
    private double centerColorPosition;

    @SerializedName("center_color_px_position")
    private int centerColorPxPosition;

    @SerializedName("end_color")
    private String endColor;

    @SerializedName("gradient_layout_type")
    private int gradientLayoutType;

    @SerializedName("start_color")
    private String startColor;

    public BackgroundGradientConfig() {
        this.centerColorPosition = 0.5d;
    }

    public final String getCenterColor() {
        return this.centerColor;
    }

    public final double getCenterColorPosition() {
        return this.centerColorPosition;
    }

    public final int getCenterColorPxPosition() {
        return this.centerColorPxPosition;
    }

    public final String getEndColor() {
        return this.endColor;
    }

    public final int getGradientLayoutType() {
        return this.gradientLayoutType;
    }

    public final String getStartColor() {
        return this.startColor;
    }

    public final void setCenterColor(String r100) {
        this.centerColor = r100;
    }

    public final void setCenterColorPosition(double r100) {
        this.centerColorPosition = r100;
    }

    public final void setCenterColorPxPosition(int r100) {
        this.centerColorPxPosition = r100;
    }

    public final void setEndColor(String r100) {
        this.endColor = r100;
    }

    public final void setGradientLayoutType(int r100) {
        this.gradientLayoutType = r100;
    }

    public final void setStartColor(String r100) {
        this.startColor = r100;
    }
}
