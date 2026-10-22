package com.bytedance.ee.bear.bitable.card.view.record;

import android.text.Layout;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import hp4.u;
import java.lang.ref.WeakReference;
import jq4.k;
import jq4.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f208659g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f208660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f208661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<RecyclerView> f208662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC3009a f208663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f208664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f208665f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.record.a$a, reason: collision with other inner class name */
    public interface InterfaceC3009a {
        void b(int r100);
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f208666a;

        public c(a r100) {
            this.f208666a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f208666a;     // Catch: Throwable -> L9
            if (r100.f208662c.get() == null) goto L12;
            tt5.a.b("STFocusCellVisibleUpdater", "resetBottomSpaceHeight");     // Catch: Throwable -> L9
            InterfaceC3009a r101 = r100.f208663d;     // Catch: Throwable -> L9
            if (r101 == null) goto L16;
            r101.b(a.f208659g);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f208667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f208668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f208669c;

        public d(a r100, View r101, u r102) {
            this.f208667a = r100;
            this.f208668b = r101;
            this.f208669c = r102;
        }

        public final void a() {
            a r100 = this.f208667a;
            View r101 = this.f208668b;
            int r102 = this.f208669c.getPanelHeight(r101.getContext());
            RecyclerView r103 = r100.f208662c.get();
            if (r103 == null) goto L24;
            tt5.a.b("STFocusCellVisibleUpdater", "show focus view");
            tt5.a.b("STFocusCellVisibleUpdater", "panel height: " + r102);
            j.e(r100.f208664e);
            InterfaceC3009a r104 = r100.f208663d;
            if (r104 == null) goto L9;
            r104.b(r102 - a.f208659g);
        L9:
            if ((r101 instanceof AtEditText) == true) goto L11;
        L17:
            int[] r105 = new int[2];
            if (r100.f208661b == false) goto L20;
            r101.getLocationInWindow(r105);
        L21:
            tt5.a.b("STFocusCellVisibleUpdater", "loc y: " + r105[1]);
            int r106 = r105[1];
            int r107 = r101.getHeight() + r106;
        L22:
            j.c(new v(r100, r103, r102, r106, r107));
            return;
        L20:
            r101.getLocationOnScreen(r105);
            goto L21
        L11:
            if (r100.f208660a == true) goto L17;
            AtEditText r108 = (AtEditText) r101;
            int[] r109 = new int[2];
            r108.getLocationOnScreen(r109);
            int r110 = r108.getSelectionStart();
            Layout r111 = r108.getLayout();
            if (r111 != null) goto L15;
            tt5.a.d("STFocusCellVisibleUpdater", "textView's layout is null!");
            r106 = r109[1];
        L16:
            r107 = (r108.getLineHeight() + r106) + n.d(12);
            goto L22
        L15:
            int r112 = r111.getLineForOffset(r110);
            int r113 = r111.getLineBaseline(r112);
            int r114 = r111.getLineAscent(r112);
            tt5.a.b("STFocusCellVisibleUpdater", "line " + r112 + " baseline " + r113 + " ascent " + r114 + " ypos " + r109[1] + "scrollY" + r108.getScrollY());
            r106 = r108.getPaddingTop() + (((r113 + r114) + r109[1]) - r108.getScrollY());
            goto L16
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

    static {
        f208659g = n.c(24.0f);
    }

    @Override // jq4.k
    public final void d(View r100, u r101) {
        if (r100 == null) goto L10;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.r2() == true) goto L8;
        return;
    L8:
        j.c(new d(this, r100, r101));
        return;
    }

    @Override // jq4.k
    public final void f(View r100, u r101) {
        c r102 = this.f208664e;
        if (r102 != null) goto L5;
    L7:
        c r103 = new c(this);
        this.f208664e = r103;
        j.d(r103, 200);
        return;
    L5:
        if (j.a(r102) == false) goto L7;
        j.e(r102);
        goto L7
    }

    public a(RecyclerView r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f208660a = r101;
        this.f208661b = r102;
        this.f208662c = new WeakReference(r100);
    }
}
