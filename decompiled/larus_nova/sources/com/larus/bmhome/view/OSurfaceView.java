package com.larus.bmhome.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0014¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/OSurfaceView;", "Landroid/view/SurfaceView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onWindowVisibilityChanged", "", RemoteMessageConst.Notification.VISIBILITY, "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSurfaceView extends SurfaceView {
    public OSurfaceView(Context r100) {
        super(r100);
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        Context r101 = getContext();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) r101).isDestroyed() == true) goto L7;
        Context r102 = getContext();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.Activity");
        if (((Activity) r102).isFinishing() == true) goto L7;
        super.onWindowVisibilityChanged(r100);
        return;
    L7:
        if (r100 != 0) goto L11;
        super.onWindowVisibilityChanged(r100);
        return;
    }

    public OSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public OSurfaceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
