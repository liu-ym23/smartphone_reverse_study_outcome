package com.bytelink.syswrapper.ble;

import com.alipay.sdk.m.u.i;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public class DeviceInfo {
    public static final int DEVICE_MAC_LEN = 6;
    public static final int DEVICE_NAME_MAX_LEN = 15;
    public static final int MAX_SERVICES = 10;
    private byte batteryLeft;
    private byte batteryMain;
    private byte batteryRight;
    private byte[] btMac;
    private byte deviceConfig;
    private long deviceId;
    private long deviceIp;
    private String deviceName;
    private byte deviceStatus;
    private DeviceDomain domain;
    private byte linkAbility;
    private LinkInfo linkInfo;
    private int productId;
    private byte protocolVersion;
    private byte rssi;
    private ServiceInfo[] serviceList;
    private byte serviceNum;
    private byte transferAbility;
    private byte txPower;
    private int vendorId;
    private byte[] wifiMac;

    public static final enum DeviceDomain extends Enum<DeviceDomain> {
        private static final /* synthetic */ DeviceDomain[] $VALUES = null;
        public static final DeviceDomain DOMAIN_LOCAL = null;
        public static final DeviceDomain DOMAIN_REMOTE_CLOUD = null;
        public static final DeviceDomain DOMAIN_REMOTE_CORE = null;
        public static final DeviceDomain DOMAIN_REMOTE_DEVICE = null;
        private final int value;

        static {
            DeviceDomain r100 = new DeviceDomain("DOMAIN_LOCAL", 0, 0);
            DOMAIN_LOCAL = r100;
            DeviceDomain r101 = new DeviceDomain("DOMAIN_REMOTE_CORE", 1, 1);
            DOMAIN_REMOTE_CORE = r101;
            DeviceDomain r102 = new DeviceDomain("DOMAIN_REMOTE_DEVICE", 2, 2);
            DOMAIN_REMOTE_DEVICE = r102;
            DeviceDomain r103 = new DeviceDomain("DOMAIN_REMOTE_CLOUD", 3, 3);
            DOMAIN_REMOTE_CLOUD = r103;
            $VALUES = new DeviceDomain[]{r100, r101, r102, r103};
        }

        public static DeviceDomain[] values() {
            return (DeviceDomain[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static DeviceDomain fromValue(int r100) {
            DeviceDomain[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            DeviceDomain r104 = r101[r103];
            if (r104.value == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            throw new IllegalArgumentException("Invalid DeviceDomain value: " + r100);
        }

        public static DeviceDomain valueOf(String r100) {
            return (DeviceDomain) r27.a.a(DeviceDomain.class, r100);
        }

        private DeviceDomain(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class LinkInfo {
        private static final int LINK_TYPE_MASK = 7;
        private static final int PAIRED_MASK = 16;
        private static final int RESERVED1_MASK = 8;
        private static final int RESERVED2_MASK = 224;
        private byte raw;
        final /* synthetic */ DeviceInfo this$0;

        public int getLinkType() {
            return this.raw & 7;
        }

        public int getReserved1() {
            return (this.raw & 8) >> 3;
        }

        public int getReserved2() {
            return (this.raw & 224) >> 5;
        }

        public boolean isPaired() {
            if ((this.raw & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public byte getRaw() {
            return this.raw;
        }

        public LinkInfo(DeviceInfo r100) {
            this.this$0 = r100;
        }

        public void setLinkType(int r100) {
            int r101 = r100 & 7;
            this.raw = (byte) (r101 | (this.raw & (-8)));
        }

        public void setPaired(boolean r100) {
            if (r100 == false) goto L4;
            this.raw = (byte) (this.raw | 16);
            return;
        L4:
            this.raw = (byte) (this.raw & (-17));
        }

        public void setRaw(byte r100) {
            this.raw = r100;
        }

        public void setReserved1(int r100) {
            int r101 = (r100 & 1) << 3;
            this.raw = (byte) (r101 | (this.raw & (-9)));
        }

        public void setReserved2(int r100) {
            int r101 = (r100 & 7) << 5;
            this.raw = (byte) (r101 | (this.raw & (-225)));
        }
    }

    public static class ServiceInfo {
        private byte serviceData;
        private byte serviceId;

        public ServiceInfo() {
        }

        public String toString() {
            return "ServiceInfo{serviceId=" + this.serviceId + ", serviceData=" + this.serviceData + i.f25855d;
        }

        public byte getServiceData() {
            return this.serviceData;
        }

        public byte getServiceId() {
            return this.serviceId;
        }

        public void setServiceData(byte r100) {
            this.serviceData = r100;
        }

        public void setServiceId(byte r100) {
            this.serviceId = r100;
        }

        public ServiceInfo(byte r100, byte r101) {
            this.serviceId = r100;
            this.serviceData = r101;
        }
    }

    public byte[] getBtMac() {
        return (byte[]) this.btMac.clone();
    }

    public ServiceInfo[] getServiceList() {
        return (ServiceInfo[]) this.serviceList.clone();
    }

    public byte[] getWifiMac() {
        return (byte[]) this.wifiMac.clone();
    }

    public String toString() {
        return "DeviceInfo{deviceId=0x" + Long.toHexString(this.deviceId) + ", vendorId=0x" + Integer.toHexString(this.vendorId) + ", productId=0x" + Integer.toHexString(this.productId) + ", protocolVersion=" + this.protocolVersion + ", deviceConfig=0x" + Integer.toHexString(this.deviceConfig & UByte.MAX_VALUE) + ", deviceStatus=0x" + Integer.toHexString(this.deviceStatus & UByte.MAX_VALUE) + ", linkAbility=0x" + Integer.toHexString(this.linkAbility & UByte.MAX_VALUE) + ", transferAbility=0x" + Integer.toHexString(this.transferAbility & UByte.MAX_VALUE) + ", batteryMain=" + this.batteryMain + "%, batteryLeft=" + this.batteryLeft + "%, batteryRight=" + this.batteryRight + "%, txPower=" + this.txPower + "dBm, rssi=" + this.rssi + "dBm, btMac=" + bytesToHex(this.btMac) + ", wifiMac=" + bytesToHex(this.wifiMac) + ", deviceIp=" + String.format("%d.%d.%d.%d", new Object[]{Long.valueOf((this.deviceIp >> 24) & 255), Long.valueOf((this.deviceIp >> 16) & 255), Long.valueOf((this.deviceIp >> 8) & 255), Long.valueOf(this.deviceIp & 255)}) + ", deviceName='" + this.deviceName + "', linkInfo={linkType=" + this.linkInfo.getLinkType() + ", paired=" + this.linkInfo.isPaired() + "}, serviceNum=" + this.serviceNum + ", domain=" + this.domain + '}';
    }

    public DeviceInfo() {
        this.btMac = new byte[6];
        this.wifiMac = new byte[6];
        this.linkInfo = new LinkInfo(this);
        this.serviceList = new ServiceInfo[10];
        int r100 = 0;
    L3:
        if (r100 >= 10) goto L5;
        this.serviceList[r100] = new ServiceInfo();
        r100 = r100 + 1;
        goto L3
    L5:
        this.domain = DeviceDomain.DOMAIN_LOCAL;
    }

    public byte getBatteryLeft() {
        return this.batteryLeft;
    }

    public byte getBatteryMain() {
        return this.batteryMain;
    }

    public byte getBatteryRight() {
        return this.batteryRight;
    }

    public byte getDeviceConfig() {
        return this.deviceConfig;
    }

    public long getDeviceId() {
        return this.deviceId;
    }

    public long getDeviceIp() {
        return this.deviceIp;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public byte getDeviceStatus() {
        return this.deviceStatus;
    }

    public DeviceDomain getDomain() {
        return this.domain;
    }

    public byte getLinkAbility() {
        return this.linkAbility;
    }

    public LinkInfo getLinkInfo() {
        return this.linkInfo;
    }

    public int getProductId() {
        return this.productId;
    }

    public byte getProtocolVersion() {
        return this.protocolVersion;
    }

    public byte getRssi() {
        return this.rssi;
    }

    public byte getServiceNum() {
        return this.serviceNum;
    }

    public byte getTransferAbility() {
        return this.transferAbility;
    }

    public byte getTxPower() {
        return this.txPower;
    }

    public int getVendorId() {
        return this.vendorId;
    }

    private String bytesToHex(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L7;
        r101.append(String.format("%02X:", new Object[]{Byte.valueOf(r100[r103])}));
        r103 = r103 + 1;
        goto L4
    L7:
        if (r101.length() <= 0) goto L10;
        r101.setLength(r101.length() - 1);
    L10:
        return r101.toString();
    }

    public void addService(ServiceInfo r100) {
        byte r101 = this.serviceNum;
        if (r101 >= 10) goto L7;
        ServiceInfo[] r102 = this.serviceList;
        this.serviceNum = (byte) (r101 + 1);
        r102[r101] = r100;
        return;
    L7:
        throw new IllegalStateException("Maximum number of services (10) reached");
    }

    public void setBatteryLeft(byte r100) {
        this.batteryLeft = r100;
    }

    public void setBatteryMain(byte r100) {
        this.batteryMain = r100;
    }

    public void setBatteryRight(byte r100) {
        this.batteryRight = r100;
    }

    public void setBtMac(byte[] r100) {
        if (r100.length != 6) goto L7;
        this.btMac = (byte[]) r100.clone();
        return;
    L7:
        throw new IllegalArgumentException("BT MAC address must be 6 bytes");
    }

    public void setDeviceConfig(byte r100) {
        this.deviceConfig = r100;
    }

    public void setDeviceId(long r100) {
        this.deviceId = r100;
    }

    public void setDeviceIp(long r100) {
        this.deviceIp = r100;
    }

    public void setDeviceName(String r100) {
        if (r100 != null) goto L4;
    L8:
        this.deviceName = r100;
        return;
    L4:
        if (r100.length() <= 15) goto L8;
        throw new IllegalArgumentException("Device name exceeds maximum length of 15");
    }

    public void setDeviceStatus(byte r100) {
        this.deviceStatus = r100;
    }

    public void setDomain(DeviceDomain r100) {
        this.domain = r100;
    }

    public void setLinkAbility(byte r100) {
        this.linkAbility = r100;
    }

    public void setProductId(int r100) {
        this.productId = r100;
    }

    public void setProtocolVersion(byte r100) {
        this.protocolVersion = r100;
    }

    public void setRssi(byte r100) {
        this.rssi = r100;
    }

    public void setServiceList(ServiceInfo[] r100) {
        if (r100.length > 10) goto L7;
        this.serviceList = (ServiceInfo[]) Arrays.copyOf(r100, 10);
        this.serviceNum = (byte) r100.length;
        return;
    L7:
        throw new IllegalArgumentException("Service list exceeds maximum size of 10");
    }

    public void setServiceNum(byte r100) {
        if (r100 < 0) goto L8;
        if (r100 > 10) goto L8;
        this.serviceNum = r100;
        return;
    L8:
        throw new IllegalArgumentException("Service number must be between 0 and 10");
    }

    public void setTransferAbility(byte r100) {
        this.transferAbility = r100;
    }

    public void setTxPower(byte r100) {
        this.txPower = r100;
    }

    public void setVendorId(int r100) {
        this.vendorId = r100;
    }

    public void setWifiMac(byte[] r100) {
        if (r100.length != 6) goto L7;
        this.wifiMac = (byte[]) r100.clone();
        return;
    L7:
        throw new IllegalArgumentException("WiFi MAC address must be 6 bytes");
    }
}
