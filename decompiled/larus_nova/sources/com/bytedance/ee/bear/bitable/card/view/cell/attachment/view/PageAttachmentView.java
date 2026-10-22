package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;
import com.bytedance.ee.bear.bitable.common.widgets.flex.FixedSizeDebounceInnerRecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.SafeFlexboxLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001f\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00102\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/PageAttachmentView;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentGridView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPerfItemViewComplexCellEnable", "", "itemFixedWidth", "itemFixedHeight", "itemWidthMargin", "init", "", "setFixedSize", "entityCount", "attachmentViewWidth", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setData", "data", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "updateWidth", "needFullWidth", "limitMaxVisibleLine", GXTemplateKey.STYLE_FONT_LINES, "", "getItemWidth", "getItemWidthMargin", "setAttachmentViewDelegate", "attachmentViewDelegate", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/IAttachmentViewDelegate;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageAttachmentView extends AttachmentGridView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f207455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f207456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f207457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f207458i;

    public static final class a {
    }

    static {
    }

    public PageAttachmentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PageAttachmentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public float getItemWidth() {
        return this.f207456g;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public float getItemWidthMargin() {
        return this.f207458i;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public final void a() {
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r100 = true;
    L6:
        setMIsLandscape(r100);
        int r101 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter("bitable.performance.item_view.complex_cell.enable", "key");
        boolean r102 = com.bytedance.ee.bear.bitable.core.usercomponent.b.d("bitable.performance.item_view.complex_cell.enable");
        this.f207455f = r102;
        if (r102 == false) goto L9;
        View.inflate(getContext(), R.layout.bitable_page_attachment_grid_layout_opt, this);
    L10:
        setMRecyclerView((RecyclerView) findViewById(R.id.attachment_grid_view_root_rv));
        getMRecyclerView().setHasFixedSize(true);
        getMRecyclerView().setLayoutManager(new SafeFlexboxLayoutManager(getContext()));
        setMAttachmentAdapter(new PageAttachAdapter());
        int r103 = com.bytedance.ee.bear.bitable.c.f207079a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.attachment_stable_id_crash_fix_enable") == false) goto L13;
        getMAttachmentAdapter().setHasStableIds(false);
    L14:
        getMRecyclerView().setAdapter(getMAttachmentAdapter());
        return;
    L13:
        getMAttachmentAdapter().setHasStableIds(true);
        goto L14
    L9:
        View.inflate(getContext(), R.layout.bitable_page_attachment_grid_layout, this);
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public final void b(float r100) {
        AttachmentAdapter r101 = getMAttachmentAdapter();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.PageAttachAdapter");
        ((PageAttachAdapter) r101).f207443h = r100;
        if ((getMRecyclerView() instanceof InnerRecyclerView) == false) goto L6;
        RecyclerView r102 = getMRecyclerView();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView");
        ((InnerRecyclerView) r102).setOpenInnerScroll(true);
        return;
    L6:
        if ((getMRecyclerView() instanceof FixedSizeDebounceInnerRecyclerView) == false) goto L10;
        RecyclerView r103 = getMRecyclerView();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.widgets.flex.FixedSizeDebounceInnerRecyclerView");
        ((FixedSizeDebounceInnerRecyclerView) r103).setOpenInnerScroll(true);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public final void c(boolean r100) {
        AttachmentAdapter r101 = getMAttachmentAdapter();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.PageAttachAdapter");
        ((PageAttachAdapter) r101).f207444i = r100;
        ViewGroup.LayoutParams r102 = getMRecyclerView().getLayoutParams();
        if (r100 == false) goto L5;
        int r103 = -1;
    L6:
        r102.width = r103;
        return;
    L5:
        r103 = -2;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public void setAttachmentViewDelegate(p r100) {
        getMAttachmentAdapter().f207382b = r100;
        if (r100 == null) goto L8;
        y1 r101 = r100.getMembraneManager();
        if (r101 == null) goto L9;
        getMRecyclerView().setRecycledViewPool(r101.f209194a.f208449d);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentGridView
    public void setData(List<? extends AttachmentEntity> r110) {
        int r100 = 0;
        if (this.f207455f == false) goto L42;
        List<AttachmentEntity> r101 = getMAttachmentAdapter().f207381a;
        boolean r102 = true;
        if (Intrinsics.areEqual(r110, r101) == false) goto L8;
    L36:
        if (r102 == false) goto L42;
        StringBuilder r103 = new StringBuilder("setData debounce size=");
        if (r110 == null) goto L40;
        r100 = r110.size();
    L40:
        r103.append(r100);
        tt5.a.h("PageAttachmentView", r103.toString());
        return;
    L8:
        if (r110 == null) goto L10;
        Integer r104 = Integer.valueOf(r110.size());
    L11:
        if (r101 == null) goto L13;
        Integer r105 = Integer.valueOf(((ArrayList) r101).size());
    L15:
        if (Intrinsics.areEqual(r104, r105) == true) goto L17;
    L16:
        r102 = false;
        goto L36
    L17:
        if (r110 == null) goto L19;
        int r106 = r110.size();
    L20:
        if (r106 < 0) goto L36;
        int r107 = 0;
    L22:
        if (r110 == null) goto L31;
        AttachmentEntity r108 = (AttachmentEntity) ListProtector.get(r110, r107);
        if (r108 == null) goto L31;
        if (r101 == null) goto L27;
        AttachmentEntity r109 = (AttachmentEntity) ListProtector.get(r101, r107);
    L29:
        if (r108.equals(r109) != true) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == false) goto L16;
        if (r107 == r106) goto L36;
        r107 = r107 + 1;
        goto L22
    L27:
        r109 = null;
    L31:
        r111 = false;
        goto L32
    L19:
        r106 = 0;
        goto L20
    L13:
        r105 = null;
        goto L15
    L10:
        r104 = null;
    L42:
        StringBuilder r112 = new StringBuilder("setData size=");
        if (r110 == null) goto L45;
        r100 = r110.size();
    L45:
        r112.append(r100);
        tt5.a.h("PageAttachmentView", r112.toString());
        super.setData(r110);
    }

    public PageAttachmentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f207456g = com.bytedance.ee.util.ui.n.d(44);
        this.f207457h = com.bytedance.ee.util.ui.n.d(43);
        this.f207458i = com.bytedance.ee.util.ui.n.d(4);
    }

    public /* synthetic */ PageAttachmentView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
