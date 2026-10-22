package yt;

import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569003a = 0;

    static {
    }

    public static String a(long r110) {
        Date r100 = new Date(r110);
        Date r111 = new Date();
        long r101 = (r111.getTime() - r100.getTime()) / ((long) BaseConstants.Time.HOUR);
        long r102 = (r111.getTime() - r100.getTime()) / ((long) 60000);
        Calendar r112 = Calendar.getInstance();
        r112.setTime(r100);
        int r103 = r112.get(5);
        boolean r104 = true;
        int r105 = r112.get(2) + 1;
        int r113 = r112.get(1);
        r112.setTime(r111);
        int r114 = r112.get(5);
        int r106 = r112.get(2) + 1;
        if (r113 != r112.get(1)) goto L5;
        boolean r115 = true;
    L6:
        if (r115 == false) goto L10;
        if (r105 != r106) goto L10;
        if (r103 != r114) goto L10;
    L12:
        if (r102 >= 1) goto L15;
        return "刚刚";
    L15:
        if (r101 < 1) goto L28;
        if (r104 == true) goto L19;
    L21:
        if (r104 == true) goto L30;
        if (r115 == false) goto L26;
        return new SimpleDateFormat("M月d日", Locale.getDefault()).format(r100);
    L26:
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(r100);
    L30:
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(r100);
    L19:
        if (r101 > 5) goto L21;
        return String.valueOf(r101) + "小时前";
    L28:
        return String.valueOf(r102) + "分钟前";
    L10:
        r104 = false;
        goto L12
    L5:
        r115 = false;
        goto L6
    }
}
