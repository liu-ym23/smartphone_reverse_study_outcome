package com.bytedance.locallife.groupon.struct.desktopguide;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import gs6.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/desktopguide/GrouponDeskTopGuideStruct;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Lgs6/a;", "biz_data", "Lgs6/a;", "getBiz_data", "()Lgs6/a;", "setBiz_data", "(Lgs6/a;)V", "<init>", "()V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class GrouponDeskTopGuideStruct extends BaseResponse {

    @SerializedName("biz_data")
    private a biz_data;

    public GrouponDeskTopGuideStruct() {
    }

    public final a getBiz_data() {
        return this.biz_data;
    }

    public final void setBiz_data(a r100) {
        this.biz_data = r100;
    }
}
