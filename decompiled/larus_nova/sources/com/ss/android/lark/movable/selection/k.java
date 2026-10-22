package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MovableView f432804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f432805b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f432806a;

        public a(Function0<Unit> r100) {
            this.f432806a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f432806a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getAction() != 0) goto L21;
        MovableSelectionManager r101 = this.f432804a.getRootMovableView().getSelectionManager$movable_release();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
        return false;
    L12:
        if (r101 == null) goto L20;
        Pair<Rect, Rect> r103 = r101.b(true);
        if (r103 == null) goto L20;
        Rect r104 = r103.component1();
        Rect r105 = r103.component2();
        int r106 = (int) r100.getRawX();
        int r107 = (int) r100.getRawY();
        if (r104.contains(r106, r107) == false) goto L18;
    L19:
        return false;
    L18:
        if (r105.contains(r106, r107) == true) goto L19;
    L20:
        Log.d("Movable_SelectionDialog", "dispatchTouchEvent: cancel selection by spyView");
        post(new a(this.f432805b));
        goto L21
    L7:
        if (r101.f432731g != true) goto L9;
        r102 = true;
    L21:
        return false;
    }

    public k(Context r100, MovableView r101, Function0<Unit> r102) {
        this.f432804a = r101;
        this.f432805b = r102;
        super(r100);
    }
}
