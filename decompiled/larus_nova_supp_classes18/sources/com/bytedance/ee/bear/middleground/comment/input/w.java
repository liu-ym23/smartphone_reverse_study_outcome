package com.bytedance.ee.bear.middleground.comment.input;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements View.OnTouchListener {
    public final /* synthetic */ BaseInputComment a;

    public w(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        BaseInputComment r0 = this.a;
        r0.getClass();
        if ((!(r0 instanceof AsideInputComment)) == false) goto L8;
        int r1 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        FragmentActivity r2 = this.a.a.getActivity();
        Intrinsics.checkNotNull(r5);
        if (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a(r2, r5, this.a.b.P()) == false) goto L8;
        return true;
    L8:
        if (r5.getActionMasked() != 0) goto L12;
        Fragment r3 = this.a.a.b;
        if (r3 == null) goto L12;
        CommentVoiceExtraAnalyticParams.a.update(r3, "input_box");
    L12:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r6 = this.a.M();
        if (r6 == null) goto L15;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        return r6.c(r4, r5);
    L15:
        return false;
    }
}
