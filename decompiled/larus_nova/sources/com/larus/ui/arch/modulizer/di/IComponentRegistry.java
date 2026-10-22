package com.larus.ui.arch.modulizer.di;

import androidx.lifecycle.LifecycleOwner;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;
import u1a.d;
import u1a.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/ui/arch/modulizer/di/IComponentRegistry;", "Lcom/bytedance/kmp/spi/IKmpService;", MiPushClient.COMMAND_REGISTER, "", "priority", "", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IComponentRegistry extends pd6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f375180a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f375181a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final HashSet<IComponentRegistry> f375182b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Object f375183c = null;

        /* JADX INFO: renamed from: com.larus.ui.arch.modulizer.di.IComponentRegistry$a$a, reason: collision with other inner class name */
        public static final class C4515a<T> implements Comparator {
            public C4515a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                return ComparisonsKt.compareValues(Integer.valueOf(((IComponentRegistry) r101).priority()), Integer.valueOf(((IComponentRegistry) r100).priority()));
            }
        }

        public a() {
        }

        static {
            f375181a = new a();
            f375182b = new HashSet();
            f375183c = new Object();
        }

        public static void d() {
            Object r100 = f375183c;
            monitor-enter(r100);
            int r101 = y1a.a.f565679a;     // Catch: Throwable -> L21
            StringBuilder r102 = new StringBuilder("registerAll IComponentRegistry services size = ");     // Catch: Throwable -> L21
            b r103 = c.f528682a;     // Catch: Throwable -> L21
            List r104 = c.b(Reflection.getOrCreateKotlinClass(IComponentRegistry.class));     // Catch: Throwable -> L21
            if (r104 == null) goto L7;
            Integer r105 = Integer.valueOf(r104.size());     // Catch: Throwable -> L21
        L8:
            r102.append(r105);     // Catch: Throwable -> L21
            y1a.a.d("ComponentArch", r102.toString());     // Catch: Throwable -> L21
            List r106 = c.b(Reflection.getOrCreateKotlinClass(IComponentRegistry.class));     // Catch: Throwable -> L21
            if (r106 == null) goto L19;
            List r107 = CollectionsKt.sortedWith(r106, new C4515a());     // Catch: Throwable -> L21
            if (r107 == null) goto L19;
            Iterator r108 = r107.iterator();     // Catch: Throwable -> L21
        L14:
            if (r108.hasNext() == false) goto L18;
            IComponentRegistry r109 = (IComponentRegistry) r108.next();     // Catch: Throwable -> L21
            HashSet<IComponentRegistry> r110 = f375182b;     // Catch: Throwable -> L21
            if (r110.contains(r109) == true) goto L14;
            r109.register();     // Catch: Throwable -> L21
            int r111 = y1a.a.f565679a;     // Catch: Throwable -> L21
            y1a.a.d("ComponentArch", "register IComponentRegistry service = " + r109);     // Catch: Throwable -> L21
            r110.add(r109);     // Catch: Throwable -> L21
            goto L14
        L18:
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L21
        L19:
            monitor-exit(r100);
            return;
        L7:
            r105 = null;
        L21:
            th = move-exception;
            throw th;
        }

        @ComponentDsl
        public static void b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "init");
            d r101 = d.f548352a;
            Intrinsics.checkNotNullParameter(r100, "init");
            monitor-enter(r101);
            p1a.b r102 = new p1a.b();     // Catch: Throwable -> L22
            Component r103 = (Component) r100.invoke(r102);     // Catch: Throwable -> L22
            r102.c(r103);     // Catch: Throwable -> L22
            int r104 = y1a.a.f565679a;     // Catch: Throwable -> L22
            y1a.a.d("ComponentArch", "register component " + r103);     // Catch: Throwable -> L22
            if (d.f548356e == false) goto L10;
            String r105 = Reflection.getOrCreateKotlinClass(r103.getClass()).getSimpleName();     // Catch: Throwable -> L22
            if (r105 != null) goto L9;
            r105 = "Component";
        L9:
            r100 = new u1a.a(r100, r105);     // Catch: Throwable -> L22
        L10:
            Iterator<T> r106 = r103.f375138k.iterator();     // Catch: Throwable -> L22
        L12:
            if (r106.hasNext() == false) goto L19;
            ContainerFilter r107 = (ContainerFilter) r106.next();     // Catch: Throwable -> L22
            int r108 = y1a.a.f565679a;     // Catch: Throwable -> L22
            y1a.a.d("ComponentArch", r103 + " attach to " + r107);     // Catch: Throwable -> L22
            HashMap<ContainerFilter, ArrayList<Function1<p1a.b, Component>>> r109 = d.f548353b;     // Catch: Throwable -> L22
            if (r109.containsKey(r107) == true) goto L16;
            r109.put(r107, new ArrayList());     // Catch: Throwable -> L22
        L16:
            ArrayList r110 = r109.get(r107);     // Catch: Throwable -> L22
            if (r110 == null) goto L12;
            r110.add(r100);     // Catch: Throwable -> L22
            goto L12
        L19:
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(r101);
            return;
        L22:
            th = move-exception;
            throw th;
        }

        @ComponentDsl
        public static void c(final Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "init");
            final ContainerBuilder r101 = new ContainerBuilder();
            r100.invoke(r101);
            Function0<? extends Container> r102 = new e(r100, r101);
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f375177b = r102;
            u1a.c r103 = new u1a.c(r102, r101.f375176a);
            d r104 = d.f548352a;
            Intrinsics.checkNotNullParameter(r103, "containerMeta");
            monitor-enter(r104);
            d.f548354c.put(r103.f548351b, r103.f548350a);     // Catch: Throwable -> L7
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r104);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public static Container a(LifecycleOwner r100, ContainerFilter r101, Attachable r102) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "filter");
            Intrinsics.checkNotNullParameter(r102, "attachable");
            d r103 = d.f548352a;
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "filter");
            Intrinsics.checkNotNullParameter(r102, "attachable");
            monitor-enter(r103);
            Container r104 = d.f548355d.remove(r101);     // Catch: Throwable -> L10
            if (r104 != null) goto L7;
            r104 = d.b(r101);     // Catch: Throwable -> L10
        L7:
            d.a(r100, r104, r102);     // Catch: Throwable -> L10
            monitor-exit(r103);
            return r104;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f375180a = a.f375181a;
    }

    int priority();

    void register();
}
