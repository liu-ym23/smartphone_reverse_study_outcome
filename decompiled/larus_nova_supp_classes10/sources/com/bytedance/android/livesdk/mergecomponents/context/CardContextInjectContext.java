package com.bytedance.android.livesdk.mergecomponents.context;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.arch.IInjectBusinessContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CardContextInjectContext implements IInjectBusinessContext {
    public CardContextInjectContext() {
    }

    public final void injectPreviewBusinessDataCenter(DataCenter r1, Room r2) {
    }

    public final void injectPreviewRoomController(DataCenter r1, Room r2) {
        IInjectBusinessContext.DefaultImpls.injectPreviewRoomController(this, r1, r2);
    }

    public final void injectPreviewBusinessRoomContext(Context r2, final CommonRoomContext r3, final DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof RoomContext) == true) goto L7;
        CommonRoomContext r5 = null;
    L8:
        RoomContext r6 = (RoomContext) r5;
        if (r6 == null) goto L15;
        j r7 = r6.getCardContext();
        if (r7 == null) goto L16;
        r7.e(new CardContextInjectContext$injectPreviewBusinessRoomContext$$inlined$let$lambda$1(r4, r3));
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r5 = r3;
        goto L8
    }
}
