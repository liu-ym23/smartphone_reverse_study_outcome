package com.bytedance.awemeopen.apps.framework.comment.view.commentimage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AB\u001b\b\u0016\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\b@\u0010DJ\u001a\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006E"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/view/commentimage/CommentImageView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lkotlin/Function1;", "", "", "closeAction", "setCloseCommentButton", "Landroid/view/ViewGroup;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/ViewGroup;", "getMCommentImageContainer", "()Landroid/view/ViewGroup;", "setMCommentImageContainer", "(Landroid/view/ViewGroup;)V", "mCommentImageContainer", "Landroid/view/View;", "b", "Landroid/view/View;", "getMCloseCommentImage", "()Landroid/view/View;", "setMCloseCommentImage", "(Landroid/view/View;)V", "mCloseCommentImage", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "d", "Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "getMViewPager", "()Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;", "setMViewPager", "(Lcom/bytedance/awemeopen/apps/framework/base/view/verticalviewPager/VerticalViewPager;)V", "mViewPager", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "f", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "getMPageOwner", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "setMPageOwner", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;)V", "mPageOwner", "Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", ce.f26391f, "Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "getMPageParam", "()Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "setMPageParam", "(Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;)V", "mPageParam", "h", "Lkotlin/jvm/functions/Function1;", "getCloseAction", "()Lkotlin/jvm/functions/Function1;", "setCloseAction", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentImageView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f194203i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f194204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f194205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f194206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VerticalViewPager f194207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SlidesImagePageAdapter f194208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f194209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommentPageParam f194210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super String, Unit> f194211h;

    public static final class a {
    }

    static {
    }

    public final void a() {
        FrameLayout.inflate(getContext(), R.layout.aos_comment_image_view, this);
        this.f194204a = (ViewGroup) findViewById(R.id.comment_image_container);
        this.f194205b = findViewById(R.id.close_comment_image);
        this.f194206c = (TextView) findViewById(R.id.title);
        VerticalViewPager r100 = (VerticalViewPager) findViewById(R.id.image_content_viewpager);
        this.f194207d = r100;
        if (r100 == null) goto L6;
        r100.setOffscreenPageLimit(1);
    L6:
        VerticalViewPager r101 = this.f194207d;
        if (r101 == null) goto L10;
        r101.c(new CommentImageView$initViewPager$1(this));
        return;
    }

    public final Function1<String, Unit> getCloseAction() {
        return this.f194211h;
    }

    public final View getMCloseCommentImage() {
        return this.f194205b;
    }

    public final ViewGroup getMCommentImageContainer() {
        return this.f194204a;
    }

    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b getMPageOwner() {
        return this.f194209f;
    }

    public final CommentPageParam getMPageParam() {
        return this.f194210g;
    }

    public final TextView getMTitleView() {
        return this.f194206c;
    }

    public final VerticalViewPager getMViewPager() {
        return this.f194207d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public CommentImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        a();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1<? super String, Unit> r101 = this.f194211h;
        if (r101 == null) goto L6;
        r101.invoke("click_pic_cmt");
        return;
    }

    public final void setCloseAction(Function1<? super String, Unit> r100) {
        this.f194211h = r100;
    }

    public final void setCloseCommentButton(final Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "closeAction");
        this.f194211h = r100;
        View r101 = this.f194205b;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.view.commentimage.a(r100));
        return;
    }

    public final void setMCloseCommentImage(View r100) {
        this.f194205b = r100;
    }

    public final void setMCommentImageContainer(ViewGroup r100) {
        this.f194204a = r100;
    }

    public final void setMPageOwner(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r100) {
        this.f194209f = r100;
    }

    public final void setMPageParam(CommentPageParam r100) {
        this.f194210g = r100;
    }

    public final void setMTitleView(TextView r100) {
        this.f194206c = r100;
    }

    public final void setMViewPager(VerticalViewPager r100) {
        this.f194207d = r100;
    }

    public CommentImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        a();
    }
}
