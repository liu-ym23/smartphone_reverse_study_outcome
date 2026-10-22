package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.business.VideoHolderItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b {
    public final /* synthetic */ VideoHolderItem a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b
    public final Integer a() {
        return null;
    }

    @Override // ee3.c
    public final PlayerBlock getPlayer() {
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
        return this.a.getVideoModel(PlayerViewScene.SCENE_HEAD_GALLERY_VIDEO);
    }

    public j(VideoHolderItem r1) {
        this.a = r1;
    }
}
