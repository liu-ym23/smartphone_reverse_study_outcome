package com.bytedance.upc;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/upc/IUpcLifecycleService;", "", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public interface IUpcLifecycleService {
    void init(Context r100, a r101);

    int priority();
}
