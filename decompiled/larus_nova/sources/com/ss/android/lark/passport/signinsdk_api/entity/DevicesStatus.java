package com.ss.android.lark.passport.signinsdk_api.entity;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public class DevicesStatus implements Serializable {
    private List<DeviceStatus> devices;

    public static class DeviceStatus implements Serializable {
        private String deviceId;
        private OnLineStatus onlineStatus;
        private TerminalType terminalType;

        public static final enum OnLineStatus extends Enum<OnLineStatus> {
            public static final OnLineStatus OFFLINE = null;
            public static final OnLineStatus ONLINE = null;
            public static final OnLineStatus UNKNOWN_ONLINE_STATUS = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ OnLineStatus[] f438072a = null;
            int value;

            static {
                OnLineStatus r100 = new OnLineStatus("UNKNOWN_ONLINE_STATUS", 0, 0);
                UNKNOWN_ONLINE_STATUS = r100;
                OnLineStatus r101 = new OnLineStatus("ONLINE", 1, 1);
                ONLINE = r101;
                OnLineStatus r102 = new OnLineStatus("OFFLINE", 2, 2);
                OFFLINE = r102;
                f438072a = new OnLineStatus[]{r100, r101, r102};
            }

            public static OnLineStatus[] values() {
                return (OnLineStatus[]) f438072a.clone();
            }

            public int getValue() {
                return this.value;
            }

            public static OnLineStatus valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return UNKNOWN_ONLINE_STATUS;
            L10:
                return OFFLINE;
            L12:
                return ONLINE;
            L14:
                return UNKNOWN_ONLINE_STATUS;
            }

            public void setValue(int r100) {
                this.value = r100;
            }

            public static OnLineStatus valueOf(String r100) {
                return (OnLineStatus) a.a(OnLineStatus.class, r100);
            }

            public OnLineStatus(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final enum TerminalType extends Enum<TerminalType> {
            public static final TerminalType ANDROID = null;
            public static final TerminalType IOS = null;
            public static final TerminalType PC = null;
            public static final TerminalType UNKNOWN_TERMINAL_TYPE = null;
            public static final TerminalType WEB = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TerminalType[] f438073a = null;
            int value;

            static {
                TerminalType r100 = new TerminalType("UNKNOWN_TERMINAL_TYPE", 0, 0);
                UNKNOWN_TERMINAL_TYPE = r100;
                TerminalType r101 = new TerminalType("PC", 1, 1);
                PC = r101;
                TerminalType r102 = new TerminalType("WEB", 2, 2);
                WEB = r102;
                TerminalType r103 = new TerminalType("ANDROID", 3, 3);
                ANDROID = r103;
                TerminalType r104 = new TerminalType("IOS", 4, 4);
                IOS = r104;
                f438073a = new TerminalType[]{r100, r101, r102, r103, r104};
            }

            public static TerminalType[] values() {
                return (TerminalType[]) f438073a.clone();
            }

            public int getValue() {
                return this.value;
            }

            public static TerminalType valueOf(int r100) {
                if (r100 == 0) goto L22;
                if (r100 == 1) goto L20;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L16;
                if (r100 == 4) goto L14;
                return UNKNOWN_TERMINAL_TYPE;
            L14:
                return IOS;
            L16:
                return ANDROID;
            L18:
                return WEB;
            L20:
                return PC;
            L22:
                return UNKNOWN_TERMINAL_TYPE;
            }

            public void setValue(int r100) {
                this.value = r100;
            }

            public static TerminalType valueOf(String r100) {
                return (TerminalType) a.a(TerminalType.class, r100);
            }

            public TerminalType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public DeviceStatus() {
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public OnLineStatus getOnlineStatus() {
            return this.onlineStatus;
        }

        public TerminalType getTerminalType() {
            return this.terminalType;
        }

        public void setDeviceId(String r100) {
            this.deviceId = r100;
        }

        public void setOnlineStatus(OnLineStatus r100) {
            this.onlineStatus = r100;
        }

        public void setTerminalType(TerminalType r100) {
            this.terminalType = r100;
        }
    }

    public DevicesStatus() {
    }

    public int getDeviceCount() {
        List<DeviceStatus> r100 = this.devices;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    public List<DeviceStatus> getDevices() {
        return this.devices;
    }

    public void add(DeviceStatus r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.getDeviceId()) == false) goto L7;
        return;
    L7:
        if (this.devices != null) goto L9;
        this.devices = new ArrayList();
    L9:
        this.devices.add(r100);
    }

    public boolean contains(DeviceStatus r100) {
        if (r100 == null) goto L16;
        List<DeviceStatus> r101 = this.devices;
        if (r101 == null) goto L24;
        Iterator<DeviceStatus> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L25;
        DeviceStatus r103 = r102.next();
        if (r103 == null) goto L8;
        if (a(r103.getDeviceId(), r100.getDeviceId()) == false) goto L8;
        return true;
    L25:
        return false;
    L24:
        return false;
    L16:
        return false;
    }

    public void remove(DeviceStatus r100) {
        if (r100 == null) goto L22;
        List<DeviceStatus> r101 = this.devices;
        if (r101 == null) goto L23;
        Iterator<DeviceStatus> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L24;
        DeviceStatus r103 = r102.next();
        if (r103 == null) goto L8;
        if (a(r103.getDeviceId(), r100.getDeviceId()) == false) goto L8;
        this.devices.remove(r103);
        return;
    L24:
        return;
    L23:
        return;
    }

    public void setDevices(List<DeviceStatus> r100) {
        this.devices = r100;
    }

    public void update(DeviceStatus r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<DeviceStatus> r101 = this.devices;
        if (r101 != null) goto L8;
        ArrayList r102 = new ArrayList();
        this.devices = r102;
        r102.add(r100);
        return;
    L8:
        Iterator<DeviceStatus> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L18;
        DeviceStatus r104 = r103.next();
        if (r104 == null) goto L10;
        if (a(r104.getDeviceId(), r100.getDeviceId()) == false) goto L10;
        r104.setOnlineStatus(r100.getOnlineStatus());
        return;
    L18:
        this.devices.add(r100);
    }

    public static boolean a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return false;
    L8:
        return r100.equals(r101);
    }
}
