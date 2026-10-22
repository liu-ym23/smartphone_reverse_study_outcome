package com.larus.drive.sdk.impl.utils;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes27.dex */
public final class m {
    static {
    }

    public static String a(long r110) {
        if (r110 <= ((System.currentTimeMillis() / 1000) * ((long) 10))) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        Date r101 = new Date(r110);
    L9:
        Calendar r111 = Calendar.getInstance();
        Calendar r112 = Calendar.getInstance();
        r112.setTime(r101);
        int r102 = r111.get(1);
        int r103 = r111.get(2) + 1;
        int r104 = r111.get(5);
        int r105 = r112.get(1);
        int r106 = r112.get(2) + 1;
        int r107 = r112.get(5);
        if (r102 != r105) goto L14;
        if (r103 != r106) goto L14;
        if (r104 != r107) goto L14;
        boolean r108 = true;
    L15:
        Calendar r109 = Calendar.getInstance();
        r109.setTime(r111.getTime());
        r109.add(6, -1);
        if (r109.get(1) == r105) goto L18;
    L20:
        boolean r113 = false;
    L21:
        SimpleDateFormat r114 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        if (r108 == false) goto L25;
        return String.valueOf(r114.format(r101));
    L25:
        if (r113 == true) goto L32;
        if (r102 != r105) goto L29;
        StringBuilder r115 = new StringBuilder();
        StringCompanionObject r116 = StringCompanionObject.INSTANCE;
        r115.append(String.format(AppHost.f326268a.getApplication().getString(R.string.larus_aiDoc_history_timestamp), Arrays.copyOf(new Object[]{Integer.valueOf(r106), Integer.valueOf(r107)}, 2)));
        r115.append(' ');
        r115.append(r114.format(r101));
        return r115.toString();
    L29:
        StringBuilder r117 = new StringBuilder();
        StringCompanionObject r118 = StringCompanionObject.INSTANCE;
        r117.append(String.format(AppHost.f326268a.getApplication().getString(R.string.larus_aiDoc_history_timestampYear), Arrays.copyOf(new Object[]{Integer.valueOf(r105), Integer.valueOf(r106), Integer.valueOf(r107)}, 3)));
        r117.append(' ');
        r117.append(r114.format(r101));
        return r117.toString();
    L32:
        return AppHost.f326268a.getApplication().getString(R.string.larus_drive_file_time_yesterday) + ' ' + r114.format(r101);
    L18:
        if (r109.get(6) != r112.get(6)) goto L20;
        r113 = true;
    L14:
        r108 = false;
        goto L15
    L8:
        r101 = new Date(r110 * 1000);
        goto L9
    L5:
        r100 = false;
        goto L6
    }
}
