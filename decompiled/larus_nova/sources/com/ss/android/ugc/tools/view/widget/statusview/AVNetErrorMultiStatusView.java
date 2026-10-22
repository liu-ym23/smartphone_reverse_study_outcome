package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.net.NetworkState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/statusview/AVNetErrorMultiStatusView;", "Lcom/ss/android/ugc/tools/view/widget/statusview/AbsAVNetErrorStatusView;", "", "rate", "", "setVerticalAlign", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class AVNetErrorMultiStatusView extends AbsAVNetErrorStatusView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f455177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f455178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Space f455179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Space f455180g;

    public AVNetErrorMultiStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AVNetErrorMultiStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.ugc.tools.view.widget.statusview.AbsAVNetErrorStatusView
    public final void a() {
        Context r100 = getContext();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.ugc.tools.net.a r101 = com.ss.android.ugc.tools.net.b.f454841a;
        com.ss.android.ugc.tools.net.a r102 = com.ss.android.ugc.tools.net.b.f454841a;
        r102.getClass();
        r102.getClass();
        NetworkState r103 = NetworkState.UNKNOWN;
        int r104 = com.ss.android.ugc.tools.net.c.f454842a[r103.ordinal()];
        if (r104 != 1) goto L5;
        Pair r105 = TuplesKt.to(Integer.valueOf(R.string.connection_error_retry), Integer.valueOf(R.string.connection_airplanepage_desc));
    L9:
        int r106 = ((Number) r105.component1()).intValue();
        int r107 = ((Number) r105.component2()).intValue();
        Pair r108 = TuplesKt.to(r100.getString(r106), r100.getString(r107));
        String r109 = (String) r108.component1();
        String r110 = (String) r108.component2();
        this.f455177d.setText(r109);
        this.f455178e.setText(r110);
        return;
    L5:
        if (r104 == 2) goto L7;
        r105 = TuplesKt.to(Integer.valueOf(R.string.optimize_creationpath_desc_unstable), Integer.valueOf(R.string.optimize_creationpath_desc_networktry));
        goto L9
    L7:
        r105 = TuplesKt.to(Integer.valueOf(R.string.connection_error_retry), Integer.valueOf(R.string.optimize_creationpath_desc_internet));
        goto L9
    }

    public final void setVerticalAlign(float r100) {
        ViewGroup.LayoutParams r101 = this.f455179f.getLayoutParams();
        ViewGroup.LayoutParams r102 = null;
        if ((r101 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r101 = null;
    L5:
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r101;
        if (r103 == null) goto L8;
        r103.weight = 1.0f;
    L8:
        ViewGroup.LayoutParams r104 = this.f455180g.getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L12;
        r102 = r104;
    L12:
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r102;
        if (r105 == null) goto L15;
        r105.weight = r100;
    L15:
        requestLayout();
    }

    public AVNetErrorMultiStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.tools_layout_network_err_view_multi, this, true);
        this.f455177d = (TextView) findViewById(R.id.tv_panel_error_title);
        this.f455178e = (TextView) findViewById(R.id.tv_panel_error_subtitle);
        this.f455179f = (Space) findViewById(R.id.space_top);
        this.f455180g = (Space) findViewById(R.id.space_bottom);
    }

    public /* synthetic */ AVNetErrorMultiStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
