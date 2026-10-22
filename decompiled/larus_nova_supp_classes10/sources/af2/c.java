package af2;

import com.bytedance.android.livesdk.link.model.a1;
import com.bytedance.android.livesdk.link.model.t1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final String a(b r1) {
        if ((r1 instanceof a1) == false) goto L7;
        return ((a1) r1).getUserId();
    L7:
        if ((r1 instanceof t1) == true) goto L9;
        return null;
    L9:
        return ((t1) r1).getUserId();
    }

    public static final long b(b r2) {
        if ((r2 instanceof a1) == false) goto L7;
        return ((a1) r2).getScore();
    L7:
        if ((r2 instanceof t1) == true) goto L9;
        return 0;
    L9:
        return ((t1) r2).getScore();
    }
}
