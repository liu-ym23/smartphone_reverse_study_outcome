package qe2;

import android.graphics.Bitmap;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    int S0(String r100);

    void a(int r100);

    void b();

    void c(Function0<? extends IRenderView> r100);

    void clear();

    void d(boolean r100);

    int e();

    void end();

    void f();

    void g(Bitmap r100);

    List<s0> getHeadPointList();

    void h(boolean r100);

    void i(boolean r100);

    void j();

    void k(String r100, Object r101);

    void l(tlc.d r100);

    void m();

    void n(IVoiceLiveTheme r100);

    void o(boolean r100);

    void onResume();

    void p();

    void updateTalkState(Map<String, Integer> r100);
}
