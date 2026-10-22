package com.ss.bytertc.base.utils;

/* JADX INFO: loaded from: classes40.dex */
public final class WlanMonitor {

    public static class ConnectionInfo {
        private String ifName;
        private int noise;
        private int rssi;
        private int rxRate;
        private int txRate;

        public String getIfName() {
            return this.ifName;
        }

        public int getNoise() {
            return this.noise;
        }

        public int getRssi() {
            return this.rssi;
        }

        public int getRxRate() {
            return this.rxRate;
        }

        public int getTxRate() {
            return this.txRate;
        }

        public ConnectionInfo(String r100, int r101, int r102, int r103, int r104) {
            this.ifName = r100;
            this.rssi = r101;
            this.noise = r102;
            this.txRate = r103;
            this.rxRate = r104;
        }
    }

    public static class InterfaceInfo {
        private int channelWidth;
        private int channleNum;
        private int frequency;
        private String ifName;
        private int phyMode;
        private boolean state;

        public int getChannelWidth() {
            return this.channelWidth;
        }

        public int getChannleNum() {
            return this.channleNum;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public String getIfName() {
            return this.ifName;
        }

        public int getPhyMode() {
            return this.phyMode;
        }

        public boolean getState() {
            return this.state;
        }

        public InterfaceInfo(String r100, boolean r101, int r102, int r103, int r104, int r105) {
            this.ifName = r100;
            this.state = r101;
            this.frequency = r102;
            this.phyMode = r103;
            this.channleNum = r104;
            this.channelWidth = r105;
        }
    }

    public static class ScanResultInfo {
        private int channelWidth;
        private int channleNum;
        private int frequency;
        private int noise;
        private int rssi;

        public int getChannelWidth() {
            return this.channelWidth;
        }

        public int getChannleNum() {
            return this.channleNum;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public int getNoise() {
            return this.noise;
        }

        public int getRssi() {
            return this.rssi;
        }

        public ScanResultInfo(int r100, int r101, int r102, int r103, int r104) {
            this.frequency = r100;
            this.channleNum = r101;
            this.channelWidth = r102;
            this.rssi = r103;
            this.noise = r104;
        }
    }

    public WlanMonitor() {
    }

    public static ConnectionInfo[] getConnectionInfos() {
        return null;
    }

    public static int getFrequency() {
        return 0;
    }

    public static InterfaceInfo[] getInterfaceInfos() {
        return null;
    }

    public static ScanResultInfo[] getScanResultInfos() {
        return null;
    }

    public static int getSignalQuality() {
        return 0;
    }
}
