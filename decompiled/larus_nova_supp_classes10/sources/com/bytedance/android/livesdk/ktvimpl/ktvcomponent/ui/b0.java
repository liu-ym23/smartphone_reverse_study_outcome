package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 implements com.bytedance.android.live.ktv.common.music.download.p.a {
    public final /* synthetic */ KtvComponentUIWidget$mKtvCoreListener$1 a;
    public final /* synthetic */ MusicPanel b;

    public final void c(MusicPanel r1, int r2) {
    }

    public b0(KtvComponentUIWidget$mKtvCoreListener$1 r1, MusicPanel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(MusicPanel r1, String r2, String r3) {
        ALogger.d("KtvComponentUIWidget", "onPreparingSinging download onSuccessed.");
        KtvComponentUIWidget.Bq(this.a.a, this.b);
    }

    public final void b(MusicPanel r1, int r2, String r3) {
        ALogger.d("KtvComponentUIWidget", "onPreparingSinging download onFailed.");
        f2.b(2131918369, 0);
        KtvComponentUIWidget.Bq(this.a.a, this.b);
    }
}
