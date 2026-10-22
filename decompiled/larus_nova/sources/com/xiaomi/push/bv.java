package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class bv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bv f463210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private bu f282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final HashMap<String, bt> f284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f285a;

    public static abstract class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f463212a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected bt f286a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f287a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f288a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f289a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Random f290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f463213b;

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public Object mo8861a() {
            return null;
        }

        public abstract void a(Context r100, SQLiteDatabase r101);

        public void b(Context r100) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com_xiaomi_push_bv$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m8863a() {
            if (this.f286a != null) goto L5;
        L10:
            return true;
        L5:
            if (TextUtils.isEmpty(this.f463213b) == true) goto L10;
            if (this.f289a == null) goto L10;
            return false;
        }

        public final void com_xiaomi_push_bv$a__run$___twin___() {
            WeakReference<Context> r100 = this.f289a;
            if (r100 != null) goto L5;
            return;
        L5:
            final Context r101 = r100.get();
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.getFilesDir() != null) goto L10;
            return;
        L10:
            if (this.f286a != null) goto L12;
            return;
        L12:
            if (TextUtils.isEmpty(this.f288a) == true) goto L19;
            PolarisFileWrapper r102 = new PolarisFileWrapper(this.f288a);
            t.a(r101, new PolarisFileWrapper(r102.getParentFile(), az.b(r102.getAbsolutePath())), new AnonymousClass1(this, r101));
            return;
        }

        public SQLiteDatabase a() {
            return this.f286a.getWritableDatabase();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public String m8862a() {
            return this.f288a;
        }

        public a(String r100) {
            this.f286a = null;
            this.f290a = new Random();
            this.f463212a = 0;
            this.f288a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_bv$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_xiaomi_push_bv$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void a(Context r100) {
            if (this.f287a == null) goto L5;
            this.f287a.a(r100, mo8861a());
        L5:
            b(r100);
        }

        public void a(a r100) {
            this.f287a = r100;
        }

        public void a(bt r100, Context r101) {
            this.f286a = r100;
            this.f463213b = r100.a();
            this.f289a = new WeakReference(r101);
        }

        public void a(Context r100, Object r101) {
            bv.a(r100).a(this);
        }
    }

    public static abstract class b<T> extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f463215a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f292a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f293a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String[] f294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<T> f463216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f463217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f463218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f463219e;

        public abstract T a(Context r100, Cursor r101);

        public abstract void a(Context r100, List<T> r101);

        @Override // com.xiaomi.push.bv.a
        public SQLiteDatabase a() {
            return this.f286a.getReadableDatabase();
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context r110, SQLiteDatabase r111) {
            this.f463216b.clear();
            List<String> r100 = this.f293a;
            String r101 = null;
            if (r100 != null) goto L5;
        L7:
            String[] r102 = null;
        L8:
            int r103 = this.f463215a;
            if (r103 <= 0) goto L12;
            r101 = String.valueOf(r103);
        L12:
            Cursor r112 = r111.query(this.f463213b, r102, this.f292a, this.f294a, this.f463217c, this.f463218d, this.f463219e, r101);
            if (r112 != null) goto L15;
        L22:
            a(r110, this.f463216b);
            return;
        L15:
            if (r112.moveToFirst() == false) goto L22;
        L16:
            T r104 = a(r110, r112);
            if (r104 == null) goto L20;
            this.f463216b.add(r104);
        L20:
            if (r112.moveToNext() == true) goto L16;
            r112.close();
            goto L22
        L5:
            if (r100.size() <= 0) goto L7;
            String[] r105 = new String[this.f293a.size()];
            this.f293a.toArray(r105);
            r102 = r105;
            goto L8
        }

        public b(String r100, List<String> r101, String r102, String[] r103, String r104, String r105, String r106, int r107) {
            super(r100);
            this.f463216b = new ArrayList();
            this.f293a = r101;
            this.f292a = r102;
            this.f294a = r103;
            this.f463217c = r104;
            this.f463218d = r105;
            this.f463219e = r106;
            this.f463215a = r107;
        }
    }

    public static class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<a> f463220a;

        @Override // com.xiaomi.push.bv.a
        public final void a(Context r100) {
            super.a(r100);
            Iterator<a> r101 = this.f463220a.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            a r102 = r101.next();
            if (r102 == null) goto L4;
            r102.a(r100);
            goto L4
        }

        public c(String r100, ArrayList<a> r101) {
            super(r100);
            ArrayList<a> r102 = new ArrayList();
            this.f463220a = r102;
            r102.addAll(r101);
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context r100, SQLiteDatabase r101) {
            Iterator<a> r102 = this.f463220a.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            a r103 = r102.next();
            if (r103 == null) goto L4;
            r103.a(r100, r101);
            goto L4
        }
    }

    public static class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f463221a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected String[] f295a;

        @Override // com.xiaomi.push.bv.a
        public void a(Context r100, SQLiteDatabase r101) {
            r101.delete(this.f463213b, this.f463221a, this.f295a);
        }

        public d(String r100, String r101, String[] r102) {
            super(r100);
            this.f463221a = r101;
            this.f295a = r102;
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ContentValues f463222a;

        public e(String r100, ContentValues r101) {
            super(r100);
            this.f463222a = r101;
        }

        @Override // com.xiaomi.push.bv.a
        public void a(Context r100, SQLiteDatabase r101) {
            r101.insert(this.f463213b, null, this.f463222a);
        }
    }

    private void a() {
        ad.a(this.f281a).b(new AnonymousClass1(this), com.xiaomi.push.service.ah.a(this.f281a).a(gj.f463751bm.a(), 5));
    }

    private bv(Context r110) {
        this.f284a = new HashMap();
        this.f285a = new PThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("iaomi/push/bv"));
        this.f283a = new ArrayList();
        this.f281a = r110;
    }

    public void a(ArrayList<a> r100) {
        if (this.f282a == null) goto L26;
        HashMap r101 = new HashMap();
        if (this.f285a.isShutdown() == true) goto L24;
        Iterator<a> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L16;
        a r103 = r102.next();
        if (r103.m8863a() == false) goto L12;
        r103.a(a(r103.m8862a()), this.f281a);
    L12:
        ArrayList r104 = (ArrayList) r101.get(r103.m8862a());
        if (r104 != null) goto L15;
        r104 = new ArrayList();
        r101.put(r103.m8862a(), r104);
    L15:
        r104.add(r103);
        goto L8
    L16:
        Iterator r105 = r101.keySet().iterator();
    L18:
        if (r105.hasNext() == false) goto L37;
        String r106 = (String) r105.next();
        ArrayList r107 = (ArrayList) r101.get(r106);
        if (r107 == null) goto L18;
        if (r107.size() <= 0) goto L18;
        c r108 = new c(r106, r107);
        r108.a(((a) ListProtector.get(r107, 0)).f286a, this.f281a);
        this.f285a.execute(r108);
        goto L18
    L37:
        return;
    L24:
        return;
    L26:
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    public void b(a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f282a == null) goto L20;
        String r101 = r100.m8862a();
        HashMap<String, bt> r102 = this.f284a;
        monitor-enter(r102);
        bt r103 = this.f284a.get(r101);     // Catch: Throwable -> L16
        if (r103 != null) goto L11;
        r103 = this.f282a.a(this.f281a, r101);     // Catch: Throwable -> L16
        this.f284a.put(r101, r103);     // Catch: Throwable -> L16
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L16
        if (this.f285a.isShutdown() == true) goto L23;
        r100.a(r103, this.f281a);
        a(r100);
        return;
    L23:
        return;
    L16:
        th = move-exception;
        throw th;
    L20:
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(a r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f282a == null) goto L27;
        String r101 = r100.m8862a();
        HashMap<String, bt> r102 = this.f284a;
        monitor-enter(r102);
        bt r103 = this.f284a.get(r101);     // Catch: Throwable -> L23
        if (r103 != null) goto L11;
        r103 = this.f282a.a(this.f281a, r101);     // Catch: Throwable -> L23
        this.f284a.put(r101, r103);     // Catch: Throwable -> L23
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L23
        if (this.f285a.isShutdown() == true) goto L22;
        r100.a(r103, this.f281a);
        ArrayList<a> r104 = this.f283a;
        monitor-enter(r104);
        this.f283a.add(r100);     // Catch: Throwable -> L19
        a();     // Catch: Throwable -> L19
        monitor-exit(r104);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    L27:
        throw new IllegalStateException("should exec init method first!");
    }

    private bt a(String r100) {
        bt r101 = this.f284a.get(r100);
        if (r101 != null) goto L13;
        HashMap<String, bt> r102 = this.f284a;
        monitor-enter(r102);
        if (r101 == null) goto L14;
    L8:
        monitor-exit(r102);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L14:
        r101 = this.f282a.a(this.f281a, r100);     // Catch: Throwable -> L10
        this.f284a.put(r100, r101);     // Catch: Throwable -> L10
    L13:
        return r101;
    }

    public static bv a(Context r100) {
        if (f463210a != null) goto L15;
        monitor-enter(bv.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463210a != null) goto L9;
        f463210a = new bv(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(bv.class);     // Catch: Throwable -> L11
    L15:
        return f463210a;
    }

    public void a(Runnable r100) {
        if (this.f285a.isShutdown() == true) goto L6;
        this.f285a.execute(r100);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8860a(String r100) {
        return a(r100).a();
    }

    public static /* synthetic */ ArrayList a(bv r100) {
        return r100.f283a;
    }
}
