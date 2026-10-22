package com.ss.android.lark.insets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f427746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<j> f427747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f427748c;

    public d(Dialog r100, Ref.ObjectRef<j> r101, int r102) {
        this.f427746a = r100;
        this.f427747b = r101;
        this.f427748c = r102;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        Window r101 = this.f427746a.getWindow();
        if (r101 == null) goto L7;
        Map<Integer, WeakReference<j>> r102 = e.f427749r;
        e.a.a(r101);
        int r103 = h.f427764q;
        this.f427747b.element.f427768a = h.a.a(r101);
        e.f427749r.remove(Integer.valueOf(this.f427748c));
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
