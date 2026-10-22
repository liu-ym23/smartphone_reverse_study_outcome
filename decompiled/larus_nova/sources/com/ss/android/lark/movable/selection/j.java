package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f432800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDShadowLayout f432801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f432802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f432803e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Log.d("Movable_SelectionDialog", "dismiss");
        UDShadowLayout r100 = this.f432801c;
        if (r100 == null) goto L8;
        ViewGroup r101 = this.f432800b;
        if (r101 == null) goto L7;
        r101.removeView(r100);
    L7:
        this.f432801c = null;
    L8:
        k r102 = this.f432802d;
        if (r102 == null) goto L15;
        ViewGroup r103 = this.f432800b;
        if (r103 == null) goto L13;
        r103.removeView(r102);
    L13:
        this.f432802d = null;
        return;
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f432799a = r100;
        this.f432803e = new Rect(0, b(20), 0, 0);
    }

    public final int b(int r100) {
        return UIUtils.dp2px(this.f432799a, r100);
    }
}
