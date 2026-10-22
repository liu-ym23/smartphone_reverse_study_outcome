package com.lynx.jsbridge.jsi;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public class LynxJSIObjectHub {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LynxJSIObjectHub f381365b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ILynxJSIObjectDescriptor> f381366a;

    public static final enum JObjectType extends Enum<JObjectType> {
        public static final JObjectType BOOLEAN_ARRAY_TYPE = null;
        public static final JObjectType BOOLEAN_WRAPPER_TYPE = null;
        public static final JObjectType DOUBLE_ARRAY_TYPE = null;
        public static final JObjectType DOUBLE_WRAPPER_TYPE = null;
        public static final JObjectType FLOAT_ARRAY_TYPE = null;
        public static final JObjectType FLOAT_WRAPPER_TYPE = null;
        public static final JObjectType INT_ARRAY_TYPE = null;
        public static final JObjectType INT_WRAPPER_TYPE = null;
        public static final JObjectType LIST_TYPE = null;
        public static final JObjectType LONG_ARRAY_TYPE = null;
        public static final JObjectType LONG_WRAPPER_TYPE = null;
        public static final JObjectType LYNX_JSI_OBJECT_TYPE = null;
        public static final JObjectType OBJECT_ARRAY_TYPE = null;
        public static final JObjectType STRING_TYPE = null;
        public static final JObjectType UNKNOWN_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ JObjectType[] f381367a = null;

        static {
            JObjectType r100 = new JObjectType("UNKNOWN_TYPE", 0);
            UNKNOWN_TYPE = r100;
            JObjectType r101 = new JObjectType("LYNX_JSI_OBJECT_TYPE", 1);
            LYNX_JSI_OBJECT_TYPE = r101;
            JObjectType r102 = new JObjectType("STRING_TYPE", 2);
            STRING_TYPE = r102;
            JObjectType r103 = new JObjectType("OBJECT_ARRAY_TYPE", 3);
            OBJECT_ARRAY_TYPE = r103;
            JObjectType r104 = new JObjectType("BOOLEAN_ARRAY_TYPE", 4);
            BOOLEAN_ARRAY_TYPE = r104;
            JObjectType r105 = new JObjectType("INT_ARRAY_TYPE", 5);
            INT_ARRAY_TYPE = r105;
            JObjectType r110 = new JObjectType("LONG_ARRAY_TYPE", 6);
            LONG_ARRAY_TYPE = r110;
            JObjectType r111 = new JObjectType("FLOAT_ARRAY_TYPE", 7);
            FLOAT_ARRAY_TYPE = r111;
            JObjectType r112 = new JObjectType("DOUBLE_ARRAY_TYPE", 8);
            DOUBLE_ARRAY_TYPE = r112;
            JObjectType r113 = new JObjectType("LIST_TYPE", 9);
            LIST_TYPE = r113;
            JObjectType r114 = new JObjectType("BOOLEAN_WRAPPER_TYPE", 10);
            BOOLEAN_WRAPPER_TYPE = r114;
            JObjectType r115 = new JObjectType("INT_WRAPPER_TYPE", 11);
            INT_WRAPPER_TYPE = r115;
            JObjectType r106 = new JObjectType("LONG_WRAPPER_TYPE", 12);
            LONG_WRAPPER_TYPE = r106;
            JObjectType r107 = new JObjectType("FLOAT_WRAPPER_TYPE", 13);
            FLOAT_WRAPPER_TYPE = r107;
            JObjectType r108 = new JObjectType("DOUBLE_WRAPPER_TYPE", 14);
            DOUBLE_WRAPPER_TYPE = r108;
            f381367a = new JObjectType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public static JObjectType[] values() {
            return (JObjectType[]) f381367a.clone();
        }

        public static JObjectType valueOf(String r100) {
            return (JObjectType) a.a(JObjectType.class, r100);
        }

        public JObjectType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LynxJSIObjectHub() {
        this.f381366a = new ConcurrentHashMap();
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

    private static ILynxJSIObjectDescriptor getJSIObjectDescriptor(ILynxJSIObject r100) {
        if (f381365b == null) goto L5;
    L14:
        LynxJSIObjectHub r101 = f381365b;
        String r102 = r100.getClass().getName();
        ILynxJSIObjectDescriptor r103 = r101.f381366a.get(r102);
        if (r103 == null) goto L24;
    L23:
        return r103;
    L24:
        ILynxJSIObjectDescriptor r104 = (ILynxJSIObjectDescriptor) a(r102.concat("$$Descriptor")).newInstance();     // Catch: Exception -> L18
    L20:
        r103 = r104;
        if (r103 == null) goto L23;
        r101.f381366a.put(r102, r103);
    L18:
        e = move-exception;
        LLog.e("LynxJSIObjectHub", "getJSIObjectDescriptor failed, error: " + e + ", className: " + r102);
        r104 = null;
        goto L20
    L5:
        monitor-enter(LynxJSIObjectHub.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f381365b != null) goto L9;
        f381365b = new LynxJSIObjectHub();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxJSIObjectHub.class);     // Catch: Throwable -> L11
        goto L14
    }

    private static int getJSIObjectFieldType(Object r100) {
        if (r100 != null) goto L6;
        return JObjectType.UNKNOWN_TYPE.ordinal();
    L6:
        if ((r100 instanceof ILynxJSIObject) == false) goto L10;
        return JObjectType.LYNX_JSI_OBJECT_TYPE.ordinal();
    L10:
        if ((r100 instanceof String) == false) goto L14;
        return JObjectType.STRING_TYPE.ordinal();
    L14:
        if ((r100 instanceof boolean[]) == false) goto L18;
        return JObjectType.BOOLEAN_ARRAY_TYPE.ordinal();
    L18:
        if ((r100 instanceof int[]) == false) goto L22;
        return JObjectType.INT_ARRAY_TYPE.ordinal();
    L22:
        if ((r100 instanceof long[]) == false) goto L26;
        return JObjectType.LONG_ARRAY_TYPE.ordinal();
    L26:
        if ((r100 instanceof float[]) == false) goto L30;
        return JObjectType.FLOAT_ARRAY_TYPE.ordinal();
    L30:
        if ((r100 instanceof double[]) == false) goto L34;
        return JObjectType.DOUBLE_ARRAY_TYPE.ordinal();
    L34:
        if (r100.getClass().isArray() == false) goto L38;
        return JObjectType.OBJECT_ARRAY_TYPE.ordinal();
    L38:
        if ((r100 instanceof List) == false) goto L42;
        return JObjectType.LIST_TYPE.ordinal();
    L42:
        if ((r100 instanceof Boolean) == false) goto L46;
        return JObjectType.BOOLEAN_WRAPPER_TYPE.ordinal();
    L46:
        if ((r100 instanceof Integer) == false) goto L50;
        return JObjectType.INT_WRAPPER_TYPE.ordinal();
    L50:
        if ((r100 instanceof Long) == false) goto L54;
        return JObjectType.LONG_WRAPPER_TYPE.ordinal();
    L54:
        if ((r100 instanceof Float) == false) goto L58;
        return JObjectType.FLOAT_WRAPPER_TYPE.ordinal();
    L58:
        if ((r100 instanceof Double) == false) goto L62;
        return JObjectType.DOUBLE_WRAPPER_TYPE.ordinal();
    L62:
        return JObjectType.UNKNOWN_TYPE.ordinal();
    }
}
