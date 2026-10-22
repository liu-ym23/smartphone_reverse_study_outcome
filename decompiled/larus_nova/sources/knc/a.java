package knc;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.suite.component.logger.api.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f504329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f504330b = 0;

    public a() {
    }

    static {
        f504329a = new a();
        f504330b = Process.myPid();
    }

    @Override // com.suite.component.logger.api.f
    public final boolean a(com.suite.component.logger.b r100, com.suite.component.logger.c r110) {
        Intrinsics.checkNotNullParameter(r100, "logContext");
        Intrinsics.checkNotNullParameter(r110, "logEntity");
        boolean r101 = false;
        if (r100.f460107a.getValue() <= r110.f460115a.getValue()) goto L5;
        return false;
    L5:
        long r102 = r110.f460127m;
        if (r102 >= 0) goto L9;
        r102 = f504330b;
    L9:
        r110.f460127m = r102;
        String r103 = r110.f460128n;
        if (r103.length() != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        r103 = r100.f460111e;
    L15:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r110.f460128n = r103;
        String r105 = r110.f460126l;
        if (r105.length() != 0) goto L18;
        r101 = true;
    L18:
        if (r101 == false) goto L20;
        r105 = ThreadMethodProxy.currentThread().getName();
    L20:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r110.f460126l = r105;
        long r106 = r110.f460125k;
        if (r106 >= 0) goto L24;
        r106 = ThreadMethodProxy.currentThread().getId();
    L24:
        r110.f460125k = r106;
        long r107 = System.currentTimeMillis();
        long r108 = r110.f460129o;
        if (r108 <= 0) goto L27;
        r107 = r108;
    L27:
        r110.f460129o = r107;
        return true;
    L12:
        r104 = false;
        goto L13
    }
}
