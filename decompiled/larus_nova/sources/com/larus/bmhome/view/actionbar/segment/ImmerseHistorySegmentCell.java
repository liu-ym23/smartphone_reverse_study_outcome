package com.larus.bmhome.view.actionbar.segment;

import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.databinding.LarusChatItemCustomActionbarNormalHolderBinding;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/ImmerseHistorySegmentCell;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusChatItemCustomActionbarNormalHolderBinding;", "defaultClickCallback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerse", "", "<init>", "(Lcom/larus/bmhome/databinding/LarusChatItemCustomActionbarNormalHolderBinding;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;Z)V", "getBinding", "()Lcom/larus/bmhome/databinding/LarusChatItemCustomActionbarNormalHolderBinding;", "bind", "", "name", "", "url", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "position", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImmerseHistorySegmentCell extends BaseActionBarHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f316807d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusChatItemCustomActionbarNormalHolderBinding f316808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f316809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f316810c;

    public ImmerseHistorySegmentCell(LarusChatItemCustomActionbarNormalHolderBinding r100, t1 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r101, "defaultClickCallback");
        super(r100.f310794a);
        this.f316808a = r100;
        this.f316809b = r101;
        this.f316810c = r102;
    }
}
