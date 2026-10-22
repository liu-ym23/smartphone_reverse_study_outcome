package es3;

import android.os.Build;
import android.view.FrameMetrics;
import com.bytedance.apm.constant.FilterTypeStringDef;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends es3.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f473703e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<et3.h> f473704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, b> f473705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f473706d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f473707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f473708b;

        public a() {
            this.f473707a = 0;
            this.f473708b = 0;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f473709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f473710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f473711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f473712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f473713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f473714f;

        public final String toString() {
            return "visibleScene=" + this.f473709a + ", sumFrame=" + this.f473711c + ", sumDroppedFrames=" + this.f473712d + ", sumFrameCost=" + this.f473710b + ", dropLevel=" + Arrays.toString(this.f473713e);
        }

        public b(String r100) {
            this.f473711c = 0;
            this.f473709a = r100;
            int r101 = com.bytedance.apm.util.i.f190670b - 1;
            this.f473714f = r101;
            this.f473713e = new int[(r101 - 0) + 1];
        }
    }

    public e() {
        this.f473704b = new ArrayList();
        this.f473705c = new HashMap();
        this.f473706d = new a();
        h.f473717z.f473723f = true;
        et3.c.f473889n = true;
    }

    @Override // com.bytedance.apm.block.a
    public final void f(String r100, long r101) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        h(r100, r101);
        int r102 = 0;
    L6:
        if (r102 >= this.f473704b.size()) goto L10;
        ((et3.h) ListProtector.get(this.f473704b, r102)).a(r101);
        r102 = r102 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.apm.block.a
    public final void g(String r100, FrameMetrics r101) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        int r102 = 0;
        long r103 = (((((r101.getMetric(0) + r101.getMetric(1)) + r101.getMetric(2)) + r101.getMetric(3)) + r101.getMetric(4)) + r101.getMetric(5)) / 1000000;
        h(r100, r103);
    L6:
        if (r102 >= this.f473704b.size()) goto L10;
        ((et3.h) ListProtector.get(this.f473704b, r102)).a(r103);
        r102 = r102 + 1;
        goto L6
    L10:
        return;
    }

    public final void h(String r110, long r111) {
        if (f473703e == true) goto L5;
        return;
    L5:
        if (r111 <= 0) goto L31;
        b r100 = this.f473705c.get(r110);
        if (r100 != null) goto L10;
        r100 = new b(r110);
        this.f473705c.put(r110, r100);
    L10:
        float r101 = com.bytedance.apm.util.i.f190669a;
        r100.f473710b += r111;
        int r112 = Math.min(Math.max((int) (r111 / r101), 0), r100.f473714f);
        int[] r102 = r100.f473713e;
        r102[r112] = r102[r112] + 1;
        r100.f473712d += r112;
        r100.f473711c++;
        if (r100.f473710b < 10000) goto L30;
        this.f473705c.remove(r110);
        float r113 = com.bytedance.apm.util.i.f190669a;     // Catch: Throwable -> L23
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L23
        int r114 = 0;
    L15:
        if (r114 > r100.f473714f) goto L20;
        if (r100.f473713e[r114] <= 0) goto L19;
        r103.put(String.valueOf(r114), r100.f473713e[r114]);     // Catch: Throwable -> L23
    L19:
        r114 = r114 + 1;     // Catch: Throwable -> L23
        goto L15
    L20:
        int r115 = r100.f473711c;     // Catch: Throwable -> L23
        int r104 = ((r115 * 100) * com.bytedance.apm.util.i.f190670b) / (r115 + r100.f473712d);     // Catch: Throwable -> L23
        et3.b r116 = et3.b.C5816b.f473888a;     // Catch: Throwable -> L23
        r116.getClass();     // Catch: Throwable -> L23
        bt3.b.d.f20539a.e(new et3.a(r116, r100.f473709a, null, (float) (((double) r104) / 100.0d)));     // Catch: Throwable -> L23
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L23
        r105.put("scene", r100.f473709a);     // Catch: Throwable -> L23
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L23
        r106.put("total_scroll_time", r100.f473710b);     // Catch: Throwable -> L23
        r106.put("drop_time_rate", 1.0f - ((r100.f473711c * 1.0f) / ((int) (r100.f473710b / r113))));     // Catch: Throwable -> L23
        r106.put("refresh_rate", r100.f473714f + 1);     // Catch: Throwable -> L23
        is3.a.h().b(new js3.e(FilterTypeStringDef.FPS_DROP, r100.f473709a, r103, r105, r106));     // Catch: Throwable -> L23
    L21:
        r100.f473711c = 0;
        r100.f473712d = 0;
        r100.f473710b = 0;
        return;
    L30:
        return;
    }

    @Override // com.bytedance.apm.block.a
    public final void e(String r100, long r101, long r102) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return;
    L5:
        long r103 = r102 - r101;
        h(r100, r103);
        int r104 = 0;
    L7:
        if (r104 >= this.f473704b.size()) goto L9;
        ((et3.h) ListProtector.get(this.f473704b, r104)).a(r103);
        r104 = r104 + 1;
        goto L7
    }
}
