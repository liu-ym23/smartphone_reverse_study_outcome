package com.ss.android.lark.thirdshare.panel;

import android.content.Context;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.base.export.ShareEntity;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/thirdshare/panel/ShareAction$Image$Companion$imageShareActionType$1$1", "Lcom/ss/android/lark/thirdshare/base/export/ShareActionType$ShareItemClickListener;", SendEventContainerMethodParamModel.EventKinds.onClick, "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shareEntity", "Lcom/ss/android/lark/thirdshare/base/export/ShareEntity;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareAction$Image$Companion$imageShareActionType$1$1 extends ShareActionType.ShareItemClickListener {
    @Override // com.ss.android.lark.thirdshare.base.export.ShareActionType.ShareItemClickListener
    public void onClick(Context r100, ShareEntity r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "shareEntity");
    }

    public ShareAction$Image$Companion$imageShareActionType$1$1(ShareActionType r100) {
        super(r100);
    }
}
