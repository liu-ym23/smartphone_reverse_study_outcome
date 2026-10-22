package com.ss.android.lark.keyboard.keyboard2;

import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f429568b;

    public m() {
    }

    public abstract int a();

    public int b() {
        return R.color.kb_icon_color_selector;
    }

    public abstract KeyboardMenuItemKey g();

    public Integer q() {
        return null;
    }

    public abstract void s();

    public void u() {
    }

    public void v() {
    }

    public void w(boolean r100) {
    }

    public void x(i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
    }

    public void y(boolean r100) {
    }

    public final com.ss.android.lark.keyboard.b n() {
        com.ss.android.lark.keyboard.b r100 = this.f429567a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }
}
