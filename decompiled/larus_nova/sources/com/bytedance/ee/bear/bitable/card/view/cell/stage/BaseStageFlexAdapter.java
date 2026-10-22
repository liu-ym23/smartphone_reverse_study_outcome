package com.bytedance.ee.bear.bitable.card.view.cell.stage;

import android.content.res.ColorStateList;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageType;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.d;
import com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.util.ui.ColorUtils;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00142\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/BaseStageFlexAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexLimitLineAdapter;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "layoutResId", "", "<init>", "(I)V", "getMeasureText", "", MapController.ITEM_LAYER_TAG, "convert", "", "helper", "Lcom/chad/library/adapter/base/BaseViewHolder;", "applyTagBackground", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "applyStatusDot", "iconRing", "Lcom/bytedance/ee/bear/bitable/common/widgets/common/RingView;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseStageFlexAdapter extends BaseFlexLimitLineAdapter<d> {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f208194a = null;

        static {
            int[] r100 = new int[StageType.values().length];
            r100[StageType.EndDone.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[StageType.EndCancel.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[StageType.Default.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f208194a = r100;
        }
    }

    static {
    }

    public void D2(RingView r100) {
        Intrinsics.checkNotNullParameter(r100, "iconRing");
    }

    public BaseStageFlexAdapter(int r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final String B2(d r100) {
        d r101 = r100;
        if (r101 == null) goto L6;
        String r102 = r101.f207142b;
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public void E2(ViewGroup r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        r100.setBackgroundTintList(ColorStateList.valueOf(ColorUtils.h(r101.f207144d)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("BaseStageFlexAdapter", "parse color failed!", e, false);
    }

    public void F2(BaseViewHolder r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        if (r101 != null) goto L5;
        return;
    L5:
        ViewGroup r102 = (ViewGroup) r100.getView(R.id.cell_item);
        Intrinsics.checkNotNull(r102);
        E2(r102, r101);
        TextView r103 = (TextView) r100.getView(R.id.tv_name);
        r103.setTextColor(ColorUtils.h(r101.f207145e));     // Catch: Exception -> L8
    L10:
        r103.setText(r101.f207142b);
        ImageView r104 = (ImageView) r100.getView(R.id.icon_done);
        RingView r105 = (RingView) r100.getView(R.id.icon_ring);
        Intrinsics.checkNotNull(r105);
        D2(r105);
        StageType r106 = r101.getType();
        int r107 = b.f208194a[r106.ordinal()];
        if (r107 != 1) goto L13;
        r104.setVisibility(0);
        r105.setVisibility(8);
        return;
    L13:
        if (r107 != 2) goto L15;
        r104.setVisibility(8);
        r105.setVisibility(0);
        r105.a(UIHelper.getColor(R.color.ud_R500), UIHelper.getColor(R.color.ud_R300));
        return;
    L15:
        if (r107 != 3) goto L18;
        r104.setVisibility(8);
        r105.setVisibility(0);
        r105.a(UIHelper.getColor(R.color.ud_O350), UIHelper.getColor(R.color.ud_O200));
        return;
    L18:
        throw new NoWhenBranchMatchedException();
    L8:
        e = move-exception;
        tt5.a.e("BaseStageFlexAdapter", "parse color failed!", e, false);
        goto L10
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Object r101) {
        F2(r100, (d) r101);
    }
}
