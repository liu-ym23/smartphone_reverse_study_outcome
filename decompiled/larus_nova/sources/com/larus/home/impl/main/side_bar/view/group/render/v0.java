package com.larus.home.impl.main.side_bar.view.group.render;

import android.text.format.DateFormat;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f345723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f345724b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f345725c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f345726d = 0;

    public v0() {
    }

    static {
        f345723a = new v0();
        f345724b = R.string.larus_LarkIM_Common_Today_Text;
        f345725c = R.string.larus_LarkIM_Common_Yesterday_Text;
        f345726d = R.string.larus_cc_edit_session_searchResults_earlier;
    }

    public static String a(a r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "locale");
        String r102 = DateFormat.getBestDateTimePattern(r101, "MMMd");
        TimeZone r103 = TimeZone.getDefault();
        SimpleDateFormat r104 = new SimpleDateFormat(r102, r101);
        r104.setTimeZone(r103);
        Intrinsics.checkNotNull(r103);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, TimeZoneItemV2.TIME_ZONE);
        Intrinsics.checkNotNullParameter(r103, TimeZoneItemV2.TIME_ZONE);
        Calendar r105 = Calendar.getInstance(r103);
        r105.clear();
        r105.set(r100.f345603a, r100.f345604b, r100.f345605c);
        return r104.format(new Date(r105.getTimeInMillis()));
    }
}
