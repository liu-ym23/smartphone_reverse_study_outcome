package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r2) {
            r2.a(FirstLevelTab.OrderSongTab.getValue(), "");
        }
    }

    void a(int r1, String r2);

    com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r1);

    void c(Integer r1, String r2);

    void clearData();
}
