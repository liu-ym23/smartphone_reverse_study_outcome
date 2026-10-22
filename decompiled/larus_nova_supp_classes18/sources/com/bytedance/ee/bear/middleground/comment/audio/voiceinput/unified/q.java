package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements Runnable {
    public final /* synthetic */ CommentUnifiedVoiceComponentSimpleSession a;
    public final /* synthetic */ CommentUnifiedVoiceComponentSimpleSession.b b;
    public final /* synthetic */ ViewGroup c;

    public q(CommentUnifiedVoiceComponentSimpleSession r1, CommentUnifiedVoiceComponentSimpleSession.b r2, ViewGroup r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        if (this.a.j(this.b) == true) goto L5;
        return;
    L5:
        if (this.c.getParent() == null) goto L16;
        ViewGroup r0 = this.c;
        r0.setElevation(UIUtils.dp2px(r0.getContext(), 16.0f));
        this.c.bringToFront();
        ViewParent r1 = this.c.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L10;
        ViewGroup r2 = (ViewGroup) r1;
    L11:
        if (r2 == null) goto L15;
        r2.requestLayout();
        return;
    L15:
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
