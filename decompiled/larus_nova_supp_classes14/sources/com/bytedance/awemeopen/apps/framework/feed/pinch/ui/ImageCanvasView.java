package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/ImageCanvasView;", "Landroid/view/View;", "a", "Landroid/view/View;", "getImageView", "()Landroid/view/View;", "setImageView", "(Landroid/view/View;)V", "imageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ImageCanvasView extends View {
    public View a;

    public ImageCanvasView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageCanvasView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final View getImageView() {
        return this.a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        r6.save();
        int r0 = getWidth();
        View r1 = this.a;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.getWidth();
    L6:
        float r4 = r0 - r3;
        float r5 = 2;
        float r7 = r4 / r5;
        int r8 = getHeight();
        View r9 = this.a;
        if (r9 == null) goto L9;
        r2 = r9.getHeight();
    L9:
        r6.translate(r7, (r8 - r2) / r5);
        View r10 = this.a;
        if (r10 == null) goto L12;
        r10.draw(r6);
    L12:
        r6.restore();
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void setImageView(View r1) {
        this.a = r1;
    }

    public ImageCanvasView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
    }

    public /* synthetic */ ImageCanvasView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
