package h06;

import com.bytedance.ies.abmock.annotations.ABKey;
import com.bytedance.ies.abmock.annotations.ConfigKey;
import com.bytedance.ies.abmock.annotations.Group;
import com.bytedance.ies.abmock.annotations.NoCache;
import com.bytedance.ies.abmock.settings.SettingsKey;
import com.bytedance.keva.Keva;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f483441b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f483442a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ies.abmock.ClientExpManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ies.abmock.ClientExpManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ies.abmock.ClientExpManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ies.abmock.ClientExpManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ies.abmock.ClientExpManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ies.abmock.ClientExpManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ies.abmock.ClientExpManager");
    }

    public static a b() {
        if (f483441b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f483441b != null) goto L9;
        f483441b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f483441b;
    }

    public a() {
        this.f483442a = new ConcurrentHashMap();
    }

    public final int c(Class r110) {
        ABKey r100 = (ABKey) r110.getAnnotation(ABKey.class);
        if (r100 == null) goto L5;
        boolean r101 = r100.clientExperiment();
    L6:
        boolean r102 = true;
        String r103 = null;
        if (r101 == false) goto L19;
        ABKey r104 = (ABKey) r110.getAnnotation(ABKey.class);
        if (r104 == null) goto L12;
        r103 = r104.value();
    L12:
        if (r110.getAnnotation(NoCache.class) == null) goto L116;
        r102 = false;
    L116:
        return ((Integer) d(r103, r102)).intValue();
    L17:
        return 0;
    L19:
        if (b.f483443a == null) goto L21;
    L30:
        b.f483443a.getClass();
        ConfigKey r105 = (ConfigKey) r110.getAnnotation(ConfigKey.class);
        if (r105 == null) goto L33;
        String r106 = r105.value();
    L39:
        Field[] r107 = r110.getDeclaredFields();
        int r108 = r107.length;
        Field r109 = null;
        int r111 = 0;
    L40:
        if (r111 >= r108) goto L48;
        Field r112 = r107[r111];
        Group r113 = (Group) r112.getAnnotation(Group.class);
        if (r113 == null) goto L47;
        if (r113.isDefault() == true) goto L45;
        r109 = r112;
        goto L47
    L45:
        r109 = r112;
    L47:
        r111 = r111 + 1;
    L48:
        if (r109 == null) goto L113;
        r109.setAccessible(true);
    L109:
        e = move-exception;
        throw new RuntimeException(e);
    L106:
        e = move-exception;
        throw new RuntimeException(e);
    L51:
        if (Modifier.isStatic(r109.getModifiers()) == false) goto L53;
        Object r114 = r109.get(null);     // Catch: InstantiationException -> L106 IllegalAccessException -> L109
    L54:
        int r115 = ((Integer) r114).intValue();
        if (((SettingsKey) r110.getAnnotation(SettingsKey.class)) == null) goto L58;
    L60:
        boolean r116 = false;
    L61:
        i06.b r117 = i06.b.a();
        if (r117.f487889c.a().enable() == false) goto L66;
        Object r118 = r117.f487889c.a().get();
        if (r118 == null) goto L66;
    L70:
        if (r118 != null) goto L125;
        Integer r119 = Integer.valueOf(m06.a.f511487b.f511488a.getInt(r106, r115));
        Keva r120 = l06.a.f506868a;
        if (r120.contains(r106) == false) goto L100;
        String r121 = l06.a.b();
        if (((ArrayList) l06.a.f506869b).contains(r106) == false) goto L88;
        String[] r122 = r120.getStringArray("{__exposed_vids_for_current_user}_{" + r121 + '}', new String[0]);
        String r123 = r120.getString(r106, "");
        if (r123.length() > 0) goto L80;
        r102 = false;
    L80:
        if (r102 == false) goto L100;
        if (ArraysKt.contains(r122, r123) == true) goto L100;
        List r124 = ArraysKt.toMutableList(r122);
        r124.add(r123);
        String r125 = "{__exposed_vids_for_current_user}_{" + r121 + '}';
        Object[] r126 = r124.toArray(new String[0]);
        if (r126 == null) goto L87;
        r120.storeStringArray(r125, (String[]) r126);
        l06.a.a();
        goto L100
    L87:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L88:
        String[] r127 = r120.getStringArray("__exposed_vids", new String[0]);
        String r128 = r120.getString(r106, "");
        if (r128.length() > 0) goto L92;
        r102 = false;
    L92:
        if (r102 == false) goto L100;
        if (ArraysKt.contains(r127, r128) == true) goto L100;
        List r129 = ArraysKt.toMutableList(r127);
        r129.add(r128);
        Object[] r130 = r129.toArray(new String[0]);
        if (r130 == null) goto L99;
        r120.storeStringArray("__exposed_vids", (String[]) r130);
        l06.a.a();
        goto L100
    L99:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L100:
        if (r119 == null) goto L105;
        if (r116 == false) goto L103;
        ((ConcurrentHashMap) r117.f487887a).put(r106, r119);
        goto L105
    L103:
        ((ConcurrentHashMap) r117.f487888b).put(r106, r119);
    L105:
        return r119.intValue();
    L125:
        return ((Integer) r118).intValue();
    L66:
        r118 = ((ConcurrentHashMap) r117.f487887a).get(r106);
        if (r118 != null) goto L70;
        r118 = ((ConcurrentHashMap) r117.f487888b).get(r106);
        goto L70
    L58:
        if (r110.getAnnotation(NoCache.class) != null) goto L60;
        r116 = true;
        goto L61
    L53:
        r114 = r109.get(r110.newInstance());     // Catch: InstantiationException -> L106 IllegalAccessException -> L109
        goto L54
    L113:
        throw new RuntimeException("Can not find @Group in ".concat(r110.getName()));
    L33:
        ABKey r131 = (ABKey) r110.getAnnotation(ABKey.class);
        if (r131 == null) goto L36;
        r106 = r131.value();
        goto L39
    L36:
        SettingsKey r132 = (SettingsKey) r110.getAnnotation(SettingsKey.class);
        if (r132 == null) goto L115;
        r106 = r132.value();
        goto L39
    L115:
        throw new RuntimeException("Can not find @ConfigKey or @ABKey or @SettingsKey in ".concat(r110.getName()));
    L21:
        monitor-enter(b.class);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (b.f483443a != null) goto L25;
        b.f483443a = new b();     // Catch: Throwable -> L27
    L25:
        monitor-exit(b.class);     // Catch: Throwable -> L27
        goto L30
    L5:
        r101 = false;
        goto L6
    }

    public final <T> T d(String r100, boolean r101) {
        if (c.f483444a == null) goto L5;
    L14:
        c.f483444a.getClass();
        T r102 = null;
        if (r101 == false) goto L19;
        T r103 = (T) ((ConcurrentHashMap) this.f483442a).get(r100);
        if (r103 == null) goto L19;
    L20:
        if (r103 == null) goto L30;
        return r103;
    L30:
        r102 = (T) a().getDeclaredMethod(r100, new Class[0]).invoke(null, new Object[0]);
    L26:
        if (r102 == null) goto L29;
        if (r101 == false) goto L29;
        ((ConcurrentHashMap) this.f483442a).put(r100, r102);
    L29:
        return r102;
    L24:
        th = move-exception;
        th.printStackTrace();
    L19:
        r103 = null;
        goto L20
    L5:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f483444a != null) goto L9;
        c.f483444a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        goto L14
    }
}
