package com.bytedance.bdlocation.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class BssInfo {

    @SerializedName("bid")
    public int bid;

    @SerializedName("bsss")
    public long bsss;

    /* JADX INFO: renamed from: bw, reason: collision with root package name */
    @SerializedName("bw")
    public int f199862bw;

    /* JADX INFO: renamed from: ci, reason: collision with root package name */
    @SerializedName("ci")
    public int f199863ci;

    @SerializedName("cid")
    public long cid;

    @SerializedName("cpid")
    public int cpid;

    @SerializedName("earfcn")
    public int earfcn;

    @SerializedName("is_registered")
    public boolean isRegistered;

    /* JADX INFO: renamed from: lac, reason: collision with root package name */
    @SerializedName("lac")
    public long f199864lac;

    @SerializedName("lat")
    public int lat;

    @SerializedName("longi")
    public int longi;

    /* JADX INFO: renamed from: mcc, reason: collision with root package name */
    @SerializedName("mcc")
    public long f199865mcc;

    /* JADX INFO: renamed from: mnc, reason: collision with root package name */
    @SerializedName("mnc")
    public long f199866mnc;

    @SerializedName("nci")
    public long nci;

    @SerializedName("nid")
    public int nid;

    @SerializedName("pci")
    public int pci;

    /* JADX INFO: renamed from: psc, reason: collision with root package name */
    @SerializedName("psc")
    public long f199867psc;

    @SerializedName("radio_type")
    public String radioType;

    @SerializedName("rssi")
    public long rssi;

    @SerializedName(WsConstants.KEY_SESSION_ID)
    public int sid;

    /* JADX INFO: renamed from: tac, reason: collision with root package name */
    @SerializedName("tac")
    public int f199868tac;

    @SerializedName("timestamp")
    public long timestamp;

    public BssInfo() {
    }
}
