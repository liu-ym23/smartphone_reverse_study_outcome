package com.ss.android.lark.chameleon.basewebview.interfaces;

import com.ss.android.lark.chameleon.basewebview.BizType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/interfaces/ILarkWebViewHybridMonitor;", "", "getBid", "", "getBizType", "Lcom/ss/android/lark/chameleon/basewebview/BizType;", "getMonitorDataCallback", "Lcom/ss/android/lark/chameleon/basewebview/interfaces/IMonitorDataCallback;", "openMonitor", "", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ILarkWebViewHybridMonitor {
    String getBid();

    BizType getBizType();

    IMonitorDataCallback getMonitorDataCallback();

    boolean openMonitor();
}
