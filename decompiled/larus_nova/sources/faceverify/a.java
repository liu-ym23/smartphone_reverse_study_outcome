package faceverify;

import com.dtf.face.log.RecordService;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hs7.b f476089a;

    @Override // java.lang.Runnable
    public void run() {
        faceverify_a_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void faceverify_a__run$___twin___() {
        hs7.b r100 = this.f476089a;
        if (r100.f487038u == true) goto L5;
    L7:
        RecordService.getInstance().recordEvent(2, "videoReleaseWait", new String[]{"hasRelease", String.valueOf(this.f476089a.f487038u), "badCaseCount", String.valueOf(this.f476089a.f487039v.get())});
        return;
    L5:
        if (r100.f487039v.get() != 0) goto L7;
        ws7.s.a(0);
    }

    public a(hs7.b r100) {
        this.f476089a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void faceverify_a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
        r100.faceverify_a__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
