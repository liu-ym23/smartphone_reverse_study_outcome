package faceverify;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hs7.b f476091a;

    @Override // java.lang.Runnable
    public void run() {
        faceverify_c_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void faceverify_c__run$___twin___() {
        hs7.b r100 = this.f476091a;
        if (r100.f487034q != null) goto L5;
        r100.f487034q = new CopyOnWriteArrayList();
    L5:
        hs7.b r101 = this.f476091a;
        r101.f487034q.addAll(r101.f487033p);
    L6:
        int r102 = this.f476091a.f487034q.size();
        hs7.b r103 = this.f476091a;
        if (r102 <= r103.f487035r) goto L9;
        r103.f487034q.remove(0);
        goto L6
    }

    public c(hs7.b r100) {
        this.f476091a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void faceverify_c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
        r100.faceverify_c__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
