package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a {
    public final /* synthetic */ g a;
    public final /* synthetic */ LifecycleOwner b;

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.b
    public final MusicPanel a() {
        KtvComponentOrderedSongDataContext r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r0 == null) goto L7;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.a.e;
    }

    public h(g r1, LifecycleOwner r2) {
        this.a = r1;
        this.b = r2;
    }
}
