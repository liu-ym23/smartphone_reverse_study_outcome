package cq1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BusinessConfigure> f464763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<BusinessConfigure> f464764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<BusinessConfigure> f464765c;

    /* JADX INFO: renamed from: cq1.a$a, reason: collision with other inner class name */
    public static final class C5570a<T> implements Comparator<T> {
        public C5570a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((BusinessConfigure) r100).delayMills), Long.valueOf(((BusinessConfigure) r101).delayMills));
        }
    }

    public static final class b {
    }

    static {
    }

    public a(List<? extends BusinessConfigure> r110) {
        this.f464763a = new ArrayList();
        this.f464764b = new LinkedList();
        this.f464765c = new LinkedList();
        if (r110 == null) goto L25;
        Iterator<T> r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L25;
        BusinessConfigure r100 = (BusinessConfigure) r111.next();
        if (r100.resourceConfig == null) goto L6;
        if (r100.displaySecond != 0) goto L12;
        r100.displaySecond = 5;
    L12:
        long r101 = r100.deliveryType;
        if (r101 == BusinessConfigure.DeliveryType.ENTER) goto L15;
        if (r101 != BusinessConfigure.DeliveryType.TIMING) goto L6;
        long r102 = r100.preciseTime;
        if (r102 <= 0) goto L6;
        long r103 = 1000;
        if (((r102 * r103) - e.a()) <= 0) goto L6;
        long r104 = (r100.preciseTime * r103) - e.a();
        r100.remainDelayMills = r104;
        r100.delayMills = r104;
        ((ArrayList) this.f464763a).add(r100);
        goto L6
    L15:
        if (r100.delaySecond != 0) goto L17;
        r100.delaySecond = 2;
    L17:
        long r105 = ((long) r100.delaySecond) * 1000;
        r100.remainDelayMills = r105;
        r100.delayMills = r105;
        ((ArrayList) this.f464763a).add(r100);
    L25:
        ArrayList r112 = (ArrayList) this.f464763a;
        if (r112.size() <= 1) goto L28;
        CollectionsKt.sortWith(r112, new C5570a());
    L28:
        ALogger.i("BusinessConfigure", "business waiting list " + this.f464763a);
    }
}
