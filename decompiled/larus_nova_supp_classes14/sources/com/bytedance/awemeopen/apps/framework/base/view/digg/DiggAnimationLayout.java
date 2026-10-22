package com.bytedance.awemeopen.apps.framework.base.view.digg;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/digg/DiggAnimationLayout;", "Landroid/widget/FrameLayout;", "", "selected", "", "setSelected", "", "b", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "type", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiggAnimationLayout extends FrameLayout {
    public final HashMap<String, View> a;
    public String b;

    public static final class a {
    }

    static {
    }

    public DiggAnimationLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DiggAnimationLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final String getType() {
        String r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return "common";
    L13:
        return this.b;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(String r5) {
        AppCompatImageView r0 = new DiggAnimationView(getContext());
        Resources r2 = Resources.getSystem();
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 36, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r1, r1);
        r3.gravity = 17;
        r0.setLayoutParams(r3);
        r0.setFocusableInTouchMode(false);
        r0.setFocusable(false);
        r0.setImportantForAccessibility(2);
        r0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r0.setImageDrawable(ContextCompat.getDrawable(r0.getContext(), 2131231458));
        addView(r0);
        this.a.put(r5, (View) r0);
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        View r0 = this.a.get(getType());
        if (r0 == null) goto L7;
        r0.setSelected(r3);
        return;
    }

    public final void setType(String r1) {
        this.b = r1;
    }

    public DiggAnimationLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = new HashMap();
        this.b = "common";
        a("common");
    }

    public /* synthetic */ DiggAnimationLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
