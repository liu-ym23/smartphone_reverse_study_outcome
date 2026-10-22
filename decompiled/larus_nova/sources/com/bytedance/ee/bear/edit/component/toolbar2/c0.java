package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes16.dex */
public interface c0<T> extends tb5.i<T> {
    @Override // tb5.i, tb5.o
    @Nullable
    /* bridge */ /* synthetic */ BridgeAuthType authType();

    g45.a getEditPanel();

    int getType();

    @Override // tb5.i, tb5.o
    /* synthetic */ void handle(T r100, tb5.m r101);

    <V> void onToolbarItemClick(ItemIdV2 r100, V r101, int r102);
}
