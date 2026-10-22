package com.bytedance.ug.sdk.luckycat.impl.popup;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/e;", "", "", "triggerType", "Ljava/lang/String;", "getTriggerType", "()Ljava/lang/String;", "setTriggerType", "(Ljava/lang/String;)V", "", "whitelist", "Ljava/util/List;", "getWhitelist", "()Ljava/util/List;", "setWhitelist", "(Ljava/util/List;)V", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class e {

    @SerializedName("trigger_type")
    private String triggerType;

    @SerializedName("white_list")
    private List<String> whitelist;

    public e() {
        this.triggerType = "";
    }
}
