package oc;

import android.util.Log;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522675a = 0;

    static {
    }

    public static String a(Throwable r100) {
        String r101 = Log.getStackTraceString(r100);
        int r102 = RangesKt.coerceAtMost(r101.length(), BtmSetting.f42469d.c().c().d());
        if (r102 > 0) goto L5;
        return "";
    L5:
        return r101.substring(0, r102);
    }
}
