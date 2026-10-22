package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.graphics.Paint;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001$B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0017\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010#R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexLimitLineAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexMeasure;", "layoutResId", "", "<init>", "(I)V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "textSizeDp", "getTextSizeDp", "()I", "fixWidthDp", "getFixWidthDp", "itemHeightDp", "getItemHeightDp", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "getMeasureHeight", "widthSpec", "heightSpec", "getItemWidth", "t", "(Ljava/lang/Object;)F", "getMeasureText", "", MapController.ITEM_LAYER_TAG, "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFlexLimitLineAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> implements com.bytedance.ee.bear.bitable.common.widgets.flex.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f208031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f208032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f208033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f208034d;

    public static final class a {
    }

    static {
    }

    public float A2() {
        return 0.0f;
    }

    public abstract String B2(T r100);

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public /* synthetic */ boolean M1() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public /* synthetic */ boolean R() {
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public /* synthetic */ float m1() {
        return 0.0f;
    }

    public int C2() {
        return this.f208031a;
    }

    public int y2() {
        return this.f208032b;
    }

    public int z2() {
        return this.f208033c;
    }

    public BaseFlexLimitLineAdapter(int r100) {
        super(r100);
        this.f208031a = 13;
        this.f208032b = 28;
        this.f208033c = 34;
        this.f208034d = LazyKt.lazy(new BaseFlexLimitLineAdapter$paint$2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float g2(T r100) {
        return ((Paint) this.f208034d.getValue()).measureText(B2(r100)) + com.bytedance.ee.util.ui.n.d(y2());
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final int k0(int r100, int r101) {
        if (A2() != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        if (R() == false) goto L11;
    L14:
        float r103 = com.bytedance.ee.bear.bitable.common.widgets.flex.a.a(this, getData(), View.MeasureSpec.getSize(r100), A2());
    L16:
        return View.MeasureSpec.makeMeasureSpec((int) (r103 * com.bytedance.ee.util.ui.n.d(z2())), 1073741824);
    L11:
        if (M1() == true) goto L14;
        r103 = 1.0f;
        goto L16
    L5:
        r102 = false;
        goto L6
    }
}
