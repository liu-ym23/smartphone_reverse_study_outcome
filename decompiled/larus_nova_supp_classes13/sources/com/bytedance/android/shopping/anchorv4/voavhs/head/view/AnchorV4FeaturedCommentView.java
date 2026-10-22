package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FeaturedCommentView;", "Landroid/widget/FrameLayout;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "a", "Lkotlin/Lazy;", "getBgView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "bgView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FeaturedCommentView extends FrameLayout {
    public final Lazy a;

    public AnchorV4FeaturedCommentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4FeaturedCommentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final SimpleDraweeView getBgView() {
        return (SimpleDraweeView) this.a.getValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r1);
    }

    public AnchorV4FeaturedCommentView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new AnchorV4FeaturedCommentView$bgView$2(r2));
        addView(getBgView(), -1, -1);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560489, this, true).findViewById(2131372198).setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(2131106003));
    }

    public final void a(com.bytedance.android.shopping.anchorv4.voavhs.head.holder.b r19, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r20, boolean r21) {
        SimpleDraweeView r2 = getBgView();
        TextWithOneIconElement r3 = null;
        if (r19 == null) goto L5;
        ECUrlModel r4 = r19.b;
    L6:
        y.a(r2, r4);
        TextWithOneIconElementView r5 = (TextWithOneIconElementView) findViewById(2131372209);
        if (r5 == null) goto L14;
        if (r19 == null) goto L12;
        FeaturedComment r6 = r19.a;
        if (r6 == null) goto L12;
        TextWithOneIconElement r7 = r6.getFeaturedTitle();
    L13:
        TextWithOneIconElementView.b(r5, r7, null, false, null, 14);
    L12:
        r7 = null;
    L14:
        Iterator r8 = CollectionsKt.listOf(new HeadCommentInfoView[]{(HeadCommentInfoView) findViewById(2131372196), (HeadCommentInfoView) findViewById(2131372197)}).iterator();
        int r9 = 0;
    L16:
        if (r8.hasNext() == false) goto L53;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        HeadCommentInfoView r12 = (HeadCommentInfoView) r10;
        if (r19 == null) goto L51;
        FeaturedComment r13 = r19.a;
        if (r13 == null) goto L51;
        List<CommentInfoVO> r14 = r13.getFeaturedCommentList();
        if (r14 == null) goto L51;
        CommentInfoVO r15 = (CommentInfoVO) CollectionsKt.getOrNull(r14, r9);
        if (r15 == null) goto L51;
        r12.setVisibility(0);
        Intrinsics.checkNotNullParameter(r15, "infoVO");
        ImageModel r16 = r15.getUserAvatar();
        if (r16 == null) goto L33;
        ECUrlModel r17 = r16.getRemote();
        if (r17 == null) goto L33;
        y.a(r12.findViewById(2131372200), r17);
    L33:
        TextWithOneIconElement r18 = r15.getUserName();
        if (r18 == null) goto L38;
        TextWithOneIconElementView r110 = (TextWithOneIconElementView) r12.findViewById(2131372202);
        if (r110 == null) goto L38;
        TextWithOneIconElementView.b(r110, r18, null, false, null, 14);
    L38:
        TextElement r22 = r15.getContent();
        if (r22 == null) goto L43;
        FontStyle r111 = r22.getFontStyle();
        if (r111 == null) goto L43;
        r111.setLine(2);
    L43:
        TextElementView r112 = (TextElementView) r12.findViewById(2131372199);
        if (r112 == null) goto L46;
        r112.x(r22);
    L46:
        ImageModel r23 = r15.getPhoto();
        if (r23 == null) goto L52;
        ECUrlModel r24 = r23.getRemote();
        if (r24 == null) goto L52;
        y.a(r12.findViewById(2131372201), r24);
    L52:
        r9 = r11;
    L51:
        r12.setVisibility(8);
        Unit r25 = Unit.INSTANCE;
        goto L52
    L53:
        TextWithOneIconElementView r26 = (TextWithOneIconElementView) findViewById(2131372203);
        if (r26 == null) goto L63;
        if (r21 == false) goto L57;
        r26.setVisibility(8);
        goto L63
    L57:
        r26.setVisibility(0);
        if (r19 == null) goto L62;
        FeaturedComment r27 = r19.a;
        if (r27 == null) goto L62;
        r3 = r27.getMoreCommentTitle();
    L62:
        TextWithOneIconElementView.b(r26, r3, null, false, null, 14);
        r26.setOnClickListener(new b(r20));
    L63:
        if (r19 == null) goto L67;
        String r28 = r19.c;
        if (r28 == null) goto L67;
    L68:
        setContentDescription(r28);
        if (r21 == false) goto L71;
        setBackgroundColor(-1);
        postDelayed(new d(this), 300);
    L71:
        if (r19 != null) goto L73;
    L74:
        post(new c(this));
        return;
    L73:
        if (r19.d != true) goto L74;
        return;
    L67:
        r28 = "图片，商品评论";
        goto L68
    L5:
        r4 = null;
        goto L6
    }

    public /* synthetic */ AnchorV4FeaturedCommentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
