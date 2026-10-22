package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements md2.a {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.b
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.b
    public final MusicPanel a() {
        KtvComponentOrderedSongDataContext r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvPublicFirstOrderedSong();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.b
    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c c() {
        VideoChorusDataContext r0 = VideoChorusDataContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c> r1 = r0.getMusicPlayerProxy();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c) r1.getValue();
    L7:
        return null;
    }

    @Override // md2.a
    public final String getRoomId() {
        com.bytedance.live.datacontext.m r0 = o3.f().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.getIdStr();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }
}
