package com.bytedance.ee.bear.bitable.itemview.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f214301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f214302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f214303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f214304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f214305e;

    public static final class a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f214306a;

        public a(t r100) {
            this.f214306a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            l.a("PressWrapper long click", null, null, null, 14);
            this.f214306a.f214301a = true;
            return false;
        }
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f214307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableAtEditText f214308b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f214309a;

            public a(View r100) {
                this.f214309a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l.a("PressWrapper simple click", null, null, null, 14);     // Catch: Throwable -> L4
                this.f214309a.performClick();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(t r100, BitableAtEditText r101) {
            this.f214307a = r100;
            this.f214308b = r101;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            t r103 = this.f214307a;
            r103.f214301a = false;
            r103.f214302b = false;
            r103.f214303c = r101.getRawX();
            this.f214307a.f214304d = r101.getRawY();
        L23:
            return false;
        L5:
            if (r102 != 1) goto L7;
            t r104 = this.f214307a;
            if (r104.f214301a == true) goto L23;
            if (r104.f214302b == true) goto L23;
            l.a("PressWrapper simple click delay", null, null, null, 14);
            this.f214308b.postDelayed(new a(r100), 100);
            goto L23
        L7:
            if (r102 != 2) goto L9;
            float r105 = Math.abs(r101.getRawX() - this.f214307a.f214303c);
            float r106 = Math.abs(r101.getRawY() - this.f214307a.f214304d);
            t r107 = this.f214307a;
            float r108 = r107.f214305e;
            if (r105 <= r108) goto L15;
        L16:
            r107.f214302b = true;
            goto L23
        L15:
            if (r106 <= r108) goto L23;
        L9:
            if (r102 != 3) goto L23;
            this.f214307a.f214302b = false;
            goto L23
        }
    }

    public t(BitableAtEditText r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f214305e = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        if (r101 == false) goto L5;
        r100.setOnLongClickListener(new a(this));
    L5:
        r100.setOnTouchListener(new b(this, r100));
    }
}
