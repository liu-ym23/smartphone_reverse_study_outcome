package v19;

import android.app.Application;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f552450a = 0;

    static {
    }

    public static String a(long r110) {
        long r100 = System.currentTimeMillis() / 1000;
        Application r101 = AppHost.f326268a.getApplication();
        long r102 = RangesKt.coerceAtLeast(r100 - r110, 60);
        if (r102 >= 120) goto L6;
        String r103 = r101.getString(R.string.larus_botsComment_commentTime_label_justNow);
        Intrinsics.checkNotNull(r103);
        return r103;
    L6:
        if (r102 >= TimeUtils.SECONDS_PER_HOUR) goto L9;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        return String.format(r101.getString(R.string.larus_notification_time_minutes), Arrays.copyOf(new Object[]{Long.valueOf(r102 / ((long) 60))}, 1));
    L9:
        if (r102 >= 86400) goto L12;
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        return String.format(r101.getString(R.string.larus_notification_time_hours), Arrays.copyOf(new Object[]{Long.valueOf(r102 / ((long) AnnouncementViewModel.HOUR_DURATION))}, 1));
    L12:
        if (r102 >= 604800) goto L14;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        return String.format(r101.getString(R.string.larus_notification_time_days), Arrays.copyOf(new Object[]{Long.valueOf(r102 / ((long) 86400))}, 1));
    L14:
        Calendar r107 = Calendar.getInstance();
        r107.set(r107.get(1), 0, 1, 0, 0, 0);
        r107.set(14, 0);
        if (r110 < (r107.getTimeInMillis() / 1000)) goto L17;
        Calendar r108 = Calendar.getInstance();
        r108.setTimeInMillis(r110 * 1000);
        String r109 = String.valueOf(r108.get(2) + 1);
        return StringsKt.replace$default(StringsKt.replace$default(r101.getString(R.string.larus_notification_time_mmdd), "%d_month", r109, false, 4, null), "%d_day", String.valueOf(r108.get(5)), false, 4, null);
    L17:
        Calendar r111 = Calendar.getInstance();
        r111.setTimeInMillis(r110 * 1000);
        String r112 = String.valueOf(r111.get(2) + 1);
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r101.getString(R.string.larus_notification_time_yymmdd), "%d_year", String.valueOf(r111.get(1)), false, 4, null), "%d_month", r112, false, 4, null), "%d_day", String.valueOf(r111.get(5)), false, 4, null);
    }
}
