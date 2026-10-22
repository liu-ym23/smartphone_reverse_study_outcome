package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.KSongOrderSongDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ KSongOrderSongDialog a;
    public final /* synthetic */ KtvComponentUIWidget b;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        ALogger.i(bb0.b.b(), "KSongOrderSongDialog dismiss, invoke class :".concat(e0.class.getSimpleName()));
        if (((Boolean) this.b.q.getValue()).booleanValue() == false) goto L13;
        Fragment r4 = this.a.requireActivity().getSupportFragmentManager().findFragmentByTag("KSongOrderSongDialog");
        if (r4 == null) goto L9;
        View r5 = r4.getView();
        if (r5 == null) goto L9;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131376922);
    L10:
        if (r6 == null) goto L14;
        r6.removeAllViews();
        return;
    L14:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public e0(KSongOrderSongDialog r1, KtvComponentUIWidget r2) {
        this.a = r1;
        this.b = r2;
    }
}
