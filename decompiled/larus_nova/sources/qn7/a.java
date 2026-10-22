package qn7;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import oo7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends lo7.a {

    /* JADX INFO: renamed from: qn7.a$a, reason: collision with other inner class name */
    public class C7367a implements in7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WeakReference f534109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareContent f534110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f534111c;

        /* JADX INFO: renamed from: qn7.a$a$a, reason: collision with other inner class name */
        public class RunnableC7368a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f534112a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C7367a f534113b;

            @Override // java.lang.Runnable
            public final void run() {
                Bitmap r100 = this.f534112a;     // Catch: Throwable -> L14
                if (r100 != null) goto L5;
                return;
            L5:
                if (r100.isRecycled() == false) goto L8;
                return;
            L8:
                if (((Activity) this.f534113b.f534109a.get()) == null) goto L22;
                ShareContent r101 = this.f534113b.f534110b;     // Catch: Throwable -> L14
                if (r101 == null) goto L23;
                r101.setImage(this.f534112a);     // Catch: Throwable -> L14
                C7367a r102 = this.f534113b;     // Catch: Throwable -> L14
                a r103 = r102.f534111c;     // Catch: Throwable -> L14
                ShareContent r104 = r102.f534110b;     // Catch: Throwable -> L14
                r103.getClass();     // Catch: Throwable -> L14
                a.d(r104);     // Catch: Throwable -> L14
                return;
            L23:
                return;
            L22:
                return;
            L14:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L24;
                throw th;
            }

            public RunnableC7368a(C7367a r100, Bitmap r101) {
                this.f534113b = r100;
                this.f534112a = r101;
            }
        }

        @Override // in7.a
        public final void onFailed() {
            j.a();
        }

        @Override // in7.a
        public final void onSuccess(Bitmap r100) {
            j.a();
            new Handler(Looper.getMainLooper()).post(new RunnableC7368a(this, r100));
        }

        public C7367a(a r100, WeakReference r101, ShareContent r102) {
            this.f534111c = r100;
            this.f534109a = r101;
            this.f534110b = r102;
        }
    }

    public a(Context r100) {
        super(r100);
    }

    public static void d(ShareContent r100) {
        long r101 = System.currentTimeMillis();
        kn7.a r102 = r100.getExtraParams();
        if (r102 == null) goto L11;
        Object r103 = r102.f504252f;
        if (r103 == null) goto L11;
        if ((r103 instanceof rn7.a) == false) goto L11;
        rn7.a r104 = (rn7.a) r103;
        go7.a.c(System.currentTimeMillis() - r101, r100.getPanelId(), "secondaryPanel == null");
        return;
    L11:
        go7.a.c(System.currentTimeMillis() - r101, r100.getPanelId(), "shareExtra error");
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        this.f510133b = r100;
        if (r100 != null) goto L5;
        return false;
    L5:
        eo7.a r101 = eo7.a.b.f473353a;
        Activity r102 = r101.h();
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r100.getImage() == null) goto L13;
        d(r100);
        return true;
    L13:
        if (TextUtils.isEmpty(r100.getHiddenImageUrl()) == true) goto L16;
        j.b(r100);
        WeakReference r103 = new WeakReference(r102);
        r101.d(r100.getHiddenImageUrl(), new C7367a(this, r103, r100));
        return true;
    L16:
        return false;
    }
}
