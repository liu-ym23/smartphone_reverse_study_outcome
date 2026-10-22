package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingLanguageChooseView f436387a;

    public a(MmRecordingLanguageChooseView r100) {
        this.f436387a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f436387a.f436363b;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
