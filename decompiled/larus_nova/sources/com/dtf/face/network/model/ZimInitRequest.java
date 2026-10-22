package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;

/* JADX INFO: loaded from: classes22.dex */
public class ZimInitRequest {

    @JSONField(name = RuleConditionBean.BIZ_DATA_KEY)
    public String bizData;

    @JSONField(name = "channel")
    public String channel;

    @JSONField(name = "merchant")
    public String merchant;

    @JSONField(name = "metaInfo")
    public String metaInfo;

    @JSONField(name = "produceNode")
    public String produceNode;

    @JSONField(name = "productName")
    public String productName;

    @JSONField(name = "zimId")
    public String zimId;

    public String toString() {
        return "ZimInitRequest{zimId='" + this.zimId + "', channel='" + this.channel + "', merchant='" + this.merchant + "', productName='" + this.productName + "', produceNode='" + this.produceNode + "', bizData='" + this.bizData + "', metaInfo='" + this.metaInfo + "'}";
    }

    public ZimInitRequest() {
    }
}
