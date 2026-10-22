package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s implements nq8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f299151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<nq8.a.InterfaceC6961a> f299152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnKeyListener f299153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f299154d;

    @Override // nq8.a
    public final int c() {
        return this.f299151a.getSelectionEnd();
    }

    @Override // nq8.a
    public final int g() {
        return this.f299151a.getSelectionStart();
    }

    @Override // nq8.a
    public final Editable getText() {
        return this.f299151a.getText();
    }

    public s(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        this.f299151a = r100;
        this.f299152b = new ArrayList();
    }

    @Override // nq8.a
    public final void a(qq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f299152b).remove(r100);
    }

    @Override // nq8.a
    public final void b(int r100) {
        this.f299151a.setSelection(r100);
    }

    @Override // nq8.a
    public final void d(uq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        this.f299151a.addTextChangedListener(r100);
    }

    @Override // nq8.a
    public final void e(qq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f299152b).add(r100);
        if (this.f299154d == true) goto L19;
        this.f299154d = true;
        Field r101 = View.class.getDeclaredField("mListenerInfo");     // Catch: Exception -> L16
        r101.setAccessible(true);     // Catch: Exception -> L16
        Object r102 = r101.get(this.f299151a);     // Catch: Exception -> L16
        if (r102 == null) goto L13;
        Field r103 = r102.getClass().getDeclaredField("mOnKeyListener");     // Catch: Exception -> L16
        r103.setAccessible(true);     // Catch: Exception -> L16
        Object r104 = r103.get(r102);     // Catch: Exception -> L16
        if ((r104 instanceof View.OnKeyListener) == false) goto L13;
        View.OnKeyListener r105 = (View.OnKeyListener) r104;     // Catch: Exception -> L16
    L14:
        this.f299153c = r105;
        this.f299151a.setOnKeyListener(new r(this));
        return;
    L13:
        r105 = null;
        goto L14
    }

    @Override // nq8.a
    public final void f(uq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        this.f299151a.removeTextChangedListener(r100);
    }
}
