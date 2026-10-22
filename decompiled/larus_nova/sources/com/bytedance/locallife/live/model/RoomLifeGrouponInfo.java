package com.bytedance.locallife.live.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@ProtoMessage("webcast.data.LifeGrouponInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/live/model/RoomLifeGrouponInfo;", "", "()V", "aggCardId", "", "getAggCardId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dynamicUrl", "", "getDynamicUrl", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "permissionStatus", "getPermissionStatus", "setPermissionStatus", "(Ljava/lang/Long;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RoomLifeGrouponInfo {

    @SerializedName("agg_card_id")
    private final Long aggCardId;

    @SerializedName("dynamic_url")
    private final String dynamicUrl;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName(LocationMonitorConst.PERMISSION_STATUS)
    private Long permissionStatus;

    public RoomLifeGrouponInfo() {
    }

    public final Long getAggCardId() {
        return this.aggCardId;
    }

    public final String getDynamicUrl() {
        return this.dynamicUrl;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final Long getPermissionStatus() {
        return this.permissionStatus;
    }

    public final void setPermissionStatus(Long r100) {
        this.permissionStatus = r100;
    }
}
