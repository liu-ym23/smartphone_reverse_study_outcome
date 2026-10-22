package com.ss.android.lark.flow.feed.action;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView;
import com.ss.android.lark.feed.shared.page.swipe.SwipeActionTextHelper;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends BaseFeedSwipeActionView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f423200e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f423201f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f423202g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f423203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f423204d;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.feed.action.a$a, reason: collision with other inner class name */
    public static final class C4992a {
    }

    static {
        f423200e = UIHelper.dp2px(80.0f);
        f423201f = UIHelper.dp2px(8.0f);
        f423202g = UIHelper.dp2px(4.0f);
    }

    public final void c() {
        measure(View.MeasureSpec.makeMeasureSpec(f423200e, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView
    public CharSequence getActionName() {
        TextView r100 = this.f423204d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r100 = null;
    L6:
        return r100.getText();
    }

    @Override // com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView
    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_flow_feed_swipe_action, this, true);
        setOrientation(1);
        int r100 = f423202g;
        int r101 = f423201f;
        setPadding(r100, r101, r100, r101);
        setGravity(17);
        this.f423203c = (ImageView) findViewById(R.id.iv_icon);
        TextView r102 = (TextView) findViewById(R.id.tv_name);
        this.f423204d = r102;
        TextView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r102 = null;
    L5:
        r102.setMaxLines(2);
        TextView r104 = this.f423204d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
    L9:
        float r105 = SwipeActionTextHelper.f421451c;
        r103.setTextSize(1, SwipeActionTextHelper.f421451c);
        return;
    L8:
        r103 = r104;
        goto L9
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        new SwipeActionTextHelper();
    }

    @Override // com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView
    public void setOnlyShowText(boolean r100) {
        ImageView r101 = this.f423203c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 8;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(f423200e, 1073741824), r101);
    }

    @Override // com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView
    public final void a(Drawable r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r101, "text");
        super.a(r100, r101, r102);
        TextView r103 = this.f423204d;
        ImageView r104 = null;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r103 = null;
    L5:
        zz7.a.c(r103, 12);
        TextView r105 = this.f423204d;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("nameTextView");
        r105 = null;
    L8:
        r105.setText(r101);
        ImageView r106 = this.f423203c;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L12:
        r104.setBackground(r100);
        setBackgroundColor(r102);
        return;
    L11:
        r104 = r106;
        goto L12
    }
}
