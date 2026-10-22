package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {
    void onInvalidated();

    void setNetworkState(NetState r1);

    void setPageTimestamp(List<Long> r1);

    void setTotalCount(int r1);
}
