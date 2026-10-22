package com.bytedance.ee.bear.middleground.comment.input;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b1 implements View.OnTouchListener {
    public final /* synthetic */ InputComment a;

    public b1(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        int r0 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        FragmentActivity r1 = this.a.a.getActivity();
        Intrinsics.checkNotNull(r5);
        if (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a(r1, r5, this.a.b.P()) == false) goto L7;
        return true;
    L7:
        if (r5.getActionMasked() != 0) goto L11;
        Fragment r2 = this.a.a.b;
        if (r2 == null) goto L11;
        CommentVoiceExtraAnalyticParams.a.update(r2, "input_box");
    L11:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r3 = this.a.I();
        if (r3 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        return r3.c(r4, r5);
    L14:
        return false;
    }
}
