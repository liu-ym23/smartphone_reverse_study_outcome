package com.larus.cdm;

import androidx.exifinterface.media.ExifInterface;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
public final class DeviceHandler {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/cdm/DeviceHandler$Device;", "", "productId", "", "productName", "", "scanUUID", "connectUUID", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()I", "getProductName", "()Ljava/lang/String;", "getScanUUID", "getConnectUUID", "D_OLD", "D", ExifInterface.LONGITUDE_EAST, "G", "H_FREE_CLIP", "H_FREE_PRO", "H_FREE_BUDS_PRO", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Device extends Enum<Device> {
        public static final Device D = null;
        public static final Device D_OLD = null;
        public static final Device E = null;
        public static final Device G = null;
        public static final Device H_FREE_BUDS_PRO = null;
        public static final Device H_FREE_CLIP = null;
        public static final Device H_FREE_PRO = null;
        public static final Device UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Device[] f323878a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f323879b = null;
        private final String connectUUID;
        private final int productId;
        private final String productName;
        private final String scanUUID;

        public static EnumEntries<Device> getEntries() {
            return f323879b;
        }

        static {
            Device r100 = new Device("D_OLD", 0, 0, DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME, "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            D_OLD = r100;
            Device r101 = new Device("D", 1, 1, DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME, "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            D = r101;
            Device r102 = new Device(ExifInterface.LONGITUDE_EAST, 2, 2, "DoraE", "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            E = r102;
            Device r103 = new Device("G", 3, 16, "DoraG", "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            G = r103;
            Device r104 = new Device("H_FREE_CLIP", 4, 1048576, "HUAWEI FreeClip 2", "0000FDEE-0000-1000-8000-00805F9B34FB", "00101020-4C42-0065-636E-614465747942");
            H_FREE_CLIP = r104;
            Device r105 = new Device("H_FREE_PRO", 5, 1048577, "HUAWEI FreeBuds Pro 5", "0000FDEE-0000-1000-8000-00805F9B34FB", "00101020-4C42-0065-636E-614465747942");
            H_FREE_PRO = r105;
            Device r106 = new Device("H_FREE_BUDS_PRO", 6, 1048578, "HUAWEI FreeBuds Pro 5", "0000FDEE-0000-1000-8000-00805F9B34FB", "00101020-4C42-0065-636E-614465747942");
            H_FREE_BUDS_PRO = r106;
            Device r107 = new Device("UNKNOWN", 7, -1, "UNKNOWN", "", "");
            UNKNOWN = r107;
            Device[] r108 = {r100, r101, r102, r103, r104, r105, r106, r107};
            f323878a = r108;
            f323879b = EnumEntriesKt.enumEntries(r108);
        }

        public static Device[] values() {
            return (Device[]) f323878a.clone();
        }

        public final String getConnectUUID() {
            return this.connectUUID;
        }

        public final int getProductId() {
            return this.productId;
        }

        public final String getProductName() {
            return this.productName;
        }

        public final String getScanUUID() {
            return this.scanUUID;
        }

        public static Device valueOf(String r100) {
            return (Device) a.a(Device.class, r100);
        }

        public Device(String r100, int r101, int r102, String r103, String r104, String r105) {
            super(r100, r101);
            this.productId = r102;
            this.productName = r103;
            this.scanUUID = r104;
            this.connectUUID = r105;
        }
    }

    static {
    }

    public static Device a(int r100) {
        Device r101 = Device.G;
        if (r100 != r101.getProductId()) goto L6;
        return r101;
    L6:
        if (r100 == Device.D_OLD.getProductId()) goto L25;
        Device r102 = Device.D;
        if (r100 == r102.getProductId()) goto L27;
        Device r103 = Device.E;
        if (r100 == r103.getProductId()) goto L28;
        Device r104 = Device.H_FREE_CLIP;
        if (r100 == r104.getProductId()) goto L29;
        Device r105 = Device.H_FREE_PRO;
        if (r100 == r105.getProductId()) goto L30;
        Device r106 = Device.H_FREE_BUDS_PRO;
        if (r100 != r106.getProductId()) goto L24;
        return r106;
    L24:
        return Device.UNKNOWN;
    L30:
        return r105;
    L29:
        return r104;
    L28:
        return r103;
    L27:
        return r102;
    L25:
        return Device.D;
    }
}
