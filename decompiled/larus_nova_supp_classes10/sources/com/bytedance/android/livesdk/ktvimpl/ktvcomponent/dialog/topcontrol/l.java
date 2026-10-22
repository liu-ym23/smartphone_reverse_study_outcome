package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public ImageView a;
    public final LifecycleOwner b;
    public final String c;

    public final void a() {
        ChorusContext.a r0 = ChorusContext.Companion;
        if (r0.c() == false) goto L8;
        ChorusContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        List<MusicPanel> r2 = r1.getChorusNotSelfSeeingMusicList();
    L9:
        if (r2 != null) goto L11;
    L18:
        ImageView r3 = this.a;
        if (r3 == null) goto L21;
        r3.setAlpha(1.0f);
    L21:
        ImageView r4 = this.a;
        if (r4 == null) goto L27;
        r4.setTag(Boolean.TRUE);
        return;
    L27:
        return;
    L11:
        if (r2.isEmpty() != true) goto L18;
        ImageView r5 = this.a;
        if (r5 == null) goto L15;
        r5.setAlpha(0.5f);
    L15:
        ImageView r6 = this.a;
        if (r6 == null) goto L25;
        r6.setTag(Boolean.FALSE);
        return;
    L25:
        return;
    L7:
        r2 = null;
        goto L9
    L8:
        KtvContext.Companion.getClass();
        r2 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        goto L9
    }

    public l(LifecycleOwner r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        this.b = r2;
        this.c = r3;
    }
}
