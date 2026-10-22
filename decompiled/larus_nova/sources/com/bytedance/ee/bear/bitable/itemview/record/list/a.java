package com.bytedance.ee.bear.bitable.itemview.record.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewFoldLayoutBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends FrameLayout implements gv4.b<HiddenInfoData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f214129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableItemViewFoldLayoutBinding f214130b;

    public final BitableItemViewFoldLayoutBinding getBinding() {
        return this.f214130b;
    }

    public a(boolean r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        this.f214129a = r100;
        View r102 = LayoutInflater.from(r101).inflate(R.layout.bitable_item_view_fold_layout, this, false);
        addView(r102);
        int r103 = R.id.fold_arrow_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.fold_arrow_icon);
        if (r104 == null) goto L13;
        r103 = R.id.fold_desc_icon;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.fold_desc_icon);
        if (r105 == null) goto L13;
        r103 = R.id.fold_icon;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.fold_icon);
        if (r106 == null) goto L13;
        r103 = R.id.fold_title;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.fold_title);
        if (r107 == null) goto L13;
        this.f214130b = new BitableItemViewFoldLayoutBinding((LinearLayout) r102, r104, r105, r106, r107);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
