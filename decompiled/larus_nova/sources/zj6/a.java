package zj6;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.live.photoviewer.transition.PhotoViewerDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewerDialog f572490a;

    @Override // zj6.c
    public final void onTransitionBegin(int r100) {
    }

    public a(PhotoViewerDialog r100) {
        this.f572490a = r100;
    }

    @Override // zj6.c
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L9;
        RecyclerView.LayoutManager r101 = this.f572490a.f255688a.getLayoutManager();
        if (r101 == null) goto L7;
        PhotoViewerDialog r102 = this.f572490a;
        ((LinearLayoutManager) r101).findFirstCompletelyVisibleItemPosition();
        r102.getClass();
        goto L9
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    L9:
        if (r100 != 2) goto L27;
        PhotoViewerDialog r103 = this.f572490a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r105 == null) goto L24;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r104.getLooper()) goto L15;
        r104.post(DialogLancet.createDismissRunnable(r103));
        return;
    }

    @Override // zj6.c
    public final void onTransitionChanged(int r100, float r101) {
        this.f572490a.f255689b.getBackground().setAlpha((int) (r101 * 255));
    }
}
