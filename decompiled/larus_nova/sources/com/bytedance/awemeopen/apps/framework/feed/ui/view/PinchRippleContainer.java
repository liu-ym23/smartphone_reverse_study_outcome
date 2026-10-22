package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchRippleContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f196824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f196825b;

    public static final class a {
    }

    static {
    }

    public PinchRippleContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinchRippleContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        if (this.f196825b != 0) goto L5;
        Path r100 = this.f196824a;
        r100.lineTo(getWidth() * 0.56f, 0.0f);
        r100.quadTo(getWidth(), getHeight() * 0.21f, getWidth(), getHeight() * 0.5f);
        r100.quadTo(getWidth(), getHeight() * 0.78f, getWidth() * 0.56f, getHeight());
        r100.lineTo(0.0f, getHeight());
        r100.lineTo(0.0f, 0.0f);
    L6:
        if (r110 == null) goto L9;
        r110.clipPath(this.f196824a);
        return;
    L9:
        return;
    L5:
        Path r101 = this.f196824a;
        r101.moveTo(getWidth() * 0.44f, 0.0f);
        r101.quadTo(0.0f, getHeight() * 0.21f, 0.0f, getHeight() * 0.5f);
        r101.quadTo(0.0f, getHeight() * 0.78f, getWidth() * 0.44f, getHeight());
        r101.lineTo(getWidth(), getHeight());
        r101.lineTo(getWidth(), 0.0f);
        r101.lineTo(getWidth() * 0.44f, 0.0f);
        goto L6
    }

    public PinchRippleContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f196824a = new Path();
        setWillNotDraw(false);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.aos_direction});
        this.f196825b = r103.getInt(0, 0);
        r103.recycle();
    }

    public /* synthetic */ PinchRippleContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
