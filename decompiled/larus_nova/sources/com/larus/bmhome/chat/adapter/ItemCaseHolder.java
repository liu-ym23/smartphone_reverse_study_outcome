package com.larus.bmhome.chat.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0015J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/adapter/ItemCaseHolder;", "Lcom/larus/bmhome/chat/adapter/BaseCaseItemHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "coverContainer", "Landroid/view/ViewGroup;", "title", "Landroid/widget/TextView;", "description", ItemStyle.ITEM_STYLE_DIVIDER, "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/platform/model/showcase/Case;", "needDivider", "", "onItemClicked", "Lkotlin/Function0;", "setIconUrl", "coverUrl", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemCaseHolder extends BaseCaseItemHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f297016g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f297017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f297018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f297019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f297020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f297021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f297022f;

    public static final class a {
    }

    static {
    }

    public ItemCaseHolder(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f297017a = r100;
        this.f297018b = (SimpleDraweeView) r100.findViewById(R.id.img_cover);
        this.f297019c = (ViewGroup) r100.findViewById(R.id.img_cover_container);
        this.f297020d = (TextView) r100.findViewById(R.id.title);
        this.f297021e = (TextView) r100.findViewById(R.id.description);
        this.f297022f = r100.findViewById(R.id.divider);
    }
}
