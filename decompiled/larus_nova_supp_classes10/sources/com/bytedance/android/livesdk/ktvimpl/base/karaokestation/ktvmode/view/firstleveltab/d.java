package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import android.content.DialogInterface;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements DialogInterface.OnClickListener {
    public final /* synthetic */ MineFirstLevelTabFragment a;
    public final /* synthetic */ List b;
    public final /* synthetic */ y c;

    public d(MineFirstLevelTabFragment r1, List r2, y r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        r2.dismiss();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = this.a.E;
        if (r4 == null) goto L6;
        r4.orderPlayAllSong(this.b, this.c);
        return;
    }
}
