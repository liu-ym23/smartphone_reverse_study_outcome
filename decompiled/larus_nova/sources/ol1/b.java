package ol1;

import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.dialog.ReplayDanmakuInputDialog;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import mq1.o;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayDanmakuInputDialog f524118a;

    public b(ReplayDanmakuInputDialog r100) {
        this.f524118a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f524118a.f109084h.f519542d.onNext(Boolean.TRUE);
        this.f524118a.dismiss();     // Catch: Exception -> L5
    L9:
        o r102 = s.d();
        if (r102 == null) goto L15;
        r102.onInputStateChange(false);
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L9;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
