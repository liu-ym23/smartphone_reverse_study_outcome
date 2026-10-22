package com.bytedance.ee.bear.bitable.itemview.record.menu;

import com.bytedance.ee.bear.bitable.card.view.page.RecordSubscribeStatus;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;

/* JADX INFO: loaded from: classes15.dex */
public interface g {
    void addOperationListener(sq4.b.a r100);

    BitableAnalytic bitableAnalytic();

    void closeAutoSubscribe();

    boolean getCloseAutoSubscribe();

    boolean getRecordCloseAutoSubscribe(String r100);

    RecordSubscribeStatus getSubscribeStatus(String r100);

    boolean isShowInRecord();

    void removeOperationListener(sq4.b.a r100);

    void setRecordCloseAutoSubscribe(String r100);

    void setSubscribeStatus(String r100, RecordSubscribeStatus r101);
}
