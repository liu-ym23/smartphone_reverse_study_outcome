package com.ss.android.lark.feed.shared.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/feed/shared/page/FeedItemsFragment$feedItemListener$2$1$drawFeedItemOnView$1$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Landroid/graphics/Bitmap;", "onSuccess", "", SimplayerImageStrategy.RESULT_BITMAP, LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedItemsFragment$feedItemListener$2$1$drawFeedItemOnView$1$1 implements IGetDataCallback<Bitmap> {
    final /* synthetic */ AppCompatImageView $containerView;
    final /* synthetic */ View $contentView;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        this.$contentView.buildDrawingCache();
        this.$containerView.setImageBitmap(this.$contentView.getDrawingCache());
    }

    public void onSuccess(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Bitmap.Config r101 = r100.getConfig();
        if (r101 == null) goto L6;
        View r102 = this.$contentView;
        AppCompatImageView r103 = this.$containerView;
        com.ss.android.lark.forsetiutils.b r104 = com.ss.android.lark.forsetiutils.b.f424768a;
        Context r105 = r102.getContext();
        r104.getClass();
        com.ss.android.lark.forsetiutils.b.c(r105);
        r103.setImageDrawable(new ukb.a(r103.getResources(), r100.copy(r101, true)));
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Bitmap) r100);
    }

    public FeedItemsFragment$feedItemListener$2$1$drawFeedItemOnView$1$1(View r100, AppCompatImageView r101) {
        this.$contentView = r100;
        this.$containerView = r101;
    }
}
