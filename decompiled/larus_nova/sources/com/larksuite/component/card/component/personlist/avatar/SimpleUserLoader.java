package com.larksuite.component.card.component.personlist.avatar;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class SimpleUserLoader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<SimpleUserLoader> f283460d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, wy7.c> f283461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, ArrayList<WeakReference<com.larksuite.component.card.component.personlist.avatar.b>>> f283462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, ArrayList<WeakReference<c>>> f283463c;

    public static final class a {
        public static SimpleUserLoader a() {
            return SimpleUserLoader.f283460d.getValue();
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList<String> f283464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SimpleUserLoader f283465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<String, wy7.c> f283466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f283467d;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SimpleUserLoader f283468a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map<String, wy7.c> f283469b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Map<String, wy7.c> f283470c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f283471d;

            public a(SimpleUserLoader r100, Map<String, wy7.c> r101, Map<String, wy7.c> r102, f r103) {
                this.f283468a = r100;
                this.f283469b = r101;
                this.f283470c = r102;
                this.f283471d = r103;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f283468a.f283461a.putAll(this.f283469b);     // Catch: Throwable -> L4
                this.f283470c.putAll(this.f283469b);     // Catch: Throwable -> L4
                this.f283468a.a(this.f283470c, this.f283471d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader$b$b, reason: collision with other inner class name */
        public static final class RunnableC3897b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SimpleUserLoader f283472a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map<String, wy7.c> f283473b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f f283474c;

            public RunnableC3897b(SimpleUserLoader r100, Map<String, wy7.c> r101, f r102) {
                this.f283472a = r100;
                this.f283473b = r101;
                this.f283474c = r102;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SimpleUserLoader r100 = this.f283472a;     // Catch: Throwable -> L4
                Map<String, wy7.c> r101 = this.f283473b;     // Catch: Throwable -> L4
                f r102 = this.f283474c;     // Catch: Throwable -> L4
                Lazy<SimpleUserLoader> r103 = SimpleUserLoader.f283460d;     // Catch: Throwable -> L4
                r100.a(r101, r102);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(ArrayList<String> r100, SimpleUserLoader r101, Map<String, wy7.c> r102, f r103) {
            this.f283464a = r100;
            this.f283465b = r101;
            this.f283466c = r102;
            this.f283467d = r103;
        }

        public final void a() {
            yy7.a r100 = ty7.a.a();     // Catch: Exception -> L10
            if (r100 == null) goto L5;
            Map<String, wy7.c> r101 = r100.getChatterByIds(this.f283464a);     // Catch: Exception -> L10
        L6:
            if (r101 == null) goto L8;
            mz7.b.a(new a(this.f283465b, r101, this.f283466c, this.f283467d));     // Catch: Exception -> L10
            return;
        L8:
            mz7.b.a(new RunnableC3897b(this.f283465b, this.f283466c, this.f283467d));     // Catch: Exception -> L10
            return;
        L5:
            r101 = null;
        L10:
            e = move-exception;
            Log.w("SimpleUserLoader", "loadUserIfNeed submit task is exception", e);
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

    static {
        f283460d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SimpleUserLoader$Companion$instance$2.INSTANCE);
    }

    public SimpleUserLoader() {
        this.f283461a = new LinkedHashMap();
        this.f283462b = new LinkedHashMap();
        this.f283463c = new LinkedHashMap();
    }

    public final void a(Map<String, wy7.c> r100, f r101) {
        if (r101 == null) goto L4;
        r101.a(r100);
    L4:
        Iterator<Map.Entry<String, wy7.c>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Map.Entry<String, wy7.c> r103 = r102.next();
        String r104 = r103.getKey();
        wy7.c r105 = r103.getValue();
        Intrinsics.checkNotNullParameter(r104, "userId");
        Intrinsics.checkNotNullParameter(r105, "userInfo");
        ArrayList r106 = (ArrayList) ((LinkedHashMap) this.f283463c).get(r104);
        if (r106 == null) goto L6;
        Iterator r107 = r106.iterator();
    L11:
        if (r107.hasNext() == false) goto L6;
        c r108 = (c) ((WeakReference) r107.next()).get();
        if (r108 == null) goto L11;
        r108.a(r104, r105);
        goto L11
    }

    public final void b(List<String> r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "userIds");
        LinkedHashMap r102 = new LinkedHashMap();
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((ArrayList) r100).iterator();
    L4:
        if (r104.hasNext() == false) goto L22;
        String r105 = (String) r104.next();
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L4;
        if (this.f283461a.containsKey(r105) == false) goto L20;
        if (((LinkedHashMap) this.f283461a).get(r105) == null) goto L20;
        wy7.c r107 = (wy7.c) ((LinkedHashMap) this.f283461a).get(r105);
        if (r107 == null) goto L4;
        r102.put(r105, r107);
    L20:
        r103.add(r105);
        goto L4
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    L22:
        if (r103.isEmpty() == false) goto L24;
        a(r102, r101);
        return;
    L24:
        CoreThreadPool.getDefault().getCachedThreadPool().submit(new b(r103, this, r102, r101));
    }

    public final void c(String r100, com.larksuite.component.card.component.personlist.avatar.b r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "listener");
        ArrayList<WeakReference<com.larksuite.component.card.component.personlist.avatar.b>> r102 = (ArrayList) ((LinkedHashMap) this.f283462b).get(r100);
        if (r102 != null) goto L5;
        r102 = new ArrayList();
        this.f283462b.put(r100, r102);
    L5:
        r102.add(new WeakReference(r101));
    }
}
