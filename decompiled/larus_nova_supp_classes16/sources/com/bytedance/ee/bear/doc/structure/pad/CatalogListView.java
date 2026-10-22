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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0012J\b\u0010\u001d\u001a\u00020\u0012H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'*\u0004\b\"\u0010#R/\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001e\u001a\u0004\u0018\u00010(8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.*\u0004\b*\u0010#R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010\u001e\u001a\u0004\u0018\u00010/8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b2\u00103\"\u0004\b4\u00105*\u0004\b1\u0010#¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/doc/structure/pad/ICatalogAbility;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyView", "Landroid/view/View;", "adapter", "Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListAdapter;", "shadowView", "Lcom/bytedance/ee/bear/doc/structure/pad/RightShadowView;", "setShadowVisible", "", "visible", "", "setData", "structure", "Lcom/bytedance/ee/bear/doc/structure/Structure;", "addScrollListener", "Lkotlin/Function0;", "listener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "endAllAnimations", "setupView", "<set-?>", "Lkotlin/Function2;", "Lcom/bytedance/ee/bear/doc/structure/Structure$Paragraph;", "itemClickListener", "getItemClickListener$delegate", "(Lcom/bytedance/ee/bear/doc/structure/pad/CatalogListView;)Ljava/lang/Object;", "getItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "Landroid/view/View$OnHoverListener;", "itemHoverListener", "getItemHoverListener$delegate", "getItemHoverListener", "()Landroid/view/View$OnHoverListener;", "setItemHoverListener", "(Landroid/view/View$OnHoverListener;)V", "", "activeContentId", "getActiveContentId$delegate", "getActiveContentId", "()Ljava/lang/String;", "setActiveContentId", "(Ljava/lang/String;)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogListView extends FrameLayout {
    public final RecyclerView a;
    public final View b;
    public final CatalogListAdapter c;
    public final RightShadowView d;

    public String getActiveContentId() {
        return this.c.g;
    }

    public Function2<View, Structure.Paragraph, Unit> getItemClickListener() {
        return this.c.e;
    }

    public View.OnHoverListener getItemHoverListener() {
        return this.c.f;
    }

    public CatalogListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final Function0 a(final PadCatalogController$setupView$3 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.addOnScrollListener(r2);
        return new CatalogListView$addScrollListener$1(this, r2);
    }

    public void setActiveContentId(String r7) {
        CatalogListAdapter r0 = this.c;
        r0.g = r7;
        if (r7 == null) goto L15;
        Structure r8 = r0.b;
        if (r8 == null) goto L15;
        Structure.Paragraph[] r9 = r8.paragraphs;
        if (r9 == null) goto L15;
        int r2 = r9.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        if (Intrinsics.areEqual(r9[r3].getHash(), r0.g) == true) goto L16;
        r3 = r3 + 1;
    L16:
        r0.d.setValue(r0, CatalogListAdapter.h[0], Integer.valueOf(r3));
        return;
    L14:
        r3 = -1;
    L15:
        r3 = 0;
        goto L16
    }

    public final void setData(Structure r4) {
        if (r4 == null) goto L4;
        Structure.Paragraph[] r0 = r4.paragraphs;
    L6:
        if (r0 == null) goto L14;
        boolean r2 = true;
        if (r4.paragraphs.length != 0) goto L10;
        boolean r1 = true;
    L12:
        if ((!r1) == false) goto L14;
    L16:
        if (r2 == false) goto L18;
        this.a.setVisibility(0);
        this.b.setVisibility(8);
    L19:
        CatalogListAdapter r3 = this.c;
        r3.b = r4;
        r3.notifyDataSetChanged();
        return;
    L18:
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        goto L19
    L10:
        r1 = false;
    L14:
        r2 = false;
        goto L16
    L4:
        r0 = null;
        goto L6
    }

    public void setItemClickListener(Function2<? super View, ? super Structure.Paragraph, Unit> r2) {
        this.c.e = r2;
    }

    public void setItemHoverListener(View.OnHoverListener r2) {
        this.c.f = r2;
    }

    public final void setShadowVisible(boolean r2) {
        RightShadowView r0 = this.d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public CatalogListView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        LayoutInflater.from(r4).inflate(2131564157, this, true);
        RecyclerView r6 = findViewById(2131365279);
        this.a = r6;
        this.b = findViewById(2131378771);
        CatalogListAdapter r7 = new CatalogListAdapter(r6);
        this.c = r7;
        RightShadowView r0 = (RightShadowView) findViewById(2131384624);
        this.d = r0;
        r6.setLayoutManager(new CenterLayoutManager(getContext()));
        r6.setAdapter(r7);
        r0.setShadowWidth(n.d(8));
        setData(null);
    }
}
