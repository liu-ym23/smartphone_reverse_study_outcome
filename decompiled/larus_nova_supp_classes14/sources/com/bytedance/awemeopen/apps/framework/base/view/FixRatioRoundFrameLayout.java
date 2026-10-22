package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/FixRatioRoundFrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/base/view/FixedRatioFrameLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FixRatioRoundFrameLayout extends FixedRatioFrameLayout {
    public final a c;
    public float d;

    public static final class a extends ViewOutlineProvider {
        public float a;

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), Math.min((Math.min(r8.getWidth(), r8.getHeight()) / 2) + 1, this.a));
        }
    }

    public FixRatioRoundFrameLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FixRatioRoundFrameLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setRadius(float r3) {
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        if (this.d != r3) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L18;
        this.d = r3;
        if (getClipToOutline() == true) goto L12;
        setClipToOutline(true);
    L12:
        a r1 = this.c;
        if (r1 == null) goto L15;
        r1.a = r3;
    L15:
        setOutlineProvider(r1);
        return;
    L18:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public FixRatioRoundFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.c = new a();
    }

    public /* synthetic */ FixRatioRoundFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
