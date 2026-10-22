package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.log.g;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.MediaScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.KolReviewElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.MediaBoxElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.extensions.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentDisplay;", "description", "", "setKolReviewV1", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "list", "setKolReviewV2", "component", "setDividerVisibility", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentView extends RelativeLayout implements ActionHubAccessor {
    public AnchorV4VM A;
    public AnchorV4CommentMeta B;
    public boolean C;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a D;
    public Map<Integer, View> a;
    public final LongContentLabelComponentView b;
    public final TagsScrollBoxComponentView c;
    public final TagsScrollBoxComponentView d;
    public final TextElementView e;
    public final MediaScrollBoxComponentView f;
    public final LinearLayout g;
    public final View h;
    public final LongContentLabelComponentView i;
    public final MediaScrollBoxComponentView j;
    public final LongContentLabelComponentView k;
    public final LinearLayout l;
    public final View m;
    public final View n;
    public final LongContentLabelComponentView o;
    public final TagsScrollBoxComponentView p;
    public final View q;
    public final LongContentLabelComponentView r;
    public final ConstraintLayout s;
    public final TextWithOneIconElementView t;
    public final TextElementView u;
    public final TextWithOneIconElementView v;
    public final TextWithOneIconElementView w;
    public final MediaBoxElementView x;
    public final HorizontalScrollView y;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b z;

    public AnchorV4CommentView(Context r3) {
        this(r3, null, 6);
    }

    public AnchorV4CommentView(Context r2, AttributeSet r3) {
        this(r2, r3, 4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.D;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    private final void setDividerVisibility(AnchorV4CommentDisplay r6) {
        LongContentLabelComponent r0 = r6.getBuyersShowTitle();
        boolean r1 = false;
        if (r0 == null) goto L11;
        TagsScrollBoxComponent r2 = r0.getHeadButtons();
        if (r2 == null) goto L11;
        List r3 = r2.getButtonList();
        if (r3 == null) goto L11;
        if ((!r3.isEmpty()) != true) goto L11;
        boolean r4 = true;
    L12:
        LongContentLabelComponent r5 = r6.getOtherGoodsReviewTitle();
        if (r5 == null) goto L21;
        TagsScrollBoxComponent r7 = r5.getHeadButtons();
        if (r7 == null) goto L21;
        List r8 = r7.getButtonList();
        if (r8 == null) goto L21;
        if ((!r8.isEmpty()) != true) goto L21;
        boolean r9 = true;
    L22:
        LongContentLabelComponent r10 = r6.getKolReviewTitle();
        if (r10 == null) goto L31;
        TagsScrollBoxComponent r11 = r10.getHeadButtons();
        if (r11 == null) goto L31;
        List r12 = r11.getButtonList();
        if (r12 == null) goto L31;
        if ((!r12.isEmpty()) != true) goto L31;
        boolean r13 = true;
    L32:
        LongContentLabelComponent r14 = r6.getAskAroundTitle();
        if (r14 == null) goto L41;
        TagsScrollBoxComponent r15 = r14.getHeadButtons();
        if (r15 == null) goto L41;
        List r16 = r15.getButtonList();
        if (r16 == null) goto L41;
        if ((!r16.isEmpty()) != true) goto L41;
        r1 = true;
    L41:
        wg.a.h(this.h, r4);
        wg.a.h(this.n, r9);
        wg.a.h(this.q, r13);
        wg.a.h(this.m, r1);
        return;
    L31:
        r13 = false;
    L21:
        r9 = false;
    L11:
        r4 = false;
        goto L12
    }

    private final void setKolReviewV1(AnchorV4CommentDisplay r9) {
        TextWithOneIconElementView.b(this.t, r9.getKolReviewUser(), null, false, null, 14);
        this.u.x(r9.getKolReviewContent());
        List<TextWithOneIconElement> r0 = r9.getKolReviewStatistics();
        if (r0 == null) goto L7;
        TextWithOneIconElement r2 = (TextWithOneIconElement) CollectionsKt.getOrNull(r0, 0);
        if (r2 == null) goto L7;
        TextWithOneIconElementView.b(this.v, r2, null, false, null, 14);
    L7:
        List<TextWithOneIconElement> r1 = r9.getKolReviewStatistics();
        if (r1 == null) goto L12;
        TextWithOneIconElement r3 = (TextWithOneIconElement) CollectionsKt.getOrNull(r1, 1);
        if (r3 == null) goto L12;
        TextWithOneIconElementView.b(this.w, r3, null, false, null, 14);
    L12:
        MediaBoxElementView.c(this.x, r9.getKolReviewVideo(), null, true, 2);
    }

    private final void setKolReviewV2(List<KolReviewElement> r14) {
        this.y.setVisibility(0);
        this.y.setHorizontalFadingEdgeEnabled(false);
        LinearLayout r0 = new LinearLayout(getContext());
        if (r14 != null) goto L5;
    L7:
        if (r14 != null) goto L9;
    L20:
        this.y.addView(r0, -2, -2);
        return;
    L9:
        if ((!r14.isEmpty()) != true) goto L20;
        float r6 = ((KolReviewElement) CollectionsKt.first(r14)).getEdgePercent();
        float r5 = (n1.f - (com.bytedance.android.shopping.extensions.b.b(8) * (((int) (1 / r6)) - 1))) * r6;
        Iterator<T> r15 = r14.iterator();
        int r7 = 0;
    L12:
        if (r15.hasNext() == false) goto L20;
        Object r8 = r15.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        KolReviewElementView r10 = new KolReviewElementView(getContext(), null, 0, 14);
        int r12 = (int) r5;
        r10.a((KolReviewElement) r8, new ViewGroup.MarginLayoutParams(r12, r12));
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(r12, -2);
        if (r7 <= 0) goto L19;
        r11.leftMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L19:
        r0.addView(r10, r11);
        r7 = r9;
        goto L12
    L5:
        if (r14.size() != 1) goto L7;
        KolReviewElementView r13 = new KolReviewElementView(getContext(), null, 0, 14);
        r13.a((KolReviewElement) CollectionsKt.firstOrNull(r14), null);
        Unit r16 = Unit.INSTANCE;
        r0.addView(r13, n1.f, -2);
        goto L20
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.z.e(r2);
        super.draw(r2);
        this.z.d(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.D = r2;
    }

    public AnchorV4CommentView(Context r24, AttributeSet r25, int r26) {
        View r3 = null;
        if ((r26 & 2) == 0) goto L5;
        AttributeSet r2 = null;
    L6:
        super(r24, r2);
        this.D = null;
        this.a = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r4 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.z = r4;
        if (r24 == null) goto L9;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r24).aU(2131560607, this, true);
    L9:
        this.b = (LongContentLabelComponentView) findViewById(2131362781);
        this.c = (TagsScrollBoxComponentView) findViewById(2131362780);
        this.d = (TagsScrollBoxComponentView) findViewById(2131362782);
        this.e = (TextElementView) findViewById(2131362766);
        this.f = (MediaScrollBoxComponentView) findViewById(2131362777);
        this.g = (LinearLayout) findViewById(2131362850);
        this.h = findViewById(2131362767);
        this.i = (LongContentLabelComponentView) findViewById(2131362762);
        this.j = (MediaScrollBoxComponentView) findViewById(2131362763);
        LongContentLabelComponentView r1 = (LongContentLabelComponentView) findViewById(2131362747);
        this.k = r1;
        this.l = (LinearLayout) findViewById(2131362837);
        this.m = findViewById(2131362770);
        this.n = findViewById(2131362768);
        this.o = (LongContentLabelComponentView) findViewById(2131362778);
        this.p = (TagsScrollBoxComponentView) findViewById(2131362779);
        this.q = findViewById(2131362769);
        this.r = (LongContentLabelComponentView) findViewById(2131362771);
        this.s = findViewById(2131362764);
        this.t = (TextWithOneIconElementView) findViewById(2131362776);
        this.u = (TextElementView) findViewById(2131362773);
        this.v = (TextWithOneIconElementView) findViewById(2131362774);
        this.w = (TextWithOneIconElementView) findViewById(2131362772);
        this.x = (MediaBoxElementView) findViewById(2131362775);
        HorizontalScrollView r5 = (HorizontalScrollView) findViewById(2131362840);
        this.y = r5;
        Action r14 = new Action("click_askaround_module", null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(r1, "theView");
        ActionHubAccessor.DefaultImpls.a(this, r1, r14);
        if (this.a != null) goto L12;
        this.a = new LinkedHashMap();
    L12:
        View r6 = (View) ((LinkedHashMap) this.a).get(2131362764);
        if (r6 != null) goto L17;
        r6 = findViewById(2131362764);
        if (r6 == null) goto L18;
        this.a.put(2131362764, r6);
    L18:
        Action r7 = new Action("comment_good_goods_review", null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(r3, "theView");
        ActionHubAccessor.DefaultImpls.a(this, r3, r7);
        Action r8 = new Action("kol_review_video_list", null, null, null, null, 30, null);
        Intrinsics.checkNotNullParameter(r5, "theView");
        ActionHubAccessor.DefaultImpls.a(this, r5, r8);
        r4.f(new Radius(8, 8, 8, 8));
        return;
    L17:
        r3 = r6;
        goto L18
    L5:
        r2 = r25;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView] */
    public final void a(AnchorV4CommentDisplay r21, AnchorV4VM r22, AnchorV4CommentMeta r23) {
        Intrinsics.checkNotNullParameter(r22, "viewModel");
        if (r21 != null) goto L5;
        return;
    L5:
        this.A = r22;
        this.B = r23;
        this.b.bind(r21.getCommentTitle());
        CommonMeta r1 = r22.commonMeta();
        if (r1 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r1.getEnablePDPOptimize());
    L10:
        if (k.i(r2) == false) goto L18;
        LongContentLabelComponentView r3 = this.b;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        r5 = null;
    L14:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (r6 == null) goto L17;
        r6.topMargin = 0;
        r3.setLayoutParams(r6);
    L17:
        this.z.f(new Radius(12, 12, 12, 12));
    L18:
        TagsScrollBoxComponentView.b(this.c, r21.getCommentTags(), null, 14);
        TagsScrollBoxComponentView.b(this.d, r21.getCommentUser(), null, 14);
        this.e.x(r21.getCommentDesc());
        MediaScrollBoxComponentView r4 = this.f;
        MediaScrollBoxComponent r7 = r21.getCommentMedias();
        int r8 = MediaScrollBoxComponentView.e;
        r4.a(r7, false);
        this.i.bind(r21.getBuyersShowTitle());
        boolean r9 = true;
        this.j.a(r21.getBuyersShowMedias(), true);
        this.k.bind(r21.getAskAroundTitle());
        List<LongContentLabelComponent> r10 = r21.getAskAroundItems();
        if (r10 == null) goto L30;
        Iterator<T> r11 = r10.iterator();
        int r12 = 0;
    L22:
        if (r11.hasNext() == false) goto L30;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        this.l.removeAllViews();
        this.l.setVisibility(0);
        LinearLayout r15 = this.l;
        LongContentLabelComponentView r16 = new LongContentLabelComponentView(getContext(), null, null, 6, null).bind((LongContentLabelComponent) r13);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-1, -2);
        if (r12 <= 0) goto L29;
        r17.topMargin = com.bytedance.android.shopping.extensions.b.b(8);
    L29:
        Unit r18 = Unit.INSTANCE;
        r15.addView(r16, r17);
        r12 = r14;
    L30:
        this.o.bind(r21.getOtherGoodsReviewTitle());
        TagsScrollBoxComponentView.b(this.p, r21.getOtherGoodsReviewTags(), null, 14);
        this.r.bind(r21.getKolReviewTitle());
        this.y.removeAllViews();
        this.g.removeAllViews();
        List<KolReviewElement> r19 = r21.getKolReviewList();
        if (r19 != null) goto L33;
    L36:
        boolean r20 = true;
    L38:
        if ((!r20) == false) goto L40;
        setKolReviewV2(r21.getKolReviewList());
        this.s.setVisibility(8);
    L45:
        List<MultiCommentComponent> r24 = r21.getMultiComments();
        if (r24 == null) goto L55;
        this.g.setVisibility(0);
        Iterator<T> r25 = r24.iterator();
    L49:
        if (r25.hasNext() == false) goto L56;
        MultiCommentComponent r26 = (MultiCommentComponent) r25.next();
        if (r26 == null) goto L49;
        if (r26.getCommentUser() == null) goto L49;
        TagsScrollBoxComponentView r27 = new TagsScrollBoxComponentView(getContext(), null, 0, 14);
        TagsScrollBoxComponentView.b(r27, r26.getCommentUser(), null, 14);
        LinearLayout r28 = this.g;
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        r110.topMargin = com.bytedance.android.shopping.extensions.b.b(12);
        Unit r111 = Unit.INSTANCE;
        r28.addView(r27, r110);
        ?? r29 = new TextElementView(getContext(), null, 0, null, 30);
        r29.x(r26.getCommentDesc());
        LinearLayout r30 = this.g;
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-2, -2);
        r112.topMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r30.addView(r29, r112);
        MediaScrollBoxComponentView r31 = new MediaScrollBoxComponentView(getContext(), null, 0, 14);
        r31.a(r26.getCommentMedias(), false);
        LinearLayout r32 = this.g;
        LinearLayout.LayoutParams r33 = new LinearLayout.LayoutParams(-2, -2);
        r33.topMargin = com.bytedance.android.shopping.extensions.b.b(12);
        r32.addView(r31, r33);
    L56:
        setDividerVisibility(r21);
        return;
    L55:
        this.g.setVisibility(8);
        goto L56
    L40:
        ConstraintLayout r34 = this.s;
        if (r21.getKolReviewTitle() != null) goto L44;
        r9 = false;
    L44:
        wg.a.h(r34, r9);
        setKolReviewV1(r21);
        goto L45
    L33:
        if (r19.isEmpty() == true) goto L36;
        r20 = false;
        goto L38
    L8:
        r2 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.z.c(r1, r2);
    }

    public final void b(int r10, int r11, boolean r12, Long r13, View r14) {
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.A);
        if (r1 == null) goto L32;
        Integer r2 = null;
        if (g.a(r14) == false) goto L7;
        AnchorV4TrackerImpl r3 = r1;
    L8:
        if (r3 == null) goto L33;
        Pair[] r15 = new Pair[10];
        r15[0] = TuplesKt.to("comment_entrance", "comment_region");
        r15[1] = TuplesKt.to("comment_module", "product_comment");
        AnchorV4CommentMeta r4 = this.B;
        if (r4 == null) goto L14;
        d r5 = r4.getTrackMeta();
        if (r5 == null) goto L14;
        Long r6 = Long.valueOf(r5.d());
    L15:
        r15[2] = TuplesKt.to("comment_id", String.valueOf(r6));
        String r7 = "1";
        r15[3] = TuplesKt.to("comment_rank", "1");
        r15[4] = TuplesKt.to("picture_num", String.valueOf(r10));
        r15[5] = TuplesKt.to("video_num", String.valueOf(r11));
        r15[6] = TuplesKt.to("user_comment_level", r13);
        AnchorV4CommentMeta r16 = this.B;
        if (r16 == null) goto L20;
        d r17 = r16.getTrackMeta();
        if (r17 == null) goto L20;
        String r18 = r17.k();
    L21:
        r15[7] = TuplesKt.to("comment_module", r18);
        AnchorV4CommentMeta r19 = this.B;
        if (r19 == null) goto L26;
        d r110 = r19.getTrackMeta();
        if (r110 == null) goto L26;
        r2 = r110.v();
    L26:
        r15[8] = TuplesKt.to("with_same_comment", r2);
        if (r12 == true) goto L30;
        r7 = "0";
    L30:
        r15[9] = TuplesKt.to("show_selected_comment", r7);
        r3.c = MapsKt.mapOf(r15);
        AnchorV4TrackerImpl.b(r3, "single_comment_show", false, null, false, null, 28);
        return;
    L20:
        r18 = null;
    L14:
        r6 = null;
        goto L15
    L33:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
