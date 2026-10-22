package com.ss.android.lark.watermark.v2;

import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.watermark.userscope.ToolsV3Kt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements q<Fragment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f445551a = null;

    static {
        f445551a = new i();
    }

    public i() {
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final void a(Fragment r100) {
        Fragment r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        View r102 = r101.getView();
        if (Build.VERSION.SDK_INT < 23) goto L11;
        p4c.d r103 = ToolsV3Kt.a();
        if (r103 == null) goto L7;
        boolean r104 = r103.fragmentBinderOpt();
    L8:
        if (r104 == false) goto L11;
        if (r102 == null) goto L21;
        r102.setForeground(null);
        return;
    L21:
        return;
    L7:
        r104 = true;
    L11:
        if (r102 == null) goto L35;
        if ((r102 instanceof FrameLayout) == true) goto L14;
        Object r105 = r102.getParent();
        if ((r105 instanceof View) == true) goto L19;
        r102 = null;
        goto L11
    L19:
        r102 = (View) r105;
        goto L11
    L14:
        FrameLayout r106 = (FrameLayout) r102;
        if (Intrinsics.areEqual(r106.getTag(), Integer.valueOf(R.id.watermark_foreground_tag)) == false) goto L11;
        r106.setForeground(null);
        r106.setTag(null);
        return;
    }

    @Override // com.ss.android.lark.watermark.v2.q
    public final boolean b(u r100, Fragment r101) {
        Fragment r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "drawable");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        View r103 = r102.getView();
        if (Build.VERSION.SDK_INT < 23) goto L11;
        p4c.d r104 = ToolsV3Kt.a();
        if (r104 == null) goto L7;
        boolean r105 = r104.fragmentBinderOpt();
    L8:
        if (r105 == false) goto L11;
        if (r103 == null) goto L29;
        r103.setForeground(r100);
        return true;
    L29:
        return true;
    L7:
        r105 = true;
    L11:
        if (r103 == null) goto L19;
        if ((r103 instanceof FrameLayout) == true) goto L14;
        Object r106 = r103.getParent();
        if ((r106 instanceof View) == true) goto L17;
        r103 = null;
        goto L11
    L17:
        r103 = (View) r106;
        goto L11
    L14:
        FrameLayout r107 = (FrameLayout) r103;
        r107.setForegroundGravity(119);
        r107.setForeground(r100);
        r107.setTag(Integer.valueOf(R.id.watermark_foreground_tag));
        return true;
    L19:
        return false;
    }
}
