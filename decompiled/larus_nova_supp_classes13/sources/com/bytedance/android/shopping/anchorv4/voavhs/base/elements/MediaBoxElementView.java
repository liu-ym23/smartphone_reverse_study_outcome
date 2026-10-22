package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.h;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001b\u0010\u000e\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/MediaBoxElementView;", "Landroid/widget/FrameLayout;", "Lfj/e;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/b;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "", "setActionHub", "Lcom/bytedance/android/shopping/widget/legacy/SquareImageView;", "a", "Lkotlin/Lazy;", "getImageView", "()Lcom/bytedance/android/shopping/widget/legacy/SquareImageView;", "imageView", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "b", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "getVideoHolder", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;", "setVideoHolder", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoHolder;)V", "videoHolder", "Landroid/view/View;", "d", "getMaskView", "()Landroid/view/View;", "maskView", "", "e", "getEnableOptimize", "()Z", "enableOptimize", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaBoxElementView extends FrameLayout implements fj.e, ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.b {
    public final Lazy a;
    public VideoHolder b;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b c;
    public final Lazy d;
    public final Lazy e;
    public MediaBoxElement f;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a g;

    public MediaBoxElementView(Context r4) {
        this(r4, null, 0, 14);
    }

    public MediaBoxElementView(Context r3, AttributeSet r4) {
        this(r3, r4, 0, 12);
    }

    public MediaBoxElementView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 8);
    }

    private final boolean getEnableOptimize() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    private final View getMaskView() {
        return (View) this.d.getValue();
    }

    public final void B0() {
    }

    public final void H() {
    }

    public final void Q(float r1) {
    }

    public final void R2() {
    }

    public final void Z2() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    public final void e() {
    }

    public final SquareImageView getImageView() {
        return (SquareImageView) this.a.getValue();
    }

    public final void m3(boolean r1) {
    }

    public final void y(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.b
    public final void a() {
        if (getEnableOptimize() == false) goto L32;
        MediaBoxElement r0 = this.f;
        LocalImage r1 = null;
        if (r0 == null) goto L9;
        ImageModel r2 = r0.getImageModel();
        if (r2 == null) goto L9;
        ECUrlModel r3 = r2.getRemote();
    L10:
        if (r3 == null) goto L18;
        MediaBoxElement r4 = this.f;
        if (r4 == null) goto L33;
        ImageModel r5 = r4.getImageModel();
        if (r5 == null) goto L34;
        ECUrlModel r6 = r5.getRemote();
        if (r6 == null) goto L35;
        ImageExtensionsKt.a(getImageView(), r6.getUri(), Integer.valueOf(r6.getHeight()), Integer.valueOf(r6.getWidth()));
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L18:
        MediaBoxElement r7 = this.f;
        if (r7 == null) goto L23;
        ImageModel r8 = r7.getImageModel();
        if (r8 == null) goto L23;
        r1 = r8.getLocal();
    L23:
        if (r1 == null) goto L37;
        MediaBoxElement r9 = this.f;
        if (r9 == null) goto L38;
        ImageModel r10 = r9.getImageModel();
        if (r10 == null) goto L39;
        LocalImage r11 = r10.getLocal();
        if (r11 == null) goto L40;
        ImageExtensionsKt.a(getImageView(), r11.getName(), Integer.valueOf(r11.getHeight()), Integer.valueOf(r11.getWidth()));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.g;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final VideoHolder getVideoHolder() {
        return this.b;
    }

    public static final /* synthetic */ boolean b(MediaBoxElementView r0) {
        return r0.getEnableOptimize();
    }

    public final void d(boolean r4) {
        Border r0 = null;
        if (r4 == false) goto L12;
        SquareImageView r5 = getImageView();
        MediaBoxElement r1 = this.f;
        if (r1 == null) goto L7;
        ImageModel r2 = r1.getImageModel();
    L8:
        MediaBoxElement r3 = this.f;
        if (r3 == null) goto L11;
        r0 = r3.getSelectInBorder();
    L11:
        ImageExtensionsKt.g(r5, r2, r0);
        getMaskView().setVisibility(0);
        return;
    L7:
        r2 = null;
        goto L8
    L12:
        getMaskView().setVisibility(4);
        SquareImageView r6 = getImageView();
        MediaBoxElement r7 = this.f;
        if (r7 == null) goto L15;
        ImageModel r8 = r7.getImageModel();
    L16:
        MediaBoxElement r9 = this.f;
        if (r9 == null) goto L19;
        r0 = r9.getDefaultInBorder();
    L19:
        ImageExtensionsKt.g(r6, r8, r0);
        return;
    L15:
        r8 = null;
        goto L16
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.c.e(r2);
        super.draw(r2);
        this.c.d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.g = r2;
    }

    public final void setVideoHolder(VideoHolder r1) {
        this.b = r1;
    }

    public MediaBoxElementView(final Context r3, AttributeSet r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.g = null;
        this.a = LazyKt.lazy(new MediaBoxElementView$imageView$2(this, r3));
        this.c = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.d = LazyKt.lazy(new MediaBoxElementView$maskView$2(this, r3));
        this.e = LazyKt.lazy(MediaBoxElementView$enableOptimize$2.INSTANCE);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.c.c(r1, r2);
    }

    public static void c(final MediaBoxElementView r36, final MediaBoxElement r37, ViewGroup.LayoutParams r38, boolean r39, int r40) {
        View r8 = null;
        if ((r40 & 2) == 0) goto L5;
        ViewGroup.LayoutParams r0 = null;
    L7:
        if ((r40 & 4) == 0) goto L9;
        boolean r10 = false;
    L10:
        r36.f = r37;
        if (r37 != null) goto L13;
        r36.setVisibility(8);
        return;
    L13:
        r36.c.f(r37.getRadius());
        if (r0 == null) goto L16;
        r36.setLayoutParams(r0);
    L16:
        ExtensionsKt.j(r36, r37.getBackground());
        int r1 = r37.getType();
        if (r1 == 0) goto L65;
        if (r1 == 1) goto L21;
        r36.setVisibility(8);
    L126:
        Action r2 = r37.getAction();
        Intrinsics.checkNotNullParameter(r36, "theView");
        ActionHubAccessor.DefaultImpls.a(r36, r36, r2);
        return;
    L21:
        if (r36.getChildCount() > 0) goto L126;
        VideoModel r3 = r37.getVideo();
        if (r3 == null) goto L126;
        String r14 = r3.getMainUrl();
        String r15 = r3.getBackupUrl();
        String r16 = r3.getVid();
        long r4 = r3.getHeight();
        long r5 = r3.getWidth();
        Integer r13 = r3.getDuration();
        if (r13 == null) goto L29;
        long r11 = r13.intValue();
    L30:
        long r21 = r11;
        ImageModel r6 = r3.getPosterImage();
        if (r6 == null) goto L37;
        ECUrlModel r7 = r6.getRemote();
        if (r7 == null) goto L37;
        List r9 = r7.getUrlList();
        if (r9 == null) goto L37;
        String r23 = (String) CollectionsKt.firstOrNull(r9);
    L38:
        final fj.d r12 = new fj.d(r14, r15, r16, r5, r4, r21, r23, false, false, false, false, false, null, false, 0, null, null, 130944);
        final VideoHolder r17 = new VideoHolder(r36.getContext(), r10, false, 26);
        ECUrlModel r18 = new ECUrlModel();
        String r19 = r12.g;
        if (r19 != null) goto L41;
        r19 = "";
    L41:
        r18.setUrlList(CollectionsKt.listOf(r19));
        Unit r20 = Unit.INSTANCE;
        final boolean r22 = r10;
        r17.f(r12, r18, new MediaBoxElementView$renderAsVideoMode$$inlined$apply$lambda$1(r17, r36, r12, r37, r22));
        if (r10 == false) goto L44;
        final boolean r24 = r10;
        Function1<Boolean, Unit> r110 = new MediaBoxElementView$renderAsVideoMode$$inlined$apply$lambda$2(r17, r36, r12, r37, r24);
        Intrinsics.checkNotNullParameter(r110, "listener");
        r17.k = r110;
    L44:
        r36.b = r17;
        ViewGroup.LayoutParams r25 = new ViewGroup.MarginLayoutParams(-1, -1);
        VideoHolder r26 = r36.b;
        if (r26 == null) goto L47;
        r8 = r26.b();
    L47:
        r36.addView(r8, r25);
        VideoHolder r27 = r36.b;
        if (r27 == null) goto L63;
        PlayerBlock r28 = r27.g;
        if (r28 != null) goto L52;
    L60:
        r27.h(false);
        ProgressBar r29 = r27.f;
        if (r29 == null) goto L63;
        r29.setVisibility(8);
        goto L63
    L52:
        if (r28.P == false) goto L54;
        int r30 = com.bytedance.android.shopping.extensions.b.b(32);
    L56:
        if (r28.P == false) goto L58;
        int r31 = 2131235273;
    L59:
        r28.a.setAlpha(1.0f);
        r28.a.setBackgroundResource(r31);
        ImageView r32 = r28.a;
        ViewGroup.LayoutParams r33 = r32.getLayoutParams();
        r33.width = r30;
        r33.height = r30;
        r32.setLayoutParams(r33);
        r28.a.setVisibility(0);
        goto L60
    L58:
        r31 = 2131233485;
        goto L59
    L54:
        r30 = (int) UIUtils.dip2Px(r28.getContext(), 23.53f);
    L63:
        new h(r36, r12, AVScene.CONTENT_PRODUCT_DETAIL_MEDIA_BOX).A(r36);
        r36.setOnClickListener(c.a);
    L37:
        r23 = null;
        goto L38
    L29:
        r11 = 0;
        goto L30
    L65:
        if (r36.getChildCount() > 0) goto L126;
        ImageModel r34 = r37.getImageModel();
        if (r34 == null) goto L70;
        ECUrlModel r35 = r34.getRemote();
    L71:
        if (r35 == null) goto L102;
        final Ref.ObjectRef r41 = new Ref.ObjectRef();
        r41.element = r37.getImageModel().getRemote();
        ImageModel r42 = r37.getImageModel();
        if (r0 != null) goto L80;
        ECUrlModel r43 = (ECUrlModel) r41.element;
        Intrinsics.checkNotNullParameter(r43, "urlModel");
        if (r43.getWidth() > 0) goto L77;
    L79:
        FrameLayout.LayoutParams r44 = new FrameLayout.LayoutParams(-1, -1);
        r44.gravity = 17;
        ViewGroup.LayoutParams r45 = r44;
    L81:
        if (r42 == null) goto L86;
        ImageMonitorMeta r46 = r42.getImageMonitorMeta();
        if (r46 == null) goto L86;
        com.bytedance.android.ec.core.imagex.ImageExtensionsKt.D(r36.getImageView(), q73.b.a(r46));
    L86:
        if (r36.getEnableOptimize() == false) goto L91;
        String r47 = ((ECUrlModel) r41.element).getUri();
        if (r47 != null) goto L90;
    L99:
        Float.valueOf(r42.getRoundCorner()).floatValue();
        ImageExtensionsKt.g(r36.getImageView(), r42, r37.getDefaultInBorder());
        r36.addView(r36.getImageView(), r45);
        Border r48 = r37.getOutBorder();
        if (r48 == null) goto L126;
        int r49 = Integer.valueOf(r48.getBorderWidth()).intValue();
        View r50 = r36.getMaskView();
        FrameLayout.LayoutParams r51 = new FrameLayout.LayoutParams(r45.width + (com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r49)) * 2), r45.height + (com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r49)) * 2));
        r51.gravity = 17;
        Unit r52 = Unit.INSTANCE;
        r36.addView(r50, r51);
        goto L126
    L90:
        if (r47.equals(r36.getImageView().getTag(2131368899)) == true) goto L99;
    L91:
        r36.getImageView().setHierarchy(new GenericDraweeHierarchyBuilder(r36.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
        if (r0 == null) goto L94;
    L98:
        SquareImageView r53 = r36.getImageView();
        ECUrlModel r54 = (ECUrlModel) r41.element;
        y.c(r53, r54, -1, -1, new z53.a(r54.getUrlList(), ImagePosition.COMMENT_PAGE.getValue(), new MediaBoxElementView$renderAsImageMode$2(r36, r41), false, 24));
        goto L99
    L94:
        if (((ECUrlModel) r41.element).getWidth() <= 0) goto L98;
        if (((ECUrlModel) r41.element).getHeight() <= 0) goto L98;
        ECLiveImageUtils.c(r36.getImageView(), (ECUrlModel) r41.element, true, null);
        goto L99
    L77:
        if (r43.getHeight() <= 0) goto L79;
        FrameLayout.LayoutParams r55 = new FrameLayout.LayoutParams(vf4.a.b(Integer.valueOf(r43.getWidth())), vf4.a.b(Integer.valueOf(r43.getHeight())));
        r55.gravity = 17;
        r45 = r55;
        goto L81
    L80:
        r45 = r0;
        goto L81
    L102:
        ImageModel r56 = r37.getImageModel();
        if (r56 == null) goto L105;
        r8 = r56.getLocal();
    L105:
        if (r8 == null) goto L126;
        LocalImage r57 = r37.getImageModel().getLocal();
        Intrinsics.checkNotNullParameter(r57, "localModel");
        if (r57.getWidth() > 0) goto L109;
    L111:
        ViewGroup.LayoutParams r58 = new ViewGroup.MarginLayoutParams(-1, -1);
    L113:
        if (r36.getEnableOptimize() == false) goto L118;
        String r59 = r37.getImageModel().getLocal().getName();
        if (r59 != null) goto L117;
    L125:
        r36.addView(r36.getImageView(), r58);
        goto L126
    L117:
        if (r59.equals(r36.getImageView().getTag()) == true) goto L125;
    L118:
        SquareImageView r60 = r36.getImageView();
        LocalImage r61 = r37.getImageModel().getLocal();
        Intrinsics.checkNotNullParameter(r60, "$this$setLocalImage");
        if (r61 == null) goto L125;
        String r62 = r61.getName();
        if (r62 == null) goto L125;
        Integer r63 = ImageExtensionsKt.c(r62);
        if (r63 == null) goto L125;
        r60.setActualImageResource(r63.intValue());
        goto L125
    L109:
        if (r57.getHeight() <= 0) goto L111;
        r58 = new ViewGroup.MarginLayoutParams(vf4.a.b(Integer.valueOf(r57.getWidth())), vf4.a.b(Integer.valueOf(r57.getHeight())));
        goto L113
    L70:
        r35 = null;
        goto L71
    L9:
        r10 = r39;
        goto L10
    L5:
        r0 = r38;
        goto L7
    }
}
