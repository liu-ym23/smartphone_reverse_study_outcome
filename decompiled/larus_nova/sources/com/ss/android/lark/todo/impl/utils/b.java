package com.ss.android.lark.todo.impl.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f444276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f444277b;

        public a(View r100, int r101) {
            this.f444276a = r100;
            this.f444277b = r101;
        }

        public final void a() {
            Rect r100 = new Rect();
            this.f444276a.getHitRect(r100);
            int r101 = r100.top;
            int r102 = this.f444277b;
            r100.top = r101 - r102;
            r100.bottom += r102;
            r100.left -= r102;
            r100.right += r102;
            ViewParent r103 = this.f444276a.getParent();
            if ((r103 instanceof ViewGroup) == false) goto L5;
            ViewGroup r104 = (ViewGroup) r103;
        L6:
            if (r104 == null) goto L9;
            r104.setTouchDelegate(new TouchDelegate(r100, this.f444276a));
            return;
        L9:
            return;
        L5:
            r104 = null;
            goto L6
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

    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.post(new a(r100, r101));
    }
}
