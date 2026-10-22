package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/ClipLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ClipLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f194312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f194313b;

    public ClipLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ClipLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f194312a <= (-1)) goto L5;
        this.f194313b.reset();
        this.f194313b.addRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight() - this.f194312a, Path.Direction.CW);
        r100.clipPath(this.f194313b);
    L5:
        super.onDraw(r100);
    }

    public ClipLinearLayout(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f194312a = -1;
        if (getBackground() != null) goto L5;
        setBackgroundResource(R.drawable.legacy_transparent);
    L5:
        this.f194313b = new Path();
    }

    public /* synthetic */ ClipLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
