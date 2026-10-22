package com.bytedance.bdp.bdpbase.ipc;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.monitor.BdpAppMonitor;
import com.bytedance.bdp.bdpbase.ipc.annotation.Callback;
import com.bytedance.bdp.bdpbase.ipc.annotation.RemoteInterface;
import com.bytedance.bdp.bdpbase.ipc.annotation.SyncIpc;
import com.bytedance.bdp.bdpbase.util.ToastUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f201195a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f201196b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f201197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f201198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f201199e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f201200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f201201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f201202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f201203d;

        public final void a() {
            JSONObject r100 = new JSONObject();
            JSONObject r101 = new JSONObject();
            Application r102 = z84.a.a();
            boolean r103 = com.bytedance.bdp.bdpbase.util.i.b(r102, r102.getPackageName());
            r100.put("error_type", this.f201200a);     // Catch: JSONException -> L9
            r100.put("target_class", this.f201201b);     // Catch: JSONException -> L9
            r100.put("method_name", this.f201202c);     // Catch: JSONException -> L9
            if (r103 == false) goto L6;
            String r104 = "true";
        L7:
            r100.put("is_main_process_alive", r104);     // Catch: JSONException -> L9
            r100.put("exception_type", this.f201203d);     // Catch: JSONException -> L9
        L11:
            g94.b.b("IPC_Utils", new Object[]{"#monitorError error_type=" + this.f201200a + " target_class=" + this.f201201b + " method_name=" + this.f201202c + " exception_type=" + this.f201203d + " is_main_process_alive=" + r103});
            BdpAppMonitor.a("mp_ipc_error", r100, r101, new JSONObject());
            return;
        L6:
            r104 = "false";
        L9:
            e = move-exception;
            g94.b.b("IPC_Utils", new Object[]{"monitorError catch json exception", e});
            goto L11
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

        public a(String r100, String r101, String r102, String r103) {
            this.f201200a = r100;
            this.f201201b = r101;
            this.f201202c = r102;
            this.f201203d = r103;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f201204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f201205b;

        @Override // java.lang.Runnable
        public final void run() {
            BdpAppMonitor.a("mp_ipc_success_rate", this.f201204a, this.f201205b, new JSONObject());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(JSONObject r100, JSONObject r101) {
            this.f201204a = r100;
            this.f201205b = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f201206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f201207b;

        @Override // java.lang.Runnable
        public final void run() {
            BdpAppMonitor.a("mp_ipc_execute_result", this.f201206a, this.f201207b, new JSONObject());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(JSONObject r100, JSONObject r101) {
            this.f201206a = r100;
            this.f201207b = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f201208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f201209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f201210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f201211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f201212e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f201213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f201214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f201215h;

        public final void a() {
            if (t.f201199e != null) goto L5;
            t.f201199e = Boolean.valueOf(com.bytedance.bdp.bdpbase.util.i.d(z84.a.a()));
        L5:
            boolean r100 = t.f201199e.booleanValue();
            g94.b.d("IPC_Utils_monitor", new Object[]{"calling monitorBindResult, target=" + this.f201209b + ", bindSuccess=" + this.f201210c + ", scene=" + this.f201211d + ", duration=" + this.f201212e + ", use=" + this.f201213f + ", firstBind=" + this.f201214g + ", targetAlive=" + this.f201215h + ", mainProcess=" + r100 + ", bindTimeFromLaunch=" + (this.f201208a / 1000.0d) + "s"});
            JSONObject r101 = new JSONObject();
            JSONObject r102 = new JSONObject();
            r101.put("target_process", this.f201209b);     // Catch: JSONException -> L25
            r101.put("get_binder_scene", this.f201211d);     // Catch: JSONException -> L25
            r101.put("bind_success", this.f201210c);     // Catch: JSONException -> L25
            if (r100 == false) goto L9;
            String r103 = PullConfiguration.PROCESS_NAME_MAIN;
        L10:
            r101.put("current_process", r103);     // Catch: JSONException -> L25
            String r104 = "true";
            if (this.f201213f == false) goto L14;
            Object r105 = "true";
        L15:
            r101.put("whether_to_use", r105);     // Catch: JSONException -> L25
            if (this.f201214g == false) goto L18;
            Object r106 = "true";
        L19:
            r101.put("first_time_bind", r106);     // Catch: JSONException -> L25
            if (this.f201215h == true) goto L23;
            r104 = "false";
        L23:
            r101.put("target_process_alive", r104);     // Catch: JSONException -> L25
            r102.put("duration", this.f201212e);     // Catch: JSONException -> L25
        L27:
            BdpAppMonitor.a("mp_ipc_bind_result", r101, r102, new JSONObject());
            return;
        L18:
            r106 = "false";
            goto L19
        L14:
            r105 = "false";
            goto L15
        L9:
            r103 = MapBundleKey.OfflineMapKey.OFFLINE_CHILD;
        L25:
            e = move-exception;
            g94.b.b("IPC_Utils", new Object[]{"monitor bind result catch error", e});
            goto L27
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

        public d(long r100, String r101, String r102, String r103, long r104, boolean r105, boolean r106, boolean r110) {
            this.f201208a = r100;
            this.f201209b = r101;
            this.f201210c = r102;
            this.f201211d = r103;
            this.f201212e = r104;
            this.f201213f = r105;
            this.f201214g = r106;
            this.f201215h = r110;
        }
    }

    public static double d(long r100) {
        double r101 = r100;
        if (r100 > 0) goto L5;
        return r101;
    L5:
        return r101 / 1000000.0d;
    }

    static {
        Application r100 = z84.a.a();
        if ("com.bytedance.miniapp.app".equals(r100.getPackageName()) == false) goto L5;
        boolean r101 = true;
    L9:
        f201195a = r101;
        f201196b = new Object();
        f201197c = 0;
        f201198d = 0;
        f201199e = null;
        return;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getExternalCacheDir() + File.separator, "debug.flag");
        if (r102.exists() == false) goto L8;
        r101 = q94.a.a(r102.getAbsolutePath());
        goto L9
    L8:
        r101 = false;
        goto L9
    }

    public static boolean j() {
        f94.a.c().getClass();
        return TextUtils.equals(f94.a.a(), "local_test");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static void b(Method r110) throws IpcException {
        if (f201195a == false) goto L5;
    L7:
        boolean r100 = r110.isAnnotationPresent(SyncIpc.class);
        String r101 = r110.getDeclaringClass().getName();
        String r102 = r110.getName();
        String r103 = r101 + "-" + r102;
        if (r100 == false) goto L18;
        Class<?>[] r104 = r110.getExceptionTypes();
        int r105 = r104.length;
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        if (r104[r106] == IpcException.class) goto L13;
        r106 = r106 + 1;
        goto L10
    L13:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L18;
        m(r101, r102, "sync_not_throw_exception", "method '" + r103 + "' with @SyncIpc annotation must throw IpcException in method signature");
        goto L18
    L15:
        r107 = false;
    L18:
        Class<?> r108 = r110.getReturnType();
        if (r108 != Void.TYPE) goto L23;
        if (r100 == false) goto L27;
        m(r101, r102, "void_return_with_sync", "please don't use @SyncIpc annotation in for method '" + r103 + "' with void return, if do not want thread distribution, please use @NoDispatch");
    L27:
        Class<?>[] r109 = r110.getParameterTypes();
        Annotation[][] r111 = r110.getParameterAnnotations();
        if (r109.length == r111.length) goto L38;
        g94.b.b("IPC_Utils", new Object[]{"parse parameter error, method=" + r103 + ", paramCls.length=" + r109.length + ", paramAnnotations.length=" + r111.length + ", from " + r110.getDeclaringClass()});
        String r112 = r110.getDeclaringClass().getName();
        String r113 = r110.getName();
        StringBuilder r114 = new StringBuilder("cache_callback_");
        r114.append(r109.length);
        r114.append("_");
        r114.append(r111.length);
        o("parse_parameter_error", r112, r113, r114.toString());
        StringBuilder r115 = new StringBuilder("parameterType: \n");
        int r116 = r109.length;
        int r117 = 0;
    L31:
        if (r117 >= r116) goto L33;
        r115.append(r109[r117].getName());
        r115.append("\n");
        r117 = r117 + 1;
        goto L31
    L33:
        g94.b.b("IPC_Utils", new Object[]{r115.toString()});
        StringBuilder r118 = new StringBuilder("parameterAnnotationsArray: \n");
        int r119 = r111.length;
        int r120 = 0;
    L34:
        if (r120 >= r119) goto L36;
        r118.append(Arrays.toString(r111[r120]));
        r118.append("\n");
        r120 = r120 + 1;
        goto L34
    L36:
        g94.b.b("IPC_Utils", new Object[]{r118.toString()});
        return;
    L38:
        int r121 = r109.length;
        int r122 = 0;
    L39:
        if (r122 >= r121) goto L56;
        Annotation[] r123 = r111[r122];
        Class<?> r124 = r109[r122];
        byte r125 = h(r124);
        if (r123 != null) goto L43;
    L51:
        boolean r126 = false;
    L52:
        if (r126 == true) goto L55;
        if (r125 != 0) goto L55;
        m(r101, r102, "parameter_not_parcelable", "parameter type '" + r124.getName() + "' of method '" + r103 + "' is not parcelable! please check the class and add @Callback annotation if the parameter is a callback");
    L55:
        r122 = r122 + 1;
        goto L39
    L43:
        if (r123.length <= 0) goto L51;
        int r127 = r123.length;
        int r128 = 0;
    L46:
        if (r128 >= r127) goto L51;
        if ((r123[r128] instanceof Callback) == true) goto L49;
        r128 = r128 + 1;
        goto L46
    L49:
        r126 = true;
        goto L52
    L56:
        return;
    L23:
        if (h(r108) != 0) goto L25;
        m(r101, r102, "return_not_parcelable", "return type '" + r108.getName() + "' of method '" + r103 + "' is not parcelable");
        goto L27
    L25:
        if (r100 == true) goto L27;
        m(r101, r102, "return_value_no_sync", "method '" + r103 + "' with return value should use @SyncIpc annotation");
        goto L27
    L5:
        if (j() == true) goto L7;
    }

    public static String c(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder(r100.getClass().getName() + ": " + r100.getMessage());
        r101.append('\n');
        StackTraceElement[] r102 = r100.getStackTrace();
        int r103 = Math.min(r102.length, 5);
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L9;
        r101.append("\tat ");
        r101.append(r102[r104]);
        r101.append('\n');
        r104 = r104 + 1;
        goto L6
    L9:
        return r101.toString();
    }

    public static Object e(String r100) {
        String r101 = "create new instance of class '" + r100 + "' catch error";
    L15:
        return a(r100).newInstance();
    L5:
        e = move-exception;
        g94.b.b("IPC_Utils", new Object[]{r101, c(e)});
    L11:
        return null;
    L7:
        e = move-exception;
        g94.b.b("IPC_Utils", new Object[]{r101, c(e)});
    L9:
        e = move-exception;
        g94.b.b("IPC_Utils", new Object[]{r101, c(e)});
        goto L11
    }

    public static String f(Class<?> r100) {
        if (r100 != Boolean.class) goto L7;
        return "boolean";
    L7:
        if (r100 != Byte.class) goto L11;
        return "byte";
    L11:
        if (r100 != Character.class) goto L15;
        return "char";
    L15:
        if (r100 != Short.class) goto L19;
        return "short";
    L19:
        if (r100 != Integer.class) goto L23;
        return "int";
    L23:
        if (r100 != Long.class) goto L27;
        return "long";
    L27:
        if (r100 != Float.class) goto L31;
        return "float";
    L31:
        if (r100 != Double.class) goto L35;
        return ItemStyle.ITEM_STYLE_DOUBLE;
    L35:
        if (r100 != Void.class) goto L39;
        return "void";
    L39:
        if (r100 != String.class) goto L43;
        return "String";
    L43:
        if (r100 != JSONObject.class) goto L47;
        return "JSON";
    L47:
        if (r100 != JSONArray.class) goto L51;
        return "JSONArray";
    L51:
        if (r100 != Bundle.class) goto L55;
        return "Bundle";
    L55:
        return r100.getSimpleName();
    }

    public static Class<?> g(Type r100) {
        if (r100 == null) goto L30;
        if ((r100 instanceof Class) == false) goto L8;
        return (Class) r100;
    L8:
        if ((r100 instanceof ParameterizedType) == false) goto L16;
        Type r101 = ((ParameterizedType) r100).getRawType();
        if ((r101 instanceof Class) == false) goto L14;
        return (Class) r101;
    L14:
        throw new IllegalArgumentException();
    L16:
        if ((r100 instanceof GenericArrayType) == false) goto L20;
        return Array.newInstance(g(((GenericArrayType) r100).getGenericComponentType()), 0).getClass();
    L20:
        if ((r100 instanceof TypeVariable) == false) goto L24;
        return Object.class;
    L24:
        if ((r100 instanceof WildcardType) == false) goto L28;
        return g(((WildcardType) r100).getUpperBounds()[0]);
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r100.getClass().getName());
    L30:
        throw new NullPointerException("type == null");
    }

    public static byte h(Class<?> r100) {
        if (r100 != Byte.TYPE) goto L5;
    L108:
        return 1;
    L5:
        if (r100 == Byte.class) goto L108;
        if (r100 != Short.TYPE) goto L10;
    L107:
        return 2;
    L10:
        if (r100 == Short.class) goto L107;
        if (r100 != Integer.TYPE) goto L15;
    L106:
        return 3;
    L15:
        if (r100 == Integer.class) goto L106;
        if (r100 != Long.TYPE) goto L20;
    L105:
        return 4;
    L20:
        if (r100 == Long.class) goto L105;
        if (r100 != Float.TYPE) goto L25;
    L104:
        return 5;
    L25:
        if (r100 == Float.class) goto L104;
        if (r100 != Double.TYPE) goto L30;
    L103:
        return 6;
    L30:
        if (r100 == Double.class) goto L103;
        if (r100 != Boolean.TYPE) goto L35;
    L102:
        return 7;
    L35:
        if (r100 == Boolean.class) goto L102;
        if (r100 != Character.TYPE) goto L40;
    L101:
        return 8;
    L40:
        if (r100 == Character.class) goto L101;
        if (r100 != byte[].class) goto L46;
        return 9;
    L46:
        if (r100 != short[].class) goto L49;
        return 10;
    L49:
        if (r100 != int[].class) goto L52;
        return 11;
    L52:
        if (r100 != long[].class) goto L55;
        return 12;
    L55:
        if (r100 != float[].class) goto L58;
        return HTTP.CR;
    L58:
        if (r100 != double[].class) goto L61;
        return 14;
    L61:
        if (r100 != boolean[].class) goto L64;
        return 15;
    L64:
        if (r100 != char[].class) goto L67;
        return 16;
    L67:
        if (r100 != String.class) goto L70;
        return 17;
    L70:
        if (r100 != String[].class) goto L73;
        return 18;
    L73:
        if (r100 != CharSequence.class) goto L76;
        return 19;
    L76:
        if (r100 != CharSequence[].class) goto L78;
        return 20;
    L78:
        if (r100 != null) goto L80;
    L82:
        if (r100 != null) goto L84;
    L86:
        if (r100 != null) goto L88;
    L90:
        if (r100 == null) goto L95;
        if (Map.class.isAssignableFrom(r100) == false) goto L95;
        return 24;
    L95:
        if (r100 != JSONObject.class) goto L98;
        return 25;
    L98:
        if (r100 != JSONArray.class) goto L100;
        return 26;
    L100:
        return 0;
    L88:
        if (List.class.isAssignableFrom(r100) == false) goto L90;
        return 23;
    L84:
        if (Parcelable[].class.isAssignableFrom(r100) == false) goto L86;
        return 22;
    L80:
        if (Parcelable.class.isAssignableFrom(r100) == false) goto L82;
        return 21;
    }

    public static boolean i(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r100 instanceof ParameterizedType) == false) goto L15;
        Type[] r101 = ((ParameterizedType) r100).getActualTypeArguments();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (i(r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r100 instanceof GenericArrayType) == false) goto L19;
        return i(((GenericArrayType) r100).getGenericComponentType());
    L19:
        if ((r100 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r100 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r100 != null) goto L26;
        String r104 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r104);
    L26:
        r104 = r100.getClass().getName();
        goto L28
    }

    public static boolean k(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.trim().length() == 0) goto L7;
        return false;
    }

    public static String s(Method r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getName());
        r101.append('(');
        Class<?>[] r102 = r100.getParameterTypes();
        StringBuilder r103 = new StringBuilder();
        int r104 = r102.length;
        if (r104 != 0) goto L5;
        String r105 = r103.toString();
    L9:
        r101.append(r105);
        r101.append(')');
        return r101.toString();
    L5:
        r103.append(f(r102[0]));
        int r106 = 1;
    L6:
        if (r106 >= r104) goto L8;
        r103.append(",");
        r103.append(f(r102[r106]));
        r106 = r106 + 1;
        goto L6
    L8:
        r105 = r103.toString();
        goto L9
    }

    public static <T> void t(Class<T> r100) {
        if (r100.isInterface() == false) goto L10;
        if (r100.getInterfaces().length > 1) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must only extend ipc interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public static Class<?> u(Object r100) {
        if (r100 == null) goto L13;
        Class<?>[] r101 = r100.getClass().getInterfaces();
        if (r101.length != 1) goto L11;
        Class<?> r102 = r101[0];
        if (r102.isAnnotationPresent(RemoteInterface.class) == false) goto L9;
        return r102;
    L9:
        throw new IllegalArgumentException("Interface doesn't has @RemoteInterface annotation.");
    L11:
        throw new IllegalArgumentException("Remote object must extend just one interface.");
    L13:
        throw new NullPointerException("Object to (un)register must not be null.");
    }

    public static void l(Context r100, String r101) {
        g94.b.b("IPC_BdpIPC", new Object[]{r101});
        if (j() == true) goto L5;
        return;
    L5:
        if (f201195a == false) goto L13;
        Lazy r102 = ToastUtils.f201329a;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        ToastUtils.a(r100, r101);
        return;
    }

    public static Pair<String, String> r(Class<?> r100, boolean r101) {
        RemoteInterface r102 = (RemoteInterface) r100.getAnnotation(RemoteInterface.class);
        if (r101 == false) goto L5;
        String r103 = r100.getSimpleName();
    L6:
        if (r102 != null) goto L8;
    L10:
        String r104 = "";
    L12:
        return Pair.create(r103, r104);
    L8:
        if (r102.implementClass().isAssignableFrom(Void.class) == true) goto L10;
        r104 = r102.implementClass().getName();
        goto L12
    L5:
        r103 = r100.getName();
        goto L6
    }

    public static void m(String r100, String r101, String r102, String r103) throws IpcException {
        g94.b.b("IPC_Utils", new Object[]{r103});
        o("method_define_invalid", r100, r101, r102);
    }

    public static void o(String r100, String r101, String r102, String r103) {
        a r104 = new a(r100, r101, r102, r103);
        new BdpTask.Builder().onCPU().nonCancel().runnable(r104).start();
    }

    public static void p(String r110, boolean r111, long r112, long r113, long r210, long r211) {
        q(r110, r111, true, r112, -1, r113, r210, r211, -1);
    }

    public static void n(String r110, String r111, String r112, long r113, boolean r210, boolean r211, boolean r212, long r213) {
        if (Math.random() <= 0.1d) goto L5;
        return;
    L5:
        d r100 = new d(r213, r110, r111, r112, r113, r210, r211, r212);
        new BdpTask.Builder().onCPU().nonCancel().runnable(r100).start();
    }

    public static void q(String r110, boolean r111, boolean r112, long r210, long r211, long r212, long r213, long r214, long r310) {
        Object r100 = f201196b;
        monitor-enter(r100);
        if (r111 == true) goto L53;
    L7:
        int r101 = f201198d + 1;     // Catch: Throwable -> L50
        f201198d = r101;     // Catch: Throwable -> L50
        if (r101 != 100) goto L10;
        int r102 = f201197c;     // Catch: Throwable -> L50
        f201198d = 0;     // Catch: Throwable -> L50
        f201197c = 0;     // Catch: Throwable -> L50
        boolean r103 = true;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L50
        if (r103 == false) goto L30;
        if (Math.random() >= 0.1d) goto L30;
        double r104 = (((double) r102) * 1.0d) / 100.0d;
        JSONObject r113 = new JSONObject();
        JSONObject r114 = new JSONObject();
        r113.put(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, 100);     // Catch: JSONException -> L26
        if (f201199e != null) goto L21;
        f201199e = Boolean.valueOf(com.bytedance.bdp.bdpbase.util.i.d(z84.a.a()));     // Catch: JSONException -> L26
    L21:
        if (f201199e.booleanValue() == false) goto L23;
        String r115 = PullConfiguration.PROCESS_NAME_MAIN;
    L24:
        r113.put("current_process", r115);     // Catch: JSONException -> L26
        r114.put("success_count", r102);     // Catch: JSONException -> L26
        r114.put("success_rate", r104);     // Catch: JSONException -> L26
    L28:
        BdpPool.executeQuickly(new b(r113, r114));
        goto L30
    L23:
        r115 = MapBundleKey.OfflineMapKey.OFFLINE_CHILD;
    L26:
        e = move-exception;
        g94.b.b("IPC_Utils_monitor", new Object[]{"monitorSuccessRate catch json exception", e});
    L30:
        if (Math.random() >= 0.01d) goto L59;
        double r105 = d(r210);
        double r106 = d(r211);
        double r116 = d(r212);
        double r117 = d(r213);
        double r107 = d(r214);
        double r108 = d(r310);
        if (q94.a.f532096b == false) goto L34;
        StringBuilder r109 = new StringBuilder("method ");
        r109.append(r110);
        r109.append(", success ");
        r109.append(r111);
        r109.append(", callback ");
        r109.append(r112);
        r109.append(", prepare=");
        r109.append(r105);
        r109.append("ms, binder=");
        r109.append(r106);
        r109.append("ms, execute=");
        r109.append(r116);
        r109.append("ms, transRequest=");
        r109.append(r117);
        r109.append("ms, transResponse=");
        double r118 = r107;
        r109.append(r118);
        r109.append("ms, threadSchedule=");
        r109.append(r108);
        r109.append("ms");
        g94.b.a("IPC_Utils_monitor", new Object[]{"calling monitorIpcResult", r109.toString()});
    L35:
        JSONObject r119 = new JSONObject();
        JSONObject r120 = new JSONObject();
        r119.put("method_name", r110);     // Catch: JSONException -> L46
        if (r111 == false) goto L39;
        String r121 = "success";
    L40:
        r119.put("execute_result", r121);     // Catch: JSONException -> L46
        if (r112 == false) goto L43;
        String r122 = "true";
    L44:
        r119.put("is_callback", r122);     // Catch: JSONException -> L46
        r120.put("prepare_cost", r105);     // Catch: JSONException -> L46
        r120.put("get_binder_cost", r106);     // Catch: JSONException -> L46
        r120.put("thread_schedule_cost", r108);     // Catch: JSONException -> L46
        r120.put("execute_cost", r116);     // Catch: JSONException -> L46
        r120.put("transact_request_cost", r117);     // Catch: JSONException -> L46
        r120.put("transact_response_cost", r118);     // Catch: JSONException -> L46
    L48:
        BdpPool.executeQuickly(new c(r119, r120));
        return;
    L43:
        r122 = "false";
        goto L44
    L39:
        r121 = "fail";
    L46:
        e = move-exception;
        g94.b.b("IPC_Utils", new Object[]{"monitorIpcResult catch json exception", e});
        goto L48
    L34:
        r118 = r107;
        goto L35
    L59:
        return;
    L50:
        th = move-exception;
        throw th;
    L10:
        r102 = 0;
        r103 = false;
        goto L11
    L53:
        f201197c++;     // Catch: Throwable -> L50
        goto L7
    }
}
