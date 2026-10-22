package com.bytedance.ee.bear.doc.structure.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.doc.structure.Structure;
import com.bytedance.ee.bear.doc.structure.pad.container.PadCatalogController$setupView$3;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0012J\b\u0010\u001d\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'*\u0004\b\"\u0010#R/\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001e\u001a\u0004\u0018\u00010(8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.*\u0004\b*\u0010#R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u001e\u001a\u0004\u0018\u00010/8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b2\u00103\"\u0004\b4\u00105*\u0004\b1\u0010#¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/doc/structure/pad/ICatalogAbility;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyView", "Landroid/view/View;", "adapter", "Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListAdapter;", "shadowView", "Lcom/bytedance/ee/bear/doc/structure/pad/RightShadowView;", "setShadowVisible", "", "visible", "", "setData", "structure", "Lcom/bytedance/ee/bear/doc/structure/Structure;", "addScrollListener", "Lkotlin/Function0;", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "endAllAnimations", "setupView", "<set-?>", "Lkotlin/Function2;", "Lcom/bytedance/ee/bear/doc/structure/Structure$Paragraph;", "itemClickListener", "getItemClickListener$delegate", "(Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListView;)Ljava/lang/Object;", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/view/View$OnHoverListener;", "itemHoverListener", "getItemHoverListener$delegate", "getItemHoverListener", "()Landroid/view/View$OnHoverListener;", "setItemHoverListener", "(Landroid/view/View$OnHoverListener;)V", "", "activeContentId", "getActiveContentId$delegate", "getActiveContentId", "()Ljava/lang/String;", "setActiveContentId", "(Ljava/lang/String;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogListView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f218212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f218213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CatalogListAdapter f218214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RightShadowView f218215d;

    public String getActiveContentId() {
        return this.f218214c.f218210g;
    }

    public Function2<View, Structure.Paragraph, Unit> getItemClickListener() {
        return this.f218214c.f218208e;
    }

    public View.OnHoverListener getItemHoverListener() {
        return this.f218214c.f218209f;
    }

    public CatalogListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final Function0 a(final PadCatalogController$setupView$3 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f218212a.addOnScrollListener(r100);
        return new CatalogListView$addScrollListener$1(this, r100);
    }

    public void setActiveContentId(String r100) {
        CatalogListAdapter r101 = this.f218214c;
        r101.f218210g = r100;
        if (r100 == null) goto L15;
        Structure r102 = r101.f218205b;
        if (r102 == null) goto L15;
        Structure.Paragraph[] r103 = r102.paragraphs;
        if (r103 == null) goto L15;
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L14;
        if (Intrinsics.areEqual(r103[r105].getHash(), r101.f218210g) == true) goto L16;
        r105 = r105 + 1;
    L16:
        r101.f218207d.setValue(r101, CatalogListAdapter.f218201h[0], Integer.valueOf(r105));
        return;
    L14:
        r105 = -1;
    L15:
        r105 = 0;
        goto L16
    }

    public final void setData(Structure r100) {
        if (r100 == null) goto L4;
        Structure.Paragraph[] r101 = r100.paragraphs;
    L6:
        if (r101 == null) goto L14;
        boolean r102 = true;
        if (r100.paragraphs.length != 0) goto L10;
        boolean r103 = true;
    L12:
        if ((!r103) == false) goto L14;
    L16:
        if (r102 == false) goto L18;
        this.f218212a.setVisibility(0);
        this.f218213b.setVisibility(8);
    L19:
        CatalogListAdapter r104 = this.f218214c;
        r104.f218205b = r100;
        r104.notifyDataSetChanged();
        return;
    L18:
        this.f218212a.setVisibility(8);
        this.f218213b.setVisibility(0);
        goto L19
    L10:
        r103 = false;
    L14:
        r102 = false;
        goto L16
    L4:
        r101 = null;
        goto L6
    }

    public void setItemClickListener(Function2<? super View, ? super Structure.Paragraph, Unit> r100) {
        this.f218214c.f218208e = r100;
    }

    public void setItemHoverListener(View.OnHoverListener r100) {
        this.f218214c.f218209f = r100;
    }

    public final void setShadowVisible(boolean r100) {
        RightShadowView r101 = this.f218215d;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public CatalogListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.pad_catalog_list_container, this, true);
        RecyclerView r102 = (RecyclerView) findViewById(R.id.catalog_recycler_view);
        this.f218212a = r102;
        this.f218213b = findViewById(R.id.ll_no_data);
        CatalogListAdapter r103 = new CatalogListAdapter(r102);
        this.f218214c = r103;
        RightShadowView r104 = (RightShadowView) findViewById(R.id.right_shadow_view);
        this.f218215d = r104;
        r102.setLayoutManager(new CenterLayoutManager(getContext()));
        r102.setAdapter(r103);
        r104.setShadowWidth(n.d(8));
        setData(null);
    }
}
