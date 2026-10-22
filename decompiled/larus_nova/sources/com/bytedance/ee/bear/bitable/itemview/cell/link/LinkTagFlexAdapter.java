package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0012\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagFlexAdapter;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagAllAdapter;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexMeasure;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagItem;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "fullWidth", "", "getFullWidth", "()Z", "setFullWidth", "(Z)V", "useNewLayout", "getUseNewLayout", "setUseNewLayout", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "getMeasureHeight", "", "widthSpec", "heightSpec", "getItemWidth", "t", "getItemMargin", "isMeasureWidthExactly", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkTagFlexAdapter extends LinkTagAllAdapter implements com.bytedance.ee.bear.bitable.common.widgets.flex.b<LinkTagItem> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f213934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f213935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f213936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f213937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f213938k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return n.d(8);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean M1() {
        return this.f213937j;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean R() {
        return this.f213936i;
    }

    public LinkTagFlexAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f213934g = r100;
        this.f213935h = 6.5f;
        this.f213936i = true;
        this.f213938k = LazyKt.lazy(LinkTagFlexAdapter$paint$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final /* bridge */ /* synthetic */ float g2(LinkTagItem r100) {
        return y2(r100);
    }

    public final float y2(LinkTagItem r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getTitle();
    L7:
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        r101 = this.f213934g.getString(R.string.Doc_Block_UnnamedRecord);
    L17:
        if (r101 != null) goto L19;
    L22:
        r101 = "";
    L24:
        return ((Paint) this.f213938k.getValue()).measureText(r101) + n.d(26);
    L19:
        if (r101.length() <= 200) goto L21;
        r101 = r101.substring(0, 200);
    L21:
        if (r101 != null) goto L24;
    L15:
        if (r100 == null) goto L17;
        r101 = r100.getTitle();
        goto L17
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final int k0(int r100, int r101) {
        if (this.f213935h != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        if (this.f213936i == false) goto L11;
    L14:
        float r103 = com.bytedance.ee.bear.bitable.common.widgets.flex.a.a(this, this.f213903b, View.MeasureSpec.getSize(r100), this.f213935h);
    L16:
        return View.MeasureSpec.makeMeasureSpec((int) (r103 * n.d(32)), 1073741824);
    L11:
        if (this.f213937j == true) goto L14;
        r103 = 1.0f;
        goto L16
    L5:
        r102 = false;
        goto L6
    }
}
