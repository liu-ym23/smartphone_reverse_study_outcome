package n4a;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public abstract class h3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f517341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f517342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, b> f517343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f517344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f517345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f517346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f517347g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h3 f517348a;

        public a(h3 r100) {
            this.f517348a = r100;
        }

        public final void a() {
            h3 r100 = this.f517348a;
            if (r100.f517342b == true) goto L5;
            return;
        L5:
            if (r100.f517346f == true) goto L7;
        L34:
            h3 r101 = this.f517348a;
            Handler r102 = r101.f517344d;
            if (r102 == null) goto L51;
            r102.postDelayed(r101.f517347g, 60000);
            return;
        L51:
            return;
        L7:
            if (r100.g() <= 0) goto L22;
            ((ConcurrentHashMap) r100.f517343c).size();
            if (r100.c() <= 0) goto L17;
            long r103 = SystemClock.elapsedRealtime();
            Iterator r104 = ((ConcurrentHashMap) r100.f517343c).entrySet().iterator();
        L12:
            if (r104.hasNext() == false) goto L17;
            Map.Entry r105 = (Map.Entry) r104.next();
            if ((r103 - ((b) ((ConcurrentHashMap) r100.f517343c).get(r105.getKey())).f517351c) <= r100.c()) goto L12;
            r104.remove();
        L17:
            if (((ConcurrentHashMap) r100.f517343c).size() <= r100.g()) goto L22;
            ArrayList r106 = new ArrayList(((ConcurrentHashMap) r100.f517343c).keySet());
            Collections.sort(r106, new g3(r100));
            int r107 = (int) r100.g();
        L20:
            if (r107 >= r106.size()) goto L22;
            ((ConcurrentHashMap) r100.f517343c).remove(ListProtector.get(r106, r107));
            r107 = r107 + 1;
        L22:
            StringBuilder r108 = new StringBuilder();
            Iterator r109 = ((ConcurrentHashMap) r100.f517343c).entrySet().iterator();
        L24:
            if (r109.hasNext() == false) goto L30;
            Map.Entry r110 = (Map.Entry) r109.next();
            r108.append(y4.d(t3.c((((String) r110.getKey()) + "," + ((b) r110.getValue()).f517349a + "," + ((b) r110.getValue()).f517350b + "," + ((b) r110.getValue()).f517351c).getBytes("UTF-8"), r100.f517345e)) + "\n");     // Catch: UnsupportedEncodingException -> L28
        L28:
            e = move-exception;
            e.printStackTrace();
            goto L24
        L30:
            String r111 = r108.toString();
            if (TextUtils.isEmpty(r111) == true) goto L33;
            j4.h(r100.f517341a, r111);
        L33:
            this.f517348a.f517346f = false;
            goto L34
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

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f517349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f517350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f517351c;

        public b(int r100, long r101, long r102) {
            this.f517349a = r100;
            this.f517350b = r101;
            this.f517351c = r102;
        }
    }

    public abstract void a(T r100, long r101);

    public abstract long c();

    public abstract String d(T r100);

    public final void e(T r110, long r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (h(r110) < 0) goto L17;
        String r100 = d(r110);
        b r101 = (b) ((ConcurrentHashMap) this.f517343c).get(r100);
        if (r101 != null) goto L10;
        a(r110, r111);
        Map<String, b> r102 = this.f517343c;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r100, new b(f(r110), h(r110), r111));
        this.f517346f = true;
        return;
    L10:
        r101.f517351c = r111;
        if (r101.f517349a == f(r110)) goto L14;
        a(r110, r111);
        r101.f517349a = f(r110);
        r101.f517350b = h(r110);
        this.f517346f = true;
        return;
    L14:
        a(r110, r101.f517350b);
        return;
    }

    public abstract int f(T r100);

    public abstract long g();

    public abstract long h(T r100);

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(List<T> r110) {
        long r100 = SystemClock.elapsedRealtime();
        ArrayList r111 = (ArrayList) r110;
        Iterator r101 = r111.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        e(r101.next(), r100);
        goto L4
    L7:
        if (((ConcurrentHashMap) this.f517343c).size() < r111.size()) goto L10;
        this.f517346f = true;
    L10:
        if (((ConcurrentHashMap) this.f517343c).size() <= 16384) goto L12;
    L13:
        ((ConcurrentHashMap) this.f517343c).clear();
        Iterator r112 = r111.iterator();
    L15:
        if (r112.hasNext() == false) goto L20;
        Object r102 = r112.next();
        Map<String, b> r103 = this.f517343c;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(d(r102), new b(f(r102), h(r102), r100));
        goto L15
    L20:
        return;
    L12:
        if (g() <= 0) goto L13;
    }

    public h3(Context r110, String r111, Handler r112) {
        this.f517342b = false;
        this.f517343c = new ConcurrentHashMap();
        this.f517345e = null;
        this.f517347g = new a(this);
        if (r110 != null) goto L5;
        return;
    L5:
        this.f517344d = r112;
        if (TextUtils.isEmpty(r111) == false) goto L8;
        r111 = "unknow";
    L8:
        this.f517345e = j4.I(r110);
        this.f517341a = new PolarisFileWrapper(r110.getFilesDir().getPath(), r111);     // Catch: Throwable -> L11
    L32:
        Iterator r113 = ((ArrayList) j4.g(this.f517341a)).iterator();     // Catch: Throwable -> L29
    L14:
        if (r113.hasNext() == false) goto L43;
        String[] r114 = new String(t3.e(y4.e((String) r113.next()), this.f517345e), "UTF-8").split(",");     // Catch: Throwable -> L23
    L18:
        if (r114.length < 4) goto L20;
        long r100 = CastLongProtector.parseLong(r114[3]);     // Catch: Throwable -> L23
    L21:
        long r101 = r100;
        Map<String, b> r115 = this.f517343c;     // Catch: Throwable -> L23
        ConcurrentHashMap r116 = (ConcurrentHashMap) r115;     // Catch: Throwable -> L23
        r116.put(r114[0], new b(CastIntegerProtector.parseInt(r114[1]), CastLongProtector.parseLong(r114[2]), r101));     // Catch: Throwable -> L23
        goto L14
    L20:
        r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (this.f517341a.exists() == false) goto L27;
        this.f517341a.delete();     // Catch: Throwable -> L29
    L27:
        th.printStackTrace();     // Catch: Throwable -> L29
        goto L14
    L43:
        return;
    L29:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L32
    }
}
