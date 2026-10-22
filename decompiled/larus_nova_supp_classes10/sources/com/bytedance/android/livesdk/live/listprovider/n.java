package com.bytedance.android.livesdk.live.listprovider;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.IMultiRoomListProvider;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n extends DrawRoomListProvider implements IMultiRoomListProvider {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.live.listprovider.DrawRoomListProvider
    public final String providerType() {
        return "MultiRoomListProvider";
    }

    @Override // com.bytedance.android.livesdk.live.listprovider.DrawRoomListProvider
    public final void release() {
        Set r0 = ((ILiveRoomListProvider) this).mListeners;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.y.clear();
        this.w = false;
    }

    public final void onDestroy() {
        super.release();
    }

    public n(Bundle r10, String r11, Room r12) {
        Intrinsics.checkNotNullParameter(r10, "roomArgs");
        Intrinsics.checkNotNullParameter(r11, "url");
        super(r10, r11, "", null, r12, null, false);
    }

    public final void parseRoomInfo(List<FeedItem> r9, FeedExtra r10, Boolean r11) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
        return;
    L6:
        if (r11 == null) goto L8;
        boolean r3 = r11.booleanValue();
    L9:
        DrawRoomListProvider.J(this, r9, r10, r3, 0, false, false, 56);
        return;
    L8:
        r3 = true;
        goto L9
    }
}
