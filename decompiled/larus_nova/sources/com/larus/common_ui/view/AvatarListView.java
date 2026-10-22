package com.larus.common_ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/common_ui/view/AvatarListView;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarSize", "overlapping", "avatar1", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatar2", "getAvatarList", "", "createAvatarViewWithBorder", "index", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarListView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f328127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f328129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f328130d;

    public final List<SimpleDraweeView> getAvatarList() {
        return CollectionsKt.listOf(new SimpleDraweeView[]{this.f328129c, this.f328130d});
    }

    public AvatarListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final SimpleDraweeView a(int r100) {
        SimpleDraweeView r101 = new SimpleDraweeView(getContext());
        GenericDraweeHierarchyBuilder r102 = new GenericDraweeHierarchyBuilder(r101.getContext().getResources()).setRoundingParams(RoundingParams.fromCornersRadius(0.0f).setRoundAsCircle(true)).setPlaceholderImage(R.drawable.larus_common_ui_avatar_placeholder);
        ScalingUtils.ScaleType r103 = ScalingUtils.ScaleType.CENTER_CROP;
        r101.setHierarchy(r102.setPlaceholderImageScaleType(r103).setActualImageScaleType(r103).build());
        if (r100 == 0) goto L5;
        FrameLayout r104 = new FrameLayout(getContext());
        int r105 = v19.c.b(R.attr.larus_base_1, r104.getContext(), R.color.larus_base_1);
        int r106 = v19.c.b(R.attr.larus_press, r104.getContext(), R.color.larus_press);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        int r107 = ContextCompat.getColor(r104.getContext(), r105);
        int r108 = ContextCompat.getColor(r104.getContext(), r106);
        GradientDrawable r109 = new GradientDrawable();
        r109.setShape(1);
        r109.setColor(r107);
        GradientDrawable r110 = new GradientDrawable();
        r110.setShape(1);
        r110.setColor(r108);
        StateListDrawable r111 = new StateListDrawable();
        r111.addState(new int[]{android.R.attr.state_pressed}, r110);
        r111.addState(new int[0], r109);
        r104.setBackground(r111);
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, -1);
        int r113 = this.f328128b;
        r112.setMargins(r113, r113, r113, r113);
        r112.gravity = 17;
        r104.addView(r101, r112);
        int r114 = this.f328127a + (this.f328128b * 2);
        RelativeLayout.LayoutParams r115 = new RelativeLayout.LayoutParams(r114, r114);
        r115.addRule(21, 1);
        r115.addRule(12, 1);
        int r116 = this.f328128b;
        r115.setMargins(0, 0, -r116, -r116);
        addView(r104, r115);
    L6:
        return r101;
    L5:
        int r117 = this.f328127a;
        addView(r101, new RelativeLayout.LayoutParams(r117, r117));
        goto L6
    }

    public AvatarListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public AvatarListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_avatar_size, R.attr.larus_overlapping});
        this.f328127a = (int) r103.getDimension(0, c7.c(46));
        this.f328128b = (int) r103.getDimension(1, c7.c(3));
        r103.recycle();
        this.f328129c = a(0);
        this.f328130d = a(1);
    }
}
