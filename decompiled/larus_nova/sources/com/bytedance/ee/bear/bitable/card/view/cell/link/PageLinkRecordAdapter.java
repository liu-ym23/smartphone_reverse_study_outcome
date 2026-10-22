package com.bytedance.ee.bear.bitable.card.view.cell.link;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010%\u001a\u00020\rH\u0016J\b\u0010&\u001a\u00020\u0013H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/link/PageLinkRecordAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/link/LinkRecordAdapter;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexMeasure;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/STRecord;", "delegate", "Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Lcom/bytedance/ee/bear/bitable/card/view/IBitableCardDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "fullWidth", "", "getFullWidth", "()Z", "setFullWidth", "(Z)V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "getMeasureHeight", "widthSpec", "heightSpec", "getItemWidth", "t", "getItemMargin", "isMeasureWidthExactly", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageLinkRecordAdapter extends LinkRecordAdapter implements com.bytedance.ee.bear.bitable.common.widgets.flex.b<cp4.a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f207728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f207729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f207730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f207731l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* synthetic */ boolean M1() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.link.LinkRecordAdapter
    public final int getLayoutId() {
        return R.layout.bitable_page_link_rv_item;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return com.bytedance.ee.util.ui.n.d(8);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean R() {
        return this.f207730k;
    }

    public final Context getContext() {
        return this.f207728i;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* bridge */ /* synthetic */ float g2(cp4.a r100) {
        return y2(r100);
    }

    public final float y2(cp4.a r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f464637d;
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        r101 = this.f207728i.getString(R.string.Doc_Block_UnnamedRecord);
    L16:
        Paint r104 = (Paint) this.f207731l.getValue();
        if (r101 != null) goto L20;
        r101 = "";
    L20:
        return r104.measureText(r101) + com.bytedance.ee.util.ui.n.d(26);
    L14:
        if (r100 == null) goto L16;
        r101 = r100.f464637d;
        goto L16
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public PageLinkRecordAdapter(gp4.h r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f207728i = r101;
        this.f207730k = true;
        this.f207731l = LazyKt.lazy(PageLinkRecordAdapter$paint$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final int k0(int r100, int r101) {
        if (this.f207729j != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        if (this.f207730k == false) goto L11;
        float r103 = com.bytedance.ee.bear.bitable.common.widgets.flex.a.a(this, this.f207721d, View.MeasureSpec.getSize(r100), this.f207729j);
    L13:
        return View.MeasureSpec.makeMeasureSpec((int) (r103 * com.bytedance.ee.util.ui.n.d(32)), 1073741824);
    L11:
        r103 = 1.0f;
        goto L13
    L5:
        r102 = false;
        goto L6
    }
}
