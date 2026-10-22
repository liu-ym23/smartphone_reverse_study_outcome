package ia8;

import android.app.Application;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.j0;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f488936a = 0;

    static {
    }

    public static String a(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r101.get(5))}, 1));
    }

    public static String b(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        Calendar r102 = Calendar.getInstance();
        Application r103 = AppHost.f326268a.getApplication();
        if (r101.get(1) == r102.get(1)) goto L5;
    L8:
        Calendar r104 = Calendar.getInstance();
        r104.add(6, -1);
        if (r101.get(1) == r104.get(1)) goto L11;
    L14:
        String r105 = r103.getString(R.string.larus_dora_general_date_year_cn);
        String r106 = r103.getString(R.string.larus_dora_general_date_month_cn);
        String r107 = r103.getString(R.string.larus_dora_general_date_day_cn);
        if (r101.get(1) == r102.get(1)) goto L19;
        return new SimpleDateFormat("yyyy" + r105 + "MM" + r106 + "dd" + r107, Locale.CHINESE).format(r101.getTime());
    L19:
        return new SimpleDateFormat("MM" + r106 + "dd" + r107, Locale.CHINESE).format(r101.getTime());
    L11:
        if (r101.get(6) != r104.get(6)) goto L14;
        return r103.getString(R.string.larus_dora_general_date_yesterday_cn);
    L5:
        if (r101.get(6) != r102.get(6)) goto L8;
        return r103.getString(R.string.larus_dora_general_date_today_cn);
    }

    public static String c(long r100) {
        if (r100 != 0) goto L6;
        return "";
    L6:
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(r101.getTime());
    }

    public static String d(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        Calendar r102 = Calendar.getInstance();
        if (r101.get(1) == r102.get(1)) goto L5;
    L7:
        boolean r103 = false;
    L8:
        Integer[] r104 = {Integer.valueOf(R.string.larus_message_time_sunday), Integer.valueOf(R.string.larus_message_time_monday), Integer.valueOf(R.string.larus_message_time_tuesday), Integer.valueOf(R.string.larus_message_time_wednesday), Integer.valueOf(R.string.larus_message_time_thursday), Integer.valueOf(R.string.larus_message_time_friday), Integer.valueOf(R.string.larus_message_time_saturday)};
        int r105 = r101.get(7) - 1;
        int r106 = j0.f375426a;
        if (r105 >= 0) goto L11;
        Integer r107 = r104[0];
    L12:
        String r108 = j0.d(r107.intValue());
        if (r103 == true) goto L15;
        return r108;
    L15:
        return "今日 " + r108;
    L11:
        r107 = r104[r105];
        goto L12
    L5:
        if (r101.get(6) != r102.get(6)) goto L7;
        r103 = true;
        goto L8
    }

    public static String e(long r100) {
        Calendar r101 = Calendar.getInstance();
        r101.setTimeInMillis(r100);
        int r102 = r101.get(1);
        int r103 = r101.get(2) + 1;
        StringBuilder r104 = new StringBuilder();
        r104.append(r102);
        r104.append(24180);
        r104.append(r103);
        r104.append(26376);
        return r104.toString();
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = CastLongProtector.parseLong(r100);
        Calendar r102 = Calendar.getInstance();
        r102.setTimeInMillis(r101);
        Calendar r103 = Calendar.getInstance();
        if (r102.get(1) == r103.get(1)) goto L8;
        return false;
    L8:
        if (r102.get(6) != r103.get(6)) goto L12;
        return true;
    L12:
        return false;
    }
}
