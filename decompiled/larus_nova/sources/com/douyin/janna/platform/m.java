package com.douyin.janna.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.ss.texturerender.TextureRenderKeys;

/* JADX INFO: loaded from: classes22.dex */
public final class m extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XMProcessor f273629a;

    public m(XMProcessor r100) {
        this.f273629a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ("hyper.os.POWER_MODE_LEVEL".equals(r101.getAction()) == false) goto L11;
        int r102 = r101.getIntExtra(TextureRenderKeys.KEY_IS_POWER_LEVEL, -1);
        int r103 = 0;
        Settings.System.getInt(this.f273629a.f273598a.getContentResolver(), "power_mode_level", 0);
        boolean r104 = hq7.a.f486512a;
        XMProcessor r105 = this.f273629a;
        if (r102 <= 0) goto L8;
        r103 = 1;
    L8:
        r105.f273603f = r103;
        r105.g(a.a(r103));
        return;
    }
}
