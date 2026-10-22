package com.larus.community.impl.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.larus.community.impl.databinding.LarusCommunitySegmentedControlItemViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0011\u001a\u00020\u000f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/community/impl/share/CreationShareSegmentedControlView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "singleImageControlView", "Lcom/larus/community/impl/share/CreationShareSegmentedControlItemView;", "puzzleImageControlView", "onSelectionChanged", "Lkotlin/Function1;", "", "setupViews", "setOnSelectionChangedListener", "listener", "setSelectedPosition", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationShareSegmentedControlView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CreationShareSegmentedControlItemView f329789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CreationShareSegmentedControlItemView f329790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f329791c;

    public CreationShareSegmentedControlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationShareSegmentedControlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnSelectionChangedListener(Function1<? super Integer, Unit> r100) {
        this.f329791c = r100;
    }

    public final void setSelectedPosition(int r100) {
        Function1<? super Integer, Unit> r101 = this.f329791c;
        if (r101 == null) goto L6;
        r101.invoke(Integer.valueOf(r100));
    L6:
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L13;
        this.f329789a.setSelected(false);
        this.f329790b.setSelected(true);
        return;
    L13:
        return;
    L10:
        this.f329789a.setSelected(true);
        this.f329790b.setSelected(false);
    }

    public CreationShareSegmentedControlView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_segmented_control_container, this, true);
        CreationShareSegmentedControlItemView r103 = (CreationShareSegmentedControlItemView) findViewById(R.id.single_image_control);
        this.f329789a = r103;
        CreationShareSegmentedControlItemView r104 = (CreationShareSegmentedControlItemView) findViewById(R.id.puzzle_image_control);
        this.f329790b = r104;
        LarusCommunitySegmentedControlItemViewBinding r105 = r103.f329788b;
        if (r105 == null) goto L5;
        r105.f329147b.setImageResource(R.drawable.larus_community_single_share_icon);
        r105.f329148c.setText(R.string.larus_shareModal_option_btn_image);
    L5:
        LarusCommunitySegmentedControlItemViewBinding r106 = r104.f329788b;
        if (r106 == null) goto L8;
        r106.f329147b.setImageResource(R.drawable.larus_community_puzzle_share_icon);
        r106.f329148c.setText(R.string.larus_shareModal_option_btn_collage);
    L8:
        setPadding(0, i5.h(), 0, i5.h());
        r103.setSelected(true);
        r104.setSelected(false);
        r103.setOnClickListener(new k(this));
        r104.setOnClickListener(new l(this));
    }

    public /* synthetic */ CreationShareSegmentedControlView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
