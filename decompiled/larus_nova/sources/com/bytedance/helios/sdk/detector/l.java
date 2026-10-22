package com.bytedance.helios.sdk.detector;

import android.media.AudioRecord;
import android.os.Message;
import androidx.collection.ArrayMap;
import com.bytedance.helios.api.consumer.AnchorExtra;
import com.bytedance.helios.api.consumer.ClosureExtra;
import com.bytedance.helios.api.consumer.ControlExtra;
import com.bytedance.helios.api.consumer.FrequencyExtra;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TypeCastException;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends com.bytedance.helios.sdk.detector.b implements nz5.m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f245530d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<PrivacyEvent> f245531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f245532c;

    public static final class a {
    }

    public interface b {
        void a();

        void b(long r100);

        void c(long r100, PrivacyEvent r101);
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrivacyEvent f245533a;

        @Override // java.lang.Runnable
        public final void run() {
            hz5.j r100 = hz5.l.f487701d;     // Catch: Throwable -> L12
            if (r100 == null) goto L5;
            List<hz5.i> r101 = r100.getJsbEvents();     // Catch: Throwable -> L12
        L6:
            if (r101 != null) goto L8;
        L10:
            this.f245533a.D = "";     // Catch: Throwable -> L12
            return;
        L8:
            if ((!r101.isEmpty()) != true) goto L10;
            PrivacyEvent r102 = this.f245533a;     // Catch: Throwable -> L12
            r102.D = PrefetchTiming.JSB;     // Catch: Throwable -> L12
            r102.E = r101;     // Catch: Throwable -> L12
            return;
        L5:
            r101 = null;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }

        public c(PrivacyEvent r100) {
            this.f245533a = r100;
        }
    }

    public abstract List<Integer> j(int r100);

    public abstract String k();

    static {
        f245530d = new String[]{"FORE_START_FORE_END", "FORE_START_BACK_END", "BACK_START_FORE_END", "BACK_START_BACK_END"};
    }

    @Override // nz5.m
    public final void a() {
        this.f245531b.clear();
        b r100 = this.f245532c;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public l() {
        this.f245531b = new CopyOnWriteArrayList();
        String r100 = k();
        nz5.b r101 = nz5.b.f521421c;
        monitor-enter(r101);
        ArrayMap<String, nz5.m> r102 = new ArrayMap(nz5.b.f521419a);     // Catch: Throwable -> L7
        r102.put(r100, this);     // Catch: Throwable -> L7
        nz5.b.f521419a = r102;     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // nz5.m
    public final List<PrivacyEvent> b() {
        return this.f245531b;
    }

    public final void h(k r100) {
        String r101 = r100.getResourceId();
        String r102 = r100.b();
        int[] r103 = r100.a();
        int[] r104 = r100.getTypes();
        int r105 = r103.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        int r107 = r103[r106];
        ApiConfig r108 = new ApiConfig(r101, r102, r107, r104[r106]);
        this.f245516a.put(r107, r108);
        r106 = r106 + 1;
        goto L3
    }

    public final void i(PrivacyEvent r110) {
        CopyOnWriteArrayList<nz5.g> r100 = nz5.h.f521423b;
        long r101 = l(r110);
        r110.f245365b = k();
        if ((!r110.f245372i) == false) goto L5;
        String r102 = "FORE_START";
    L6:
        r110.f245373j = r102;
        r110.f245380q = r101;
        r110.f245383t = 0;
        r110.f245377n.put("runtimeObjHashCode", Long.valueOf(r101));
        AnchorExtra r103 = new AnchorExtra(0, 0, null, null, 15, null);
        r110.B = r103;
        Set<Object> r104 = r103.getFloatingViewEvents();
        if (r104 == null) goto L9;
        r104.addAll(r100);
    L9:
        AnchorExtra r105 = r110.B;
        if (r105 == null) goto L15;
        Set<Object> r106 = r105.getHistoryFloatingViewEvents();
        if (r106 == null) goto L15;
        r106.addAll(r100);
    L15:
        if ((r110.f245389z.getThisOrClass() instanceof AudioRecord) == false) goto L21;
        Map<String, Object> r107 = r110.f245377n;
        Object r108 = r110.f245389z.getThisOrClass();
        if (r108 == null) goto L20;
        r107.put("audioSessionId", Integer.valueOf(((AudioRecord) r108).getAudioSessionId()));
        goto L21
    L20:
        throw new TypeCastException("null cannot be cast to non-null type android.media.AudioRecord");
    L21:
        hz5.l.f487699b.postDelayed(new c(r110), 50);
        return;
    L5:
        r102 = "BACK_START";
        goto L6
    }

    public long l(PrivacyEvent r100) {
        Object r101 = r100.f245389z.getThisOrClass();
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final void o(PrivacyEvent r110) {
        Iterator<PrivacyEvent> r100 = this.f245531b.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        PrivacyEvent r101 = r100.next();
        if (r101.C != null) goto L4;
        if (r101.f245380q != l(r110)) goto L4;
        r101.C = new ClosureExtra(r110.f245376m, 0, 2, null);
        goto L4
    }

    public final void n(ApiConfig r510, PrivacyEvent r511) {
        hz5.k.b("ClosureActionDetector", "sensitiveApiCalled: " + r510 + '/' + r511);
        int r100 = r510.f245513b;
        String r101 = "null cannot be cast to non-null type android.media.AudioRecord";
        String r102 = "";
        if (r100 != 0) goto L33;
        if (l(r511) == 0) goto L57;
        i(r511);
        Iterator<PrivacyEvent> r103 = this.f245531b.iterator();
    L9:
        if (r103.hasNext() == false) goto L17;
        PrivacyEvent r104 = r103.next();
        String r110 = r101;
        if (r511.f245380q != r104.f245380q) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L15;
        r101 = r110;
        goto L9
    L15:
        PrivacyEvent r106 = r104;
    L18:
        PrivacyEvent r107 = r106;
        if (r107 == null) goto L21;
        this.f245531b.remove(r107);
    L21:
        this.f245531b.add(r511);
        r511.toString();
        StringBuilder r108 = new StringBuilder("monitorTrigger factors=");
        r108.append(r511.f245366c);
        r108.append(" calledTime=");
        r108.append(r511.f245376m);
        r108.append(" runtimeObjHashcode=");
        r108.append(r511.f245380q);
        r108.append(" eventCurrentPageHashCode=");
        r108.append(r511.f245375l);
        if ((r511.f245389z.getThisOrClass() instanceof AudioRecord) == false) goto L28;
        StringBuilder r109 = new StringBuilder(" audioSessionId=");
        Object r111 = r511.f245389z.getThisOrClass();
        if (r111 == null) goto L27;
        r109.append(((AudioRecord) r111).getAudioSessionId());
        r102 = r109.toString();
        goto L28
    L27:
        throw new TypeCastException(r110);
    L28:
        r108.append(r102);
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", r108.toString());
        hz5.l.b(r511);
        b r112 = this.f245532c;
        if (r112 == null) goto L53;
        long r113 = r511.f245380q;
        String r114 = r511.f245364a;
        String r115 = r511.f245365b;
        int r116 = r511.f245366c;
        String r117 = r511.f245367d;
        String r118 = r511.f245368e;
        Throwable r119 = r511.f245369f;
        String r120 = r511.f245370g;
        String r121 = r511.f245371h;
        boolean r122 = r511.f245372i;
        String r123 = r511.f245373j;
        String r124 = r511.f245374k;
        int r125 = r511.f245375l;
        long r126 = r511.f245376m;
        Map<String, Object> r127 = r511.f245377n;
        String r128 = r511.f245378o;
        String r129 = r511.f245379p;
        boolean r130 = r511.f245381r;
        String r131 = r511.f245382s;
        int r132 = r511.f245383t;
        Set<String> r133 = r511.f245384u;
        String r134 = r511.f245385v;
        String r135 = r511.f245386w;
        boolean r136 = r511.f245387x;
        boolean r137 = r511.f245388y;
        ControlExtra r138 = r511.f245389z;
        FrequencyExtra r139 = r511.A;
        AnchorExtra r140 = r511.B;
        ClosureExtra r141 = r511.C;
        String r142 = r511.D;
        List<? extends Object> r143 = r511.E;
        String r144 = r511.F;
        List<String> r145 = r511.G;
        int r146 = r511.H;
        r511.getClass();
        r112.c(r113, new PrivacyEvent(r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r113, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, null, r511.I, r511.f245363J, r511.K, r511.L, r511.M, r511.N));
    L53:
        return;
    L13:
        r105 = false;
        goto L14
    L17:
        r110 = r101;
        r106 = null;
        goto L18
    L57:
        return;
    L33:
        if (r100 != 1) goto L48;
        long r147 = l(r511);
        List<Integer> r148 = j(r510.f245514c);
        StringBuilder r149 = new StringBuilder("monitorTrigger factors=");
        r149.append(r510.f245514c);
        r149.append(" calledTime=");
        r149.append(r511.f245376m);
        r149.append(" runtimeObjHashcode=");
        r149.append(r147);
        r149.append(" eventCurrentPageHashCode=");
        com.bytedance.helios.sdk.p r150 = com.bytedance.helios.sdk.p.f245593n;
        int r151 = r150.f245599f;
        if (r151 != 0) goto L37;
        r151 = r150.f245604k;
    L37:
        r149.append(r151);
        if ((r511.f245389z.getThisOrClass() instanceof AudioRecord) == false) goto L44;
        StringBuilder r152 = new StringBuilder(" audioSessionId=");
        Object r153 = r511.f245389z.getThisOrClass();
        if (r153 == null) goto L43;
        r152.append(((AudioRecord) r153).getAudioSessionId());
        r102 = r152.toString();
        goto L44
    L43:
        throw new TypeCastException("null cannot be cast to non-null type android.media.AudioRecord");
    L44:
        r149.append(r102);
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", r149.toString());
        m(r147, r148, r511);
        b r154 = this.f245532c;
        if (r154 == null) goto L54;
        r154.b(r147);
        return;
    L54:
        return;
    L48:
        if (r100 != 2) goto L56;
        long r155 = HeliosEnvImpl.get().f245470m.l().b();
        Map<String, Set<hz5.b>> r156 = hz5.l.f487698a;
        Message r157 = Message.obtain();
        r157.what = 1000;
        r157.obj = r511;
        hz5.l.f487699b.sendMessageDelayed(r157, r155);
        return;
    }

    public final void m(long r100, List r110, PrivacyEvent r111) {
        Objects.toString(r110);
        i(r111);
        int r101 = this.f245531b.size() - 1;
    L3:
        if (r101 < 0) goto L19;
        PrivacyEvent r102 = this.f245531b.get(r101);
        if (r102.f245380q != r100) goto L18;
        if (r110.contains(Integer.valueOf(r102.f245366c)) == false) goto L18;
        hz5.k.d("Helios-Log-Monitor-Ability-Api-Call", "removeEndApiCallTrace eventId=" + r111.f245366c + " eventName=" + r102.f245367d + " calledTime=" + r111.f245376m + " eventStartTime=" + r102.f245376m);
        int r103 = (((!r102.f245372i ? 1 : 0) ^ 1) << 1) | ((!com.bytedance.helios.sdk.p.f245593n.d() ? 1 : 0) ^ 1);
        ClosureExtra r104 = r102.C;
        if (r104 == null) goto L11;
        r104.setRealCloseTime(r111.f245376m);
    L11:
        r102.f245373j = f245530d[r103];
        r102.f245370g = r102.f245370g + r111.f245370g;
        r102.f245381r = r111.f245381r;
        r102.f245383t = 1;
        AnchorExtra r105 = r102.B;
        if (r105 == null) goto L14;
        int r106 = r105.getAnchorCheckCount();
    L15:
        if (r106 <= 0) goto L17;
        r102.f245384u.add("pair_delay_close");
        r102.f245384u.remove("pair_not_close");
        hz5.l.b(r102);
    L17:
        this.f245531b.remove(r101);
        goto L18
    L14:
        r106 = 0;
    L18:
        r101 = r101 - 1;
        goto L3
    L19:
        hz5.l.b(r111);
    }
}
