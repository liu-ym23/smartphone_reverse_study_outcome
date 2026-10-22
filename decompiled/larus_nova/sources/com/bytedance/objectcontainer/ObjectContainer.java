package com.bytedance.objectcontainer;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.bytedance.objectcontainer.exceptions.CircleDependencyException;
import com.bytedance.objectcontainer.exceptions.ContainerInternalException;
import com.bytedance.objectcontainer.exceptions.DependencyDuplicateException;
import com.bytedance.objectcontainer.exceptions.DependencyNotRegisteredException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y37.a;
import y37.b;
import y37.c;

/* JADX INFO: loaded from: classes21.dex */
public final class ObjectContainer {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AsyncHandlerExecutor f266106n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Name f266107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObjectContainer f266108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ServiceKey, Provider<?>> f266109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends FactoryArg>, Factory<?, ?>> f266110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Object, Map<?, Provider<?>>> f266111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Object, List<Provider<?>>> f266112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, Set<Provider<?>>> f266113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<ServiceKey, ConstructInfo> f266114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<ServiceKey, Object> f266115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<ServiceKey, List<InstanceCreatedCallback<?>>> f266116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<ServiceKey> f266117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile RuntimeException f266118l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final InstanceCreatedCallbackAdapter f266119m;

    /* JADX INFO: renamed from: com.bytedance.objectcontainer.ObjectContainer$3, reason: invalid class name */
    public class AnonymousClass3 implements InstanceCreatedCallbackAdapter {
        @Override // com.bytedance.objectcontainer.InstanceCreatedCallbackAdapter
        public final void a(ServiceKey r100, Object r101, boolean r102) {
        }
    }

    public static class ConstructInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f266121a;

        public ConstructInfo() {
            this.f266121a = "";
        }
    }

    public class ListContainer {
    }

    public class MapContainer {
    }

    public interface Name {
        void a();
    }

    public class SetContainer {
    }

    static {
        f266106n = new AsyncHandlerExecutor();
    }

    public final <T> T b(Class<T> r100) {
        if (this.f266118l != null) goto L10;
        return (T) d(r100);
    L6:
        e = move-exception;
        this.f266118l = e;
        AsyncHandlerExecutor r101 = f266106n;
        Runnable r102 = new b(e);
        r101.f266105a.postAtFrontOfQueue(r102);
        throw e;
    L10:
        throw this.f266118l;
    }

    public final <INSTANCE, ARG extends FactoryArg<INSTANCE>> Factory<ARG, INSTANCE> c(Class<ARG> r100) {
        Factory<ARG, INSTANCE> r101 = (Factory) this.f266110d.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        ObjectContainer r102 = this.f266108b;
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.c(r100);
    }

    public final Object d(Type r100) {
        Object r101 = f(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        StringBuilder r102 = new StringBuilder();
        ServiceKey r103 = new ServiceKey(r100);
        if (this.f266114h.size() <= 0) goto L13;
        Iterator r104 = ((LinkedHashMap) this.f266114h).keySet().iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        r102.append(((ServiceKey) r104.next()).a() + "\n ╚> ");
        goto L9
    L11:
        r102.append(r103.a());
        throw new DependencyNotRegisteredException(String.format("Dependency not registered: \n %s", new Object[]{r102.toString()}));
    L13:
        r102.append(r103.a());
        throw new DependencyNotRegisteredException(String.format("Dependency not registered %s", new Object[]{r102.toString()}));
    }

    public final <T> Pair<Provider<T>, InstanceCreatedCallbackAdapter> e(ServiceKey r100) {
        Provider<?> r101 = this.f266109c.get(r100);
        if (r101 != null) goto L5;
        ObjectContainer r102 = this.f266108b;
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.e(r100);
    L5:
        return Pair.create(r101, this.f266119m);
    }

    public final Object f(Type r100) {
        if (r100 == ObjectContainer.class) goto L5;
        ServiceKey r101 = new ServiceKey(r100);
        a r102 = new a(e(r101));
        if (this.f266118l != null) goto L17;
        return a(r101, r102);
    L13:
        e = move-exception;
        this.f266118l = e;
        AsyncHandlerExecutor r103 = f266106n;
        Runnable r104 = new c(e);
        r103.f266105a.postAtFrontOfQueue(r104);
        throw e;
    L17:
        throw this.f266118l;
    L5:
        if (TextUtils.isEmpty(null) == false) goto L8;
        return this;
    L8:
        throw new IllegalArgumentException("ObjectContainer.class should not contain name");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Object a(ServiceKey r100, a r101) {
        monitor-enter(this);
        Object r102 = ((HashMap) this.f266115i).get(r100);     // Catch: Throwable -> L42
        if (r102 == null) goto L8;
        monitor-exit(this);
        return r102;
    L8:
        Pair r103 = r101.f565865a;     // Catch: Throwable -> L42
        if (r103 != null) goto L13;
        monitor-exit(this);
        return null;
    L13:
        Provider r104 = (Provider) r103.first;     // Catch: Throwable -> L42
        if (r104 != null) goto L17;
        monitor-exit(this);
        return null;
    L17:
        boolean r105 = true;
        if (this.f266114h.containsKey(r100) == false) goto L25;
        Set r106 = ((LinkedHashMap) this.f266114h).keySet();     // Catch: Throwable -> L42
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L42
        Iterator r108 = r106.iterator();     // Catch: Throwable -> L42
    L21:
        if (r108.hasNext() == false) goto L23;
        ServiceKey r109 = (ServiceKey) r108.next();     // Catch: Throwable -> L42
        r107.append(r109.a() + " " + ((ConstructInfo) ((LinkedHashMap) this.f266114h).get(r109)).f266121a + "\n ╚> ");     // Catch: Throwable -> L42
        goto L21
    L23:
        r107.append(r100.a());     // Catch: Throwable -> L42
        throw new CircleDependencyException(String.format("circle dependency: \n %s", new Object[]{r107.toString()}));     // Catch: Throwable -> L42
    L25:
        this.f266114h.put(r100, new ConstructInfo());     // Catch: Throwable -> L42
        Object r110 = r104.a();     // Catch: Throwable -> L42
        if (r110 == null) goto L41;
        if (((HashMap) this.f266115i).containsKey(r100) == true) goto L39;
        r104.f266129a.getClass();     // Catch: Throwable -> L42
        this.f266114h.remove(r100);     // Catch: Throwable -> L42
        InstanceCreatedCallbackAdapter r111 = (InstanceCreatedCallbackAdapter) r103.second;     // Catch: Throwable -> L42
        if (r111 != null) goto L32;
    L36:
        monitor-exit(this);
        return r110;
    L32:
        if (this.f266114h.size() != 0) goto L35;
        r105 = false;
    L35:
        r111.a(r100, r110, r105);     // Catch: Throwable -> L42
        goto L36
    L39:
        throw new ContainerInternalException("Why duplicate key!!!");     // Catch: Throwable -> L42
    L41:
        throw new NullPointerException("Provider should return nonnull value " + r104);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public ObjectContainer(Name r110, ObjectContainer r111, ObjectContainerBuilder... r112) {
        this.f266114h = new LinkedHashMap();
        this.f266115i = new HashMap();
        this.f266116j = new HashMap();
        this.f266117k = new HashSet();
        this.f266118l = null;
        this.f266119m = new AnonymousClass4(this);
        this.f266107a = r110;
        this.f266108b = r111;
        LinkedHashMap r113 = new LinkedHashMap();
        LinkedHashMap r114 = new LinkedHashMap();
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        int r103 = r112.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L45;
        ObjectContainerBuilder r105 = r112[r104];
        Iterator r106 = ((LinkedHashMap) r105.f266124c).entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L12;
        Map.Entry r107 = (Map.Entry) r106.next();
        if (r113.containsKey(r107.getKey()) == true) goto L11;
        r113.put(r107.getKey(), r107.getValue());
        goto L6
    L11:
        throw new DependencyDuplicateException("duplicate already contain " + ((ServiceKey) r107.getKey()).a() + " " + r107.getValue());
    L12:
        Iterator r108 = ((LinkedHashMap) r105.f266125d).entrySet().iterator();
    L14:
        if (r108.hasNext() == false) goto L20;
        Map.Entry r109 = (Map.Entry) r108.next();
        if (r114.containsKey(r109.getKey()) == true) goto L19;
        r114.put(r109.getKey(), r109.getValue());
        goto L14
    L19:
        throw new DependencyDuplicateException("duplicate already contain " + r109.getKey() + " " + r109.getValue());
    L20:
        Iterator r115 = ((LinkedHashMap) r105.f266126e).entrySet().iterator();
    L22:
        if (r115.hasNext() == false) goto L28;
        Map.Entry r116 = (Map.Entry) r115.next();
        if (r100.containsKey(r116.getKey()) == true) goto L27;
        r100.put(r116.getKey(), r116.getValue());
        goto L22
    L27:
        throw new DependencyDuplicateException("duplicate already contain " + r116.getKey() + " " + r116.getValue());
    L28:
        Iterator r117 = ((LinkedHashMap) r105.f266128g).entrySet().iterator();
    L30:
        if (r117.hasNext() == false) goto L36;
        Map.Entry r118 = (Map.Entry) r117.next();
        if (r101.containsKey(r118.getKey()) == true) goto L35;
        r101.put(r118.getKey(), r118.getValue());
        goto L30
    L35:
        throw new DependencyDuplicateException("duplicate already contain " + r118.getKey() + " " + r118.getValue());
    L36:
        Iterator r119 = ((LinkedHashMap) r105.f266127f).entrySet().iterator();
    L38:
        if (r119.hasNext() == false) goto L44;
        Map.Entry r120 = (Map.Entry) r119.next();
        if (r102.containsKey(r120.getKey()) == true) goto L43;
        r102.put(r120.getKey(), r120.getValue());
        goto L38
    L43:
        throw new DependencyDuplicateException("duplicate already contain " + r120.getKey() + " " + r120.getValue());
    L44:
        r104 = r104 + 1;
        goto L3
    L45:
        this.f266109c = Collections.unmodifiableMap(r113);
        this.f266110d = Collections.unmodifiableMap(r114);
        this.f266111e = Collections.unmodifiableMap(r100);
        this.f266112f = Collections.unmodifiableMap(r101);
        this.f266113g = Collections.unmodifiableMap(r102);
    }
}
