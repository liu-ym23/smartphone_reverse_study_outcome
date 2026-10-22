package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, String> f199604c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, List<c>> f199605d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f199606e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f199607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f199608b;

    public static class a extends i84.r<a1> {
        public a() {
        }

        @Override // i84.r
        public final a1 a(Object[] r100) {
            return new a1((Context) r100[0]);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f199609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f199610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f199611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a1 f199612d;

        public final void a() {
            this.f199612d.f199607a.getContentResolver().notifyChange(this.f199609a, null);     // Catch: Exception -> L4
            return;
        L4:
            int[] r100 = this.f199610b;
            int r101 = r100[0] + 1;
            r100[0] = r101;
            if (r101 > 4) goto L10;
            t.a(this + "retry " + this.f199610b[0] + " times after 1 second");
            v.b(this.f199611c).postDelayed(this, 1000);
            return;
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

        public b(a1 r100, Uri r101, int[] r102, String r103) {
            this.f199612d = r100;
            this.f199609a = r101;
            this.f199610b = r102;
            this.f199611c = r103;
        }
    }

    /* JADX INFO: loaded from: classes8.dex */
    public interface c {
        void b(String r100, String r101);
    }

    static {
        f199604c = new ConcurrentHashMap();
        f199605d = new ConcurrentHashMap();
        f199606e = new a();
    }

    public a1(Context r100) {
        this.f199608b = new AtomicBoolean(false);
        this.f199607a = r100;
    }

    public static a1 a(Context r100) {
        return f199606e.b(new Object[]{r100});
    }

    public final void b(String r100, String r101, c r102) {
        if (this.f199608b.compareAndSet(false, true) == false) goto L10;
        Uri r103 = BDInstallProvider.a(this.f199607a);
        if (r103 == null) goto L10;
        this.f199607a.getContentResolver().registerContentObserver(r103, true, new b1(this, v.b(v.a(v.f199800d))));
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return;
    L12:
        monitor-enter(this);
        Map<String, List<c>> r104 = f199605d;     // Catch: Throwable -> L29
        List r105 = (List) ((ConcurrentHashMap) r104).get(r101);     // Catch: Throwable -> L29
        if (r105 != null) goto L16;
        r105 = new ArrayList();     // Catch: Throwable -> L29
        ((ConcurrentHashMap) r104).put(r101, r105);     // Catch: Throwable -> L29
    L16:
        r105.add(r102);     // Catch: Throwable -> L29
        Map<String, String> r106 = f199604c;     // Catch: Throwable -> L29
        if (((ConcurrentHashMap) r106).containsKey(r101) == false) goto L23;
        String r107 = (String) ((ConcurrentHashMap) r106).get(r101);     // Catch: Throwable -> L29
        if (r102 == null) goto L21;
        r102.b(r107, r100);     // Catch: Throwable -> L29
    L21:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L23:
        String r108 = this.f199607a.getSharedPreferences("ug_install_op_pref", 0).getString(r101 + "_" + r100, null);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r108) == true) goto L27;
        if (r102 == null) goto L27;
        r102.b(r108, r100);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public final void c(String r100, String r101, String r102) {
        this.f199607a.getSharedPreferences("ug_install_op_pref", 0).edit().putString(r101 + "_" + r100, r102).apply();     // Catch: Exception -> L7
        Uri r103 = BDInstallProvider.a(this.f199607a);     // Catch: Exception -> L7
        if (r103 != null) goto L5;
        return;
    L5:
        new b(this, r103.buildUpon().appendQueryParameter("key", r101).appendQueryParameter("aid", r100).appendQueryParameter("value", r102).build(), new int[1], r100).run();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        t.c("sendSubpEvent error", e);
    }
}
