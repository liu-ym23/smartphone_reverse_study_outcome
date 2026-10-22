package com.hihonor.android.app.admin;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum DeviceEthernetProfile$IpAssignment extends Enum<DeviceEthernetProfile$IpAssignment> {
    public static final DeviceEthernetProfile$IpAssignment DHCP = null;
    public static final DeviceEthernetProfile$IpAssignment STATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceEthernetProfile$IpAssignment[] f276468a = null;

    static {
        DeviceEthernetProfile$IpAssignment r100 = new DeviceEthernetProfile$IpAssignment("DHCP", 0);
        DHCP = r100;
        DeviceEthernetProfile$IpAssignment r101 = new DeviceEthernetProfile$IpAssignment("STATIC", 1);
        STATIC = r101;
        f276468a = new DeviceEthernetProfile$IpAssignment[]{r100, r101};
    }

    public static DeviceEthernetProfile$IpAssignment[] values() {
        return (DeviceEthernetProfile$IpAssignment[]) f276468a.clone();
    }

    public static DeviceEthernetProfile$IpAssignment valueOf(String r100) {
        return (DeviceEthernetProfile$IpAssignment) a.a(DeviceEthernetProfile$IpAssignment.class, r100);
    }

    public DeviceEthernetProfile$IpAssignment(String r100, int r101) {
        super(r100, r101);
    }
}
