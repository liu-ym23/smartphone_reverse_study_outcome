package cp7;

import android.view.View;
import com.bytedance.ugc.glue.UGCTools;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import dp7.e;
import dp7.f;
import dp7.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<c.a> f464706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<c.a> f464707b = null;

    /* JADX INFO: renamed from: cp7.a$a, reason: collision with other inner class name */
    public static final class RunnableC5564a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cp7.b f464708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f464709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f464710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c.AbstractC5566c f464711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c.d f464712e;

        public final void a() {
            long r100 = System.currentTimeMillis();
            cp7.b r101 = this.f464708a;
            View r102 = this.f464709b;
            String r103 = this.f464710c;
            c.AbstractC5566c r104 = this.f464711d;
            int r105 = r101.f464722d - 1;
            int r106 = r101.f464719a;
            int r107 = (r105 / r106) + 1;
            int r110 = ((r101.f464721c - 1) / r106) + 1;
            int r108 = r107 * r110;
            int[] r111 = new int[r108];
            Iterator<Integer[]> r112 = r101.f464720b.iterator();
        L4:
            if (r112.hasNext() == false) goto L15;
            Integer[] r113 = r112.next();
            int r109 = Math.max(0, r113[0].intValue() / r101.f464719a);
            Iterator<Integer[]> r114 = r112;
            int r115 = Math.max(0, r113[1].intValue() / r101.f464719a);
            long r116 = r100;
            int r117 = Math.min(r110 - 1, r113[2].intValue() / r101.f464719a);
            int r118 = Math.min(r107 - 1, r113[3].intValue() / r101.f464719a);
            if (r115 > r118) goto L14;
        L7:
            if (r109 > r117) goto L12;
            int r119 = r109;
        L9:
            r111[(r115 * r110) + r119] = r113[4].intValue();
            if (r119 == r117) goto L12;
            r119 = r119 + 1;
        L12:
            if (r115 == r118) goto L14;
            r115 = r115 + 1;
        L14:
            r112 = r114;
            r100 = r116;
            goto L4
        L15:
            long r120 = r100;
            int r121 = 0;
            int r122 = 0;
        L16:
            if (r121 >= r108) goto L24;
            if (r111[r121] != 1) goto L20;
            boolean r123 = true;
        L21:
            if (r123 == false) goto L23;
            r122 = r122 + 1;
        L23:
            r121 = r121 + 1;
            goto L16
        L20:
            r123 = false;
            goto L21
        L24:
            r104.a(r102, r103, r108, r122);
            c.d r124 = this.f464712e;
            if (r124 == null) goto L27;
            r124.a(this.f464710c, System.currentTimeMillis() - r120);
        L27:
            int r125 = c.f464723a;
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

        public RunnableC5564a(cp7.b r100, View r101, String r102, JSONObject r103, c.AbstractC5566c r104, c.d r105) {
            this.f464708a = r100;
            this.f464709b = r101;
            this.f464710c = r102;
            this.f464711d = r104;
            this.f464712e = r105;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f464713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f464714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c.a f464715c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f464716d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c.AbstractC5566c f464717e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c.d f464718f;

        public final void a() {
            long r100 = System.currentTimeMillis();
            c.AbstractC5566c r101 = this.f464717e;
            c.d r102 = null;
            if (r101 == null) goto L5;
            c.AbstractC5566c r110 = r101;
        L6:
            if (r110 == null) goto L15;
            c.d r103 = this.f464718f;
            if (r103 == null) goto L10;
            r102 = r103;
        L11:
            cp7.b r104 = new cp7.b(this.f464713a.getWidth(), this.f464713a.getHeight());
            List<c.a> r105 = a.f464706a;
            View r111 = this.f464713a;
            a.a(r104, r111, 0, 0, 0, 0, r111.getWidth(), this.f464713a.getHeight(), this.f464715c);
            UGCTools.mainHandler.post(new RunnableC5564a(r104, this.f464713a, this.f464714b, this.f464716d, r110, r102));
            if (r102 == null) goto L16;
            r102.b(System.currentTimeMillis() - r100);
            return;
        L16:
            return;
        L10:
            List<c.a> r106 = a.f464706a;
            goto L11
        L15:
            return;
        L5:
            List<c.a> r107 = a.f464706a;
            r110 = null;
            goto L6
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

        public b(LynxView r100, c.a r101, JSONObject r102, c.AbstractC5566c r103, c.d r104) {
            this.f464713a = r100;
            this.f464714b = "";
            this.f464715c = r101;
            this.f464716d = r102;
            this.f464717e = r103;
            this.f464718f = r104;
        }
    }

    static {
        f464706a = CollectionsKt.mutableListOf(new c.a[]{f.f469612a, dp7.d.f469610a, dp7.b.f469608a, dp7.c.f469609a, g.f469613a, e.f469611a, dp7.a.f469607a});
        f464707b = new CopyOnWriteArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(cp7.b r110, View r111, int r112, int r113, int r114, int r115, int r116, int r117, c.a r210) {
        if (r210 == null) goto L8;
        if (r210.a(r110, r111, r112, r113, r114, r115, r116, r117, r210) != true) goto L8;
        return;
    L8:
        if ((r111 instanceof c.b) == false) goto L11;
        r110.a(r114, r115, r116, r117, ((c.b) r111).a());
        return;
    L11:
        Iterator<c.a> r118 = f464707b.iterator();
    L13:
        if (r118.hasNext() == false) goto L17;
        if (r118.next().a(r110, r111, r112, r113, r114, r115, r116, r117, r210) == false) goto L13;
        return;
    L17:
        Iterator<c.a> r119 = f464706a.iterator();
    L19:
        if (r119.hasNext() == false) goto L22;
        if (r119.next().a(r110, r111, r112, r113, r114, r115, r116, r117, r210) == false) goto L19;
        return;
    }
}
