package com.larus.uaigc.chat.block.correction;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CorrectionImageView f370443a;

    public /* synthetic */ j(CorrectionImageView r100) {
        this.f370443a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CorrectionImageView r100 = this.f370443a;
        SimpleDraweeView r101 = r100.f370406a;
        if (r101 == null) goto L5;
        r101.setAlpha(1.0f);
    L5:
        ShimmerTextView r102 = r100.f370411f;
        if (r102 == null) goto L8;
        r102.x();
    L8:
        ConstraintLayout r103 = r100.f370409d;
        if (r103 == null) goto L12;
        e1.o(r103);
        return;
    }
}
