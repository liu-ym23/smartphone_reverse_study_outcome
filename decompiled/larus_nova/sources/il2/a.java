package il2;

import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface a {

    /* JADX INFO: renamed from: il2.a$a, reason: collision with other inner class name */
    public static final class C6280a {
        public static /* synthetic */ a a(a r100, String r110, Map r111, boolean r112, String r113, String r114, String r115, int r116) {
            if ((r116 & 2) == 0) goto L5;
            Map r101 = null;
        L7:
            if ((r116 & 4) == 0) goto L9;
            boolean r102 = true;
        L11:
            if ((r116 & 8) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r116 & 16) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r116 & 32) == 0) goto L21;
            String r105 = null;
        L23:
            return r100.c(r110, r101, r102, r103, r104, r105);
        L21:
            r105 = r115;
            goto L23
        L17:
            r104 = r114;
            goto L19
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    LiveActionTracker a(g r100);

    b b();

    LiveActionTracker c(String r100, Map r101, boolean r102, String r103, String r104, String r105);

    LiveActionTracker d(d r100);
}
