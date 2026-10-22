package com.bytedance.ee.bear.more.fresh;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.n;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pj5.i;
import pj5.j;
import pj5.k;
import pj5.l;
import pj5.m;
import pj5.o;
import pj5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002J\u001a\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000eH\u0003J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u000eH\u0007J \u0010-\u001a\u00020\u00172\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002J\u0018\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J(\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u000208H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/more/fresh/DocFreshNessFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", "objToken", "", "objType", "", WikiFolderPushPlugin.DATA, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessEntity;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessAdapter;", "peekHeight", "", "minTime", "seconds", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "initPeekHeight", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "buildRightAction", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "onViewCreated", "view", "updateStatus", "entity", "updateSelected", "checkSelected", "buildData", "addWatermark", "showDialog", "clickListener", "Landroid/content/DialogInterface$OnClickListener;", "dismissListener", "descMessage", "freshStatus", "onDestroy", "isSupportScreenLandscape", "", "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocFreshNessFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int s = 0;
    public final CompositeDisposable k;
    public DocMetaInfo l;
    public String m;
    public int n;
    public ArrayList<i> o;
    public DocFreshNessAdapter p;
    public final double q;
    public final int r;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ DocFreshNessFragment c;

        public b(DocFreshNessFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements p {
        public final /* synthetic */ DocFreshNessFragment a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ DocFreshNessFragment a;
            public final /* synthetic */ i b;

            public a(DocFreshNessFragment r1, i r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                DocFreshNessFragment.ea0(this.a, this.b);
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
            }
        }

        public c(DocFreshNessFragment r1) {
            this.a = r1;
        }

        @Override // pj5.p
        public final void a(i r9) {
            Intrinsics.checkNotNullParameter(r9, "entity");
            if (r9.c == false) goto L12;
            DocFreshNessFragment r0 = this.a;
            o r10 = new o(r0.n, r0.m, false, r0.l.getFreshInfo().getDeadlineTime(), this.a.l.getFreshInfo().getFreshState());
            int r1 = DocDynamicChampionFragment.w;
            DocDynamicChampionFragment.a.a(this.a.requireActivity(), r10);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L16;
            d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L16:
            return;
        L12:
            DocFreshNessFragment r2 = this.a;
            DocFreshNessFragment.da0(r2, new a(r2, r9), b.a, r9.b, r9.h);
        }

        @Override // pj5.p
        public final void b(i r9) {
            Intrinsics.checkNotNullParameter(r9, "entity");
            DocFreshNessFragment r0 = this.a;
            o r10 = new o(r0.n, r0.m, true, r0.l.getFreshInfo().getDeadlineTime(), this.a.l.getFreshInfo().getFreshState());
            int r1 = DocDynamicChampionFragment.w;
            DocDynamicChampionFragment.a.a(this.a.requireActivity(), r10);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r11 = DialogFragmentLancet.sLastShowStack;
            if (r11 == null) goto L12;
            d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    public DocFreshNessFragment() {
        this.k = new CompositeDisposable();
        this.l = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);
        this.m = "";
        this.n = -1;
        this.o = new ArrayList();
        this.q = 0.5d;
        this.r = CCMLynxCardView.ViewType.BANNER;
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
        tt5.a.e("DocFreshNessFragment", "init peek height", th, false);
    }

    public final void onDestroy() {
        super.onDestroy();
        this.k.clear();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        fa0();
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        fa0();
    }

    public final void onCreate(Bundle r47) {
        super.onCreate(r47);
        Bundle r1 = getArguments();     // Catch: Exception -> L13
        if (r1 == null) goto L17;
        DocMetaInfo r2 = r1.getSerializable("extra_meta");     // Catch: Exception -> L13
        if ((r2 instanceof DocMetaInfo) == false) goto L8;
        DocMetaInfo r3 = r2;     // Catch: Exception -> L13
    L9:
        if (r3 != null) goto L11;
        r3 = new DocMetaInfo(null, false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -1, 63, null);     // Catch: Exception -> L13
    L11:
        this.l = r3;     // Catch: Exception -> L13
        this.m = r1.getString("extra_token", "");     // Catch: Exception -> L13
        this.n = r1.getInt("extra_type");     // Catch: Exception -> L13
        return;
    L8:
        r3 = null;
        goto L9
    L17:
        return;
    L13:
        tt5.a.d("DocFreshNessFragment", "parse error");
    }

    public static final void ea0(DocFreshNessFragment r6, i r7) {
        r6.getClass();
        int r0 = r7.h;
        ConcurrentHashMap<String, ArrayList<qj5.b>> r1 = m.a;
        if (r0 != 0) goto L5;
        String r2 = "cancle_mark";
    L21:
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L18
        r3.put("click", r2);     // Catch: Exception -> L18
        r3.put("role", "up_edit");     // Catch: Exception -> L18
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).i("ccm_space_freshness_card_click", r3);     // Catch: Exception -> L18
    L19:
        CompositeDisposable r4 = r6.k;
        int r5 = mj5.b.a;
        r4.add(mj5.b.a.a(r6.m, r6.n, r7.h, -1).subscribe(new k(r7, r6), new l(r6)));
        return;
    L18:
        tt5.a.d("MoreAnalytic", "");
        goto L19
    L5:
        if (r0 != 1) goto L7;
        r2 = "maybeOutdated";
        goto L21
    L7:
        if (r0 != 2) goto L9;
        r2 = "mark_overdue";
        goto L21
    L9:
        if (r0 == 3) goto L11;
        r2 = "";
        goto L21
    L11:
        r2 = "newest";
        goto L21
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r20, r21);
        ((BaseTitleBar) r20.findViewById(2131388775)).setTitle(2131888857);
        ((BaseTitleBar) r20.findViewById(2131388775)).setLeftClickListener(new b(this));
        ((TextView) r20.findViewById(2131368819)).setVisibility(0);
        ((TextView) r20.findViewById(2131368819)).setText(getString(2131888858));
        BaseTitleBar r2 = (BaseTitleBar) r20.findViewById(2131388775);
        if (this.l.getFreshInfo().getFreshState() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        int r6 = 2131106611;
    L9:
        View r4 = r2.a(new BaseTitleBar.e(getString(2131887658), r6), true);
        if (r4 == null) goto L12;
        r4.setOnClickListener(new j(r3, this));
    L12:
        DocFreshNessAdapter r5 = new DocFreshNessAdapter();
        this.p = r5;
        c r7 = new c(this);
        Intrinsics.checkNotNullParameter(r7, "clickListener");
        r5.a = r7;
        ArrayList<i> r8 = this.o;
        Context r9 = getContext();
        if (r9 == null) goto L18;
        String r10 = r9.getString(2131888841);
        if (r10 == null) goto L18;
        String r11 = r10;
    L19:
        r8.add(new i(false, r11, false, false, null, false, 2, false, 0, 893));
        ArrayList<i> r12 = this.o;
        Context r13 = getContext();
        if (r13 == null) goto L25;
        String r14 = r13.getString(2131888852);
        if (r14 == null) goto L25;
        String r15 = r14;
    L26:
        StringBuilder r16 = new StringBuilder();
        r16.append(getString(2131888856));
        r16.append(' ');
        int r17 = pj5.b.a;
        r16.append(pj5.b.b(new Date(this.l.getFreshInfo().getDeadlineTime() * ((long) this.r))));
        String r18 = r16.toString();
        if (this.l.getFreshInfo().getDeadlineTime() <= 0) goto L29;
        boolean r19 = true;
    L30:
        r12.add(new i(false, r15, true, r19, r18, true, 3, false, 0, 801));
        ArrayList<i> r22 = this.o;
        this.o = r22;
        Iterator<i> r23 = r22.iterator();
    L32:
        if (r23.hasNext() == false) goto L41;
        i r24 = r23.next();
        if (r24.h != 1) goto L39;
        if (this.l.getFreshInfo().getFreshState() == 1) goto L39;
        r23.remove();
    L39:
        if (r24.h != this.l.getFreshInfo().getFreshState()) goto L32;
        r24.a = true;
        goto L32
    L41:
        DocFreshNessAdapter r25 = this.p;
        if (r25 == null) goto L44;
        r25.setNewData(this.o);
    L44:
        r20.findViewById(2131384071).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        r20.findViewById(2131384071).setAdapter(this.p);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.m, this.n, getDialog());
        return;
    L29:
        r19 = false;
    L25:
        r15 = "";
    L18:
        r11 = "";
        goto L19
    L8:
        r6 = 2131106622;
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561257, r3, false);
    }

    public static final void da0(DocFreshNessFragment r4, DialogInterface.OnClickListener r5, DialogInterface.OnClickListener r6, String r7, int r8) {
        String r0 = xo5.a.c(r4.getContext(), 2131888830, "validity", r7);
        String r1 = xo5.a.c(r4.getContext(), 2131888829, "validity", r7);
        if (r8 != 0) goto L6;
        r0 = r4.getString(2131888826);
        r1 = xo5.a.c(r4.getContext(), 2131888825, "validity", r7);
    L6:
        if (r8 != 2) goto L8;
        r1 = "";
    L8:
        Context r9 = r4.getContext();
        if (r9 == null) goto L23;
        Intrinsics.checkNotNullParameter(r9, "context");
        UDDialogBuilder r10 = new UDDialogBuilder(r9);
        r10.autoDismiss(true);
        Intrinsics.checkNotNullParameter(r0, "value");
        r10.title(r0);
        Intrinsics.checkNotNullParameter(r1, "value");
        r10.message(r1);
        BearUDDialogBuilder.ActionBottomOrientation r11 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r11, "value");
        if (r11 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L13;
        UDBaseDialogBuilder.ActionBottomOrientation r12 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L14:
        r10.actionButtonOrientation(r12);
        r10.addActionButton(2131391777, 2131887800, r5);
        r10.addActionButton(2131391778, 2131887170, r6);
        r10.cancelOnTouchOutside(false);
        UDDialog r13 = r10.build();
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r13);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L18:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        return;
    L13:
        r12 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
        goto L14
    }
}
