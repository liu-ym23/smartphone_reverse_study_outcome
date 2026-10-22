package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class ZimValidateRequest {

    @JSONField(name = RuleConditionBean.BIZ_DATA_KEY)
    public Map<String, String> bizData;

    @JSONField(name = "zimData")
    public String zimData;

    @JSONField(name = "zimId")
    public String zimId;

    public ZimValidateRequest() {
    }
}
