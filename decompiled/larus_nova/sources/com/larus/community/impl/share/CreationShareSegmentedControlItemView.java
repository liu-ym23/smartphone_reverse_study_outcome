package com.larus.community.impl.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.databinding.LarusCommunitySegmentedControlItemViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/community/impl/share/CreationShareSegmentedControlItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunitySegmentedControlItemViewBinding;", "bindData", "", "icoResId", "textResId", "setSelected", "selected", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationShareSegmentedControlItemView extends RoundLinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusCommunitySegmentedControlItemViewBinding f329788b;

    public CreationShareSegmentedControlItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationShareSegmentedControlItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        c29.a r101 = getDelegate();
        if (r100 == false) goto L5;
        int r102 = ContextCompat.getColor(getContext(), R.color.larus_base_4);
    L6:
        r101.a(r102);
        LarusCommunitySegmentedControlItemViewBinding r103 = this.f329788b;
        if (r103 == null) goto L18;
        AppCompatImageView r104 = r103.f329147b;
        Context r105 = getContext();
        boolean r106 = isSelected();
        int r107 = R.color.larus_neutral_100;
        if (r106 == false) goto L11;
        int r108 = R.color.larus_neutral_100;
    L12:
        r104.setImageTintList(ContextCompat.getColorStateList(r105, r108));
        AppCompatTextView r109 = r103.f329148c;
        Context r110 = getContext();
        if (isSelected() == true) goto L16;
        r107 = R.color.larus_neutral_50;
    L16:
        r109.setTextColor(ContextCompat.getColorStateList(r110, r107));
        return;
    L11:
        r108 = R.color.larus_neutral_50;
        goto L12
    L18:
        return;
    L5:
        r102 = ContextCompat.getColor(getContext(), android.R.color.transparent);
        goto L6
    }

    public CreationShareSegmentedControlItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_segmented_control_item_view, this);
        int r103 = R.id.iv_icon;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_icon);
        if (r104 == null) goto L9;
        r103 = R.id.tv_title;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.tv_title);
        if (r105 == null) goto L9;
        this.f329788b = new LarusCommunitySegmentedControlItemViewBinding(this, r104, r105);
        getDelegate().d(6);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ CreationShareSegmentedControlItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
