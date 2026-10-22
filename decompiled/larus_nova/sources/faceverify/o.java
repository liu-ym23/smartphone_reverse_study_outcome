package faceverify;

import android.util.Pair;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f476178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f476179b;

    @Override // java.lang.Runnable
    public void run() {
        faceverify_o_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void faceverify_o__run$___twin___() {
        String r100 = String.valueOf(this.f476178a.hashCode());
        if (m.f476171b.get(r100) == null) goto L5;
        return;
    L5:
        m.f476171b.put(r100, 1);
        String r101 = this.f476179b;
        StringBuilder r102 = new StringBuilder();
        File r103 = m.f476176g;
        r102.append(r103.getAbsolutePath());
        r102.append(File.separator);
        boolean r104 = false;
        Pair<File, String> r105 = ws7.e.b(r101, r102.toString(), this.f476178a + FaceShowElderlyFragment.AUDIO_FORM, null, 0);
        if (r105 != null) goto L8;
    L10:
        if (r104 == true) goto L12;
        return;
    L12:
        if (m.a(this.f476178a) == false) goto L16;
        m.a(r103.getAbsolutePath(), this.f476178a, true);
        return;
    L16:
        return;
    L8:
        if (r105.first == null) goto L10;
        r104 = true;
        goto L10
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void faceverify_o_com_larus_apm_impl_protector_RunnableLancet_run(o r100) {
        r100.faceverify_o__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(String r100, String r101) {
        this.f476178a = r100;
        this.f476179b = r101;
    }
}
