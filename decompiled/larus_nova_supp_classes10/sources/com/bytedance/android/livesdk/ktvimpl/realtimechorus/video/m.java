package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements DialogInterface.OnDismissListener {
    public final /* synthetic */ KSongOrderSongDialog a;

    public m(KSongOrderSongDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Fragment r3 = this.a.requireActivity().getSupportFragmentManager().findFragmentByTag("KSongOrderSongDialog");
        if (r3 == null) goto L7;
        View r4 = r3.getView();
        if (r4 == null) goto L7;
        FrameLayout r5 = (FrameLayout) r4.findViewById(2131376922);
    L8:
        if (r5 == null) goto L11;
        r5.removeAllViews();
        return;
    L11:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
