package v53;

import android.content.Context;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.ttm.player.MediaPlayer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import m53.c;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f553245a = 0;

    static {
    }

    public static int b(Date r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Calendar r101 = Calendar.getInstance();
        r101.setTime(r100);
        return r101.get(5);
    }

    public static int c(Date r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Calendar r101 = Calendar.getInstance();
        r101.setTime(r100);
        return r101.get(2) + 1;
    }

    public static int d(Date r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Calendar r101 = Calendar.getInstance();
        r101.setTime(r100);
        return r101.get(1);
    }

    public static String a(Context r110, String r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, VideoSurfaceTexture.KEY_TIME);
        SimpleDateFormat r100 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());     // Catch: ParseException -> L44
        r100.setTimeZone(TimeZone.getTimeZone("GMT+8"));     // Catch: ParseException -> L44
        long r101 = r100.parse(r210).getTime();     // Catch: ParseException -> L44
        long r102 = Calendar.getInstance().getTimeInMillis() - r101;     // Catch: ParseException -> L44
        Calendar r103 = Calendar.getInstance();     // Catch: ParseException -> L44
        r103.set(11, 0);     // Catch: ParseException -> L44
        r103.set(12, 0);     // Catch: ParseException -> L44
        r103.set(13, 0);     // Catch: ParseException -> L44
        int r104 = b(new Date(r101));     // Catch: ParseException -> L44
        int r105 = b(new Date(System.currentTimeMillis()));     // Catch: ParseException -> L44
        int r106 = c(new Date(r101));     // Catch: ParseException -> L44
        int r111 = c(new Date(System.currentTimeMillis()));     // Catch: ParseException -> L44
        int r112 = d(new Date(r101));     // Catch: ParseException -> L44
        int r113 = d(new Date(System.currentTimeMillis()));     // Catch: ParseException -> L44
        long r114 = r102 / 86400000;     // Catch: ParseException -> L44
        if (r104 == r105) goto L6;
    L8:
        long r107 = 30;
        if (1 > r114) goto L15;
        if (r107 <= r114) goto L15;
        int r115 = r105;
    L18:
        if (r112 < r113) goto L22;
        if (r106 < r111) goto L22;
        int r108 = r115 - r104;     // Catch: ParseException -> L44
    L23:
        int r109 = g1.f45599a;     // Catch: ParseException -> L44
        if (c.a() == false) goto L26;
        int r116 = R.string.commerce_anchor_v3_comment_time_new;
    L48:
        return g1.a.c(r110, r116, new Object[]{Integer.valueOf(r108)});
    L26:
        r116 = R.string.commerce_anchor_v3_comment_time;
    L22:
        int r117 = d(new Date(r101));     // Catch: ParseException -> L44
        Calendar r118 = Calendar.getInstance();     // Catch: ParseException -> L44
        r118.set(1, r117);     // Catch: ParseException -> L44
        r118.set(2, r106 - 1);     // Catch: ParseException -> L44
        r118.set(5, 1);     // Catch: ParseException -> L44
        r118.roll(5, -1);     // Catch: ParseException -> L44
        r108 = (r118.get(5) - r104) + r115;     // Catch: ParseException -> L44
    L15:
        if (r114 >= 1) goto L28;
        r115 = r105;
        if (r104 != r115) goto L18;
    L28:
        long r119 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME;
        if (r107 <= r114) goto L32;
    L38:
        int r120 = g1.f45599a;     // Catch: ParseException -> L44
        if (c.a() == false) goto L41;
        int r121 = R.string.commerce_anchor_v3_comment_tim_year_new;
    L50:
        return g1.a.c(r110, r121, new Object[]{1});
    L41:
        r121 = R.string.commerce_anchor_v3_comment_tim_year;
        goto L50
    L32:
        if (r119 <= r114) goto L38;
        int r122 = MathKt.roundToInt((r102 * 1.0f) / 2592000000L);     // Catch: ParseException -> L44
        int r123 = g1.f45599a;     // Catch: ParseException -> L44
        if (c.a() == false) goto L36;
        int r124 = R.string.commerce_anchor_v3_comment_tim_month_new;
    L49:
        return g1.a.c(r110, r124, new Object[]{Integer.valueOf(r122)});
    L36:
        r124 = R.string.commerce_anchor_v3_comment_tim_month;
        goto L49
    L6:
        if (r101 < r103.getTimeInMillis()) goto L8;
        int r125 = g1.f45599a;     // Catch: ParseException -> L44
        return g1.a.c(r110, R.string.commerce_anchor_v3_comment_time_today, new Object[0]);
    L44:
        return "";
    }
}
