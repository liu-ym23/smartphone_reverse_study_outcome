package com.bytedance.locallife.host.search;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/host/search/CommentExtraInfo;", "Ljava/io/Serializable;", "()V", "display", "", "getDisplay", "()Z", "highlight", "", "getHighlight", "()Ljava/lang/String;", "qrecForSearch", "getQrecForSearch", "relInfo", "getRelInfo", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CommentExtraInfo implements Serializable {

    @SerializedName("display")
    private final boolean display;

    @SerializedName("highlight")
    private final String highlight;

    @SerializedName("qrec_for_search")
    private final String qrecForSearch;

    @SerializedName("rel_info")
    private final String relInfo;

    public CommentExtraInfo() {
    }

    public final boolean getDisplay() {
        return this.display;
    }

    public final String getHighlight() {
        return this.highlight;
    }

    public final String getQrecForSearch() {
        return this.qrecForSearch;
    }

    public final String getRelInfo() {
        return this.relInfo;
    }
}
