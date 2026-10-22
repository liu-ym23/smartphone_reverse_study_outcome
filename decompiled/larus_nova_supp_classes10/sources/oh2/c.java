package oh2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void b(c r6, String r7, boolean r8, String r9, View r10) {
            r6.a(r7, r8, r9, null, r10);
        }

        public static /* synthetic */ void a(c r11, Context r12, String r13, Integer r14, com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r15, com.bytedance.android.btm.api.model.d r16, String r17, il2.a r18) {
            r11.c(r12, r13, r14, r15, 0, 0, null, r16, r17, r18);
        }
    }

    void a(String r1, boolean r2, String r3, BtmItemBuilder r4, View r5);

    Long b(long r1, long r3);

    void c(Context r1, String r2, Integer r3, com.bytedance.android.livesdk.livecommerce.intro.model.resp.b r4, int r5, int r6, cf.a r7, com.bytedance.android.btm.api.model.d r8, String r9, il2.a r10);
}
