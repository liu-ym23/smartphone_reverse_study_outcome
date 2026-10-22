package com.larus.bmhome.taskskill.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class r extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PcConnectionStatusView f314649a;

    public r(PcConnectionStatusView r100) {
        this.f314649a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        PcConnectionStatusView r101 = this.f314649a;
        PcConnectionStatusAction r102 = r101.f314609q;
        if (r102 == null) goto L8;
        Function1<PcConnectionStatusAction, Unit> r103 = r101.getOnActionClick();
        if (r103 == null) goto L9;
        r103.invoke(r102);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "drawState");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
    }
}
