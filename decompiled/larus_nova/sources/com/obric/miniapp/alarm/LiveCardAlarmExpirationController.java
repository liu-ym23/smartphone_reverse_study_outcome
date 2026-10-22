package com.obric.miniapp.alarm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.obric.livecard.api.entity.IslandSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes33.dex */
public final class LiveCardAlarmExpirationController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveCardAlarmExpirationController f397406a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f397407b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f397408c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f397409d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LiveCardAlarmExpirationController$eventsContentObserver$1 f397410e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IslandSession f397411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f397412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f397413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f397414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final PendingIntent f397415e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f397411a, r101.f397411a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397412b, r101.f397412b) == true) goto L15;
            return false;
        L15:
            if (this.f397413c == r101.f397413c) goto L18;
            return false;
        L18:
            if (this.f397414d == r101.f397414d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f397415e, r101.f397415e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f397411a.hashCode() * 31;
            Long r101 = this.f397412b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f397413c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f397414d;
            return ((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f397415e.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Record(session=" + this.f397411a + ", eventId=" + this.f397412b + ", createAtMs=" + this.f397413c + ", durationMs=" + this.f397414d + ", expirePendingIntent=" + this.f397415e + ')';
        }

        public a(IslandSession r100, Long r101, long r102, long r103, PendingIntent r104) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r104, "expirePendingIntent");
            this.f397411a = r100;
            this.f397412b = r101;
            this.f397413c = r102;
            this.f397414d = r103;
            this.f397415e = r104;
        }
    }

    public LiveCardAlarmExpirationController() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.miniapp.alarm.LiveCardAlarmExpirationController$eventsContentObserver$1] */
    static {
        f397406a = new LiveCardAlarmExpirationController();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("LiveCardAlarmExpirationController");
        ThreadMethodProxy.start(r100);
        final Handler r101 = new Handler(r100.getLooper());
        f397407b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(HandlerDispatcherKt.from$default(r101, null, 1, null)));
        f397408c = new ConcurrentHashMap();
        f397409d = new AtomicBoolean(false);
        f397410e = new LiveCardAlarmExpirationController$eventsContentObserver$1(r101);
    }

    public static final /* synthetic */ Application a() {
        return f397406a.getContext();
    }

    public static final void d() {
        Set<Map.Entry<String, a>> r100 = f397408c.entrySet();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.add(TuplesKt.to(r103.getKey(), r103.getValue()));
        goto L4
    L6:
        Iterator r104 = SequencesKt.filter(CollectionsKt.asSequence(r101), new x()).iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        Pair r105 = (Pair) r104.next();
        String r106 = (String) r105.component1();
        Long r107 = ((a) r105.component2()).f397412b;
        if (r107 == null) goto L8;
        long r108 = r107.longValue();
        if (f(f397406a.getContext(), Long.valueOf(r108)) == true) goto L8;
        Intrinsics.checkNotNullParameter(r106, "id");
        BuildersKt.launch$default(f397407b, null, null, new LiveCardAlarmExpirationController$destroySession$1(r106, null), 3, null);
        goto L8
    }

    public static final void e() {
        LiveCardAlarmExpirationController r100 = f397406a;
        Application r101 = r100.getContext();
        if (r101 == null) goto L55;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r101, "android.permission.READ_CALENDAR") == 0) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L14;
        return;
    L14:
        if ((!f397408c.isEmpty()) == false) goto L31;
        if (f397409d.get() == true) goto L57;
        Application r103 = r100.getContext();
        if (r103 == null) goto L50;
        ContentResolver r104 = r103.getContentResolver();
        if (r104 == null) goto L58;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
        r104.registerContentObserver(CalendarContract.Events.CONTENT_URI, true, f397410e);     // Catch: Throwable -> L25
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L28:
        if (Result.m9456isSuccessimpl(r106) == false) goto L51;
        Unit r107 = (Unit) r106;
        f397409d.set(true);
        return;
    L51:
        return;
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L58:
        return;
    L50:
        return;
    L57:
        return;
    L31:
        if (f397409d.get() == false) goto L59;
        Application r109 = r100.getContext();
        if (r109 == null) goto L53;
        ContentResolver r110 = r109.getContentResolver();
        if (r110 == null) goto L60;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L40
        r110.unregisterContentObserver(f397410e);     // Catch: Throwable -> L40
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L43:
        if (Result.m9456isSuccessimpl(r112) == false) goto L54;
        Unit r113 = (Unit) r112;
        f397409d.set(false);
        return;
    L54:
        return;
    L40:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L60:
        return;
    L53:
        return;
    L59:
        return;
    L8:
        if (ContextCompat.checkSelfPermission(r101, "android.permission.WRITE_CALENDAR") != 0) goto L10;
        r102 = true;
        goto L11
    }

    private final Application getContext() {
        return AppHost.f326268a.getApplication();
    }

    public final android.app.AlarmManager h() {
        Object r100 = getContext().getSystemService("alarm");
        if ((r100 instanceof android.app.AlarmManager) == true) goto L7;
        return null;
    L7:
        return (android.app.AlarmManager) r100;
    }

    public static final long c(IslandSession r100) {
        JsonObject r101 = r100.getExt();
        if (r101 == null) goto L7;
        JsonElement r102 = r101.get("timestamp");
        if (r102 == null) goto L7;
        return r102.getAsLong();
    L7:
        return 0;
    }

    public static boolean f(Context r100, Long r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = true;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.READ_CALENDAR") == 0) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L13;
        return true;
    L13:
        if (r101 == null) goto L45;
        long r104 = r101.longValue();
        Object r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L30
        Uri r107 = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, r104);     // Catch: Throwable -> L30
        Cursor r108 = g(r100.getContentResolver(), r107, new String[]{DBDefinition.ID});     // Catch: Throwable -> L30
        if (r108 == null) goto L27;
        Cursor r109 = r108;     // Catch: Throwable -> L30
        boolean r110 = r109.moveToFirst();     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r109, null);     // Catch: Throwable -> L30
        if (r110 != true) goto L27;
    L28:
        Object r111 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L30
    L33:
        if (Result.m9455isFailureimpl(r111) == true) goto L36;
        r105 = r111;
    L36:
        Boolean r112 = (Boolean) r105;
        if (r112 != null) goto L39;
        return false;
    L39:
        return r112.booleanValue();
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L27:
        r102 = false;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L45:
        return false;
    L8:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_CALENDAR") != 0) goto L10;
        r103 = true;
        goto L11
    }

    public static final PendingIntent b(String r100, long r101, long r102) {
        LiveCardAlarmExpirationController r103 = f397406a;
        Intent r104 = new Intent(r103.getContext(), LiveCardAlarmExpireReceiver.class);
        r104.setAction("com.obric.miniapp.alarm.action.EXPIRE_LIVE_CARD." + r100);
        r104.putExtra("extra_id", r100);
        r104.putExtra("extra_task_id", r101);
        r104.putExtra("extra_expire_at_ms", r102);
        return PendingIntent.getBroadcast(r103.getContext(), 0, r104, 201326592);
    }

    public static Cursor g(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
