package zz5;

import android.os.Message;
import com.bytedance.helios.api.config.ApiStatistics;
import com.bytedance.helios.common.utils.d;
import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.bytedance.helios.sdk.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import gz5.y;
import hz5.k;
import hz5.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import jz5.g;
import jz5.h;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements gz5.a.InterfaceC6085a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<ConcurrentHashMap<String, AtomicLong>> f574088a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f574089b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<ApiStatistics> f574090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f574091d = null;

    /* JADX INFO: loaded from: classes19.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f574092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f574093b;

        public a(int r100, String r101) {
            this.f574092a = r100;
            this.f574093b = r101;
        }

        public final void a() {
            ArrayList<ConcurrentHashMap<String, AtomicLong>> r100 = b.f574088a;
            String r101 = b.c(new Object[]{((ApiStatistics) ListProtector.get(b.f574090c, this.f574092a)).getType(), Integer.valueOf(this.f574092a), Boolean.valueOf(p.f245593n.e()), this.f574093b});
            h r102 = b.f574089b;
            long r103 = r102.getLong(r101) + 1;
            r102.putLong(r101, r103);
            k.b("Helios-Frequency-Manager", "store local " + r101 + " = " + r103);
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

    public b() {
    }

    static {
        f574091d = new b();
        f574088a = new ArrayList();
        g r100 = HeliosEnvImpl.get().f245478u;
        if (r100 == null) goto L5;
        com.bytedance.timon_monitor_impl.c r101 = r100.b("helios_api_statistics_repo");
    L6:
        f574089b = r101;
        f574090c = CollectionsKt.emptyList();
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static String c(Object... r110) {
        if (HeliosEnvImpl.get().f245470m.u() == true) goto L5;
        int r100 = r110.length;
        String r101 = "";
        int r102 = 0;
    L8:
        if (r102 >= r100) goto L11;
        r101 = (r101 + r110[r102]) + "##";
        r102 = r102 + 1;
        goto L8
    L11:
        return StringsKt.removeSuffix(r101, "##");
    L5:
        return ((StringBuilder) ArraysKt.joinTo$default(r110, new StringBuilder(), "##", null, null, 0, null, null, 124, null)).toString();
    }

    @Override // gz5.a.InterfaceC6085a
    public final void onNewSettings(y r110) {
        h r100 = f574089b;
        int r101 = 0;
        if (r100 == null) goto L16;
        Map<String, ?> r102 = r100.getAll();
        if (r102 == null) goto L16;
        Iterator<Map.Entry<String, ?>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<String, ?> r104 = r103.next();
        List r105 = StringsKt.split$default(r104.getKey(), new String[]{"##"}, false, 4, 2, null);
        if (r105.size() < 4) goto L8;
        String r106 = (String) ListProtector.get(r105, 0);
        String r107 = (String) ListProtector.get(r105, 3);
        boolean r108 = Boolean.parseBoolean((String) ListProtector.get(r105, 2));
        Object r109 = r104.getValue();
        if (r109 == null) goto L15;
        l.b(hz5.a.b(r106, r107, r108, ((Long) r109).longValue()));
        goto L8
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    L16:
        h r111 = f574089b;
        if (r111 == null) goto L19;
        r111.clear();
    L19:
        int r112 = f574088a.size();
        int r113 = 0;
    L20:
        if (r113 >= r112) goto L22;
        k.b("Helios-Frequency-Manager", "stop timer: group=" + r113);
        d.f().removeMessages(r113, "statistics");
        r113 = r113 + 1;
        goto L20
    L22:
        f574088a.clear();
        List<ApiStatistics> r114 = r110.g();
        f574090c = r114;
        int r115 = r114.size();
    L23:
        if (r101 >= r115) goto L25;
        f574088a.add(new ConcurrentHashMap());
        r101 = r101 + 1;
        goto L23
    }

    public static final void b(Map r100, String r110) {
        Iterator r101 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Map.Entry r102 = (Map.Entry) r101.next();
        long r103 = ((Number) r102.getValue()).longValue();
        if (r103 <= 0) goto L4;
        List r104 = StringsKt.split$default((CharSequence) r102.getKey(), new String[]{"##"}, false, 2, 2, null);
        if (r104.size() < 2) goto L4;
        l.b(hz5.a.b(r110, (String) ListProtector.get(r104, 1), Boolean.parseBoolean((String) ListProtector.get(r104, 0)), r103));
        goto L4
    }

    public static void d(int r100, String r101) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (d.f().hasMessages(r100, "statistics") == true) goto L8;
        k.b("Helios-Frequency-Manager", "start timer: group=" + r100);
        Message r102 = Message.obtain(d.f(), new zz5.a(r100));
        r102.what = r100;
        r102.obj = "statistics";
        d.f().sendMessageDelayed(r102, ((ApiStatistics) ListProtector.get(f574090c, r100)).d());
    L8:
        if (((ApiStatistics) ListProtector.get(f574090c, r100)).b() == true) goto L10;
    L12:
        String r103 = c(new Object[]{Boolean.valueOf(p.f245593n.e()), r101});
        ArrayList<ConcurrentHashMap<String, AtomicLong>> r104 = f574088a;
        AtomicLong r105 = (AtomicLong) ((ConcurrentHashMap) ListProtector.get(r104, r100)).get(r103);
        if (r105 != null) goto L16;
        r105 = new AtomicLong(0);
    L16:
        r105.incrementAndGet();
        ((Map) ListProtector.get(r104, r100)).put(r103, r105);
        k.b("Helios-Frequency-Manager", "store memory " + r100 + ' ' + r103 + " = " + r105.get());
        return;
    L10:
        if (f574089b == null) goto L12;
        d.f().post(new a(r100, r101));
    }
}
