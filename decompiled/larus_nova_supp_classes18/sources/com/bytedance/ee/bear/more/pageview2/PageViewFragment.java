package com.bytedance.ee.bear.more.pageview2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.CompatLandscapeBottomSheetDialogFragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.m;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.toast.c;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.HashMap;
import sj5.d;
import tj5.e;
import tj5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PageViewFragment extends CompatLandscapeBottomSheetDialogFragment {
    public static final /* synthetic */ int B = 0;
    public final a A;
    public b k;
    public String l;
    public PageViewModel m;
    public d n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public PageviewUIHolder t;
    public HashMap<String, Serializable> u;
    public boolean v;
    public boolean w;
    public Runnable x;
    public c y;
    public Disposable z;

    public class a implements Runnable {
        public final /* synthetic */ PageViewFragment a;

        @Override // java.lang.Runnable
        public final void run() {
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        L24:
            return;
        L3:
            if (this.a.isResumed() == false) goto L17;
            PageViewFragment r0 = this.a;     // Catch: Throwable -> L14
            int r1 = PageViewFragment.B;     // Catch: Throwable -> L14
            Dialog r2 = r0.getDialog();     // Catch: Throwable -> L14
            View r3 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.a(r2);     // Catch: Throwable -> L14
            if (r3 == null) goto L21;
            BottomSheetBehavior r4 = com.bytedance.ee.bear.bizwidget.dialogfragment.b.b(r2);     // Catch: Throwable -> L14
            if (r4 == null) goto L22;
            int r5 = r3.getHeight();     // Catch: Throwable -> L14
            if (r5 <= 0) goto L23;
            r4.setPeekHeight(r5);     // Catch: Throwable -> L14
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        }

        public a(PageViewFragment r1) {
            this.a = r1;
        }
    }

    public class b {
        public PageviewItemView A;
        public PageviewItemView B;
        public PageviewItemView C;
        public PageviewItemView D;
        public final /* synthetic */ PageViewFragment E;
        public TextView a;
        public UDAvatar b;
        public TextView c;
        public TextView d;
        public UDAvatar e;
        public View f;
        public TextView g;
        public View h;
        public ViewGroup i;
        public TextView j;
        public TextView k;
        public TextView l;
        public View m;
        public TextView n;
        public TextView o;
        public TextView p;
        public View q;
        public TextView r;
        public View s;
        public TextView t;
        public View u;
        public ImageView v;
        public SpaceEmptyState w;
        public PageviewTextView x;
        public PageviewTextView y;
        public PageviewTextView z;

        public final void b() {
            m.e(this.E.x);
            c r0 = this.E.y;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            PageViewFragment r1 = this.E;
            r1.x = null;
            r1.y = null;
        }

        public final void c() {
            if (this.n.getVisibility() == 8) goto L5;
        L9:
            this.i.setVisibility(0);
            return;
        L5:
            if (this.p.getVisibility() != 8) goto L9;
            if (this.t.getVisibility() != 8) goto L9;
            this.i.setVisibility(8);
        }

        public final String a(int r3) {
            if (r3 >= 1000) goto L6;
            return String.valueOf(r3);
        L6:
            if (r3 >= 1000000) goto L9;
            return String.valueOf(r3 / CCMLynxCardView.ViewType.BANNER) + n.x(this.E.getContext(), 2131887141);
        L9:
            return String.valueOf(r3 / 1000000) + n.x(this.E.getContext(), 2131887140);
        }

        public b(PageViewFragment r1, View r2) {
            this.E = r1;
            TextView r3 = (TextView) r2.findViewById(2131388772);
            this.a = (TextView) r2.findViewById(2131387628);
            this.b = r2.findViewById(2131387627);
            this.j = (TextView) r2.findViewById(2131388908);
            this.f = r2.findViewById(2131387650);
            this.d = (TextView) r2.findViewById(2131387652);
            this.e = r2.findViewById(2131387651);
            this.g = (TextView) r2.findViewById(2131387656);
            this.h = r2.findViewById(2131387655);
            this.c = (TextView) r2.findViewById(2131387630);
            this.i = (ViewGroup) r2.findViewById(2131388910);
            this.k = (TextView) r2.findViewById(2131388909);
            this.n = (TextView) r2.findViewById(2131387631);
            this.l = (TextView) r2.findViewById(2131387633);
            this.m = r2.findViewById(2131387632);
            this.p = (TextView) r2.findViewById(2131387634);
            this.o = (TextView) r2.findViewById(2131387636);
            this.q = r2.findViewById(2131387635);
            this.t = (TextView) r2.findViewById(2131387637);
            this.r = (TextView) r2.findViewById(2131387639);
            this.s = r2.findViewById(2131387638);
            this.v = (ImageView) r2.findViewById(2131377699);
            this.u = r2.findViewById(2131384216);
            this.w = (SpaceEmptyState) r2.findViewById(2131371597);
            this.x = (PageviewTextView) r2.findViewById(2131375864);
            this.y = (PageviewTextView) r2.findViewById(2131381561);
            this.z = (PageviewTextView) r2.findViewById(2131375865);
            this.A = (PageviewItemView) r2.findViewById(2131375830);
            this.B = (PageviewItemView) r2.findViewById(2131375831);
            this.C = (PageviewItemView) r2.findViewById(2131375832);
            this.D = (PageviewItemView) r2.findViewById(2131375833);
        }
    }

    public final void W90() {
        tt5.a.h("PageViewFragment", "onFloatDismiss");
        d r0 = this.n;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    public PageViewFragment() {
        this.v = true;
        this.w = true;
        this.A = new a(this);
    }

    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onDestroy();
        Disposable r0 = this.z;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        b r1 = this.k;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    public final void da0(PageviewUIHolder r4) {
        PageviewUIHolder r0 = this.t;
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r4.d;
        if (r1 != null) goto L8;
        r1 = getContext().getString(2131892102);
    L8:
        r0.d = r1;
        PageviewUIHolder r2 = this.t;
        String r5 = r4.e;
        if (r5 != null) goto L11;
        r5 = getContext().getString(2131892102);
    L11:
        r2.e = r5;
        if (TextUtils.isEmpty(this.t.a) == false) goto L14;
    L19:
        boolean r6 = true;
    L20:
        this.w = r6;
        b r3 = this.k;
        if (r3 != null) goto L23;
        return;
    L23:
        if (r6 == false) goto L29;
        if (this.v == false) goto L27;
        r3.u.setVisibility(4);
    L27:
        this.k.w.setVisibility(8);
        this.k.l.setText(this.t.d);
        this.k.o.setText(this.t.e);
        return;
    L29:
        if (this.v == false) goto L31;
        r3.u.setVisibility(0);
        r3.w.setVisibility(8);
        return;
    L31:
        r3.u.setVisibility(8);
        r3.w.setVisibility(0);
        return;
    L14:
        if (TextUtils.isEmpty(this.t.d) == false) goto L19;
        if (TextUtils.isEmpty(this.t.e) == false) goto L19;
        r6 = false;
        goto L20
    }

    public final void onCreate(Bundle r4) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onCreate(r4);
        this.l = ((i0) org.koin.java.a.a(i0.class)).a();
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        tt5.a.d("PageViewFragment", "getArguments() == null");
    L13:
        PageViewModel r5 = (PageViewModel) ViewModelProviders.of(getActivity()).get(PageViewModel.class);
        this.m = r5;
        r5.getPageViewResult().observe(this, new tj5.a(this));
        if (this.t != null) goto L20;
        this.w = true;
        return;
    L20:
        return;
    L5:
        this.o = r0.getInt("documentType");
        this.p = r0.getString(ResourceData.KEY_TOKEN);
        this.q = r0.getBoolean("isDocV2");
        this.r = r0.getBoolean("isShowViewHistory");
        this.t = (PageviewUIHolder) r0.getParcelable("titleHolder");
        this.s = (String) r0.getParcelable("docName");
        Serializable r1 = r0.getSerializable("extraParams");     // Catch: Exception -> L11
        if (r1 != null) goto L9;
        tt5.a.h("PageViewFragment", "initBundle, extraParams doesn't exist.");     // Catch: Exception -> L11
    L17:
        goto L13
    L9:
        HashMap<String, Serializable> r2 = (HashMap) r1;     // Catch: Exception -> L11
        this.u = r2;     // Catch: Exception -> L11
        tt5.a.h("PageViewFragment", "initBundle, extraParams: " + r2);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        tt5.a.i("PageViewFragment", "newInstance, deserialize extraParams error", e);
        goto L13
    }

    public final void onDismiss(DialogInterface r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        d r3 = this.n;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.onDismiss();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void Z90(WindowManager.LayoutParams r3, boolean r4) {
        if (r4 == false) goto L4;
        r3.height = n.p(getActivity()) - BaseBottomSheetDialogFragment.j;
    L5:
        if (r4 == true) goto L8;
        j.e(this.A);
        j.c(this.A);
        return;
    L8:
        return;
    L4:
        r3.height = -1;
        goto L5
    }

    public final void onViewCreated(View r7, Bundle r8) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r7, r8);
        final b r9 = new b(this, r7);
        this.k = r9;
        r9.A.setTitle(n.x(getContext(), 2131887677));
        r9.B.setTitle(n.x(getContext(), 2131887678));
        r9.C.setTitle(n.x(getContext(), 2131887401));
        r9.D.setTitle(n.x(getContext(), 2131888034));
        r9.x.setTitle(n.x(getContext(), 2131889338));
        r9.x.setImageResource(2131256160);
        r9.z.setTitle(n.x(getContext(), 2131887134));
        r9.z.setImageResource(2131255650);
        r9.z.d.setVisibility(4);
        r9.x.setOnClickListener(new tj5.b(r9));
        r9.z.setOnClickListener(new tj5.c(r9));
        this.k.u.setOnClickListener(new tj5.d(r9));
        r9.w.setPrimaryClickListener(new e(r9));
        r9.v.setOnClickListener(new f(r9));
        PageviewUIHolder r10 = this.t;
        int r0 = 0;
        if (r10 != null) goto L5;
    L16:
        r9.i.setVisibility(8);
    L17:
        r9.c();
        PageviewUIHolder r11 = this.t;
        if (r11 != null) goto L20;
    L22:
        boolean r12 = this.q;
        HashMap<String, Serializable> r2 = this.u;
        tt5.a.h("PageViewFragment", "initOperationItem operationEnable=" + r12);
        HashMap r3 = new HashMap();
        r3.put(ResourceData.KEY_TOKEN, this.p);
        r3.put("obj_type", Integer.valueOf(this.o));
        if (r2 == null) goto L25;
        r3.put(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY, r2.get(IDocPublicPermission.ConfigInfo.CONFIG_LEADER_SEARCH_NUMBER_KEY));
    L25:
        PageviewTextView r4 = r9.y;
        if (r12 == true) goto L29;
        r0 = 8;
    L29:
        r4.setVisibility(r0);
        r9.y.setTitle(getString(2131887118));
        r9.y.setImageResource(2131238029);
        r9.y.setOnClickListener(new com.bytedance.ee.bear.more.pageview2.a(r9, r3));
        if (this.r == true) goto L33;
        this.k.x.setVisibility(8);
        return;
    L33:
        return;
    L20:
        if (r11.f == true) goto L22;
        r9.D.setVisibility(8);
        goto L22
    L5:
        if (TextUtils.isEmpty(r10.a) == true) goto L16;
        r9.i.setVisibility(0);
        this.k.k.setText(this.t.a);
        if (TextUtils.isEmpty(this.t.b) == true) goto L10;
        int r13 = 0;
    L11:
        this.k.n.setVisibility(r13);
        this.k.l.setVisibility(r13);
        this.k.m.setVisibility(r13);
        this.k.n.setText(this.t.b);
        if (TextUtils.isEmpty(this.t.c) == true) goto L14;
        int r14 = 0;
    L15:
        this.k.p.setVisibility(r14);
        this.k.o.setVisibility(r14);
        this.k.q.setVisibility(r14);
        this.k.p.setText(this.t.c);
        da0(this.t);
        goto L17
    L14:
        r14 = 8;
        goto L15
    L10:
        r13 = 8;
        goto L11
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564165, r3, false);
    }
}
