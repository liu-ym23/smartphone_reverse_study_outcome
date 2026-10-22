package com.ss.android.ugc.aweme.ktv;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/ReverberationData;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "path", "getPath", "setPath", "resId", "getResId", "setResId", ST.UUID_DEVICE, "getUuid", "setUuid", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class ReverberationData implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f450957id;

    @SerializedName("index")
    private int index;

    @SerializedName("path")
    private String path;

    @SerializedName("res_id")
    private String resId;

    @SerializedName(ST.UUID_DEVICE)
    private String uuid;

    public ReverberationData() {
        this.index = -1;
        this.uuid = "";
    }

    public final String getId() {
        return this.f450957id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getResId() {
        return this.resId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setId(String r100) {
        this.f450957id = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setResId(String r100) {
        this.resId = r100;
    }

    public final void setUuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uuid = r100;
    }
}
