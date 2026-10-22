package com.bytedance.bdlocation.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class NetworkAbilityEntity {

    @SerializedName("network_capabilities")
    public List<Integer> netCapabilityList;

    @SerializedName("network_transports")
    public List<Integer> netTransportList;

    public NetworkAbilityEntity() {
        this.netCapabilityList = new ArrayList();
        this.netTransportList = new ArrayList();
    }

    public void addNetCapability(int r100) {
        this.netCapabilityList.add(Integer.valueOf(r100));
    }

    public void addNetTransport(int r100) {
        this.netTransportList.add(Integer.valueOf(r100));
    }
}
