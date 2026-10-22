package va;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C7976a f553911g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f553912h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f553914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f553915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public va.b f553916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f553917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f553918f;

    /* JADX INFO: renamed from: va.a$a, reason: collision with other inner class name */
    public static final class C7976a {
        public final a a() {
            a r100 = a.f553912h;
            if (r100 != null) goto L13;
            monitor-enter(this);
            r100 = a.f553912h;     // Catch: Throwable -> L10
            if (r100 != null) goto L8;
            r100 = new a();     // Catch: Throwable -> L10
            a.f553912h = r100;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r100;
        }

        public C7976a() {
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f553919a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            switch(r100.what) {
                case 1: goto L26;
                case 2: goto L23;
                case 3: goto L20;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto L45;
                case 7: goto L11;
                case 8: goto L8;
                case 9: goto L5;
                default: goto L45;
            };
        L5:
            c r101 = this.f553919a.f553918f;
            if (r101 == null) goto L30;
            r101.b(r100);
            return;
        L30:
            return;
        L8:
            c r102 = this.f553919a.f553918f;
            if (r102 == null) goto L32;
            r102.c(r100);
            return;
        L32:
            return;
        L11:
            c r103 = this.f553919a.f553918f;
            if (r103 == null) goto L34;
            r103.a(r100);
            return;
        L34:
            return;
        L14:
            d r104 = this.f553919a.f553917e;
            if (r104 == null) goto L36;
            r104.a(r100);
            return;
        L36:
            return;
        L17:
            d r105 = this.f553919a.f553917e;
            if (r105 == null) goto L38;
            r105.b(r100);
            return;
        L38:
            return;
        L20:
            va.b r106 = this.f553919a.f553916d;
            if (r106 == null) goto L40;
            r106.b(r100);
            return;
        L40:
            return;
        L23:
            va.b r107 = this.f553919a.f553916d;
            if (r107 == null) goto L42;
            r107.c(r100);
            return;
        L42:
            return;
        L26:
            va.b r108 = this.f553919a.f553916d;
            if (r108 == null) goto L44;
            r108.a(r100);
            return;
        L44:
            return;
        }

        public b(a r100, Looper r101) {
            this.f553919a = r100;
            super(r101);
        }
    }

    static {
        f553911g = new C7976a();
    }

    public a() {
        Intrinsics.checkNotNullParameter("AnnieX-AI", "tag");
        this.f553913a = "AnnieX-AI";
    }

    public final void a() {
        if (this.f553915c == true) goto L5;
    L7:
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(this.f553913a, 0);
        ThreadMethodProxy.start(r100);
        this.f553914b = new b(this, r100.getLooper());
        this.f553915c = true;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
    }
}
