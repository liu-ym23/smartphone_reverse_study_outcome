package com.bytedance.ee.bear.more.fresh;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.timepicker.impl.action.UDTimePickerBuilder;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pj5.f;
import pj5.i;
import pj5.m;
import pj5.o;
import pj5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010,\u001a\u00020\u001bH\u0002J\u0006\u0010-\u001a\u00020\u001bJ\b\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\u000eH\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0003J\b\u00105\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0007J\b\u00107\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/more/fresh/DocDynamicChampionFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "adapter", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessAdapter;", WikiFolderPushPlugin.DATA, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessEntity;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "objToken", "", "objType", "", "selectEntity", "peekHeight", "", "deadlineTime", "", "isCustomer", "", "customEntity", "one", "freshStatus", "seconds", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "initPeekHeight", "setDoneBtn", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onViewCreated", "view", "addWatermark", "openTimePick", "getDescText", "addData", "buildData", "getNumber", "day", "updateStatus", "entity", "isSupportScreenLandscape", "updateSelected", "onDestroy", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDynamicChampionFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int w = 0;
    public DocFreshNessAdapter k;
    public ArrayList<i> l;
    public final CompositeDisposable m;
    public String n;
    public int o;
    public i p;
    public final double q;
    public long r;
    public i s;
    public final int t;
    public int u;
    public final int v;

    public static final class a {
        public static void a(FragmentActivity r5, o r6) {
            Intrinsics.checkNotNullParameter(r5, "activity");
            Intrinsics.checkNotNullParameter(r6, "param");
            DocDynamicChampionFragment r0 = new DocDynamicChampionFragment();
            Bundle r1 = new Bundle();
            r1.putString("extra_token", r6.b);
            r1.putInt("extra_type", r6.a);
            r1.putBoolean("extra_customer", r6.c);
            r1.putLong("extra_time", r6.d);
            r1.putInt("extra_status", r6.e);
            r0.setArguments(r1);
            FragmentManager r7 = r5.getSupportFragmentManager();
            LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "DocDynamicChampionFragment", r8);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r0, r8) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r0.show(r7, "DocDynamicChampionFragment");
            return;
        }
    }

    public static final class b extends t {
        public final /* synthetic */ DocDynamicChampionFragment c;

        public b(DocDynamicChampionFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DocDynamicChampionFragment a;

        public c(DocDynamicChampionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DocDynamicChampionFragment a;

        public d(DocDynamicChampionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            DocDynamicChampionFragment r9 = this.a;
            i r0 = r9.p;
            CompositeDisposable r1 = r9.m;
            int r2 = mj5.b.a;
            r1.add(mj5.b.a.a(r9.n, r9.o, 3, r0.j).subscribe(new pj5.e(r9), new f(r9)));
        }
    }

    public static final class e implements p {
        public final /* synthetic */ DocDynamicChampionFragment a;

        @Override // pj5.p
        public final void b(i r2) {
            Intrinsics.checkNotNullParameter(r2, "entity");
        }

        public e(DocDynamicChampionFragment r1) {
            this.a = r1;
        }

        @Override // pj5.p
        public final void a(i r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            DocDynamicChampionFragment r0 = this.a;
            r0.p = r5;
            if (r5.i == false) goto L8;
            Context r6 = r0.getContext();
            if (r6 == null) goto L10;
            pj5.a r1 = new pj5.a(r6, r0.s.j);
            r1.m = new pj5.d(r0);
            new UDTimePickerBuilder(r6).controller(r1).show();
            return;
        L10:
            return;
        L8:
            r0.ha0(r5);
        }
    }

    static {
    }

    public DocDynamicChampionFragment() {
        this.l = new ArrayList();
        this.m = new CompositeDisposable();
        this.n = "";
        this.o = -1;
        this.p = new i(false, null, false, false, null, false, 0, false, 0, 1023);
        this.q = 0.5d;
        this.r = -1;
        this.s = new i(false, null, false, false, null, false, 0, false, 0, 1023);
        this.t = 1;
        this.u = -1;
        this.v = CCMLynxCardView.ViewType.BANNER;
    }

    public final void ga0() {
        int r0 = pj5.b.a;
        long r1 = this.r * ((long) this.v);
        long r2 = this.p.j;
        Calendar r4 = Calendar.getInstance();
        Calendar r5 = Calendar.getInstance();
        r4.setTimeInMillis(r1);
        r5.setTimeInMillis(r2);
        int r3 = r4.get(1);
        int r6 = r4.get(2);
        int r7 = r4.get(5);
        int r8 = r5.get(1);
        int r9 = r5.get(2);
        if (r7 != r5.get(5)) goto L7;
        if (r3 != r8) goto L7;
        if (r6 != r9) goto L7;
        boolean r10 = true;
    L8:
        UDButton r11 = null;
        if (r10 == false) goto L16;
        View r12 = getView();
        if (r12 == null) goto L13;
        r11 = r12.findViewById(2131369397);
    L13:
        if (r11 == null) goto L22;
        r11.setEnabled(false);
        return;
    L22:
        return;
    L16:
        View r13 = getView();
        if (r13 == null) goto L19;
        r11 = r13.findViewById(2131369397);
    L19:
        if (r11 == null) goto L23;
        r11.setEnabled(true);
        return;
    L23:
        return;
    L7:
        r10 = false;
        goto L8
    }

    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void fa0() {
        Dialog r0 = getDialog();     // Catch: Throwable -> L11
        if (r0 == null) goto L17;
        Window r1 = r0.getWindow();     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        View r2 = r1.getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r3 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L11
    L13:
        if (r2 == null) goto L17;
        FrameLayout r4 = (FrameLayout) r2.findViewById(2131368870);     // Catch: Throwable -> L11
        if (r4 == null) goto L17;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();     // Catch: Throwable -> L11
    L19:
        if ((r5 instanceof CoordinatorLayout.LayoutParams) == false) goto L30;
        BottomSheetBehavior r6 = ((CoordinatorLayout.LayoutParams) r5).getBehavior();     // Catch: Throwable -> L11
        if ((r6 instanceof BottomSheetBehavior) == true) goto L23;
        return;
    L23:
        if (n.D(getActivity()) == false) goto L25;
        r6.setPeekHeight((int) (((double) n.p(getActivity())) * this.q));     // Catch: Throwable -> L11
        return;
    L25:
        r6.setPeekHeight((int) (((double) n.p(getActivity())) * 1.0d));     // Catch: Throwable -> L11
        return;
    L30:
        return;
    L17:
        r5 = null;
    L11:
        th = move-exception;
        tt5.a.e("DocDynamicChampionFragment", "init peek height", th, false);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.m.clear();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        fa0();
    }

    public final String da0(String r4) {
        StringBuilder r0 = new StringBuilder();
        Context r1 = getContext();
        if (r1 == null) goto L5;
        String r2 = r1.getString(2131888853);
    L6:
        r0.append(r2);
        r0.append(' ');
        r0.append(r4);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public final String ea0(int r4) {
        Context r0 = getContext();
        if (r0 != null) goto L6;
        r0 = eu5.b.a;
    L6:
        return xo5.a.c(r0, 2131888855, "num", String.valueOf(r4));
    }

    public final void ha0(i r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        Iterator<T> r0 = this.l.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).a = false;
        goto L4
    L6:
        r4.a = true;
        DocFreshNessAdapter r5 = this.k;
        if (r5 == null) goto L9;
        r5.notifyDataSetChanged();
    L9:
        ga0();
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        fa0();
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();     // Catch: Exception -> L7
        if (r4 == null) goto L11;
        this.n = r4.getString("extra_token", "");     // Catch: Exception -> L7
        this.o = r4.getInt("extra_type");     // Catch: Exception -> L7
        this.r = r4.getLong("extra_time");     // Catch: Exception -> L7
        r4.getBoolean("extra_customer");     // Catch: Exception -> L7
        this.u = r4.getInt("extra_status");     // Catch: Exception -> L7
        return;
    L11:
        return;
    L7:
        tt5.a.d("DocDynamicChampionFragment", "arguments parse error");
    }

    public final void onViewCreated(View r37, Bundle r38) {
        Intrinsics.checkNotNullParameter(r37, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r37, r38);
        ((BaseTitleBar) r37.findViewById(2131388775)).setTitle(xo5.a.c(getContext(), 2131888830, "validity", getString(2131888852)));
        ((TextView) r37.findViewById(2131368819)).setVisibility(0);
        TextView r2 = (TextView) r37.findViewById(2131368819);
        Context r4 = getContext();
        if (this.u == 1) goto L5;
        int r7 = 2131888850;
    L6:
        Context r8 = getContext();
        if (r8 == null) goto L9;
        String r9 = r8.getString(m.a(3));
    L10:
        r2.setText(xo5.a.c(r4, r7, "validity", r9));
        ((LinearLayout) r37.findViewById(2131364623)).setVisibility(0);
        ((BaseTitleBar) r37.findViewById(2131388775)).setLeftClickListener(new b(this));
        r37.findViewById(2131365115).setOnClickListener(new c(this));
        r37.findViewById(2131369397).setOnClickListener(new d(this));
        DocFreshNessAdapter r3 = new DocFreshNessAdapter();
        this.k = r3;
        e r5 = new e(this);
        Intrinsics.checkNotNullParameter(r5, "clickListener");
        r3.a = r5;
        ArrayList<i> r6 = this.l;
        String r12 = ea0(7);
        int r10 = pj5.b.a;
        r6.add(new i(false, r12, false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 7))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 7), 485));
        this.l.add(new i(false, ea0(30), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 30))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 30), 485));
        i r11 = new i(true, ea0(90), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 90))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 90), 484);
        this.p = r11;
        this.l.add(r11);
        this.l.add(new i(false, ea0(180), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 180))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 180), 485));
        this.l.add(new i(false, ea0(365), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 365))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 365), 485));
        i r13 = new i(false, getString(2131888854), false, true, null, false, 0, true, 0, 757);
        this.s = r13;
        r13.j = pj5.b.a(new Date(System.currentTimeMillis()), Integer.valueOf(this.t)).getTime();
        this.l.add(this.s);
        ArrayList<i> r14 = this.l;
        this.l = r14;
        DocFreshNessAdapter r15 = this.k;
        if (r15 == null) goto L13;
        r15.setNewData(r14);
    L13:
        r37.findViewById(2131384071).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        r37.findViewById(2131384071).setAdapter(this.k);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.n, this.o, getDialog());
        ga0();
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = 2131888834;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561257, r3, false);
    }
}
