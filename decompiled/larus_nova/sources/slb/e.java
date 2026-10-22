package slb;

import com.ss.android.lark.pb.office_ai_inline.QuickAction;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes36.dex */
public interface e {

    public interface a {
        void onError(Throwable r100);

        void onSuccess(List<QuickAction> r100);
    }

    void a(j r100, List<m> r101);

    void b();

    void c(Map<String, String> r100, a r101);

    void d(String r100);

    void e(List<m> r100);

    i1<Boolean> isShowing();
}
