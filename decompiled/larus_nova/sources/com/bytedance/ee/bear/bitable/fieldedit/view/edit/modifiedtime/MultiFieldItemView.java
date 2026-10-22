package com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldSelectModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.e;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import iv4.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/modifiedtime/MultiFieldItemView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewCreator", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/FieldSelectCreator;", "uiKitView", "Landroid/view/View;", "emptyView", "setData", "", "data", "", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldSelectModel;", "applyParams", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiFieldItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f211492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutilCellLayout f211493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f211494c;

    public MultiFieldItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MultiFieldItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setData(List<FieldSelectModel> r100) {
        List<FieldSelectModel> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        m.z(this.f211494c, true);
        m.z(this.f211493b, false);
        return;
    L11:
        m.z(this.f211494c, false);
        m.z(this.f211493b, true);
        e r103 = this.f211492a;
        Integer r104 = Integer.valueOf(r100.size());
        MutilCellLayout r105 = r103.f216159b;
        if ((r105 instanceof MutilCellLayout) == true) goto L15;
        r105 = null;
    L15:
        if (r105 == null) goto L17;
        r105.setIdealChildCount(r104);
    L17:
        this.f211492a.g(CollectionsKt.take(r100, 10));
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public MultiFieldItemView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        b r102 = new b(false, 0.0f, 0, 0, 15);
        r102.f495938a = false;
        r102.f495939b = 14.0f;
        r102.f495940c = 1;
        r102.f495941d = R.color.text_title;
        e r103 = new e(r102);
        this.f211492a = r103;
        View r104 = r103.b(r100, this);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 != null) goto L5;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
    L6:
        r106.gravity = 16;
        m.z(r104, false);
        addView(r104);
        this.f211493b = (MutilCellLayout) r104;
        TextView r107 = new TextView(r100);
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 != null) goto L9;
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
    L10:
        r109.gravity = 16;
        m.z(r107, true);
        r107.setText(r100.getString(R.string.Bitable_Field_Select));
        r107.setTextSize(16.0f);
        r107.setPadding(d.a(8), 0, 0, 0);
        r107.setTextColor(ResourcesCompat.getColor(r100.getResources(), R.color.text_placeholder, r100.getTheme()));
        addView(r107);
        this.f211494c = r107;
        return;
    L9:
        r109 = new FrameLayout.LayoutParams(r108);
        goto L10
    L5:
        r106 = new FrameLayout.LayoutParams(r105);
        goto L6
    }

    public /* synthetic */ MultiFieldItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
