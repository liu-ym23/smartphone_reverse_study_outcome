package com.ss.android.lark.chameleon.pluginapi;

import android.view.View;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Deprecated(message = "此接口已废弃，不建议使用")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/ILoadingPlugin;", "", "getLoadingView", "Landroid/view/View;", "onLoadSuccess", "", "onLoadFail", "code", "", "e", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILoadingPlugin {
    View getLoadingView();

    void onLoadFail(int r100, Throwable r101);

    void onLoadSuccess();
}
