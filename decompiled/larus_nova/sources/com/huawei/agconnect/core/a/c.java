package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f276763a;

    /* JADX INFO: renamed from: com.huawei.agconnect.core.a.c$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 r100) {
            this();
        }

        public int a(Map.Entry<String, Integer> r100, Map.Entry<String, Integer> r101) {
            return r100.getValue().intValue() - r101.getValue().intValue();
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Map.Entry<String, Integer> r100, Map.Entry<String, Integer> r101) {
            return a(r100, r101);
        }
    }

    public c(Context r100) {
        this.f276763a = r100;
    }

    private <T extends ServiceRegistrar> T a(String r100) {
        Class r101 = INVOKESTATIC_com_huawei_agconnect_core_a_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: IllegalAccessException -> L9 InstantiationException -> L11 ClassNotFoundException -> L13
        if (ServiceRegistrar.class.isAssignableFrom(r101) == true) goto L8;
        Objects.toString(r101);     // Catch: IllegalAccessException -> L9 InstantiationException -> L11 ClassNotFoundException -> L13
        return null;
    L8:
        return (T) INVOKESTATIC_com_huawei_agconnect_core_a_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();
    L13:
        e = move-exception;
        e.getMessage();
    L15:
        return null;
    L9:
        e = move-exception;
        e.getLocalizedMessage();
    L11:
        e = move-exception;
        e.getLocalizedMessage();
        goto L15
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private List<String> b() {
        ArrayList r100 = new ArrayList();
        Bundle r101 = c();
        if (r101 != null) goto L5;
        return r100;
    L5:
        HashMap r102 = new HashMap(10);
        Iterator<String> r103 = r101.keySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();
        if ("com.huawei.agconnect.core.ServiceRegistrar".equals(r101.getString(r104)) == false) goto L7;
        String[] r105 = r104.split(":");
        if (r105.length != 2) goto L17;
        r102.put(r105[0], CastIntegerProtector.valueOf(r105[1]));     // Catch: NumberFormatException -> L14
    L14:
        e = move-exception;
        e.getMessage();
        goto L7
    L17:
        if (r105.length != 1) goto L7;
        r102.put(r105[0], 1000);
        goto L7
    L20:
        ArrayList r106 = new ArrayList(r102.entrySet());
        Collections.sort(r106, new a(null));
        Iterator r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L24;
        r100.add(((Map.Entry) r107.next()).getKey());
        goto L22
    L24:
        return r100;
    }

    private Bundle c() {
        PackageManager r100 = this.f276763a.getPackageManager();
        if (r100 != null) goto L13;
        return null;
    L13:
        ServiceInfo r101 = r100.getServiceInfo(new ComponentName(this.f276763a, ServiceDiscovery.class), 128);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r101 == null) goto L12;
        return r101.metaData;
    L12:
        return null;
    L10:
        e = move-exception;
        e.getLocalizedMessage();
        goto L12
    }

    public List<Service> a() {
        List<String> r100 = b();
        ArrayList r101 = new ArrayList();
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        ServiceRegistrar r103 = a(r102.next());
        if (r103 == null) goto L4;
        r103.initialize(this.f276763a);
        List<Service> r104 = r103.getServices(this.f276763a);
        if (r104 == null) goto L4;
        r101.addAll(r104);
        goto L4
    L10:
        r101.size();
        return r101;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_agconnect_core_a_c_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
