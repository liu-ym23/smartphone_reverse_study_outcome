package com.larus.collection.impl.view;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.baidu.platform.comapi.map.MapController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larus/collection/impl/view/NormalCollectionItemHolder;", "Lcom/larus/collection/impl/view/BaseCollectionItemHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/collection/impl/view/CollectionListHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/collection/impl/view/CollectionListHolderCallback;)V", "imageCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "subIcon", "imageGroup", "Landroidx/constraintlayout/widget/Group;", "title", "Landroid/widget/TextView;", "description", "createTimeView", "source", "touchXOffset", "", "touchYOffset", "bindData", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/platform/model/MessageCollection;", "setIconUrl", "coverUrl", "", "subIconUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalCollectionItemHolder extends BaseCollectionItemHolder {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f325614l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f325615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.collection.impl.view.a f325616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f325617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f325618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Group f325619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f325620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f325621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f325622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f325623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f325624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f325625k;

    public static final class a {
    }

    static {
    }

    public NormalCollectionItemHolder(ConstraintLayout r100, com.larus.collection.impl.view.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f325615a = r100;
        this.f325616b = r101;
        this.f325617c = (SimpleDraweeView) r100.findViewById(R.id.img_cover);
        this.f325618d = (SimpleDraweeView) r100.findViewById(R.id.sub_icon);
        this.f325619e = (Group) r100.findViewById(R.id.item_img_group);
        this.f325620f = (TextView) r100.findViewById(R.id.title);
        this.f325621g = (TextView) r100.findViewById(R.id.description);
        this.f325622h = (TextView) r100.findViewById(R.id.collection_create_time);
        this.f325623i = (TextView) r100.findViewById(R.id.source);
    }
}
