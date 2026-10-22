package com.larus.bmhome.chat.search.holder;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010\"J\b\u0010$\u001a\u00020\bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardVideoTinyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "indicator", "", "abVersion", "useDetailBox", "", "<init>", "(Landroid/view/View;IIZ)V", "getIndicator", "()I", "getAbVersion", "getUseDetailBox", "()Z", "textCreator", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageCreateAvatar", "videoPlay", "Landroidx/appcompat/widget/AppCompatImageView;", "textTitle", "videoMask", "Landroid/widget/FrameLayout;", "rootView", "Lcom/larus/common_ui/widget/roundlayout/RoundFrameLayout;", "bind", "", "position", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/VideoInfo;", "extra", "", "", "shouldGone", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCardVideoTinyViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f308668k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f308669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f308670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f308671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f308672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f308673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SimpleDraweeView f308674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f308675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f308676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f308677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RoundFrameLayout f308678j;

    public static final class a {
    }

    static {
    }

    public SearchCardVideoTinyViewHolder(View r100, int r101, int r102, boolean r103) {
        super(r100);
        this.f308669a = r101;
        this.f308670b = r102;
        this.f308671c = r103;
        this.f308672d = (TextView) r100.findViewById(R.id.text_creator);
        this.f308673e = (SimpleDraweeView) r100.findViewById(R.id.image_cover);
        this.f308674f = (SimpleDraweeView) r100.findViewById(R.id.image_creator_avatar);
        this.f308675g = (AppCompatImageView) r100.findViewById(R.id.video_play);
        this.f308676h = (TextView) r100.findViewById(R.id.text_title);
        this.f308677i = (FrameLayout) r100.findViewById(R.id.video_mask);
        this.f308678j = (RoundFrameLayout) r100.findViewById(R.id.root_view);
    }
}
