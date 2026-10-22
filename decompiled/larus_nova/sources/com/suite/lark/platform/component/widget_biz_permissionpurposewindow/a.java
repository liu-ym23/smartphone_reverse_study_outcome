package com.suite.lark.platform.component.widget_biz_permissionpurposewindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.k;
import com.ss.android.lark.utils.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import yoc.c;
import yoc.d;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f460924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f460925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f460926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f460927d;

    @Override // yoc.c
    public final void getPriority() {
    }

    @Override // yoc.c
    public int getType() {
        return R.id.permission_window;
    }

    @Override // yoc.c
    public final String getId() {
        return String.valueOf(getType());
    }

    @Override // yoc.d
    public final long getDisplayDuration() {
        return this.f460927d;
    }

    public a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "purpose");
        this.f460924a = r100;
        this.f460927d = TimeUnit.SECONDS.toMillis(60);
    }

    @Override // yoc.c
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TextView r101 = null;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.layout_permission_purpose_window, null);
        this.f460925b = (TextView) r102.findViewById(R.id.permission_window_title);
        this.f460926c = (TextView) r102.findViewById(R.id.permission_window_desc);
        boolean r103 = true;
        if (this.f460924a.h() == 0) goto L9;
        TextView r104 = this.f460925b;
        if (r104 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r104 = null;
    L7:
        r104.setText(this.f460924a.h());
    L18:
        if (this.f460924a.b() == 0) goto L25;
        TextView r105 = this.f460926c;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("descTextView");
    L23:
        r101.setText(this.f460924a.b());
    L34:
        Intrinsics.checkNotNull(r102);
        return r102;
    L22:
        r101 = r105;
        goto L23
    L25:
        if (this.f460924a.d().length() > 0) goto L28;
        r103 = false;
    L28:
        if (r103 == false) goto L34;
        TextView r106 = this.f460926c;
        if (r106 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("descTextView");
    L33:
        r101.setText(this.f460924a.d());
        goto L34
    L32:
        r101 = r106;
        goto L33
    L9:
        if (this.f460924a.g().length() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L18;
        TextView r108 = this.f460925b;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        r108 = null;
    L16:
        r108.setText(this.f460924a.g());
        goto L18
    L11:
        r107 = false;
        goto L12
    }
}
