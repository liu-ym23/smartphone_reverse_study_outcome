package com.bytedance.ee.bear.middleground.comment.audio;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecordPanelView f230342a;

    public j(RecordPanelView r100) {
        this.f230342a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RecordViewModel r101 = this.f230342a.getViewModel();
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter("en_us", "lanLocale");
        r101.f230321g.postValue("en_us");
        r101.f230319e.b("AUDIO_RECOGNIZE_LOCALE_SETTING_KEY", "en_us");
        return;
    }
}
