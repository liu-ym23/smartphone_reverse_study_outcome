package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentUnifiedVoiceComponentSimpleSession f230660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentUnifiedVoiceComponentSimpleSession.b f230661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f230662c;

    public q(CommentUnifiedVoiceComponentSimpleSession r100, CommentUnifiedVoiceComponentSimpleSession.b r101, ViewGroup r102) {
        this.f230660a = r100;
        this.f230661b = r101;
        this.f230662c = r102;
    }

    public final void a() {
        if (this.f230660a.j(this.f230661b) == true) goto L5;
        return;
    L5:
        if (this.f230662c.getParent() == null) goto L16;
        ViewGroup r100 = this.f230662c;
        r100.setElevation(UIUtils.dp2px(r100.getContext(), 16.0f));
        this.f230662c.bringToFront();
        ViewParent r101 = this.f230662c.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L10;
        ViewGroup r102 = (ViewGroup) r101;
    L11:
        if (r102 == null) goto L15;
        r102.requestLayout();
        return;
    L15:
        return;
    L10:
        r102 = null;
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
