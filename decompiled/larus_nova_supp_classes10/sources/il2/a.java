package il2;

import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {

    /* JADX INFO: renamed from: il2.a$a, reason: collision with other inner class name */
    public static final class C0145a {
        public static /* synthetic */ a a(a r9, String r10, Map r11, boolean r12, String r13, String r14, String r15, int r16) {
            if ((r16 & 2) == 0) goto L5;
            Map r4 = null;
        L7:
            if ((r16 & 4) == 0) goto L9;
            boolean r5 = true;
        L11:
            if ((r16 & 8) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r16 & 16) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r16 & 32) == 0) goto L21;
            String r8 = null;
        L23:
            return r9.c(r10, r4, r5, r6, r7, r8);
        L21:
            r8 = r15;
            goto L23
        L17:
            r7 = r14;
            goto L19
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }
    }

    LiveActionTracker a(g r1);

    b b();

    LiveActionTracker c(String r1, Map r2, boolean r3, String r4, String r5, String r6);

    LiveActionTracker d(d r1);
}
