package com.bytedance.bdlocation.continuous;

import com.bytedance.bdlocation.bridge.LocationConfig;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\r\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionLocationUtils;", "", "()V", "buildLocationConfig", "Lcom/bytedance/bdlocation/bridge/LocationConfig;", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "navInstanceId", "", "newException", "Lcom/bytedance/bdlocation/exception/BDLocationException;", "message", "code", "resolveNavInstanceId", "config", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationConfig;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionLocationUtils {
    public static final ByteFusionLocationUtils INSTANCE = null;

    private ByteFusionLocationUtils() {
    }

    static {
        INSTANCE = new ByteFusionLocationUtils();
    }

    public final LocationConfig buildLocationConfig(LocationOption r100, String r101) {
        if (r100 == null) goto L5;
        int r102 = r100.getFusionLocationWorkMode();
    L6:
        if (r100 == null) goto L8;
        int r103 = r100.getFusionLocationUserMotionMode();
    L10:
        return new LocationConfig(r102, r103, BDLocationConfig.isFusionLocationTrackUploadEnabled(), BDLocationConfig.getFusionLocationTrackIntervalSec(), r101);
    L8:
        r103 = 2;
        goto L10
    L5:
        r102 = 1;
        goto L6
    }

    public final BDLocationException newException(String r100, String r101) {
        return new BDLocationException(r100, LocationInfoConst.BYTE_FUSION_CONTINUOUS, r101);
    }

    public final String resolveNavInstanceId(LocationOption r100, ByteFusionContinuousLocationConfig r101) {
        if (r100 == null) goto L4;
        String r102 = r100.getBusinessId();
    L5:
        boolean r103 = false;
        if (r102 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        return r102;
    L15:
        if (r101.getNavInstanceId().length() <= 0) goto L17;
        r103 = true;
    L17:
        if (r103 == true) goto L19;
        return ByteFusionContinuousLocationConfig.DEFAULT_NAV_INSTANCE_ID;
    L19:
        return r101.getNavInstanceId();
    L8:
        if (r102.length() == 0) goto L11;
        r104 = false;
        goto L12
    L4:
        r102 = null;
        goto L5
    }
}
