package com.obric.miniapp.provider;

import android.app.Application;
import android.content.SearchRecentSuggestionsProvider;
import android.content.UriMatcher;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.ee.bear.lynx.impl.globalbridge.FormatMethod;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.l;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.request.SearchCalendarRequest;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016JS\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0002J$\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002J*\u0010*\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/miniapp/provider/CalendarSearchRecentSuggestionsProvider;", "Landroid/content/SearchRecentSuggestionsProvider;", "<init>", "()V", "sUriMatcher", "Landroid/content/UriMatcher;", WidgetCostModule.TYPE_ON_CREATE, "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "setTodayToNextYear", "", "bundle", "Landroid/os/Bundle;", "setTodayToLastYear", "loadInstance", EffectConfiguration.KEY_CURSOR, "Landroid/database/MatrixCursor;", "tokenizeSearchQuery", "", "maxCountSearchToken", "", "escapeSearchToken", "token", "getTimeText", GearStrategyConsts.EV_SELECT_BEGIN, "", "getDisplayDate", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "time", TimeZoneItemV2.TIME_ZONE, "isChineseLanguage", FormatMethod.FORMAT_DATE_TIME, "millis", "flags", "Companion", "TimeRange", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarSearchRecentSuggestionsProvider extends SearchRecentSuggestionsProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f398353b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f398354c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f398355d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UriMatcher f398356a;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f398357c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f398358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f398359b;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f398358a);
            r100.append('/');
            r100.append(this.f398359b);
            return r100.toString();
        }

        public b(long r100, long r101) {
            this.f398358a = r100;
            this.f398359b = r101;
        }
    }

    static {
        f398353b = new String[]{DBDefinition.ID, "suggest_text_1", "suggest_text_2", "suggest_intent_data_id", "suggest_intent_extra_data", "suggest_shortcut_id", "is_achieved", "calendar_color", "eventTimezone", "allDay"};
        f398354c = PatternProtector.compile("[^\\s\"'.?!,]+|\"([^\"]*)\"");
        f398355d = PatternProtector.compile("([%_#])");
    }

    @Override // android.content.SearchRecentSuggestionsProvider, android.content.ContentProvider
    public final boolean onCreate() {
        FLogger.f375446a.i("CalendarSearchRecentSuggestionsProvider", WidgetCostModule.TYPE_ON_CREATE);
        setupSuggestions("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", 1);
        return super.onCreate();
    }

    public CalendarSearchRecentSuggestionsProvider() {
        UriMatcher r100 = new UriMatcher(-1);
        this.f398356a = r100;
        FLogger.f375446a.i("CalendarSearchRecentSuggestionsProvider", "init");
        r100.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_query", 1);
        r100.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_query/*", 1);
        r100.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_shortcut", 2);
        r100.addURI("com.obric.miniapp.provider.CalendarSearchRecentSuggestionsProvider", "search_suggest_shortcut/*", 2);
    }

    public static void c(Bundle r110) {
        Calendar r100 = Calendar.getInstance();
        r100.set(11, 0);
        r100.set(12, 0);
        r100.set(13, 0);
        r100.set(14, 0);
        r100.add(1, -1);
        long r101 = r100.getTimeInMillis();
        r100.set(11, 23);
        r100.set(12, 59);
        r100.set(13, 59);
        r100.set(14, 59);
        r100.add(6, -1);
        r100.add(1, 1);
        long r102 = r100.getTimeInMillis();
        r110.putLong("start", r101);
        r110.putLong("end", r102);
    }

    public final String a(long r110) {
        Application r100 = AppHost.f326268a.getApplication();
        monitor-enter(CalendarSearchRecentSuggestionsProvider.class);
        Resources r101 = r100.getResources();     // Catch: Throwable -> L23
        if (r101 == null) goto L11;
        Configuration r102 = r101.getConfiguration();     // Catch: Throwable -> L23
        if (r102 == null) goto L11;
        Locale r103 = r102.locale;     // Catch: Throwable -> L23
        if (r103 == null) goto L11;
        String r104 = r103.getLanguage();     // Catch: Throwable -> L23
    L13:
        if (Intrinsics.areEqual(r104, Locale.CHINESE.getLanguage()) == false) goto L15;
        Calendar r105 = Calendar.getInstance();     // Catch: Throwable -> L23
        r105.setTimeInMillis(r110);     // Catch: Throwable -> L23
        String r106 = new SimpleDateFormat("yyyy/MM/dd EE").format(r105.getTime());     // Catch: Throwable -> L23
    L16:
        monitor-exit(CalendarSearchRecentSuggestionsProvider.class);
        if (DateFormat.is24HourFormat(r100) == false) goto L20;
        int r107 = 129;
    L22:
        return r106 + ' ' + DateUtils.formatDateTime(getContext(), r110, r107);
    L20:
        r107 = 1;
        goto L22
    L15:
        r106 = DateUtils.formatDateRange(r100, new Formatter(new StringBuilder(50), Locale.getDefault()), r110, r110, 98326, null).toString();     // Catch: Throwable -> L23
    L11:
        r104 = null;
    L23:
        th = move-exception;
        throw th;
    }

    public final void b(MatrixCursor r110, Bundle r111) {
        Bundle r100 = new SearchCalendarRequest().b(r111);
        if (r100 == null) goto L66;
        JsonArray r101 = JsonParser.parseString(r100.getString("result")).getAsJsonArray();     // Catch: Exception -> L62
        if (r101 == null) goto L66;
        Iterator<JsonElement> r102 = r101.iterator();     // Catch: Exception -> L62
        long r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L58;
        JsonObject r104 = r102.next().getAsJsonObject();     // Catch: Exception -> L55
        JsonElement r105 = r104.get("eventUuid");     // Catch: Exception -> L55
        Object r106 = null;
        if (r105 == null) goto L14;
        Object r107 = Long.valueOf(r105.getAsLong());     // Catch: Exception -> L55
    L15:
        JsonElement r108 = r104.get("title");     // Catch: Exception -> L55
        if (r108 == null) goto L18;
        Object r109 = r108.getAsString();     // Catch: Exception -> L55
    L19:
        JsonElement r112 = r104.get("dtstart");     // Catch: Exception -> L55
        if (r112 == null) goto L22;
        Long r113 = Long.valueOf(r112.getAsLong());     // Catch: Exception -> L55
    L23:
        JsonElement r114 = r104.get("dtend");     // Catch: Exception -> L55
        if (r114 == null) goto L26;
        Long r115 = Long.valueOf(r114.getAsLong());     // Catch: Exception -> L55
    L27:
        JsonElement r116 = r104.get("allDay");     // Catch: Exception -> L55
        if (r116 == null) goto L30;
        Integer r117 = Integer.valueOf(r116.getAsInt());     // Catch: Exception -> L55
    L31:
        JsonElement r118 = r104.get("eventTimezone");     // Catch: Exception -> L55
        if (r118 == null) goto L34;
        r106 = r118.getAsString();     // Catch: Exception -> L55
    L34:
        if (r107 == null) goto L51;
        if (r109 == null) goto L51;
        if (r113 == null) goto L51;
        if (r115 == null) goto L51;
        if (r117 == null) goto L51;
        if (r106 == null) goto L51;
        if (r117.intValue() != 1) goto L45;
        Object r119 = AppHost.f326268a.getApplication().getString(R.string.mini_app_all_day);     // Catch: Exception -> L55
    L75:
        Intrinsics.checkNotNull(r119);     // Catch: Exception -> L49
        r103 = r103 + 1;     // Catch: Exception -> L49
        r110.addRow(new Object[]{Long.valueOf(r103), r109, r119, r107, new b(r113.longValue(), r115.longValue()).toString(), r107, 1, 0, r106, r117});     // Catch: Exception -> L53
    L53:
        e = e;
    L71:
        FLogger.f375446a.e("CalendarSearchRecentSuggestionsProvider", "loadInstance: invalid field: " + e);     // Catch: Exception -> L60
    L60:
        e = e;
    L64:
        FLogger.f375446a.e("CalendarSearchRecentSuggestionsProvider", "loadInstance error: " + e);
        Unit r120 = Unit.INSTANCE;
        return;
    L49:
        e = e;
        goto L71
    L45:
        r119 = a(r113.longValue());     // Catch: Exception -> L49
    L51:
        FLogger.f375446a.e("CalendarSearchRecentSuggestionsProvider", "loadInstance: invalid field. ignore current instance");     // Catch: Exception -> L53
        goto L9
    L30:
        r117 = null;
        goto L31
    L26:
        r115 = null;
        goto L27
    L22:
        r113 = null;
        goto L23
    L18:
        r109 = null;
        goto L19
    L14:
        r107 = null;
    L55:
        e = e;
        goto L71
    L58:
        Unit r121 = Unit.INSTANCE;     // Catch: Exception -> L60
        return;
    L62:
        e = e;
    }

    @Override // android.content.SearchRecentSuggestionsProvider, android.content.ContentProvider
    public Cursor query(Uri r110, String[] r111, String r210, String[] r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        FLogger r100 = FLogger.f375446a;
        r100.d("CalendarSearchRecentSuggestionsProvider", "query");
        long r101 = Binder.clearCallingIdentity();
        MatrixCursor r102 = new MatrixCursor(f398353b);     // Catch: Throwable -> L75
        int r103 = this.f398356a.match(r110);     // Catch: Throwable -> L75
        int r112 = 1;
        if (r103 != 1) goto L7;
        String r104 = r110.getLastPathSegment();     // Catch: Throwable -> L75
        if (r104 != null) goto L22;
    L25:
        boolean r105 = true;
    L26:
        if (r105 == true) goto L58;
        int r106 = r104.length();     // Catch: Throwable -> L75
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L75
        Matcher r113 = f398354c.matcher(r104);     // Catch: Throwable -> L75
        int r108 = 0;
    L30:
        if (r113.find() == false) goto L41;
        if (r108 >= r106) goto L41;
        if (r113.group(r112) == null) goto L35;
        String r114 = r113.group(r112);     // Catch: Throwable -> L75
    L36:
        r108 = r108 + 1;     // Catch: Throwable -> L75
        String r115 = f398355d.matcher(r114).replaceAll("#$1");     // Catch: Throwable -> L75
        if (r115 == null) goto L39;
        r107.add(r115);     // Catch: Throwable -> L75
    L39:
        r112 = 1;
        goto L30
    L35:
        r114 = r113.group();     // Catch: Throwable -> L75
    L41:
        if (r107.isEmpty() == true) goto L58;
        Bundle r109 = new Bundle();     // Catch: Throwable -> L75
        r109.putString("keyword", r104);     // Catch: Throwable -> L75
        String r116 = r110.getQueryParameter("dtstart");     // Catch: Exception -> L56 Throwable -> L75
        if (r116 == null) goto L47;
        Long r117 = Long.valueOf(Long.parseLong(r116));     // Catch: Exception -> L56 Throwable -> L75
    L48:
        String r118 = r110.getQueryParameter("dtend");     // Catch: Exception -> L56 Throwable -> L75
        if (r118 == null) goto L51;
        Long r119 = Long.valueOf(Long.parseLong(r118));     // Catch: Exception -> L56 Throwable -> L75
    L52:
        if (r117 == null) goto L55;
        if (r119 == null) goto L55;
        r109.putLong("start", r117.longValue());     // Catch: Exception -> L56 Throwable -> L75
        r109.putLong("end", r119.longValue());     // Catch: Exception -> L56 Throwable -> L75
    L55:
        Bundle r120 = r109;
    L59:
        if (r120 == null) goto L73;
        String r121 = r120.getString("keyword");     // Catch: Throwable -> L75
        if (r121 != null) goto L63;
    L66:
        boolean r122 = true;
    L67:
        if (r122 == false) goto L69;
        b(r102, r120);     // Catch: Throwable -> L75
        goto L73
    L69:
        if (r120.getLong("start") == 0) goto L71;
        b(r102, r120);     // Catch: Throwable -> L75
        goto L73
    L71:
        Bundle r123 = new Bundle(r120);     // Catch: Throwable -> L75
        Calendar r124 = Calendar.getInstance();     // Catch: Throwable -> L75
        r124.set(11, 0);     // Catch: Throwable -> L75
        r124.set(12, 0);     // Catch: Throwable -> L75
        r124.set(13, 0);     // Catch: Throwable -> L75
        r124.set(14, 0);     // Catch: Throwable -> L75
        long r125 = r124.getTimeInMillis();     // Catch: Throwable -> L75
        r124.add(1, 1);     // Catch: Throwable -> L75
        long r126 = r124.getTimeInMillis();     // Catch: Throwable -> L75
        r123.putLong("start", r125);     // Catch: Throwable -> L75
        r123.putLong("end", r126);     // Catch: Throwable -> L75
        b(r102, r123);     // Catch: Throwable -> L75
        Bundle r127 = new Bundle(r120);     // Catch: Throwable -> L75
        c(r127);     // Catch: Throwable -> L75
        b(r102, r127);     // Catch: Throwable -> L75
        goto L73
    L63:
        if (r121.length() == 0) goto L66;
        r122 = false;
    L73:
        Binder.restoreCallingIdentity(r101);
        return r102;
    L51:
        r119 = null;
        goto L52
    L47:
        r117 = null;
    L56:
        e = move-exception;
        FLogger.f375446a.e("CalendarSearchRecentSuggestionsProvider", "parse parameters error: " + e);     // Catch: Throwable -> L75
    L58:
        r120 = null;
        goto L59
    L22:
        if (r104.length() == 0) goto L25;
        r105 = false;
        goto L26
    L7:
        if (r103 == 2) goto L9;
        r100.e("CalendarSearchRecentSuggestionsProvider", "Unknown URL " + r110 + ' ');     // Catch: Throwable -> L75
        goto L58
    L9:
        String r128 = r110.getLastPathSegment();     // Catch: Throwable -> L75
        if (r128 != null) goto L12;
    L15:
        boolean r129 = true;
    L16:
        if (r129 == true) goto L58;
        r120 = new Bundle();     // Catch: Throwable -> L75
        l.c(this, "eventUuid", r128);     // Catch: Throwable -> L75
        goto L59
    L12:
        if (r128.length() == 0) goto L15;
        r129 = false;
    L75:
        th = move-exception;
        Binder.restoreCallingIdentity(r101);
        throw th;
    }
}
