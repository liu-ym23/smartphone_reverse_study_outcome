package kr1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayActionSheet f505701a;

    public a(ReplayActionSheet r100) {
        this.f505701a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f505701a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L12;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
