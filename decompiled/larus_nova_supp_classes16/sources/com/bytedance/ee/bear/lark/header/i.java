package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface i extends j {
    boolean a();

    void b(ConnectionService.NetworkState r1);

    void c(Context r1);

    View createView(Context r1);

    boolean isAdded();
}
