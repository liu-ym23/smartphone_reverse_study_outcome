package com.ss.android.lark.feed.cardcomponent.preview;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.feed.app.entity.DigestElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/feed/cardcomponent/preview/FeedDigestTextView$createCallback$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", "aBoolean", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDigestTextView$createCallback$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ int $emojiSizeDp;
    final /* synthetic */ FeedDigestTextView this$0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(boolean r100) {
        List<? extends DigestElement> r101 = this.this$0.f420874a;
        if (r101 == null) goto L6;
        FeedDigestTextView r102 = this.this$0;
        r102.setText(r102.x(r101, null, this.$emojiSizeDp));
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess(((Boolean) r100).booleanValue());
    }

    public FeedDigestTextView$createCallback$1(FeedDigestTextView r100, int r101) {
        this.this$0 = r100;
        this.$emojiSizeDp = r101;
    }
}
