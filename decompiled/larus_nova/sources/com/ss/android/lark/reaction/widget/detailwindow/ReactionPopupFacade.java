package com.ss.android.lark.reaction.widget.detailwindow;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.detailwindow.pager.ReactionListFragment;
import com.ss.android.lark.reaction.widget.detailwindow.scroller.ScrollableLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n2c.e;
import n2c.f;
import n2c.h;
import n2c.i;
import n2c.j;
import n2c.k;
import n2c.l;
import n2c.o;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionPopupFacade extends DialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f439195j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f439196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n2c.d f439197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f439198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f439199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f439200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DialogInterface.OnDismissListener f439201i;

    public class a implements com.ss.android.lark.reaction.widget.detailwindow.a.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReactionPopupFacade f439202a;

        public final void a() {
            ReactionPopupFacade r100 = this.f439202a;
            int r101 = ReactionPopupFacade.f439195j;
            r100.getClass();
        }

        public a(ReactionPopupFacade r100) {
            this.f439202a = r100;
        }

        public final void b(String r100) {
            c r101 = this.f439202a.f439198f;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }
    }

    public interface b {
    }

    public interface c {
        void a(String r100);
    }

    public interface d {
        void a(int r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        n2c.d r100 = this.f439197e;
        if (r100 == null) goto L5;
        r100.f516842a.getClass();
        r100.f516843b.getClass();
    L5:
        super.onDestroyView();
    }

    public ReactionPopupFacade() {
        this.f439200h = new a(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    public final void T90(List<ReactionDetailViewModel> r100) {
        n2c.d r101 = this.f439197e;
        if (r101 == null) goto L17;
        n2c.c r102 = (n2c.c) r101.f516842a;
        r102.getClass();
        if (r100 == null) goto L7;
        r102.f516839a = new ArrayList(r100);
    L7:
        List<o2c.a> r103 = ((n2c.c) r101.f516842a).a();
        n2c.b r104 = r101.f516843b;
        String r105 = ((n2c.c) r101.f516842a).f516840b;
        final com.ss.android.lark.reaction.widget.detailwindow.a r106 = (com.ss.android.lark.reaction.widget.detailwindow.a) r104;
        r106.f439218o = r103;
        Iterator r107 = ((ArrayList) r103).iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        ReactionListFragment r108 = ((o2c.a) r107.next()).f521822a;
        r108.f439244h = r106.f439223t;
        r108.f439245i = r106.f439224u;
        goto L9
    L11:
        r106.f439219p = r105;
        if (r106.f439211h.getAdapter() == null) goto L14;
        r106.f439211h.getAdapter().notifyDataSetChanged();
    L14:
        r106.f439222s.f565128a.notifyChanged();
        r106.f439211h.post(new l(r106));
        return;
    }

    public final void U90(FragmentManager r100) {
        int r101 = DesktopUtil.f420394a;
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "ReactionPopupFacade", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        show(r100, "ReactionPopupFacade");
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ReactionScrollableDialogStyle);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        DialogInterface.OnDismissListener r101 = this.f439201i;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.onDismiss(r100);     // Catch: Throwable -> L8
    L5:
        super.onDismiss(r100);     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        final com.ss.android.lark.reaction.widget.detailwindow.a r102 = new com.ss.android.lark.reaction.widget.detailwindow.a(this.f439200h, getContext(), this);
        n2c.c r103 = new n2c.c(getArguments());
        this.f439197e = new n2c.d(r103, r102);
        a r104 = (a) r102.f439215l;
        r102.f439204a = (ScrollableLayout) r104.f439202a.f439196d.findViewById(R.id.scrollable_layout);
        r102.f439205b = r104.f439202a.f439196d.findViewById(R.id.reaction_popup_placeholder);
        r102.f439206c = (ViewGroup) r104.f439202a.f439196d.findViewById(R.id.reaction_facade_title);
        r102.f439207d = (ViewGroup) r104.f439202a.f439196d.findViewById(R.id.reaction_facade_title_wrapper);
        r102.f439208e = r104.f439202a.f439196d.findViewById(R.id.reaction_facade_title_masker);
        r102.f439209f = (ViewGroup) r104.f439202a.f439196d.findViewById(R.id.reaction_facade_body);
        r102.f439210g = (MagicIndicator) r104.f439202a.f439196d.findViewById(R.id.reaction_facade_indicator);
        r102.f439211h = (ViewPager) r104.f439202a.f439196d.findViewById(R.id.reaction_facade_vp);
        r102.f439212i = r104.f439202a.f439196d.findViewById(R.id.reaction_facade_close);
        r102.f439213j = (ViewGroup) r104.f439202a.f439196d.findViewById(R.id.reaction_facade_title_desktop);
        r102.f439214k = r104.f439202a.f439196d.findViewById(R.id.reaction_facade_close_desktop);
        int r105 = DesktopUtil.f420394a;
        r102.f439213j.setVisibility(8);
        r102.f439207d.setVisibility(0);
        r102.f439204a.getViewTreeObserver().addOnGlobalLayoutListener(new com.ss.android.lark.reaction.widget.detailwindow.c(r102));
        r102.f439204a.setDraggableView(r102.f439207d);
        r102.f439204a.setCanScrollVerticallyDelegate(new h(r102));
        r102.f439204a.setOnFlingOverListener(new i(r102));
        ScrollableLayout r106 = r102.f439204a;
        com.ss.android.lark.reaction.widget.detailwindow.scroller.i r107 = new j(r102);
        ((ArrayList) r106.f439269b).add(r107);
        r102.f439205b.setOnClickListener(new k(r102));
        r102.f439212i.setOnClickListener(new e(r102));
        r102.f439211h.addOnPageChangeListener(new com.ss.android.lark.reaction.widget.detailwindow.b(r102));
        List<o2c.a> r108 = r103.a();
        String r109 = r103.f516840b;
        r102.f439218o = r108;
        Iterator r110 = ((ArrayList) r108).iterator();
    L4:
        if (r110.hasNext() == false) goto L6;
        ReactionListFragment r111 = ((o2c.a) r110.next()).f521822a;
        r111.f439244h = r102.f439223t;
        r111.f439245i = r102.f439224u;
        goto L4
    L6:
        r102.f439219p = r109;
        r102.f439211h.setAdapter(new o(r102, r102.f439217n.getChildFragmentManager()));
        wuc.a r112 = new wuc.a(r102.f439216m);
        r112.setAdapter(r102.f439222s);
        r102.f439210g.setNavigator(r112);
        MagicIndicator r113 = r102.f439210g;
        r102.f439211h.addOnPageChangeListener(new tuc.c(r113));
        r102.f439211h.post(new f(r102));
    }

    public static ReactionPopupFacade S90(List<ReactionDetailViewModel> r100, String r101, boolean r102) {
        ReactionPopupFacade r103 = new ReactionPopupFacade();
        Bundle r104 = new Bundle();
        r104.putSerializable("reaction_info_list", new ArrayList(r100));
        r104.putString("reaction_opened_type", r101);
        r104.putBoolean("key_need_loading", r102);
        r103.setArguments(r104);
        return r103;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.layout_reaction_detail_facade, r101, false);
        this.f439196d = r103;
        return r103;
    }
}
