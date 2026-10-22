package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDepend;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lre7/c;", "params", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IChooseMediaResultCallback;", "callback", "", "handleJsInvoke", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface IHostMediaDepend {
    void handleJsInvoke(Context r100, re7.c r101, IChooseMediaResultCallback r102);
}
