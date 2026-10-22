package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/view/PinchRippleContainer;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class PinchRippleContainer extends FrameLayout {
    public final Path a;
    public final int b;

    public static final class a {
    }

    static {
    }

    public PinchRippleContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinchRippleContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        if (this.b != 0) goto L5;
        Path r0 = this.a;
        r0.lineTo(getWidth() * 0.56f, 0.0f);
        r0.quadTo(getWidth(), getHeight() * 0.21f, getWidth(), getHeight() * 0.5f);
        r0.quadTo(getWidth(), getHeight() * 0.78f, getWidth() * 0.56f, getHeight());
        r0.lineTo(0.0f, getHeight());
        r0.lineTo(0.0f, 0.0f);
    L6:
        if (r10 == null) goto L9;
        r10.clipPath(this.a);
        return;
    L9:
        return;
    L5:
        Path r1 = this.a;
        r1.moveTo(getWidth() * 0.44f, 0.0f);
        r1.quadTo(0.0f, getHeight() * 0.21f, 0.0f, getHeight() * 0.5f);
        r1.quadTo(0.0f, getHeight() * 0.78f, getWidth() * 0.44f, getHeight());
        r1.lineTo(getWidth(), getHeight());
        r1.lineTo(getWidth(), 0.0f);
        r1.lineTo(getWidth() * 0.44f, 0.0f);
        goto L6
    }

    public PinchRippleContainer(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        new LinkedHashMap();
        super(r3, r4, r5);
        this.a = new Path();
        setWillNotDraw(false);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130968805});
        this.b = r6.getInt(0, 0);
        r6.recycle();
    }

    public /* synthetic */ PinchRippleContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
