package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public d0(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        int r6 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        FragmentActivity r7 = this.a.e.getActivity();
        Function0<Unit> r0 = this.a.f.P();
        Intrinsics.checkNotNullParameter(r0, "onSwitchToPortrait");
        boolean r2 = false;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        if (r7 == null) goto L13;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.c(r7, r0);
    L13:
        r2 = true;
    L14:
        if (r2 == false) goto L16;
        return;
    L16:
        this.a.e.d0.k("input_left_button");
        Fragment r8 = this.a.e.b;
        if (r8 == null) goto L19;
        CommentVoiceExtraAnalyticParams.a.update(r8, "input_left_button");
    L19:
        this.a.o(true, Boolean.FALSE);
        return;
    L5:
        if (CommentUtils.b(r7) == false) goto L7;
        r1 = true;
        goto L8
    }
}
