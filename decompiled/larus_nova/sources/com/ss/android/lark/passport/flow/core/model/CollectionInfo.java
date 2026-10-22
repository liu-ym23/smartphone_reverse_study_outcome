package com.ss.android.lark.passport.flow.core.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR>\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/model/CollectionInfo;", "Ljava/io/Serializable;", "<init>", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()I", "setActionType", "(I)V", "eventKey", "", "getEventKey", "()Ljava/lang/String;", "setEventKey", "(Ljava/lang/String;)V", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionInfo implements Serializable {

    @JSONField(name = "action_type")
    private int actionType;

    @JSONField(name = LiveCommonConstants.LOG_PARAM_EVENT_KEY)
    private String eventKey;

    @JSONField(name = "params")
    private HashMap<String, String> params;

    public CollectionInfo() {
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getEventKey() {
        return this.eventKey;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public final void setActionType(int r100) {
        this.actionType = r100;
    }

    public final void setEventKey(String r100) {
        this.eventKey = r100;
    }

    public final void setParams(HashMap<String, String> r100) {
        this.params = r100;
    }
}
