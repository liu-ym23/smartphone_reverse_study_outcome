package kh1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.liverecord.RecordEntranceDialog;
import com.bytedance.android.livesdk.chatroom.model.i2;
import com.bytedance.android.livesdk.chatroom.model.n2;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i2 f503433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecordEntranceDialog f503434b;

    public b(i2 r100, RecordEntranceDialog r101) {
        this.f503433a = r100;
        this.f503434b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        n2 r101 = this.f503434b.f106832g;
        if (r101 == null) goto L13;
        r101.a(this.f503433a, r100);
    L13:
        this.f503434b.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
