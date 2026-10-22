package com.larksuite.component.universe_design.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.tab.databinding.UdTabItemLayoutBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f285307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f285308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f285309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f285310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UdTabItemLayoutBinding f285311e;

    @Override // com.larksuite.component.universe_design.tab.a
    public int getContentViewLeft() {
        ImageView r100 = this.f285311e.f285303b;
        if (r100.getVisibility() != 0) goto L7;
        int r101 = r100.getLeft();
        int r102 = getLeft();
    L6:
        return r101 + r102;
    L7:
        FrameLayout r103 = this.f285311e.f285304c;
        if (r103.getVisibility() != 0) goto L10;
        r101 = r103.getLeft();
        r102 = getLeft();
        goto L6
    L10:
        return 0;
    }

    @Override // com.larksuite.component.universe_design.tab.a
    public int getContentViewRight() {
        FrameLayout r100 = this.f285311e.f285304c;
        if (r100.getVisibility() != 0) goto L7;
        int r101 = r100.getRight();
        int r102 = getLeft();
    L6:
        return r101 + r102;
    L7:
        ImageView r103 = this.f285311e.f285303b;
        if (r103.getVisibility() != 0) goto L10;
        r101 = r103.getRight();
        r102 = getLeft();
        goto L6
    L10:
        return 0;
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean r100 = super.performClick();
        b r101 = this.f285307a;
        if (r101 == null) goto L9;
        UDTabLayout r102 = r101.f285293b;
        if (r102 == null) goto L7;
        r102.selectTab(r101);
    L7:
        return true;
    L9:
        return r100;
    }

    public final int getMaxWidth$universe_ui_tab_release() {
        return this.f285308b;
    }

    public final int getMultiLineTitleTextSize$universe_ui_tab_release() {
        return this.f285309c;
    }

    public final float getSingleLineTitleTextSize$universe_ui_tab_release() {
        return this.f285310d;
    }

    public final b getTab$universe_ui_tab_release() {
        return this.f285307a;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f285308b = -1;
        this.f285309c = -1;
        this.f285310d = -1.0f;
        LayoutInflater.from(r100).inflate(R.layout.ud_tab_item_layout, this);
        int r101 = R.id.ud_tab_icon;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(this, R.id.ud_tab_icon);
        if (r102 == null) goto L16;
        r101 = R.id.ud_tab_title;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.ud_tab_title)) == null) goto L16;
        r101 = R.id.ud_tab_title_bold;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.ud_tab_title_bold)) == null) goto L16;
        r101 = R.id.ud_tab_title_warpper;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.ud_tab_title_warpper);
        if (r103 == null) goto L16;
        this.f285311e = new UdTabItemLayoutBinding(this, r102, r103);
        float r104 = r100.getResources().getConfiguration().fontScale;
        if (r104 > 0.0f) goto L13;
        r104 = 1.0f;
    L13:
        setLayoutParams(new LinearLayout.LayoutParams(-2, MathKt.roundToInt(h18.d.d(r100, R.dimen.ud_tabs_height) * r104)));
        setGravity(17);
        setOrientation(0);
        setClickable(true);
        setFocusable(true);
        return;
    L16:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }

    public final void setMaxWidth$universe_ui_tab_release(int r100) {
        this.f285308b = r100;
    }

    public final void setMultiLineTitleTextSize$universe_ui_tab_release(int r100) {
        this.f285309c = r100;
    }

    public final void setSingleLineTitleTextSize$universe_ui_tab_release(float r100) {
        this.f285310d = r100;
    }

    public final void setTab$universe_ui_tab_release(b r100) {
        this.f285307a = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f285308b <= 0) goto L12;
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getMode(r100);
        if (r103 != 0) goto L7;
        int r104 = View.MeasureSpec.makeMeasureSpec(this.f285308b, Integer.MIN_VALUE);
    L13:
        super.onMeasure(r104, r101);
        b r105 = this.f285307a;
        if (r105 != null) goto L16;
        return;
    L16:
        TextView r106 = r105.a();
        if (r106 != null) goto L19;
        return;
    L19:
        boolean r107 = true;
        if (r106.getLineCount() > 1) goto L22;
        float r108 = r106.getTextSize();
        float r109 = this.f285310d;
        if (r108 != r109) goto L32;
        boolean r110 = true;
    L33:
        if (r110 == true) goto L48;
        r106.setTextSize(0, r109);
        super.onMeasure(r100, r101);
        if (r106.getLineCount() > 1) goto L37;
        return;
    L37:
        if (this.f285309c <= 0) goto L50;
        float r111 = r106.getTextSize();
        int r112 = this.f285309c;
        if (r111 == r112) goto L42;
        r107 = false;
    L42:
        if (r107 == true) goto L51;
        r106.setTextSize(0, r112);
        super.onMeasure(r100, r101);
        return;
    L51:
        return;
    L50:
        return;
    L48:
        return;
    L32:
        r110 = false;
        goto L33
    L22:
        if (this.f285309c <= 0) goto L45;
        float r113 = r106.getTextSize();
        int r114 = this.f285309c;
        if (r113 == r114) goto L27;
        r107 = false;
    L27:
        if (r107 == true) goto L46;
        r106.setTextSize(0, r114);
        super.onMeasure(r100, r101);
        return;
    L46:
        return;
    L45:
        return;
    L7:
        int r115 = this.f285308b;
        if (r102 <= r115) goto L12;
        if (r103 == 1073741824) goto L12;
        r104 = View.MeasureSpec.makeMeasureSpec(r115, Integer.MIN_VALUE);
    L12:
        r104 = r100;
        goto L13
    }
}
