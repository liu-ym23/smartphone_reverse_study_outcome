package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements com.bytedance.android.ec.model.j {
    public final /* synthetic */ j a;

    public final void onClick() {
    }

    public final void onClose(boolean r1) {
    }

    public final void onReturnClick() {
    }

    public final void onShow() {
    }

    public f(j r1) {
        this.a = r1;
    }

    public final void onMuteButtonClick(boolean r3) {
        if (r3 == true) goto L15;
        PlayerBlock r4 = this.a.e;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.isPlaying() != true) goto L17;
        PlayerBlock r5 = this.a.e;
        if (r5 != null) goto L10;
    L12:
        if (r5 == null) goto L18;
        PlayerBlock.o(r5, false, 3);
        return;
    L18:
        return;
    L10:
        if (r5.o != true) goto L12;
        return;
    L17:
        return;
    }
}
