package lg9;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.xtrace.XTrace;
import com.bytedance.xtrace.utils.TraceHelper;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
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

    public static Member b(String r110, String r111, String r112) {
        Class[] r100 = null;
        if (TextUtils.isEmpty(r112) == true) goto L106;
        String[] r113 = r112.split(",");
        Class[] r101 = new Class[r113.length];
        int r102 = r113.length;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r102) goto L105;
        String r105 = r113[r103];
        r105.getClass();
        byte r106 = -1;
        switch(r105.hashCode()) {
            case -1374008726: goto L71;
            case -1361632968: goto L67;
            case -1325958191: goto L63;
            case -1097129250: goto L59;
            case -766441794: goto L55;
            case 104431: goto L51;
            case 3039496: goto L47;
            case 3052374: goto L43;
            case 3327612: goto L39;
            case 64711720: goto L35;
            case 97526364: goto L31;
            case 100361105: goto L27;
            case 109413500: goto L23;
            case 1359468275: goto L19;
            case 2058423690: goto L15;
            case 2067161310: goto L11;
            default: goto L74;
        };
    L74:
        switch(r106) {
            case 0: goto L103;
            case 1: goto L102;
            case 2: goto L101;
            case 3: goto L100;
            case 4: goto L99;
            case 5: goto L98;
            case 6: goto L97;
            case 7: goto L96;
            case 8: goto L95;
            case 9: goto L94;
            case 10: goto L93;
            case 11: goto L92;
            case 12: goto L91;
            case 13: goto L90;
            case 14: goto L89;
            case 15: goto L88;
            default: goto L76;
        };
    L88:
        r101[r104] = short[].class;
    L104:
        r104 = r104 + 1;
        r103 = r103 + 1;
        goto L6
    L89:
        r101[r104] = boolean[].class;
        goto L104
    L90:
        r101[r104] = double[].class;
        goto L104
    L91:
        r101[r104] = Short.TYPE;
        goto L104
    L92:
        r101[r104] = int[].class;
        goto L104
    L93:
        r101[r104] = Float.TYPE;
        goto L104
    L94:
        r101[r104] = Boolean.TYPE;
        goto L104
    L95:
        r101[r104] = Long.TYPE;
        goto L104
    L96:
        r101[r104] = Character.TYPE;
        goto L104
    L97:
        r101[r104] = Byte.TYPE;
        goto L104
    L98:
        r101[r104] = Integer.TYPE;
        goto L104
    L99:
        r101[r104] = float[].class;
        goto L104
    L100:
        r101[r104] = long[].class;
        goto L104
    L101:
        r101[r104] = Double.TYPE;
        goto L104
    L102:
        r101[r104] = char[].class;
        goto L104
    L103:
        r101[r104] = byte[].class;
        goto L104
    L76:
        if (r105.contains("[]") == false) goto L78;
        String r107 = r105.replace("[]", "");
    L110:
        Class r108 = a(r107);     // Catch: ClassNotFoundException -> L81
    L84:
        if (r105.contains("[]") == false) goto L87;
        if (r108 == null) goto L87;
        r101[r104] = Array.newInstance(r108, 0).getClass();
    L87:
        r101[r104] = r108;
    L81:
        e = move-exception;
        FLogger.f375446a.e("XTraceHelper", "getArgsTypes", e);
        r108 = null;
        goto L84
    L78:
        r107 = r105;
        goto L110
    L11:
        if (r105.equals("short[]") == false) goto L74;
        r106 = 15;
        goto L74
    L15:
        if (r105.equals("boolean[]") == false) goto L74;
        r106 = 14;
        goto L74
    L19:
        if (r105.equals("double[]") == false) goto L74;
        r106 = HTTP.CR;
        goto L74
    L23:
        if (r105.equals("short") == false) goto L74;
        r106 = 12;
        goto L74
    L27:
        if (r105.equals("int[]") == false) goto L74;
        r106 = 11;
        goto L74
    L31:
        if (r105.equals("float") == false) goto L74;
        r106 = 10;
        goto L74
    L35:
        if (r105.equals("boolean") == false) goto L74;
        r106 = 9;
        goto L74
    L39:
        if (r105.equals("long") == false) goto L74;
        r106 = 8;
        goto L74
    L43:
        if (r105.equals("char") == false) goto L74;
        r106 = 7;
        goto L74
    L47:
        if (r105.equals("byte") == false) goto L74;
        r106 = 6;
        goto L74
    L51:
        if (r105.equals("int") == false) goto L74;
        r106 = 5;
        goto L74
    L55:
        if (r105.equals("float[]") == false) goto L74;
        r106 = 4;
        goto L74
    L59:
        if (r105.equals("long[]") == false) goto L74;
        r106 = 3;
        goto L74
    L63:
        if (r105.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L74;
        r106 = 2;
        goto L74
    L67:
        if (r105.equals("char[]") == false) goto L74;
        r106 = 1;
        goto L74
    L71:
        if (r105.equals("byte[]") == false) goto L74;
        r106 = 0;
        goto L74
    L105:
        r100 = r101;
    L106:
        Method r114 = TraceHelper.getMethod(r110, r111, r100);
        if (r114 == null) goto L109;
        XTrace.dynamicHook(r114);
        FLogger.f375446a.i("XTraceHelper", "dynamic hook member" + r114.getName() + " method hash code:" + r114.hashCode());
    L109:
        return r114;
    }
}
