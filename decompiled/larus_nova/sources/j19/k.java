package j19;

import android.view.View;
import com.larus.common_ui.photoviewer.PhotoViewerDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class k implements l19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewerDialogFragment f496877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f496878b;

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        Iterator<d> r101 = this.f496877a.f327647j.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTransitionBegin(r100);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        if (r100 != 0) goto L4;
        this.f496877a.U90();
    L17:
        Iterator<d> r101 = this.f496877a.f327647j.iterator();
    L19:
        if (r101.hasNext() == false) goto L21;
        r101.next().onTransitionEnd(r100);
        goto L19
    L21:
        return;
    L4:
        if (r100 == 2) goto L22;
        if (r100 != 3) goto L17;
        PhotoViewerDialogFragment r102 = this.f496877a;
        r102.f327649l = r102.f327648k;
        goto L17
    L22:
        this.f496877a.dismiss();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L17;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L17
    }

    public k(PhotoViewerDialogFragment r100, View r101) {
        this.f496877a = r100;
        this.f496878b = r101;
    }

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
        PhotoViewerDialogFragment r102 = this.f496877a;
        if (r100 != 0) goto L5;
        float r103 = r101;
    L15:
        r102.f327648k = r103;
        this.f496878b.getBackground().setAlpha((int) (this.f496877a.f327648k * 255));
        Iterator<d> r104 = this.f496877a.f327647j.iterator();
    L17:
        if (r104.hasNext() == false) goto L19;
        r104.next().onTransitionChanged(r100, r101);
        goto L17
    L19:
        return;
    L5:
        if (r100 != 1) goto L7;
        float r105 = r102.f327649l;
        r103 = r105 + ((1 - r105) * r101);
        goto L15
    L7:
        if (r100 == 2) goto L12;
        r103 = 1.0f;
        if (r100 != 3) goto L15;
        r103 = 1 - Math.min(1.0f, Math.max(r101, 0.0f));
        goto L15
    L12:
        r103 = r102.f327649l * (1 - r101);
        goto L15
    }
}
