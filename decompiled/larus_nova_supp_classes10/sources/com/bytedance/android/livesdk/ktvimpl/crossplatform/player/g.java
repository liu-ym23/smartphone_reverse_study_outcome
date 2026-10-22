package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g {
    public final CompositeDisposable a;
    public DownloadTask b;
    public Integer c;
    public TuningEffectAbility.b d;
    public final String e;
    public final j1 f;

    public static final class a {
    }

    static {
    }

    public final void a() {
        j1 r0 = this.f;
        if (r0 == null) goto L14;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L15;
        hg6.g r2 = r1.getRtcManager();
        if (r2 == null) goto L16;
        ec6.b r3 = r2.R();
        if (r3 == null) goto L17;
        com.bytedance.android.live.pushstream.d r4 = gc6.b.a(r3);
        if (r4 == null) goto L18;
        r4.u();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public g(j1 r3) {
        this.f = r3;
        this.a = new CompositeDisposable();
        StringBuilder r4 = new StringBuilder(KtvCommonConfigParams.a());
        String r0 = File.separator;
        r4.append(r0);
        r4.append("ktv_tunings");
        r4.append(r0);
        this.e = r4.toString();
    }
}
