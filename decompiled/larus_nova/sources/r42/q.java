package r42;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class q {
    static {
    }

    public static void a(String r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.put("history_comment_type", r100);
        j0.l().sendLog("livesdk_history_comment_click", r101, new Object[]{new x(), IRoom.class});
    }
}
