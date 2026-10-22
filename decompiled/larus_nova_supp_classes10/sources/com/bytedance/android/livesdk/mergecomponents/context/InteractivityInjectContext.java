package com.bytedance.android.livesdk.mergecomponents.context;

import android.content.Context;
import com.bytedance.android.live.base.g;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.tj0;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.arch.IInjectBusinessContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class InteractivityInjectContext implements IInjectBusinessContext {
    public InteractivityInjectContext() {
    }

    public final void injectPreviewBusinessDataCenter(DataCenter r1, Room r2) {
    }

    public final void injectPreviewRoomController(DataCenter r1, Room r2) {
        IInjectBusinessContext.DefaultImpls.injectPreviewRoomController(this, r1, r2);
    }

    public final void injectPreviewBusinessRoomContext(final Context r3, CommonRoomContext r4, final DataCenter r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (((g) tj0.a.getValue()).a() == false) goto L5;
    L7:
        if (r5 != null) goto L10;
        return;
    L10:
        if ((r4 instanceof RoomContext) == true) goto L12;
        r4 = null;
    L12:
        final RoomContext r6 = (RoomContext) r4;
        if (r6 == null) goto L16;
        r6.getInteractivityContext().e(new InteractivityInjectContext$injectPreviewBusinessRoomContext$$inlined$apply$lambda$1(r6, r3, r5));
        return;
    L16:
        return;
    L5:
        if (LivePreviewDanmakuConfig.Companion.isPreviewDanmakuEnable() == true) goto L7;
    }
}
