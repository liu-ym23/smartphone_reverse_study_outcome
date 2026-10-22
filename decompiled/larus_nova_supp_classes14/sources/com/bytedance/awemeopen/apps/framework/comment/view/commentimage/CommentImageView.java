package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AB\u001b\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\b@\u0010DJ\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006E"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/commentimage/CommentImageView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lkotlin/Function1;", "", "", "closeAction", "setCloseCommentButton", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "getMCommentImageContainer", "()Landroid/view/ViewGroup;", "setMCommentImageContainer", "(Landroid/view/ViewGroup;)V", "mCommentImageContainer", "Landroid/view/View;", "b", "Landroid/view/View;", "getMCloseCommentImage", "()Landroid/view/View;", "setMCloseCommentImage", "(Landroid/view/View;)V", "mCloseCommentImage", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "d", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "getMViewPager", "()Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "setMViewPager", "(Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;)V", "mViewPager", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "f", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "getMPageOwner", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "setMPageOwner", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;)V", "mPageOwner", "Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "g", "Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "getMPageParam", "()Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "setMPageParam", "(Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;)V", "mPageParam", "h", "Lkotlin/jvm/functions/Function1;", "getCloseAction", "()Lkotlin/jvm/functions/Function1;", "setCloseAction", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentImageView extends FrameLayout implements View.OnClickListener {
    public static final /* synthetic */ int i = 0;
    public ViewGroup a;
    public View b;
    public TextView c;
    public VerticalViewPager d;
    public SlidesImagePageAdapter e;
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f;
    public CommentPageParam g;
    public Function1<? super String, Unit> h;

    public static final class a {
    }

    static {
    }

    public final void a() {
        FrameLayout.inflate(getContext(), 2131558596, this);
        this.a = (ViewGroup) findViewById(2131367359);
        this.b = findViewById(2131366990);
        this.c = (TextView) findViewById(2131388772);
        VerticalViewPager r0 = (VerticalViewPager) findViewById(2131374972);
        this.d = r0;
        if (r0 == null) goto L6;
        r0.setOffscreenPageLimit(1);
    L6:
        VerticalViewPager r1 = this.d;
        if (r1 == null) goto L10;
        r1.c(new CommentImageView$initViewPager$1(this));
        return;
    }

    public final Function1<String, Unit> getCloseAction() {
        return this.h;
    }

    public final View getMCloseCommentImage() {
        return this.b;
    }

    public final ViewGroup getMCommentImageContainer() {
        return this.a;
    }

    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b getMPageOwner() {
        return this.f;
    }

    public final CommentPageParam getMPageParam() {
        return this.g;
    }

    public final TextView getMTitleView() {
        return this.c;
    }

    public final VerticalViewPager getMViewPager() {
        return this.d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public CommentImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1<? super String, Unit> r3 = this.h;
        if (r3 == null) goto L6;
        r3.invoke("click_pic_cmt");
        return;
    }

    public final void setCloseAction(Function1<? super String, Unit> r1) {
        this.h = r1;
    }

    public final void setCloseCommentButton(final Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "closeAction");
        this.h = r3;
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.view.commentimage.a(r3));
        return;
    }

    public final void setMCloseCommentImage(View r1) {
        this.b = r1;
    }

    public final void setMCommentImageContainer(ViewGroup r1) {
        this.a = r1;
    }

    public final void setMPageOwner(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r1) {
        this.f = r1;
    }

    public final void setMPageParam(CommentPageParam r1) {
        this.g = r1;
    }

    public final void setMTitleView(TextView r1) {
        this.c = r1;
    }

    public final void setMViewPager(VerticalViewPager r1) {
        this.d = r1;
    }

    public CommentImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        a();
    }
}
