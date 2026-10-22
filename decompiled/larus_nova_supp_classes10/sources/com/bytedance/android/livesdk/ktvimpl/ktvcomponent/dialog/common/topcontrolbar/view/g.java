package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ KtvComponentTopBarControlContainer a;

    public g(KtvComponentTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List r4 = (List) r3;
        if (ChorusContext.Companion.c() == true) goto L12;
        KtvComponentOrderedSongDataContext r5 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r5 == null) goto L9;
        List<SongUniqueInfo> r6 = r5.getKtvPublicSongUniqueInfoList();
        if (r6 == null) goto L9;
        int r7 = r6.size();
    L10:
        if (r7 > 0) goto L12;
        KtvComponentTopBarControlContainer r8 = this.a;
        r8.q = false;
        r8.j();
    L9:
        r7 = 0;
    L12:
        KtvComponentTopBarControlContainer r9 = this.a;
        KtvContext.Companion.getClass();
        boolean r0 = KtvContext.a.g().isCurrentUserIsSinger();
        int r1 = KtvComponentTopBarControlContainer.u;
        r9.i(r0);
    }
}
