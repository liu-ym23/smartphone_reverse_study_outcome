package jc1;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.LiveServiceProviderManager;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.emoji.AwemeEmojiProxy;
import com.bytedance.android.live.misc.LiveService$$liveemojiimpl;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.live.utility.plugin_adapter.ExternalPluginAdapter;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.aweme.live.ILiveUtils4Plugin;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends IService>, Object> f498081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, Object> f498082b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f498083c;

    public k() {
    }

    static {
        f498081a = new ConcurrentHashMap();
        f498082b = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [R, com.bytedance.android.live.emoji.AwemeEmojiProxy] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static <T extends IService> T b(Class<T> r100) {
        ConcurrentHashMap<Class<? extends IService>, Object> r101 = f498081a;
        T r102 = (T) r101.get(r100);
        Lazy r103 = LiveServiceProviderManager.f58797a;
        Object r104 = null;
        if (r102 != null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Lazy r105 = LiveServiceProviderManager.f58797a;
        Function0 r106 = (Function0) ((ConcurrentHashMap) r105.getValue()).get(r100);
        if (r106 == null) goto L7;
        IService r107 = (IService) r106.invoke();
    L9:
        if ((r107 instanceof IService) == true) goto L11;
        r107 = null;
    L11:
        ((ConcurrentHashMap) r105.getValue()).remove(r100);
        if (r107 == null) goto L14;
        l(r100, r107);
    L14:
        r102 = (T) r107;
        goto L15
    L7:
        r107 = null;
    L15:
        if (r102 != null) goto L22;
        Iterator<Map.Entry<Class<? extends IService>, Object>> r108 = r101.entrySet().iterator();
    L18:
        if (r108.hasNext() == false) goto L22;
        Map.Entry<Class<? extends IService>, Object> r109 = r108.next();
        if (r100.isAssignableFrom(r109.getValue().getClass()) == false) goto L18;
        r102 = (T) r109.getValue();
        f498081a.put((Class<? extends IService>) r100, r102);
        r102.getClass();
    L22:
        if (r102 != null) goto L47;
        mc1.a r110 = mc1.a.c.f512867a;
        if (((ConcurrentHashMap) r110.f512862a).containsKey(r100) == false) goto L47;
        mc1.a.b r111 = (mc1.a.b) ((ConcurrentHashMap) r110.f512862a).get(r100);
        if (r111 != null) goto L29;
    L44:
        r102 = (T) r104;
        if (r102 == null) goto L47;
        l(r100, r102);
        goto L47
    L29:
        if (r111.f512865b != null) goto L32;
        Object r112 = r111.f512864a;
        mc1.a.InterfaceC6796a.C6797a<T> r113 = new mc1.a.InterfaceC6796a.C6797a();
        ((LiveService$$liveemojiimpl.a) r112).getClass();
        r113.f512863a = new AwemeEmojiProxy();
        r111.f512865b = r113;
    L32:
        if (r111.f512866c == null) goto L34;
    L43:
        r104 = r111.f512866c;
        goto L44
    L34:
        monitor-enter(mc1.a.class);
    L40:
        th = move-exception;
        throw th;
    L36:
        if (r111.f512866c != null) goto L38;
        r111.f512866c = r111.f512865b.f512863a;     // Catch: Throwable -> L40
    L38:
        monitor-exit(mc1.a.class);     // Catch: Throwable -> L40
    L47:
        return r102;
    }

    public static Object d(Class r100) {
        Package r101 = r100.getPackage();
        Objects.requireNonNull(r101);
        String r102 = r101.getName();
        String r103 = r100.getCanonicalName();
        Objects.requireNonNull(r103);
        if (r102.isEmpty() == true) goto L21;
        r103 = r103.substring(r102.length() + 1);
    L21:
        return ExternalPluginAdapter.INSTANCE.findClass("com.bytedance.android.live.misc.sv.impl." + (r103.replace('.', '_') + "$$Impl"), r100).newInstance();
    L9:
        e = move-exception;
        e.getException();
    L25:
        return null;
    L14:
        if (r100 != ILiveUtils4Plugin.class) goto L16;
        return null;
    L16:
        if (f(ILiveUtils4Plugin.class) == null) goto L24;
        LocalTestManager.a(new Class[]{((ILiveUtils4Plugin) f(ILiveUtils4Plugin.class)).getLiveTag()});
        return null;
    L24:
        return null;
    }

    public static Object e(Class r100) {
        String r101 = r100.getPackage().getName();
        String r102 = r100.getCanonicalName();
        if (r101.isEmpty() == true) goto L6;
        r102 = r102.substring(r101.length() + 1);
    L6:
        String r103 = r102.replace('.', '_') + "$$Impl";
    L17:
        e = move-exception;
        d r104 = (d) b(d.class);
        if (r104 == null) goto L34;
        r104.W3();
        if ((e instanceof ClassCastException) == false) goto L24;
    L29:
        r104.J0();
        return null;
    L24:
        if ((e instanceof ClassNotFoundException) == true) goto L29;
        if ((e instanceof IllegalAccessException) == true) goto L29;
        boolean r105 = e instanceof InstantiationException;
        goto L29
    L34:
        return null;
    L8:
        if (r101.isEmpty() == true) goto L12;
        r103 = r101 + "." + r103;     // Catch: Exception -> L17
    L12:
        if (ExternalPluginAdapter.INSTANCE.enable(r100) == false) goto L14;
        Class<?> r106 = ExternalPluginAdapter.INSTANCE.findClass(r103, r100);     // Catch: Exception -> L17
    L15:
        return r106.newInstance();
    L14:
        r106 = j(r100, r103);     // Catch: Exception -> L17
        goto L15
    }

    public static <T extends IService> T f(Class<T> r100) {
        return (T) g(r100, false);
    }

    public static <T> boolean h(Class<T> r100) {
        return f498081a.containsKey(r100);
    }

    public static boolean i(String r100) {
        Boolean r101 = Boolean.FALSE;
        boolean r102 = ((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_service_lookup_opt_strategy_enable", Boolean.class, r101)).booleanValue();
        boolean r103 = ((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_service_lookup_opt_other_strategy", Boolean.class, r101)).booleanValue();
        if ("com.bytedance.android.live.impl.StrategyService".equals(r100) == false) goto L5;
    L10:
        boolean r104 = true;
    L11:
        Boolean r105 = Boolean.valueOf(r104);
        if (r105.booleanValue() == false) goto L16;
        if (r102 == false) goto L16;
        return true;
    L16:
        if (r105.booleanValue() == true) goto L19;
        if (r103 == false) goto L19;
        return true;
    L19:
        return false;
    L5:
        if ("com.bytedance.android.live.impl.FeatureService".equals(r100) == true) goto L10;
        if ("com.bytedance.android.livesdk.chatroom.resolution.newresolution.ResolutionService".equals(r100) == true) goto L10;
        r104 = false;
        goto L11
    }

    public static <T extends IService> T n(Class<T> r100) {
        T r101 = (T) f(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new RuntimeException("获取Service失败：未注册[" + r100.getName() + "]的接口类");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static <T> T c(Class<T> r100, Boolean r101) {
        Exception r102 = null;
        if (r101.booleanValue() == false) goto L5;
    L7:
        d r103 = (d) b(d.class);
        ServiceLookup r104 = (ServiceLookup) r100.getAnnotation(ServiceLookup.class);     // Catch: Exception -> L22
        if (r104 == null) goto L21;
        String r105 = r104.value();     // Catch: Exception -> L22
        if (r105 == null) goto L21;
        if (r105.isEmpty() == true) goto L21;
        if (r101.booleanValue() == false) goto L18;
    L19:
        T r106 = r100.cast(ExternalPluginAdapter.INSTANCE.findClass(r105, r100).newInstance());     // Catch: Exception -> L22
    L29:
        if (r103 == null) goto L41;
        if (r102 == null) goto L40;
        r100.getClass();
        r103.W3();
        if ((r102 instanceof ClassCastException) == true) goto L40;
        if ((r102 instanceof ClassNotFoundException) == true) goto L40;
        if ((r102 instanceof IllegalAccessException) == true) goto L40;
        boolean r107 = r102 instanceof InstantiationException;
    L40:
        r100.getClass();
        r103.J0();
    L41:
        return r106;
    L18:
        if (i(r105) == true) goto L19;
    L21:
        r106 = null;
    L22:
        e = e;
        ServiceDummyLookup r108 = (ServiceDummyLookup) r100.getAnnotation(ServiceDummyLookup.class);
        if (r108 != null) goto L44;
    L28:
        r102 = e;
        r106 = null;
        goto L29
    L44:
        r106 = r100.cast(ExternalPluginAdapter.INSTANCE.findClass(r108.value(), r100).newInstance());     // Catch: Exception -> L27
    L27:
        e = e;
        goto L28
    L5:
        if (((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_service_lookup_opt", Boolean.class, Boolean.FALSE)).booleanValue() == true) goto L7;
        return null;
    }

    public static <T extends IService> T g(Class<T> r100, boolean r101) {
        IService r102 = (T) b(r100);
        if (r102 == null) goto L34;
    L26:
        if (r102 != null) goto L30;
        c r103 = f498083c;
        if (r103 == null) goto L30;
        r103.onGetServiceNPE(r100);
    L30:
        return (T) r102;
    L34:
        IService r104 = (IService) d(r100);     // Catch: Exception -> L16
        if (r104 == null) goto L36;
        r102 = r104;
    L11:
        if (r102 != null) goto L13;
        r102 = (T) ((IService) e(r100));
    L13:
        if (r102 == null) goto L26;
        l(r100, r102);     // Catch: Exception -> L16
        goto L26
    L36:
        r102 = (IService) c(r100, Boolean.valueOf(r101));     // Catch: Exception -> L8
    L8:
        e = e;
        r102 = (T) r104;
    L21:
        if (r100 != ILiveUtils4Plugin.class) goto L23;
    L31:
        throw e;
    L23:
        if (f(ILiveUtils4Plugin.class) == null) goto L31;
        if (((ILiveUtils4Plugin) f(ILiveUtils4Plugin.class)).isSaas() == false) goto L31;
    L16:
        e = e;
    L18:
        e = e;
        r102 = null;
        goto L21
    }

    public static <T> Class<T> j(Class<?> r100, String r101) throws ClassNotFoundException {
        ClassLoader r102 = k.class.getClassLoader();     // Catch: ClassNotFoundException -> L12
        if (r102 == null) goto L14;
        return a(r102, r101);
    L14:
        ClassLoader r103 = r100.getClassLoader();     // Catch: ClassNotFoundException -> L13
        if (r103 == null) goto L11;
        return a(r103, r101);
    L11:
        throw new ClassNotFoundException("cannot find for class" + r101 + " does not exist");
    }

    public static <T extends IService> void k(Class<T> r100, Callable<T> r101) {
        ConcurrentHashMap<Class<? extends IService>, Object> r102 = f498081a;     // Catch: Exception -> L6
        if (r102.containsKey(r100) == true) goto L10;
        r102.put(r100, r101.call());     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public static <T extends IService> void l(Class<T> r100, T r101) {
        f498081a.put(r100, r101);
    }

    public static <T extends IService> void m(Class<T> r100, Function0<? extends T> r101) {
        Lazy r102 = LiveServiceProviderManager.f58797a;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((ConcurrentHashMap) LiveServiceProviderManager.f58797a.getValue()).put(r100, r101);
    }
}
