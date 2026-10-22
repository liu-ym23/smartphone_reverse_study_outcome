package com.bytedance.bdp.serviceapi.defaults.map.model;

import com.bytedance.bdp.service.plug.map.model.BdpLatLng;

/* JADX INFO: loaded from: classes11.dex */
public interface BdpLocator {

    public interface a {
    }

    public interface b {
    }

    a searchPoiListByKeyword(BdpLatLng r100, String r101, String r102, int r103, int r104, b r105);

    a searchPoiListByLatLng(BdpLatLng r100, int r101, int r102, int r103, b r104);
}
