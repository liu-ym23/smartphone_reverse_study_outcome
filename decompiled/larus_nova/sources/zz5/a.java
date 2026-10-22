package zz5;

import com.bytedance.helios.api.config.ApiStatistics;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import hz5.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import jz5.h;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f574087a;

    public a(int r100) {
        this.f574087a = r100;
    }

    public final void a() {
        k.b("Helios-Frequency-Manager", "time out: group=" + this.f574087a);
        ArrayList<ConcurrentHashMap<String, AtomicLong>> r100 = b.f574088a;
        if (((ApiStatistics) ListProtector.get(b.f574090c, this.f574087a)).b() == false) goto L22;
        h r101 = b.f574089b;
        if (r101 == null) goto L22;
        String r102 = b.c(new Object[]{((ApiStatistics) ListProtector.get(b.f574090c, this.f574087a)).getType(), Integer.valueOf(this.f574087a)});
        Map<String, ?> r103 = r101.getAll();
        if (r103 == null) goto L38;
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, ?>> r105 = r103.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, ?> r106 = r105.next();
        if (StringsKt.startsWith$default(r106.getKey(), r102, false, 2, null) == false) goto L10;
        r104.put(r106.getKey(), r106.getValue());
        goto L10
    L14:
        Set r107 = r104.keySet();
        ArrayList<ConcurrentHashMap<String, AtomicLong>> r108 = b.f574088a;
        LinkedHashMap r109 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));
        Iterator r110 = r104.entrySet().iterator();
    L16:
        if (r110.hasNext() == false) goto L18;
        Map.Entry r111 = (Map.Entry) r110.next();
        r109.put(StringsKt.removePrefix((String) r111.getKey(), r102 + "##"), r111.getValue());
        goto L16
    L18:
        b.b(r109, ((ApiStatistics) ListProtector.get(b.f574090c, this.f574087a)).getType());
        Iterator r112 = r107.iterator();
    L20:
        if (r112.hasNext() == false) goto L40;
        b.f574089b.remove((String) r112.next());
        goto L20
    L40:
        return;
    L38:
        return;
    L22:
        ConcurrentHashMap r113 = (ConcurrentHashMap) CollectionsKt.getOrNull(b.f574088a, this.f574087a);
        if (r113 == null) goto L39;
        LinkedHashMap r114 = new LinkedHashMap(MapsKt.mapCapacity(r113.size()));
        Iterator r115 = r113.entrySet().iterator();
    L26:
        if (r115.hasNext() == false) goto L28;
        Map.Entry r116 = (Map.Entry) r115.next();
        r114.put(r116.getKey(), Long.valueOf(((AtomicLong) r116.getValue()).get()));
        goto L26
    L28:
        b.b(r114, ((ApiStatistics) ListProtector.get(b.f574090c, this.f574087a)).getType());
        r113.clear();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
