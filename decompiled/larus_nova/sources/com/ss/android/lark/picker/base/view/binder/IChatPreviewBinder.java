package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/IChatPreviewBinder;", "", "isEnableChatPreview", "", "()Z", "setEnableChatPreview", "(Z)V", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "startPreview", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatPreviewBinder {
    String getScene();

    boolean isEnableChatPreview();

    void setEnableChatPreview(boolean r100);

    void setScene(String r100);

    void startPreview(Context r100, SearchBaseInfo r101);
}
