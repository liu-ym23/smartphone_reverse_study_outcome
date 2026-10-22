package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class w implements com.larksuite.framework.ui.b, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f436537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f436538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayoutManager f436539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f436540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f436541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x f436542f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f436543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f436544b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f436543a == r101.f436543a) goto L12;
            return false;
        L12:
            if (this.f436544b == r101.f436544b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f436543a * 31) + this.f436544b;
        }

        public final String toString() {
            return "Anchor(position=" + this.f436543a + ", offset=" + this.f436544b + ')';
        }

        public a(int r100, int r101) {
            this.f436543a = r100;
            this.f436544b = r101;
        }
    }

    @Override // com.larksuite.framework.ui.b
    public final void a() {
    }

    @Override // com.larksuite.framework.ui.b
    public final void b() {
    }

    @Override // com.larksuite.framework.ui.b
    public final void onLayoutComplete() {
    }

    public final boolean d() {
        if (this.f436539c.getItemCount() != 0) goto L6;
        return false;
    L6:
        if (this.f436537a.canScrollVertically(1) == false) goto L8;
    L24:
        return true;
    L8:
        if (this.f436537a.canScrollVertically(-1) == true) goto L24;
        int r100 = this.f436539c.findFirstVisibleItemPosition();
        int r101 = this.f436539c.findLastVisibleItemPosition();
        if (r100 == (-1)) goto L25;
        if (r101 == (-1)) goto L27;
        View r102 = this.f436539c.findViewByPosition(r100);
        if (r102 == null) goto L28;
        View r103 = this.f436539c.findViewByPosition(r101);
        if (r103 != null) goto L21;
        return false;
    L21:
        if ((r103.getBottom() - r102.getTop()) < ((this.f436537a.getHeight() - this.f436537a.getPaddingTop()) - this.f436537a.getPaddingBottom())) goto L26;
        return true;
    L26:
        return false;
    L28:
        return false;
    L27:
        return false;
    L25:
        return false;
    }

    public w(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f436537a = r100;
        this.f436538b = true;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r102 = (LinearLayoutManager) r101;
    L6:
        if (r102 == null) goto L10;
        this.f436539c = r102;
        this.f436540d = r102.getStackFromEnd();
        int r103 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "init", hashCode() + ", isEnabled=true", null, 8);
        r100.addOnLayoutChangeListener(this);
        this.f436542f = new x(this);
        return;
    L10:
        throw new IllegalStateException("RecyclerView must use LinearLayoutManager");
    L5:
        r102 = null;
        goto L6
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (this.f436538b == true) goto L6;
        return;
    L6:
        if (this.f436540d == false) goto L9;
        return;
    L9:
        if (d() == true) goto L11;
        return;
    L11:
        f(true, r100);
    }

    public final void e(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (this.f436541e == r100) goto L6;
        this.f436541e = r100;
        int r102 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "setFrozenStackFromEnd", "frozen=" + r100 + ", source=" + r101, null, 8);
        return;
    }

    public final boolean f(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        int r102 = bwb.b.f21271a;
        a r103 = null;
        bwb.b.g(MmUiLogScene.SUBTITLE, "toggleStackFromEnd", "enable=" + r100 + ", stackFromEnd:" + this.f436540d + ", source=" + r101, null, 8);
        if (this.f436538b == true) goto L6;
        return false;
    L6:
        if (this.f436540d != r100) goto L8;
        return false;
    L8:
        this.f436540d = r100;
        this.f436539c.setStackFromEnd(r100);
        if (r100 == true) goto L11;
        int r104 = this.f436539c.findFirstVisibleItemPosition();
        if (r104 == (-1)) goto L22;
        View r105 = this.f436539c.findViewByPosition(r104);
        if (r105 == null) goto L22;
        r103 = new a(r104, r105.getTop() - this.f436537a.getPaddingTop());
    L22:
        if (r103 == null) goto L24;
        this.f436539c.scrollToPositionWithOffset(r103.f436543a, r103.f436544b);
    L24:
        return true;
    L11:
        if (this.f436539c.getItemCount() <= 0) goto L14;
        LinearLayoutManager r106 = this.f436539c;
        r106.scrollToPositionWithOffset(r106.getItemCount() - 1, 0);
    L14:
        return true;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (this.f436540d == true) goto L5;
        return;
    L5:
        if ((r104 - r102) == (r108 - r106)) goto L7;
    L8:
        this.f436537a.removeCallbacks(this.f436542f);
        this.f436537a.post(this.f436542f);
        return;
    L7:
        if ((r103 - r101) != (r107 - r105)) goto L8;
    }
}
