package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class SubscribeResult extends Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SubscribedItem> f277610b;

    public SubscribeResult() {
    }

    public String getErrorMsg() {
        return this.f277609a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f277610b;
    }

    public void setErrorMsg(String r100) {
        this.f277609a = r100;
    }

    public void setSubscribedItems(List<SubscribedItem> r100) {
        this.f277610b = r100;
    }
}
