package com.ss.android.lark.inline.ai.ui.view;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/inline/ai/ui/view/AnchorParseFilter$filter$callbackWrapper$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnchorParseFilter$filter$callbackWrapper$1 implements IGetDataCallback<UrlInlinePreviewEntity> {
    final /* synthetic */ CharSequence $source;
    final /* synthetic */ a this$0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(UrlInlinePreviewEntity r100) {
        if (r100 == null) goto L5;
        String r101 = r100.f428709b;
    L6:
        StringBuilder r102 = new StringBuilder("title: ");
        r102.append(r101);
        r102.append("， icon: ");
        if (r100 == null) goto L9;
        String r103 = r100.f428710c;
    L10:
        r102.append(r103);
        Log.i("AnchorParseFilter", r102.toString());
        if (r101 != null) goto L14;
        Log.e("AnchorParseFilter", "filter err: title null");
        return;
    L14:
        throw null;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((UrlInlinePreviewEntity) r100);
    }

    public AnchorParseFilter$filter$callbackWrapper$1(a r100, CharSequence r101) {
        this.$source = r101;
    }
}
