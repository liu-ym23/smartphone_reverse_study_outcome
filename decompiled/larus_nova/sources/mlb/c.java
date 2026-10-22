package mlb;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f514394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.a f514395b;

    public static final class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f514396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f514397b;

        @Override // mlb.d.a
        public final void a(ArrayList<QRCodeResultInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "resultList");
            b.f514386b.put(this.f514396a, r100);
            b.b(this.f514397b, r100);
        }

        @Override // mlb.d.a
        public final void onError(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            b.f514386b.put(this.f514396a, new ArrayList());
            b.a(this.f514397b, r100);
        }

        public a(String r100, d.a r101) {
            this.f514396a = r100;
            this.f514397b = r101;
        }
    }

    public c(String r100, d.a r101) {
        this.f514394a = r100;
        this.f514395b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = com.ss.android.lark.imageqrcode.utils.a.f426671a;     // Catch: Throwable -> L6
        Bitmap r101 = com.ss.android.lark.imageqrcode.utils.a.a(this.f514394a);     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        b.f(r101, new a(this.f514394a, this.f514395b));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
