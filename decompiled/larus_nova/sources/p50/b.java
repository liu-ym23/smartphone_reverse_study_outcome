package p50;

import android.graphics.Bitmap;
import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function4 f527740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f527741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f527742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f527743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f527744e;

    public b(Function4 r100, Uri r101, Bitmap r102, int r103, int r104) {
        this.f527740a = r100;
        this.f527741b = r101;
        this.f527742c = r102;
        this.f527743d = r103;
        this.f527744e = r104;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f527740a.invoke(this.f527741b, this.f527742c, Integer.valueOf(this.f527743d), Integer.valueOf(this.f527744e));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
