package dw6;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.poi.utils.SafeGsonUtil;
import kotlin.jvm.internal.Intrinsics;
import yn6.e;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f470318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f470320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f470321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f470322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f470323g;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f470324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f470325b;

        public a(c r100, d r101) {
            this.f470324a = r100;
            this.f470325b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f470324a.c(this.f470325b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b() {
        yn6.c r100 = yn6.a.f568561a;
        yn6.a.j(this.f470319c, this, this.f470317a);
        yn6.a.b(this.f470319c, this.f470317a);
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r101 == null) goto L6;
        r101.i("BackInterceptManager", "unsubscribeKey domain=" + this.f470317a + ", componentId=" + this.f470318b);
        return;
    }

    public final void c(d r100) {
        if (r100.a() >= 0) goto L5;
        int r101 = 0;
    L6:
        this.f470320d = r101;
        this.f470321e = r100.b();
        qs6.b r102 = HostServiceUtilsKt.k();
        if (r102 == null) goto L10;
        r102.d("BackInterceptManager", "InterceptControl valueUpdate 2 priority=" + this.f470320d + ", should=" + this.f470321e);
        return;
    L10:
        return;
    L5:
        r101 = r100.a();
        goto L6
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "componentId");
        this.f470317a = r100;
        this.f470318b = r101;
        this.f470319c = "intercept_control_" + r101;
        this.f470322f = "";
        this.f470323g = new Handler(Looper.getMainLooper());
    }

    @Override // yn6.e
    public final void a(String r100, String r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "key");
        qs6.b r104 = HostServiceUtilsKt.k();
        if (r104 == null) goto L6;
        r104.d("BackInterceptManager", "InterceptControl valueUpdate 1 domain=" + r100 + ", key=" + r101 + ", controlValue=" + r102);
    L6:
        if (Intrinsics.areEqual(r100, this.f470317a) == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r101, this.f470319c) == true) goto L10;
        return;
    L10:
        if ((r102 instanceof String) == false) goto L24;
        d r105 = (d) SafeGsonUtil.a((String) r102, d.class);
        if (r105 != null) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r105.c(), this.f470322f) == false) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L20;
        c(r105);
        return;
    L20:
        this.f470323g.post(new a(this, r105));
        return;
    }
}
