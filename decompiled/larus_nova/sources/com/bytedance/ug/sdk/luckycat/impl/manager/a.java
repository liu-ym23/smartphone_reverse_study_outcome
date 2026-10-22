package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ug.sdk.luckycat.impl.manager.a$a, reason: collision with other inner class name */
    public class RunnableC3802a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f271286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ug.sdk.luckycat.impl.model.b f271287b;

        @Override // java.lang.Runnable
        public final void run() {
            g r100 = this.f271286a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f271287b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC3802a(g r100, com.bytedance.ug.sdk.luckycat.impl.model.b r101) {
            this.f271286a = r100;
            this.f271287b = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f271288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ug.sdk.luckycat.impl.model.a f271289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f271290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f271291d;

        public final void a() {
            a r100 = this.f271291d;
            Context r101 = this.f271288a.getApplicationContext();
            com.bytedance.ug.sdk.luckycat.impl.model.a r102 = this.f271289b;
            r100.getClass();
            if (r101 != null) goto L5;
        L64:
            com.bytedance.ug.sdk.luckycat.impl.model.b r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-1, "msg_param_error");
        L65:
            a r104 = this.f271291d;
            g r105 = this.f271290c;
            r104.getClass();
            a.f(r103, r105);
            a.g("add", true);
            return;
        L5:
            if (TextUtils.isEmpty(r102.f271385a) == true) goto L64;
            if (r102.f271387c < 0) goto L64;
            int r106 = a.a(r101);
            if (r106 >= 0) goto L25;
            TimeZone r107 = TimeZone.getDefault();
            ContentValues r110 = new ContentValues();
            r110.put("name", "luckycatCalendar");
            r110.put("account_name", "luckycat@bytedance.com");
            r110.put("account_type", "com.bytedance.ug.sdk.luckycat");
            r110.put("calendar_displayName", "");
            r110.put("visible", 1);
            r110.put("calendar_color", Integer.valueOf(FakePickerAvatarCreator.BLUE));
            r110.put("calendar_access_level", 700);
            r110.put("sync_events", 1);
            r110.put("calendar_timezone", r107.getID());
            r110.put("ownerAccount", "luckycat@bytedance.com");
            r110.put("canOrganizerRespond", 0);
            Uri r108 = a.c(r101.getContentResolver(), UriProtector.parse("content://com.android.calendar/calendars").buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "luckycat@bytedance.com").appendQueryParameter("account_type", "com.bytedance.ug.sdk.luckycat").build(), r110);     // Catch: Throwable -> L18
            if (r108 == null) goto L20;
            long r109 = ContentUris.parseId(r108);     // Catch: Throwable -> L18
        L22:
            if (r109 < 0) goto L24;
            r106 = a.a(r101);
            goto L25
        L24:
            r106 = -1;
        L20:
            r109 = -1;
        L18:
            th = move-exception;
            th.getMessage();
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
        L25:
            if (r106 >= 0) goto L28;
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-2, "msg_calendar_account_error");
            goto L65
        L28:
            if (r102.f271392h == false) goto L30;
        L67:
            long r111 = System.currentTimeMillis();     // Catch: Throwable -> L59
            long r112 = r102.f271390f;     // Catch: Throwable -> L59
            if (r112 <= r111) goto L37;
            long r113 = r112;
        L35:
            long r114 = 0;
        L46:
            if (r113 >= r114) goto L48;
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-1, "msg_param_error");     // Catch: Throwable -> L59
            goto L65
        L48:
            ContentValues r115 = new ContentValues();     // Catch: Throwable -> L59
            r115.put("title", r102.f271385a);     // Catch: Throwable -> L59
            if (TextUtils.isEmpty(r102.f271393i) == true) goto L51;
            r115.put("description", r102.f271393i);     // Catch: Throwable -> L59
        L51:
            r115.put("calendar_id", Integer.valueOf(r106));     // Catch: Throwable -> L59
            r115.put("dtstart", Long.valueOf(r113));     // Catch: Throwable -> L59
            r115.put("duration", "P" + (r102.f271389e * 60) + ExifInterface.LATITUDE_SOUTH);     // Catch: Throwable -> L59
            r115.put("hasAlarm", 1);     // Catch: Throwable -> L59
            r115.put("rrule", "FREQ=DAILY;COUNT=" + r102.f271388d + com.alipay.sdk.m.u.i.f25853b);     // Catch: Throwable -> L59
            r115.put("eventTimezone", TimeZone.getDefault().getID());     // Catch: Throwable -> L59
            Uri r116 = a.c(r101.getContentResolver(), Uri.parse("content://com.android.calendar/events"), r115);     // Catch: Throwable -> L59
            if (r116 != null) goto L54;
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-4, "msg_insert_event_failed");     // Catch: Throwable -> L59
            goto L65
        L54:
            ContentValues r117 = new ContentValues();     // Catch: Throwable -> L59
            long r118 = ContentUris.parseId(r116);     // Catch: Throwable -> L59
            r117.put(DocumentType.MINUTES_NAME, 0);     // Catch: Throwable -> L59
            r117.put("event_id", Long.valueOf(r118));     // Catch: Throwable -> L59
            r117.put(com.alipay.sdk.m.p.e.f25671s, 1);     // Catch: Throwable -> L59
            if (a.c(r101.getContentResolver(), Uri.parse("content://com.android.calendar/reminders"), r117) != null) goto L57;
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-5, "msg_insert_remind_failed");     // Catch: Throwable -> L59
            goto L65
        L57:
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(0, "");     // Catch: Throwable -> L59
            goto L65
        L37:
            if (r102.f271386b >= 0) goto L39;
        L44:
            r114 = 0;
            r113 = -1;
            goto L46
        L39:
            if (r102.f271387c < 0) goto L44;
            Calendar r119 = Calendar.getInstance();     // Catch: Throwable -> L59
            r119.set(11, r102.f271386b);     // Catch: Throwable -> L59
            r119.set(12, r102.f271387c);     // Catch: Throwable -> L59
            if (r111 < r119.getTimeInMillis()) goto L43;
            r119.set(5, r119.get(5) + 1);     // Catch: Throwable -> L59
        L43:
            r113 = r119.getTime().getTime();     // Catch: Throwable -> L59
        L59:
            th = move-exception;
            String r120 = Log.getStackTraceString(th);     // Catch: Throwable -> L62
            th.getMessage();     // Catch: Throwable -> L62
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());     // Catch: Throwable -> L62
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-100, r120);
        L62:
            th = move-exception;
            throw th;
        L30:
            if (a.e(r101, r102.f271385a).f271394a != 0) goto L67;
            r103 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-3, "msg_remind_title_repeated");
            goto L65
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a r100, Activity r101, com.bytedance.ug.sdk.luckycat.impl.model.a r102, g r103) {
            this.f271291d = r100;
            this.f271288a = r101;
            this.f271289b = r102;
            this.f271290c = r103;
        }
    }

    public class c implements pi7.d {
        public c() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f271292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f271293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f271294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f271295d;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f271295d;     // Catch: Throwable -> L4
            Context r101 = this.f271292a.getApplicationContext();     // Catch: Throwable -> L4
            String r102 = this.f271293b;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            com.bytedance.ug.sdk.luckycat.impl.model.b r103 = a.e(r101, r102);     // Catch: Throwable -> L4
            a r104 = this.f271295d;     // Catch: Throwable -> L4
            g r105 = this.f271294c;     // Catch: Throwable -> L4
            r104.getClass();     // Catch: Throwable -> L4
            a.f(r103, r105);     // Catch: Throwable -> L4
            a.g("check", true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(a r100, Activity r101, String r102, g r103) {
            this.f271295d = r100;
            this.f271292a = r101;
            this.f271293b = r102;
            this.f271294c = r103;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f271296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f271297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f271298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f271299d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f271300e;

        public final void a() {
            a r100 = this.f271300e;
            Context r101 = this.f271296a.getApplicationContext();
            String r102 = this.f271297b;
            boolean r103 = this.f271298c;
            r100.getClass();
            if (r101 != null) goto L5;
        L61:
            a.g("delete", false);
            com.bytedance.ug.sdk.luckycat.impl.model.b r104 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-1, "msg_param_error");
        L62:
            a r105 = this.f271300e;
            g r106 = this.f271299d;
            r105.getClass();
            a.f(r104, r106);
            a.g("delete", true);
            return;
        L5:
            if (TextUtils.isEmpty(r102) == true) goto L61;
            Cursor r107 = a.d(r101.getContentResolver(), Uri.parse("content://com.android.calendar/events"));     // Catch: Throwable -> L47
            if (r107 != null) goto L16;
            a.g("delete", false);     // Catch: Throwable -> L45
            r104 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-9, "msg_calendar_remind_query_cursor_null");     // Catch: Throwable -> L45
            if (r107 == null) goto L62;
        L64:
            r107.close();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.getMessage();
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
            goto L62
        L16:
            String r110 = "";
            if (r107.getCount() <= 0) goto L68;
            r107.moveToFirst();     // Catch: Throwable -> L45
        L20:
            if (r107.isAfterLast() == true) goto L38;
            String r111 = r107.getString(r107.getColumnIndex("title"));     // Catch: Throwable -> L45
            if (TextUtils.isEmpty(r111) == false) goto L25;
        L37:
            r107.moveToNext();     // Catch: Throwable -> L45
            goto L20
        L25:
            if (r107.getInt(r107.getColumnIndex("deleted")) != 1) goto L27;
            boolean r112 = true;
        L29:
            if (r102.equals(r111) == true) goto L33;
            if (r103 == true) goto L37;
            if (r111.contains(r102) == false) goto L37;
        L33:
            if (r112 == true) goto L37;
            if (a.b(r101.getContentResolver(), ContentUris.withAppendedId(Uri.parse("content://com.android.calendar/events"), r107.getInt(r107.getColumnIndex(DBDefinition.ID)))) != (-1)) goto L37;
            r104 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-10, "msg_calendar_remind_delete_failed");     // Catch: Throwable -> L45
            goto L64
        L27:
            r112 = false;
            goto L29
        L38:
            a.g("delete", true);     // Catch: Throwable -> L45
            r104 = new com.bytedance.ug.sdk.luckycat.impl.model.b(0, "");     // Catch: Throwable -> L45
        L68:
            r107.close();     // Catch: Throwable -> L43
        L53:
            a.g("delete", false);
            r104 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-100, r110);
        L43:
            th = move-exception;
            th.getMessage();
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
        L45:
            th = th;
        L66:
            r110 = Log.getStackTraceString(th);     // Catch: Throwable -> L54
            th.getMessage();     // Catch: Throwable -> L54
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());     // Catch: Throwable -> L54
            if (r107 == null) goto L53;
        L54:
            th = move-exception;
            if (r107 != null) goto L71;
        L60:
            throw th;
        L71:
            r107.close();     // Catch: Throwable -> L58
        L58:
            th = move-exception;
            th.getMessage();
            com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
        L47:
            th = th;
            r107 = null;
            goto L66
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(a r100, Activity r101, String r102, boolean r103, g r104) {
            this.f271300e = r100;
            this.f271296a = r101;
            this.f271297b = r102;
            this.f271298c = r103;
            this.f271299d = r104;
        }
    }

    public class f implements pi7.d {
        public f() {
        }
    }

    public interface g {
        void a(com.bytedance.ug.sdk.luckycat.impl.model.b r100);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f271301a = null;

        static {
            f271301a = new a();
        }
    }

    public a() {
        m r100 = m.a.f271349a;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.getMessage();
    }

    public static int a(Context r100) {
        Cursor r101 = null;
        Cursor r102 = d(r100.getContentResolver(), Uri.parse("content://com.android.calendar/calendars"));     // Catch: Throwable -> L25
        if (r102 != null) goto L13;
        if (r102 != null) goto L36;
    L11:
        return -1;
    L36:
        r102.close();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.getMessage();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
        goto L11
    L13:
        if (r102.getCount() <= 0) goto L38;
        r102.moveToFirst();     // Catch: Throwable -> L25
        int r103 = r102.getInt(r102.getColumnIndex(DBDefinition.ID));     // Catch: Throwable -> L25
        r102.close();     // Catch: Throwable -> L17
    L19:
        return r103;
    L17:
        th = move-exception;
        th.getMessage();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
        goto L19
    L38:
        r102.close();     // Catch: Throwable -> L22
    L24:
        return -1;
    L22:
        th = move-exception;
        th.getMessage();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
    L25:
        th = move-exception;
        if (0 != 0) goto L32;
    L31:
        throw th;
    L32:
        r101.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.getMessage();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());
        goto L31
    }

    public static int b(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, null, null};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r210.delete(r211, null, null);
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor d(ContentResolver r110, Uri r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, null, null, null, null};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r112, false);
        return (Cursor) r113.f474983b;
    L6:
        Cursor r114 = r110.query(r111, null, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r114, r112, true);
        return r114;
    }

    public static com.bytedance.ug.sdk.luckycat.impl.model.b e(Context r100, String r101) {
        if (r100 == null) goto L52;
        if (TextUtils.isEmpty(r101) == true) goto L52;
        Cursor r102 = null;
        Cursor r103 = d(r100.getContentResolver(), Uri.parse("content://com.android.calendar/events"));     // Catch: Throwable -> L35
        if (r103 != null) goto L10;
    L28:
        com.bytedance.ug.sdk.luckycat.impl.model.b r104 = new com.bytedance.ug.sdk.luckycat.impl.model.b(-8, "msg_calendar_remind_not_exist");     // Catch: Throwable -> L35
        if (r103 != null) goto L62;
    L34:
        return r104;
    L62:
        r103.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.getMessage();
        goto L34
    L10:
        if (r103.getCount() <= 0) goto L28;
        r103.moveToFirst();     // Catch: Throwable -> L35
    L13:
        if (r103.isAfterLast() == true) goto L28;
        String r105 = r103.getString(r103.getColumnIndex("title"));     // Catch: Throwable -> L35
        boolean r106 = true;
        if (r103.getInt(r103.getColumnIndex("deleted")) == 1) goto L19;
        r106 = false;
    L19:
        if (r101.equals(r105) == false) goto L27;
        if (r106 == true) goto L27;
        com.bytedance.ug.sdk.luckycat.impl.model.b r107 = new com.bytedance.ug.sdk.luckycat.impl.model.b(0, "");     // Catch: Throwable -> L35
        r103.close();     // Catch: Throwable -> L24
    L26:
        return r107;
    L24:
        th = move-exception;
        th.getMessage();
    L27:
        r103.moveToNext();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        String r108 = Log.getStackTraceString(th);     // Catch: Throwable -> L44
        th.getMessage();     // Catch: Throwable -> L44
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("CalendarReminderManager", th.getMessage());     // Catch: Throwable -> L44
        if (0 == 0) goto L43;
        r102.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.getMessage();
    L43:
        return new com.bytedance.ug.sdk.luckycat.impl.model.b(-100, r108);
    L44:
        th = move-exception;
        if (0 != 0) goto L60;
    L50:
        throw th;
    L60:
        r102.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.getMessage();
    L52:
        return new com.bytedance.ug.sdk.luckycat.impl.model.b(-1, "msg_param_error");
    }

    public static void f(com.bytedance.ug.sdk.luckycat.impl.model.b r100, g r101) {
        new Handler(Looper.getMainLooper()).post(new RunnableC3802a(r101, r100));
    }

    public static void g(String r100, boolean r101) {
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L9
        r102.put("type", r100);     // Catch: Throwable -> L9
        if (r101 == false) goto L6;
        r102.put("result", "success");     // Catch: Throwable -> L9
    L7:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_webview_calendar", r102, true);     // Catch: Throwable -> L9
        return;
    L6:
        r102.put("result", "failure");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.getMessage();
    }

    public static Uri c(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final void h(Activity r100, com.bytedance.ug.sdk.luckycat.impl.model.a r101, g r102) {
        String[] r103 = {"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
        m r104 = m.a.f271349a;
        if (r104.l(r100.getApplicationContext(), r103) == false) goto L6;
        rj7.c.a(new b(this, r100, r101, r102));
        return;
    L6:
        if (r101.f271391g == true) goto L9;
        f(new com.bytedance.ug.sdk.luckycat.impl.model.b(-7, "msg_no_permission"), r102);
        g("add", false);
        return;
    L9:
        r104.requestPermissions(r100, r103, new c());
    }

    public final void i(Activity r100, String r101, g r102) {
        m r103 = m.a.f271349a;
        Context r104 = r100.getApplicationContext();
        if (r103.l(r104, new String[]{"android.permission.WRITE_CALENDAR"}) == false) goto L5;
        rj7.c.a(new d(this, r100, r101, r102));
        return;
    L5:
        f(new com.bytedance.ug.sdk.luckycat.impl.model.b(-6, "msg_permission_denied"), r102);
        g("check", false);
    }

    public final void j(Activity r110, String r111, g r112, boolean r113) {
        String[] r100 = {"android.permission.WRITE_CALENDAR"};
        m r101 = m.a.f271349a;
        if (r101.l(r110.getApplicationContext(), r100) == false) goto L5;
        rj7.c.a(new e(this, r110, r111, r113, r112));
        return;
    L5:
        r101.requestPermissions(r110, r100, new f());
    }
}
