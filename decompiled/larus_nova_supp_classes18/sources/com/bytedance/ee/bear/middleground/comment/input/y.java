package com.bytedance.ee.bear.middleground.comment.input;

import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements View.OnTouchListener {
    public final /* synthetic */ BaseInputComment a;

    public y(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        if (r5.getActionMasked() != 0) goto L7;
        Fragment r0 = this.a.a.b;
        if (r0 == null) goto L7;
        CommentVoiceExtraAnalyticParams.a.update(r0, "input_bottom_button");
    L7:
        BaseInputComment r1 = this.a;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        return r1.e0(r4, r5);
    }
}
