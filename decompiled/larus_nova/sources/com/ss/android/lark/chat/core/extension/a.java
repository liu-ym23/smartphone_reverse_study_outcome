package com.ss.android.lark.chat.core.extension;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends com.ss.android.lark.chat.core.api.a implements com.ss.android.lark.chat.core.api.a.InterfaceC4846a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f414747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.ss.android.lark.chat.core.api.a> f414748b;

    @Override // com.ss.android.lark.chat.core.api.a
    public final boolean b() {
        Iterator<T> r100 = this.f414748b.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        com.ss.android.lark.chat.core.api.a r101 = (com.ss.android.lark.chat.core.api.a) r100.next();
        r101.getClass();
        if (r101.b() == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void d() {
        Iterator<T> r100 = this.f414748b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r101 = (com.ss.android.lark.chat.core.api.a) r100.next();
        r101.getClass();
        r101.d();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void f() {
        Iterator<T> r100 = this.f414748b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r101 = (com.ss.android.lark.chat.core.api.a) r100.next();
        r101.getClass();
        r101.f();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void h() {
        Iterator<T> r100 = this.f414748b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r101 = (com.ss.android.lark.chat.core.api.a) r100.next();
        r101.getClass();
        r101.h();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void i() {
        Iterator<T> r100 = this.f414748b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r101 = (com.ss.android.lark.chat.core.api.a) r100.next();
        r101.getClass();
        r101.i();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void j() {
        Iterator<T> r100 = this.f414748b.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r101 = (com.ss.android.lark.chat.core.api.a) r100.next();
        r101.getClass();
        r101.j();
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a.InterfaceC4846a
    public FragmentActivity getActivity() {
        return this.f414747a;
    }

    public a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f414747a = r100;
        this.f414748b = new ArrayList();
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void c(Bundle r100) {
        Iterator<T> r101 = this.f414748b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r102 = (com.ss.android.lark.chat.core.api.a) r101.next();
        r102.getClass();
        r102.c(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void e(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Iterator<T> r101 = this.f414748b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r102 = (com.ss.android.lark.chat.core.api.a) r101.next();
        r102.getClass();
        r102.e(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void g(AssistContent r100) {
        Iterator<T> r101 = this.f414748b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r102 = (com.ss.android.lark.chat.core.api.a) r101.next();
        r102.getClass();
        r102.g(r100);
        goto L4
    }

    @Override // com.ss.android.lark.chat.core.api.a
    public final void a(int r100, int r101, Intent r102) {
        Iterator<T> r103 = this.f414748b.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        com.ss.android.lark.chat.core.api.a r104 = (com.ss.android.lark.chat.core.api.a) r103.next();
        r104.getClass();
        r104.a(r100, r101, r102);
        goto L4
    }
}
