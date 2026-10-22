package com.bytedance.bdlocation.utils.cell;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class CellInfoUtil {
    public CellInfoUtil() {
    }

    private static List<CellInfo> getAllCellInfoBeforeInit(Context r100, TelephonyManager r101) {
        return r101.getAllCellInfo();
    L4:
        Logger.e("getAllCellInfoBeforeInit#getAllCellInfo occur throwable !");
        return null;
    }

    public static List<CellInfo> getAllCellInfoAfterInit(TelephonyManager r100, Object r101, boolean r102, RefreshBaseStationInfo r103) {
        List<CellInfo> r104 = null;
        if (r100 != null) goto L14;
        return null;
    L14:
    L12:
        Logger.e("LocationInfoCollector#getAllCellInfo occur throwable !");
        return r104;
    L6:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L16;
        requestCellInfoUpdate(r100, r101, r102, r103);     // Catch: Throwable -> L12
        if (r103 == null) goto L10;
        return null;
    L10:
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L12
        r104 = BDLocationExtrasService.getBPEAManager().getAllCellInfo(r100, r101);     // Catch: Throwable -> L12
        Logger.i("getAllCellInfo duration:" + (System.currentTimeMillis() - r105));     // Catch: Throwable -> L12
        return r104;
    L16:
        return null;
    }

    public static CellLocation getCellLocation(Context r100, TelephonyManager r101, Object r102, boolean r103) {
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r103 == false) goto L8;
        return r101.getCellLocation();
    L8:
        if (PermissionManager.hasAnyPermission(r100, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getCellLocation(r101, r102);
    }

    private static void requestCellInfoUpdate(TelephonyManager r100, final Object r101, boolean r102, final RefreshBaseStationInfo r103) {
        if (r102 == true) goto L4;
    L6:
        if (r103 != null) goto L13;
        return;
    L13:
        r103.setRequestCellInfoResult(3);     // Catch: Exception -> L10
        r103.downLatch.countDown();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.e("requestCellInfoUpdate occur exception!", e);
        return;
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L6;
        final long r104 = System.currentTimeMillis();
        BDLocationExtrasService.getBPEAManager().requestCellInfoUpdate(r100, AppExecutors.getInstance().networkIO(), new AnonymousClass1(r104, r103, r101), r101);
    }

    public static List<CellInfo> getAllCellInfo(Context r100, TelephonyManager r101, Object r102, boolean r103, boolean r104, RefreshBaseStationInfo r105) {
        if (r104 == false) goto L6;
        return getAllCellInfoBeforeInit(r100, r101);
    L6:
        return getAllCellInfoAfterInit(r101, r102, r103, r105);
    }
}
