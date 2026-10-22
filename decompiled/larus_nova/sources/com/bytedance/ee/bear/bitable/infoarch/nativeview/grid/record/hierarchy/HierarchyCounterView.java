package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.hierarchy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableGridUikitHierarchyCounterLayoutBinding;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/record/hierarchy/HierarchyCounterView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableGridUikitHierarchyCounterLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableGridUikitHierarchyCounterLayoutBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HierarchyCounterView extends LinearLayout implements b<SimpleItemModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableGridUikitHierarchyCounterLayoutBinding f213613a;

    public final BitableGridUikitHierarchyCounterLayoutBinding getBinding() {
        return this.f213613a;
    }

    public HierarchyCounterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public HierarchyCounterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(0);
        LayoutInflater.from(r100).inflate(R.layout.bitable_grid_uikit_hierarchy_counter_layout, this);
        int r102 = R.id.counter_num;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.counter_num);
        if (r103 == null) goto L9;
        r102 = R.id.desc_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.desc_icon)) == null) goto L9;
        this.f213613a = new BitableGridUikitHierarchyCounterLayoutBinding(this, r103);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
