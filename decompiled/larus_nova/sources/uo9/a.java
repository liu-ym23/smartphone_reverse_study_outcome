package uo9;

import com.larus.office.plugins.snapshot.DocShotFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements yo9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocShotFragment f550942a;

    public a(DocShotFragment r100) {
        this.f550942a = r100;
    }

    @Override // yo9.a
    public final void onSnapshotFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        yo9.a r101 = this.f550942a.f363473g;
        if (r101 == null) goto L13;
        r101.onSnapshotFail(r100);
    L13:
        this.f550942a.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // yo9.a
    public final void onSnapshotSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        yo9.a r101 = this.f550942a.f363473g;
        if (r101 == null) goto L13;
        r101.onSnapshotSuccess(r100);
    L13:
        this.f550942a.dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
