package com.bytedance.android.livesdk.ktvimpl.chorus;

import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ChorusWidget a;

    public f(ChorusWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        List r11 = (List) sh6.c.b((sh6.b) r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (ChorusContext.Companion.d() == false) goto L20;
        ChorusWidget r0 = this.a;
        int r1 = ChorusWidget.f;
        r0.getClass();
        ArrayList r2 = new ArrayList();
        if (r11.size() < 5) goto L12;
        int r3 = 0;
    L10:
        if (r3 > 4) goto L13;
        r2.add(ListProtector.get(r11, r3));
        r3 = r3 + 1;
    L13:
        a.a("ChorusWidget", "needDownloadList count: " + r2.size());
        Iterator r12 = r2.iterator();
    L15:
        if (r12.hasNext() == false) goto L21;
        KtvMusicManager.e(KtvMusicManager.m, (MusicPanel) r12.next(), r0.e, false, null, false, 24);
        goto L15
    L21:
        return;
    L12:
        r2.addAll(r11);
        goto L13
    }
}
