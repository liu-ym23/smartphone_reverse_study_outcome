package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.CoverFitType;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001c\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\u0017J\b\u0010#\u001a\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "coverAdapter", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryCoverAdapter;", "coverViewPager", "Landroidx/viewpager/widget/ViewPager;", "coverIndexLayout", "Landroid/view/View;", "coverIndex", "Landroid/widget/TextView;", "coverEmptyLayout", "coverEmptyImage", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cover/GalleryEmptyCoverView;", "coverDivider", "init", "", "setCoverFitType", "fitType", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/CoverFitType;", "setObjToken", "token", "", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", DyPayConstant.KEY_SHOW_LOADING, "resetView", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryCoverView extends FrameLayout implements gv4.b<GalleryCoverData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GalleryCoverAdapter f213468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager f213469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f213470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f213471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f213472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GalleryEmptyCoverView f213473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f213474g;

    public final void a() {
        this.f213468a.f(null);
        this.f213468a.f213457e = null;
        this.f213469b.setVisibility(0);
        this.f213469b.setCurrentItem(0);
        this.f213470c.setVisibility(8);
        this.f213474g.setVisibility(8);
        this.f213472e.setVisibility(8);
        setBackground(null);
    }

    public GalleryCoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setCoverFitType(CoverFitType r100) {
        Intrinsics.checkNotNullParameter(r100, "fitType");
        GalleryCoverAdapter r101 = this.f213468a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "fitType");
        if (r100 == r101.f213456d) goto L5;
        boolean r102 = true;
    L6:
        r101.f213456d = r100;
        if (r102 == false) goto L9;
        tt5.a.h("GalleryCoverAdapter", "notifyCoverFitTypeChange");
        r101.notifyDataSetChanged();
        return;
    L9:
        tt5.a.h("GalleryCoverAdapter", "no fitType changed");
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setObjToken(String r100) {
        this.f213468a.f213458f = r100;
    }

    public GalleryCoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_gallery_cover_page_view_pager, this);
        ViewPager r102 = (ViewPager) findViewById(R.id.bitable_card_cover_view_pager);
        this.f213469b = r102;
        this.f213470c = findViewById(R.id.cover_index_layout);
        this.f213471d = (TextView) findViewById(R.id.cover_index);
        this.f213472e = findViewById(R.id.bitable_card_cover_empty_layout);
        this.f213473f = (GalleryEmptyCoverView) findViewById(R.id.bitable_card_cover_empty_image);
        View r103 = new View(r100);
        this.f213474g = r103;
        r103.setBackgroundColor(n.h(r100, R.color.line_border_card));
        addView(r103, new FrameLayout.LayoutParams(-1, n.c(0.5f), 80));
        GalleryCoverAdapter r104 = new GalleryCoverAdapter(r100);
        this.f213468a = r104;
        r102.setAdapter(r104);
        r102.setOnPageChangeListener(new GalleryCoverView$init$1(this));
        setCoverFitType(CoverFitType.FIT);
    }

    public final void b(final GalleryCoverData r100, final gv4.e r101) {
        if (r100 == null) goto L5;
        ArrayList<AttachmentEntity> r102 = r100.getCovers();
    L6:
        int r103 = 0;
        if (r102 != null) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L36;
        this.f213468a.f(r102);
        this.f213468a.f213457e = new GalleryCoverView$setData$1(r100, r101);
        this.f213469b.setVisibility(0);
        ViewPager r105 = this.f213469b;
        GalleryCoverAdapter r106 = this.f213468a;
        List<? extends AttachmentEntity> r107 = r106.f213454b;
        if (r107 == null) goto L18;
        int r108 = r107.size();
    L19:
        int r109 = r106.f213455c;
        if (r109 < r108) goto L23;
        r109 = 0;
    L23:
        r105.setCurrentItem(r109);
        View r110 = this.f213470c;
        if (r102.size() <= 1) goto L26;
        int r111 = 0;
    L27:
        r110.setVisibility(r111);
        StringBuilder r112 = new StringBuilder();
        GalleryCoverAdapter r113 = this.f213468a;
        List<? extends AttachmentEntity> r114 = r113.f213454b;
        if (r114 == null) goto L30;
        int r115 = r114.size();
    L31:
        int r116 = r113.f213455c;
        if (r116 < r115) goto L35;
        r116 = 0;
    L35:
        r112.append(r116 + 1);
        r112.append('/');
        r112.append(this.f213468a.getCount());
        this.f213471d.setText(r112.toString());
        this.f213474g.setVisibility(0);
        this.f213472e.setVisibility(8);
        setBackground(null);
        return;
    L30:
        r115 = 0;
        goto L31
    L26:
        r111 = 8;
        goto L27
    L18:
        r108 = 0;
        goto L19
    L36:
        a();
        this.f213469b.setVisibility(8);
        this.f213472e.setVisibility(0);
        GalleryEmptyCoverView r117 = this.f213473f;
        if (r100 == null) goto L39;
        int r118 = r100.getIndex();
    L40:
        r117.setTopCircleColorByIndex(r118);
        GalleryEmptyCoverView r119 = this.f213473f;
        if (r100 == null) goto L43;
        r103 = r100.getIndex();
    L43:
        setBackground(r119.b(r103));
        return;
    L39:
        r118 = 0;
        goto L40
    L9:
        if (r102.isEmpty() == true) goto L12;
        r104 = false;
        goto L14
    L5:
        r102 = null;
        goto L6
    }
}
