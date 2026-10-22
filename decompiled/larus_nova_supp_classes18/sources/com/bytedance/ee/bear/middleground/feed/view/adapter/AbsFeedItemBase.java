package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.middleground.feed.export.bean.AbsBaseBean;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.glide.BearGlideUrl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class AbsFeedItemBase<Data extends AbsBaseBean> implements ag5.a<FeedBaseViewHolder, Data> {
    public final Function1<String, Unit> a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u001aX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/view/adapter/AbsFeedItemBase$FeedBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTvContent", "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getMTvContent", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "setMTvContent", "(Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;)V", "mUserImg", "Landroid/widget/ImageView;", "getMUserImg", "()Landroid/widget/ImageView;", "setMUserImg", "(Landroid/widget/ImageView;)V", "mUnReadIco", "getMUnReadIco", "()Landroid/view/View;", "setMUnReadIco", "mDivider", "getMDivider", "setMDivider", "mTvTime", "Landroid/widget/TextView;", "getMTvTime", "()Landroid/widget/TextView;", "setMTvTime", "(Landroid/widget/TextView;)V", "middleground-feed_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class FeedBaseViewHolder extends RecyclerView.ViewHolder {
        public View T3() {
            Intrinsics.throwUninitializedPropertyAccessException("mDivider");
            return null;
        }

        public CommentTextView U3() {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
            return null;
        }

        public TextView V3() {
            Intrinsics.throwUninitializedPropertyAccessException("mTvTime");
            return null;
        }

        public View W3() {
            Intrinsics.throwUninitializedPropertyAccessException("mUnReadIco");
            return null;
        }

        public ImageView X3() {
            Intrinsics.throwUninitializedPropertyAccessException("mUserImg");
            return null;
        }

        public FeedBaseViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbsFeedItemBase(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "gotoProfile");
        this.a = r2;
    }

    public final void a(RecyclerView.Adapter r8, FeedBaseViewHolder r9, AbsBaseBean r10) {
        Intrinsics.checkNotNullParameter(r8, "adapter");
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, WikiFolderPushPlugin.DATA);
        int r2 = 0;
        RichTextInjector.b(r9.U3(), null, null, false, 24);
        Glide.with(((RecyclerView.ViewHolder) r9).itemView.getContext()).load(new BearGlideUrl(r10.getAvatarUrl())).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(2131235295).into(r9.X3());
        r9.X3().setOnClickListener(new com.bytedance.ee.bear.middleground.feed.view.adapter.a(r10, this));
        TextView r11 = r9.V3();
        Context r0 = r9.U3().getContext();
        String r1 = zu5.a.b(r0, r10.getCreateTime() * ((long) CCMLynxCardView.ViewType.BANNER));     // Catch: Exception -> L5
    L6:
        r11.setText(r1);
        View r12 = r9.W3();
        if (r10.getReadStatus() != 1) goto L9;
        int r3 = 0;
    L10:
        r12.setVisibility(r3);
        View r13 = r9.T3();
        if (r10.isLastItem() == false) goto L13;
        r2 = 8;
    L13:
        r13.setVisibility(r2);
        return;
    L9:
        r3 = 8;
    L5:
        tt5.a.k("AbsFeedItemBase", "the time isn't right");
        r1 = String.valueOf(r10.getCreateTime());
        goto L6
    }
}
