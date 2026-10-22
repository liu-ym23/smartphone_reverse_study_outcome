package com.bytedance.helios.common.utils;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.jvm.internal.StringCompanionObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245398a = 0;

    static {
    }

    public static String a(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        int r102 = r101.get(15) / BaseConstants.Time.HOUR;
        if (r102 < 0) goto L5;
        String r103 = Marker.ANY_NON_NULL_MARKER + r102;
    L6:
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        return String.format("%d-%02d-%02d %02d:%02d:%02d.%03d GMT%s", Arrays.copyOf(new Object[]{Integer.valueOf(r101.get(1)), Integer.valueOf(r101.get(2) + 1), Integer.valueOf(r101.get(5)), Integer.valueOf(r101.get(11)), Integer.valueOf(r101.get(12)), Integer.valueOf(r101.get(13)), Integer.valueOf(r101.get(14)), r103}, 8));
    L5:
        r103 = String.valueOf(r102);
        goto L6
    }
}
