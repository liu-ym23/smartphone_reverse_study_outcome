package com.bytedance.dataplatform;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f204358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f204359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f204360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f204361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set<String> f204362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f204363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f204364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f204365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f204366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Map<String, String>> f204367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f204368k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f204369a;

        @Override // java.lang.Runnable
        public final void run() {
            q r100 = this.f204369a;     // Catch: Throwable -> L4
            r100.a("ab_test_noapt_module_name", r100.f204368k);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(q r100) {
            this.f204369a = r100;
        }
    }

    public final void c() {
        if (this.f204360c.isEmpty() == true) goto L5;
    L11:
        boolean r100 = true;
        Set[] r101 = {this.f204360c, this.f204362e, this.f204361d, this.f204363f};
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L12:
        if (r103 >= 4) goto L23;
        Set r104 = r101[r103];
        if (r104 == null) goto L22;
        Iterator r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L22;
        if (r100 == false) goto L20;
        r100 = false;
    L21:
        r102.append((String) r105.next());
        goto L17
    L20:
        r102.append(',');
    L22:
        r103 = r103 + 1;
        goto L12
    L23:
        String r106 = r102.toString();
    L25:
        if (TextUtils.equals(r106, this.f204365h) == true) goto L35;
        this.f204365h = r106;
        s r107 = this.f204359b;
        if (r107 == null) goto L36;
        r107.a(r106);
        return;
    L36:
        return;
    L35:
        return;
    L5:
        if (this.f204362e.isEmpty() == false) goto L11;
        if (this.f204361d.isEmpty() == false) goto L11;
        if (this.f204363f.isEmpty() == false) goto L11;
        r106 = null;
        goto L25
    }

    public final void a(String r100, List<String> r101) {
        Map r102 = (Map) ((ConcurrentHashMap) this.f204367j).get(r100);
        Iterator r103 = r102.keySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        if (r101.contains(r104) == true) goto L4;
        ((ConcurrentSkipListSet) this.f204361d).remove(r102.get(r104));     // Catch: Throwable -> L9
        r102.remove(r104);     // Catch: Throwable -> L9
        w.a(new f(this.f204358a, "SP_CLIENT_EXPOSURE_CACHE$$$" + r100, r104));     // Catch: Throwable -> L9
        goto L4
    }

    public q(Context r100, s r101, Set<String> r102) {
        this.f204361d = new ConcurrentSkipListSet();
        this.f204367j = new ConcurrentHashMap();
        this.f204368k = new CopyOnWriteArrayList();
        this.f204358a = r100;
        this.f204359b = r101;
        this.f204363f = r102;
        this.f204364g = g.c(r100, "SP_EXPERIMENT_CACHE").getString("ab_test_current_uid", "");
        this.f204360c = g.d(r100, "SP_EXPERIMENT_EXPOSURE_CACHE");
        this.f204362e = g.d(r100, "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.f204364g);
        this.f204366i = g.b(r100, "SP_EXPERIMENT_EXPOSURE_CACHE");
        Iterator r103 = ((ConcurrentSkipListSet) g.d(r100, "SP_CLIENT_EXPOSURE_CACHE")).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = (String) r103.next();
        Map<String, String> r105 = g.b(r100, "SP_CLIENT_EXPOSURE_CACHE$$$" + r104);
        ((ConcurrentHashMap) this.f204367j).put(r104, r105);
        this.f204361d.addAll(((ConcurrentHashMap) r105).values());
        goto L4
    L6:
        c();
        w.f204370a.schedule(new a(this), 5000, TimeUnit.MILLISECONDS);
    }

    public final <T> void b(String r100, ij4.a<T> r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r103 = r101.f490064d;
        if (((ConcurrentHashMap) this.f204367j).containsKey(r103) == true) goto L7;
        ((ConcurrentHashMap) this.f204367j).put(r103, new ConcurrentHashMap());
        w.a(new c(this.f204358a, "SP_CLIENT_EXPOSURE_CACHE", ((ConcurrentHashMap) this.f204367j).keySet()));
    L7:
        String[] r104 = r101.f490065e;
        if (r104 == null) goto L10;
        a(r103, Arrays.asList(r104));
    L11:
        Map r105 = (Map) ((ConcurrentHashMap) this.f204367j).get(r103);
        String r106 = (String) r105.get(r100);
        if (TextUtils.equals(r106, r102) == false) goto L14;
    L20:
        String r107 = this.f204365h;
        if (hj4.d.f485429c == false) goto L25;
        w.a(new hj4.b(r102, r107));
        return;
    L25:
        return;
    L14:
        if (TextUtils.isEmpty(r106) == true) goto L17;
        ((ConcurrentSkipListSet) this.f204361d).remove(r106);
        r105.remove(r100);
    L17:
        if (TextUtils.isEmpty(r102) == true) goto L19;
        ((ConcurrentSkipListSet) this.f204361d).add(r102);
        r105.put(r100, r102);
    L19:
        w.a(new d(r102, this.f204358a, "SP_CLIENT_EXPOSURE_CACHE$$$" + r103, r100));
        c();
        goto L20
    L10:
        ((CopyOnWriteArrayList) this.f204368k).add(r100);
        goto L11
    }
}
