package ts7;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class a implements Runnable {
    public static String TYPE_BIZ = "business";
    public static String TYPE_LOG = "log";
    private String type;

    public void com_dtf_face_thread_DTFVerifyRunnable__run$___twin___() {
    }

    @Override // java.lang.Runnable
    public void run() {
        com_dtf_face_thread_DTFVerifyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public String getRunnableType() {
        return this.type;
    }

    public a(String r100) {
        this.type = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_dtf_face_thread_DTFVerifyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
        r100.com_dtf_face_thread_DTFVerifyRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
