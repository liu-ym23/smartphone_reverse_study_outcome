package androidx.activity;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$5 implements Runnable {
    final /* synthetic */ ComponentActivity this$0;

    @Override // java.lang.Runnable
    public void run() {
        androidx_activity_ComponentActivity$5_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_activity_ComponentActivity$5__run$___twin___() {
        ComponentActivity.access$001(this.this$0);     // Catch: NullPointerException -> L4 IllegalStateException -> L9
    L16:
        return;
    L9:
        e = move-exception;
        if (TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState") == false) goto L13;
        return;
    L13:
        throw e;
    L4:
        e = move-exception;
        if (TextUtils.equals(e.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference") == true) goto L17;
        throw e;
    }

    public ComponentActivity$5(ComponentActivity r1) {
        this.this$0 = r1;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_activity_ComponentActivity$5_com_larus_apm_impl_protector_RunnableLancet_run(ComponentActivity$5 r1) {
        r1.androidx_activity_ComponentActivity$5__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
