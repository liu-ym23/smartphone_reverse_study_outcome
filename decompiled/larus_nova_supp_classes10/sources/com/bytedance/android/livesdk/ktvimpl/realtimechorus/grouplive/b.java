package com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.p8;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        List r5 = (List) r4;
        this.a.getClass();
        KtvModeOrderedSongDataContext r6 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r6 == null) goto L17;
        MusicPanel r7 = r6.getKtvPublicFirstOrderedSong();
        if (r7 == null) goto L18;
        ALogger.i("GroupLiveChorusController", "observerKtvSingSongListChange -> showJoinChorusDialog");
        a r0 = this.a;
        if (r0.b == false) goto L12;
        ALogger.i("GroupLiveChorusController", "showJoinChorusDialog");
        int r1 = GroupLiveChorusBeInvitedDialog.f;
        Intrinsics.checkNotNullParameter(r7, "currentMusic");
        GroupLiveChorusBeInvitedDialog r2 = new GroupLiveChorusBeInvitedDialog();
        r2.e = r7;
        p8.a(r2, r0.a);
        KtvMusic r8 = r7.a;
        if (r8 == null) goto L11;
        r8.getTitle();
    L11:
        f2.g();
        r0.b = false;
    L12:
        Disposable r9 = this.a.c;
        if (r9 == null) goto L15;
        r9.dispose();
    L15:
        this.a.c = null;
        return;
    L18:
        return;
    }
}
