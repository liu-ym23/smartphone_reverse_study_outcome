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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BaseStationHelper {
    private Context mContext;
    private final TelephonyManager mTelephonyManager;

    public interface CellInfoFecher {
        List<CellInfo> fetchCellInfo();
    }

    private static int doCheckAndReturnBackup(int r1, int r2) {
        if (r1 != Integer.MAX_VALUE) goto L5;
        return r2;
    L5:
        return r1;
    }

    public BaseStationHelper(Context r2) {
        this.mContext = r2;
        this.mTelephonyManager = (TelephonyManager) r2.getSystemService("phone");
    }

    public static /* synthetic */ Context access$000(BaseStationHelper r0) {
        return r0.mContext;
    }

    public static /* synthetic */ TelephonyManager access$100(BaseStationHelper r0) {
        return r0.mTelephonyManager;
    }

    public static int[] getMccMncPair(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (r3.length() > 3) goto L12;
        return null;
    L12:
        return new int[]{CastIntegerProtector.parseInt(r3.substring(0, 3)), CastIntegerProtector.parseInt(r3.substring(3))};
    L15:
        return null;
    }

    private BaseStation buildBaseStation(Object r14, CellInfoFecher r15) throws SecurityException {
        BaseStation r0 = new BaseStation();
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L23;
        int r3 = Integer.MAX_VALUE;
        int[] r2 = getMccMncPair(r1.getNetworkOperator());     // Catch: Exception -> L11
        if (r2 == null) goto L13;
        int r4 = r2[0];     // Catch: Exception -> L11
        int r5 = r2[1];     // Catch: Exception -> L24
        r3 = r4;
    L14:
        r0.current = new BssInfo();
        r0.neighboring = new ArrayList();
        List<CellInfo> r16 = r15.fetchCellInfo();
        long r11 = -1;
        if (r16 != null) goto L17;
    L22:
        r0.baseStationGap = (System.currentTimeMillis() / 1000) - r11;
        Logger.i("buildBaseStation baseStationGap: " + r0.baseStationGap);
        goto L23
    L17:
        if (r16.isEmpty() == true) goto L22;
        addCellInfo(r0.current, (CellInfo) ListProtector.get(r16, 0), r3, r5, r14);
        Iterator<CellInfo> r17 = r16.iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        CellInfo r7 = r17.next();
        BssInfo r6 = new BssInfo();
        addCellInfo(r6, r7, r3, r5, r14);
        r0.neighboring.add(r6);
        r11 = Math.max(r11, r6.timestamp);
    L12:
        r3 = r4;
    L13:
        r5 = Integer.MAX_VALUE;
    L11:
        r4 = Integer.MAX_VALUE;
    L23:
        return r0;
    }

    private static int doCheckAndReturnBackup(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r2;
    L8:
        return CastIntegerProtector.parseInt(r1);
    L7:
        return r2;
    }

    public BaseStation buildBaseState(Object r2, final List<CellInfo> r3) throws SecurityException {
        return buildBaseStation(r2, new AnonymousClass2(this, r3));
    }

    private void addCurrentCellInfo(BaseStation r4, CellLocation r5, Object r6) {
        if ((r5 instanceof GsmCellLocation) == false) goto L6;
        GsmCellLocation r7 = (GsmCellLocation) r5;
        BssInfo r0 = r4.current;
        r0.radioType = LocationInfoConst.GSM;
        r0.cid = BDLocationExtrasService.getBPEAManager().getCid(r7, r6);
        r4.current.lac = BDLocationExtrasService.getBPEAManager().getLac(r7, r6);
        r4.current.psc = BDLocationExtrasService.getBPEAManager().getPsc(r7, r6);
        return;
    L6:
        if ((r5 instanceof CdmaCellLocation) == false) goto L10;
        CdmaCellLocation r8 = (CdmaCellLocation) r5;
        BssInfo r1 = r4.current;
        r1.radioType = LocationInfoConst.CDMA;
        r1.bid = BDLocationExtrasService.getBPEAManager().getBaseStationId(r8, r6);
        r4.current.lat = BDLocationExtrasService.getBPEAManager().getBaseStationLatitude(r8, r6);
        r4.current.longi = BDLocationExtrasService.getBPEAManager().getBaseStationLongitude(r8, r6);
        r4.current.nid = BDLocationExtrasService.getBPEAManager().getNetworkId(r8, r6);
        r4.current.sid = BDLocationExtrasService.getBPEAManager().getSystemId(r8, r6);
        return;
    }

    public BaseStation getBaseStation(final Object r2, final boolean r3, final RefreshBaseStationInfo r4) throws SecurityException {
        return buildBaseStation(r2, new AnonymousClass1(this, r2, r3, r4));
    }

    public BaseStation getLightBaseStation(Object r11, boolean r12, boolean r13) throws SecurityException {
        BaseStation r0 = new BaseStation();
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L34;
        int r2 = Integer.MAX_VALUE;
        int[] r3 = getMccMncPair(r1.getNetworkOperator());     // Catch: Exception -> L12
        if (r3 == null) goto L11;
        int r4 = r3[0];     // Catch: Exception -> L12
        int r5 = r3[1];     // Catch: Exception -> L36
        r2 = r4;
    L14:
        List<CellInfo> r14 = CellInfoUtil.getAllCellInfo(this.mContext, this.mTelephonyManager, r11, false, r12, null);
        if (r14 != null) goto L17;
        return null;
    L17:
        if (r14.isEmpty() == true) goto L53;
        Iterator<CellInfo> r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L33;
        CellInfo r6 = r15.next();
        if (r6 == null) goto L20;
        if (r6.isRegistered() == true) goto L25;
        if (r13 == false) goto L20;
        if (r0.neighboring != null) goto L32;
        r0.neighboring = new ArrayList();
    L32:
        BssInfo r7 = new BssInfo();
        addCellInfo(r7, r6, r2, r5, r11);
        r0.neighboring.add(r7);
        goto L20
    L25:
        BssInfo r8 = new BssInfo();
        r0.current = r8;
        addCellInfo(r8, r6, r2, r5, r11);
        if (r13 == true) goto L20;
        return r0;
    L33:
        return r0;
    L53:
        return null;
    L13:
        r2 = r4;
    L11:
        r5 = Integer.MAX_VALUE;
    L12:
        r4 = Integer.MAX_VALUE;
        goto L13
    L34:
        return null;
    }

    private void addCellInfo(BssInfo r7, CellInfo r8, int r9, int r10, Object r11) {
        if (r7 == null) goto L6;
        if (r8 == null) goto L6;
        r7.timestamp = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r8.getTimeStamp() / 1000000)) / 1000;
        r7.isRegistered = r8.isRegistered();
    L6:
        if ((r8 instanceof CellInfoGsm) == false) goto L9;
        CellInfoGsm r12 = (CellInfoGsm) r8;
        CellIdentityGsm r13 = r12.getCellIdentity();
        CellSignalStrengthGsm r14 = r12.getCellSignalStrength();
        r7.radioType = LocationInfoConst.GSM;
        r7.lac = r13.getLac();
        r7.cid = r13.getCid();
        r7.psc = r13.getPsc();
        r7.bsss = r14.getDbm();
        r7.mcc = doCheckAndReturnBackup(r13.getMcc(), r9);
        r7.mnc = doCheckAndReturnBackup(r13.getMnc(), r10);
        return;
    L9:
        if ((r8 instanceof CellInfoCdma) == false) goto L12;
        CellInfoCdma r15 = (CellInfoCdma) r8;
        CellIdentityCdma r16 = r15.getCellIdentity();
        CellSignalStrengthCdma r17 = r15.getCellSignalStrength();
        r7.radioType = LocationInfoConst.CDMA;
        r7.bid = r16.getBasestationId();
        r7.lat = r16.getLatitude();
        r7.longi = r16.getLongitude();
        r7.nid = r16.getNetworkId();
        r7.sid = r16.getSystemId();
        r7.bsss = r17.getDbm();
        r7.mcc = r9;
        r7.mnc = r10;
        return;
    L12:
        if ((r8 instanceof CellInfoLte) == false) goto L20;
        CellInfoLte r18 = (CellInfoLte) r8;
        CellIdentityLte r0 = r18.getCellIdentity();
        CellSignalStrengthLte r19 = r18.getCellSignalStrength();
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 28) goto L16;
        r7.bw = r0.getBandwidth();
    L16:
        r7.ci = r0.getCi();
        if (r1 < 24) goto L19;
        r7.earfcn = r0.getEarfcn();
    L19:
        r7.radioType = LocationInfoConst.LTE;
        r7.pci = r0.getPci();
        r7.tac = BDLocationExtrasService.getBPEAManager().getTac(r0, r11);
        r7.bsss = r19.getDbm();
        r7.mcc = doCheckAndReturnBackup(r0.getMcc(), r9);
        r7.mnc = doCheckAndReturnBackup(r0.getMnc(), r10);
        return;
    L20:
        int r110 = Build.VERSION.SDK_INT;
        if ((r8 instanceof CellInfoWcdma) == false) goto L24;
        CellInfoWcdma r20 = (CellInfoWcdma) r8;
        CellIdentityWcdma r111 = r20.getCellIdentity();
        CellSignalStrengthWcdma r21 = r20.getCellSignalStrength();
        r7.radioType = LocationInfoConst.WCDMA;
        r7.cid = r111.getCid();
        r7.lac = r111.getLac();
        r7.psc = r111.getPsc();
        r7.bsss = r21.getDbm();
        r7.mcc = doCheckAndReturnBackup(r111.getMcc(), r9);
        r7.mnc = doCheckAndReturnBackup(r111.getMnc(), r10);
        return;
    L24:
        if (r110 >= 29) goto L26;
    L36:
        if (r110 >= 29) goto L38;
        return;
    L38:
        if ((r8 instanceof CellInfoTdscdma) == false) goto L53;
        CellInfoTdscdma r22 = (CellInfoTdscdma) r8;
        CellSignalStrengthTdscdma r112 = r22.getCellSignalStrength();
        if (r112 == null) goto L42;
        r7.bsss = r112.getDbm();
    L42:
        CellIdentityTdscdma r23 = r22.getCellIdentity();
        r7.radioType = LocationInfoConst.WCDMA;
        r7.lac = r23.getLac();
        r7.cid = r23.getCid();
        r7.cpid = r23.getCpid();
        r7.mcc = doCheckAndReturnBackup(r23.getMccString(), r9);
        r7.mnc = doCheckAndReturnBackup(r23.getMncString(), r10);
        return;
    L53:
        return;
    L26:
        if ((r8 instanceof CellInfoNr) == false) goto L36;
        CellInfoNr r24 = (CellInfoNr) r8;     // Catch: Exception -> L34
        CellSignalStrengthNr r113 = (CellSignalStrengthNr) r24.getCellSignalStrength();     // Catch: Exception -> L34
        if (r113 == null) goto L30;
        r7.bsss = r113.getSsRsrp();     // Catch: Exception -> L34
    L30:
        CellIdentityNr r25 = (CellIdentityNr) r24.getCellIdentity();     // Catch: Exception -> L34
        if (r25 == null) goto L50;
        r7.radioType = LocationInfoConst.NR;     // Catch: Exception -> L34
        r7.tac = r25.getTac();     // Catch: Exception -> L34
        r7.pci = r25.getPci();     // Catch: Exception -> L34
        r7.nci = r25.getNci();     // Catch: Exception -> L34
        r7.mcc = doCheckAndReturnBackup(r25.getMccString(), r9);     // Catch: Exception -> L34
        r7.mnc = doCheckAndReturnBackup(r25.getMncString(), r10);     // Catch: Exception -> L34
        r7.earfcn = r25.getNrarfcn();     // Catch: Exception -> L34
        return;
    L50:
        return;
    L34:
        e = move-exception;
        Logger.i("CellInfoNr error:" + e.toString());
    }
}
