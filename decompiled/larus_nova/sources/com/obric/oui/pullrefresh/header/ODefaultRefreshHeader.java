package com.obric.oui.pullrefresh.header;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.RefreshState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/pullrefresh/header/ODefaultRefreshHeader;", "Landroid/widget/FrameLayout;", "Ljma/a;", "Landroid/view/View;", "getView", "", "color", "", "setTextColor", "Landroid/content/res/ColorStateList;", "colors", "setIconColor", "setProgressBackgroundColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ODefaultRefreshHeader extends FrameLayout implements jma.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f402576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f402577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ODownloadProgressView f402578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f402579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f402580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f402581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f402582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f402583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f402584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f402585j;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f402586a = null;

        static {
            int[] r100 = new int[RefreshState.values().length];
            r100[RefreshState.PULL_TO_REFRESH.ordinal()] = 1;
            r100[RefreshState.IDLE.ordinal()] = 2;
            r100[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            r100[RefreshState.REFRESHING.ordinal()] = 4;
            r100[RefreshState.FINISH.ordinal()] = 5;
            f402586a = r100;
        }
    }

    @Override // jma.a
    public View getView() {
        return this;
    }

    public ODefaultRefreshHeader(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // jma.a
    public final void b(OPullRefreshLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        ObjectAnimator r101 = this.f402585j;
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        this.f402576a.setRotation(0.0f);
        this.f402584i = false;
    }

    public final void setIconColor(int r100) {
        this.f402578c.setProcessingColor(r100);
        this.f402576a.setColorFilter(r100);
        this.f402577b.setColorFilter(r100);
    }

    public final void setProgressBackgroundColor(int r100) {
        this.f402578c.setProgressBackgroundColor(r100);
    }

    public final void setTextColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f402579d.setTextColor(r100);
    }

    public final void setTextColor(int r100) {
        this.f402579d.setTextColor(r100);
    }

    public ODefaultRefreshHeader(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f402580e = r100.getString(R.string.oui_pull_to_refresh);
        this.f402581f = r100.getString(R.string.oui_release_to_refresh);
        this.f402582g = r100.getString(R.string.oui_refreshing);
        this.f402583h = r100.getString(R.string.oui_refresh_success);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(r100).inflate(R.layout.o_pullrefresh_default_header, this, true);
        this.f402576a = (ImageView) findViewById(R.id.pr_iv_arrow);
        this.f402577b = (ImageView) findViewById(R.id.pr_iv_success);
        this.f402578c = (ODownloadProgressView) findViewById(R.id.pr_progress);
        this.f402579d = (TextView) findViewById(R.id.pr_tv_title);
        setAlpha(0.0f);
    }

    @Override // jma.a
    public final void c(OPullRefreshLayout r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        setAlpha(RangesKt.coerceIn(r101, 0.0f, 1.0f));
        if (r100.getState() != RefreshState.IDLE) goto L5;
    L6:
        this.f402579d.setText(this.f402580e);
        this.f402578c.setVisibility(8);
        this.f402577b.setVisibility(8);
        this.f402576a.setVisibility(0);
        if (this.f402584i == false) goto L11;
        this.f402576a.setRotation(0.0f);
        this.f402584i = false;
        return;
    L11:
        return;
    L5:
        if (r100.getState() == RefreshState.PULL_TO_REFRESH) goto L6;
    }

    public final void d(boolean r100, boolean r101) {
        if (this.f402584i != r100) goto L5;
        return;
    L5:
        ObjectAnimator r102 = this.f402585j;
        if (r102 == null) goto L9;
        r102.cancel();
    L9:
        float r103 = 0.0f;
        if (r100 == false) goto L12;
        float r104 = 0.0f;
    L13:
        if (r100 == false) goto L15;
        r103 = 180.0f;
    L15:
        if (r101 == false) goto L17;
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f402576a, View.ROTATION, new float[]{r104, r103});
        r105.setDuration(200);
        r105.setInterpolator(new DecelerateInterpolator());
        r105.start();
        this.f402585j = r105;
    L18:
        this.f402584i = r100;
        return;
    L17:
        this.f402576a.setRotation(r103);
        goto L18
    L12:
        r104 = 180.0f;
        goto L13
    }

    @Override // jma.a
    public final void a(OPullRefreshLayout r100, RefreshState r101, RefreshState r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        Intrinsics.checkNotNullParameter(r101, "oldState");
        Intrinsics.checkNotNullParameter(r102, "newState");
        int r103 = a.f402586a[r102.ordinal()];
        boolean r104 = true;
        boolean r105 = false;
        if (r103 != 1) goto L5;
    L19:
        this.f402579d.setText(this.f402580e);
        this.f402578c.setVisibility(8);
        this.f402577b.setVisibility(8);
        this.f402576a.setVisibility(0);
        if (r101 == RefreshState.RELEASE_TO_REFRESH) goto L23;
        r104 = false;
    L23:
        d(false, r104);
        return;
    L5:
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L9;
        this.f402579d.setText(this.f402581f);
        this.f402578c.setVisibility(8);
        this.f402577b.setVisibility(8);
        this.f402576a.setVisibility(0);
        if (r101 != RefreshState.PULL_TO_REFRESH) goto L18;
        r105 = true;
    L18:
        d(true, r105);
        return;
    L9:
        if (r103 != 4) goto L11;
        this.f402579d.setText(this.f402582g);
        this.f402577b.setVisibility(8);
        this.f402576a.setVisibility(8);
        this.f402578c.setVisibility(0);
        setAlpha(1.0f);
        return;
    L11:
        if (r103 != 5) goto L28;
        this.f402579d.setText(this.f402583h);
        this.f402576a.setVisibility(8);
        this.f402578c.setVisibility(8);
        this.f402577b.setVisibility(0);
        setAlpha(1.0f);
        return;
    }
}
