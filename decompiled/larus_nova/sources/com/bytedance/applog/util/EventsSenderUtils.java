package com.bytedance.applog.util;

import android.content.Context;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.log.b;
import com.bytedance.applog.log.n;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.common.applog.EventVerify;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jx3.c;
import jx3.d;
import jx3.k;
import me.ele.lancet.base.annotations.Skip;
import nx3.e;
import nx3.g;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class EventsSenderUtils {
    private static final Map<String, e> appEventSenderMap = null;
    private static final b<Boolean> hasEventVerifyClass = null;
    private static final List<String> logTags = null;

    public static class a extends b<Boolean> {
        public a() {
        }

        @Override // com.bytedance.applog.log.b
        public final Boolean a(Object[] r100) {
            Class r101 = g.a();     // Catch: ClassNotFoundException -> L4
        L5:
            if (r101 == null) goto L7;
            boolean r102 = true;
        L9:
            return Boolean.valueOf(r102);
        L7:
            r102 = false;
        L4:
            r101 = null;
            goto L5
        }
    }

    public EventsSenderUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        logTags = Collections.singletonList("EventsSenderUtils");
        appEventSenderMap = new ConcurrentHashMap();
        hasEventVerifyClass = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_applog_util_EventsSenderUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static e findIEventsSender(String r100) {
        if (hasEventVerifyClass.b(new Object[0]).booleanValue() == true) goto L5;
        return null;
    L5:
        com.bytedance.applog.b r101 = com.bytedance.applog.a.a(r100);
        if (r101 != null) goto L18;
        r101 = (com.bytedance.applog.b) AppLog.getInstance();
    L18:
        Constructor r102 = INVOKESTATIC_com_bytedance_applog_util_EventsSenderUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.applog.et_verify.EventVerify").getConstructor(new Class[]{com.bytedance.applog.b.class});     // Catch: Throwable -> L13 Exception -> L16
        r102.setAccessible(true);     // Catch: Throwable -> L13 Exception -> L16
        e r103 = (e) r102.newInstance(new Object[]{r101});     // Catch: Throwable -> L13 Exception -> L16
        if (r103 != null) goto L11;
        n.w().c(logTags, "can't find event verify, should compile with ET", new Object[0]);
    L20:
        return r103;
    L11:
        n.w().h(logTags, "found event sender: {}", new Object[]{r103});
        goto L20
    L16:
        n.w().c(logTags, "can't find event verify, should compile with ET", new Object[0]);
        return null;
    L13:
        th = move-exception;
        n.w().c(logTags, "can't find event verify, should compile with ET", new Object[0]);
        throw th;
    }

    private static e getSender(String r100) {
        if (hasEventVerifyClass.b(new Object[0]).booleanValue() == true) goto L6;
        return null;
    L6:
        Map<String, e> r101 = appEventSenderMap;
        if (r101.containsKey(r100) == true) goto L11;
        e r102 = findIEventsSender(r100);
        r101.put(r100, r102);
        return r102;
    L11:
        return r101.get(r100);
    }

    public static String getType(jx3.a r100) {
        if ((r100 instanceof c) == false) goto L7;
        return "event";
    L7:
        if ((r100 instanceof jx3.e) == false) goto L11;
        return "event_v3";
    L11:
        if ((r100 instanceof d) == false) goto L15;
        return "log_data";
    L15:
        if ((r100 instanceof jx3.g) == false) goto L19;
        return EventVerify.TYPE_LAUNCH;
    L19:
        if ((r100 instanceof k) == false) goto L22;
        return EventVerify.TYPE_TERMINATE;
    L22:
        return null;
    }

    public static boolean isEnable(String r100) {
        if (hasEventVerifyClass.b(new Object[0]).booleanValue() == true) goto L5;
        return false;
    L5:
        e r101 = getSender(r100);
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.isEnable();
    }

    public static void addHttpHeader(String r100, String r101) {
        if (hasEventVerifyClass.b(new Object[0]).booleanValue() == true) goto L9;
        return;
    L9:
        Method r102 = INVOKESTATIC_com_bytedance_applog_util_EventsSenderUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.applog.et_verify.EventVerify").getMethod("addHttpHeader", new Class[]{String.class, String.class});     // Catch: Throwable -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L7
        r102.invoke(null, new Object[]{r100, r101});     // Catch: Throwable -> L7
        return;
    L7:
        n.w().n(logTags, new Object[0]);
    }

    public static void setEventVerifyHost(String r100, String r101) {
        e r102 = getSender(r100);
        if (r102 == null) goto L5;
        r102.setEventVerifyUrl(r101);
        return;
    L5:
        n.w().n(logTags, new Object[0]);
    }

    public static void setEventVerifyInterval(String r100, long r101) {
        e r102 = getSender(r100);
        if (r102 == null) goto L5;
        r102.setEventVerifyInterval(r101);
        return;
    L5:
        n.w().n(logTags, new Object[0]);
    }

    public static void setSpecialKeys(String r100, List<String> r101) {
        e r102 = getSender(r100);
        if (r102 == null) goto L5;
        r102.setSpecialKeys(r101);
        return;
    L5:
        n.w().n(logTags, new Object[0]);
    }

    public static void loginEtWithScheme(String r100, String r101, Context r102) {
        e r103 = getSender(r100);
        if (r103 == null) goto L5;
        r103.loginEtWithScheme(r101, r102);
        return;
    L5:
        n.w().n(logTags, new Object[0]);
    }

    public static void putEvent(String r100, String r101, JSONArray r102) {
        e r103 = getSender(r100);
        if (r103 == null) goto L6;
        r103.putEvent(r101, r102);
        return;
    }

    public static void setEventsSenderEnable(String r100, boolean r101, Context r102) {
        e r103 = getSender(r100);
        if (r103 == null) goto L5;
        r103.setEnable(r101, r102);
        return;
    L5:
        n.w().n(logTags, new Object[0]);
    }
}
