package com.bytedance.lark.rustclient.internal;

import com.ss.android.lark.log.Log;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
@Singleton
public class DefaultRustClientDefinition implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, a.C3608a> f253947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f253948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f253949c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.lark.rustclient.internal.DefaultRustClientDefinition$a$a, reason: collision with other inner class name */
        public static final class C3608a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Scheduler f253950a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Function0<Boolean> f253951b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3608a) == true) goto L8;
                return false;
            L8:
                C3608a r101 = (C3608a) r100;
                if (Intrinsics.areEqual(this.f253950a, r101.f253950a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f253951b, r101.f253951b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f253950a.hashCode() * 31) + this.f253951b.hashCode();
            }

            public final String toString() {
                return "AsyncCallbackSchedulerRoute(scheduler=" + this.f253950a + ", enabledProvider=" + this.f253951b + ')';
            }

            public C3608a(Scheduler r100, Function0<Boolean> r101) {
                Intrinsics.checkNotNullParameter(r100, "scheduler");
                Intrinsics.checkNotNullParameter(r101, "enabledProvider");
                this.f253950a = r100;
                this.f253951b = r101;
            }
        }
    }

    static {
    }

    @Override // com.bytedance.lark.rustclient.internal.k
    public String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return r100;
    }

    @Override // com.bytedance.lark.rustclient.internal.k
    public boolean b() {
        return false;
    }

    @Override // com.bytedance.lark.rustclient.internal.k
    public void c(JSONObject r100) {
        Intrinsics.checkNotNullParameter("lark_rust_ffi_userid_check_dev", "eventName");
        Intrinsics.checkNotNullParameter(r100, "eventParams");
    }

    @Override // com.bytedance.lark.rustclient.internal.k
    public final Scheduler e() {
        return (Scheduler) this.f253948b.getValue();
    }

    public final Scheduler f() {
        return (Scheduler) this.f253949c.getValue();
    }

    @Inject
    public DefaultRustClientDefinition(Set<com.bytedance.lark.rustclient.api.o> r110) {
        Intrinsics.checkNotNullParameter(r110, "asyncCallbackExecutorGroups");
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashSet r101 = new LinkedHashSet();
        Iterator<T> r102 = r110.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        com.bytedance.lark.rustclient.api.o r103 = (com.bytedance.lark.rustclient.api.o) r102.next();
        a.C3608a r104 = new a.C3608a(Schedulers.from(new h(r103, new AtomicBoolean(false))), r103.f253919b);
        Iterator<T> r105 = r103.f253920c.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        int r106 = ((Number) r105.next()).intValue();
        if (r101.contains(Integer.valueOf(r106)) == true) goto L7;
        if (r100.put(Integer.valueOf(r106), r104) == null) goto L7;
        r100.remove(Integer.valueOf(r106));
        r101.add(Integer.valueOf(r106));
        Log.e("DefaultRustClientDefinition", "async callback command belongs to multiple executor groups, fallback to default, command=" + r106);
        goto L7
    L15:
        Log.i("DefaultRustClientDefinition", "async callback executor groups initialized, groups=" + r110.size() + ", commands=" + r100.size() + ", conflicts=" + r101.size());
        this.f253947a = MapsKt.toMap(r100);
        this.f253948b = LazyKt.lazy(DefaultRustClientDefinition$pushScheduler$2.INSTANCE);
        this.f253949c = LazyKt.lazy(DefaultRustClientDefinition$asyncScheduler$2.INSTANCE);
    }

    @Override // com.bytedance.lark.rustclient.internal.k
    public final Scheduler d(Integer r100) {
        if (r100 == null) goto L13;
        a.C3608a r101 = this.f253947a.get(Integer.valueOf(r100.intValue()));
        if (r101 == null) goto L13;
        if (r101.f253951b.invoke().booleanValue() == true) goto L11;
        return f();
    L11:
        return r101.f253950a;
    L13:
        return f();
    }
}
