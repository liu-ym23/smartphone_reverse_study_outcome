package com.ss.android.lark.chatbase.view;

import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f416926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextChatView2 f416927b;

    public final void a() {
        boolean r100 = true;
        int r101 = 0;
        if (this.f416926a == false) goto L11;
        if (this.f416927b.f416910b.getVisibility() == 0) goto L7;
    L14:
        if (r100 == true) goto L16;
        return;
    L16:
        ConstraintSet r102 = new ConstraintSet();
        r102.clone(this.f416927b);
        if (this.f416926a == false) goto L19;
        int r103 = 0;
    L20:
        r102.setVisibility(R.id.post_show_more, r103);
        if (this.f416926a == true) goto L24;
        r101 = 8;
    L24:
        r102.setVisibility(R.id.post_show_more_text, r101);
        r102.applyTo(this.f416927b);
        return;
    L19:
        r103 = 8;
        goto L20
    L7:
        if (this.f416927b.f416911c.getVisibility() != 0) goto L14;
    L9:
        r100 = false;
        goto L14
    L11:
        if (this.f416927b.f416910b.getVisibility() != 8) goto L14;
        if (this.f416927b.f416911c.getVisibility() == 8) goto L9;
        goto L9
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

    public f(TextChatView2 r100, boolean r101) {
        this.f416927b = r100;
        this.f416926a = r101;
    }
}
