package pk2;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.s;
import io.reactivex.Observable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a {

    /* JADX INFO: renamed from: pk2.a$a, reason: collision with other inner class name */
    public static final class C0160a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable a(a r9, com.bytedance.android.livesdk.livecommerce.room.model.e r10, boolean r11, boolean r12, s r13, Map r14, String r15, int r16) {
            if ((r16 & 32) == 0) goto L5;
            Map r6 = null;
        L7:
            if ((r16 & 64) == 0) goto L9;
            String r7 = null;
        L11:
            return r9.a(r10, r11, false, r12, r13, r6, r7, null);
        L9:
            r7 = r15;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }
    }

    Observable<ECCurrentPromotion> a(com.bytedance.android.livesdk.livecommerce.room.model.e r1, boolean r2, boolean r3, boolean r4, s r5, Map<String, String> r6, String r7, uj2.c r8);
}
