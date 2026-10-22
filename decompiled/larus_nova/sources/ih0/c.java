package ih0;

import android.view.View;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public interface c extends Disposable {

    public static final class a {
        public static /* synthetic */ void a(c r100, Map r101, Map r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            r100.h(r101, r102);
        }
    }

    Boolean A();

    void J();

    void N(long r100);

    View S0();

    void f1();

    View getHybridView();

    void h(Map r100, Map r101);

    Completable onLoadSuccess();

    void r1();

    void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101);

    void release();

    void sendJsEvent(String r100, Object r101);

    void updateData(Map<String, ? extends Object> r100);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
