package com.bytedance.ee.bear.bitable.itemview.record.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitablePageCellFoldLayoutBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HiddenFieldInfoItem;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/HiddenInfoData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitablePageCellFoldLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitablePageCellFoldLayoutBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiddenFieldInfoItem extends FrameLayout implements gv4.b<HiddenInfoData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitablePageCellFoldLayoutBinding f214090a;

    public final BitablePageCellFoldLayoutBinding getBinding() {
        return this.f214090a;
    }

    public HiddenFieldInfoItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public HiddenFieldInfoItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_page_cell_fold_layout, this, false);
        addView(r102);
        int r103 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r104 == null) goto L11;
        r103 = R.id.fold_arrow_icon;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.fold_arrow_icon);
        if (r105 == null) goto L11;
        r103 = R.id.fold_title;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.fold_title);
        if (r106 == null) goto L11;
        this.f214090a = new BitablePageCellFoldLayoutBinding((LinearLayout) r102, r104, r105, r106);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
