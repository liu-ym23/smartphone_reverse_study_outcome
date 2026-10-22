package com.bytedance.ee.bear.bitable.card.viewmodel;

import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface v1 extends com.bytedance.ee.bear.browser.plugin.i, sq4.b.a {
    String getCurrentBaseId();

    int getCurrentCommentCount();

    List<String> getCurrentCommentIds();

    String getCurrentRecordId();

    String getCurrentTableId();

    boolean recordCardIsShow();

    void registerRecordPageLifeCycler(x1 r100);
}
