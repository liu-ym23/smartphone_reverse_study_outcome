package h58;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.audio.ainotes.notification.AiNoteService;
import com.larus.audio.e0;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AiNoteService f483884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f483885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f483886c;

    static {
    }

    public static Notification a(Context r110, String r111) {
        int r100 = e0.f289663a;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r110.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r101 = true;
    L6:
        String r102 = r110.getPackageName();
        if (e0.a() == true) goto L23;
        String r103 = Build.MANUFACTURER;
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L20;
        if (DeviceUtils.isVivo() == true) goto L20;
        if (DeviceUtils.isOppo() == true) goto L20;
    L22:
        boolean r105 = false;
    L24:
        if (r105 == false) goto L28;
        if (r101 == false) goto L27;
        int r106 = R.layout.larus_layout_ainote_notification_dark_with_margin;
    L31:
        RemoteViews r107 = new RemoteViews(r102, r106);
        int r108 = Build.VERSION.SDK_INT;
        if (r108 >= 31) goto L34;
    L36:
        if (r108 >= 31) goto L38;
    L40:
        AppHost.Companion r112 = AppHost.f326268a;
        r107.setTextViewText(R.id.name, r112.getApplication().getString(R.string.larus_memo_record_push_recording_title));
        r107.setTextViewText(R.id.title, r112.getApplication().getString(R.string.larus_memo_record_push_recording_subtitle));
        r107.setImageViewResource(R.id.photo, R.drawable.larus_avatar_gif);
        String r109 = r110.getPackageName();
        String r113 = Build.MANUFACTURER;
        if (r113 != null) goto L43;
    L45:
        boolean r114 = false;
    L46:
        if (r114 == false) goto L48;
    L51:
        if (r108 >= 31) goto L53;
        boolean r115 = true;
    L54:
        if (r115 == false) goto L58;
        if (r101 == false) goto L57;
        int r116 = R.layout.larus_layout_ainote_notification_dark_with_margin;
    L61:
        RemoteViews r117 = new RemoteViews(r109, r116);
        r117.setTextViewText(R.id.name, r112.getApplication().getString(R.string.larus_memo_record_push_recording_title));
        r117.setTextViewText(R.id.title, r112.getApplication().getString(R.string.larus_memo_record_push_recording_subtitle));
        r117.setImageViewResource(R.id.photo, R.drawable.larus_avatar_gif);
        String r118 = "sslocal://flow/chat?is_from_outer=true&open_method=outer&bot_id=" + r111;
        Intent r119 = r112.getApplication().getPackageManager().getLaunchIntentForPackage(r112.getApplication().getPackageName());
        if (r119 != null) goto L64;
        r119 = new Intent();
    L64:
        r119.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r119.setPackage(r112.getApplication().getPackageName());
        r119.setData(UriProtector.parse(r118).buildUpon().build());
        r119.setFlags(268468224);
        if (r108 < 23) goto L67;
        int r120 = 201326592;
    L68:
        PendingIntent r121 = PendingIntent.getActivity(r110, 0, r119, r120);
        NotificationCompat.Builder r122 = new NotificationCompat.Builder(r110, "ai_note_channel");
        if (r101 == false) goto L71;
        int r123 = R.drawable.larus_ic_phone_fill_dark;
    L72:
        NotificationCompat.Builder r124 = r122.setSmallIcon(r123).setShowWhen(false).setSound(null).setVibrate(null).setContentTitle(r112.getApplication().getString(R.string.larus_memo_record_push_recording_title)).setContentText(r112.getApplication().getString(R.string.larus_memo_record_push_recording_subtitle)).setAutoCancel(false).setOngoing(false).setPriority(1).setContentIntent(r121).setVisibility(1);
        if (e0.a() == true) goto L90;
        if (r113 != null) goto L76;
    L78:
        boolean r125 = false;
    L79:
        if (r125 == true) goto L90;
        if (DeviceUtils.isHuawei() == true) goto L90;
        if (DeviceUtils.isOppo() == true) goto L90;
        if (DeviceUtils.isVivo() == true) goto L90;
        if (DeviceUtils.isFlyme() == true) goto L90;
        boolean r126 = false;
    L91:
        if (r126 == false) goto L100;
        r124.setCustomContentView(r107);
        r124.setCustomBigContentView(r117);
        int r127 = j0.f375426a;
        if (r101 == false) goto L95;
        int r128 = R.color.larus_rtc_notification_bg_dark;
    L96:
        r124.setColor(j0.a(r128));
        if (r108 < 26) goto L100;
        r124.setColorized(true);
        goto L100
    L95:
        r128 = R.color.larus_rtc_notification_bg_light;
    L100:
        return r124.build();
    L76:
        if (StringsKt.equals(r113, "OnePlus", true) == false) goto L78;
        r125 = true;
    L90:
        r126 = true;
        goto L91
    L71:
        r123 = R.drawable.larus_ic_phone_fill_light;
        goto L72
    L67:
        r120 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L68
    L57:
        r116 = R.layout.larus_layout_ainote_notification_with_margin;
        goto L61
    L58:
        if (r101 == false) goto L60;
        r116 = R.layout.larus_layout_ainote_notification_dark;
        goto L61
    L60:
        r116 = R.layout.larus_layout_ainote_notification;
    L53:
        r115 = false;
        goto L54
    L48:
        if (DeviceUtils.isOppo() == true) goto L51;
        if (DeviceUtils.isVivo() == false) goto L53;
    L43:
        if (StringsKt.equals(r113, "OnePlus", true) == false) goto L45;
        r114 = true;
        goto L46
    L38:
        if (DeviceUtils.isVivo() == false) goto L40;
        r107.setViewVisibility(R.id.large_icon, 8);
        goto L40
    L34:
        if (e0.a() == false) goto L36;
        r107.setViewLayoutMargin(R.id.photo, 4, 0.0f, 1);
        goto L36
    L27:
        r106 = R.layout.larus_layout_ainote_notification_with_margin;
        goto L31
    L28:
        if (r101 == false) goto L30;
        r106 = R.layout.larus_layout_ainote_notification_dark;
        goto L31
    L30:
        r106 = R.layout.larus_layout_ainote_notification;
    L20:
        if (Build.VERSION.SDK_INT >= 31) goto L22;
    L11:
        if (StringsKt.equals(r103, "OnePlus", true) == false) goto L13;
        r104 = true;
    L23:
        r105 = true;
        goto L24
    L5:
        r101 = false;
        goto L6
    }

    public static void b(String r100, String r101) {
        if (f483884a != null) goto L6;
        f483885b = new a(r100, r101);
        return;
    L6:
        if (f483886c == true) goto L30;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 34) goto L12;
        AiNoteService r103 = f483884a;     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        r103.startForeground(104, a(AppHost.f326268a.getApplication(), r100), 128);     // Catch: Throwable -> L18
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L20:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L24;
        FLogger.f375446a.e("AiNoteServiceManager", "showForegroundNotification failed, " + r106.getMessage());
    L24:
        if (Result.m9456isSuccessimpl(r105) == false) goto L31;
        Unit r107 = (Unit) r105;
        f483886c = true;
        return;
    L31:
        return;
    L15:
        r104 = null;
        goto L16
    L12:
        AiNoteService r108 = f483884a;     // Catch: Throwable -> L18
        if (r108 == null) goto L15;
        r108.startForeground(104, a(AppHost.f326268a.getApplication(), r100));     // Catch: Throwable -> L18
        r104 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
