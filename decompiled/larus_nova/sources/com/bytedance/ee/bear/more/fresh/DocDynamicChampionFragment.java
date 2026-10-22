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
import androidx.recyclerview.widget.RecyclerView;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.timepicker.impl.action.UDTimePickerBuilder;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010,\u001a\u00020\u001bH\u0002J\u0006\u0010-\u001a\u00020\u001bJ\b\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\u000eH\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0003J\b\u00105\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0007J\b\u00107\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/more/fresh/DocDynamicChampionFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "adapter", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessAdapter;", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/more/fresh/DocFreshNessEntity;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "objToken", "", "objType", "", "selectEntity", "peekHeight", "", "deadlineTime", "", "isCustomer", "", "customEntity", IPortraitService.TYPE_ONE_PORTRAIT, "freshStatus", "seconds", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", WidgetCostModule.TYPE_ON_START, "initPeekHeight", "setDoneBtn", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onViewCreated", "view", "addWatermark", "openTimePick", "getDescText", "addData", "buildData", "getNumber", BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, "updateStatus", "entity", "isSupportScreenLandscape", "updateSelected", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "features-more_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDynamicChampionFragment extends BaseBottomSheetDialogFragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f234512w = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DocFreshNessAdapter f234513k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<i> f234514l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f234515m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f234516n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f234517o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i f234518p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final double f234519q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f234520r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public i f234521s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f234522t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f234523u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f234524v;

    public static final class a {
        public static void a(FragmentActivity r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "param");
            DocDynamicChampionFragment r102 = new DocDynamicChampionFragment();
            Bundle r103 = new Bundle();
            r103.putString("extra_token", r101.f529498b);
            r103.putInt("extra_type", r101.f529497a);
            r103.putBoolean("extra_customer", r101.f529499c);
            r103.putLong("extra_time", r101.f529500d);
            r103.putInt("extra_status", r101.f529501e);
            r102.setArguments(r103);
            FragmentManager r104 = r100.getSupportFragmentManager();
            LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, "DocDynamicChampionFragment", r105);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r102, r105) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r102.show(r104, "DocDynamicChampionFragment");
            return;
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DocDynamicChampionFragment f234525c;

        public b(DocDynamicChampionFragment r100) {
            this.f234525c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f234525c.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDynamicChampionFragment f234526a;

        public c(DocDynamicChampionFragment r100) {
            this.f234526a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f234526a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDynamicChampionFragment f234527a;

        public d(DocDynamicChampionFragment r100) {
            this.f234527a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            DocDynamicChampionFragment r101 = this.f234527a;
            i r102 = r101.f234518p;
            CompositeDisposable r103 = r101.f234515m;
            int r104 = mj5.b.f514253a;
            r103.add(mj5.b.a.a(r101.f234516n, r101.f234517o, 3, r102.f529486j).subscribe(new pj5.e(r101), new f(r101)));
        }
    }

    public static final class e implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocDynamicChampionFragment f234528a;

        @Override // pj5.p
        public final void b(i r100) {
            Intrinsics.checkNotNullParameter(r100, "entity");
        }

        public e(DocDynamicChampionFragment r100) {
            this.f234528a = r100;
        }

        @Override // pj5.p
        public final void a(i r100) {
            Intrinsics.checkNotNullParameter(r100, "entity");
            DocDynamicChampionFragment r101 = this.f234528a;
            r101.f234518p = r100;
            if (r100.f529485i == false) goto L8;
            Context r102 = r101.getContext();
            if (r102 == null) goto L10;
            pj5.a r103 = new pj5.a(r102, r101.f234521s.f529486j);
            r103.f529463m = new pj5.d(r101);
            new UDTimePickerBuilder(r102).controller(r103).show();
            return;
        L10:
            return;
        L8:
            r101.ha0(r100);
        }
    }

    static {
    }

    public DocDynamicChampionFragment() {
        this.f234514l = new ArrayList();
        this.f234515m = new CompositeDisposable();
        this.f234516n = "";
        this.f234517o = -1;
        this.f234518p = new i(false, null, false, false, null, false, 0, false, 0, 1023);
        this.f234519q = 0.5d;
        this.f234520r = -1;
        this.f234521s = new i(false, null, false, false, null, false, 0, false, 0, 1023);
        this.f234522t = 1;
        this.f234523u = -1;
        this.f234524v = 1000;
    }

    public final void ga0() {
        int r100 = pj5.b.f529469a;
        long r101 = this.f234520r * ((long) this.f234524v);
        long r102 = this.f234518p.f529486j;
        Calendar r103 = Calendar.getInstance();
        Calendar r104 = Calendar.getInstance();
        r103.setTimeInMillis(r101);
        r104.setTimeInMillis(r102);
        int r105 = r103.get(1);
        int r106 = r103.get(2);
        int r107 = r103.get(5);
        int r108 = r104.get(1);
        int r109 = r104.get(2);
        if (r107 != r104.get(5)) goto L7;
        if (r105 != r108) goto L7;
        if (r106 != r109) goto L7;
        boolean r110 = true;
    L8:
        UDButton r111 = null;
        if (r110 == false) goto L16;
        View r112 = getView();
        if (r112 == null) goto L13;
        r111 = (UDButton) r112.findViewById(R.id.doneBtn);
    L13:
        if (r111 == null) goto L22;
        r111.setEnabled(false);
        return;
    L22:
        return;
    L16:
        View r113 = getView();
        if (r113 == null) goto L19;
        r111 = (UDButton) r113.findViewById(R.id.doneBtn);
    L19:
        if (r111 == null) goto L23;
        r111.setEnabled(true);
        return;
    L23:
        return;
    L7:
        r110 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment
    public final boolean ba0() {
        return !ku5.c.k(getActivity());
    }

    public final void fa0() {
        Dialog r100 = getDialog();     // Catch: Throwable -> L11
        if (r100 == null) goto L17;
        Window r101 = r100.getWindow();     // Catch: Throwable -> L11
        if (r101 == null) goto L17;
        View r102 = r101.getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r103 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");     // Catch: Throwable -> L11
    L13:
        if (r102 == null) goto L17;
        FrameLayout r104 = (FrameLayout) r102.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L11
        if (r104 == null) goto L17;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();     // Catch: Throwable -> L11
    L19:
        if ((r105 instanceof CoordinatorLayout.LayoutParams) == false) goto L30;
        CoordinatorLayout.Behavior r106 = ((CoordinatorLayout.LayoutParams) r105).getBehavior();     // Catch: Throwable -> L11
        if ((r106 instanceof BottomSheetBehavior) == true) goto L23;
        return;
    L23:
        if (n.D(getActivity()) == false) goto L25;
        ((BottomSheetBehavior) r106).setPeekHeight((int) (((double) n.p(getActivity())) * this.f234519q));     // Catch: Throwable -> L11
        return;
    L25:
        ((BottomSheetBehavior) r106).setPeekHeight((int) (((double) n.p(getActivity())) * 1.0d));     // Catch: Throwable -> L11
        return;
    L30:
        return;
    L17:
        r105 = null;
    L11:
        th = move-exception;
        tt5.a.e("DocDynamicChampionFragment", "init peek height", th, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f234515m.clear();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        fa0();
    }

    public final String da0(String r100) {
        StringBuilder r101 = new StringBuilder();
        Context r102 = getContext();
        if (r102 == null) goto L5;
        String r103 = r102.getString(R.string.LarkCCM_CM_Verify_ValidUntil2_Title);
    L6:
        r101.append(r103);
        r101.append(' ');
        r101.append(r100);
        return r101.toString();
    L5:
        r103 = null;
        goto L6
    }

    public final String ea0(int r100) {
        Context r101 = getContext();
        if (r101 != null) goto L6;
        r101 = eu5.b.f474075a;
    L6:
        return xo5.a.c(r101, R.string.LarkCCM_CM_Verify_ValidityPeriod_Days_Option, "num", String.valueOf(r100));
    }

    public final void ha0(i r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        Iterator<T> r101 = this.f234514l.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((i) r101.next()).f529477a = false;
        goto L4
    L6:
        r100.f529477a = true;
        DocFreshNessAdapter r102 = this.f234513k;
        if (r102 == null) goto L9;
        r102.notifyDataSetChanged();
    L9:
        ga0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        fa0();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();     // Catch: Exception -> L7
        if (r101 == null) goto L11;
        this.f234516n = r101.getString("extra_token", "");     // Catch: Exception -> L7
        this.f234517o = r101.getInt("extra_type");     // Catch: Exception -> L7
        this.f234520r = r101.getLong("extra_time");     // Catch: Exception -> L7
        r101.getBoolean("extra_customer");     // Catch: Exception -> L7
        this.f234523u = r101.getInt("extra_status");     // Catch: Exception -> L7
        return;
    L11:
        return;
    L7:
        tt5.a.d("DocDynamicChampionFragment", "arguments parse error");
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r310, Bundle r311) {
        Intrinsics.checkNotNullParameter(r310, "view");
        super.onViewCreated(r310, r311);
        ((BaseTitleBar) r310.findViewById(R.id.titleBar)).setTitle(xo5.a.c(getContext(), R.string.LarkCCM_CM_Verify_Confirm_Title, "validity", getString(R.string.LarkCCM_CM_Verify_UpToDate_Radio)));
        ((TextView) r310.findViewById(R.id.desc)).setVisibility(0);
        TextView r100 = (TextView) r310.findViewById(R.id.desc);
        Context r101 = getContext();
        if (this.f234523u == 1) goto L5;
        int r102 = R.string.LarkCCM_CM_Verify_SetPeriod_Text;
    L6:
        Context r103 = getContext();
        if (r103 == null) goto L9;
        String r104 = r103.getString(m.a(3));
    L10:
        r100.setText(xo5.a.c(r101, r102, "validity", r104));
        ((LinearLayout) r310.findViewById(R.id.btnLayout)).setVisibility(0);
        ((BaseTitleBar) r310.findViewById(R.id.titleBar)).setLeftClickListener(new b(this));
        ((UDButton) r310.findViewById(R.id.cancelBtn)).setOnClickListener(new c(this));
        ((UDButton) r310.findViewById(R.id.doneBtn)).setOnClickListener(new d(this));
        DocFreshNessAdapter r105 = new DocFreshNessAdapter();
        this.f234513k = r105;
        e r106 = new e(this);
        Intrinsics.checkNotNullParameter(r106, "clickListener");
        r105.f234529a = r106;
        ArrayList<i> r107 = this.f234514l;
        String r110 = ea0(7);
        int r108 = pj5.b.f529469a;
        r107.add(new i(false, r110, false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 7))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 7), TTVideoEngineInterface.PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS));
        this.f234514l.add(new i(false, ea0(30), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 30))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 30), TTVideoEngineInterface.PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS));
        i r109 = new i(true, ea0(90), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 90))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 90), 484);
        this.f234518p = r109;
        this.f234514l.add(r109);
        this.f234514l.add(new i(false, ea0(180), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), 180))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), 180), TTVideoEngineInterface.PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS));
        ArrayList<i> r111 = this.f234514l;
        Integer r112 = Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME);
        r111.add(new i(false, ea0(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME), false, true, da0(pj5.b.b(pj5.b.a(new Date(System.currentTimeMillis()), r112))), false, 0, false, pj5.b.c(new Date(System.currentTimeMillis()), r112), TTVideoEngineInterface.PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS));
        i r113 = new i(false, getString(R.string.LarkCCM_CM_Verify_ValidityPeriod_Custom_Option), false, true, null, false, 0, true, 0, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAYER_REQ_OFFSET);
        this.f234521s = r113;
        r113.f529486j = pj5.b.a(new Date(System.currentTimeMillis()), Integer.valueOf(this.f234522t)).getTime();
        this.f234514l.add(this.f234521s);
        ArrayList<i> r114 = this.f234514l;
        this.f234514l = r114;
        DocFreshNessAdapter r115 = this.f234513k;
        if (r115 == null) goto L13;
        r115.setNewData(r114);
    L13:
        ((RecyclerView) r310.findViewById(R.id.recyclerView)).setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        ((RecyclerView) r310.findViewById(R.id.recyclerView)).setAdapter(this.f234513k);
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.f234516n, this.f234517o, getDialog());
        ga0();
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = R.string.LarkCCM_CM_Verify_MarkAsUpdated_NotifyAndSetPeriod_Descrip;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.fresh_ness_fragment, r101, false);
    }
}
