package com.bytedance.bdp.service.plug.map.model;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class BdpLatLng implements Serializable {
    public double latitude;
    public double longitude;

    public JSONObject toJSON() {
        JSONObject r100 = new JSONObject();
        r100.put("latitude", this.latitude);     // Catch: JSONException -> L5
        r100.put("longitude", this.longitude);     // Catch: JSONException -> L5
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public BdpLatLng() {
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLatitude(double r100) {
        this.latitude = r100;
    }

    public void setLongitude(double r100) {
        this.longitude = r100;
    }

    public BdpLatLng(double r100, double r101) {
        this.latitude = r100;
        this.longitude = r101;
    }
}
