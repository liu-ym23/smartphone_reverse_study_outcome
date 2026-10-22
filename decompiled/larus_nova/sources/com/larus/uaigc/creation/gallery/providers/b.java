package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements com.larus.bmhome.share.panel.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.d f372891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.d f372892b;

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
        this.f372891a.f();
        com.larus.bmhome.share.panel.d r100 = this.f372892b;
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        this.f372891a.onDismiss();
        com.larus.bmhome.share.panel.d r100 = this.f372892b;
        if (r100 == null) goto L6;
        r100.onDismiss();
        return;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void e(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        Function0<Unit> r102 = new a(r101, r100);
        this.f372891a.e(r102);
        com.larus.bmhome.share.panel.d r103 = this.f372892b;
        if (r103 == null) goto L6;
        r103.e(r102);
        return;
    }

    public b(com.larus.bmhome.share.panel.d r100, com.larus.bmhome.share.panel.d r101) {
        Intrinsics.checkNotNullParameter(r100, "primary");
        this.f372891a = r100;
        this.f372892b = r101;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r100, String r101, Boolean r102) {
        if (this.f372891a.d(r100, r101, r102) == false) goto L10;
        com.larus.bmhome.share.panel.d r103 = this.f372892b;
        if (r103 == null) goto L7;
        boolean r104 = r103.d(r100, r101, r102);
    L8:
        if (r104 == false) goto L10;
        return true;
    L7:
        r104 = true;
    L10:
        return false;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r100, DialogFragment r101, View r102, jr9.a r103) {
        Intrinsics.checkNotNullParameter(r103, "shareItemConfig");
        if (this.f372891a.b(r100, r101, r102, r103) == false) goto L6;
        return true;
    L6:
        com.larus.bmhome.share.panel.d r104 = this.f372892b;
        if (r104 != null) goto L11;
        return false;
    L11:
        return r104.b(r100, r101, r102, r103);
    }
}
