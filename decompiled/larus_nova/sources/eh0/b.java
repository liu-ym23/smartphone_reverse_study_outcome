package eh0;

import ch0.e;
import com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface b extends com.bytedance.android.live.liveinteract.plantform.datamerge.b {
    List<e> d();

    void e();

    BehaviorSubject<List<e>> h();

    void i(Map<String, Boolean> r100);

    BehaviorSubject<Map<String, Boolean>> j();

    BehaviorSubject<Map<String, Long>> l();

    void m(h.a r100);

    void n(Map<String, Boolean> r100);

    BehaviorSubject<Map<String, Boolean>> o();

    void p(Map<String, Long> r100);

    void t0(SeiAppData r100);
}
