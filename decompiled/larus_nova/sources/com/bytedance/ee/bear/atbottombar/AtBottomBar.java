package com.bytedance.ee.bear.atbottombar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.atfinder.AtCheckBoxViewModel;
import com.bytedance.ee.bear.atfinder.AtFinderResultList;
import com.bytedance.ee.bear.atfinder.AtMentionListAdapter;
import com.bytedance.ee.bear.bean.MentionPanelType;
import com.bytedance.ee.bear.edit.component.document.at.AtPanelFragment;
import com.bytedance.ee.bear.widget.AtFinderView;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import com.larus.nova.R;
import com.ss.android.lark.utils.Contexts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ln4.g;
import ln4.k;
import ln4.m;
import net.lucode.hackware.magicindicator.MagicIndicator;
import sa5.v;
import sa5.w;

/* JADX INFO: loaded from: classes15.dex */
public class AtBottomBar extends FrameLayout implements w, com.bytedance.ee.bear.widget.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f206290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f206291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.atbottombar.b> f206292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f206293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f206294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f206295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f206296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v f206297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public kn4.k f206298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<m> f206299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public bo4.c f206300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f206301l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ee.bear.atbottombar.b.a f206302m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AtCheckBoxViewModel f206303n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f206304o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f206305p;

    public class a extends xuc.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtBottomBar f206306b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.atbottombar.AtBottomBar$a$a, reason: collision with other inner class name */
        public class C2972a extends t {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f206307c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f206308d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r100) {
                this.f206308d.f206306b.f206291b.getViewPager().setCurrentItem(this.f206307c, true);
            }

            public C2972a(a r100, int r101) {
                this.f206308d = r100;
                this.f206307c = r101;
                super(300);
            }
        }

        @Override // xuc.a
        public final xuc.c b(Context r100) {
            return null;
        }

        @Override // xuc.a
        public final int a() {
            return this.f206306b.f206299j.size();
        }

        public a(AtBottomBar r100) {
            this.f206306b = r100;
        }

        @Override // xuc.a
        public final xuc.d c(Context r100, int r101) {
            avc.b r102 = new avc.b(this.f206306b.f206290a);
            r102.setContentView(R.layout.at_indicator_item);
            View r103 = r102.findViewById(R.id.at_bar_item);
            ImageView r104 = (ImageView) r102.findViewById(R.id.at_bar_icon);
            if (r101 >= this.f206306b.f206299j.size()) goto L5;
            r104.setImageResource(((m) ListProtector.get(this.f206306b.f206299j, r101)).f510023a);
        L5:
            r103.setOnClickListener(new C2972a(this, r101));
            r102.setOnPagerTitleChangeListener(new b(this.f206306b, r104));
            return r102;
        }
    }

    public class b implements avc.b.InterfaceC0238b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f206309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtBottomBar f206310b;

        @Override // avc.b.InterfaceC0238b
        public final void onEnter() {
        }

        @Override // avc.b.InterfaceC0238b
        public final void onLeave() {
        }

        @Override // avc.b.InterfaceC0238b
        public final void b() {
            this.f206309a.setSelected(false);
        }

        @Override // avc.b.InterfaceC0238b
        public final void a(int r100) {
            k r101 = this.f206310b.f206293d;
            if (r101 == null) goto L5;
            r101.f510015b = r100;
        L5:
            this.f206309a.setSelected(true);
        }

        public b(AtBottomBar r100, View r101) {
            this.f206310b = r100;
            this.f206309a = r101;
        }
    }

    public class c implements com.bytedance.ee.bear.atfinder.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.atfinder.d f206311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtBottomBar f206312b;

        @Override // com.bytedance.ee.bear.atfinder.d
        public final void b() {
            if (this.f206312b.f206294e == true) goto L5;
            tt5.a.b("AtFinderCallbackWrapper", "onClosedView: atBottomBar is already closed");
            return;
        L5:
            if (this.f206311a == null) goto L13;
            tt5.a.h("AtFinderCallbackWrapper", "onClosedView: isCloseImmediately = " + this.f206312b.f206295f);
            this.f206311a.b();
            AtBottomBar r100 = this.f206312b;
            boolean r101 = r100.f206295f;
            if (r100.f206294e == false) goto L12;
            v r102 = r100.f206297h;
            if (r102 == null) goto L11;
            r102.b(r100);
        L11:
            r100.f206291b.hide(r101);
            return;
        L12:
            tt5.a.k("AtBottomBar", "hide atBottomBar fail: isAnimStart = false");
            return;
        L13:
            tt5.a.k("AtFinderCallbackWrapper", "onClosedView: atFinderDataCallback is null");
        }

        @Override // com.bytedance.ee.bear.atfinder.d
        public final void c(String r100) {
            tt5.a.h("AtFinderCallbackWrapper", "onExistResult: ");
            k r101 = this.f206312b.f206293d;
            if (r101 == null) goto L8;
            Iterator r102 = ((ArrayList) r101.f510014a).iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            ((com.bytedance.ee.bear.atfinder.c) r102.next()).c(false);
            goto L6
        L10:
            return;
        }

        @Override // com.bytedance.ee.bear.atfinder.d
        public final void d(String r100) {
            if (r100 != null) goto L6;
            tt5.a.k("AtFinderCallbackWrapper", "onEmptyResult, keyword is null");
            return;
        L6:
            com.bytedance.ee.bear.atfinder.d r101 = this.f206311a;
            if (r101 == null) goto L9;
            r101.d(r100);
            return;
        L9:
            tt5.a.k("AtFinderCallbackWrapper", "onEmptyResult: atFinderDataCallback is null");
        }

        public c(AtBottomBar r100, com.bytedance.ee.bear.atfinder.d r101) {
            this.f206312b = r100;
            this.f206311a = r101;
        }

        @Override // com.bytedance.ee.bear.atfinder.d
        public final void a(AtFinderResultList r100, boolean r101) {
            if (this.f206311a == null) goto L11;
            tt5.a.b("AtFinderCallbackWrapper", "onSelectData");
            this.f206311a.a(r100, this.f206312b.f206303n.isCheckboxSelected());
            AtBottomBar r102 = this.f206312b;
            if (r102.f206294e == false) goto L10;
            v r103 = r102.f206297h;
            if (r103 == null) goto L9;
            r103.b(r102);
        L9:
            r102.f206291b.hide(false);
            return;
        L10:
            tt5.a.k("AtBottomBar", "hide atBottomBar fail: isAnimStart = false");
            return;
        L11:
            tt5.a.k("AtFinderCallbackWrapper", "onSelectData: atFinderDataCallback is null");
        }
    }

    public class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f206313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f206314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ViewPager f206315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UDTabLayout f206316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CommonActionPanelLayout f206317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f206318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f206319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f206320h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f206321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f206322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ AtBottomBar f206323k;

        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f206324a;

            public a(d r100) {
                this.f206324a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                this.f206324a.f206323k.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                this.f206324a.f206323k.setVisibility(8);
            }
        }

        public class b implements UDTabLayout.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f206325a;

            @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
            public final void a(com.larksuite.component.universe_design.tab.b r100) {
            }

            @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
            public final void c(com.larksuite.component.universe_design.tab.b r100) {
            }

            public b(d r100) {
                this.f206325a = r100;
            }

            @Override // com.larksuite.component.universe_design.tab.UDTabLayout.b
            public final void b(com.larksuite.component.universe_design.tab.b r100) {
                if (r100 == null) goto L12;
                int r101 = r100.f285297f;
                d r102 = this.f206325a;
                if (r102.f206317e != null) goto L6;
            L8:
                k r103 = this.f206325a.f206323k.f206293d;
                if (r103 == null) goto L13;
                r103.f510015b = r101;
                return;
            L13:
                return;
            L6:
                if (r101 >= r102.f206323k.f206299j.size()) goto L8;
                d r104 = this.f206325a;
                r104.f206317e.setTitle(((m) ListProtector.get(r104.f206323k.f206299j, r101)).f510024b);
                goto L8
            }
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final void a() {
            ViewGroup.LayoutParams r100 = this.f206315c.getLayoutParams();
            r100.height = c();
            this.f206323k.requestLayout();
        }

        public final int c() {
            pcb.a r100 = pcb.a.AbstractC7181a.b(Contexts.requireActivity(this.f206323k.f206290a));
            return Math.max(Math.min((((((n.t() - this.f206323k.f206304o) - this.f206321i) - r100.getVisibleKeyboardHeight()) - this.f206323k.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_20)) - this.f206319g) - this.f206320h, this.f206318f), this.f206322j);
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final View b() {
            return this.f206316d;
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final View getTitle() {
            return this.f206317e;
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final ViewPager getViewPager() {
            return this.f206315c;
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final void hide(boolean r100) {
            tt5.a.b("AtMiddleViewHolder", "hide atMiddleBar: immediately = " + r100);
            AtBottomBar r101 = this.f206323k;
            r101.f206294e = false;
            if (r100 == false) goto L5;
            r101.setVisibility(8);
            return;
        L5:
            ValueAnimator r102 = ValueAnimator.ofInt(new int[]{this.f206314b, 0}).setDuration(this.f206313a);
            r102.addUpdateListener(new ln4.d(this));
            AnimatorSet r103 = new AnimatorSet();
            r103.setDuration(this.f206313a);
            r103.play(r102);
            r103.addListener(new a(this));
            r103.start();
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final void show(int r100) {
            tt5.a.b("AtMiddleViewHolder", "show atMiddleBar");
            this.f206314b = c();
            this.f206323k.f206294e = true;
            if (this.f206315c.getAdapter() != null) goto L5;
        L7:
            this.f206315c.setCurrentItem(r100, false);
            this.f206323k.setVisibility(8);
            ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f206314b}).setDuration(this.f206313a);
            r101.addUpdateListener(new ln4.c(this));
            AnimatorSet r102 = new AnimatorSet();
            r102.setDuration(this.f206313a);
            r102.play(r101);
            r102.start();
            return;
        L5:
            if (r100 < this.f206315c.getAdapter().getCount()) goto L7;
            r100 = 0;
            goto L7
        }

        public d(AtBottomBar r100, View r101) {
            this.f206323k = r100;
            this.f206318f = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.at_viewpager_max_height2);
            this.f206319g = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_40);
            this.f206320h = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_48);
            this.f206321i = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_50);
            this.f206322j = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_40) + r100.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_66);
            ViewPager r102 = (ViewPager) r101.findViewById(R.id.vp_at);
            this.f206315c = r102;
            r102.setOffscreenPageLimit(2);
            r102.setAdapter(new AtCardAdapter(r100.f206292c));
            this.f206314b = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.at_viewpager_max_height);
            this.f206313a = r100.f206290a.getResources().getInteger(R.integer.at_finder_anim_duration);
            CommonActionPanelLayout r103 = (CommonActionPanelLayout) r101.findViewById(R.id.vp_at_title);
            this.f206317e = r103;
            UDTabLayout r104 = (UDTabLayout) r101.findViewById(R.id.new_at_bar);
            this.f206316d = r104;
            r104.addOnTabSelectedListener(new b(this));
            r104.setBottomDividerEnabled(true);
            int r105 = 0;
            r104.setIndicatorFullWidth(false);
            if (r103 != null) goto L5;
        L7:
            r103.setOnActionListener(new com.bytedance.ee.bear.atbottombar.a(this));
            r100.setVisibility(8);
            new UDTabLayoutCoordinator(r104, r102).attach();
            r104.removeAllTabs();
        L9:
            if (r105 >= this.f206323k.f206299j.size()) goto L11;
            com.larksuite.component.universe_design.tab.b r106 = this.f206316d.newTab();
            m r107 = (m) ListProtector.get(this.f206323k.f206299j, r105);
            r106.b(this.f206323k.f206290a.getString(r107.f510027e));
            this.f206316d.addTab(r106);
            r105 = r105 + 1;
            goto L9
        L11:
            return;
        L5:
            if (r100.f206299j.size() < 1) goto L7;
            r103.setTitle(((m) ListProtector.get(r100.f206299j, 0)).f510024b);
            goto L7
        }
    }

    public class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f206326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f206327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f206328c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ViewPager f206329d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LinearLayout f206330e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f206331f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ AtBottomBar f206332g;

        public class a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f206333a;

            public a(e r100) {
                this.f206333a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator r100) {
                this.f206333a.f206332g.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                this.f206333a.f206332g.setVisibility(8);
            }
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final View getTitle() {
            return null;
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final void a() {
            ViewGroup.LayoutParams r100 = this.f206329d.getLayoutParams();
            r100.height = c();
            this.f206332g.requestLayout();
        }

        public final int c() {
            if (this.f206332g.f206290a.getResources().getConfiguration().orientation != 2) goto L5;
            boolean r100 = true;
        L7:
            if (n.D(n.g(this.f206332g.f206290a)) == false) goto L9;
        L14:
            pcb.a r101 = pcb.a.AbstractC7181a.b((Activity) this.f206332g.f206290a);
            return Math.min(((n.t() - this.f206332g.f206304o) - r101.getVisibleKeyboardHeight()) - this.f206332g.f206290a.getResources().getDimensionPixelSize(R.dimen.space_kit_len_44), this.f206331f);
        L9:
            if (ku5.c.k(this.f206332g.f206290a) == false) goto L13;
            if (r100 == true) goto L14;
        L13:
            return this.f206331f;
        L5:
            r100 = false;
            goto L7
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final View b() {
            return this.f206330e;
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final ViewPager getViewPager() {
            return this.f206329d;
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final void hide(boolean r100) {
            tt5.a.b("AtViewHolder", "hide atBottomBar: immediately = " + r100);
            AtBottomBar r101 = this.f206332g;
            r101.f206294e = false;
            if (r100 == false) goto L5;
            r101.setVisibility(8);
            return;
        L5:
            ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f206330e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, this.f206327b});
            ValueAnimator r103 = ValueAnimator.ofInt(new int[]{this.f206328c, 0}).setDuration(this.f206326a);
            r103.addUpdateListener(new ln4.f(this));
            AnimatorSet r104 = new AnimatorSet();
            r104.setDuration(this.f206326a);
            r104.playTogether(new Animator[]{r102, r103});
            r104.addListener(new a(this));
            r104.start();
        }

        @Override // com.bytedance.ee.bear.atbottombar.AtBottomBar.f
        public final void show(int r100) {
            tt5.a.b("AtViewHolder", "show atBottomBar");
            this.f206328c = c();
            this.f206332g.f206294e = true;
            if (this.f206329d.getAdapter() != null) goto L5;
        L7:
            this.f206329d.setCurrentItem(r100, false);
            this.f206332g.setVisibility(0);
            ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f206330e, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{this.f206327b, 0.0f});
            ValueAnimator r102 = ValueAnimator.ofInt(new int[]{0, this.f206328c}).setDuration(this.f206326a);
            r102.addUpdateListener(new ln4.e(this));
            AnimatorSet r103 = new AnimatorSet();
            r103.setDuration(this.f206326a);
            r103.playTogether(new Animator[]{r101, r102});
            r103.start();
            return;
        L5:
            if (r100 < this.f206329d.getAdapter().getCount()) goto L7;
            r100 = 0;
            goto L7
        }

        public e(AtBottomBar r100, View r101) {
            this.f206332g = r100;
            this.f206331f = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.at_viewpager_max_height);
            ViewPager r102 = (ViewPager) r101.findViewById(R.id.vp_at);
            this.f206329d = r102;
            MagicIndicator r103 = (MagicIndicator) r101.findViewById(R.id.magic_indicator);
            this.f206330e = (LinearLayout) r101.findViewById(R.id.ll_at_bar);
            View r104 = r101.findViewById(R.id.at_back);
            l.c((ImageView) r101.findViewById(R.id.at_back_icon), R.color.icon_n1);
            r104.setOnClickListener(new g(this));
            r102.setOffscreenPageLimit(2);
            r102.setAdapter(new AtCardAdapter(r100.f206292c));
            wuc.a r105 = new wuc.a(r100.f206290a);
            r105.setAdapter(r100.f206305p);
            r103.setNavigator(r105);
            r102.addOnPageChangeListener(new tuc.c(r103));
            this.f206327b = n.w(r100.f206290a);
            this.f206328c = r100.f206290a.getResources().getDimensionPixelSize(R.dimen.at_viewpager_max_height);
            this.f206326a = r100.f206290a.getResources().getInteger(R.integer.at_finder_anim_duration);
        }
    }

    public interface f {
        void a();

        View b();

        View getTitle();

        ViewPager getViewPager();

        void hide(boolean r100);

        void show(int r100);
    }

    @Override // com.bytedance.ee.bear.widget.w
    public final void onCancel() {
        a(false);
    }

    private int getMentionPanelIndex() {
        if (TextUtils.isEmpty(this.f206301l) == false) goto L5;
        return 0;
    L5:
        int r100 = 0;
    L7:
        if (r100 >= this.f206299j.size()) goto L14;
        MentionPanelType r101 = ((m) ListProtector.get(this.f206299j, r100)).f510026d;
        if (r101 == null) goto L13;
        if (r101.name().equals(this.f206301l) == false) goto L13;
        return r100;
    L13:
        r100 = r100 + 1;
        goto L7
    L14:
        return 0;
    }

    public final void c() {
        tt5.a.h("AtBottomBar", "showAtFinder");
        if (this.f206293d == null) goto L17;
        this.f206298i.d(this.f206296g);
        this.f206298i.b();
        Iterator r100 = ((ArrayList) this.f206293d.f510014a).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        ((com.bytedance.ee.bear.atfinder.c) r100.next()).c(false);
        goto L6
    L8:
        int r101 = getMentionPanelIndex();
        if (this.f206294e == true) goto L14;
        v r102 = this.f206297h;
        if (r102 == null) goto L13;
        r102.c(this);
    L13:
        this.f206291b.show(r101);
        return;
    L14:
        tt5.a.k("AtBottomBar", "show atBottomBar fail: isAnimStart = true");
        return;
    }

    public AtBottomBar(Context r100) {
        super(r100);
        this.f206292c = new ArrayList();
        this.f206296g = true;
        this.f206298i = new com.bytedance.ee.bear.utils.g();
        this.f206304o = 0;
        this.f206305p = new a(this);
        this.f206290a = r100;
    }

    public final void a(boolean r100) {
        tt5.a.h("AtBottomBar", "closeAtFinder: immediately = " + r100);
        k r101 = this.f206293d;
        if (r101 == null) goto L8;
        this.f206295f = r100;
        Iterator r102 = ((ArrayList) r101.f510014a).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((com.bytedance.ee.bear.atfinder.c) r102.next()).a();
        goto L6
    L10:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        tt5.a.h("AtBottomBar", "onConfigurationChanged");
        f r101 = this.f206291b;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    public void setAtCommonConfig(bo4.c r100) {
        if (r100 == null) goto L8;
        this.f206300k = r100;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mention.optimizing_authorizaiton") == false) goto L9;
        this.f206300k.f19838c = true;
        return;
    L9:
        return;
    L8:
        throw new IllegalArgumentException("atCommonConfig not be null!!!");
    }

    public void setCardsData(List<m> r100) {
        this.f206299j = r100;
    }

    public void setDelegate(com.bytedance.ee.bear.atbottombar.b.a r100) {
        this.f206302m = r100;
    }

    public void setSelectDataCallback(com.bytedance.ee.bear.atfinder.d r100) {
        k r101 = this.f206293d;
        if (r101 == null) goto L10;
        c r102 = new c(this, r100);
        Iterator r103 = ((ArrayList) r101.f510014a).iterator();
    L6:
        if (r103.hasNext() == false) goto L16;
        com.bytedance.ee.bear.atfinder.c r104 = (com.bytedance.ee.bear.atfinder.c) r103.next();
        k.a r105 = new k.a(r101, r102);
        if (r104 == null) goto L6;
        r105.f510019c = r104;
        r104.f206351d = r105;
        goto L6
    L16:
        return;
    }

    public void setTitleBarLocationY(int r100) {
        if (n.D(n.g(this.f206290a)) == true) goto L7;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mention.optimizing_authorizaiton") == true) goto L7;
        return;
    L7:
        if (r100 == this.f206304o) goto L13;
        this.f206304o = r100;
        if (this.f206294e == false) goto L14;
        this.f206291b.a();
        return;
    L14:
        return;
    }

    public void setTouchMonitor(v r100) {
        this.f206297h = r100;
    }

    @Override // sa5.w
    public final boolean u70(MotionEvent r100) {
        k r101 = this.f206293d;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (n.B(((com.bytedance.ee.bear.atbottombar.b) ListProtector.get(r101.f510016c, r101.f510015b)).f206337b, r100) == false) goto L8;
    L13:
        return false;
    L8:
        if (n.B(this.f206291b.b(), r100) == true) goto L13;
        if (n.B(this.f206291b.getTitle(), r100) == true) goto L13;
        a(false);
        return true;
    }

    public AtBottomBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f206292c = new ArrayList();
        this.f206296g = true;
        this.f206298i = new com.bytedance.ee.bear.utils.g();
        this.f206304o = 0;
        this.f206305p = new a(this);
        this.f206290a = r100;
    }

    public AtBottomBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f206292c = new ArrayList();
        this.f206296g = true;
        this.f206298i = new com.bytedance.ee.bear.utils.g();
        this.f206304o = 0;
        this.f206305p = new a(this);
        this.f206290a = r100;
    }

    public final void b(AtPanelFragment r100, bo4.d r101, String r102) {
        this.f206301l = r102;
        this.f206296g = TextUtils.equals(r101.f19844f, NewBroadcastMonitor.STAGE.TOOLBAR);
        AtCheckBoxViewModel r103 = (AtCheckBoxViewModel) ViewModelProviders.of(r100).get(AtCheckBoxViewModel.class);
        this.f206303n = r103;
        r103.getUserPanelCheckBoxData().observe(r100, new ln4.a(this));
        k r104 = this.f206293d;
        if (r104 != null) goto L5;
        this.f206293d = new k(this.f206292c, r100, r101);
        this.f206298i.f(r101);
        return;
    L5:
        int r105 = 0;
    L7:
        if (r105 >= ((ArrayList) r104.f510014a).size()) goto L17;
        ((com.bytedance.ee.bear.atfinder.c) ListProtector.get(r104.f510014a, r105)).d(r101);
        AtFinderView r106 = ((com.bytedance.ee.bear.atbottombar.b) ListProtector.get(r104.f510016c, r105)).f206337b;
        r106.getClass();
        int r107 = r101.f19840b;
        AtMentionListAdapter r108 = r106.f239861d;
        if (r107 != 6) goto L11;
        boolean r109 = true;
    L12:
        r108.f206344a = r109;
        r105 = r105 + 1;
        goto L7
    L11:
        r109 = false;
        goto L12
    }
}
