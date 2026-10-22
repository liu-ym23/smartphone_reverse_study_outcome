package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final void accept(Object r3) {
        final com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        ALogger.i("KtvComponentAnchorLogicWidget", "big event updateRealTimeChorusSwitch success");
        MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> r0 = KtvComponentContext.Companion.a();
        if (r0 == null) goto L6;
        com.bytedance.android.livesdk.ktvapi.util.d.b(r0, new KtvComponentAnchorLogicWidget$onChanged$1$1(r4));
        return;
    }
}
