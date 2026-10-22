package com.bytedance.ug.sdk.luckycat.impl.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/settings/d;", "", "Lcom/bytedance/ug/sdk/luckycat/impl/settings/b;", "commonInfo", "Lcom/bytedance/ug/sdk/luckycat/impl/settings/b;", "getCommonInfo", "()Lcom/bytedance/ug/sdk/luckycat/impl/settings/b;", "setCommonInfo", "(Lcom/bytedance/ug/sdk/luckycat/impl/settings/b;)V", "", "Lcom/bytedance/ug/sdk/luckycat/impl/settings/a;", "activityData", "Ljava/util/List;", "getActivityData", "()Ljava/util/List;", "setActivityData", "(Ljava/util/List;)V", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("activity_data")
    private List<a> activityData;

    @SerializedName("common_info")
    private b commonInfo;

    public d() {
    }
}
