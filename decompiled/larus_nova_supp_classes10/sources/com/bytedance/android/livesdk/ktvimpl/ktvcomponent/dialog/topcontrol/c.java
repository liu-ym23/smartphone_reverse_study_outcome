package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public ImageView a;
    public final CompositeDisposable b;
    public final String c;

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        this.c = r2;
        this.b = new CompositeDisposable();
    }

    public final void a(boolean r4) {
        ChorusContext.a r0 = ChorusContext.Companion;
        ChorusContext r1 = r0.getContext();
        if (r1 == null) goto L9;
        n<List<MusicPanel>> r2 = r1.getChorusSelectedSongList();
        if (r2 == null) goto L9;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L9;
        int r5 = r3.size();
    L10:
        if (r4 == false) goto L14;
        KtvContext.Companion.getClass();
        if (((Boolean) KtvContext.a.g().getHasBgm().getValue()).booleanValue() == false) goto L14;
    L22:
        ImageView r6 = this.a;
        if (r6 == null) goto L25;
        r6.setAlpha(1.0f);
    L25:
        ImageView r7 = this.a;
        if (r7 == null) goto L35;
        r7.setTag(Boolean.TRUE);
        return;
    L35:
        return;
    L14:
        if (r0.c() == true) goto L16;
    L18:
        MultiChorusContext.a r8 = MultiChorusContext.Companion;
        if (r8.c() == true) goto L21;
    L28:
        ImageView r9 = this.a;
        if (r9 == null) goto L31;
        r9.setAlpha(0.5f);
    L31:
        ImageView r10 = this.a;
        if (r10 == null) goto L37;
        r10.setTag(Boolean.FALSE);
        return;
    L37:
        return;
    L21:
        if (r8.a() != 2) goto L28;
    L16:
        if (r0.a() != 2) goto L18;
        if (r5 != 0) goto L22;
    L9:
        r5 = 0;
        goto L10
    }
}
