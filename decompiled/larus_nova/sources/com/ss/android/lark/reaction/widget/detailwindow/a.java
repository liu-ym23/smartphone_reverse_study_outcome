package com.ss.android.lark.reaction.widget.detailwindow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.reaction.loader.ReactionLoaderManager;
import com.ss.android.lark.reaction.widget.detailwindow.scroller.ScrollableLayout;
import java.util.List;
import n2c.m;
import n2c.n;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements n2c.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Double f439203v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScrollableLayout f439204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f439205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f439206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f439207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f439208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f439209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MagicIndicator f439210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewPager f439211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f439212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f439213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f439214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f439215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f439216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Fragment f439217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<o2c.a> f439218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f439219p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f439220q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f439221r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final C5267a f439222s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f439223t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f439224u;

    /* JADX INFO: renamed from: com.ss.android.lark.reaction.widget.detailwindow.a$a, reason: collision with other inner class name */
    public class C5267a extends xuc.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f439225b;

        @Override // xuc.a
        public final xuc.c b(Context r100) {
            return null;
        }

        @Override // xuc.a
        public final int a() {
            return this.f439225b.f439218o.size();
        }

        public C5267a(a r100) {
            this.f439225b = r100;
        }

        @Override // xuc.a
        public final xuc.d c(Context r100, final int r110) {
            avc.b r101 = new avc.b(this.f439225b.f439216m);
            r101.setContentView(R.layout.layout_reaction_detail_pager_title);
            final a r102 = this.f439225b;
            r102.getClass();
            ImageView r103 = (ImageView) r101.findViewById(R.id.reaction_icon);
            TextView r104 = (TextView) r101.findViewById(R.id.reaction_count);
            ViewGroup r105 = (ViewGroup) r101.findViewById(R.id.reaction_title_wrapper);
            ReactionLoaderManager.b.f439153a.c(r103, ((o2c.a) ListProtector.get(r102.f439218o, r110)).f521823b);
            String r106 = ((o2c.a) ListProtector.get(r102.f439218o, r110)).f521823b;
            int r107 = v2c.a.a(r102.f439216m, 20);
            int r108 = k2c.b.b(r106);
            int r109 = k2c.b.a(r106);
            if (r108 <= 44) goto L6;
            if (r109 == 0) goto L6;
            r107 = (r107 * r108) / r109;
        L6:
            r103.getLayoutParams().width = r107;
            r104.setText(String.valueOf(((o2c.a) ListProtector.get(r102.f439218o, r110)).f521824c));
            r101.setOnPagerTitleChangeListener(new e(r102, r105));
            View r111 = r101.getChildAt(0);
            if (r110 != 0) goto L10;
            r111.setPadding(v2c.a.a(r102.f439216m, 16.0f), 0, 0, 0);
        L12:
            r105.setOnClickListener(new n2c.g(r102, r110));
            return r101;
        L10:
            if (r110 != (r102.f439218o.size() - 1)) goto L12;
            r111.setPadding(0, 0, v2c.a.a(r102.f439216m, 4.0f), 0);
            goto L12
        }
    }

    public class b implements ReactionPopupFacade.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f439226a;

        public b(a r100) {
            this.f439226a = r100;
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade.c
        public final void a(String r100) {
            g r101 = this.f439226a.f439215l;
            if (r101 == null) goto L6;
            ((ReactionPopupFacade.a) r101).b(r100);
            return;
        }
    }

    public class c implements ReactionPopupFacade.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f439227a;

        public c(a r100) {
            this.f439227a = r100;
        }
    }

    public interface d {
        void a(int r100);
    }

    public class e implements avc.b.InterfaceC0238b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f439228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f439229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f439230c;

        @Override // avc.b.InterfaceC0238b
        public final void onEnter() {
        }

        @Override // avc.b.InterfaceC0238b
        public final void onLeave() {
        }

        @Override // avc.b.InterfaceC0238b
        public final void b() {
            this.f439228a.setBackgroundResource(R.drawable.reaction_pager_title_color_unselected);
            this.f439229b.setTextColor(v2c.a.b(this.f439230c.f439216m, R.color.text_caption));
        }

        @Override // avc.b.InterfaceC0238b
        public final void a(int r100) {
            this.f439228a.setBackgroundResource(R.drawable.reaction_pager_title_color_selected);
            this.f439229b.setTextColor(v2c.a.b(this.f439230c.f439216m, R.color.static_white));
            this.f439230c.f439211h.setCurrentItem(r100);
        }

        public e(a r100, ViewGroup r101) {
            this.f439230c = r100;
            this.f439228a = r101;
            this.f439229b = (TextView) r101.findViewById(R.id.reaction_count);
        }
    }

    public static class f extends com.ss.android.lark.reaction.widget.detailwindow.scroller.e {
        public f() {
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.e, com.ss.android.lark.reaction.widget.detailwindow.scroller.b
        public final int b(int r100, int r101) {
            int r102 = r101 / 4;
            if (r100 <= (r101 - r102)) goto L5;
            return r101;
        L5:
            if (r100 >= r102) goto L9;
            return 0;
        L9:
            return Double.valueOf(((double) r101) * a.f439203v.doubleValue()).intValue();
        }

        @Override // com.ss.android.lark.reaction.widget.detailwindow.scroller.e, com.ss.android.lark.reaction.widget.detailwindow.scroller.b
        public final int a(boolean r100, int r101, int r102) {
            int r103 = Double.valueOf(((double) r102) * a.f439203v.doubleValue()).intValue();
            if (r100 == false) goto L7;
            if (r101 >= r103) goto L8;
            return 0;
        L8:
            return r103;
        L7:
            return r102;
        }
    }

    public interface g {
    }

    public final void a() {
        FragmentActivity r100 = this.f439217n.getActivity();
        if (r100 != null) goto L5;
    L13:
        b(this.f439204a.getScrollY(), 0, new m(this));
        return;
    L5:
        if (com.ss.android.lark.base.embedded.b.b(r100) == false) goto L13;
        ((ReactionPopupFacade.a) this.f439215l).f439202a.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L17;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    static {
        f439203v = Double.valueOf(0.67d);
    }

    public a(ReactionPopupFacade.a r100, Context r101, Fragment r102) {
        this.f439222s = new C5267a(this);
        this.f439223t = new b(this);
        this.f439224u = new c(this);
        this.f439215l = r100;
        this.f439216m = r101;
        this.f439217n = r102;
    }

    public static void b(int r100, int r101, final d r102) {
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{r100, r101});
        r103.setInterpolator(new DecelerateInterpolator());
        r103.addUpdateListener(new n(r102));
        r103.start();
    }
}
