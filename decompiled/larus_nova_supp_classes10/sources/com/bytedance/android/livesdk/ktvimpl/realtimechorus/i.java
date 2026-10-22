package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ RTChorusMusicInfoView a;

    public i(RTChorusMusicInfoView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.y((MidiSkinDressInfo) sh6.c.b((sh6.b) r2));
    }
}
