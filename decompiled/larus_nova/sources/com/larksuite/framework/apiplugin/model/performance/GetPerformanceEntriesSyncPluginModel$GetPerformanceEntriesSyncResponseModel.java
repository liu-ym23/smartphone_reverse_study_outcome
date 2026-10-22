package com.larksuite.framework.apiplugin.model.performance;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class GetPerformanceEntriesSyncPluginModel$GetPerformanceEntriesSyncResponseModel extends LKBaseResponseModel {

    @JSONField(name = "entries")
    @LKRequiredParam
    public ArrayList<GetPerformanceEntriesSyncPluginModel$EntriesItemModel> entries;

    public GetPerformanceEntriesSyncPluginModel$GetPerformanceEntriesSyncResponseModel() {
    }
}
