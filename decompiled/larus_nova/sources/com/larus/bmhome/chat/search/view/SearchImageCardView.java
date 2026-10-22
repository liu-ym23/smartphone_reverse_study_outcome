package com.larus.bmhome.chat.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c29.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.RoundFrameLayoutWithLastMotion;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ti8.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J#\u0010\u0019\u001a\u00020\u0013*\u00020\u000b2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001dJ\u0014\u0010\u001e\u001a\u00020\u0013*\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/search/view/SearchImageCardView;", "Lcom/larus/bmhome/chat/layout/widget/RoundFrameLayoutWithLastMotion;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageMetrics", "Lcom/larus/common_ui/widget/roundlayout/RoundTextView;", "imageMask", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "sourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "setImageData", "", "viewData", "Lcom/larus/bmhome/chat/search/view/SearchImageCardViewData;", "extra", "", "", "updateRoundingParams", "block", "Lkotlin/Function1;", "Lcom/facebook/drawee/generic/RoundingParams;", "Lkotlin/ExtensionFunctionType;", "setRounding", "Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchImageCardView extends RoundFrameLayoutWithLastMotion {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f308691f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f308692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RoundTextView f308693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoundFrameLayout f308694e;

    public SearchImageCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SearchImageCardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static void a(a r100, b r101) {
        int r102 = 0;
        if (r101.f546248g == false) goto L5;
        int r103 = r101.f546247f;
    L6:
        r100.f22227i = r103;
        r100.c();
        if (r101.f546249h == false) goto L9;
        int r104 = r101.f546247f;
    L10:
        r100.f22228j = r104;
        r100.c();
        if (r101.f546250i == false) goto L13;
        int r105 = r101.f546247f;
    L14:
        r100.f22229k = r105;
        r100.c();
        if (r101.f546251j == false) goto L17;
        r102 = r101.f546247f;
    L17:
        r100.f22230l = r102;
        r100.c();
        return;
    L13:
        r105 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public SearchImageCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = FrameLayout.inflate(r100, R.layout.larus_search_image_card_view, this);
        this.f308692c = (SimpleDraweeView) r103.findViewById(R.id.image_cover);
        this.f308693d = (RoundTextView) r103.findViewById(R.id.image_metrics);
        this.f308694e = (RoundFrameLayout) r103.findViewById(R.id.image_mask);
        MarkdownSourceImageView r104 = (MarkdownSourceImageView) r103.findViewById(R.id.sourceIcon);
    }

    public /* synthetic */ SearchImageCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
