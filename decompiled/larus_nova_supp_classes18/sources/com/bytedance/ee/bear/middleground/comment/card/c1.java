package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c1 implements View.OnTouchListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public c1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        HalfScreenCardComment r0 = this.a;
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNull(r6);
        r0.getClass();
        if ((r5 instanceof TextView) == false) goto L5;
        TextView r1 = (TextView) r5;
    L7:
        if (r1 == null) goto L17;
        int r2 = r6.getAction() & 255;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L13;
    L15:
        r1.setText(2131890964);
        goto L17
    L13:
        if (r2 == 3) goto L15;
    L16:
        r1.setText(2131890974);
    L17:
        int r3 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        if (com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a(this.a.a.getActivity(), r6, this.a.b.P()) == false) goto L21;
        return true;
    L21:
        if (r6.getActionMasked() != 0) goto L25;
        Fragment r4 = this.a.a.b;
        if (r4 == null) goto L25;
        CommentVoiceExtraAnalyticParams.a.update(r4, "input_bottom_button");
    L25:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r7 = HalfScreenCardComment.a(this.a);
        if (r7 != null) goto L30;
        return false;
    L30:
        return r7.f(r5, r6);
    L5:
        r1 = null;
        goto L7
    }
}
