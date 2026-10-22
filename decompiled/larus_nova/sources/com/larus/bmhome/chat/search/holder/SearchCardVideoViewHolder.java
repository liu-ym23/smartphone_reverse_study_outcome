package com.larus.bmhome.chat.search.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "texCreator", "Landroid/widget/TextView;", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageCreateAvatar", "bind", "", "position", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/VideoInfo;", "extra", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCardVideoViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f308679d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f308680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f308681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f308682c;

    public static final class a {
    }

    static {
    }

    public SearchCardVideoViewHolder(View r100) {
        super(r100);
        this.f308680a = (TextView) r100.findViewById(R.id.text_creator);
        this.f308681b = (SimpleDraweeView) r100.findViewById(R.id.image_cover);
        this.f308682c = (SimpleDraweeView) r100.findViewById(R.id.image_creator_avatar);
    }
}
