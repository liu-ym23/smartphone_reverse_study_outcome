package com.bytedance.bdlocation.bytelocation;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import pr3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class ByteLocationImpl$ByteListener implements b {
    private BDLocationCallback mCallback;
    private Handler mHandler;
    private long mLocationStartTime;
    private LocationOption mOption;
    final /* synthetic */ ByteLocationImpl this$0;

    public static /* synthetic */ BDLocationCallback access$200(ByteLocationImpl$ByteListener r0) {
        return r0.mCallback;
    }

    public static /* synthetic */ LocationOption access$300(ByteLocationImpl$ByteListener r0) {
        return r0.mOption;
    }

    public static /* synthetic */ long access$400(ByteLocationImpl$ByteListener r2) {
        return r2.mLocationStartTime;
    }

    public void onError(BDLocationException r17) {
        if (this.mOption.isOnceLocation() == false) goto L5;
        LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, r17.getCode(), r17.getDetailMessage(), null, this.mOption.isChineseRegion(), 0, this.mOption.isBackground());
    L6:
        Logger.i("ByteLocationImpl: ByteListener onError() and the message is " + r17.getMessage());
        this.mCallback.onError(r17);
        return;
    L5:
        LocationMonitor.doContinueLocation(this.this$0.getLocateName(), r17.getCode(), r17.getDetailMessage(), this.mOption.isChineseRegion(), 0, "", SystemClock.elapsedRealtime() - ByteLocationImpl.access$000(this.this$0), ByteLocationImpl.access$100(this.this$0), this.mOption.getUploadSource(), null);
        ByteLocationImpl.access$002(this.this$0, SystemClock.elapsedRealtime());
        ByteLocationImpl.access$102(this.this$0, false);
        goto L6
    }

    public void onLocationChanged(final BDLocation r18) {
        Logger.i("ByteLocationImpl: ByteListener onLocationChanged() is executed ");
        Handler r2 = this.mHandler;
        if (r2 == null) goto L8;
        if (r18 == null) goto L8;
        r2.post(new AnonymousClass1(this, r18));
        return;
    L8:
        BDLocationException r1 = new BDLocationException(BDLocationExceptionMessage.BYTE_LOCATION_ERROR, LocationInfoConst.BYTE, BDLocationException.ERROR_BYTE_FAIL);
        if (this.mOption.isOnceLocation() == false) goto L11;
        LocationMonitor.locationTraceLogEnd(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        LocationMonitor.doDesiredLocationDuration(this.this$0.getLocateName(), SystemClock.elapsedRealtime() - this.mLocationStartTime, BDLocationException.ERROR_BYTE_FAIL, BDLocationExceptionMessage.BYTE_LOCATION_ERROR, null, this.mOption.isChineseRegion(), 0, this.mOption.isBackground());
    L12:
        this.mCallback.onError(r1);
        return;
    L11:
        long r12 = SystemClock.elapsedRealtime() - ByteLocationImpl.access$000(this.this$0);
        LocationMonitor.doContinueLocation(this.this$0.getLocateName(), r1.getCode(), r1.getDetailMessage(), this.mOption.isChineseRegion(), 0, "", r12, ByteLocationImpl.access$100(this.this$0), this.mOption.getUploadSource(), null);
        ByteLocationImpl.access$002(this.this$0, SystemClock.elapsedRealtime());
        ByteLocationImpl.access$102(this.this$0, false);
        goto L12
    }

    public ByteLocationImpl$ByteListener(ByteLocationImpl r1, Handler r2, BDLocationCallback r3, LocationOption r4) {
        this.this$0 = r1;
        this.mHandler = r2;
        this.mCallback = r3;
        this.mOption = r4;
        this.mLocationStartTime = SystemClock.elapsedRealtime();
        LocationMonitor.locationTraceLogBegin(this.mOption.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
    }
}
