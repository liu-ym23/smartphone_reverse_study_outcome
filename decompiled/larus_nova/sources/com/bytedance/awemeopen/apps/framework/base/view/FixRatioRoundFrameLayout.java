package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/FixRatioRoundFrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/base/view/FixedRatioFrameLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class FixRatioRoundFrameLayout extends FixedRatioFrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f193154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f193155d;

    public static final class a extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f193156a;

        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), Math.min((Math.min(r100.getWidth(), r100.getHeight()) / 2) + 1, this.f193156a));
        }
    }

    public FixRatioRoundFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FixRatioRoundFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setRadius(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (this.f193155d != r100) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L18;
        this.f193155d = r100;
        if (getClipToOutline() == true) goto L12;
        setClipToOutline(true);
    L12:
        a r102 = this.f193154c;
        if (r102 == null) goto L15;
        r102.f193156a = r100;
    L15:
        setOutlineProvider(r102);
        return;
    L18:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public FixRatioRoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f193154c = new a();
    }

    public /* synthetic */ FixRatioRoundFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
