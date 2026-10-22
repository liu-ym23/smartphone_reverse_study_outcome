package com.ss.android.lark.widget.select;

import android.widget.ScrollView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f448417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScrollView f448418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f448419c;

    public d(Ref.BooleanRef r100, ScrollView r101, e r102) {
        this.f448417a = r100;
        this.f448418b = r101;
        this.f448419c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f448417a.element = false;     // Catch: Throwable -> L4
        this.f448418b.removeCallbacks(this.f448419c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
