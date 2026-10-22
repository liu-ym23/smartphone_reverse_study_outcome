package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostPermissionDependV2;", "", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permission", "", "", "callback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/OnPermissionCallback;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostPermissionDependV2 {
    void requestPermissions(Activity r100, String[] r101, OnPermissionCallback r102);
}
