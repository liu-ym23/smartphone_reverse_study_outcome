package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ RecordPanelView a;

    public j(RecordPanelView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        RecordViewModel r4 = this.a.getViewModel();
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullParameter("en_us", "lanLocale");
        r4.g.postValue("en_us");
        r4.e.b("AUDIO_RECOGNIZE_LOCALE_SETTING_KEY", "en_us");
        return;
    }
}
