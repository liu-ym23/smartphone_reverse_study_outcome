package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c0<T> extends tb5.i<T> {
    @Override // tb5.i, tb5.o
    @Nullable
    /* bridge */ /* synthetic */ BridgeAuthType authType();

    g45.a getEditPanel();

    int getType();

    @Override // tb5.i, tb5.o
    /* synthetic */ void handle(T r1, tb5.m r2);

    <V> void onToolbarItemClick(ItemIdV2 r1, V r2, int r3);
}
