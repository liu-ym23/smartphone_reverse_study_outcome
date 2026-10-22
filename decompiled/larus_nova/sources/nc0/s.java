package nc0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.rtc.p f518621a;

    public final List<String> a() {
        return this.f518621a.c();
    }

    public final List<String> b() {
        List<com.bytedance.android.live.revenuelink.rtc.o> r100 = this.f518621a.l();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (((com.bytedance.android.live.revenuelink.rtc.o) r103).f91961g == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(((com.bytedance.android.live.revenuelink.rtc.o) r105.next()).f91956b);
        goto L10
    L12:
        return r104;
    }

    public final Map<String, Object> c() {
        return this.f518621a.d().f554081a;
    }

    public final int d() {
        return this.f518621a.f91969a.size();
    }

    public s(com.bytedance.android.live.revenuelink.rtc.p r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518621a = r100;
    }

    public final r e(String r100) {
        com.bytedance.android.live.revenuelink.rtc.o r101 = this.f518621a.k(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new r(r101);
    }
}
