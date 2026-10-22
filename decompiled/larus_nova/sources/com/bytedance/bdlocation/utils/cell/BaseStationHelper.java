package com.bytedance.bdlocation.utils.cell;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BaseStationHelper {
    private Context mContext;
    private final TelephonyManager mTelephonyManager;

    public interface CellInfoFecher {
        List<CellInfo> fetchCellInfo();
    }

    private static int doCheckAndReturnBackup(int r100, int r101) {
        if (r100 != Integer.MAX_VALUE) goto L5;
        return r101;
    L5:
        return r100;
    }

    public BaseStationHelper(Context r100) {
        this.mContext = r100;
        this.mTelephonyManager = (TelephonyManager) r100.getSystemService("phone");
    }

    public static /* synthetic */ Context access$000(BaseStationHelper r100) {
        return r100.mContext;
    }

    public static /* synthetic */ TelephonyManager access$100(BaseStationHelper r100) {
        return r100.mTelephonyManager;
    }

    public static int[] getMccMncPair(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (r100.length() > 3) goto L12;
        return null;
    L12:
        return new int[]{CastIntegerProtector.parseInt(r100.substring(0, 3)), CastIntegerProtector.parseInt(r100.substring(3))};
    L15:
        return null;
    }

    private BaseStation buildBaseStation(Object r110, CellInfoFecher r111) throws SecurityException {
        BaseStation r100 = new BaseStation();
        TelephonyManager r101 = this.mTelephonyManager;
        if (r101 == null) goto L23;
        int r102 = Integer.MAX_VALUE;
        int[] r103 = getMccMncPair(r101.getNetworkOperator());     // Catch: Exception -> L11
        if (r103 == null) goto L13;
        int r104 = r103[0];     // Catch: Exception -> L11
        int r105 = r103[1];     // Catch: Exception -> L24
        r102 = r104;
    L14:
        r100.current = new BssInfo();
        r100.neighboring = new ArrayList();
        List<CellInfo> r112 = r111.fetchCellInfo();
        long r113 = -1;
        if (r112 != null) goto L17;
    L22:
        r100.baseStationGap = (System.currentTimeMillis() / 1000) - r113;
        Logger.i("buildBaseStation baseStationGap: " + r100.baseStationGap);
        goto L23
    L17:
        if (r112.isEmpty() == true) goto L22;
        addCellInfo(r100.current, (CellInfo) ListProtector.get(r112, 0), r102, r105, r110);
        Iterator<CellInfo> r114 = r112.iterator();
    L20:
        if (r114.hasNext() == false) goto L22;
        CellInfo r106 = r114.next();
        BssInfo r107 = new BssInfo();
        addCellInfo(r107, r106, r102, r105, r110);
        r100.neighboring.add(r107);
        r113 = Math.max(r113, r107.timestamp);
    L12:
        r102 = r104;
    L13:
        r105 = Integer.MAX_VALUE;
    L11:
        r104 = Integer.MAX_VALUE;
    L23:
        return r100;
    }

    private static int doCheckAndReturnBackup(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return r101;
    L8:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return r101;
    }

    public BaseStation buildBaseState(Object r100, final List<CellInfo> r101) throws SecurityException {
        return buildBaseStation(r100, new AnonymousClass2(this, r101));
    }

    private void addCurrentCellInfo(BaseStation r100, CellLocation r101, Object r102) {
        if ((r101 instanceof GsmCellLocation) == false) goto L6;
        GsmCellLocation r103 = (GsmCellLocation) r101;
        BssInfo r104 = r100.current;
        r104.radioType = LocationInfoConst.GSM;
        r104.cid = BDLocationExtrasService.getBPEAManager().getCid(r103, r102);
        r100.current.f199864lac = BDLocationExtrasService.getBPEAManager().getLac(r103, r102);
        r100.current.f199867psc = BDLocationExtrasService.getBPEAManager().getPsc(r103, r102);
        return;
    L6:
        if ((r101 instanceof CdmaCellLocation) == false) goto L10;
        CdmaCellLocation r105 = (CdmaCellLocation) r101;
        BssInfo r106 = r100.current;
        r106.radioType = LocationInfoConst.CDMA;
        r106.bid = BDLocationExtrasService.getBPEAManager().getBaseStationId(r105, r102);
        r100.current.lat = BDLocationExtrasService.getBPEAManager().getBaseStationLatitude(r105, r102);
        r100.current.longi = BDLocationExtrasService.getBPEAManager().getBaseStationLongitude(r105, r102);
        r100.current.nid = BDLocationExtrasService.getBPEAManager().getNetworkId(r105, r102);
        r100.current.sid = BDLocationExtrasService.getBPEAManager().getSystemId(r105, r102);
        return;
    }

    public BaseStation getBaseStation(final Object r100, final boolean r101, final RefreshBaseStationInfo r102) throws SecurityException {
        return buildBaseStation(r100, new AnonymousClass1(this, r100, r101, r102));
    }

    public BaseStation getLightBaseStation(Object r110, boolean r111, boolean r112) throws SecurityException {
        BaseStation r100 = new BaseStation();
        TelephonyManager r101 = this.mTelephonyManager;
        if (r101 == null) goto L34;
        int r102 = Integer.MAX_VALUE;
        int[] r103 = getMccMncPair(r101.getNetworkOperator());     // Catch: Exception -> L12
        if (r103 == null) goto L11;
        int r104 = r103[0];     // Catch: Exception -> L12
        int r105 = r103[1];     // Catch: Exception -> L36
        r102 = r104;
    L14:
        List<CellInfo> r113 = CellInfoUtil.getAllCellInfo(this.mContext, this.mTelephonyManager, r110, false, r111, null);
        if (r113 != null) goto L17;
        return null;
    L17:
        if (r113.isEmpty() == true) goto L53;
        Iterator<CellInfo> r114 = r113.iterator();
    L20:
        if (r114.hasNext() == false) goto L33;
        CellInfo r106 = r114.next();
        if (r106 == null) goto L20;
        if (r106.isRegistered() == true) goto L25;
        if (r112 == false) goto L20;
        if (r100.neighboring != null) goto L32;
        r100.neighboring = new ArrayList();
    L32:
        BssInfo r107 = new BssInfo();
        addCellInfo(r107, r106, r102, r105, r110);
        r100.neighboring.add(r107);
        goto L20
    L25:
        BssInfo r108 = new BssInfo();
        r100.current = r108;
        addCellInfo(r108, r106, r102, r105, r110);
        if (r112 == true) goto L20;
        return r100;
    L33:
        return r100;
    L53:
        return null;
    L13:
        r102 = r104;
    L11:
        r105 = Integer.MAX_VALUE;
    L12:
        r104 = Integer.MAX_VALUE;
        goto L13
    L34:
        return null;
    }

    private void addCellInfo(BssInfo r100, CellInfo r101, int r102, int r110, Object r111) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        r100.timestamp = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r101.getTimeStamp() / 1000000)) / 1000;
        r100.isRegistered = r101.isRegistered();
    L6:
        if ((r101 instanceof CellInfoGsm) == false) goto L9;
        CellInfoGsm r103 = (CellInfoGsm) r101;
        CellIdentityGsm r112 = r103.getCellIdentity();
        CellSignalStrengthGsm r104 = r103.getCellSignalStrength();
        r100.radioType = LocationInfoConst.GSM;
        r100.f199864lac = r112.getLac();
        r100.cid = r112.getCid();
        r100.f199867psc = r112.getPsc();
        r100.bsss = r104.getDbm();
        r100.f199865mcc = doCheckAndReturnBackup(r112.getMcc(), r102);
        r100.f199866mnc = doCheckAndReturnBackup(r112.getMnc(), r110);
        return;
    L9:
        if ((r101 instanceof CellInfoCdma) == false) goto L12;
        CellInfoCdma r105 = (CellInfoCdma) r101;
        CellIdentityCdma r113 = r105.getCellIdentity();
        CellSignalStrengthCdma r106 = r105.getCellSignalStrength();
        r100.radioType = LocationInfoConst.CDMA;
        r100.bid = r113.getBasestationId();
        r100.lat = r113.getLatitude();
        r100.longi = r113.getLongitude();
        r100.nid = r113.getNetworkId();
        r100.sid = r113.getSystemId();
        r100.bsss = r106.getDbm();
        r100.f199865mcc = r102;
        r100.f199866mnc = r110;
        return;
    L12:
        if ((r101 instanceof CellInfoLte) == false) goto L20;
        CellInfoLte r107 = (CellInfoLte) r101;
        CellIdentityLte r108 = r107.getCellIdentity();
        CellSignalStrengthLte r109 = r107.getCellSignalStrength();
        int r114 = Build.VERSION.SDK_INT;
        if (r114 < 28) goto L16;
        r100.f199862bw = r108.getBandwidth();
    L16:
        r100.f199863ci = r108.getCi();
        if (r114 < 24) goto L19;
        r100.earfcn = r108.getEarfcn();
    L19:
        r100.radioType = LocationInfoConst.LTE;
        r100.pci = r108.getPci();
        r100.f199868tac = BDLocationExtrasService.getBPEAManager().getTac(r108, r111);
        r100.bsss = r109.getDbm();
        r100.f199865mcc = doCheckAndReturnBackup(r108.getMcc(), r102);
        r100.f199866mnc = doCheckAndReturnBackup(r108.getMnc(), r110);
        return;
    L20:
        int r115 = Build.VERSION.SDK_INT;
        if ((r101 instanceof CellInfoWcdma) == false) goto L24;
        CellInfoWcdma r116 = (CellInfoWcdma) r101;
        CellIdentityWcdma r117 = r116.getCellIdentity();
        CellSignalStrengthWcdma r118 = r116.getCellSignalStrength();
        r100.radioType = LocationInfoConst.WCDMA;
        r100.cid = r117.getCid();
        r100.f199864lac = r117.getLac();
        r100.f199867psc = r117.getPsc();
        r100.bsss = r118.getDbm();
        r100.f199865mcc = doCheckAndReturnBackup(r117.getMcc(), r102);
        r100.f199866mnc = doCheckAndReturnBackup(r117.getMnc(), r110);
        return;
    L24:
        if (r115 >= 29) goto L26;
    L36:
        if (r115 >= 29) goto L38;
        return;
    L38:
        if ((r101 instanceof CellInfoTdscdma) == false) goto L53;
        CellInfoTdscdma r119 = (CellInfoTdscdma) r101;
        CellSignalStrengthTdscdma r120 = r119.getCellSignalStrength();
        if (r120 == null) goto L42;
        r100.bsss = r120.getDbm();
    L42:
        CellIdentityTdscdma r121 = r119.getCellIdentity();
        r100.radioType = LocationInfoConst.WCDMA;
        r100.f199864lac = r121.getLac();
        r100.cid = r121.getCid();
        r100.cpid = r121.getCpid();
        r100.f199865mcc = doCheckAndReturnBackup(r121.getMccString(), r102);
        r100.f199866mnc = doCheckAndReturnBackup(r121.getMncString(), r110);
        return;
    L53:
        return;
    L26:
        if ((r101 instanceof CellInfoNr) == false) goto L36;
        CellInfoNr r122 = (CellInfoNr) r101;     // Catch: Exception -> L34
        CellSignalStrengthNr r123 = (CellSignalStrengthNr) r122.getCellSignalStrength();     // Catch: Exception -> L34
        if (r123 == null) goto L30;
        r100.bsss = r123.getSsRsrp();     // Catch: Exception -> L34
    L30:
        CellIdentityNr r124 = (CellIdentityNr) r122.getCellIdentity();     // Catch: Exception -> L34
        if (r124 == null) goto L50;
        r100.radioType = LocationInfoConst.NR;     // Catch: Exception -> L34
        r100.f199868tac = r124.getTac();     // Catch: Exception -> L34
        r100.pci = r124.getPci();     // Catch: Exception -> L34
        r100.nci = r124.getNci();     // Catch: Exception -> L34
        r100.f199865mcc = doCheckAndReturnBackup(r124.getMccString(), r102);     // Catch: Exception -> L34
        r100.f199866mnc = doCheckAndReturnBackup(r124.getMncString(), r110);     // Catch: Exception -> L34
        r100.earfcn = r124.getNrarfcn();     // Catch: Exception -> L34
        return;
    L50:
        return;
    L34:
        e = move-exception;
        Logger.i("CellInfoNr error:" + e.toString());
    }
}
