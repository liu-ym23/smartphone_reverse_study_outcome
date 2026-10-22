package y6;

import android.app.Activity;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.ies.web.jsbridge2.g;

/* JADX INFO: loaded from: classes43.dex */
public interface c {
    f0 a();

    void b(Activity r100);

    IHybridComponent c();

    d0 d();

    Activity getActivity();

    void registerMethod(String r100, f.b r101);

    <P, R> void registerMethod(String r100, g<P, R> r101);

    void registerMethod(String r100, n56.c r101);

    void release();

    <T> void sendJSEvent(String r100, T r101);
}
