package hn1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.ITTNetNQEConfigHelper;
import com.bytedance.android.livesdk.config.ip0;
import com.bytedance.android.livesdk.config.zj1;
import jc1.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zj1 f486080a = null;

    static {
        f486080a = ip0.f120471a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        IMiddlewareHostApp r100 = (IMiddlewareHostApp) k.f(IMiddlewareHostApp.class);
        if (r100 == null) goto L7;
        ITTNetNQEConfigHelper r101 = r100.getTTNetNQEConfigHelper();
        if (r101 == null) goto L7;
        Integer r102 = Integer.valueOf(r101.getEffectiveConnectionType());
    L8:
        ALogger.i("LiveRoomReEnterUtils", "effectiveConnectionType = " + r102);
        if (r102 != null) goto L12;
    L13:
        if (r102 != null) goto L16;
    L17:
        if (r102 != null) goto L20;
    L21:
        if (r102 != null) goto L24;
    L26:
        return false;
    L24:
        if (r102.intValue() != 3) goto L26;
        return true;
    L20:
        if (r102.intValue() != 2) goto L21;
        return true;
    L16:
        if (r102.intValue() != 1) goto L17;
        return true;
    L12:
        if (r102.intValue() != (-1)) goto L13;
        return true;
    L7:
        r102 = null;
        goto L8
    }
}
