package com.ss.android.lark.thirdshare.panel;

import com.ss.android.lark.thirdshare.base.export.OnShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/thirdshare/panel/UGCompatUtilsKt$wrapShareCallback$1", "Lcom/ss/android/lark/thirdshare/base/export/OnShareCallback;", "onSuccess", "", "type", "Lcom/ss/android/lark/thirdshare/base/export/ShareActionType;", "onFailed", "error", "Lcom/ss/android/lark/thirdshare/base/export/OnShareCallback$ShareError;", "third-share-panel_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UGCompatUtilsKt$wrapShareCallback$1 extends OnShareCallback {
    final /* synthetic */ List<b> $actions;
    final /* synthetic */ a $callback;

    @Override // com.ss.android.lark.thirdshare.base.export.OnShareCallback
    public void onSuccess(ShareActionType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        f.a(r100, this.$actions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UGCompatUtilsKt$wrapShareCallback$1(List<? extends b> r100, a r101) {
        this.$actions = r100;
    }

    @Override // com.ss.android.lark.thirdshare.base.export.OnShareCallback
    public void onFailed(ShareActionType r100, OnShareCallback.ShareError r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "error");
        f.a(r100, this.$actions);
    }
}
