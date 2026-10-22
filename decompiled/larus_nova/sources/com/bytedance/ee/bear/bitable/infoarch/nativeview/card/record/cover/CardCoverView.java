package com.bytedance.ee.bear.bitable.infoarch.nativeview.card.record.cover;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentCoverView;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.n;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/cover/CardCoverView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ILoadingView;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/card/record/cover/CardCoverData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attachmentCoverView", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentCoverView;", "emptyCoverView", "Lcom/bytedance/ee/bear/bitable/card/view/table/EmptyCoverView;", "setSrcObjToken", "", "srcObjToken", "", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardCoverView extends FrameLayout implements b<CardCoverData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttachmentCoverView f213290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CardEmptyCoverView f213291b;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), d.a(6));
        }
    }

    public CardCoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setSrcObjToken(String r100) {
        this.f213290a.setSrcObjToken(r100);
    }

    public CardCoverView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        AttachmentCoverView r102 = new AttachmentCoverView(r100, null, 6, 0);
        this.f213290a = r102;
        CardEmptyCoverView r103 = new CardEmptyCoverView(r100, null, 6, 0);
        this.f213291b = r103;
        addView(r102, -1, -1);
        addView(r103, -1, -1);
        setOutlineProvider(new a());
        setClipToOutline(true);
        int r104 = n.d(104);
        m.f(this, r104);
        m.e(this, r104);
    }
}
