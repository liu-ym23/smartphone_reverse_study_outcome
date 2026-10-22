package tta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f547575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f547576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f547577c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f547578a;

        public a(d r100) {
            this.f547578a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            d r100 = this.f547578a;     // Catch: Throwable -> L6
            Function1 r101 = r100.f547577c;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            Unit r102 = (Unit) r101.invoke((Bitmap) r100.f547575a.element);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f547579a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f547580a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bitmap f547581b;

            /* JADX INFO: renamed from: tta.d$b$a$a, reason: collision with other inner class name */
            public static final class RunnableC7774a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ a f547582a;

                public RunnableC7774a(a r100) {
                    this.f547582a = r100;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a r100 = this.f547582a;     // Catch: Throwable -> L6
                    Function1 r101 = r100.f547580a.f547579a.f547577c;     // Catch: Throwable -> L6
                    if (r101 == null) goto L9;
                    Unit r102 = (Unit) r101.invoke(r100.f547581b);     // Catch: Throwable -> L6
                    return;
                L9:
                    return;
                L6:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == true) goto L13;
                    throw th;
                }
            }

            public a(b r100, Bitmap r101) {
                this.f547580a = r100;
                this.f547581b = r101;
            }

            public final void a() {
                tta.b r100 = c.f547572c;
                String r101 = this.f547580a.f547579a.f547576b;
                Bitmap r102 = this.f547581b;
                r100.getClass();
                if (r102.isRecycled() == true) goto L21;
                PolarisFileWrapper r103 = r100.f547569a;
                if (r103 == null) goto L21;
                r100.a();
                PolarisFileWrapper r104 = new PolarisFileWrapper(r103, com.ss.android.dypay.utils.c.a(r101));     // Catch: Throwable -> L20
                if (StringsKt.startsWith$default(r104.getCanonicalPath(), r103.getCanonicalPath(), false, 2, null) == false) goto L21;
                PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L20
                r102.compress(Bitmap.CompressFormat.PNG, 100, r105);     // Catch: Throwable -> L15
                CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L20
                goto L21
            L15:
                th = move-exception;
                throw th;     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L20
                throw th;     // Catch: Throwable -> L20
            L21:
                h r106 = c.f547571b;
                String r107 = this.f547580a.f547579a.f547576b;
                Bitmap r108 = this.f547581b;
                r106.getClass();
                if (r108.isRecycled() == true) goto L24;
                r106.f547587a.put(r107, r108);
            L24:
                new Handler(Looper.getMainLooper()).post(new RunnableC7774a(this));
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

        /* JADX INFO: renamed from: tta.d$b$b, reason: collision with other inner class name */
        public static final class RunnableC7775b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f547583a;

            public RunnableC7775b(b r100) {
                this.f547583a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function1 r100 = this.f547583a.f547579a.f547577c;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                Unit r101 = (Unit) r100.invoke(null);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public b(d r100) {
            this.f547579a = r100;
        }

        public final void a(Bitmap r100) {
            if (r100 != null) goto L4;
        L6:
            new Handler(Looper.getMainLooper()).post(new RunnableC7775b(this));
            return;
        L4:
            if (r100.isRecycled() == true) goto L6;
            c.f547573d.post(new a(this, r100));
        }
    }

    public d(Ref.ObjectRef r100, String r101, com.ss.android.dypay.views.d r102) {
        this.f547575a = r100;
        this.f547576b = r101;
        this.f547577c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        Ref.ObjectRef r100 = this.f547575a;
        tta.b r101 = c.f547572c;
        String r102 = this.f547576b;
        PolarisFileWrapper r103 = r101.f547569a;
        boolean r104 = false;
        if (r103 == null) goto L25;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103, com.ss.android.dypay.utils.c.a(r102));
    L24:
        r105.delete();
        goto L25
    L6:
        if (StringsKt.startsWith$default(r105.getCanonicalPath(), r103.getCanonicalPath(), false, 2, null) == false) goto L25;
        if (r105.exists() == false) goto L25;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r105);     // Catch: Throwable -> L24
        Bitmap r107 = BitmapFactory.decodeStream(r106);     // Catch: Throwable -> L19
        if (r107 != null) goto L14;
    L17:
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L24
        goto L25
    L14:
        if (r107.isRecycled() == true) goto L17;
        r105.setLastModified(System.currentTimeMillis());     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L24
        T r108 = r107;
    L26:
        r100.element = r108;
        Bitmap r109 = (Bitmap) this.f547575a.element;
        if (r109 != null) goto L29;
    L37:
        e r110 = c.f547570a;
        String r111 = this.f547576b;
        b r112 = new b(this);
        r110.getClass();
        if (r111 != null) goto L40;
    L41:
        r104 = true;
    L42:
        if (r104 == false) goto L44;
        r112.a(null);
        return;
    L44:
        ThreadMethodProxy.start(new PthreadThreadV2(new uta.a(r111, new f(r112)), "ypay/base/h/e"));
        return;
    L40:
        if (r111.length() != 0) goto L42;
    L29:
        if (r109.isRecycled() == true) goto L37;
        new Handler(Looper.getMainLooper()).post(new a(this));
        h r113 = c.f547571b;
        String r114 = this.f547576b;
        Bitmap r115 = (Bitmap) this.f547575a.element;
        if (r115 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        r113.getClass();
        if (r115.isRecycled() == true) goto L51;
        r113.f547587a.put(r114, r115);
        return;
    L51:
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L25:
        r108 = 0;
        goto L26
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
