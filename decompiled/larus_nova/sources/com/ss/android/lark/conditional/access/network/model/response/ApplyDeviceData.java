package com.ss.android.lark.conditional.access.network.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/model/response/ApplyDeviceData;", "Ljava/io/Serializable;", "<init>", "()V", "applyStatus", "", "getApplyStatus", "()I", "setApplyStatus", "(I)V", "ownership", "getOwnership", "setOwnership", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplyDeviceData implements Serializable {

    @SerializedName("apply_status")
    private int applyStatus;

    @SerializedName("ownership")
    private int ownership;

    public ApplyDeviceData() {
    }

    public final int getApplyStatus() {
        return this.applyStatus;
    }

    public final int getOwnership() {
        return this.ownership;
    }

    public final void setApplyStatus(int r100) {
        this.applyStatus = r100;
    }

    public final void setOwnership(int r100) {
        this.ownership = r100;
    }
}
