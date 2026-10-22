package com.larus.gallery.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public abstract class t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CoroutineScope f343896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f343897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f343898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w f343899e;

    public boolean m() {
        return !(this instanceof m88.g);
    }

    public boolean n() {
        return !(this instanceof m88.i);
    }

    public Fragment o(ViewGroup r100) {
        return null;
    }

    public View p(ViewGroup r100) {
        return null;
    }

    public ViewGroup.LayoutParams q() {
        return null;
    }

    public boolean s() {
        return this instanceof PreviewBottomProvider;
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public void x(p r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public final CoroutineScope r() {
        CoroutineScope r100 = this.f343896b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleScope");
        return null;
    }

    public t() {
        this.f343895a = getClass().getSimpleName();
    }

    public final Context getContext() {
        return this.f343897c;
    }

    public void w(T r100, int r101) {
        this.f343898d = r100;
    }
}
