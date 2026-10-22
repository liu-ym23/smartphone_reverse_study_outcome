package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewHeaderBackgroundBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordHeaderBackground;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewHeaderBackgroundBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewHeaderBackgroundBinding;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordHeaderBackground extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewHeaderBackgroundBinding f214024a;

    public final BitableItemViewHeaderBackgroundBinding getBinding() {
        return this.f214024a;
    }

    public ItemViewRecordHeaderBackground(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public ItemViewRecordHeaderBackground(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.bitable_item_view_header_background, this);
        int r102 = R.id.record_page_view_header_left_bg;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.record_page_view_header_left_bg)) == null) goto L9;
        r102 = R.id.record_page_view_header_right_bg;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.record_page_view_header_right_bg)) == null) goto L9;
        this.f214024a = new BitableItemViewHeaderBackgroundBinding(this);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
