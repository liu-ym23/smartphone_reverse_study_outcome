package com.ss.android.ugc.tools.view.widget.statusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.tools.net.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/statusview/AVNetErrorSingleStatusView;", "Lcom/ss/android/ugc/tools/view/widget/statusview/AbsAVNetErrorStatusView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class AVNetErrorSingleStatusView extends AbsAVNetErrorStatusView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f455181d;

    public AVNetErrorSingleStatusView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AVNetErrorSingleStatusView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.ss.android.ugc.tools.view.widget.statusview.AbsAVNetErrorStatusView
    public final void a() {
        TextView r100 = this.f455181d;
        Context r101 = getContext();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.ugc.tools.net.a r102 = com.ss.android.ugc.tools.net.b.f454841a;
        com.ss.android.ugc.tools.net.a r103 = com.ss.android.ugc.tools.net.b.f454841a;
        r103.getClass();
        r103.getClass();
        NetworkState r104 = NetworkState.UNKNOWN;
        int r105 = com.ss.android.ugc.tools.net.c.f454843b[r104.ordinal()];
        if (r105 != 1) goto L5;
        int r106 = R.string.connection_error_retry;
    L9:
        r100.setText(r101.getString(r106));
        return;
    L5:
        if (r105 == 2) goto L7;
        r106 = R.string.connection_toast_unstable_tryagain;
        goto L9
    L7:
        r106 = R.string.connection_cantconnect;
        goto L9
    }

    public AVNetErrorSingleStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.tools_layout_network_err_view_single, this, true);
        this.f455181d = (TextView) findViewById(R.id.tv_panel_error_title);
    }

    public /* synthetic */ AVNetErrorSingleStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
