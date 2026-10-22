package com.larus.bmhome.chat.standarduikit.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u001e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007J(\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J.\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/search/view/PureVideoItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textDesc", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageIcon", "adaptiveItemWidth", "overSeaSourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "updateAdaptiveWidth", "", "itemWidth", "bindData", "data", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewData;", "callback", "Lcom/larus/bmhome/chat/standarduikit/search/view/VideoCardViewCallback;", "position", "updateCover", BdpAppEventConstant.PARAMS_OUTPUT, "cardSize", "Lcom/larus/bmhome/chat/standarduikit/search/view/PureVideoItemView$CardSizeSpec;", "updateIcon", "isOversea", "", "iconUrl", "", "hostPageUrl", "messageId", "getAdaptiveCardSize", "mode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "updateLayoutParams", "Companion", "CardSizeSpec", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PureVideoItemView extends RoundFrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f309734g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f309735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f309736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f309737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f309738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MarkdownSourceImageView f309739f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f309740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f309741b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f309740a == r101.f309740a) goto L12;
            return false;
        L12:
            if (this.f309741b == r101.f309741b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f309740a * 31) + this.f309741b;
        }

        public final String toString() {
            return "CardSizeSpec(width=" + this.f309740a + ", height=" + this.f309741b + ')';
        }

        public a(int r100, int r101) {
            this.f309740a = r100;
            this.f309741b = r101;
        }
    }

    public static final class b {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f309742a = null;

            static {
                int[] r100 = new int[ExpandCardViewMode.values().length];
                r100[ExpandCardViewMode.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[ExpandCardViewMode.EXPAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[ExpandCardViewMode.EXPAND_PIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[ExpandCardViewMode.NORMAL_PIC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[ExpandCardViewMode.NORMAL_SHARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[ExpandCardViewMode.EXPAND_SHARE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f309742a = r100;
            }
        }

        public static a a(ExpandCardViewMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            switch(a.f309742a[r100.ordinal()]) {
                case 1: goto L8;
                case 2: goto L8;
                case 3: goto L8;
                case 4: goto L8;
                case 5: goto L9;
                case 6: goto L9;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L9:
            return new a(i5.r(), i5.F());
        L8:
            return new a(i5.s(), i5.G());
        }
    }

    static {
    }

    public PureVideoItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = FrameLayout.inflate(r100, R.layout.larus_block_search_video_card_view, this);
        this.f309735b = (TextView) r103.findViewById(R.id.text_description);
        this.f309736c = (SimpleDraweeView) r103.findViewById(R.id.image_cover);
        this.f309737d = (SimpleDraweeView) r103.findViewById(R.id.image_creator_avatar);
        this.f309739f = (MarkdownSourceImageView) r103.findViewById(R.id.sourceIcon);
        a r104 = b.a(ExpandCardViewMode.NORMAL);
        setLayoutParams(new FrameLayout.LayoutParams(r104.f309740a, r104.f309741b));
    }
}
