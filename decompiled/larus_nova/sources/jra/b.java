package jra;

import com.larus.apm.impl.protector.RunnableProtector;
import ira.e;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f500158a;

    public b(e r100) {
        this.f500158a = r100;
    }

    public final void a() {
        List<Object> r100 = a.f500155a;
        int r101 = a.f500156b;
        int r102 = a.C6479a.f500157a;
        boolean r103 = true;
        if (r101 != 1) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L14;
        lra.c r105 = lra.b.f510478a.get();
        if (r105 != null) goto L10;
    L13:
        long r106 = -1;
    L27:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L20
        Object r108 = Result.m9449constructorimpl(new JSONObject().putOpt("duration", Long.valueOf(r106)));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r108) == false) goto L25;
        r108 = null;
    L25:
        int r109 = com.ss.android.ad.applinksdk.core.b.f406354a;
        e r110 = this.f500158a;
        com.ss.android.ad.applinksdk.core.b.e(r103, r110, (JSONObject) r108);
        return;
    L20:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    L10:
        if (r105.d() != 1) goto L13;
        if (a.a() == true) goto L13;
    L17:
        r106 = 0;
        r103 = false;
        goto L27
    L14:
        long r112 = System.currentTimeMillis();
        List<Object> r113 = a.f500155a;
        if ((r112 - 0) > 5000) goto L17;
        r106 = 0 - this.f500158a.f495547f;
        goto L27
    L5:
        r104 = false;
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
}
