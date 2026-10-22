package com.larus.office.plugins.toast;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/larus/office/plugins/toast/ToastModel;", "", "<init>", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "type", "", "getType", "()I", "setType", "(I)V", "duration", "getDuration", "setDuration", "buttonMessage", "getButtonMessage", "setButtonMessage", "isForceDarkMode", "", "()Z", "setForceDarkMode", "(Z)V", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastModel {
    public static final a Companion = null;
    public static final int TYPE_FAIL = 2;
    public static final int TYPE_LOADING = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_SUCCESS = 3;
    public static final int TYPE_WARNING = 1;

    @SerializedName("buttonMessage")
    private String buttonMessage;

    @SerializedName("duration")
    private int duration;

    @SerializedName("isForceDarkMode")
    private boolean isForceDarkMode;

    @SerializedName("message")
    private String message;

    @SerializedName("type")
    private int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ToastModel() {
    }

    public String toString() {
        return "ToastModel{message='" + this.message + "', type=" + this.type + ", duration=" + this.duration + ", buttonMessage='" + this.buttonMessage + "'}";
    }

    public final String getButtonMessage() {
        return this.buttonMessage;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isForceDarkMode() {
        return this.isForceDarkMode;
    }

    public final void setButtonMessage(String r100) {
        this.buttonMessage = r100;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setForceDarkMode(boolean r100) {
        this.isForceDarkMode = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
