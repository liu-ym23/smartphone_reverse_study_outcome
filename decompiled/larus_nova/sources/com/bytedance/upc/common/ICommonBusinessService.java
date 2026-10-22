package com.bytedance.upc.common;

import android.content.Context;
import com.bytedance.upc.IUpcBusinessService;
import com.bytedance.upc.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/upc/common/ICommonBusinessService;", "Lcom/bytedance/upc/IUpcBusinessService;", "Landroid/content/Context;", "getContext", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public interface ICommonBusinessService extends IUpcBusinessService {
    a getConfiguration();

    Context getContext();
}
