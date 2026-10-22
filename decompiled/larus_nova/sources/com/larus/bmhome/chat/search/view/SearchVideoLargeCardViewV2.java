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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/search/view/SearchVideoLargeCardViewV2;", "Lcom/larus/bmhome/chat/layout/widget/RoundFrameLayoutWithLastMotion;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textDesc", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageIcon", "ciciSourceIcon", "Lcom/larus/bmhome/chat/markdown/imagegroup/view/MarkdownSourceImageView;", "setVideoInfo", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/VideoInfo;", "imgCallback", "Lcom/larus/bmhome/chat/search/factory/ISearchImgCallback;", "position", "extra", "", "", "updateLayoutParams", "mode", "Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchVideoLargeCardViewV2 extends RoundFrameLayoutWithLastMotion {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f308702g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f308703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f308704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f308705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MarkdownSourceImageView f308706f;

    public static final class a {
    }

    static {
    }

    public SearchVideoLargeCardViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = FrameLayout.inflate(r100, R.layout.larus_search_video_large_card_view_v2, this);
        this.f308703c = (TextView) r103.findViewById(R.id.text_description);
        this.f308704d = (SimpleDraweeView) r103.findViewById(R.id.image_cover);
        this.f308705e = (SimpleDraweeView) r103.findViewById(R.id.image_creator_avatar);
        this.f308706f = (MarkdownSourceImageView) r103.findViewById(R.id.sourceIcon);
        setLayoutParams(new FrameLayout.LayoutParams(i5.n(), i5.D()));
    }
}
