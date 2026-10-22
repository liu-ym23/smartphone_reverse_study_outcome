package com.ss.android.lark.compose.foundation.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends Toast implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f417654a;

    public static final class a {
    }

    static {
    }

    @Override // android.widget.Toast, com.larksuite.component.universe_design.toast.c
    public final void show() {
        int r100 = h.f417655a;
        Intrinsics.checkNotNullParameter(this, "toast");
        boolean r101 = false;
        if (Build.VERSION.SDK_INT != 25) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L26;
    L24:
        this.f417654a.b();
        super.show();
        return;
    L26:
        Object r103 = h.a(this, "mTN");     // Catch: Throwable -> L22
        if (r103 == null) goto L24;
        Object r104 = h.a(r103, "mShow");     // Catch: Throwable -> L22
        if (r104 != null) goto L13;
    L15:
        if (r101 == true) goto L24;
        Object r105 = h.a(r103, "mHandler");     // Catch: Throwable -> L22
        if (r105 == null) goto L24;
        if ((r105 instanceof Handler) == false) goto L24;
        h.b(r105, "mCallback", new h.a((Handler) r105));     // Catch: Throwable -> L22
        goto L24
    L13:
        if ((r104 instanceof Runnable) == false) goto L15;
        r101 = h.b(r103, "mShow", new h.b((Runnable) r104));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L24
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final boolean isShowing() {
        View r100 = getView();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isAttachedToWindow();
    }

    @Override // android.widget.Toast, com.larksuite.component.universe_design.toast.c
    public final void cancel() {
        super.cancel();
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        i r101 = new i(r100);
        this.f417654a = r101;
        setView(r101.f417659b.f424293a);
        setGravity(48, 0, (int) h18.d.b(r100, 100));
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void setIcon(int r100) {
        i r101 = this.f417654a;
        r101.a(UDIconUtils.getIconDrawable(r101.f417658a, r100));
    }

    @Override // android.widget.Toast
    public final void setText(int r100) {
        i r101 = this.f417654a;
        String r102 = r101.f417658a.getString(r100);
        Intrinsics.checkNotNullParameter(r102, "s");
        r101.f417659b.f424297e.setText(r102);
    }

    @Override // com.larksuite.component.universe_design.toast.c
    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f417654a.a(r100);
    }

    @Override // android.widget.Toast, com.larksuite.component.universe_design.toast.c
    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        i r101 = this.f417654a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "s");
        r101.f417659b.f424297e.setText(r100);
    }
}
