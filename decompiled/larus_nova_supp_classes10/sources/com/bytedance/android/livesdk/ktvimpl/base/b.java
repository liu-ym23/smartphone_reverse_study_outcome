package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedViewService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements IKtvComponentFeedViewService {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public final IKtvComponentFeedView getKtvComponentFeedView() {
        return jc1.k.n(IKtvService.class).getKtvComponentFeedView(s1.getContext(), false);
    }
}
