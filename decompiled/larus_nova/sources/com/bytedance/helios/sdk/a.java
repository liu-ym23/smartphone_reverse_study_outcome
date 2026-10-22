package com.bytedance.helios.sdk;

import android.util.Pair;
import com.bytedance.helios.api.consumer.PrivacyEvent;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    Pair<Boolean, Object> actionIntercept(PrivacyEvent r100);

    void actionInvoke(PrivacyEvent r100);

    PrivacyEvent createPrivacyEvent(Object r100, Object r101, Object[] r102, int r103, String r104, long r105, boolean r106, String r107, String r110);
}
