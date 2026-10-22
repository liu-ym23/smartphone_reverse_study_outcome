package com.bytedance.awemeopen.apps.framework.base.view.digg;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/digg/DiggAnimationLayout;", "Landroid/widget/FrameLayout;", "", "selected", "", "setSelected", "", "b", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "type", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiggAnimationLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, View> f193238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f193239b;

    public static final class a {
    }

    static {
    }

    public DiggAnimationLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DiggAnimationLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final String getType() {
        String r100 = this.f193239b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return "common";
    L13:
        return this.f193239b;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void a(String r100) {
        DiggAnimationView r101 = new DiggAnimationView(getContext());
        Resources r102 = Resources.getSystem();
        int r103 = MathKt.roundToInt(TypedValue.applyDimension(1, 36, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r103, r103);
        r104.gravity = 17;
        r101.setLayoutParams(r104);
        r101.setFocusableInTouchMode(false);
        r101.setFocusable(false);
        r101.setImportantForAccessibility(2);
        r101.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r101.setImageDrawable(ContextCompat.getDrawable(r101.getContext(), R.drawable.aos_feed_item_icon_digg));
        addView(r101);
        this.f193238a.put(r100, r101);
    }

    @Override // android.view.View
    public void setSelected(boolean r100) {
        super.setSelected(r100);
        View r101 = this.f193238a.get(getType());
        if (r101 == null) goto L7;
        r101.setSelected(r100);
        return;
    }

    public final void setType(String r100) {
        this.f193239b = r100;
    }

    public DiggAnimationLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f193238a = new HashMap();
        this.f193239b = "common";
        a("common");
    }

    public /* synthetic */ DiggAnimationLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
