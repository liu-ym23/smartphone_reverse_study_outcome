package com.bytedance.bdlocation.scan.strategy;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.scan.wifi.WifiInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/bdlocation/scan/strategy/ScanWifiStrategy;", "", "()V", LocationMonitorConst.TAG, "", "checkScanWifiStrategy", "", "locInfoRsp", "Lcom/bytedance/bdlocation/network/response/LocationResp;", "deviceLocation", "Lcom/bytedance/bdlocation/network/model/DeviceLocation;", "deviceStatus", "Lcom/bytedance/bdlocation/network/model/DeviceStatus;", "extra", "Lcom/bytedance/bdlocation/network/model/LocationUploadExtra;", "library_release"}, k = 1, mv = {1, 1, 16})
public final class ScanWifiStrategy {
    public static final ScanWifiStrategy INSTANCE = null;
    private static final String tag = "[ScanWifiStrategy] ";

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.strategy.ScanWifiStrategy$checkScanWifiStrategy$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ DeviceLocation $deviceLocation;
        final /* synthetic */ DeviceStatus $deviceStatus;
        final /* synthetic */ LocationUploadExtra $extra;
        final /* synthetic */ LocationResp $locInfoRsp;

        public AnonymousClass1(LocationResp r1, DeviceLocation r2, DeviceStatus r3, LocationUploadExtra r4) {
            this.$locInfoRsp = r1;
            this.$deviceLocation = r2;
            this.$deviceStatus = r3;
            this.$extra = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com_bytedance_bdlocation_scan_strategy_ScanWifiStrategy$checkScanWifiStrategy$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public final void com_bytedance_bdlocation_scan_strategy_ScanWifiStrategy$checkScanWifiStrategy$1__run$___twin___() {
            if (this.$locInfoRsp != null) goto L7;
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "loc info resp is null, don't rescan");
            return;
        L7:
            if (BDLocationConfig.initIfNeed() == true) goto L9;
        L22:
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "bdlocation config no init or rescan count <= 0");
            return;
        L9:
            if (BDLocationConfig.rescanWifiCount() <= 0) goto L22;
            LocInfoRspData r0 = LocationUtil.parseLocInfoRsp(this.$locInfoRsp);
            if (r0 != null) goto L14;
        L20:
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "loc info resp data is null or wifirescan <= 0 && enbale rescan wifi is false");
            return;
        L14:
            if (r0.isWifiRescan <= 0) goto L16;
        L18:
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "wifi strategy is " + r0.isWifiRescan);
            new WifiInfoManager().getWifiScanInfos(BDLocationConfig.getContext(), new ScanWifiStrategy$checkScanWifiStrategy$1$wifiInfoCallback$1(this), BDLocationExtrasService.getBPEAManager().getBpeaCert("bpea-location_sdk_rescan_wifi"), null);
            return;
        L16:
            if (BDLocationConfig.enableRescanWifi() == true) goto L18;
            goto L18
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_bdlocation_scan_strategy_ScanWifiStrategy$checkScanWifiStrategy$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r1) {
            r1.com_bytedance_bdlocation_scan_strategy_ScanWifiStrategy$checkScanWifiStrategy$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private ScanWifiStrategy() {
    }

    static {
        INSTANCE = new ScanWifiStrategy();
        tag = "[ScanWifiStrategy] ";
    }

    public static final /* synthetic */ String access$getTag$p(ScanWifiStrategy r0) {
        return tag;
    }

    public final void checkScanWifiStrategy(LocationResp r3, DeviceLocation r4, DeviceStatus r5, LocationUploadExtra r6) {
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass1(r3, r4, r5, r6));
    }
}
