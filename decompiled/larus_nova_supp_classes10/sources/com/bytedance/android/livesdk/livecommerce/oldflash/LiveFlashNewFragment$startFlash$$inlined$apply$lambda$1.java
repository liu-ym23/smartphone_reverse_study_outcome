package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveFlashNewFragment$startFlash$$inlined$apply$lambda$1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveFlashNewFragment a;

    public LiveFlashNewFragment$startFlash$$inlined$apply$lambda$1(LiveFlashNewFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        LiveFlashNewFragment r5 = this.a;
        int r0 = LiveFlashNewFragment.w;
        UtilityKotlinExtentionsKt.f((LiveFlashViewModel) r5.g, r5.m, new AnonymousClass1(this));
        r3.dismiss();
    }
}
