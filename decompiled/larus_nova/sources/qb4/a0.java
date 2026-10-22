package qb4;

import android.app.Activity;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a0 f532294c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f532295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<sb4.k> f532296b;

    public class a implements ec4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f532297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f532298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f532299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Map f532300d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a0 f532301e;

        @Override // ec4.c
        public final void a(xb4.a r100) {
            int r101 = this.f532301e.f532295a;
            Objects.toString(r100);
            int r102 = n.f532367a;
            int r103 = r100.f563110a;
            if (r103 != 200) goto L5;
            d.a r104 = (d.a) this.f532297a;
            r104.f532335c.f532330a.onSuccess(r104.f532333a, r104.f532334b);
            EventReport.T(0, "", r104.f532335c.f532331b);
            return;
        L5:
            a0 r105 = this.f532301e;
            int r106 = r105.f532295a;
            if (r106 >= 1) goto L8;
            r105.f532295a = r106 + 1;
            r105.b(this.f532298b, this.f532299c, this.f532300d, this.f532297a);
            return;
        L8:
            a0.a(r105, this.f532298b, this.f532299c, this.f532300d, r103, r100.f563112c, this.f532297a);
        }

        @Override // ec4.c
        public final void onError(Throwable r100) {
            int r101 = this.f532301e.f532295a;
            Objects.toString(r100);
            int r102 = n.f532367a;
            a0 r103 = this.f532301e;
            int r104 = r103.f532295a;
            if (r104 >= 1) goto L5;
            r103.f532295a = r104 + 1;
            r103.b(this.f532298b, this.f532299c, this.f532300d, this.f532297a);
            return;
        L5:
            a0.a(r103, this.f532298b, this.f532299c, this.f532300d, 3, "", this.f532297a);
        }

        public a(a0 r100, b r101, String r102, Map r103, Map r104) {
            this.f532301e = r100;
            this.f532297a = r101;
            this.f532298b = r102;
            this.f532299c = r103;
            this.f532300d = r104;
        }
    }

    public interface b {
    }

    public a0() {
        this.f532295a = 0;
    }

    public final void b(String r100, Map<String, String> r110, Map<String, String> r111, b r112) {
        HashMap r101 = new HashMap();
        r101.put("Content-Type", "application/json; charset=utf-8");
        new ec4.j(r100, r110, r111, r101).c(new a(this, r112, r100, r110, r111));
    }

    public static void a(a0 r110, String r111, Map r112, Map r113, int r114, String r115, b r116) {
        r110.getClass();
        BdTuringConfig r100 = qb4.b.c.f532315a.f532302a;
        if (r100 == null) goto L5;
        Activity r101 = r100.getTopActivity();
    L6:
        if (r101 != null) goto L13;
        ((d.a) r116).a(r114, r115);
        return;
    L13:
        r101.runOnUiThread(new b0(r110, r101, r116, r114, r115, r111, r112, r113));     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        ((d.a) r116).a(r114, r115);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
