package com.ss.android.ugc.aweme.discover.model.globaldoodle;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes40.dex */
public class SearchUserGuide implements Serializable {

    @SerializedName("inflow_second")
    public Integer inflowSecond;

    @SerializedName("inflow_stop")
    public Integer inflowStop;

    @SerializedName("resp_second")
    public Integer respSecond;

    @SerializedName("show_inflow_guide")
    public boolean showInflowGuide;

    @SerializedName("show_resp_guide")
    public boolean showRespGuide;

    public SearchUserGuide() {
        this.showRespGuide = false;
        this.respSecond = null;
        this.showInflowGuide = false;
        this.inflowSecond = null;
        this.inflowStop = null;
    }
}
