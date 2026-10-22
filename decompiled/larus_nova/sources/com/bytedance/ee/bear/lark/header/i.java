package com.bytedance.ee.bear.lark.header;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes16.dex */
public interface i extends j {
    boolean a();

    void b(ConnectionService.NetworkState r100);

    void c(Context r100);

    View createView(Context r100);

    boolean isAdded();
}
