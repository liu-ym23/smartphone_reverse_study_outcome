package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/DrawTicketParamsInfo;", "Ljava/io/Serializable;", "()V", "drawTicketParams", "", "getDrawTicketParams", "()Ljava/lang/String;", "setDrawTicketParams", "(Ljava/lang/String;)V", "trackParamsList", "", "", "getTrackParamsList", "()Ljava/util/List;", "setTrackParamsList", "(Ljava/util/List;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DrawTicketParamsInfo implements Serializable {

    @SerializedName("draw_ticket_params")
    private String drawTicketParams;

    @SerializedName("track_params")
    private List<? extends Map<String, String>> trackParamsList;

    public DrawTicketParamsInfo() {
    }

    public final String getDrawTicketParams() {
        return this.drawTicketParams;
    }

    public final List<Map<String, String>> getTrackParamsList() {
        return this.trackParamsList;
    }

    public final void setDrawTicketParams(String r100) {
        this.drawTicketParams = r100;
    }

    public final void setTrackParamsList(List<? extends Map<String, String>> r100) {
        this.trackParamsList = r100;
    }
}
