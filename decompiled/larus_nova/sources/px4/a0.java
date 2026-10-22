package px4;

import android.app.Dialog;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f530868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f530869b;

    public a0(w r100, String r101) {
        this.f530868a = r100;
        this.f530869b = r101;
    }

    public final void a() {
        w r100 = this.f530868a;
        jx4.u r101 = r100.f530922b;
        if (r101 != null) goto L8;
        r100.f530922b = new jx4.u(r100.f530921a, this.f530869b);
        jx4.u r102 = this.f530868a.f530922b;
        Intrinsics.checkNotNull(r102);
        Dialog r103 = r102.f500860b;
        if (r103 == null) goto L7;
        r103.setCancelable(false);
    L7:
        jx4.u r104 = this.f530868a.f530922b;
        Intrinsics.checkNotNull(r104);
        r104.c();
        return;
    L8:
        Intrinsics.checkNotNull(r101);
        String r105 = this.f530869b;
        Dialog r106 = r101.f500860b;
        if (r106 != null) goto L11;
        return;
    L11:
        if (r106.isShowing() == false) goto L16;
        r101.f500861c.setText(r105);
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
}
