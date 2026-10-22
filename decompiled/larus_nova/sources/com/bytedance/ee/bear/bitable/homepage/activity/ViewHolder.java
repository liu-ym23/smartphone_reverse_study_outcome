package com.bytedance.ee.bear.bitable.homepage.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.widgets.universedesign.SimpleTagTextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "userImage", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "getUserImage", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "userName", "Landroid/widget/TextView;", "getUserName", "()Landroid/widget/TextView;", "senderTag", "Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", "getSenderTag", "()Lcom/bytedance/ee/bear/widgets/universedesign/SimpleTagTextView;", RXScreenCaptureService.KEY_CONTENT_TEXT, "Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "getContentText", "()Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTextView;", "reactionIcon", "Landroid/widget/ImageView;", "getReactionIcon", "()Landroid/widget/ImageView;", "noticeTime", "getNoticeTime", "docTypeIcon", "getDocTypeIcon", "docName", "getDocName", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "rightLayout", "getRightLayout", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDAvatar f212294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f212295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleTagTextView f212296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentTextView f212297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f212298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f212299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f212300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f212301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f212302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f212303j;

    public ViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f212294a = (UDAvatar) r100.findViewById(R.id.user_icon);
        this.f212295b = (TextView) r100.findViewById(R.id.user_name);
        this.f212296c = (SimpleTagTextView) r100.findViewById(R.id.tag);
        this.f212297d = (CommentTextView) r100.findViewById(R.id.content);
        this.f212298e = (ImageView) r100.findViewById(R.id.reaction_icon);
        this.f212299f = (TextView) r100.findViewById(R.id.time);
        this.f212300g = (ImageView) r100.findViewById(R.id.doc_icon);
        this.f212301h = (TextView) r100.findViewById(R.id.doc_name);
        this.f212302i = (LinearLayout) r100.findViewById(R.id.time_layout);
        this.f212303j = (LinearLayout) r100.findViewById(R.id.right_layout);
    }
}
