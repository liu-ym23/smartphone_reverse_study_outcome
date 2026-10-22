package iu3;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f495773d;

    public final void a() {
        this.f495773d.getClass();
        d r100 = this.f495773d;
        r100.getClass();
        long r101 = System.currentTimeMillis();
        e r102 = e.a.f495788a;
        ku3.a r103 = r100.f495776b;
        if (xu3.a.getContext() != null) goto L91;
    L11:
        Debug.MemoryInfo r104 = null;
    L13:
        if (r104 == null) goto L17;
        long r310 = ((long) r104.dalvikPss) * 1024;
        if (r310 < 0) goto L17;
        uu3.a r110 = (uu3.a) qu3.c.a(uu3.a.class);
        long r105 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (r105 <= 0) goto L21;
        double r111 = new BigDecimal(r105).divide(new BigDecimal(Runtime.getRuntime().maxMemory()), 4, 4).doubleValue();
    L22:
        double r311 = r111;
        long r112 = r102.c();
        long r113 = r102.d();
        long r210 = r102.a();
        long r211 = r102.b();
        boolean r212 = !r110.isForeground();
        long r213 = ((long) r104.nativePss) * 1024;
        long r214 = ((long) r104.getTotalPss()) * 1024;
        if (Build.VERSION.SDK_INT < 23) goto L31;
        String r106 = r104.getMemoryStat("summary.graphics");
        if (TextUtils.isEmpty(r106) == true) goto L31;
        long r107 = ((long) CastIntegerProtector.parseInt(r106)) * 1024;
        String r108 = "APM-Memory";
        int r109 = 1;
    L33:
        Object[] r114 = new Object[r109];
        r114[0] = Integer.valueOf(Process.myPid());
        String[] r115 = f.a(String.format("/proc/%s/status", r114)).trim().split("\n");     // Catch: Exception -> L50
        int r116 = r115.length;     // Catch: Exception -> L50
        int r117 = 0;
    L37:
        if (r117 >= r116) goto L45;
        String r118 = r115[r117];     // Catch: Exception -> L50
        int r312 = r116;
        if (r118.startsWith("VmSize") == false) goto L43;
        Matcher r119 = PatternProtector.compile("\\d+").matcher(r118);     // Catch: Exception -> L50
        if (r119.find() == false) goto L43;
        long r120 = CastLongProtector.parseLong(r119.group());     // Catch: Exception -> L50
    L52:
        long r121 = r120 * 1024;
        if (r121 <= 0) goto L55;
        long r313 = r121;
    L56:
        double r122 = r103.f506204b;
        if (r122 > 0.5d) goto L61;
        r122 = 0.8d;
    L61:
        if (r311 <= r122) goto L63;
        boolean r314 = true;
    L64:
        mu3.a r123 = new mu3.a(r112, r113, r210, r211, r212, r213, r214, r105, r310, r107, r313, r311, r314, r103.f506206d);
    L65:
        if (r123 == null) goto L67;
        r123.f515744p = null;
        if (xu3.a.a() == false) goto L73;
        av3.b.a(r108, String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(r100.f495776b.f506207e), Long.valueOf(System.currentTimeMillis() - r101), r123.a().toString()}));
    L73:
        if (r100.f495776b.f506207e == false) goto L75;
        nu3.b.a(r123);
    L75:
        r100.f495776b.getClass();
        List<lu3.a> r124 = r100.f495781g;
        if (r124 != null) goto L78;
        return;
    L78:
        if (((CopyOnWriteArrayList) r124).size() <= 0) goto L101;
        ju3.a r125 = r123.g();     // Catch: Exception -> L85
        Iterator r126 = ((CopyOnWriteArrayList) r100.f495781g).iterator();     // Catch: Exception -> L85
    L81:
        if (r126.hasNext() == false) goto L103;
        ((lu3.a) r126.next()).a(r125);     // Catch: Exception -> L85
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L67:
        if (xu3.a.a() == false) goto L84;
        av3.b.a(r108, "collectWithConfig return is null");
        return;
    L84:
        return;
    L63:
        r314 = false;
        goto L64
    L55:
        r313 = -1;
    L43:
        r117 = r117 + 1;     // Catch: Exception -> L50
        r116 = r312;
        goto L37
    L45:
        if (r115.length <= 12) goto L51;
        Matcher r127 = PatternProtector.compile("\\d+").matcher(r115[12]);     // Catch: Exception -> L50
        if (r127.find() == false) goto L51;
        r120 = CastLongProtector.parseLong(r127.group());     // Catch: Exception -> L50
    L51:
        r120 = -1;
    L29:
        e = move-exception;
        r108 = "APM-Memory";
        av3.b.c(r108, "getGraphics", e);
        e.printStackTrace();
    L32:
        r109 = 1;
        r107 = -1;
    L31:
        r108 = "APM-Memory";
        goto L32
    L21:
        r111 = -1.0d;
    L17:
        r108 = "APM-Memory";
        r123 = null;
        goto L65
    L91:
        ActivityManager r128 = (ActivityManager) xu3.a.getContext().getSystemService("activity");     // Catch: Exception -> L10
        if (r128 == null) goto L11;
        r104 = r128.getProcessMemoryInfo(new int[]{Process.myPid()})[0];     // Catch: Exception -> L10
        goto L13
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

    public c(d r100, long r101) {
        this.f495773d = r100;
        super(0, r101);
    }
}
