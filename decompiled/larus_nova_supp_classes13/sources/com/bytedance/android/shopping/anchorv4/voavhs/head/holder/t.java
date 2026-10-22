package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4VideoView;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b {
    public final /* synthetic */ r a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ h83.g c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final Integer a() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final x73.c getSharePlayer() {
        return null;
    }

    @Override // ee3.c
    public final void onTransitionBegin(int r1) {
    }

    @Override // ee3.c
    public final void onTransitionChanged(int r1, float r2) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b getPlayInfo() {
        h83.g r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // ee3.c
    public final PlayerBlock getPlayer() {
        r r0 = this.a;
        View r1 = (View) this.b.invoke();
        r0.getClass();
        AnchorV4VideoView r2 = r.A(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getPlayerBlock();
    }

    public t(r r1, Function0 r2, h83.g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
