package zka;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.alarm.w;
import com.obric.miniapp.calendar.proxy.function.SystemAppletMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    public static final class a {
    }

    static {
    }

    public g() {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [zka.f] */
    public final void d(Context r100, final com.obric.miniapp.aibridge.f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onResult");
        final AtomicBoolean r102 = new AtomicBoolean(false);
        ?? r103 = new f(r102, r101);
        Messenger r104 = new Messenger(new k(r103, Looper.getMainLooper()));
        Bundle r105 = new Bundle();
        r105.putParcelable("callbackMessenger", r104);
        Bundle r106 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_GET_ALARM_IDS, null, r105);     // Catch: Exception -> L9
        if (r106 != null) goto L6;
    L7:
        r103.invoke(CollectionsKt.emptyList());     // Catch: Exception -> L9
        return;
    L6:
        if (r106.getBoolean("accepted", true) == false) goto L7;
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("AlarmOpsProxy", "getAlarmJsonById failed", e);
        r103.invoke(CollectionsKt.emptyList());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [zka.d] */
    public final void b(Context r100, String r101, final com.obric.miniapp.aibridge.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        final AtomicBoolean r103 = new AtomicBoolean(false);
        ?? r104 = new d(r103, r102);
        Messenger r105 = new Messenger(new i(r104, Looper.getMainLooper()));
        Bundle r106 = new Bundle();
        r106.putString("id", r101);
        r106.putParcelable("callbackMessenger", r105);
        Bundle r107 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_DELETE_ALARM, null, r106);     // Catch: Exception -> L9
        if (r107 != null) goto L6;
    L7:
        r104.invoke(Boolean.FALSE);     // Catch: Exception -> L9
        return;
    L6:
        if (r107.getBoolean("accepted", true) == false) goto L7;
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("AlarmOpsProxy", "deleteAlarm failed", e);
        r104.invoke(Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [zka.e] */
    public final void c(Context r100, String r101, final com.obric.miniapp.aibridge.d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        final AtomicBoolean r103 = new AtomicBoolean(false);
        ?? r104 = new e(r103, r102);
        Messenger r105 = new Messenger(new j(r104, Looper.getMainLooper()));
        Bundle r106 = new Bundle();
        r106.putString("id", r101);
        r106.putParcelable("callbackMessenger", r105);
        Bundle r107 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_GET_ALARM_JSON_BY_ID, null, r106);     // Catch: Exception -> L9
        if (r107 != null) goto L6;
    L7:
        r104.invoke(null);     // Catch: Exception -> L9
        return;
    L6:
        if (r107.getBoolean("accepted", true) == false) goto L7;
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("AlarmOpsProxy", "getAlarmJsonById failed", e);
        r104.invoke(null);
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [zka.c] */
    public final void a(Context r100, String r110, String r111, String r112, w r113, Map r114, final Function1 r115) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "content");
        Intrinsics.checkNotNullParameter(r113, "triggerTime");
        Intrinsics.checkNotNullParameter(r114, "extraInfo");
        Intrinsics.checkNotNullParameter(r115, "onResult");
        long r101 = r113.b();
        if (StringsKt.isBlank(r110) == false) goto L5;
    L21:
        r115.invoke(Boolean.FALSE);
        return;
    L5:
        if (r101 == Long.MIN_VALUE) goto L21;
        final AtomicBoolean r116 = new AtomicBoolean(false);
        ?? r102 = new c(r116, r115);
        Messenger r117 = new Messenger(new h(r102, Looper.getMainLooper()));
        Bundle r118 = new Bundle();
        r118.putString("id", r110);
        r118.putString("title", r111);
        r118.putString("content", r112);
        r118.putLong("triggerAtMillis", r101);
        Bundle r119 = new Bundle(r114.size());
        Iterator r120 = r114.entrySet().iterator();
    L9:
        if (r120.hasNext() == false) goto L11;
        Map.Entry r121 = (Map.Entry) r120.next();
        r119.putString((String) r121.getKey(), (String) r121.getValue());
        goto L9
    L11:
        r118.putBundle("extraInfo", r119);
        r118.putLong("intervalMinutes", 0);
        r118.putInt("repeatCount", 0);
        r118.putParcelable("callbackMessenger", r117);
        Bundle r103 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.obric.appletapp.SystemAppletProvider"), SystemAppletMethod.METHOD_CREATE_OR_UPDATE_ALARM, null, r118);     // Catch: Exception -> L18
        if (r103 != null) goto L15;
    L16:
        r102.invoke(Boolean.FALSE);     // Catch: Exception -> L18
        return;
    L15:
        if (r103.getBoolean("accepted", true) == false) goto L16;
        return;
    L18:
        e = move-exception;
        FLogger.f375446a.e("AlarmOpsProxy", "createOrUpdateAlarm failed", e);
        r102.invoke(Boolean.FALSE);
    }
}
