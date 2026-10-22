package com.obric.oui.tab.optimize;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000b\u0017B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/tab/optimize/OBottomTabBar;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/tab/optimize/OBottomTabBar$b;", "listener", "", "setOnTabSelectedListener", "", "show", "setShowTopLine", "", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getSelectedIndex", "()I", "selectedIndex", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBottomTabBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f403227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f403228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f403229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f403230d;

    public static final class a {
    }

    public interface b {
    }

    public OBottomTabBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OBottomTabBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnTabSelectedListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    static {
        new ola.a();
    }

    public final int getSelectedIndex() {
        return this.f403227a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f403230d == false) goto L10;
        r100.save();
        r100.drawLine(0.0f, this.f403228b / 2.0f, getWidth(), this.f403228b, this.f403229c);
        r100.restore();
        return;
    }

    public final void setShowTopLine(boolean r100) {
        this.f403230d = r100;
        invalidate();
    }

    public OBottomTabBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403227a = -1;
        Paint r103 = new Paint();
        r103.setStyle(Paint.Style.FILL);
        r103.setColor(getResources().getColor(R.color.oui_line_2));
        this.f403229c = r103;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setPadding((int) getResources().getDimension(R.dimen.oui_p_container_2), d.l(this, 4.5d), (int) getResources().getDimension(R.dimen.oui_p_container_2), d.n(this, 2));
        float r104 = d.m(this, 0.6f);
        this.f403228b = r104;
        r103.setStrokeWidth(r104);
        setWillNotDraw(false);
        this.f403230d = true;
    }

    public /* synthetic */ OBottomTabBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
