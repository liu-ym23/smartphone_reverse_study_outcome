package eq7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements gq7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LinkedHashMap<Long, Long>> f473538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LinkedHashMap<Long, Long>> f473539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<LinkedHashMap<Long, Long>> f473540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f473541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Integer> f473542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f473543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f473544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f473545h;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("ProcTimeInStateInfo{freqTimeMapList=");
        r100.append(this.f473538a);
        r100.append(", freqDeltaTimeMapList=");
        r100.append(this.f473539b);
        r100.append(", totalCpuTime=");
        if (this.f473543f != 0) goto L5;
        this.f473543f = a(this.f473538a);
    L5:
        r100.append(this.f473543f);
        r100.append(", totalDeltaCpuTime=");
        if (this.f473544g != 0) goto L8;
        this.f473544g = a(this.f473539b);
    L8:
        r100.append(this.f473544g);
        r100.append(", totalMergeCpuTime=");
        if (this.f473545h != 0) goto L11;
        this.f473545h = a(this.f473540c);
    L11:
        r100.append(this.f473545h);
        r100.append('}');
        return r100.toString();
    }

    public e() {
        this.f473538a = new ArrayList();
        this.f473539b = new ArrayList();
        this.f473540c = new ArrayList();
        this.f473541d = false;
        this.f473543f = 0;
        this.f473544g = 0;
        this.f473545h = 0;
    }

    public final long a(List<LinkedHashMap<Long, Long>> r110) {
        if (this.f473541d == false) goto L5;
    L21:
        long r100 = 0;
        if (r110 == null) goto L34;
        ArrayList r101 = (ArrayList) r110;
        if (r101.isEmpty() == true) goto L34;
        int r102 = r101.size();
        if (r102 != this.f473542e.size()) goto L34;
        int r103 = 0;
    L28:
        if (r103 >= r102) goto L34;
        int r104 = ((Integer) ListProtector.get(this.f473542e, r103)).intValue();
        Iterator r105 = ((LinkedHashMap) ListProtector.get(r110, r103)).entrySet().iterator();
    L31:
        if (r105.hasNext() == false) goto L33;
        r100 = r100 + (((Long) ((Map.Entry) r105.next()).getValue()).longValue() * ((long) r104));
        goto L31
    L33:
        r103 = r103 + 1;
    L34:
        return r100;
    L5:
        monitor-enter(com.bytedance.watson.assist.utils.a.class);
        List<Integer> r106 = com.bytedance.watson.assist.utils.a.f272584c;     // Catch: Throwable -> L18
        if (r106 == null) goto L10;
        monitor-exit(com.bytedance.watson.assist.utils.a.class);
    L17:
        this.f473542e = r106;
        this.f473541d = true;
        goto L21
    L10:
        List<com.bytedance.watson.assist.utils.a.e> r107 = com.bytedance.watson.assist.utils.a.a();     // Catch: Throwable -> L18
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<com.bytedance.watson.assist.utils.a.e> r109 = r107.iterator();     // Catch: Throwable -> L18
    L12:
        if (r109.hasNext() == false) goto L14;
        r108.add(Integer.valueOf(r109.next().f272588b.size()));     // Catch: Throwable -> L18
        goto L12
    L14:
        com.bytedance.watson.assist.utils.a.f272584c = r108;     // Catch: Throwable -> L18
        monitor-exit(com.bytedance.watson.assist.utils.a.class);
        r106 = r108;
    L18:
        th = move-exception;
        throw th;
    }
}
