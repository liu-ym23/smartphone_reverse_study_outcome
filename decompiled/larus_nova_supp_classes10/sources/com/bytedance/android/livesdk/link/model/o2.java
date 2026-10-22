package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o2 {
    public static final boolean a(m2 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$isLinkRoom");
        if (r3.getParticipantRooms() == null) goto L15;
        List<IRoom> r0 = r3.getParticipantRooms();
        if (r0 == null) goto L10;
        if (r0.isEmpty() != true) goto L10;
        return false;
    L10:
        if (r3.getRoomScene() != 1) goto L12;
    L13:
        return true;
    L12:
        if (r3.getRoomScene() == 7) goto L13;
        return false;
    L15:
        return false;
    }
}
