package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import android.content.Context;
import com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog;
import com.bytedance.android.live.liveinteract.videotalk.emoji.VoiceChatDynamicEmojiDialog;
import com.bytedance.android.live.liveinteract.videotalk.emoji.y;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/emoji/KtvRoomDynamicEmojiDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/VoiceChatDynamicEmojiDialog;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomDynamicEmojiDialog extends VoiceChatDynamicEmojiDialog {

    public static final class a {
    }

    static {
    }

    public final void b1() {
        int r0 = y.a;
        y.d(((BaseDynamicEmojiDialog) this).u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c1() {
        int r0 = y.a;
        y.e(((BaseDynamicEmojiDialog) this).D, getContext(), ((BaseDynamicEmojiDialog) this).u);
    }

    public final boolean T0() {
        if (jc0.a.a() == false) goto L8;
        b.X0.getClass();
        b r0 = b.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canSilenceSelf();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.canSilenceSelf();
    }

    public KtvRoomDynamicEmojiDialog(Context r2, DataCenter r3, boolean r4) {
        super(r2, r3, r4, false);
    }
}
