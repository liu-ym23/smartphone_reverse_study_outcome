package com.bytedance.ee.bear.bitable.card.view.cell.user;

import android.graphics.Paint;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u0004:\u0001#B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0014J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/user/FlexUserAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexMeasure;", "<init>", "()V", "mDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/user/IUserDelegate;", "getMDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/user/IUserDelegate;", "setMDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/user/IUserDelegate;)V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "convert", "", "helper", MapController.ITEM_LAYER_TAG, "getMeasureHeight", "", "widthSpec", "heightSpec", "getItemWidth", "t", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlexUserAdapter extends BaseQuickAdapter<UserEntity, BaseViewHolder> implements com.bytedance.ee.bear.bitable.common.widgets.flex.b<UserEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.user.a f208350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f208351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f208352c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* synthetic */ boolean M1() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* synthetic */ boolean R() {
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* synthetic */ float m1() {
        return 0.0f;
    }

    public FlexUserAdapter() {
        super(R.layout.bitable_cell_user_rv_item);
        this.f208352c = LazyKt.lazy(FlexUserAdapter$paint$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float g2(UserEntity r100) {
        return ((Paint) this.f208352c.getValue()).measureText(UserItemView.b(r100, this.f208350a)) + n.d(42);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, UserEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        UserItemView r102 = (UserItemView) r100.getView(R.id.user_item);
        r102.setDelegate(this.f208350a);
        r102.a(r101);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final int k0(int r100, int r101) {
        if (this.f208351b != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        return View.MeasureSpec.makeMeasureSpec((int) (com.bytedance.ee.bear.bitable.common.widgets.flex.a.a(this, getData(), View.MeasureSpec.getSize(r100), this.f208351b) * n.d(38)), 1073741824);
    L5:
        r102 = false;
        goto L6
    }
}
