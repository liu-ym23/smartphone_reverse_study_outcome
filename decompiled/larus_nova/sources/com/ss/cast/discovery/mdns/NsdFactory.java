package com.ss.cast.discovery.mdns;

import android.content.Context;
import android.os.Build;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.ILibraryLoader;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class NsdFactory {
    private static final String TAG = "NsdFactory";

    /* JADX INFO: renamed from: com.ss.cast.discovery.mdns.NsdFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$cast$discovery$mdns$NsdFactory$Type = null;

        static {
            int[] r100 = new int[Type.values().length];
            $SwitchMap$com$ss$cast$discovery$mdns$NsdFactory$Type = r100;
            r100[Type.TypeNsdManager.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$cast$discovery$mdns$NsdFactory$Type[Type.TypeDnssd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$cast$discovery$mdns$NsdFactory$Type[Type.TypeJmDNS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type TypeDnssd = null;
        public static final Type TypeJmDNS = null;
        public static final Type TypeNsdManager = null;

        static {
            Type r100 = new Type("TypeNsdManager", 0);
            TypeNsdManager = r100;
            Type r101 = new Type("TypeDnssd", 1);
            TypeDnssd = r101;
            Type r102 = new Type("TypeJmDNS", 2);
            TypeJmDNS = r102;
            $VALUES = new Type[]{r100, r101, r102};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public NsdFactory() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_cast_discovery_mdns_NsdFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static INsdHelper createNsdHelper(Type r100, Context r101, NsdListener r102, String r103, ILibraryLoader r110) {
        return createNsdHelper(r100, r101, null, r102, r103, r110);
    }

    public static INsdHelper createNsdHelper(Type r110, Context r111, ContextManager.CastContext r112, NsdListener r113, String r114, ILibraryLoader r115) {
        Type r100 = r110;
        Logger.i(TAG, "createNsdHelper, type:" + r110 + ", linkName:" + r114);
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L7:
        int r101 = AnonymousClass1.$SwitchMap$com$ss$cast$discovery$mdns$NsdFactory$Type[r100.ordinal()];
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L25;
        if (r101 != 3) goto L29;
        return (INsdHelper) INVOKESTATIC_com_ss_cast_discovery_mdns_NsdFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.jmdns.JmDNSHelper").getConstructor(new Class[]{Context.class, NsdListener.class, String.class}).newInstance(new Object[]{r111, r113, r114});
    L15:
        e = move-exception;
        Logger.w(TAG, "jmdns library load failed:" + e.getMessage());
        return NsdHelper.createInstance(r111, r112, r113, r114);
    L29:
        return null;
    L25:
        return (INsdHelper) INVOKESTATIC_com_ss_cast_discovery_mdns_NsdFactory_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.dnssd.helper.DnssdHelper").getMethod("createInstance", new Class[]{Context.class, ContextManager.CastContext.class, NsdListener.class, String.class, ILibraryLoader.class, c.class}).invoke(null, new Object[]{r111, r112, r113, r114, r115, new d()});
    L19:
        e = move-exception;
        Logger.w(TAG, "dnssd library load failed:" + e.getMessage());
        return NsdHelper.createInstance(r111, r112, r113, r114);
    L22:
        return NsdHelper.createInstance(r111, r112, r113, r114);
    L5:
        if (r100 == Type.TypeJmDNS) goto L7;
        r100 = Type.TypeNsdManager;
        Logger.i(TAG, "createNsdHelper, API LEVEL >= 31, change to NsdManager");
        goto L7
    }
}
