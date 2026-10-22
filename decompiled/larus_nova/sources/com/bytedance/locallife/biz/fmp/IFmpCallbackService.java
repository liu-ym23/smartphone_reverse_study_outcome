package com.bytedance.locallife.biz.fmp;

import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/biz/fmp/IFmpCallbackService;", "", "onFmpFinish", "", LiveEndPageData.TAG_WINDOW, "Landroid/view/Window;", "page", "", "onFmpStart", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IFmpCallbackService {
    void onFmpFinish(Window r100, String r101);

    void onFmpStart(Window r100, String r101);
}
