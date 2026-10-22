package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public class Devices implements Serializable {

    @JSONField(name = "device")
    private List<Device> sessions;

    public static final class DeleteDevice implements Serializable {
        private boolean success;

        public DeleteDevice() {
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean r100) {
            this.success = r100;
        }
    }

    public static final class Device implements Serializable {

        @JSONField(name = "device_id")
        private String deviceId;

        @JSONField(name = "device_model")
        private String deviceModel;

        @JSONField(name = ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME)
        private String deviceName;

        @JSONField(name = "device_os")
        private String deviceOs;

        @JSONField(name = "is_abnormal")
        private boolean isAbnormal;

        @JSONField(name = "is_current")
        private boolean isCurrentDevice;

        @JSONField(name = "is_online")
        private boolean isOnline;

        @JSONField(name = "login_time")
        private long loginTime;

        @JSONField(name = "tenant_name")
        public String tenantName;

        @JSONField(name = "terminal_type")
        private int terminalType;

        public Device() {
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public String getDeviceModel() {
            return this.deviceModel;
        }

        public String getDeviceName() {
            return this.deviceName;
        }

        public String getDeviceOs() {
            return this.deviceOs;
        }

        public boolean getIsAbnormal() {
            return this.isAbnormal;
        }

        public boolean getIsCurrentDevice() {
            return this.isCurrentDevice;
        }

        public boolean getIsOnline() {
            return this.isOnline;
        }

        public long getLoginTime() {
            return this.loginTime;
        }

        public int getTerminalType() {
            return this.terminalType;
        }

        public void setDeviceId(String r100) {
            this.deviceId = r100;
        }

        public void setDeviceModel(String r100) {
            this.deviceModel = r100;
        }

        public void setDeviceName(String r100) {
            this.deviceName = r100;
        }

        public void setDeviceOs(String r100) {
            this.deviceOs = r100;
        }

        public void setIsAbnormal(boolean r100) {
            this.isAbnormal = r100;
        }

        public void setIsCurrentDevice(boolean r100) {
            this.isCurrentDevice = r100;
        }

        public void setIsOnline(boolean r100) {
            this.isOnline = r100;
        }

        public void setLoginTime(long r100) {
            this.loginTime = r100;
        }

        public void setTerminalType(int r100) {
            this.terminalType = r100;
        }
    }

    public Devices() {
    }

    public List<Device> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Device> r100) {
        this.sessions = r100;
    }
}
