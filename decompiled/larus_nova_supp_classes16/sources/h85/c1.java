package h85;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c1 implements com.bytedance.ee.bear.drive.biz.external.f.d {
    public final /* synthetic */ Context a;

    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ c1 b;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.a != 3) goto L5;
            Toast.showText(this.b.a, 2131888391);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            Toast.showText(this.b.a, 2131888428);     // Catch: Throwable -> L7
            goto L12
        }

        public a(c1 r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void c(w75.a r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final /* synthetic */ void f() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final /* synthetic */ void onDismiss() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void d() {
        tt5.a.d("DriveInterfaceImpl", "onStoragePermissionDenied");
    }

    public c1(FragmentActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.d
    public final void a(int r2) {
        com.bytedance.ee.util.ui.m.a(new a(this, r2));
    }
}
