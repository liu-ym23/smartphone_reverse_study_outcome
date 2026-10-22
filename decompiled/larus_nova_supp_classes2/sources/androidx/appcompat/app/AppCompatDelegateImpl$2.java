package androidx.appcompat.app;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$2 implements Runnable {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // java.lang.Runnable
    public void run() {
        androidx_appcompat_app_AppCompatDelegateImpl$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_appcompat_app_AppCompatDelegateImpl$2__run$___twin___() {
        AppCompatDelegateImpl r0 = this.this$0;
        if ((r0.mInvalidatePanelMenuFeatures & 1) == 0) goto L5;
        r0.doInvalidatePanelMenu(0);
    L5:
        AppCompatDelegateImpl r1 = this.this$0;
        if ((r1.mInvalidatePanelMenuFeatures & 4096) == 0) goto L8;
        r1.doInvalidatePanelMenu(108);
    L8:
        AppCompatDelegateImpl r2 = this.this$0;
        r2.mInvalidatePanelMenuPosted = false;
        r2.mInvalidatePanelMenuFeatures = 0;
    }

    public AppCompatDelegateImpl$2(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_appcompat_app_AppCompatDelegateImpl$2_com_larus_apm_impl_protector_RunnableLancet_run(AppCompatDelegateImpl$2 r1) {
        r1.androidx_appcompat_app_AppCompatDelegateImpl$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
