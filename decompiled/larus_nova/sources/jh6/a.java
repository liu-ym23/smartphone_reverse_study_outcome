package jh6;

import com.bytedance.live.bizlink.api.platform.status.event.StatusEventCategory;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mg6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements mg6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<StatusEventCategory, CopyOnWriteArrayList<b>> f499092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f499093b;

    /* JADX INFO: renamed from: jh6.a$a, reason: collision with other inner class name */
    public static final class C6438a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f499094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StatusEventCategory f499095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f499096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<mg6.b, Unit> f499097d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f499094a, r101.f499094a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f499095b, r101.f499095b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f499096c, r101.f499096c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f499097d, r101.f499097d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f499094a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            StatusEventCategory r104 = this.f499095b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            c r107 = this.f499096c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Function1<mg6.b, Unit> r110 = this.f499097d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "EventListener(subscriptionId=" + this.f499094a + ", eventCategory=" + this.f499095b + ", eventType=" + this.f499096c + ", callback=" + this.f499097d + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, StatusEventCategory r101, c r102, Function1<? super mg6.b, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "subscriptionId");
            Intrinsics.checkNotNullParameter(r101, "eventCategory");
            Intrinsics.checkNotNullParameter(r103, "callback");
            this.f499094a = r100;
            this.f499095b = r101;
            this.f499096c = r102;
            this.f499097d = r103;
        }
    }

    static {
    }

    public a() {
        this.f499092a = new ConcurrentHashMap();
        this.f499093b = new ConcurrentHashMap();
    }

    @Override // mg6.a
    public final void a(mg6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        CopyOnWriteArrayList<b> r101 = this.f499092a.get(r100.f513737a);
        if (r101 != null) goto L5;
        return;
    L5:
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        b r103 = (b) r102.next();
        c r104 = r103.f499096c;
        if (r104 != null) goto L11;
    L17:
        r103.f499097d.invoke(r100);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        jy0.b.c("StatusEventManager", "publish event " + r100 + " error " + e + " \n stackTrace " + ExceptionsKt.stackTraceToString(e), null, 4);
        goto L7
    L11:
        if (Intrinsics.areEqual(r104.f513740a, r100.f513738b.f513740a) == false) goto L7;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriptionId");
        b r101 = this.f499093b.remove(r100);
        if (r101 == null) goto L8;
        CopyOnWriteArrayList<b> r102 = this.f499092a.get(r101.f499095b);
        if (r102 == null) goto L9;
        r102.remove(r101);
        return;
    L9:
        return;
    }

    public final String b(StatusEventCategory r100, c r101, Function1<? super mg6.b, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventCategory");
        Intrinsics.checkNotNullParameter(r102, "onEvent");
        String r103 = UUID.randomUUID().toString();
        b r104 = new b(r103, r100, r101, r102);
        ConcurrentHashMap<StatusEventCategory, CopyOnWriteArrayList<b>> r105 = this.f499092a;
        CopyOnWriteArrayList<b> r106 = r105.get(r100);
        if (r106 != null) goto L8;
        r106 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<b> r107 = r105.putIfAbsent(r100, r106);
        if (r107 == null) goto L8;
        r106 = r107;
    L8:
        r106.add(r104);
        this.f499093b.put(r103, r104);
        return r103;
    }
}
