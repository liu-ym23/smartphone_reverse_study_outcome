package qe2;

import android.graphics.Bitmap;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {
    int S0(String r1);

    void a(int r1);

    void b();

    void c(Function0<? extends IRenderView> r1);

    void clear();

    void d(boolean r1);

    int e();

    void end();

    void f();

    void g(Bitmap r1);

    List<s0> getHeadPointList();

    void h(boolean r1);

    void i(boolean r1);

    void j();

    void k(String r1, Object r2);

    void l(tlc.d r1);

    void m();

    void n(IVoiceLiveTheme r1);

    void o(boolean r1);

    void onResume();

    void p();

    void updateTalkState(Map<String, Integer> r1);
}
