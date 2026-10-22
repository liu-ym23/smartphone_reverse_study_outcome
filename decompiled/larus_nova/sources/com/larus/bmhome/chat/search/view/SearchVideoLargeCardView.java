package com.larus.bmhome.chat.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.RoundFrameLayoutWithLastMotion;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0012J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%2\u0006\u0010 \u001a\u00020\u0012H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/bmhome/chat/search/view/SearchVideoLargeCardView;", "Lcom/larus/bmhome/chat/layout/widget/RoundFrameLayoutWithLastMotion;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textDesc", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageIcon", "ciciSourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "currentCardMode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "enableLegacyVideoGridWidthAdaptation", "", "setVideoInfo", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/VideoInfo;", "imgCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;", "position", "extra", "", "", "updateLayoutParams", "mode", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "getDefaultCardSize", "Lkotlin/Pair;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchVideoLargeCardView extends RoundFrameLayoutWithLastMotion {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f308696g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f308697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f308698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f308699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MarkdownSourceImageView f308700f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308701a = null;

        static {
            int[] r100 = new int[ExpandCardViewMode.values().length];
            r100[ExpandCardViewMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[ExpandCardViewMode.EXPAND_PIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[ExpandCardViewMode.NORMAL_PIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[ExpandCardViewMode.EXPAND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ExpandCardViewMode.NORMAL_SHARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[ExpandCardViewMode.EXPAND_SHARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f308701a = r100;
        }
    }

    static {
    }

    @Override // com.larus.common_ui.widget.roundlayout.RoundFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public SearchVideoLargeCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ExpandCardViewMode r103 = ExpandCardViewMode.NORMAL;
        z2.f365865a.w3();
        View r104 = FrameLayout.inflate(r100, R.layout.larus_search_video_large_card_view, this);
        this.f308697c = (TextView) r104.findViewById(R.id.text_description);
        this.f308698d = (SimpleDraweeView) r104.findViewById(R.id.image_cover);
        this.f308699e = (SimpleDraweeView) r104.findViewById(R.id.image_creator_avatar);
        this.f308700f = (MarkdownSourceImageView) r104.findViewById(R.id.sourceIcon);
        setLayoutParams(new FrameLayout.LayoutParams(i5.s(), i5.G()));
    }
}
