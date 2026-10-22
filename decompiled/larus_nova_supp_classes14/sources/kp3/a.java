package kp3;

import androidx.lifecycle.Lifecycle;
import hp3.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Map<Lifecycle.Event, b> a = null;

    /* JADX INFO: renamed from: kp3.a$a, reason: collision with other inner class name */
    public static final class C0141a extends b {
        public final Map<String, Object> b;
        public final Lifecycle.Event c;

        @Override // hp3.b
        public final Map<String, Object> a() {
            return this.b;
        }

        public C0141a(Lifecycle.Event r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lifecycleEvent");
            Intrinsics.checkNotNullParameter(r3, "desc");
            super("windowLifecycleStateChanged");
            this.c = r2;
            this.b = MapsKt.mapOf(TuplesKt.to("event", r3));
        }
    }

    static {
        Intrinsics.checkNotNullParameter(Lifecycle.Event.ON_ANY, "lifecycleEvent");
        Intrinsics.checkNotNullParameter("", "desc");
        Intrinsics.checkNotNullParameter("windowLifecycleStateChanged", "eventName");
        MapsKt.mapOf(TuplesKt.to("event", ""));
        List r0 = CollectionsKt.listOf(new C0141a[]{new C0141a(Lifecycle.Event.ON_CREATE, "onCreate"), new C0141a(Lifecycle.Event.ON_RESUME, "onResume"), new C0141a(Lifecycle.Event.ON_PAUSE, "onPause"), new C0141a(Lifecycle.Event.ON_DESTROY, "onDestroy")});
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Object r3 = r1.next();
        r2.put(((C0141a) r3).c, r3);
        goto L4
    L6:
        a = r2;
    }
}
