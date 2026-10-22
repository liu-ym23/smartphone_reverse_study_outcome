package com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar;

import android.app.Activity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SelectedUserAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a, View.OnFocusChangeListener, TextView.OnEditorActionListener {
    public final Activity a;
    public final View b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final SelectedUserAdapter k;
    public com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a l;
    public Disposable m;
    public final gh5.d n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a r2 = this.a.l;
            if (r2 == null) goto L6;
            r2.X5();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0103c implements View.OnClickListener {
        public final /* synthetic */ c a;

        public ViewOnClickListenerC0103c(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a r3 = this.a.l;
            if (r3 == null) goto L5;
            r3.D2();
        L5:
            ((SpaceEditText) this.a.b.findViewById(2131386085)).setText("");
        }
    }

    public static final class d extends t {
        public final /* synthetic */ c c;

        public d(c r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r1) {
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a r2 = this.c.l;
            if (r2 == null) goto L6;
            r2.p();
            return;
        }
    }

    public static final class e implements TextView.OnEditorActionListener {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
            if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm_mindnote_mobile.screen_view_horizental") == true) goto L5;
            return false;
        L5:
            if (this.a.b.getContext() == null) goto L14;
            c r5 = this.a;
            if (r5.a.getResources().getConfiguration().orientation == 2) goto L9;
            return false;
        L9:
            if (r3 != 3) goto L16;
            rcb.c.d(r5.b.findViewById(2131386085));
            return true;
        L16:
            return false;
        L14:
            return false;
        }
    }

    public static final class f implements BaseQuickAdapter.OnItemClickListener {
        public final /* synthetic */ c a;

        public f(c r1) {
            this.a = r1;
        }

        public final void onItemClick(BaseQuickAdapter r1, View r2, int r3) {
            if (r3 >= this.a.k.getData().size()) goto L8;
            c r4 = this.a;
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a r5 = r4.l;
            if (r5 == null) goto L9;
            r5.O3((UserInfo) ListProtector.get(r4.k.getData(), r3));
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ c a;

        public g(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            CharSequence r4 = (CharSequence) r3;
            c r0 = this.a;
            if (r4 == null) goto L6;
            String r5 = r4.toString();
            if (r5 == null) goto L6;
        L7:
            com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a r1 = r0.l;
            if (r1 == null) goto L10;
            r1.B2(r5);
        L10:
            boolean r6 = TextUtils.isEmpty(r5);
            ImageView r2 = (ImageView) r0.b.findViewById(2131386128);
            if (r6 == false) goto L13;
            int r7 = 8;
        L14:
            r2.setVisibility(r7);
            return;
        L13:
            r7 = 0;
        L6:
            r5 = "";
            goto L7
        }
    }

    public static final class h<T> implements Consumer {
        public static final h<T> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r3) {
            tt5.a.f("TopbarView", (Throwable) r3, false);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void P5() {
        RecyclerView r0 = this.b.findViewById(2131382140);
        if (r0.getVisibility() != 8) goto L6;
        r0.setVisibility(0);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void X6() {
        RecyclerView r0 = this.b.findViewById(2131382140);
        if (r0.getVisibility() != 0) goto L6;
        r0.setVisibility(8);
        return;
    }

    public final void create() {
        if (this.i == false) goto L5;
        int r0 = 2131254998;
    L6:
        ((ImageView) this.b.findViewById(2131382142)).setImageResource(r0);
        ((ImageView) this.b.findViewById(2131382142)).setOnClickListener(new b(this));
        ((TextView) this.b.findViewById(2131382141)).setText(this.c);
        ((ImageView) this.b.findViewById(2131386128)).setOnClickListener(new ViewOnClickListenerC0103c(this));
        ((SpaceEditText) this.b.findViewById(2131386085)).setOnFocusChangeListener(this);
        ((SpaceEditText) this.b.findViewById(2131386085)).setOnClickListener(new d(this));
        ((SpaceEditText) this.b.findViewById(2131386085)).setOnEditorActionListener(new e(this));
        if (this.h == false) goto L9;
        int r1 = 2131888878;
    L28:
        ((SpaceEditText) this.b.findViewById(2131386085)).setHint(r1);
        this.b.findViewById(2131382140).setAdapter(this.k);
        this.b.findViewById(2131382140).setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        this.k.setOnItemClickListener(new f(this));
        this.m = vu5.b.a((TextView) this.b.findViewById(2131386085)).debounce(300, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new g(this), h.a);
        if (this.j == false) goto L32;
        ((SpaceEditText) this.b.findViewById(2131386085)).postDelayed(this.n, 50);
        return;
    L32:
        return;
    L9:
        int r2 = this.g;
        if (r2 != 113) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        r1 = 2131889745;
        goto L28
    L16:
        if (sbb.g.a(r2) == false) goto L19;
        r1 = 2131889744;
        goto L28
    L19:
        if (this.f == false) goto L22;
        r1 = 2131889264;
        goto L28
    L22:
        if (this.e == false) goto L25;
        r1 = 2131889893;
        goto L28
    L25:
        if (this.d == false) goto L27;
        r1 = 2131888042;
        goto L28
    L27:
        r1 = 2131887717;
        goto L28
    L12:
        r3 = false;
        goto L13
    L5:
        r0 = 2131254124;
        goto L6
    }

    public final void destroy() {
        Disposable r0 = this.m;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        Disposable r2 = this.m;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        ((SpaceEditText) this.b.findViewById(2131386085)).removeCallbacks(this.n);
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void R0(ArrayList<UserInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfos");
        this.k.setNewData(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void W(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        int r3 = this.k.getData().indexOf(r2);
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= this.k.getData().size()) goto L9;
        this.k.remove(r3);
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.l = (com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a
    public final void u5(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.k.addData(r2);
        this.b.findViewById(2131382140).scrollToPosition(this.k.getData().size() - 1);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.a.InterfaceC0101a r3 = this.l;
        if (r3 == null) goto L6;
        r3.C2(r2);
        return;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L5;
    L8:
        rcb.c.c(this.a);
        return true;
    L5:
        if (r2 == 6) goto L8;
        return false;
    }

    public c(FragmentActivity r2, View r3, String r4, boolean r5, boolean r6, boolean r7, int r8, boolean r9, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = new SelectedUserAdapter();
        this.n = new gh5.d(this);
    }
}
