package zu5;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static String c() {
        return TimeZone.getDefault().getID();
    }

    public static String a(TimeZone r100) {
        int r101 = r100.getOffset(GregorianCalendar.getInstance(r100).getTimeInMillis());
        if (r101 != 0) goto L5;
        return "GMT";
    L5:
        int r102 = Math.abs(r101 / BaseConstants.Time.HOUR);
        int r103 = Math.abs((r101 / 60000) % 60);
        StringBuilder r104 = new StringBuilder();
        r104.append(r102);
        if (r103 <= 0) goto L8;
        String r105 = ":" + r103;
    L9:
        r104.append(r105);
        String r106 = r104.toString();
        StringBuilder r107 = new StringBuilder("GMT");
        if (r101 <= 0) goto L12;
        String r108 = Marker.ANY_NON_NULL_MARKER;
    L13:
        r107.append(r108);
        r107.append(r106);
        return r107.toString();
    L12:
        r108 = "-";
        goto L13
    L8:
        r105 = "";
        goto L9
    }

    public static String b(TimeZone r100) {
        int r101 = r100.getOffset(GregorianCalendar.getInstance(r100).getTimeInMillis());
        String r102 = String.format("%02d:%02d", new Object[]{Integer.valueOf(Math.abs(r101 / BaseConstants.Time.HOUR)), Integer.valueOf(Math.abs((r101 / 60000) % 60))});
        StringBuilder r103 = new StringBuilder("GMT");
        if (r101 < 0) goto L5;
        String r104 = Marker.ANY_NON_NULL_MARKER;
    L6:
        r103.append(r104);
        r103.append(r102);
        return r103.toString();
    L5:
        r104 = "-";
        goto L6
    }

    public static String d(int r100) {
        int r101 = r100 / 1000;
        if (r101 < 3600) goto L7;
        return String.format("%d:%02d:%02d", new Object[]{Integer.valueOf(r101 / AnnouncementViewModel.HOUR_DURATION), Integer.valueOf((r101 % AnnouncementViewModel.HOUR_DURATION) / 60), Integer.valueOf(r101 % 60)});
    L7:
        return String.format("%02d:%02d", new Object[]{Integer.valueOf(r101 / 60), Integer.valueOf(r101 % 60)});
    }
}
