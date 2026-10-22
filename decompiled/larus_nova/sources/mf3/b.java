package mf3;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(mf3.a r110, Context r111, Lifecycle r112, ViewGroup r113, Map r114, String r115, Map r116, Map r117, String r210, boolean r211, int r212) {
            if ((r212 & 64) == 0) goto L5;
            Map r100 = null;
        L7:
            if ((r212 & 128) == 0) goto L9;
            String r118 = "";
        L11:
            if ((r212 & 256) == 0) goto L13;
            boolean r119 = false;
        L14:
            r110.b(r111, r112, r113, r114, r115, r116, r100, r118, r119);
            return;
        L13:
            r119 = r211;
            goto L14
        L9:
            r118 = r210;
            goto L11
        L5:
            r100 = r117;
            goto L7
        }
    }

    void a(boolean r100, boolean r101);

    void b(Context r100, Lifecycle r101, ViewGroup r102, Map<String, ? extends Object> r103, String r104, Map<String, String> r105, Map<String, ? extends Object> r106, String r107, boolean r108);

    void c(String r100);

    void onAppBackground();

    void onAppForeground();

    void onDestroy();

    void onRefresh();
}
