package com.ss.android.ugc.route_monitor.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.byted.cast.common.TeaEventTrack;
import com.larksuite.framework.apiplugin.common.OpenPlatform$Requests$OnActivityResult;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class u {
    public static final boolean f() {
        if (Build.VERSION.SDK_INT < 28) goto L8;
        if (a(RouteMonitorUtilsKt$findLaunchActivityMessageAbove28$1.INSTANCE) != null) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (a(RouteMonitorUtilsKt$findLaunchActivityMessageBelow28$1.INSTANCE) == null) goto L10;
        return true;
    }

    public static final Message a(Function1<? super Message, Boolean> r100) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        MessageQueue r101 = Looper.getMainLooper().getQueue();
    L6:
        if (r101 == null) goto L13;
        Message r102 = (Message) c(r101, "mMessages");
    L8:
        if (r102 == null) goto L12;
        if (r100.invoke(r102).booleanValue() == false) goto L12;
        r102 = (Message) c(r102, TeaEventTrack.ACTION_DRAMA_NEXT);
    L12:
        return r102;
    L13:
        return null;
    L5:
        r101 = (MessageQueue) c(Looper.getMainLooper(), "mQueue");
        goto L6
    }

    public static final Object d(Message r100) {
        if (r100 == null) goto L12;
        List r101 = (List) c(r100.obj, "mActivityCallbacks");
        if (r101 == null) goto L12;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (Intrinsics.areEqual("android.app.servertransaction.LaunchActivityItem", r103.getClass().getName()) == false) goto L8;
        return r103;
    L12:
        return null;
    }

    public static final String e(Intent r100) {
        if (r100 == null) goto L6;
        String r101 = r100.getStringExtra("___route_in_monitor_session___");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public static final JSONObject g(Intent r100) {
        JSONObject r101 = new JSONObject();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Uri r102 = r100.getData();
        Object r103 = "";
        if (r102 == null) goto L10;
        Object r104 = r102.toString();
        if (r104 == null) goto L10;
    L11:
        r101.put("uri", r104);
        r101.put(OpenPlatform$Requests$OnActivityResult.INTENT_DATA, r104);
        Object r105 = r100.getAction();
        if (r105 == null) goto L14;
        r103 = r105;
    L14:
        r101.put("intentAction", r103);
        JSONArray r106 = new JSONArray();
        r101.put("intentCategory", r106);
        Set<String> r107 = r100.getCategories();
        if (r107 == null) goto L28;
        Iterator<String> r108 = r107.iterator();
    L18:
        if (r108.hasNext() == false) goto L28;
        String r109 = r108.next();
        if (r109 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == true) goto L18;
        r106.put(r109);
        goto L18
    L22:
        if (r109.length() == 0) goto L25;
        r110 = false;
    L28:
        RouteMonitorManager.f454384g.b().getClass();
        r101.put("intentComponent", String.valueOf(r100.getComponent()));
        return r101;
    L10:
        r104 = "";
        goto L11
    }

    public static final String h(boolean r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == false) goto L5;
        RouteMonitorManager.f454384g.b().d();
        String r102 = "_";
    L6:
        r101.append(r102);
        r101.append(String.valueOf(SystemClock.elapsedRealtimeNanos()));
        r101.append('_');
        r101.append(new Object());
        return r101.toString();
    L5:
        r102 = "";
        goto L6
    }

    public static final Field b(Class<?> r100, String r101) {
        Field r102 = null;
    L3:
        if (r100 == null) goto L13;
        if ((!Intrinsics.areEqual(r100.getName(), Object.class.getName())) == false) goto L13;
        r102 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r100, new Object[]{r101});     // Catch: Exception -> L9
    L10:
        if (r102 != null) goto L13;
        r100 = r100.getSuperclass();
    L9:
        r102 = null;
    L13:
        return r102;
    }

    public static final <T> T c(Object r100, String r101) {
        Field r102 = b(r100.getClass(), r101);     // Catch: Throwable -> L6
        if (r102 == null) goto L8;
        r102.setAccessible(true);     // Catch: Throwable -> L6
        return (T) r102.get(r100);
    L8:
        return null;
    L6:
        th = move-exception;
        Logger r103 = Logger.f454747c;
        th.getMessage();
        r103.a();
        goto L8
    }

    public static final void i(String r100, Intent r101) {
        if (r101 == null) goto L5;
        r101.putExtra("___route_in_monitor_session___", r100);
    L5:
        com.ss.android.ugc.route_monitor.c.a().getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L17
        Intent r103 = null;
        if (r101 == null) goto L10;
        Intent r104 = (Intent) r101.getParcelableExtra("target_intent");     // Catch: Throwable -> L17
    L11:
        if (r104 == null) goto L13;
        r104.putExtra("___route_in_monitor_session___", r100);     // Catch: Throwable -> L17
    L13:
        if (r101 == null) goto L15;
        r103 = r101.putExtra("target_intent", r104);     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
        return;
    L10:
        r104 = null;
    L17:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
