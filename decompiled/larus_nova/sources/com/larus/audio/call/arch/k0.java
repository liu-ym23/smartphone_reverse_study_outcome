package com.larus.audio.call.arch;

import android.os.SystemClock;
import com.larus.audio.call.arch.c;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes24.dex */
public final class k0<C extends c> implements d<C> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f289071d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f289072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<KClass<?>, com.larus.audio.call.arch.a<? super C>> f289073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.larus.audio.call.arch.a<? super C>> f289074c;

    public static final class a {
    }

    static {
    }

    public final void f() {
        Collection r100 = ((LinkedHashMap) this.f289073b).values();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        ArrayList r104 = (ArrayList) this.f289074c;
        if (r104.contains((com.larus.audio.call.arch.a) r103) == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        c("onStartAborted", r101, new e0());
    }

    public final C getContext() {
        return this.f289072a;
    }

    public k0(C r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f289072a = r100;
        this.f289073b = new LinkedHashMap();
        this.f289074c = new ArrayList();
    }

    @Override // com.larus.audio.call.arch.d
    public final void a(com.larus.audio.call.arch.a<? super C> r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        if (this.f289073b.containsKey(Reflection.getOrCreateKotlinClass(r100.getClass())) == false) goto L5;
        com.larus.audio.call.util.e.f289645a.i("LLMPluginContainer", "plugin have " + r100.T2() + ", hashCode: " + r100.hashCode());
        return;
    L5:
        this.f289073b.put(Reflection.getOrCreateKotlinClass(r100.getClass()), r100);
        com.larus.audio.call.util.e.f289645a.i("LLMPluginContainer", "register plugin " + r100.T2() + ", hashCode: " + r100.hashCode());
    }

    public final e d(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (JvmClassMappingKt.getJavaClass(r100).isInterface() == false) goto L17;
        Iterator r101 = ((LinkedHashMap) this.f289073b).values().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        com.larus.audio.call.arch.a r103 = (com.larus.audio.call.arch.a) r102;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "other");
        if (JvmClassMappingKt.getJavaClass(r100).isAssignableFrom(r103.getClass()) == false) goto L6;
    L11:
        Object r104 = (com.larus.audio.call.arch.a) r102;
        if (r104 != null) goto L14;
        RuntimeException r105 = new RuntimeException("plugin not exist , class = " + r100.getSimpleName());
        com.larus.audio.call.util.e.f289645a.e("LLMPluginContainer", r105.getMessage(), r105);
        throw r105;
    L14:
        return (e) r104;
    L10:
        r102 = null;
        goto L11
    L17:
        IllegalArgumentException r106 = new IllegalArgumentException("interface required, KClass = " + r100.getQualifiedName());
        com.larus.audio.call.util.e.f289645a.e("LLMPluginContainer", r106.getMessage(), r106);
        throw r106;
    }

    public final e e(KClass r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (JvmClassMappingKt.getJavaClass(r100).isInterface() == false) goto L15;
        Iterator r101 = ((LinkedHashMap) this.f289073b).values().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        com.larus.audio.call.arch.a r103 = (com.larus.audio.call.arch.a) r102;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "other");
        if (JvmClassMappingKt.getJavaClass(r100).isAssignableFrom(r103.getClass()) == false) goto L6;
    L11:
        Object r104 = (com.larus.audio.call.arch.a) r102;
        if ((r104 instanceof e) == true) goto L14;
        return null;
    L14:
        return (e) r104;
    L10:
        r102 = null;
        goto L11
    L15:
        com.larus.audio.call.util.e.f289645a.e("LLMPluginContainer", "interface required, KClassclazz.name}");
        throw new IllegalArgumentException("interface required, KClassclazz.name}");
    }

    public final boolean g(i r100) {
        Intrinsics.checkNotNullParameter(r100, "isStale");
        ((ArrayList) this.f289074c).clear();
        Iterator r101 = ((LinkedHashMap) this.f289073b).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        com.larus.audio.call.arch.a r102 = (com.larus.audio.call.arch.a) r101.next();
        if (((Boolean) r100.invoke()).booleanValue() == true) goto L7;
        ((ArrayList) this.f289074c).add(r102);
        r102.e3();
        goto L4
    L7:
        return false;
    L11:
        return !((Boolean) r100.invoke()).booleanValue();
    }

    public final void b(String r100, Function1<? super com.larus.audio.call.arch.a<?>, Unit> r101) {
        long r102 = SystemClock.elapsedRealtime();
        Iterator r103 = ((LinkedHashMap) this.f289073b).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r101.invoke(((Map.Entry) r103.next()).getValue());
        goto L4
    L6:
        com.larus.audio.call.util.e.f289645a.i("LLMPluginContainer", r100 + " total cost: " + (SystemClock.elapsedRealtime() - r102) + "ms");
    }

    public static void c(String r100, Iterable r101, Function1 r102) {
        long r103 = SystemClock.elapsedRealtime();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r102.invoke((com.larus.audio.call.arch.a) r104.next());
        goto L4
    L6:
        com.larus.audio.call.util.e.f289645a.i("LLMPluginContainer", r100 + " total cost: " + (SystemClock.elapsedRealtime() - r103) + "ms");
    }
}
