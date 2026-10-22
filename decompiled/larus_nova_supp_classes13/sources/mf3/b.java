package mf3;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(mf3.a r12, Context r13, Lifecycle r14, ViewGroup r15, Map r16, String r17, Map r18, Map r19, String r20, boolean r21, int r22) {
            if ((r22 & 64) == 0) goto L5;
            Map r9 = null;
        L7:
            if ((r22 & 128) == 0) goto L9;
            String r10 = "";
        L11:
            if ((r22 & 256) == 0) goto L13;
            boolean r11 = false;
        L14:
            r12.b(r13, r14, r15, r16, r17, r18, r9, r10, r11);
            return;
        L13:
            r11 = r21;
            goto L14
        L9:
            r10 = r20;
            goto L11
        L5:
            r9 = r19;
            goto L7
        }
    }

    void a(boolean r1, boolean r2);

    void b(Context r1, Lifecycle r2, ViewGroup r3, Map<String, ? extends Object> r4, String r5, Map<String, String> r6, Map<String, ? extends Object> r7, String r8, boolean r9);

    void c(String r1);

    void onAppBackground();

    void onAppForeground();

    void onDestroy();

    void onRefresh();
}
