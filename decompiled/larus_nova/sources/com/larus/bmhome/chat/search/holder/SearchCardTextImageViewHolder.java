package com.larus.bmhome.chat.search.holder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0018\u00010\u001fR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/chat/search/holder/SearchCardTextImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textLineSpacing", "", "getTextLineSpacing", "()F", "textTitle", "Landroid/widget/TextView;", "getTextTitle", "()Landroid/widget/TextView;", "textDescription", "getTextDescription", "texCreator", "getTexCreator", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageCover", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imageCreateAvatar", "getImageCreateAvatar", "bind", "", "position", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/chat/search/ArticleInfo;", "extra", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchCardTextImageViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f308639f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f308640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f308641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f308642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f308643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f308644e;

    public static final class a {
    }

    static {
    }

    public SearchCardTextImageViewHolder(View r100) {
        super(r100);
        this.f308640a = (TextView) r100.findViewById(R.id.text_title);
        this.f308641b = (TextView) r100.findViewById(R.id.text_description);
        this.f308642c = (TextView) r100.findViewById(R.id.text_creator);
        this.f308643d = (SimpleDraweeView) r100.findViewById(R.id.image_cover);
        this.f308644e = (SimpleDraweeView) r100.findViewById(R.id.image_creator_avatar);
    }
}
