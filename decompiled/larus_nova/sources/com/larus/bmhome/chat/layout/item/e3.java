package com.larus.bmhome.chat.layout.item;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f304325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c3 f304326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List<View> f304327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f304328d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f304329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c3 f304330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f304331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f304332d;

        public a(int r100, c3 r101, View r102, View r103) {
            this.f304329a = r100;
            this.f304330b = r101;
            this.f304331c = r102;
            this.f304332d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f304329a != this.f304330b.f304282e) goto L12;
            this.f304331c.setAlpha(1.0f);     // Catch: Throwable -> L9
            this.f304331c.setTranslationY(0.0f);     // Catch: Throwable -> L9
            if (Intrinsics.areEqual(this.f304331c, this.f304332d) == false) goto L16;
            c3 r100 = this.f304330b;     // Catch: Throwable -> L9
            r100.f304283f = CollectionsKt.emptyList();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e3(int r100, c3 r101, List<? extends View> r102, View r103) {
        this.f304325a = r100;
        this.f304326b = r101;
        this.f304327c = r102;
        this.f304328d = r103;
    }

    public final void a() {
        if (this.f304325a == this.f304326b.f304282e) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f304327c.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((View) r100.next()).animate().cancel();
        goto L7
    L9:
        List<View> r101 = this.f304327c;
        int r102 = this.f304325a;
        c3 r103 = this.f304326b;
        View r104 = this.f304328d;
        Iterator<T> r105 = r101.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        View r106 = (View) r105.next();
        r106.animate().alpha(1.0f).translationY(0.0f).setStartDelay(80).setDuration(240).setInterpolator(c3.f304277g).withEndAction(new a(r102, r103, r106, r104)).start();
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
