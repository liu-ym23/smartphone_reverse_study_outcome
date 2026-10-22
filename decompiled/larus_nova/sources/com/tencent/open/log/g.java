package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f461819a = null;

    public g() {
    }

    public final String a(int r100) {
        if (r100 != 1) goto L5;
        return "V";
    L5:
        if (r100 != 2) goto L7;
        return "D";
    L7:
        if (r100 != 4) goto L9;
        return "I";
    L9:
        if (r100 != 8) goto L11;
        return ExifInterface.LONGITUDE_WEST;
    L11:
        if (r100 != 16) goto L13;
        return ExifInterface.LONGITUDE_EAST;
    L13:
        if (r100 == 32) goto L16;
        return "-";
    L16:
        return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    }

    static {
        f461819a = new g();
    }

    public String a(int r100, Thread r101, long r102, String r103, String r110, Throwable r111) {
        long r104 = r102 % 1000;
        Time r105 = new Time();
        r105.set(r102);
        StringBuilder r106 = new StringBuilder();
        r106.append(a(r100));
        r106.append('/');
        r106.append(r105.format("%Y-%m-%d %H:%M:%S"));
        r106.append('.');
        if (r104 >= 10) goto L6;
        r106.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
    L8:
        r106.append(r104);
        r106.append(" [");
        if (r101 != null) goto L11;
        r106.append("N/A");
    L12:
        r106.append("][");
        r106.append(r103);
        r106.append("] ");
        r106.append(r110);
        r106.append('\n');
        if (r111 == null) goto L16;
        r106.append("* Exception : \n");
        r106.append(Log.getStackTraceString(r111));
        r106.append('\n');
    L16:
        return r106.toString();
    L11:
        r106.append(r101.getName());
        goto L12
    L6:
        if (r104 >= 100) goto L8;
        r106.append('0');
        goto L8
    }
}
