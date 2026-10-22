package ok1;

import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;

/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final void a(int r100, DataCenter r101) {
        InteractionWidgetsPosContext r102 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, r101, 0, 2);
        if (r102 == null) goto L8;
        m<b> r103 = r102.getMatchRoomMsgTrayPos();
        if (r103 == null) goto L9;
        r103.setValue(new b(r100, r103.getValue().f523619b));
        return;
    L9:
        return;
    }
}
