package faceverify;

import android.text.TextUtils;
import android.util.Pair;
import com.dtf.face.config.IConstValues;
import com.dtf.face.log.RecordService;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap f476177a;

    @Override // java.lang.Runnable
    public void run() {
        faceverify_n_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void faceverify_n__run$___twin___() {
        if (m.f476175f == false) goto L5;
        return;
    L5:
        m.a(true);
        Iterator r100 = this.f476177a.entrySet().iterator();
    L7:
        if (r100.hasNext() == false) goto L25;
        Map.Entry r101 = (Map.Entry) r100.next();
        if (TextUtils.equals((CharSequence) r101.getKey(), IConstValues.SUITABLE_TYPE_KEY) == true) goto L7;
        if (((String) r101.getKey()).startsWith("sigdtf") == true) goto L7;
        String r102 = (String) r101.getKey();
        if (m.f476171b.containsKey(r101.getKey()) == true) goto L7;
        Pair<File, String> r103 = ws7.e.b((String) r101.getValue(), m.f476176g.getAbsolutePath() + File.separator, r102 + FaceShowElderlyFragment.AUDIO_FORM, null, 3);
        if (r103 != null) goto L18;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == false) goto L7;
        if (m.a(r102) == true) goto L7;
        RecordService.getInstance().recordEvent(2, "suitableError", new String[]{"msg", "md5 check fail", "fileName", r102});
        goto L7
    L18:
        if (r103.first == null) goto L20;
        r104 = true;
        goto L21
    }

    public n(HashMap r100) {
        this.f476177a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void faceverify_n_com_larus_apm_impl_protector_RunnableLancet_run(n r100) {
        r100.faceverify_n__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
