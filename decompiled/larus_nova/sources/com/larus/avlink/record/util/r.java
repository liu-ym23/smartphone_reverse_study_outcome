package com.larus.avlink.record.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes25.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Calendar f294435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Calendar f294436b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f294437c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f294438d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f294439e = null;

    static {
        f294435a = Calendar.getInstance();
        f294436b = Calendar.getInstance();
        f294437c = new SimpleDateFormat("H:mm", Locale.getDefault());
        StringBuilder r100 = new StringBuilder("M");
        AppHost.Companion r101 = AppHost.f326268a;
        r100.append(r101.getApplication().getString(R.string.larus_message_time_month));
        r100.append(Directory.UNIX_ID);
        r100.append(r101.getApplication().getString(R.string.larus_message_time_day));
        r100.append(" H:mm");
        f294438d = new SimpleDateFormat(r100.toString(), Locale.getDefault());
        f294439e = new SimpleDateFormat("yyyy" + r101.getApplication().getString(R.string.larus_message_time_year) + 'M' + r101.getApplication().getString(R.string.larus_message_time_month) + Directory.UNIX_ID + r101.getApplication().getString(R.string.larus_message_time_day) + " H:mm", Locale.getDefault());
    }

    public static boolean a() {
        Calendar r100 = f294435a;
        int r101 = r100.get(0);
        Calendar r102 = f294436b;
        if (r101 == r102.get(0)) goto L5;
        return false;
    L5:
        if (r100.get(1) == r102.get(1)) goto L7;
        return false;
    L7:
        if (r100.get(6) != r102.get(6)) goto L12;
        return true;
    L12:
        return false;
    }
}
