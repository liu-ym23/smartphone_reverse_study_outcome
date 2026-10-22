package com.obric.miniapp.alarm;

import android.app.PendingIntent;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.ss.bduploader.BDVideoUploaderBase;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class AlarmManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AlarmManager f397387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f397388b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f397389c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f397390d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f397391e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f397392f = null;

    public AlarmManager() {
    }

    static {
        f397387a = new AlarmManager();
        f397388b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f397389c = LazyKt.lazy(new g());
        f397390d = LazyKt.lazy(new h());
        f397391e = LazyKt.lazy(new i());
        f397392f = LazyKt.lazy(new j());
    }

    public static b i() {
        return ((AlarmDatabase) f397389c.getValue()).c();
    }

    public static SharedPreferences j() {
        return (SharedPreferences) f397390d.getValue();
    }

    public static void k() {
        Lazy r100 = m0.f397474a;
        BuildersKt.launch$default(f397388b, null, null, new AlarmManager$init$1(null), 3, null);
    }

    public static void h(com.obric.miniapp.aibridge.g r100) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        BuildersKt.launch$default(f397388b, null, null, new AlarmManager$getAllAlarmIds$1(r100, null), 3, null);
    }

    public static final Map<String, String> l(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L7
        LinkedHashMap r102 = new LinkedHashMap();     // Catch: Exception -> L7
        Iterator<String> r103 = r101.keys();     // Catch: Exception -> L7
    L4:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();     // Catch: Exception -> L7
        r102.put(r104, r101.optString(r104));     // Catch: Exception -> L7
        goto L4
    L14:
        return r102;
    L7:
        e = move-exception;
        FLogger.f375446a.e("AlarmManager", "parse extraInfo failed " + r100, e);
        return null;
    }

    public final Object d(Continuation<? super Unit> r100) {
        if ((r100 instanceof AlarmManager$clearAll$1) == false) goto L7;
        AlarmManager$clearAll$1 r101 = (AlarmManager$clearAll$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        Iterator r106 = (Iterator) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L29:
        if (r106.hasNext() == false) goto L33;
        a r107 = (a) r106.next();
        CoroutineDispatcher r108 = Dispatchers.getIO();
        AlarmManager$clearAll$3$1 r109 = new AlarmManager$clearAll$3$1(r107, null);
        r101.L$0 = r106;
        r101.label = 2;
        if (BuildersKt.withContext(r108, r109, r101) != r104) goto L29;
        return r104;
    L33:
        ((AlarmDatabase) f397389c.getValue()).clearAllTables();
        ((android.app.AlarmManager) m0.f397477d.getValue()).cancel((PendingIntent) m0.f397478e.getValue());
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L21:
        ArrayList r110 = new ArrayList();
        Iterator r111 = ((Iterable) r103).iterator();
    L23:
        if (r111.hasNext() == false) goto L27;
        Object r112 = r111.next();
        if (((a) r112).f397426k == false) goto L23;
        r110.add(r112);
        goto L23
    L27:
        r106 = r110.iterator();
        goto L29
    L16:
        ResultKt.throwOnFailure(r103);
        if (Build.VERSION.SDK_INT < 29) goto L33;
        b r113 = i();
        r101.label = 1;
        r103 = r113.a(r101);
        if (r103 != r104) goto L21;
        return r104;
    L7:
        r101 = new AlarmManager$clearAll$1(this, r100);
        goto L8
    }

    public final Object m(Continuation<? super Unit> r100) {
        if ((r100 instanceof AlarmManager$rescheduleAlarm$1) == false) goto L7;
        AlarmManager$rescheduleAlarm$1 r101 = (AlarmManager$rescheduleAlarm$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        w r107 = (w) r103;
        if (r107 == null) goto L32;
        Lazy r108 = m0.f397474a;
        long r109 = r107.b();
        int r110 = Build.VERSION.SDK_INT;
        if (r110 >= 31) goto L22;
    L25:
        if (r106 == true) goto L27;
        ((android.app.AlarmManager) m0.f397477d.getValue()).setAndAllowWhileIdle(0, r109, (PendingIntent) m0.f397478e.getValue());
        goto L32
    L27:
        if (r110 < 23) goto L29;
        ((android.app.AlarmManager) m0.f397477d.getValue()).setExactAndAllowWhileIdle(0, r109, (PendingIntent) m0.f397478e.getValue());
        goto L32
    L29:
        ((android.app.AlarmManager) m0.f397477d.getValue()).setExact(0, r109, (PendingIntent) m0.f397478e.getValue());
        goto L32
    L22:
        if (((android.app.AlarmManager) m0.f397477d.getValue()).canScheduleExactAlarms() == true) goto L25;
        r106 = false;
    L32:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        b r111 = ((AlarmDatabase) f397389c.getValue()).c();
        r101.label = 1;
        r103 = r111.e(r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new AlarmManager$rescheduleAlarm$1(this, r100);
        goto L8
    }

    public static void f(String r100, com.obric.miniapp.aibridge.c r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "onResult");
        BuildersKt.launch$default(f397388b, null, null, new AlarmManager$deleteAlarm$1(r100, r101, null), 3, null);
    }

    public static void g(String r100, com.obric.miniapp.aibridge.e r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "onResult");
        BuildersKt.launch$default(f397388b, null, null, new AlarmManager$getAlarmJsonById$1(r101, r100, null), 3, null);
    }

    public static final Object b(AlarmManager r110, String r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof AlarmManager$doDeleteAlarm$1) == false) goto L7;
        AlarmManager$doDeleteAlarm$1 r100 = (AlarmManager$doDeleteAlarm$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        ResultKt.throwOnFailure(r113);
    L50:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        a r114 = (a) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L45:
        if (r114.f397426k == true) goto L50;
        r100.L$0 = null;
        r100.label = 5;
        if (r110.m(r100) != r102) goto L50;
        return r102;
    L19:
        r114 = (a) r100.L$1;
        String r104 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L41:
        b r115 = i();
        String r105 = r114.f397427l;
        r100.L$0 = r114;
        r100.L$1 = null;
        r100.label = 4;
        if (r115.delete(r104, r105, r100) != r102) goto L45;
        return r102;
    L20:
        r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L30:
        a r116 = (a) r113;
        if (r116 != null) goto L34;
    L51:
        return Unit.INSTANCE;
    L34:
        if (r116.f397426k == true) goto L36;
    L40:
        r104 = r111;
        r114 = r116;
        goto L41
    L36:
        if (Build.VERSION.SDK_INT < 29) goto L40;
        CoroutineDispatcher r106 = Dispatchers.getIO();
        AlarmManager$doDeleteAlarm$2 r107 = new AlarmManager$doDeleteAlarm$2(r116, null);
        r100.L$0 = r111;
        r100.L$1 = r116;
        r100.label = 3;
        if (BuildersKt.withContext(r106, r107, r100) != r102) goto L40;
        return r102;
    L21:
        ResultKt.throwOnFailure(r113);
        goto L51
    L22:
        ResultKt.throwOnFailure(r113);
        FLogger.f375446a.i("AlarmManager", "Deleting alarm id=" + r111);
        if (Intrinsics.areEqual(r111, "clear_all_alarm") == false) goto L27;
        r100.label = 1;
        if (r110.d(r100) != r102) goto L51;
        return r102;
    L27:
        b r117 = i();
        r100.L$0 = r111;
        r100.label = 2;
        r113 = r117.c(r111, r100);
        if (r113 != r102) goto L30;
        return r102;
    L7:
        r100 = new AlarmManager$doDeleteAlarm$1(r110, r112);
        goto L8
    }

    public static final Object c(AlarmManager r100, PolarisFileWrapper r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof AlarmManager$loadExtraInfoFromFile$1) == false) goto L7;
        AlarmManager$loadExtraInfoFromFile$1 r103 = (AlarmManager$loadExtraInfoFromFile$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        File r108 = (File) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L25
        File r109 = r108;
    L22:
        String r110 = (String) r105;     // Catch: Exception -> L25
        Map<String, String> r111 = l(r110);     // Catch: Exception -> L25
        FLogger.f375446a.i("AlarmManager", "load from " + r109.getName() + " succeeded, " + r110.length() + " bytes");     // Catch: Exception -> L25
        return r111;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        if (r101.exists() == false) goto L23;
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Exception -> L25
        AlarmManager$loadExtraInfoFromFile$jsonString$1 r113 = new AlarmManager$loadExtraInfoFromFile$jsonString$1(r101, null);     // Catch: Exception -> L25
        r103.L$0 = r101;     // Catch: Exception -> L25
        r103.label = 1;     // Catch: Exception -> L25
        r105 = BuildersKt.withContext(r112, r113, r103);     // Catch: Exception -> L25
        r109 = r101;
        if (r105 != r106) goto L22;
        return r106;
    L23:
        FLogger.f375446a.i("AlarmManager", "load from " + r101.getName() + ", not exists");     // Catch: Exception -> L25
    L28:
        return null;
    L25:
        e = move-exception;
        FLogger.f375446a.e("AlarmManager", "load from " + r101.getName() + " failed", e);
    L7:
        r103 = new AlarmManager$loadExtraInfoFromFile$1(r100, r102);
        goto L8
    }

    public static void e(String r110, String r111, String r112, w r113, Map r114, Function1 r210) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "content");
        Intrinsics.checkNotNullParameter(r113, "triggerTime");
        Intrinsics.checkNotNullParameter(r114, "extraInfo");
        Intrinsics.checkNotNullParameter(r210, "onResult");
        BuildersKt.launch$default(f397388b, null, null, new AlarmManager$createOrUpdateAlarm$1(r110, r111, r112, r113, 0, 0, r210, r114, null), 3, null);
    }

    public static final Object a(AlarmManager r310, String r311, String r312, String r410, w r411, Map r412, long r413, int r414, Continuation r415) {
        r310.getClass();
        if ((r415 instanceof AlarmManager$doCreateOrUpdateAlarm$1) == false) goto L7;
        AlarmManager$doCreateOrUpdateAlarm$1 r100 = (AlarmManager$doCreateOrUpdateAlarm$1) r415;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r102);
    L91:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r102);
    L14:
        Object r104 = null;
    L87:
        r100.L$0 = r104;
        r100.label = 6;
        if (r310.m(r100) != r103) goto L91;
        return r103;
    L15:
        a r105 = (a) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L79:
        if (r105 == null) goto L14;
        if (r105.f397426k == false) goto L14;
        if (Build.VERSION.SDK_INT < 29) goto L14;
        CoroutineDispatcher r106 = Dispatchers.getIO();
        r104 = null;
        AlarmManager$doCreateOrUpdateAlarm$5$1 r107 = new AlarmManager$doCreateOrUpdateAlarm$5$1(r105, null);
        r100.L$0 = null;
        r100.label = 5;
        if (BuildersKt.withContext(r106, r107, r100) != r103) goto L87;
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
    L95:
        return Unit.INSTANCE;
    L17:
        a r108 = (a) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r109 = null;
    L61:
        if (r108 == null) goto L95;
        if (r108.f397426k == true) goto L95;
        AlarmManager r110 = f397387a;
        r100.L$0 = r109;
        r100.label = 3;
        if (r110.m(r100) != r103) goto L95;
        return r103;
    L18:
        int r111 = r100.I$0;
        long r112 = r100.J$0;
        w r113 = (w) r100.L$5;
        Map r114 = (Map) r100.L$4;
        w r115 = (w) r100.L$3;
        String r116 = (String) r100.L$2;
        String r117 = (String) r100.L$1;
        String r118 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        int r119 = r111;
        Object r120 = r102;
        Map r121 = r114;
        String r122 = r117;
        String r123 = r118;
        long r124 = r112;
        w r125 = r115;
        String r126 = r116;
    L23:
        a r127 = (a) r120;
        if (r127 != null) goto L26;
        FLogger.f375446a.i("AlarmManager", "Creating alarm id=" + r123);
    L42:
        String r210 = String.valueOf(((SecureRandom) f397391e.getValue()).nextLong());
        String r128 = (String) r121.get("notify");
        if (r128 == null) goto L45;
        boolean r129 = StringsKt.equals(r128, "alarm", true);
    L46:
        if (r127 == null) goto L48;
        a r130 = a.a(r127, r123, r122, r126, r125, r124, r119, r121, r129, r210, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
    L49:
        if (r129 == false) goto L70;
        if (Build.VERSION.SDK_INT >= 29) goto L92;
    L68:
        FLogger.f375446a.w("AlarmManager", "Schedule system alarm failed; fallback id=" + r123);
        r130 = a.a(r130, null, null, null, null, 0, 0, null, false, null, NewToolbarButtonConstants.TOOLBAR_ANCHOR_MORE_ADD_PICTURE);
        r130.f397425j.put("notify", "notification");
        goto L70
    L92:
        boolean r131 = m0.d(r130);     // Catch: Exception -> L54
    L56:
        if (r131 == false) goto L68;
        b r132 = i();
        r100.L$0 = r127;
        r109 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 2;
        if (r132.insert(r130, r100) == r103) goto L98;
        r108 = r127;
        goto L61
    L98:
        return r103;
    L54:
        e = move-exception;
        FLogger.f375446a.e("AlarmManager", "scheduleSystemAlarm exception", e);
        r131 = false;
    L70:
        if (r130.f397419d.a(r113) >= 0) goto L73;
        b0.f397430a.getClass();
        b0.a.a().a(r130);
        return Unit.INSTANCE;
    L73:
        if (r130.f397419d.a(r113) <= 0) goto L75;
        b0.f397430a.getClass();
        b0.a.a().b(r130.f397416a);
    L75:
        b r133 = i();
        r100.L$0 = r127;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 4;
        if (r133.insert(r130, r100) == r103) goto L100;
        r105 = r127;
        goto L79
    L100:
        return r103;
    L48:
        r130 = new a(r123, r122, r126, r125, r124, r119, r113, r121, r129, r210, 192);
        goto L49
    L45:
        r129 = false;
        goto L46
    L26:
        if (Intrinsics.areEqual(r127.f397416a, r123) == true) goto L28;
    L40:
        FLogger.f375446a.i("AlarmManager", "Updating alarm id=" + r123);
        goto L42
    L28:
        if (Intrinsics.areEqual(r127.f397417b, r122) == false) goto L40;
        if (Intrinsics.areEqual(r127.f397418c, r126) == false) goto L40;
        if (Intrinsics.areEqual(r127.f397419d, r125) == false) goto L40;
        if (r127.f397420e != r124) goto L40;
        if (r127.f397421f != r119) goto L40;
        if (Intrinsics.areEqual(r127.f397425j, r121) == false) goto L40;
        FLogger.f375446a.i("AlarmManager", "Duplicated alarm id=" + r123);
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r102);
        boolean r134 = w.f397489b;
        r113 = w.a.a();
        b r135 = i();
        r100.L$0 = r311;
        r100.L$1 = r312;
        r100.L$2 = r410;
        r100.L$3 = r411;
        r100.L$4 = r412;
        r100.L$5 = r113;
        r100.J$0 = r413;
        r100.I$0 = r414;
        r100.label = 1;
        Object r136 = r135.c(r311, r100);
        if (r136 == r103) goto L97;
        r123 = r311;
        r120 = r136;
        r122 = r312;
        r121 = r412;
        r126 = r410;
        r119 = r414;
        r124 = r413;
        r125 = r411;
        goto L23
    L97:
        return r103;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new AlarmManager$doCreateOrUpdateAlarm$1(r310, r415);
        goto L8
    }
}
