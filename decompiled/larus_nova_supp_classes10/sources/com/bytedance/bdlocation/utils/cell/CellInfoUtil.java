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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class CellInfoUtil {
    public CellInfoUtil() {
    }

    private static List<CellInfo> getAllCellInfoBeforeInit(Context r0, TelephonyManager r1) {
        return r1.getAllCellInfo();
    L4:
        Logger.e("getAllCellInfoBeforeInit#getAllCellInfo occur throwable !");
        return null;
    }

    public static List<CellInfo> getAllCellInfoAfterInit(TelephonyManager r4, Object r5, boolean r6, RefreshBaseStationInfo r7) {
        List<CellInfo> r1 = null;
        if (r4 != null) goto L14;
        return null;
    L14:
    L12:
        Logger.e("LocationInfoCollector#getAllCellInfo occur throwable !");
        return r1;
    L6:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L16;
        requestCellInfoUpdate(r4, r5, r6, r7);     // Catch: Throwable -> L12
        if (r7 == null) goto L10;
        return null;
    L10:
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L12
        r1 = BDLocationExtrasService.getBPEAManager().getAllCellInfo(r4, r5);     // Catch: Throwable -> L12
        Logger.i("getAllCellInfo duration:" + (System.currentTimeMillis() - r8));     // Catch: Throwable -> L12
        return r1;
    L16:
        return null;
    }

    public static CellLocation getCellLocation(Context r1, TelephonyManager r2, Object r3, boolean r4) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r4 == false) goto L8;
        return r2.getCellLocation();
    L8:
        if (PermissionManager.hasAnyPermission(r1, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L10;
        return null;
    L10:
        return BDLocationExtrasService.getBPEAManager().getCellLocation(r2, r3);
    }

    private static void requestCellInfoUpdate(TelephonyManager r4, final Object r5, boolean r6, final RefreshBaseStationInfo r7) {
        if (r6 == true) goto L4;
    L6:
        if (r7 != null) goto L13;
        return;
    L13:
        r7.setRequestCellInfoResult(3);     // Catch: Exception -> L10
        r7.downLatch.countDown();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Logger.e("requestCellInfoUpdate occur exception!", e);
        return;
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L6;
        final long r0 = System.currentTimeMillis();
        BDLocationExtrasService.getBPEAManager().requestCellInfoUpdate(r4, AppExecutors.getInstance().networkIO(), new AnonymousClass1(r0, r7, r5), r5);
    }

    public static List<CellInfo> getAllCellInfo(Context r0, TelephonyManager r1, Object r2, boolean r3, boolean r4, RefreshBaseStationInfo r5) {
        if (r4 == false) goto L6;
        return getAllCellInfoBeforeInit(r0, r1);
    L6:
        return getAllCellInfoAfterInit(r1, r2, r3, r5);
    }
}
