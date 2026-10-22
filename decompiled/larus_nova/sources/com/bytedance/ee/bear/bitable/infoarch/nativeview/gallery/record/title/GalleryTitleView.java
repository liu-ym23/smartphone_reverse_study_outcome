package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.title;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.card.record.title.CardBaseTitleView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import iv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/title/GalleryTitleView;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/title/CardBaseTitleView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cellStyle", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/UIKitStyle;", "getCellStyle", "()Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/UIKitStyle;", "setCellStyle", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/UIKitStyle;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryTitleView extends CardBaseTitleView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f213505n;

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView
    public b getCellStyle() {
        return this.f213505n;
    }

    public GalleryTitleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView
    public void setCellStyle(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213505n = r100;
    }

    public GalleryTitleView(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, 0.8f, n.d(14));
        this.f213505n = new b(true, 16.0f, 0, 0, 12);
    }
}
