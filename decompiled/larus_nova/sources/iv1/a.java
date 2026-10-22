package iv1;

import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.q;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    public static q a(DataCenter r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        return ((IRoomContextService) k.n(IRoomContextService.class)).getRoomDslService(r100, 0);
    }
}
