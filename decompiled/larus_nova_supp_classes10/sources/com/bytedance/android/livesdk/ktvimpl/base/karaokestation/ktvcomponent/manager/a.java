package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ KtvComponentFirstLevelTabManager a;

    public a(KtvComponentFirstLevelTabManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Integer r3 = (Integer) r2;
        KtvComponentFirstLevelTabManager r4 = this.a;
        int r0 = KtvComponentFirstLevelTabManager.q;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = r4.m;
        if (r5 == null) goto L8;
        MutableLiveData<vb0.a> r6 = r5.getOrderSongUiState();
        if (r6 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r6, KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1.INSTANCE);
        return;
    L9:
        return;
    }
}
