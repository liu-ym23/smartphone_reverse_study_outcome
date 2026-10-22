package com.bytedance.lark.lynxlib.image;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements rkb.g<Object, Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a f253274a;

    public e(com.bytedance.lynx.tasm.ui.imageloader.a.InterfaceC3714a r100) {
        this.f253274a = r100;
    }

    @Override // rkb.g
    public final boolean onLoadFailed(Exception r100, Object r101, Target<Drawable> r102, boolean r103) {
        if (r100 == null) goto L6;
        String r104 = r100.getLocalizedMessage();
        if (r104 == null) goto L6;
    L7:
        Log.e("LynxImageAdapter", "onLoadFailed: ".concat(r104));
        this.f253274a.a(null, r100);
        return false;
    L6:
        r104 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
        goto L7
    }

    @Override // rkb.g
    public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r100, Object r101, Target<Drawable> r102, DataSource r103, boolean r104) {
        return false;
    }
}
