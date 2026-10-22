package com.bytedance.android.livesdk.mergecomponents.context;

import android.content.Context;
import com.bytedance.android.livesdkapi.arch.CommonRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.arch.IInjectBusinessContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements IInjectBusinessContext {
    public a() {
    }

    public final void injectPreviewBusinessDataCenter(DataCenter r1, Room r2) {
    }

    public final void injectPreviewBusinessRoomContext(Context r1, CommonRoomContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    public final void injectPreviewRoomController(DataCenter r1, Room r2) {
        IInjectBusinessContext.DefaultImpls.injectPreviewRoomController(this, r1, r2);
    }
}
