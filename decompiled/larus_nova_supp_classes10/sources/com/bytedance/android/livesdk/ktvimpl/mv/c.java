package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c extends com.bytedance.android.livesdk.ktvimpl.base.frame.c {
    boolean a();

    KtvContext b();

    void d(m r1);

    List<MusicPanel> f();

    DataCenter getDataCenter();

    long getRoomId();

    lb0.b k();

    void l(String r1);

    void n(com.bytedance.android.livesdk.ktvimpl.base.viewmodel.b r1);
}
