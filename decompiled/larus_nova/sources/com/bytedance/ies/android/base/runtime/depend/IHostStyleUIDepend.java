package com.bytedance.ies.android.base.runtime.depend;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "已废弃", replaceWith = @ReplaceWith(expression = "com.bytedance.android.ad.sdk.api.ui.IAdHostStyleUIDepend", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001f\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/android/base/runtime/depend/IHostStyleUIDepend;", "", "getContainerLoadingView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "showDialog", "Landroid/app/Dialog;", "dialogBuilder", "Lcom/bytedance/ies/android/base/runtime/depend/DialogBuilder;", "showToast", "", "message", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "runtime-api_release"}, k = 1, mv = {1, 1, 16})
public interface IHostStyleUIDepend {
    View getContainerLoadingView(Context r100);

    Dialog showDialog(DialogBuilder r100);

    Boolean showToast(Context r100, String r101);
}
